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

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

import java.util.ArrayList;

/**
 * Class MetaData.
 *
 * @version $Revision$ $Date$
 */
public class MetaData implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Field _classMetaList
     */
    private ArrayList<ClassMeta> _classMetaList;


      //----------------/
     //- Constructors -/
    //----------------/

    public MetaData() {
        super();
        _classMetaList = new ArrayList<ClassMeta>();
    } //-- org.exolab.jmscts.core.meta.MetaData()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addClassMeta
     *
     * @param vClassMeta
     */
    public void addClassMeta(ClassMeta vClassMeta)
        throws IndexOutOfBoundsException
    {
        _classMetaList.add(vClassMeta);
    } //-- void addClassMeta(org.exolab.jmscts.core.meta.ClassMeta)

    /**
     * Method addClassMeta
     *
     * @param index
     * @param vClassMeta
     */
    public void addClassMeta(int index, ClassMeta vClassMeta)
        throws IndexOutOfBoundsException
    {
        _classMetaList.add(index, vClassMeta);
    } //-- void addClassMeta(int, org.exolab.jmscts.core.meta.ClassMeta)

    /**
     * Method clearClassMeta
     */
    public void clearClassMeta()
    {
        _classMetaList.clear();
    } //-- void clearClassMeta()

    /**
     * Method enumerateClassMeta
     */
    public java.util.Enumeration<?> enumerateClassMeta()
    {
        return new org.exolab.castor.util.IteratorEnumeration(_classMetaList.iterator());
    } //-- java.util.Enumeration enumerateClassMeta()

    /**
     * Note: hashCode() has not been overriden
     *
     * @param obj
     */
    public boolean equals(Object obj)
    {
        if ( this == obj )
            return true;

        if (obj instanceof MetaData) {

            MetaData temp = (MetaData)obj;
            if (this._classMetaList != null) {
                if (temp._classMetaList == null) return false;
                else if (!(this._classMetaList.equals(temp._classMetaList)))
                    return false;
            }
            else if (temp._classMetaList != null)
                return false;
            return true;
        }
        return false;
    } //-- boolean equals(java.lang.Object)

    /**
     * Method getClassMeta
     *
     * @param index
     */
    public ClassMeta getClassMeta(int index)
        throws IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _classMetaList.size())) {
            throw new IndexOutOfBoundsException();
        }

        return _classMetaList.get(index);
    } //-- org.exolab.jmscts.core.meta.ClassMeta getClassMeta(int)

    /**
     * Method getClassMeta
     */
    public ClassMeta[] getClassMeta()
    {
        int size = _classMetaList.size();
        ClassMeta[] mArray = new ClassMeta[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = _classMetaList.get(index);
        }
        return mArray;
    } //-- org.exolab.jmscts.core.meta.ClassMeta[] getClassMeta()

    /**
     * Method getClassMetaCount
     */
    public int getClassMetaCount()
    {
        return _classMetaList.size();
    } //-- int getClassMetaCount()

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
     * Method removeClassMeta
     *
     * @param vClassMeta
     */
    public boolean removeClassMeta(ClassMeta vClassMeta)
    {
        boolean removed = _classMetaList.remove(vClassMeta);
        return removed;
    } //-- boolean removeClassMeta(org.exolab.jmscts.core.meta.ClassMeta)

    /**
     * Method setClassMeta
     *
     * @param index
     * @param vClassMeta
     */
    public void setClassMeta(int index, ClassMeta vClassMeta)
        throws IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _classMetaList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _classMetaList.set(index, vClassMeta);
    } //-- void setClassMeta(int, org.exolab.jmscts.core.meta.ClassMeta)

    /**
     * Method setClassMeta
     *
     * @param classMetaArray
     */
    public void setClassMeta(ClassMeta[] classMetaArray)
    {
        //-- copy array
        _classMetaList.clear();
        for (int i = 0; i < classMetaArray.length; i++) {
            _classMetaList.add(classMetaArray[i]);
        }
    } //-- void setClassMeta(org.exolab.jmscts.core.meta.ClassMeta)

    /**
     * Method unmarshal
     *
     * @param reader
     */
    public static MetaData unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (MetaData) Unmarshaller.unmarshal(MetaData.class, reader);
    } //-- org.exolab.jmscts.core.meta.MetaData unmarshal(java.io.Reader)

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
