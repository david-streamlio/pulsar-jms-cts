/*
 * This class was automatically generated with
 * <a href="http://www.castor.org">Castor 0.9.4.3</a>, using an XML
 * Schema.
 * $Id$
 */

package org.exolab.jmscts.requirements;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.validators.StringValidator;

/**
 * Class RequirementChoiceItemDescriptor.
 *
 * @version $Revision$ $Date$
 */
public class RequirementChoiceItemDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {


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

    public RequirementChoiceItemDescriptor() {
        super();
        nsURI = "http://jmscts.sourceforge.net/requirements";

        //-- set grouping compositor
        setCompositorAsChoice();
        org.exolab.castor.xml.util.XMLFieldDescriptorImpl  desc           = null;
        org.exolab.castor.xml.XMLFieldHandler              handler        = null;
        org.exolab.castor.xml.FieldValidator               fieldValidator = null;
        //-- initialize attribute descriptors

        //-- initialize element descriptors

        //-- _referenceId
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(String.class, "_referenceId", "referenceId", org.exolab.castor.xml.NodeType.Element);
        desc.setImmutable(true);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public Object getValue( Object object )
                throws IllegalStateException
            {
                RequirementChoiceItem target = (RequirementChoiceItem) object;
                return target.getReferenceId();
            }
            public void setValue( Object object, Object value)
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    RequirementChoiceItem target = (RequirementChoiceItem) object;
                    target.setReferenceId( (String) value);
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

        //-- validation code for: _referenceId
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
            StringValidator typeValidator = new StringValidator();
            typeValidator.setWhiteSpace("preserve");
            fieldValidator.setValidator(typeValidator);
        }
        desc.setValidator(fieldValidator);
        //-- _reference
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(Reference.class, "_reference", "reference", org.exolab.castor.xml.NodeType.Element);
        handler = (new org.exolab.castor.xml.XMLFieldHandler() {
            public Object getValue( Object object )
                throws IllegalStateException
            {
                RequirementChoiceItem target = (RequirementChoiceItem) object;
                return target.getReference();
            }
            public void setValue( Object object, Object value)
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    RequirementChoiceItem target = (RequirementChoiceItem) object;
                    target.setReference( (Reference) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public Object newInstance( Object parent ) {
                return new Reference();
            }
        } );
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);

        //-- validation code for: _reference
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
    } //-- org.exolab.jmscts.requirements.RequirementChoiceItemDescriptor()


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
    public Class<RequirementChoiceItem> getJavaClass()
    {
        return RequirementChoiceItem.class;
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
