package org.apache.pulsar.integration.jmscts;

import com.datastax.oss.pulsar.jms.PulsarConnectionFactory;
import com.datastax.oss.pulsar.jms.PulsarQueue;
import org.apache.pulsar.client.admin.PulsarAdminException;
import org.exolab.jmscts.provider.Administrator;

import javax.jms.*;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.*;

public class PulsarJMSAdmin implements Administrator {

    private static final String TENANT = "public";
    private static final String NAMESPACE = "default";
    private static final String TENANT_NS = String.format("%s/%s", TENANT, NAMESPACE);
    private static final String CONNECTION_FACTORY_NAME = "ConnectionFactory";
    private Context jndiContext;
    private PulsarConnectionFactory factory;
    private List<String> queues = new ArrayList<>();
    private List<String> topics = new ArrayList<>();

    public void close() throws JMSException {
        try {
            if (jndiContext != null) {
                jndiContext.close();
            }
        } catch (final NamingException ex) {
            wrapAndThrow(ex);
        }
    }

    private void wrapAndThrow(Exception ex) throws JMSException {
        JMSException jmsException = new JMSException(ex.getLocalizedMessage());
        jmsException.setLinkedException(ex);
        throw jmsException;
    }

    private PulsarConnectionFactory getFactory() {
        if (factory == null) {
            try {
                factory =  (PulsarConnectionFactory) getJndiContext()
                        .lookup(CONNECTION_FACTORY_NAME);
            } catch (NamingException e) {
                // Ignore
            }
        }
        return factory;
    }

    private boolean isQueue(String name) {
        return queues.contains(name);
    }

    private boolean isTopic(String name) {
        return topics.contains(name);
    }

    private Context getJndiContext() throws NamingException {
        if (jndiContext == null) {
            Properties properties = new Properties();
            properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,
                    "com.datastax.oss.pulsar.jms.jndi.PulsarInitialContextFactory");
            properties.setProperty(Context.PROVIDER_URL, "pulsar://192.168.1.120:6650");
            properties.setProperty("webServiceUrl", "http://192.168.1.120:8080");
            properties.setProperty("autoCloseConnectionFactory", "true");
            properties.put("jms.emulateTransactions", true);
            properties.put("jms.forceDeleteTemporaryDestinations", true);
            properties.setProperty("jms.systemNamespace", TENANT_NS);
            jndiContext = new InitialContext(properties);
        }
        return jndiContext;
    }

    @Override
    public String getQueueConnectionFactory() {
        return CONNECTION_FACTORY_NAME;
    }

    @Override
    public String getTopicConnectionFactory() {
        return CONNECTION_FACTORY_NAME;
    }

    @Override
    public String getXAQueueConnectionFactory() {
        return CONNECTION_FACTORY_NAME;
    }

    @Override
    public String getXATopicConnectionFactory() {
        return CONNECTION_FACTORY_NAME;
    }

    @Override
    public Object lookup(String name) throws NamingException{
        if (name.contains("/") || name.equals(CONNECTION_FACTORY_NAME)) {
            return getJndiContext().lookup(name);
        } else if (isQueue(name)){
            return getJndiContext().lookup("queues/" + name);
        } else if (isTopic(name)) {
            return getJndiContext().lookup("topics/" + name);
        }
        return null;
    }

    @Override
    public void createDestination(String name, boolean isQueue) throws JMSException {
        try {
            if (isQueue) {
                Queue queue = (Queue) getJndiContext().lookup(String.format("queues/%s",name));
                queues.add(name);
            } else {
                Topic topic = (Topic) getJndiContext().lookup(String.format("topics/%s",name));
                topics.add(name);
            }
        } catch (final NamingException nEx) {
            wrapAndThrow(nEx);
        }
    }

    @Override
    public void destroyDestination(String name) throws JMSException {
        String topicName = null;
        try {
            if (isQueue(name)) {
                PulsarQueue queue = (PulsarQueue) getJndiContext().lookup(String.format("queues/%s", name));
                topicName = queue.getInternalTopicName();
                queues.remove(name);
            } else if (isTopic(name)) {
                Topic topic = (Topic) getJndiContext().lookup(String.format("topics/%s", name));
                topicName = topic.getTopicName();
                topics.remove(name);
            }

            if (topicName != null) {
                String fullQualifiedTopicName = getFactory().applySystemNamespace(topicName);
                boolean forceDelete = getFactory().isForceDeleteTemporaryDestinations();

                if (getFactory().getPulsarAdmin().topics().getPartitionedTopicList(TENANT_NS)
                        .stream().anyMatch(t -> t.equalsIgnoreCase(fullQualifiedTopicName))) {
                    getFactory().getPulsarAdmin().topics().deletePartitionedTopic(fullQualifiedTopicName, forceDelete);
                } else if (getFactory().getPulsarAdmin().topics().getList(TENANT_NS)
                        .stream().anyMatch(t -> t.equalsIgnoreCase(fullQualifiedTopicName)))  {
                    getFactory().getPulsarAdmin().topics().delete(fullQualifiedTopicName, forceDelete);
                }
            }

        } catch (final NamingException nEx) {
            // Ignore these.
        } catch (PulsarAdminException paEx) {
            paEx.printStackTrace();
            wrapAndThrow(paEx);
        }
    }

    @Override
    public boolean destinationExists(String name) throws JMSException {
        try {
            String fullQualifiedTopicName = getFactory().applySystemNamespace(name);
            if (getFactory().getPulsarAdmin().topics().getPartitionedTopicList(TENANT_NS)
                    .stream().anyMatch(t -> t.equalsIgnoreCase(fullQualifiedTopicName))) {
                return true;
            } else if (getFactory().getPulsarAdmin().topics().getList(TENANT_NS)
                    .stream().anyMatch(t -> t.equalsIgnoreCase(fullQualifiedTopicName))) {
                return true;
            }
        } catch (final PulsarAdminException paEx) {
            // Ignore these.
        }
        return false;
    }
}
