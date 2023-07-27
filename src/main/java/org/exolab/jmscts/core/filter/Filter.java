/*
 * This class was automatically generated with
 * <a href="http://www.castor.org">Castor 0.9.4.3</a>, using an XML
 * Schema.
 * $Id$
 */

package org.exolab.jmscts.core.filter;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

import java.util.ArrayList;

/**
 * The filter element is the root element of all test case filter
 *  documents.
 *
 *
 * @version $Revision$ $Date$
 */
public class Filter implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * This element specifies to include the specified test cases
     * when running
     *  the test suite
     *
     */
    private ArrayList<Selector> _includeList;

    /**
     * This element specifies to exclude the specified test cases
     * when running
     *  the test suite
     *
     */
    private ArrayList<Selector> _excludeList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Filter() {
        super();
        _includeList = new ArrayList<Selector>();
        _excludeList = new ArrayList<Selector>();
    } //-- org.exolab.jmscts.core.filter.Filter()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addExclude
     *
     * @param vExclude
     */
    public void addExclude(Exclude vExclude)
        throws IndexOutOfBoundsException
    {
        _excludeList.add(vExclude);
    } //-- void addExclude(org.exolab.jmscts.core.filter.Exclude)

    /**
     * Method addExclude
     *
     * @param index
     * @param vExclude
     */
    public void addExclude(int index, Exclude vExclude)
        throws IndexOutOfBoundsException
    {
        _excludeList.add(index, vExclude);
    } //-- void addExclude(int, org.exolab.jmscts.core.filter.Exclude)

    /**
     * Method addInclude
     *
     * @param vInclude
     */
    public void addInclude(Include vInclude)
        throws IndexOutOfBoundsException
    {
        _includeList.add(vInclude);
    } //-- void addInclude(org.exolab.jmscts.core.filter.Include)

    /**
     * Method addInclude
     *
     * @param index
     * @param vInclude
     */
    public void addInclude(int index, Include vInclude)
        throws IndexOutOfBoundsException
    {
        _includeList.add(index, vInclude);
    } //-- void addInclude(int, org.exolab.jmscts.core.filter.Include)

    /**
     * Method clearExclude
     */
    public void clearExclude()
    {
        _excludeList.clear();
    } //-- void clearExclude()

    /**
     * Method clearInclude
     */
    public void clearInclude()
    {
        _includeList.clear();
    } //-- void clearInclude()

    /**
     * Method enumerateExclude
     */
    public java.util.Enumeration<?> enumerateExclude()
    {
        return new org.exolab.castor.util.IteratorEnumeration(_excludeList.iterator());
    } //-- java.util.Enumeration enumerateExclude()

    /**
     * Method enumerateInclude
     */
    public java.util.Enumeration<?> enumerateInclude()
    {
        return new org.exolab.castor.util.IteratorEnumeration(_includeList.iterator());
    } //-- java.util.Enumeration enumerateInclude()

    /**
     * Note: hashCode() has not been overriden
     *
     * @param obj
     */
    public boolean equals(Object obj)
    {
        if ( this == obj )
            return true;

        if (obj instanceof Filter) {

            Filter temp = (Filter)obj;
            if (this._includeList != null) {
                if (temp._includeList == null) return false;
                else if (!(this._includeList.equals(temp._includeList)))
                    return false;
            }
            else if (temp._includeList != null)
                return false;
            if (this._excludeList != null) {
                if (temp._excludeList == null) return false;
                else if (!(this._excludeList.equals(temp._excludeList)))
                    return false;
            }
            else if (temp._excludeList != null)
                return false;
            return true;
        }
        return false;
    } //-- boolean equals(java.lang.Object)

    /**
     * Method getExclude
     *
     * @param index
     */
    public Exclude getExclude(int index)
        throws IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _excludeList.size())) {
            throw new IndexOutOfBoundsException();
        }

        return (Exclude) _excludeList.get(index);
    } //-- org.exolab.jmscts.core.filter.Exclude getExclude(int)

    /**
     * Method getExclude
     */
    public Exclude[] getExclude()
    {
        int size = _excludeList.size();
        Exclude[] mArray = new Exclude[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (Exclude) _excludeList.get(index);
        }
        return mArray;
    } //-- org.exolab.jmscts.core.filter.Exclude[] getExclude()

    /**
     * Method getExcludeCount
     */
    public int getExcludeCount()
    {
        return _excludeList.size();
    } //-- int getExcludeCount()

    /**
     * Method getInclude
     *
     * @param index
     */
    public Include getInclude(int index)
        throws IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _includeList.size())) {
            throw new IndexOutOfBoundsException();
        }

        return (Include) _includeList.get(index);
    } //-- org.exolab.jmscts.core.filter.Include getInclude(int)

    /**
     * Method getInclude
     */
    public Include[] getInclude()
    {
        int size = _includeList.size();
        Include[] mArray = new Include[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (Include) _includeList.get(index);
        }
        return mArray;
    } //-- org.exolab.jmscts.core.filter.Include[] getInclude()

    /**
     * Method getIncludeCount
     */
    public int getIncludeCount()
    {
        return _includeList.size();
    } //-- int getIncludeCount()

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
     * Method removeExclude
     *
     * @param vExclude
     */
    public boolean removeExclude(Exclude vExclude)
    {
        boolean removed = _excludeList.remove(vExclude);
        return removed;
    } //-- boolean removeExclude(org.exolab.jmscts.core.filter.Exclude)

    /**
     * Method removeInclude
     *
     * @param vInclude
     */
    public boolean removeInclude(Include vInclude)
    {
        boolean removed = _includeList.remove(vInclude);
        return removed;
    } //-- boolean removeInclude(org.exolab.jmscts.core.filter.Include)

    /**
     * Method setExclude
     *
     * @param index
     * @param vExclude
     */
    public void setExclude(int index, Exclude vExclude)
        throws IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _excludeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _excludeList.set(index, vExclude);
    } //-- void setExclude(int, org.exolab.jmscts.core.filter.Exclude)

    /**
     * Method setExclude
     *
     * @param excludeArray
     */
    public void setExclude(Exclude[] excludeArray)
    {
        //-- copy array
        _excludeList.clear();
        for (int i = 0; i < excludeArray.length; i++) {
            _excludeList.add(excludeArray[i]);
        }
    } //-- void setExclude(org.exolab.jmscts.core.filter.Exclude)

    /**
     * Method setInclude
     *
     * @param index
     * @param vInclude
     */
    public void setInclude(int index, Include vInclude)
        throws IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _includeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _includeList.set(index, vInclude);
    } //-- void setInclude(int, org.exolab.jmscts.core.filter.Include)

    /**
     * Method setInclude
     *
     * @param includeArray
     */
    public void setInclude(Include[] includeArray)
    {
        //-- copy array
        _includeList.clear();
        for (int i = 0; i < includeArray.length; i++) {
            _includeList.add(includeArray[i]);
        }
    } //-- void setInclude(org.exolab.jmscts.core.filter.Include)

    /**
     * Method unmarshal
     *
     * @param reader
     */
    public static Filter unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (Filter) Unmarshaller.unmarshal(Filter.class, reader);
    } //-- org.exolab.jmscts.core.filter.Filter unmarshal(java.io.Reader)

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
