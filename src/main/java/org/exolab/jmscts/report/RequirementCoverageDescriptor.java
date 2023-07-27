/*
 * This class was automatically generated with
 * <a href="http://www.castor.org">Castor 0.9.4.3</a>, using an XML
 * Schema.
 * $Id$
 */

package org.exolab.jmscts.report;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.validators.StringValidator;

/**
 * Class RequirementCoverageDescriptor.
 *
 * @version $Revision$ $Date$
 */
public class RequirementCoverageDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field nsPrefix
     */
    private String nsPrefix;

    /**
     * Field nsURI
     */
    private String nsURI;

    /**
     * Field xmlName
     */
    private String xmlName;

    /**
     * Field identity
     */
    private org.exolab.castor.xml.XMLFieldDescriptor identity;


      //----------------/
     //- Constructors -/
    //----------------/

    public RequirementCoverageDescriptor() {
        super();
        nsURI = "http://jmscts.sourceforge.net/coverage";
        xmlName = "requirementCoverage";

        //-- set grouping compositor
        setCompositorAsSequence();
        org.exolab.castor.xml.util.XMLFieldDescriptorImpl  desc           = null;
        org.exolab.castor.xml.XMLFieldHandler              handler        = null;
        org.exolab.castor.xml.FieldValidator               fieldValidator = null;
        //-- initialize attribute descriptors

        //-- initialize element descriptors

        //-- _provider
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(String.class, "_provider", "provider", org.exolab.castor.xml.NodeType.Element);
        desc.setImmutable(true);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public Object getValue( Object object )
                throws IllegalStateException
            {
                RequirementCoverage target = (RequirementCoverage) object;
                return target.getProvider();
            }
            public void setValue( Object object, Object value)
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    RequirementCoverage target = (RequirementCoverage) object;
                    target.setProvider( (String) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public Object newInstance( Object parent ) {
                return null;
            }
        } );
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);

        //-- validation code for: _provider
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
            StringValidator typeValidator = new StringValidator();
            typeValidator.setWhiteSpace("preserve");
            fieldValidator.setValidator(typeValidator);
        }
        desc.setValidator(fieldValidator);
        //-- _currentTest
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(CurrentTest.class, "_currentTest", "currentTest", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public Object getValue( Object object )
                throws IllegalStateException
            {
                RequirementCoverage target = (RequirementCoverage) object;
                return target.getCurrentTest();
            }
            public void setValue( Object object, Object value)
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    RequirementCoverage target = (RequirementCoverage) object;
                    target.setCurrentTest( (CurrentTest) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public Object newInstance( Object parent ) {
                return new CurrentTest();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);

        //-- validation code for: _currentTest
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _coverageList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(Coverage.class, "_coverageList", "coverage", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public Object getValue( Object object )
                throws IllegalStateException
            {
                RequirementCoverage target = (RequirementCoverage) object;
                return target.getCoverage();
            }
            public void setValue( Object object, Object value)
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    RequirementCoverage target = (RequirementCoverage) object;
                    target.addCoverage( (Coverage) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public Object newInstance( Object parent ) {
                return new Coverage();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(true);
        addFieldDescriptor(desc);

        //-- validation code for: _coverageList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _testRunsList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(TestRuns.class, "_testRunsList", "testRuns", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public Object getValue( Object object )
                throws IllegalStateException
            {
                RequirementCoverage target = (RequirementCoverage) object;
                return target.getTestRuns();
            }
            public void setValue( Object object, Object value)
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    RequirementCoverage target = (RequirementCoverage) object;
                    target.addTestRuns( (TestRuns) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public Object newInstance( Object parent ) {
                return new TestRuns();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(true);
        addFieldDescriptor(desc);

        //-- validation code for: _testRunsList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _failureList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(Failure.class, "_failureList", "failure", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public Object getValue( Object object )
                throws IllegalStateException
            {
                RequirementCoverage target = (RequirementCoverage) object;
                return target.getFailure();
            }
            public void setValue( Object object, Object value)
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    RequirementCoverage target = (RequirementCoverage) object;
                    target.addFailure( (Failure) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public Object newInstance( Object parent ) {
                return new Failure();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(true);
        addFieldDescriptor(desc);

        //-- validation code for: _failureList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
    } //-- org.exolab.jmscts.report.RequirementCoverageDescriptor()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method getAccessMode
     */
    public org.exolab.castor.mapping.AccessMode getAccessMode()
    {
        return null;
    } //-- org.exolab.castor.mapping.AccessMode getAccessMode()

    /**
     * Method getExtends
     */
    public org.exolab.castor.mapping.ClassDescriptor getExtends()
    {
        return null;
    } //-- org.exolab.castor.mapping.ClassDescriptor getExtends()

    /**
     * Method getIdentity
     */
    public org.exolab.castor.mapping.FieldDescriptor getIdentity()
    {
        return identity;
    } //-- org.exolab.castor.mapping.FieldDescriptor getIdentity()

    /**
     * Method getJavaClass
     */
    public Class<RequirementCoverage> getJavaClass()
    {
        return RequirementCoverage.class;
    } //-- java.lang.Class getJavaClass()

    /**
     * Method getNameSpacePrefix
     */
    public String getNameSpacePrefix()
    {
        return nsPrefix;
    } //-- java.lang.String getNameSpacePrefix()

    /**
     * Method getNameSpaceURI
     */
    public String getNameSpaceURI()
    {
        return nsURI;
    } //-- java.lang.String getNameSpaceURI()

    /**
     * Method getValidator
     */
    public org.exolab.castor.xml.TypeValidator getValidator()
    {
        return this;
    } //-- org.exolab.castor.xml.TypeValidator getValidator()

    /**
     * Method getXMLName
     */
    public String getXMLName()
    {
        return xmlName;
    } //-- java.lang.String getXMLName()

}
