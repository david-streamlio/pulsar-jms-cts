/*
 * This class was automatically generated with
 * <a href="http://www.castor.org">Castor 0.9.4.3</a>, using an XML
 * Schema.
 * $Id$
 */

package org.exolab.jmscts.core.meta;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/


/**
 * Class MetaDataDescriptor.
 *
 * @version $Revision$ $Date$
 */
public class MetaDataDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {


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

    public MetaDataDescriptor() {
        super();
        nsURI = "http://jmscts.sourceforge.net/metadata";
        xmlName = "meta-data";

        //-- set grouping compositor
        setCompositorAsSequence();
        org.exolab.castor.xml.util.XMLFieldDescriptorImpl  desc           = null;
        org.exolab.castor.xml.XMLFieldHandler              handler        = null;
        org.exolab.castor.xml.FieldValidator               fieldValidator = null;
        //-- initialize attribute descriptors

        //-- initialize element descriptors

        //-- _classMetaList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(ClassMeta.class, "_classMetaList", "class-meta", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public Object getValue( Object object )
                throws IllegalStateException
            {
                MetaData target = (MetaData) object;
                return target.getClassMeta();
            }
            public void setValue( Object object, Object value)
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    MetaData target = (MetaData) object;
                    target.addClassMeta( (ClassMeta) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public Object newInstance( Object parent ) {
                return new ClassMeta();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(true);
        addFieldDescriptor(desc);

        //-- validation code for: _classMetaList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
    } //-- org.exolab.jmscts.core.meta.MetaDataDescriptor()


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
    public Class<MetaData> getJavaClass()
    {
        return MetaData.class;
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
