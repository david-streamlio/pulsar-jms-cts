/**
 * Redistribution and use of this software and associated documentation
 * ("Software"), with or without modification, are permitted provided
 * that the following conditions are met:
 *
 * 1. Redistributions of source code must retain copyright
 *    statements and notices.  Redistributions must also contain a
 *    copy of this document.
 *
 * 2. Redistributions in binary form must reproduce the
 *    above copyright notice, this list of conditions and the
 *    following disclaimer in the documentation and/or other
 *    materials provided with the distribution.
 *
 * 3. The name "Exolab" must not be used to endorse or promote
 *    products derived from this Software without prior written
 *    permission of Exoffice Technologies.  For written permission,
 *    please contact tma@netspace.net.au.
 *
 * 4. Products derived from this Software may not be called "Exolab"
 *    nor may "Exolab" appear in their names without prior written
 *    permission of Exoffice Technologies. Exolab is a registered
 *    trademark of Exoffice Technologies.
 *
 * 5. Due credit should be given to the Exolab Project
 *    (https://castor.exolab.org).
 *
 * THIS SOFTWARE IS PROVIDED BY EXOFFICE TECHNOLOGIES AND CONTRIBUTORS
 * ``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL
 * EXOFFICE TECHNOLOGIES OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * Copyright 2001-2004 (C) Exoffice Technologies Inc. All Rights Reserved.
 *
 * $Id: AbstractMessageReceiver.java,v 1.4 2004/01/31 13:44:24 tanderson Exp $
 */
package org.exolab.jmscts.core;

import com.datastax.oss.pulsar.jms.PulsarMessageConsumer;

import javax.jms.*;


/**
 * Helper that implements behaviour common to both AsynchronousReceiver and
 * SynchronousReceiver
 *
 * @version     $Revision: 1.4 $ $Date: 2004/01/31 13:44:24 $
 * @author      <a href="mailto:tma@netspace.net.au">Tim Anderson</a>
 * @see         MessageReceiver
 * @see         AsynchronousReceiver
 * @see         SynchronousReceiver
 * @see         MessageBrowser
 */
abstract class AbstractMessageReceiver implements MessageReceiver {

    /**
     * The session that owns the consumer
     */
    private Session _session = null;

    /**
     * The consumer used to receive messages
     */
    private MessageConsumer _consumer = null;

    /**
     * The name of the subscriber, if the consumer is a durable topic
     * subscriber
     */
    private String _name = null;

    /**
     * Construct an instance with the consumer to receive messages with
     *
     * @param session the session that created the consumer
     * @param consumer the consumer used to receive messages
     * @param name the name of the subscriber, for durable topic subscribers.
     * May be null.
     */
    public AbstractMessageReceiver(Session session, MessageConsumer consumer,
                                   String name) {
        if (session == null) {
            throw new IllegalArgumentException("Argument session is null");
        }
        if (consumer == null) {
            throw new IllegalArgumentException("Argument consumer is null");
        }
        _session = session;
        _consumer = consumer;
        _name = name;
    }

    /**
     * Return the destination associated with the MessageConsumer
     *
     * @return the destination to receive messages from
     * @throws JMSException if the operation fails
     */
    @Override
    public Destination getDestination() throws JMSException {
        Destination result = null;
        try {
            result = ((QueueReceiver) _consumer).getQueue();
        } catch (final JMSException ex) {
            /* Given the class definition of the PulsarMessageConsumer, an exception
             * getting thrown is entirely possible, so we will try again as a Topic
             * if THAT fails, then we truly have an exception.
             */
            result = ((TopicSubscriber) _consumer).getTopic();
        }
        return result;
    }

    /**
     * Returns the message selector associated with the MessageConsumer
     *
     * @return the message selector
     * @throws JMSException if the operation fails
     */
    @Override
    public String getSelector() throws JMSException {
        return _consumer.getMessageSelector();
    }

    /**
     * Returns the name of the subscriber, if the consumer is a durable topic
     * subscriber
     *
     * @return the name of the subscriber, or <code>null</code> if the
     * consumer is not a durable topic subscriber
     */
    @Override
    public String getName() {
        return _name;
    }

    /**
     * Returns the no-local value, if the consumer is a topic subscriber
     *
     * @return the no-local value, if the consumer is a topic subscriber;
     * otherwise <code>false</code>
     * @throws JMSException if the operation fails
     */
    @Override
    public boolean getNoLocal() throws JMSException {
        boolean result = false;
        if (_consumer instanceof TopicSubscriber) {
            result = ((TopicSubscriber) _consumer).getNoLocal();
        }
        return result;
    }

    /**
     * Close the underlying MessageConsumer
     *
     * @throws JMSException if the operation fails
     */
    @Override
    public void close() throws JMSException {
        if (_consumer != null) {
            _consumer.close();
            _consumer = null;
        }
    }

    /**
     * Close the underlying MessageConsumer and if necessary, unsubscribe it
     * from the session.
     *
     * @throws JMSException if the operation fails
     */
    @Override
    public void remove() throws JMSException {
        close();

//        if (_name != null && _session instanceof TopicSession) {
//            ((TopicSession) _session).unsubscribe(_name);
//        } else if (_name != null && _session instanceof QueueSession) {
//            ((QueueSession) _session).unsubscribe(_name);
//        }

    }

    /**
     * Returns the underlying message consumer
     *
     * @return the underlying message consumer
     */
    protected MessageConsumer getConsumer() {
        return _consumer;
    }

}
