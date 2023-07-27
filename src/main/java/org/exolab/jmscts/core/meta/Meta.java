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

import java.util.ArrayList;

/**
 * Class Meta.
 *
 * @version $Revision$ $Date$
 */
public abstract class Meta implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Field _name
     */
    private String _name;

    /**
     * Field _description
     */
    private Description _description;

    /**
     * Field _attributeList
     */
    private ArrayList<Attribute> _attributeList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Meta() {
        super();
        _attributeList = new ArrayList<Attribute>();
    } //-- org.exolab.jmscts.core.meta.Meta()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addAttribute
     *
     * @param vAttribute
     */
    public void addAttribute(Attribute vAttribute)
        throws IndexOutOfBoundsException
    {
        _attributeList.add(vAttribute);
    } //-- void addAttribute(org.exolab.jmscts.core.meta.Attribute)

    /**
     * Method addAttribute
     *
     * @param index
     * @param vAttribute
     */
    public void addAttribute(int index, Attribute vAttribute)
        throws IndexOutOfBoundsException
    {
        _attributeList.add(index, vAttribute);
    } //-- void addAttribute(int, org.exolab.jmscts.core.meta.Attribute)

    /**
     * Method clearAttribute
     */
    public void clearAttribute()
    {
        _attributeList.clear();
    } //-- void clearAttribute()

    /**
     * Method enumerateAttribute
     */
    public java.util.Enumeration<?> enumerateAttribute()
    {
        return new org.exolab.castor.util.IteratorEnumeration(_attributeList.iterator());
    } //-- java.util.Enumeration enumerateAttribute()

    /**
     * Note: hashCode() has not been overriden
     *
     * @param obj
     */
    public boolean equals(Object obj)
    {
        if ( this == obj )
            return true;

        if (obj instanceof Meta) {

            Meta temp = (Meta)obj;
            if (this._name != null) {
                if (temp._name == null) return false;
                else if (!(this._name.equals(temp._name)))
                    return false;
            }
            else if (temp._name != null)
                return false;
            if (this._description != null) {
                if (temp._description == null) return false;
                else if (!(this._description.equals(temp._description)))
                    return false;
            }
            else if (temp._description != null)
                return false;
            if (this._attributeList != null) {
                if (temp._attributeList == null) return false;
                else if (!(this._attributeList.equals(temp._attributeList)))
                    return false;
            }
            else if (temp._attributeList != null)
                return false;
            return true;
        }
        return false;
    } //-- boolean equals(java.lang.Object)

    /**
     * Method getAttribute
     *
     * @param index
     */
    public Attribute getAttribute(int index)
        throws IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _attributeList.size())) {
            throw new IndexOutOfBoundsException();
        }

        return _attributeList.get(index);
    } //-- org.exolab.jmscts.core.meta.Attribute getAttribute(int)

    /**
     * Method getAttribute
     */
    public Attribute[] getAttribute()
    {
        int size = _attributeList.size();
        Attribute[] mArray = new Attribute[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = _attributeList.get(index);
        }
        return mArray;
    } //-- org.exolab.jmscts.core.meta.Attribute[] getAttribute()

    /**
     * Method getAttributeCount
     */
    public int getAttributeCount()
    {
        return _attributeList.size();
    } //-- int getAttributeCount()

    /**
     * Returns the value of field 'description'.
     *
     * @return the value of field 'description'.
     */
    public Description getDescription()
    {
        return this._description;
    } //-- Description getDescription()

    /**
     * Returns the value of field 'name'.
     *
     * @return the value of field 'name'.
     */
    public String getName()
    {
        return this._name;
    } //-- java.lang.String getName()

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
     * Method removeAttribute
     *
     * @param vAttribute
     */
    public boolean removeAttribute(Attribute vAttribute)
    {
        boolean removed = _attributeList.remove(vAttribute);
        return removed;
    } //-- boolean removeAttribute(org.exolab.jmscts.core.meta.Attribute)

    /**
     * Method setAttribute
     *
     * @param index
     * @param vAttribute
     */
    public void setAttribute(int index, Attribute vAttribute)
        throws IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _attributeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _attributeList.set(index, vAttribute);
    } //-- void setAttribute(int, org.exolab.jmscts.core.meta.Attribute)

    /**
     * Method setAttribute
     *
     * @param attributeArray
     */
    public void setAttribute(Attribute[] attributeArray)
    {
        //-- copy array
        _attributeList.clear();
        for (int i = 0; i < attributeArray.length; i++) {
            _attributeList.add(attributeArray[i]);
        }
    } //-- void setAttribute(org.exolab.jmscts.core.meta.Attribute)

    /**
     * Sets the value of field 'description'.
     *
     * @param description the value of field 'description'.
     */
    public void setDescription(Description description)
    {
        this._description = description;
    } //-- void setDescription(Description)

    /**
     * Sets the value of field 'name'.
     *
     * @param name the value of field 'name'.
     */
    public void setName(String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String)

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
