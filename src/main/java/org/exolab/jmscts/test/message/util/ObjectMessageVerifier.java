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
 * $Id: ObjectMessageVerifier.java,v 1.2 2004/02/03 07:31:04 tanderson Exp $
 */
package org.exolab.jmscts.test.message.util;

import org.exolab.jmscts.core.MethodCache;

import javax.jms.ObjectMessage;


/**
 * A helper class for populating and verifying the content of
 * <code>ObjectMessage</code> instances.
 *
 * @version     $Revision: 1.2 $ $Date: 2004/02/03 07:31:04 $
 * @author      <a href="mailto:tma@netspace.net.au">Tim Anderson</a>
 * @see         MessagePopulatorVerifier
 */
class ObjectMessageVerifier extends MessagePopulatorVerifier {

    /** TODO */
    private static final long serialVersionUID = 1L;
    /**
     * Method cache for ObjectMessage
     */
    private static MethodCache _methods = null;


    /**
     * Construct a new instance. No exceptions are expected to be thrown
     * when invoking methods
     */
    public ObjectMessageVerifier() {
    }

    /**
     * Construct an instance with the expected exception thrown when
     * methods are invoked
     *
     * @param exception the expected exception type when methods are invoked
     */
    public ObjectMessageVerifier(Class<?> exception) {
        super(exception);
    }

    /**
     * Attempt to populate an ObjectMessage instance with data
     *
     * @param message the message to populate
     * @throws Exception for any error
     */
    @Override
    public void populateObjectMessage(ObjectMessage message) throws Exception {
        invoke(message, "setObject", "ABC");
    }

    /**
     * Attempt to verify the content of an ObjectMessage populated via the
     * above {@link #populateObjectMessage}.
     *
     * @param message the message to verify
     * @throws Exception for any error
     */
    @Override
    public void verifyObjectMessage(ObjectMessage message) throws Exception {
        expect(message, "getObject", "ABC");
    }

    /**
     * Returns a cache of the <code>ObjectMessage</code> methods
     *
     * @return a cache of the <code>ObjectMessage</code> methods
     */
    @Override
    protected synchronized MethodCache getMethods() {
        if (_methods == null) {
            _methods = new MethodCache(ObjectMessage.class);
        }
        return _methods;
    }

}
