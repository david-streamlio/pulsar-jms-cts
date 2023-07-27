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
 * $Id: Administrator.java,v 1.2 2004/02/02 03:50:09 tanderson Exp $
 */
package org.exolab.jmscts.provider;

import javax.jms.JMSException;
import javax.naming.NamingException;


/**
 * This interface specifies methods for obtaining and manipulating
 * administered objects managed by the JMS provider.<br/>
 * Although the JMS specification states that administered objects should
 * be accessible via JNDI, not all providers implement this, and for those
 * that do, there is no standard registration scheme (eg. some use LDAP).<br>
 * This interface therefore avoids making assumptions on how administered
 * objects are accessed.
 *
 * @version     $Revision: 1.2 $ $Date: 2004/02/02 03:50:09 $
 * @author      <a href="mailto:tma@netspace.net.au">Tim Anderson</a>
 * @see         Provider
 */
public interface Administrator {

    /**
     * Returns the name of the QueueConnectionFactory bound in JNDI
     *
     * @return the default QueueConnectionFactory name
     */
    String getQueueConnectionFactory();

    /**
     * Returns the name of the TopicConnectionFactory bound in JNDI
     *
     * @return the default TopicConnectionFactory name
     */
    String getTopicConnectionFactory();

    /**
     * Returns the name of the XAQueueConnectionFactory bound in JNDI
     *
     * @return the default XAQueueConnectionFactory name
     */
    String getXAQueueConnectionFactory();

    /**
     * Returns the name of the XATopicConnectionFactory bound in JNDI
     *
     * @return the default XATopicConnectionFactory name
     */
    String getXATopicConnectionFactory();

    /**
     * Look up the named administered object in JNDI
     *
     * @param name the name that the administered object is bound to
     * @return the administered object bound to name
     * @throws NamingException if the object is not bound, or the lookup fails
     */
    Object lookup(String name) throws NamingException;

    /**
     * Create an administered destination
     *
     * @param name the destination name
     * @param queue if true, create a queue, else create a topic
     * @throws JMSException if the destination cannot be created
     */
    void createDestination(String name, boolean queue) throws JMSException;

    /**
     * Destroy an administered destination
     *
     * @param name the destination name
     * @throws JMSException if the destination cannot be destroyed
     */
    void destroyDestination(String name) throws JMSException;

    /**
     * Determines if an administered destination exists
     *
     * @param name the destination name
     * @throws JMSException for any internal JMS provider error
     * @return <code>true</code> if the destination exists
     */
    boolean destinationExists(String name) throws JMSException;

}