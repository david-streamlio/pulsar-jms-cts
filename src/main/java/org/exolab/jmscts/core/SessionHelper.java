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
 * $Id: SessionHelper.java,v 1.2 2004/01/31 13:44:24 tanderson Exp $
 */
package org.exolab.jmscts.core;

import javax.jms.*;


/**
 * Helper class for performing session operations
 *
 * @version     $Revision: 1.2 $ $Date: 2004/01/31 13:44:24 $
 * @author      <a href="mailto:tma@netspace.net.au">Tim Anderson</a>
 */
public final class SessionHelper {

    /**
     * Seed used to uniquely identify subscribers
     */
    private static int _subscriberSeed = 0;


    /**
     * Prevent construction of utility class
     */
    private SessionHelper() {
    }

    /**
     * Create a message consumer for the supplied session and destination.
     * The name argument only applies to topic destinations.
     * @param sessionType
     *
     * @param session the session
     * @param destination the destination to consume messages from
     * @param name if non-null, and the session is a TopicSession, then a
     * durable subscriber will be returned, otherwise the argument is ignored.
     * @return a new consumer
     * @throws JMSException if any of the JMS operations fail
     */
    private final static MessageConsumer createConsumer(
        Class<?> sessionType, Session session, Destination destination, String name)
        throws JMSException {

        MessageConsumer result = null;
        if (sessionType == XAQueueSession.class) {
            session = ((XAQueueSession) session).getQueueSession();
        } else if (sessionType == XATopicSession.class) {
            session = ((XATopicSession) session).getTopicSession();
        }

        if (isQueueType(sessionType)) {
            Queue queue = (Queue) destination;
            result = ((QueueSession) session).createReceiver(queue);
        } else {
            Topic topic = (Topic) destination;
            if (name != null) {
                result = ((TopicSession) session).createDurableSubscriber(
                    topic, name);
            } else {
                result = ((TopicSession) session).createSubscriber(topic);
            }
        }
        return result;
    }

    /**
     * Create a message consumer for the supplied session and destination and
     * selector.
     * The name argument only applies to topic destinations.
     * @param sessionType
     *
     * @param session the session
     * @param destination the destination to consume messages from
     * @param name if non-null, and the session is a TopicSession, then a
     * durable subscriber will be returned, otherwise the argument is ignored.
     * @param selector the message selector
     * @param noLocal if the session is a TopicSession, then the subscriber
     * will be created with the supplied noLocal flag, otherwise the argument
     * is ignored.
     * @return a new consumer
     * @throws JMSException if any of the JMS operations fail
     */
    private final static MessageConsumer createConsumer(
        Class<?> sessionType, Session session, Destination destination, String name,
        String selector, boolean noLocal) throws JMSException {

        MessageConsumer result = null;
        if (sessionType == XAQueueSession.class) {
            session = ((XAQueueSession) session).getQueueSession();
        } else if (sessionType == XATopicSession.class) {
            session = ((XATopicSession) session).getTopicSession();
        }

        if (isQueueType(sessionType)) {
            Queue queue = (Queue) destination;
            result = ((QueueSession) session).createReceiver(queue, selector);
        } else {
            Topic topic = (Topic) destination;
            if (name != null) {
                result = ((TopicSession) session).createDurableSubscriber(
                    topic, name, selector, noLocal);
            } else {
                result = ((TopicSession) session).createSubscriber(
                    topic, selector, noLocal);
            }
        }
        return result;
    }

    /**
     * Create a message producer for the supplied test session and destination
     *
     * @param session the test session
     * @param destination the destination to send messages to
     * @return a new producer
     * @throws JMSException if any of the JMS operations fail
     */
    private final static MessageProducer createProducer(Class<?> sessionType, Session session,
                                                        Destination destination)
        throws JMSException {
        MessageProducer result = null;
        if (sessionType == XAQueueSession.class) {
            session = ((XAQueueSession) session).getQueueSession();
        } else if (sessionType == XATopicSession.class) {
            session = ((XATopicSession) session).getTopicSession();
        }

        if (isQueueType(sessionType)) {
            Queue queue = (Queue) destination;
            result = ((QueueSession) session).createSender(queue);
        } else {
            Topic topic = (Topic) destination;
            result = ((TopicSession) session).createPublisher(topic);
        }
        return result;
    }

