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
 * $Id: ComplianceTestSuite.java,v 1.6 2004/02/03 07:35:14 tanderson Exp $
 */
package org.exolab.jmscts.test;

import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.exolab.jmscts.core.JMSTestRunner;
import org.exolab.jmscts.core.JUnitTestRunner;
import org.exolab.jmscts.test.asf.ASFTestSuite;
import org.exolab.jmscts.test.connection.ConnectionTestSuite;
import org.exolab.jmscts.test.message.MessageTestSuite;
import org.exolab.jmscts.test.producer.ProducerTestSuite;
import org.exolab.jmscts.test.selector.SelectorTestSuite;
import org.exolab.jmscts.test.session.SessionTestSuite;
import org.exolab.jmscts.test.topic.TopicTestSuite;

import static org.junit.Assert.fail;


/**
 * This class encapsulates all compliance tests.
 *
 * @author <a href="mailto:tma@netspace.net.au">Tim Anderson</a>
 * @version $Revision: 1.6 $
 */
public final class ComplianceTestSuite {

    /**
     * Prevent construction of helper class
     */
    private ComplianceTestSuite() {
    }

    /**
     * The main line used to execute the compliance test cases
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JMSTestRunner test = new JMSTestRunner(suite(), args);
        TestResult testResult = JUnitTestRunner.run(test);
        int numErrors = testResult.errorCount();
        int numFailures = testResult.failureCount();
        if (numErrors!=0 || numFailures!=0) {
            StringBuilder sb = new StringBuilder("ComplianceTestSuite: reports ");
            sb.append(numFailures==0 ? "NO Failures but "
                     :numFailures==1 ? "ONE Failure and "
                     :    ""+numFailures+ " Failures and ");
            sb.append(numErrors==0 ? "NO Errors."
                     :numErrors==1 ? "ONE Error."
                     :    ""+numErrors+ " Errors.");
            fail(sb.toString());
        }
    }

    /**
     * Sets up the test suite.
     *
     * @return the test suite
     */
    public static Test suite() {
        TestSuite suite = new TestSuite();

        suite.addTest(ConnectionTestSuite.suite());
        suite.addTest(SessionTestSuite.suite());
        suite.addTest(TopicTestSuite.suite());
        suite.addTest(ProducerTestSuite.suite());
        suite.addTest(MessageTestSuite.suite());
        suite.addTest(SelectorTestSuite.suite());
        suite.addTest(ASFTestSuite.suite());
        System.out.println("Test count:"+suite.testCount());
        return suite;
    }

}
