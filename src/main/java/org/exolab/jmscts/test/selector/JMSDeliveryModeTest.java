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
 * $Id: JMSDeliveryModeTest.java,v 1.4 2004/02/03 21:52:11 tanderson Exp $
 */
package org.exolab.jmscts.test.selector;

import junit.framework.Test;
import org.exolab.jmscts.core.TestCreator;

import javax.jms.DeliveryMode;


/**
 * This class tests selectors containing <code>JMSDeliveryMode</code>
 *
 * @author <a href="mailto:tma@netspace.net.au">Tim Anderson</a>
 * @version $Revision: 1.4 $
 * @see AbstractSelectorTestCase
 * @jmscts.message Message
 */
public class JMSDeliveryModeTest extends AbstractSelectorTestCase {

    /**
     * Create an instance of this class for a specific test case
     *
     * @param name the name of test case
     */
    public JMSDeliveryModeTest(String name) {
        super(name);
    }

    /**
     * Sets up the test suite
     *
     * @return an instance of this class that may be run by
     * {@link org.exolab.jmscts.core.JMSTestRunner}
     */
    public static Test suite() {
        return TestCreator.createSendReceiveTest(JMSDeliveryModeTest.class);
    }

    /**
     * Verifies that messages can be selected on JMSDeliveryMode, using the
     * selector <code>JMSDeliveryMode = 'PERSISTENT' or
     * JMSDeliveryMode = 'NON_PERSISTENT'</code>.
     * This should select all messages
     *
     * @jmscts.requirement selector.JMSDeliveryMode
     * @jmscts.requirement selector.identifier.header
     * @jmscts.requirement selector.expression
     * @throws Exception for any error
     */
    public void testJMSDeliveryMode() throws Exception {
        checkSelector("JMSDeliveryMode = 'PERSISTENT' or "
                      + "JMSDeliveryMode = 'NON_PERSISTENT'", true);
    }

    /**
     * Verifies that the selector <code>JMSDeliveryMode = {non-persistent}
     * or JMSDeliveryMode = {persistent}</code> throws
     * InvalidSelectorException, where {non-persistent} and {persistent}
     * are the values of <code>DeliveryMode.NON_PERSISTENT</code> and
     * <code>DeliveryMode.PERSISTENT</code> respectively
     *
     * @jmscts.requirement selector.JMSDeliveryMode
     * @jmscts.requirement selector.validation
     * @throws Exception for any error
     */
//    public void testInvalid1() throws Exception {
//        checkInvalidSelector(
//            "JMSDeliveryMode = " + DeliveryMode.NON_PERSISTENT
//            + " or JMSDeliveryMode = " + DeliveryMode.PERSISTENT);
//    }

    /**
     * Verifies that the selector
     * <code>JMSDeliveryMode = 'non_persistent'</code>
     * selects no messages.
     *
     * @jmscts.requirement selector.JMSDeliveryMode
     * @jmscts.requirement selector.identifier.header
     * @jmscts.requirement selector.expression
     * @throws Exception for any error
     */
    public void testJMSDeliveryMode2() throws Exception {
        checkSelector("JMSDeliveryMode = 'non-persistent'", false);
    }

}
