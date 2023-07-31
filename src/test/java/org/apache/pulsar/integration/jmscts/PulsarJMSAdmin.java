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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class PulsarJMSAdmin implements Administrator {

    private static final String CONNECTION_FACTORY_NAME = "ConnectionFactory";
    public static final String CONFIG_FILE ="pulsar.configFile";
    private Properties pulsarProperties;
    private Context jndiContext;
    private PulsarConnectionFactory factory;
    private Map<String, Boolean> queues = new HashMap<>(1024);
    private Map<String, Boolean> topics = new HashMap<>(1024);

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

    private Properties getProperties() {
        if (pulsarProperties == null) {
            try (InputStream input = new FileInputStream(System.getProperty(CONFIG_FILE))) {
                pulsarProperties = new Properties();
                pulsarProperties.load(input);
            } catch (IOException e) {
                throw new RuntimeException("Missing configuration data");
            }
        }
        return pulsarProperties;
    }

    private PulsarConnectionFactory getFactory() {
        if (factory == null) {
            try {
                factory = (PulsarConnectionFactory) getJndiContext()
                        .lookup(CONNECTION_FACTORY_NAME);
            } catch (NamingException e) {
                // Ignore
            }
        }
        return factory;
    }

    private boolean isQueue(String name) {
        return queues.containsKey(name);
    }

    private boolean isTopic(String name) {
        return topics.containsKey(name);
    }

    private Context getJndiContext() throws NamingException {
        if (jndiContext == null) {
            jndiContext = new InitialContext(getProperties());
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
                queues.put(name, true);
            } else {
                Topic topic = (Topic) getJndiContext().lookup(String.format("topics/%s",name));
                topics.put(name, true);
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

                if (getFactory().getPulsarAdmin().topics().getPartitionedTopicList(getProperties()
                        .getProperty("jms.systemNamespace", "public/default"))
                        .stream().anyMatch(t -> t.equalsIgnoreCase(fullQualifiedTopicName))) {
                    getFactory().getPulsarAdmin().topics().deletePartitionedTopic(fullQualifiedTopicName, forceDelete);
                } else if (getFactory().getPulsarAdmin().topics().getList(getProperties()
                                .getProperty("jms.systemNamespace", "public/default"))
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
            if (getFactory().getPulsarAdmin().topics().getPartitionedTopicList(getProperties()
                            .getProperty("jms.systemNamespace", "public/default"))
                    .stream().anyMatch(t -> t.equalsIgnoreCase(fullQualifiedTopicName))) {
                return true;
            } else if (getFactory().getPulsarAdmin().topics().getList(getProperties()
                            .getProperty("jms.systemNamespace", "public/default"))
                    .stream().anyMatch(t -> t.equalsIgnoreCase(fullQualifiedTopicName))) {
                return true;
            }
        } catch (final PulsarAdminException paEx) {
            // Ignore these.
        }
        return false;
    }
}