    /**
     * Create a message consumer for the supplied test context and destination
     *
     * @param context the test context
     * @param destination the destination to consume messages from
     * @param name if non-null, and the session is a TopicSession, then a
     * durable subscriber will be returned, otherwise the argument is ignored.
     * @return a new consumer
     * @throws JMSException if any of the JMS operations fail
     */
    public static MessageConsumer createConsumer(TestContext context,
                                                 Destination destination,
                                                 String name)
        throws JMSException {

        return createConsumer(context.getSessionType(), context.getSession(), destination, name);
    }

    /**
     * Create a message producer for the supplied test context and destination
     *
     * @param context the test context
     * @param destination the destination to send messages to
     * @return a new producer
     * @throws JMSException if any of the JMS operations fail
     */
    public static MessageProducer createProducer(TestContext context,
                                                 Destination destination)
        throws JMSException {

        return createProducer(context.getSessionType(), context.getSession(), destination);
    }

    /**
     * Create a {@link MessageReceiver} for the supplied session, destination,
     * and messaging behaviour
     *
     * @param session the session
     * @param destination the destination to consume messages from
     * @param behaviour the messaging behaviour
     * @return a new message receiver
     * @throws JMSException if any of the JMS operations fail
     */
    private final static MessageReceiver createReceiver(Class<?> sessionType, Session session,
                                                        Destination destination,
                                                        MessagingBehaviour behaviour)
        throws JMSException {

        MessageReceiver result = null;

        if (behaviour.getReceiptType().equals(ReceiptType.BROWSER)) {
            result = new MessageBrowser((QueueSession) session,
                                        (Queue) destination);
        } else {
            String name = null;
            if (behaviour.getDurable()) {
                name = getSubscriberName();
            }
            MessageConsumer consumer =
                createConsumer(sessionType, session, destination, name);
            if (behaviour.getReceiptType().equals(ReceiptType.SYNCHRONOUS)) {
                result = new SynchronousReceiver(session, consumer, name);
            } else {
                result = new AsynchronousReceiver(session, consumer, name);
            }
        }
        return result;
    }

    /**
     * Create a {@link MessageReceiver} for the supplied session, destination,
     * messaging behaviour, and selector
     *
     * @param session the session
     * @param destination the destination to consume messages from
     * @param behaviour the messaging behaviour
     * @param selector the message selector
     * @param noLocal if the session is a TopicSession, then the subscriber
     * will be created with the supplied noLocal flag, otherwise the argument
     * is ignored.
     * @return a new message receiver
     * @throws JMSException if any of the JMS operations fail
     */
    private final static MessageReceiver createReceiver(Class<?> sessionType, Session session,
                                                 Destination destination,
                                                 MessagingBehaviour behaviour,
                                                 String selector,
                                                 boolean noLocal)
        throws JMSException {
        return createReceiver(sessionType, session, destination, behaviour, null, selector,
                              noLocal);
    }

    /**
     * Create a {@link MessageReceiver} for the supplied session, destination,
     * messaging behaviour, and selector
     *
     * @param session the session
     * @param destination the destination to consume messages from
     * @param behaviour the messaging behaviour
     * @param name if non-null, and the session is a TopicSession, then a
     * durable subscriber will be returned, otherwise the argument is ignored.
     * If null, and the session is a TopicSession and the behaviour is for
     * durable subscribers, then a name will be automatically allocated.
     * @param selector the message selector
     * @param noLocal if the session is a TopicSession, then the subscriber
     * will be created with the supplied noLocal flag, otherwise the argument
     * is ignored.
     * @return a new message receiver
     * @throws JMSException if any of the JMS operations fail
     */
    private final static MessageReceiver createReceiver(Class<?> sessionType, Session session,
                                                 Destination destination,
                                                 MessagingBehaviour behaviour,
                                                 String name,
                                                 String selector,
                                                 boolean noLocal)
        throws JMSException {

        MessageReceiver result = null;

        if (behaviour.getReceiptType().equals(ReceiptType.BROWSER)) {
            result = new MessageBrowser((QueueSession) session,
                                        (Queue) destination, selector);
        } else {
            if (behaviour.getDurable() && name == null) {
                name = getSubscriberName();
            }
            MessageConsumer consumer = createConsumer(sessionType, session, destination,
                                                      name, selector, noLocal);
            if (behaviour.getReceiptType().equals(ReceiptType.SYNCHRONOUS)) {
                result = new SynchronousReceiver(session, consumer, name);
            } else {
                result = new AsynchronousReceiver(session, consumer, name);
            }
        }
        return result;
    }

