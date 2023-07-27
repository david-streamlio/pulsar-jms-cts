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
 * Copyright 2001, 2003 (C) Exoffice Technologies Inc. All Rights Reserved.
 *
 * $Id: MessageSender.java,v 1.6 2005/06/16 08:06:08 tanderson Exp $
 */
package org.exolab.jmscts.core;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;


/**
 * Interface for sending messages using a {@link javax.jms.MessageProducer}
 *
 * @version     $Revision: 1.6 $ $Date: 2005/06/16 08:06:08 $
 * @author      <a href="mailto:tma@netspace.net.au">Tim Anderson</a>
 */
public interface MessageSender {

    /**
     * Send messages to a destination
     *
     * @param message the message to send
     * @param count the number of times to send the message
     * @throws JMSException if any of the JMS operations fail
     */
    void send(Message message, int count) throws JMSException;

    /**
     * Send messages to a destination
     *
     * @param message the message to send
     * @param count the number of times to send the message
     * @param timeToLive the message time-to-live
     * @throws JMSException if any of the JMS operations fail
     */
    void send(Message message, int count, long timeToLive) throws JMSException;

    /**
     * Send messages to a destination, invoking a message populator prior
     * to each message being sent
     *
     * @param message the message to send
     * @param count the number of times to send the message
     * @param populator the message populator
     * @throws JMSException if any of the JMS operations fail
     */
    void send(Message message, int count, MessagePopulator populator)
        throws JMSException;

    /**
     * Send messages to a destination, invoking a message populator prior
     * to each message being sent
     *
     * @param message the message to send
     * @param count the number of times to send the message
     * @param populator the message populator
     * @param timeToLive the message time-to-live
     * @throws JMSException if any of the JMS operations fail
     */
    void send(Message message, int count, MessagePopulator populator,
              long timeToLive) throws JMSException;

    /**
     * Return the destination associated with the MessageProducer
     *
     * @return the destination to send messages to
     * @throws JMSException if the operation fails
     */
    Destination getDestination() throws JMSException;

    /**
     * Sets a listener to be notified each time a message is sent
     *
     * @param listener the listener
     */
    void setMessageListener(MessageListener listener);

    /**
     * Returns the listener for sent messages
     *
     * @return the listener, or <code>null</code> if no listener is set
     */
    MessageListener getMessageListener();

    /**
     * Close the underlying MessageProducer
     *
     * @throws JMSException if the operation fails
     */
    void close() throws JMSException;

} //-- MessageSender
