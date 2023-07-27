package org.apache.pulsar.integration.jmscts;

import org.apache.pulsar.client.admin.PulsarAdminException;
import org.apache.pulsar.client.api.PulsarClientException;
import org.exolab.jmscts.provider.Administrator;
import org.exolab.jmscts.provider.Provider;

import javax.jms.JMSException;

public class PulsarJmsProvider implements Provider {

    private PulsarJMSAdmin pulsarJmsAdministrator;

    @Override
    public void initialise(boolean b) throws JMSException {
        try {
            ((PulsarJMSAdmin) getAdministrator()).initialize();
        } catch (final Exception pcEx) {
            JMSException jmsException = new JMSException(pcEx.getLocalizedMessage());
            jmsException.setLinkedException(pcEx);
            throw jmsException;
        }
    }

    @Override
    public Administrator getAdministrator() throws JMSException {
        if (pulsarJmsAdministrator == null) {
            pulsarJmsAdministrator = new PulsarJMSAdmin();
        }
        return pulsarJmsAdministrator;
    }

    @Override
    public void cleanup(boolean b) throws JMSException {
        if (pulsarJmsAdministrator != null) {
            try {
                pulsarJmsAdministrator.close();
            } catch (final Exception paEx) {
                JMSException jmsException = new JMSException(paEx.getLocalizedMessage());
                jmsException.setLinkedException(paEx);
                throw jmsException;
            }
        }
    }
}
