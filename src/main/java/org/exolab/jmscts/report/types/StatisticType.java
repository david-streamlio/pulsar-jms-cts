/*
 * This class was automatically generated with
 * <a href="http://www.castor.org">Castor 0.9.4.3</a>, using an XML
 * Schema.
 * $Id$
 */

package org.exolab.jmscts.report.types;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Hashtable;

/**
 * Class StatisticType.
 *
 * @version $Revision$ $Date$
 */
public class StatisticType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * The send type
     */
    public static final int SEND_TYPE = 0;

    /**
     * The instance of the send type
     */
    public static final StatisticType SEND = new StatisticType(SEND_TYPE, "send");

    /**
     * The receive type
     */
    public static final int RECEIVE_TYPE = 1;

    /**
     * The instance of the receive type
     */
    public static final StatisticType RECEIVE = new StatisticType(RECEIVE_TYPE, "receive");

    /**
     * Field _memberTable
     */
    private static Hashtable<String, StatisticType> _memberTable = init();

    /**
     * Field type
     */
    private int type = -1;

    /**
     * Field stringValue
     */
    private String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private StatisticType(int type, String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- org.exolab.jmscts.report.types.StatisticType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerateReturns an enumeration of all possible
     * instances of StatisticType
     */
    public static java.util.Enumeration<StatisticType> enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate()

    /**
     * Method getTypeReturns the type of this StatisticType
     */
    public int getType()
    {
        return this.type;
    } //-- int getType()

    /**
     * Method init
     */
    private static Hashtable<String, StatisticType> init()
    {
        Hashtable<String, StatisticType> members = new Hashtable<String, StatisticType>();
        members.put("send", SEND);
        members.put("receive", RECEIVE);
        return members;
    } //-- java.util.Hashtable init()

    /**
     * Method toStringReturns the String representation of this
     * StatisticType
     */
    public String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString()

    /**
     * Method valueOfReturns a new StatisticType based on the given
     * String value.
     *
     * @param string
     */
    public static StatisticType valueOf(String string)
    {
        Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid StatisticType";
            throw new IllegalArgumentException(err);
        }
        return (StatisticType) obj;
    } //-- org.exolab.jmscts.report.types.StatisticType valueOf(java.lang.String)

}
