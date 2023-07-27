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

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class RequirementChoice.
 *
 * @version $Revision$ $Date$
 */
public class RequirementChoice implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Field requirementChoiceItem
     */
    private RequirementChoiceItem requirementChoiceItem;


      //----------------/
     //- Constructors -/
    //----------------/

    public RequirementChoice() {
        super();
    } //-- org.exolab.jmscts.requirements.RequirementChoice()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Note: hashCode() has not been overriden
     *
     * @param obj
     */
    public boolean equals(Object obj)
    {
        if ( this == obj )
            return true;

        if (obj instanceof RequirementChoice) {

            RequirementChoice temp = (RequirementChoice)obj;
            if (this.requirementChoiceItem != null) {
                if (temp.requirementChoiceItem == null) return false;
                else if (!(this.requirementChoiceItem.equals(temp.requirementChoiceItem)))
                    return false;
            }
            else if (temp.requirementChoiceItem != null)
                return false;
            return true;
        }
        return false;
    } //-- boolean equals(java.lang.Object)

    /**
     * Returns the value of field 'requirementChoiceItem'.
     *
     * @return the value of field 'requirementChoiceItem'.
     */
    public RequirementChoiceItem getRequirementChoiceItem()
    {
        return this.requirementChoiceItem;
    } //-- org.exolab.jmscts.requirements.RequirementChoiceItem getRequirementChoiceItem()

    /**
     * Method isValid
     */
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid()

    /**
     * Method marshal
     *
     * @param out
     */
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {

        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer)

    /**
     * Method marshal
     *
     * @param handler
     */
    public void marshal(org.xml.sax.ContentHandler handler)
        throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {

        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.ContentHandler)

    /**
     * Sets the value of field 'requirementChoiceItem'.
     *
     * @param requirementChoiceItem the value of field
     * 'requirementChoiceItem'.
     */
    public void setRequirementChoiceItem(RequirementChoiceItem requirementChoiceItem)
    {
        this.requirementChoiceItem = requirementChoiceItem;
    } //-- void setRequirementChoiceItem(org.exolab.jmscts.requirements.RequirementChoiceItem)

    /**
     * Method unmarshal
     *
     * @param reader
     */
    public static RequirementChoice unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (RequirementChoice) Unmarshaller.unmarshal(RequirementChoice.class, reader);
    } //-- org.exolab.jmscts.requirements.RequirementChoice unmarshal(java.io.Reader)

    /**
     * Method validate
     */
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate()

}
