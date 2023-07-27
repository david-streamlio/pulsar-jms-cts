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


/**
 * Class TestRunDescriptor.
 *
 * @version $Revision$ $Date$
 */
public class TestRunDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {


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

    public TestRunDescriptor() {
        super();
        nsURI = "http://jmscts.sourceforge.net/test";
        xmlName = "testRun";

        //-- set grouping compositor
        setCompositorAsSequence();
        org.exolab.castor.xml.util.XMLFieldDescriptorImpl  desc           = null;
        org.exolab.castor.xml.XMLFieldHandler              handler        = null;
        org.exolab.castor.xml.FieldValidator               fieldValidator = null;
        //-- initialize attribute descriptors

        //-- initialize element descriptors

        //-- _context
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(Context.class, "_context", "context", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public Object getValue( Object object )
                throws IllegalStateException
            {
                TestRun target = (TestRun) object;
                return target.getContext();
            }
            public void setValue( Object object, Object value)
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    TestRun target = (TestRun) object;
                    target.setContext( (Context) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public Object newInstance( Object parent ) {
                return new Context();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);

        //-- validation code for: _context
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _failure
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(Failure.class, "_failure", "failure", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public Object getValue( Object object )
                throws IllegalStateException
            {
                TestRun target = (TestRun) object;
                return target.getFailure();
            }
            public void setValue( Object object, Object value)
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    TestRun target = (TestRun) object;
                    target.setFailure( (Failure) value);
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
        desc.setMultivalued(false);
        addFieldDescriptor(desc);

        //-- validation code for: _failure
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _statisticList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(Statistic.class, "_statisticList", "statistic", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public Object getValue( Object object )
                throws IllegalStateException
            {
                TestRun target = (TestRun) object;
                return target.getStatistic();
            }
            public void setValue( Object object, Object value)
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    TestRun target = (TestRun) object;
                    target.addStatistic( (Statistic) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public Object newInstance( Object parent ) {
                return new Statistic();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(true);
        addFieldDescriptor(desc);

        //-- validation code for: _statisticList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
    } //-- org.exolab.jmscts.report.TestRunDescriptor()


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
    public Class<TestRun> getJavaClass()
    {
        return TestRun.class;
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
