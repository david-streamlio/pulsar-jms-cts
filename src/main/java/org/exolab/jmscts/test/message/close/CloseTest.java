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
 * $Id: CloseTest.java,v 1.6 2004/02/03 07:31:02 tanderson Exp $
 */
package org.exolab.jmscts.test.message.close;

import junit.framework.Test;
import org.exolab.jmscts.core.AbstractSendReceiveTestCase;
import org.exolab.jmscts.core.MessagePopulator;
import org.exolab.jmscts.core.TestContext;
import org.exolab.jmscts.core.TestCreator;
import org.exolab.jmscts.test.message.util.MessagePopulatorVerifier;
import org.exolab.jmscts.test.message.util.PopulatorVerifierFactory;

import javax.jms.Connection;
import javax.jms.IllegalStateException;
import javax.jms.Message;
import javax.jms.Session;


/**
 * This class tests the behaviour of messages when the associated
 * connection or session is closed.
 *
 * @author <a href="mailto:tma@netspace.net.au">Tim Anderson</a>
 * @version $Revision: 1.6 $
 * @see AbstractSendReceiveTestCase
 * @see org.exolab.jmscts.core.SendReceiveTestRunner
 * @jmscts.session all
 * @jmscts.delivery consumer
 */
public class CloseTest extends AbstractSendReceiveTestCase {

    /**
     * The destination used by this test case
     */
    private static final String DESTINATION = "CloseTest";

    /**
     * Construct an instance of this class for a specific test case.
     * The test will be run against all message, consumer and session types.
     *
     * @param name the name of test case
     */
    public CloseTest(String name) {
        super(name);
    }

    /**
     * Sets up the test suite
     *
     * @return an instance of this class that may be run by
     * {@link org.exolab.jmscts.core.JMSTestRunner}
     */
    public static Test suite() {
        return TestCreator.createSendReceiveTest(CloseTest.class);
    }

    /**
     * Returns if this test can share resources with other test cases.
     * This implementation always returns <code>false</code>, to
     * ensure that a new session is created for each test.
     *
     * @return <code>false</code>
     */
    @Override
    public boolean share() {
        return false;
    }

    /**
     * Get the message populator. This implementation always returns null
     *
     * @return null
     */
    @Override
    public MessagePopulator getMessagePopulator() {
        return null;
    }

    /**
     * Returns the list of destination names used by this test case. These
     * are used to pre-create destinations prior to running the test case.
     *
     * @return this implementation returns <code>null</code>.
     */
    @Override
    public String[] getDestinations() {
        return new String[]{DESTINATION};
    }

    /**
     * Verifies that all the methods for a message may be invoked for a closed
     * session, with the exception of <code>Message.acknowledge()</code>, which
     * should throw <code>IllegalStateException</code>.
     *
     * @jmscts.requirement session.close.message
     * @throws Exception for any error
     */
    public void testCloseSession() throws Exception {
        TestContext context = getContext();
        Session session = context.getSession();
        Message message = context.getMessage();

        MessagePopulatorVerifier verifier = PopulatorVerifierFactory.create(
            message);

        verifier.populate(message);
        Message received = sendReceive(message, DESTINATION);

        // close the session, and verify that methods may be invoked on the
        // sent and received messages
        session.close();

        // verify that the sent message can be cleared and populated
        message.clearBody();
        verifier.populate(message);

        // verify that the received message can be read
        verifier.verify(received);

        // now verify that invoking acknowledge throws IllegalStateException
        try {
            received.acknowledge();
            fail("Expected IllegalStateException to be thrown when invoking "
                 + "acknowledge for a closed session");
        } catch (IllegalStateException expected) {
            // the expected behaviour
        } catch (Exception exception) {
            fail("Expected IllegalStateException to be thrown when invoking "
                 + "acknowledge for a closed session, but got: " + exception);
        }
    }

    /**
     * Verifies that all the methods for a message may be invoked for a closed
     * connection, with the exception of <code>Message.acknowledge()</code>,
     * which should throw <code>IllegalStateException</code>.
     *
     * @jmscts.requirement connection.close.message
     * @throws Exception for any error
     */
    public void testCloseConnection() throws Exception {
        TestContext context = getContext();
        Connection connection = context.getConnection();
        Message message = context.getMessage();

        MessagePopulatorVerifier verifier = PopulatorVerifierFactory.create(
            message);

        verifier.populate(message);
        Message received = sendReceive(message, DESTINATION);

        // close the connection, and verify that methods may be invoked on the
        // sent and received messages
        connection.close();

        // verify that the sent message can be cleared and populated
        message.clearBody();
        verifier.populate(message);

        // verify that the received message can be read
        verifier.verify(received);

        // now verify that invoking acknowledge throws IllegalStateException
        try {
            received.acknowledge();
            fail("Expected IllegalStateException to be thrown when invoking "
                 + "acknowledge for a closed connection");
        } catch (IllegalStateException expected) {
            // the expected behaviour
        } catch (Exception exception) {
            fail("Expected IllegalStateException to be thrown when invoking "
                 + "acknowledge for a closed connection, but got: "
                 + exception);
        }
    }

}
