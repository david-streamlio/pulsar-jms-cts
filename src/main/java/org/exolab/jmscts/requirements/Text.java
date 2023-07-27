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

import java.util.ArrayList;

/**
 * Class Text.
 *
 * @version $Revision$ $Date$
 */
public abstract class Text implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * internal content storage
     */
    private String _content = "";

    /**
     * Field _anyObject
     */
    private ArrayList<Object> _anyObject;


      //----------------/
     //- Constructors -/
    //----------------/

    public Text() {
        super();
        setContent("");
        _anyObject = new ArrayList<Object>();
    } //-- org.exolab.jmscts.requirements.Text()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addAnyObject
     *
     * @param vAnyObject
     */
    public void addAnyObject(Object vAnyObject)
        throws IndexOutOfBoundsException
    {
        _anyObject.add(vAnyObject);
    } //-- void addAnyObject(java.lang.Object)

    /**
     * Method addAnyObject
     *
     * @param index
     * @param vAnyObject
     */
    public void addAnyObject(int index, Object vAnyObject)
        throws IndexOutOfBoundsException
    {
        _anyObject.add(index, vAnyObject);
    } //-- void addAnyObject(int, java.lang.Object)

    /**
     * Method clearAnyObject
     */
    public void clearAnyObject()
    {
        _anyObject.clear();
    } //-- void clearAnyObject()

    /**
     * Method enumerateAnyObject
     */
    public java.util.Enumeration<?> enumerateAnyObject()
    {
        return new org.exolab.castor.util.IteratorEnumeration(_anyObject.iterator());
    } //-- java.util.Enumeration enumerateAnyObject()

    /**
     * Note: hashCode() has not been overriden
     *
     * @param obj
     */
    public boolean equals(Object obj)
    {
        if ( this == obj )
            return true;

        if (obj instanceof Text) {

            Text temp = (Text)obj;
            if (this._content != null) {
                if (temp._content == null) return false;
                else if (!(this._content.equals(temp._content)))
                    return false;
            }
            else if (temp._content != null)
                return false;
            if (this._anyObject != null) {
                if (temp._anyObject == null) return false;
                else if (!(this._anyObject.equals(temp._anyObject)))
                    return false;
            }
            else if (temp._anyObject != null)
                return false;
            return true;
        }
        return false;
    } //-- boolean equals(java.lang.Object)

    /**
     * Method getAnyObject
     *
     * @param index
     */
    public Object getAnyObject(int index)
        throws IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _anyObject.size())) {
            throw new IndexOutOfBoundsException();
        }

        return _anyObject.get(index);
    } //-- java.lang.Object getAnyObject(int)

    /**
     * Method getAnyObject
     */
    public Object[] getAnyObject()
    {
        int size = _anyObject.size();
        Object[] mArray = new Object[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = _anyObject.get(index);
        }
        return mArray;
    } //-- java.lang.Object[] getAnyObject()

    /**
     * Method getAnyObjectCount
     */
    public int getAnyObjectCount()
    {
        return _anyObject.size();
    } //-- int getAnyObjectCount()

    /**
     * Returns the value of field 'content'. The field 'content'
     * has the following description: internal content storage
     *
     * @return the value of field 'content'.
     */
    public String getContent()
    {
        return this._content;
    } //-- java.lang.String getContent()

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
     * Method removeAnyObject
     *
     * @param vAnyObject
     */
    public boolean removeAnyObject(Object vAnyObject)
    {
        boolean removed = _anyObject.remove(vAnyObject);
        return removed;
    } //-- boolean removeAnyObject(java.lang.Object)

    /**
     * Method setAnyObject
     *
     * @param index
     * @param vAnyObject
     */
    public void setAnyObject(int index, Object vAnyObject)
        throws IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _anyObject.size())) {
            throw new IndexOutOfBoundsException();
        }
        _anyObject.set(index, vAnyObject);
    } //-- void setAnyObject(int, java.lang.Object)

    /**
     * Method setAnyObject
     *
     * @param anyObjectArray
     */
    public void setAnyObject(Object[] anyObjectArray)
    {
        //-- copy array
        _anyObject.clear();
        for (int i = 0; i < anyObjectArray.length; i++) {
            _anyObject.add(anyObjectArray[i]);
        }
    } //-- void setAnyObject(java.lang.Object)

    /**
     * Sets the value of field 'content'. The field 'content' has
     * the following description: internal content storage
     *
     * @param content the value of field 'content'.
     */
    public void setContent(String content)
    {
        this._content = content;
    } //-- void setContent(java.lang.String)

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
