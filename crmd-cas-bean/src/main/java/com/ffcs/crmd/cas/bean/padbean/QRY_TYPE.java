/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.padbean;

/**
 * 请求类型
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class QRY_TYPE implements java.io.Serializable {

    /**
     * 请求类型
     */
    private java.lang.String TYPE;

    /**
     * 请求时间
     */
    private java.lang.String REQ_TIME;

    /**
     * 请求来源
     */
    private java.lang.String SYSTEM_CODE;

    public QRY_TYPE() {
        super();
    }

    /**
     * Returns the value of field 'REQ_TIME'. The field 'REQ_TIME'
     * has the following description: 请求时间
     * 
     * @return the value of field 'REQ_TIME'.
     */
    public java.lang.String getREQ_TIME() {
        return this.REQ_TIME;
    }

    /**
     * Returns the value of field 'SYSTEM_CODE'. The field
     * 'SYSTEM_CODE' has the following description: 请求来源
     * 
     * @return the value of field 'SYSTEM_CODE'.
     */
    public java.lang.String getSYSTEM_CODE() {
        return this.SYSTEM_CODE;
    }

    /**
     * Returns the value of field 'TYPE'. The field 'TYPE' has the
     * following description: 请求类型
     * 
     * @return the value of field 'TYPE'.
     */
    public java.lang.String getTYPE() {
        return this.TYPE;
    }

    /**
     * Sets the value of field 'REQ_TIME'. The field 'REQ_TIME' has
     * the following description: 请求时间
     * 
     * @param REQ_TIME the value of field 'REQ_TIME'.
     */
    public void setREQ_TIME(final java.lang.String REQ_TIME) {
        this.REQ_TIME = REQ_TIME;
    }

    /**
     * Sets the value of field 'SYSTEM_CODE'. The field
     * 'SYSTEM_CODE' has the following description: 请求来源
     * 
     * @param SYSTEM_CODE the value of field 'SYSTEM_CODE'.
     */
    public void setSYSTEM_CODE(final java.lang.String SYSTEM_CODE) {
        this.SYSTEM_CODE = SYSTEM_CODE;
    }

    /**
     * Sets the value of field 'TYPE'. The field 'TYPE' has the
     * following description: 请求类型
     * 
     * @param TYPE the value of field 'TYPE'.
     */
    public void setTYPE(final java.lang.String TYPE) {
        this.TYPE = TYPE;
    }

}
