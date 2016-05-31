/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.padbean;

/**
 * 错误信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ERROR implements java.io.Serializable {

    /**
     * 错误标识
     */
    private java.lang.String ID;

    /**
     * 错误信息
     */
    private java.lang.String MESSAGE;

    public ERROR() {
        super();
    }

    /**
     * Returns the value of field 'ID'. The field 'ID' has the
     * following description: 错误标识
     * 
     * @return the value of field 'ID'.
     */
    public java.lang.String getID() {
        return this.ID;
    }

    /**
     * Returns the value of field 'MESSAGE'. The field 'MESSAGE'
     * has the following description: 错误信息
     * 
     * @return the value of field 'MESSAGE'.
     */
    public java.lang.String getMESSAGE() {
        return this.MESSAGE;
    }

    /**
     * Sets the value of field 'ID'. The field 'ID' has the
     * following description: 错误标识
     * 
     * @param ID the value of field 'ID'.
     */
    public void setID(final java.lang.String ID) {
        this.ID = ID;
    }

    /**
     * Sets the value of field 'MESSAGE'. The field 'MESSAGE' has
     * the following description: 错误信息
     * 
     * @param MESSAGE the value of field 'MESSAGE'.
     */
    public void setMESSAGE(final java.lang.String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

}
