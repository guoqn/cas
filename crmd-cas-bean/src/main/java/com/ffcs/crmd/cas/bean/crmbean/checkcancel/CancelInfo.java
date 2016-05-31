/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.crmbean.checkcancel;

/**
 * 撤销信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CancelInfo implements java.io.Serializable {

    /**
     * keep 保留，即不撤销buyerCancel 用户撤销；sellerCancel
     *  局方撤销
     */
    private java.lang.String cancelType;

    /**
     * 撤销原因，用户撤销和局方撤销的时候要必填，PAD和CRM同时做限制
     *  
     */
    private java.lang.String cancelReason;

    public CancelInfo() {
        super();
    }

    /**
     * Returns the value of field 'cancelReason'. The field
     * 'cancelReason' has the following description:
     * 撤销原因，用户撤销和局方撤销的时候要必填，PAD和CRM同时做限制
     *  
     * 
     * @return the value of field 'CancelReason'.
     */
    public java.lang.String getCancelReason() {
        return this.cancelReason;
    }

    /**
     * Returns the value of field 'cancelType'. The field
     * 'cancelType' has the following description: keep
     * 保留，即不撤销buyerCancel 用户撤销；sellerCancel
     *  局方撤销
     * 
     * @return the value of field 'CancelType'.
     */
    public java.lang.String getCancelType() {
        return this.cancelType;
    }

    /**
     * Sets the value of field 'cancelReason'. The field
     * 'cancelReason' has the following description:
     * 撤销原因，用户撤销和局方撤销的时候要必填，PAD和CRM同时做限制
     *  
     * 
     * @param cancelReason the value of field 'cancelReason'.
     */
    public void setCancelReason(final java.lang.String cancelReason) {
        this.cancelReason = cancelReason;
    }

    /**
     * Sets the value of field 'cancelType'. The field 'cancelType'
     * has the following description: keep 保留，即不撤销buyerCancel
     * 用户撤销；sellerCancel
     *  局方撤销
     * 
     * @param cancelType the value of field 'cancelType'.
     */
    public void setCancelType(final java.lang.String cancelType) {
        this.cancelType = cancelType;
    }

}
