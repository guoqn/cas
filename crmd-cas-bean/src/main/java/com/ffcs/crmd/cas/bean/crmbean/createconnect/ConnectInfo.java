/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.crmbean.createconnect;

/**
 * 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ConnectInfo implements java.io.Serializable {

    private java.lang.String preOrderNumber;

    private java.lang.String custSoNumber;

    /**
     * 是否已经关联
     * 1--已关联
     * 2--未关联
     */
    private java.lang.String isRel;

    public ConnectInfo() {
        super();
    }

    /**
     * Returns the value of field 'custSoNumber'.
     * 
     * @return the value of field 'CustSoNumber'.
     */
    public java.lang.String getCustSoNumber() {
        return this.custSoNumber;
    }

    /**
     * Returns the value of field 'isRel'. The field 'isRel' has
     * the following description: 是否已经关联
     * 1--已关联
     * 2--未关联
     * 
     * @return the value of field 'IsRel'.
     */
    public java.lang.String getIsRel() {
        return this.isRel;
    }

    /**
     * Returns the value of field 'preOrderNumber'.
     * 
     * @return the value of field 'PreOrderNumber'.
     */
    public java.lang.String getPreOrderNumber() {
        return this.preOrderNumber;
    }

    /**
     * Sets the value of field 'custSoNumber'.
     * 
     * @param custSoNumber the value of field 'custSoNumber'.
     */
    public void setCustSoNumber(final java.lang.String custSoNumber) {
        this.custSoNumber = custSoNumber;
    }

    /**
     * Sets the value of field 'isRel'. The field 'isRel' has the
     * following description: 是否已经关联
     * 1--已关联
     * 2--未关联
     * 
     * @param isRel the value of field 'isRel'.
     */
    public void setIsRel(final java.lang.String isRel) {
        this.isRel = isRel;
    }

    /**
     * Sets the value of field 'preOrderNumber'.
     * 
     * @param preOrderNumber the value of field 'preOrderNumber'.
     */
    public void setPreOrderNumber(final java.lang.String preOrderNumber) {
        this.preOrderNumber = preOrderNumber;
    }

}
