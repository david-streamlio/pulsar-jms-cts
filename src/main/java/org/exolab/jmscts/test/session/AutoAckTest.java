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
 * Copyright 2003-2004 (C) Exoffice Technologies Inc. All Rights Reserved.
 *
 * $Id: AutoAckTest.java,v 1.2 2004/02/03 21:52:11 tanderson Exp $
 */
package org.exolab.jmscts.test.session;

import junit.framework.Test;
import org.exolab.jmscts.core.AbstractSendReceiveTestCase;
import org.exolab.jmscts.core.MessageReceiver;
import org.exolab.jmscts.core.TestCreator;


/**
 * This class tests the behaviour of consumers on sessions created with the
 * <code>Session.AUTO_ACKNOWLEDGE</code> message acknowledgment mode.
 *
 * @author <a href="mailto:tma@netspace.net.au">Tim Anderson</a>
 * @version $Revision: 1.2 $
 * @jmscts.session AUTO_ACKNOWLEDGE
 * @jmscts.delivery consumer
 * @jmscts.message ObjectMessage
 */
public class AutoAckTest extends AbstractSendReceiveTestCase {

    /**
     * The destination to create prior to running the test
     */
    private static final String DESTINATION = "AutoAckTest";

    /**
     * Construct a new <code>AutoAckTest</code>
     *
     * @param name the name of test case
     */
    public AutoAckTest(String name) {
        super(name);
    }

    /**
     * Sets up the test suite.
     *
     * @return an instance of this class that may be run by
     * {@link org.exolab.jmscts.core.JMSTestRunner}
     */
    public static Test suite() {
        return TestCreator.createSendReceiveTest(AutoAckTest.class);
    }

    /**
     * Returns the list of destination names used by this test case. These
     * are used to pre-administer destinations prior to running the test case.
     *
     * @return the list of destinations used by this test case
     */
    @Override
    public String[] getDestinations() {
        return new String[]{DESTINATION};
    }

    /**
     * Verifies auto acknowledgement functionality. Creates a consumer,
     * send n messages, receives them, and closes the consumer. Creates
     * another consumer and verifies that no messages can be received.
     *
     * @jmscts.requirement session.AUTO_ACKNOWLEDGE
     * @throws Exception for any error
     */
    public void testAutoAcknowledgement() throws Exception {
        final int count = 10; // send count messages
        getContext();

        // construct the receiver
        MessageReceiver receiver = createReceiver(DESTINATION);

        try {
            // send count messages
            send(DESTINATION, count);

            // ...and receive them
            receive(receiver, count);

            // re-create the receiver, and verify that no messages are received
            receiver = recreate(receiver);
            receive(receiver, 0);
        } finally {
            receiver.remove();
        }
    }

}
