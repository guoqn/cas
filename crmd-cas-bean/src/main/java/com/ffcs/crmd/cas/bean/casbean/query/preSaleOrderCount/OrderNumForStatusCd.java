/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.query.preSaleOrderCount;

/**
 * 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class OrderNumForStatusCd implements java.io.Serializable {

    /**
     * P单状态
     */
    private java.lang.String statusCd;

    /**
     * P单数量
     */
    private java.lang.String preOrderNum;

    public OrderNumForStatusCd() {
        super();
    }

    /**
     * Returns the value of field 'preOrderNum'. The field
     * 'preOrderNum' has the following description: P单数量
     * 
     * @return the value of field 'PreOrderNum'.
     */
    public java.lang.String getPreOrderNum() {
        return this.preOrderNum;
    }

    /**
     * Returns the value of field 'statusCd'. The field 'statusCd'
     * has the following description: P单状态
     * 
     * @return the value of field 'StatusCd'.
     */
    public java.lang.String getStatusCd() {
        return this.statusCd;
    }

    /**
     * Sets the value of field 'preOrderNum'. The field
     * 'preOrderNum' has the following description: P单数量
     * 
     * @param preOrderNum the value of field 'preOrderNum'.
     */
    public void setPreOrderNum(final java.lang.String preOrderNum) {
        this.preOrderNum = preOrderNum;
    }

    /**
     * Sets the value of field 'statusCd'. The field 'statusCd' has
     * the following description: P单状态
     * 
     * @param statusCd the value of field 'statusCd'.
     */
    public void setStatusCd(final java.lang.String statusCd) {
        this.statusCd = statusCd;
    }

}
