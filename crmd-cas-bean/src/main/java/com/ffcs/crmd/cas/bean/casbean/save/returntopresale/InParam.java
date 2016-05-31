/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.save.returntopresale;

/**
 * 请求信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class InParam implements java.io.Serializable {

    /**
     * P订单号
     */
    private java.lang.String preOrderNumber;

    /**
     * 退单员工ID
     */
    private java.lang.String handleStaffId;

    /**
     * 退单原因类型
     */
    private java.lang.String reasonType;

    /**
     * 退单原因
     */
    private java.lang.String reason;

    /**
     * 退单来源标识
     * pool：工单接收界面退单
     * audit：退单稽核界面退单
     * 默认pool
     */
    private java.lang.String srcFlag;

    public InParam() {
        super();
    }

    /**
     * Returns the value of field 'handleStaffId'. The field
     * 'handleStaffId' has the following description: 退单员工ID
     * 
     * @return the value of field 'HandleStaffId'.
     */
    public java.lang.String getHandleStaffId() {
        return this.handleStaffId;
    }

    /**
     * Returns the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: P订单号
     * 
     * @return the value of field 'PreOrderNumber'.
     */
    public java.lang.String getPreOrderNumber() {
        return this.preOrderNumber;
    }

    /**
     * Returns the value of field 'reason'. The field 'reason' has
     * the following description: 退单原因
     * 
     * @return the value of field 'Reason'.
     */
    public java.lang.String getReason() {
        return this.reason;
    }

    /**
     * Returns the value of field 'reasonType'. The field
     * 'reasonType' has the following description: 退单原因类型
     * 
     * @return the value of field 'ReasonType'.
     */
    public java.lang.String getReasonType() {
        return this.reasonType;
    }

    /**
     * Returns the value of field 'srcFlag'. The field 'srcFlag'
     * has the following description: 退单来源标识
     * pool：工单接收界面退单
     * audit：退单稽核界面退单
     * 默认pool
     * 
     * @return the value of field 'SrcFlag'.
     */
    public java.lang.String getSrcFlag() {
        return this.srcFlag;
    }

    /**
     * Sets the value of field 'handleStaffId'. The field
     * 'handleStaffId' has the following description: 退单员工ID
     * 
     * @param handleStaffId the value of field 'handleStaffId'.
     */
    public void setHandleStaffId(final java.lang.String handleStaffId) {
        this.handleStaffId = handleStaffId;
    }

    /**
     * Sets the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: P订单号
     * 
     * @param preOrderNumber the value of field 'preOrderNumber'.
     */
    public void setPreOrderNumber(final java.lang.String preOrderNumber) {
        this.preOrderNumber = preOrderNumber;
    }

    /**
     * Sets the value of field 'reason'. The field 'reason' has the
     * following description: 退单原因
     * 
     * @param reason the value of field 'reason'.
     */
    public void setReason(final java.lang.String reason) {
        this.reason = reason;
    }

    /**
     * Sets the value of field 'reasonType'. The field 'reasonType'
     * has the following description: 退单原因类型
     * 
     * @param reasonType the value of field 'reasonType'.
     */
    public void setReasonType(final java.lang.String reasonType) {
        this.reasonType = reasonType;
    }

    /**
     * Sets the value of field 'srcFlag'. The field 'srcFlag' has
     * the following description: 退单来源标识
     * pool：工单接收界面退单
     * audit：退单稽核界面退单
     * 默认pool
     * 
     * @param srcFlag the value of field 'srcFlag'.
     */
    public void setSrcFlag(final java.lang.String srcFlag) {
        this.srcFlag = srcFlag;
    }

}
