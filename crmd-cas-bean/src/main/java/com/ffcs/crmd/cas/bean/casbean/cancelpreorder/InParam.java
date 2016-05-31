/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.cancelpreorder;

/**
 * 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class InParam implements java.io.Serializable {

    /**
     * 预受理P订单号
     */
    private java.lang.String preOrderNumber;

    /**
     * 撤销标识
     * 1：表示撤销P订单
     * 其他值或者空表示不撤销P订单，仅仅将P单标识为已结单，而不做撤销
     */
    private java.lang.String cancelFlag;

    /**
     * 撤销员工
     */
    private java.lang.String staffId;

    /**
     * 撤销团队
     */
    private java.lang.String orgId;

    /**
     * 撤销员工岗位ID
     */
    private java.lang.String staffPositionId;

    /**
     * 撤销原因
     */
    private java.lang.String cancelReason;

    /**
     * 退款金额
     */
    private java.lang.String amount;

    public InParam() {
        super();
    }

    /**
     * Returns the value of field 'amount'. The field 'amount' has
     * the following description: 退款金额
     * 
     * @return the value of field 'Amount'.
     */
    public java.lang.String getAmount() {
        return this.amount;
    }

    /**
     * Returns the value of field 'cancelFlag'. The field
     * 'cancelFlag' has the following description: 撤销标识
     * 1：表示撤销P订单
     * 其他值或者空表示不撤销P订单，仅仅将P单标识为已结单，而不做撤销
     * 
     * @return the value of field 'CancelFlag'.
     */
    public java.lang.String getCancelFlag() {
        return this.cancelFlag;
    }

    /**
     * Returns the value of field 'cancelReason'. The field
     * 'cancelReason' has the following description: 撤销原因
     * 
     * @return the value of field 'CancelReason'.
     */
    public java.lang.String getCancelReason() {
        return this.cancelReason;
    }

    /**
     * Returns the value of field 'orgId'. The field 'orgId' has
     * the following description: 撤销团队
     * 
     * @return the value of field 'OrgId'.
     */
    public java.lang.String getOrgId() {
        return this.orgId;
    }

    /**
     * Returns the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: 预受理P订单号
     * 
     * @return the value of field 'PreOrderNumber'.
     */
    public java.lang.String getPreOrderNumber() {
        return this.preOrderNumber;
    }

    /**
     * Returns the value of field 'staffId'. The field 'staffId'
     * has the following description: 撤销员工
     * 
     * @return the value of field 'StaffId'.
     */
    public java.lang.String getStaffId() {
        return this.staffId;
    }

    /**
     * Returns the value of field 'staffPositionId'. The field
     * 'staffPositionId' has the following description: 撤销员工岗位ID
     * 
     * @return the value of field 'StaffPositionId'.
     */
    public java.lang.String getStaffPositionId() {
        return this.staffPositionId;
    }

    /**
     * Sets the value of field 'amount'. The field 'amount' has the
     * following description: 退款金额
     * 
     * @param amount the value of field 'amount'.
     */
    public void setAmount(final java.lang.String amount) {
        this.amount = amount;
    }

    /**
     * Sets the value of field 'cancelFlag'. The field 'cancelFlag'
     * has the following description: 撤销标识
     * 1：表示撤销P订单
     * 其他值或者空表示不撤销P订单，仅仅将P单标识为已结单，而不做撤销
     * 
     * @param cancelFlag the value of field 'cancelFlag'.
     */
    public void setCancelFlag(final java.lang.String cancelFlag) {
        this.cancelFlag = cancelFlag;
    }

    /**
     * Sets the value of field 'cancelReason'. The field
     * 'cancelReason' has the following description: 撤销原因
     * 
     * @param cancelReason the value of field 'cancelReason'.
     */
    public void setCancelReason(final java.lang.String cancelReason) {
        this.cancelReason = cancelReason;
    }

    /**
     * Sets the value of field 'orgId'. The field 'orgId' has the
     * following description: 撤销团队
     * 
     * @param orgId the value of field 'orgId'.
     */
    public void setOrgId(final java.lang.String orgId) {
        this.orgId = orgId;
    }

    /**
     * Sets the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: 预受理P订单号
     * 
     * @param preOrderNumber the value of field 'preOrderNumber'.
     */
    public void setPreOrderNumber(final java.lang.String preOrderNumber) {
        this.preOrderNumber = preOrderNumber;
    }

    /**
     * Sets the value of field 'staffId'. The field 'staffId' has
     * the following description: 撤销员工
     * 
     * @param staffId the value of field 'staffId'.
     */
    public void setStaffId(final java.lang.String staffId) {
        this.staffId = staffId;
    }

    /**
     * Sets the value of field 'staffPositionId'. The field
     * 'staffPositionId' has the following description: 撤销员工岗位ID
     * 
     * @param staffPositionId the value of field 'staffPositionId'.
     */
    public void setStaffPositionId(final java.lang.String staffPositionId) {
        this.staffPositionId = staffPositionId;
    }

}