    private static final boolean isQueueType(Class<?> sessionType) {
        return (sessionType == XAQueueSession.class || sessionType == QueueSession.class);
    }

    /**
     * Create a {@link MessageReceiver} for the supplied test context and
     * destination
     *
     * @param context the test context
     * @param destination the destination to consume messages from
     * @return a new message receiver
     * @throws JMSException if any of the JMS operations fail
     */
    public static MessageReceiver createReceiver(TestContext context,
                                                 Destination destination)
        throws JMSException {

        return createReceiver(context.getSessionType(), context.getSession(), destination,
                              context.getMessagingBehaviour());
    }

    /**
     * Create a {@link MessageReceiver} for the supplied test context,
     * destination, selector, and noLocal flag
     *
     * @param context the test context
     * @param destination the destination to consume messages from
     * @param selector the message selector
     * @param noLocal if the session is a TopicSession, then the subscriber
     * will be created with the supplied noLocal flag, otherwise the argument
     * is ignored.
     * @return a new message receiver
     * @throws JMSException if any of the JMS operations fail
     */
    public static MessageReceiver createReceiver(TestContext context,
                                                 Destination destination,
                                                 String selector,
                                                 boolean noLocal)
        throws JMSException {

        return createReceiver(context.getSessionType(), context.getSession(), destination,
                              context.getMessagingBehaviour(), selector,
                              noLocal);
    }

    /**
     * Create a {@link MessageReceiver} for the supplied test context,
     * destination, name, selector, and noLocal flag
     *
     * @param context the test context
     * @param destination the destination to consume messages from
     * @param name if non-null, and the session is a TopicSession, then a
     * durable subscriber will be returned, otherwise the argument is ignored.
     * If null, and the session is a TopicSession and the behaviour is for
     * durable subscribers, then a name will be automatically allocated.
     * @param selector the message selector
     * @param noLocal if the session is a TopicSession, then the subscriber
     * will be created with the supplied noLocal flag, otherwise the argument
     * is ignored.
     * @return a new message receiver
     * @throws JMSException if any of the JMS operations fail
     */
    public static MessageReceiver createReceiver(TestContext context,
                                                 Destination destination,
                                                 String name,
                                                 String selector,
                                                 boolean noLocal)
        throws JMSException {
        return createReceiver(context.getSessionType(), context.getSession(), destination,
                              context.getMessagingBehaviour(), name, selector,
                              noLocal);
    }

    /**
     * Create a {@link MessageSender} for the supplied session, destination
     * and behaviour
     *
     * @param session the sesssion
     * @param destination the destination to send messages to
     * @param behaviour the messaging behaviour
     * @return a new message sender
     * @throws JMSException if any of the JMS operations fail
     */
    private final static MessageSender createSender(Class<?> sessionType, Session session,
                                             Destination destination,
                                             MessagingBehaviour behaviour)
        throws JMSException {

        MessageSender result = null;
        MessageProducer producer = createProducer(sessionType, session, destination);
        if (sessionType == XAQueueSession.class) {
            session = ((XAQueueSession) session).getQueueSession();
        } else if (sessionType == XATopicSession.class) {
            session = ((XATopicSession) session).getTopicSession();
        }

        if (isQueueType(sessionType)) {
            result = new QueueMessageSender((QueueSender) producer, behaviour);
        } else {
            result = new TopicMessageSender((TopicPublisher) producer,
                                            behaviour);
        }
        return result;
    }

    /**
     * Create a {@link MessageSender} for the supplied test context
     *
     * @param context the test context
     * @param destination the destination to send messages to
     * @return a new message sender
     * @throws JMSException if any of the JMS operations fail
     */
    public static MessageSender createSender(TestContext context,
                                             Destination destination)
        throws JMSException {

        return createSender(context.getSessionType(), context.getSession(), destination,
                            context.getMessagingBehaviour());
    }

    /**
     * Return a unique name for a durable subscriber
     *
     * @return a unique name
     */
    public static synchronized String getSubscriberName() {
        return "subscriber" + ++_subscriberSeed;
    }

}
