package org.apache.pulsar.integration.jmscts;

import org.apache.pulsar.client.admin.PulsarAdmin;
import org.apache.pulsar.client.admin.PulsarAdminException;
import org.apache.pulsar.client.api.PulsarClientException;
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

    private PulsarAdmin pulsarAdmin;

    // This is necessary because every call to lookup creates a new queue or topic.
    private List<String> destroyedDestinations = new ArrayList<String>();

    public void initialize() {
        try {
            pulsarAdmin = PulsarAdmin.builder()
                    .serviceHttpUrl("http://192.168.1.120:8080")
                    .build();

            getJndiContext().lookup(CONNECTION_FACTORY_NAME);
        } catch (NamingException | PulsarClientException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() throws JMSException {
        try {
            if (jndiContext != null) {
                jndiContext.close();
            }

            pulsarAdmin.topics().getList(TENANT_NS)
                    .parallelStream()
                    .filter(name -> name.contains("jms-temp-queue"))
                    .forEach(topic -> {
                        try {
                            pulsarAdmin.topics().terminateTopic(topic);
                            pulsarAdmin.topics().getSubscriptions(topic).forEach(sub -> {
                                try {
                                    pulsarAdmin.topics().deleteSubscription(topic, sub, true);
                                } catch (PulsarAdminException e) {
                                    // throw new RuntimeException(e);
                                }
                            });
                            pulsarAdmin.topics().delete(topic);
                        } catch (PulsarAdminException e) {
                            // throw new RuntimeException(e);
                        }
                    });

            pulsarAdmin.close();
        } catch (final PulsarAdminException | NamingException ex) {
            wrapAndThrow(ex);
        }
    }

    private void wrapAndThrow(Exception ex) throws JMSException {
        JMSException jmsException = new JMSException(ex.getLocalizedMessage());
        jmsException.setLinkedException(ex);
        throw jmsException;
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
    public Object lookup(String name) throws NamingException {
        if (name.contains("/") || name.equals(CONNECTION_FACTORY_NAME)) {
            return getJndiContext().lookup(name);
        } else {
            /* TOTAL Hack for now, to prevent these errors since the test doesn't prepend "queue/" or "topic/" for us
               javax.naming.InvalidNameException: Name SendReceiveStopTest67 is not valid
             */
            return getJndiContext().lookup("queues/" + name);
        }
    }

    @Override
    public void createDestination(String name, boolean isQueue) throws JMSException {
        try {
            if (isQueue) {
                Queue queue = (Queue) getJndiContext().lookup(String.format("queues/%s",name));
            } else {
                Topic topic = (Topic) getJndiContext().lookup(String.format("topics/%s",name));
            }
        } catch (final NamingException nEx) {
            wrapAndThrow(nEx);
        }
    }

    @Override
    public void destroyDestination(String name) throws JMSException {
        destroyedDestinations.add(name);
    }

    @Override
    public boolean destinationExists(String name) throws JMSException {
        return !destroyedDestinations.contains(name);
    }
}
