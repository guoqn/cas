/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.query.querypreorderstatus;

/**
 * 状态信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class StatusInfo implements java.io.Serializable {

    /**
     * P单当前状态编码
     */
    private java.lang.String statusCd;

    /**
     * P单当前状态名称
     */
    private java.lang.String statusCdName;

    /**
     * P单在工单池当前状态编码
     */
    private java.lang.String poolStatusCd;

    /**
     * P单在工单池当前状态名称
     */
    private java.lang.String poolStatusCdName;

    /**
     * 状态原因描述，比如退单原因描述
     */
    private java.lang.String statusReasonDesc;

    /**
     * 状态原因编码，比如退单原因归类编码，便于统计数量
     */
    private java.lang.String statusReasonCd;

    /**
     * P单号
     */
    private java.lang.String preOrderNumber;

    /**
     * CRM订单ID
     */
    private java.lang.String custOrderId;

    /**
     * CRM订单号
     */
    private java.lang.String custSoNumber;

    /**
     * 收单时间
     */
    private java.lang.String acceptDate;

    /**
     * 退单时间
     */
    private java.lang.String returnDate;

    /**
     * 退单人员ID
     */
    private java.lang.String returnStaffId;

    /**
     * 退单人员工号
     */
    private java.lang.String returnStaffCode;

    /**
     * 退单人员姓名
     */
    private java.lang.String returnStaffName;

    /**
     * 退单人员联系号码
     */
    private java.lang.String returnStaffPhone;

    /**
     * 退单原因类型
     */
    private java.lang.String returnType;

    /**
     * 退单原因描述
     */
    private java.lang.String returnReason;

    /**
     * 退单信息备注
     */
    private java.lang.String returnRemark;

    public StatusInfo() {
        super();
    }

    /**
     * Returns the value of field 'acceptDate'. The field
     * 'acceptDate' has the following description: 收单时间
     * 
     * @return the value of field 'AcceptDate'.
     */
    public java.lang.String getAcceptDate() {
        return this.acceptDate;
    }

    /**
     * Returns the value of field 'custOrderId'. The field
     * 'custOrderId' has the following description: CRM订单ID
     * 
     * @return the value of field 'CustOrderId'.
     */
    public java.lang.String getCustOrderId() {
        return this.custOrderId;
    }

    /**
     * Returns the value of field 'custSoNumber'. The field
     * 'custSoNumber' has the following description: CRM订单号
     * 
     * @return the value of field 'CustSoNumber'.
     */
    public java.lang.String getCustSoNumber() {
        return this.custSoNumber;
    }

    /**
     * Returns the value of field 'poolStatusCd'. The field
     * 'poolStatusCd' has the following description: P单在工单池当前状态编码
     * 
     * @return the value of field 'PoolStatusCd'.
     */
    public java.lang.String getPoolStatusCd() {
        return this.poolStatusCd;
    }

    /**
     * Returns the value of field 'poolStatusCdName'. The field
     * 'poolStatusCdName' has the following description:
     * P单在工单池当前状态名称
     * 
     * @return the value of field 'PoolStatusCdName'.
     */
    public java.lang.String getPoolStatusCdName() {
        return this.poolStatusCdName;
    }

    /**
     * Returns the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: P单号
     * 
     * @return the value of field 'PreOrderNumber'.
     */
    public java.lang.String getPreOrderNumber() {
        return this.preOrderNumber;
    }

    /**
     * Returns the value of field 'returnDate'. The field
     * 'returnDate' has the following description: 退单时间
     * 
     * @return the value of field 'ReturnDate'.
     */
    public java.lang.String getReturnDate() {
        return this.returnDate;
    }

    /**
     * Returns the value of field 'returnReason'. The field
     * 'returnReason' has the following description: 退单原因描述
     * 
     * @return the value of field 'ReturnReason'.
     */
    public java.lang.String getReturnReason() {
        return this.returnReason;
    }

    /**
     * Returns the value of field 'returnRemark'. The field
     * 'returnRemark' has the following description: 退单信息备注
     * 
     * @return the value of field 'ReturnRemark'.
     */
    public java.lang.String getReturnRemark() {
        return this.returnRemark;
    }

    /**
     * Returns the value of field 'returnStaffCode'. The field
     * 'returnStaffCode' has the following description: 退单人员工号
     * 
     * @return the value of field 'ReturnStaffCode'.
     */
    public java.lang.String getReturnStaffCode() {
        return this.returnStaffCode;
    }

    /**
     * Returns the value of field 'returnStaffId'. The field
     * 'returnStaffId' has the following description: 退单人员ID
     * 
     * @return the value of field 'ReturnStaffId'.
     */
    public java.lang.String getReturnStaffId() {
        return this.returnStaffId;
    }

    /**
     * Returns the value of field 'returnStaffName'. The field
     * 'returnStaffName' has the following description: 退单人员姓名
     * 
     * @return the value of field 'ReturnStaffName'.
     */
    public java.lang.String getReturnStaffName() {
        return this.returnStaffName;
    }

    /**
     * Returns the value of field 'returnStaffPhone'. The field
     * 'returnStaffPhone' has the following description: 退单人员联系号码
     * 
     * @return the value of field 'ReturnStaffPhone'.
     */
    public java.lang.String getReturnStaffPhone() {
        return this.returnStaffPhone;
    }

    /**
     * Returns the value of field 'returnType'. The field
     * 'returnType' has the following description: 退单原因类型
     * 
     * @return the value of field 'ReturnType'.
     */
    public java.lang.String getReturnType() {
        return this.returnType;
    }

    /**
     * Returns the value of field 'statusCd'. The field 'statusCd'
     * has the following description: P单当前状态编码
     * 
     * @return the value of field 'StatusCd'.
     */
    public java.lang.String getStatusCd() {
        return this.statusCd;
    }

    /**
     * Returns the value of field 'statusCdName'. The field
     * 'statusCdName' has the following description: P单当前状态名称
     * 
     * @return the value of field 'StatusCdName'.
     */
    public java.lang.String getStatusCdName() {
        return this.statusCdName;
    }

    /**
     * Returns the value of field 'statusReasonCd'. The field
     * 'statusReasonCd' has the following description:
     * 状态原因编码，比如退单原因归类编码，便于统计数量
     * 
     * @return the value of field 'StatusReasonCd'.
     */
    public java.lang.String getStatusReasonCd() {
        return this.statusReasonCd;
    }

    /**
     * Returns the value of field 'statusReasonDesc'. The field
     * 'statusReasonDesc' has the following description:
     * 状态原因描述，比如退单原因描述
     * 
     * @return the value of field 'StatusReasonDesc'.
     */
    public java.lang.String getStatusReasonDesc() {
        return this.statusReasonDesc;
    }

    /**
     * Sets the value of field 'acceptDate'. The field 'acceptDate'
     * has the following description: 收单时间
     * 
     * @param acceptDate the value of field 'acceptDate'.
     */
    public void setAcceptDate(final java.lang.String acceptDate) {
        this.acceptDate = acceptDate;
    }

    /**
     * Sets the value of field 'custOrderId'. The field
     * 'custOrderId' has the following description: CRM订单ID
     * 
     * @param custOrderId the value of field 'custOrderId'.
     */
    public void setCustOrderId(final java.lang.String custOrderId) {
        this.custOrderId = custOrderId;
    }

    /**
     * Sets the value of field 'custSoNumber'. The field
     * 'custSoNumber' has the following description: CRM订单号
     * 
     * @param custSoNumber the value of field 'custSoNumber'.
     */
    public void setCustSoNumber(final java.lang.String custSoNumber) {
        this.custSoNumber = custSoNumber;
    }

    /**
     * Sets the value of field 'poolStatusCd'. The field
     * 'poolStatusCd' has the following description: P单在工单池当前状态编码
     * 
     * @param poolStatusCd the value of field 'poolStatusCd'.
     */
    public void setPoolStatusCd(final java.lang.String poolStatusCd) {
        this.poolStatusCd = poolStatusCd;
    }

    /**
     * Sets the value of field 'poolStatusCdName'. The field
     * 'poolStatusCdName' has the following description:
     * P单在工单池当前状态名称
     * 
     * @param poolStatusCdName the value of field 'poolStatusCdName'
     */
    public void setPoolStatusCdName(final java.lang.String poolStatusCdName) {
        this.poolStatusCdName = poolStatusCdName;
    }

    /**
     * Sets the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: P单号
     * 
     * @param preOrderNumber the value of field 'preOrderNumber'.
     */
    public void setPreOrderNumber(final java.lang.String preOrderNumber) {
        this.preOrderNumber = preOrderNumber;
    }

    /**
     * Sets the value of field 'returnDate'. The field 'returnDate'
     * has the following description: 退单时间
     * 
     * @param returnDate the value of field 'returnDate'.
     */
    public void setReturnDate(final java.lang.String returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * Sets the value of field 'returnReason'. The field
     * 'returnReason' has the following description: 退单原因描述
     * 
     * @param returnReason the value of field 'returnReason'.
     */
    public void setReturnReason(final java.lang.String returnReason) {
        this.returnReason = returnReason;
    }

    /**
     * Sets the value of field 'returnRemark'. The field
     * 'returnRemark' has the following description: 退单信息备注
     * 
     * @param returnRemark the value of field 'returnRemark'.
     */
    public void setReturnRemark(final java.lang.String returnRemark) {
        this.returnRemark = returnRemark;
    }

    /**
     * Sets the value of field 'returnStaffCode'. The field
     * 'returnStaffCode' has the following description: 退单人员工号
     * 
     * @param returnStaffCode the value of field 'returnStaffCode'.
     */
    public void setReturnStaffCode(final java.lang.String returnStaffCode) {
        this.returnStaffCode = returnStaffCode;
    }

    /**
     * Sets the value of field 'returnStaffId'. The field
     * 'returnStaffId' has the following description: 退单人员ID
     * 
     * @param returnStaffId the value of field 'returnStaffId'.
     */
    public void setReturnStaffId(final java.lang.String returnStaffId) {
        this.returnStaffId = returnStaffId;
    }

    /**
     * Sets the value of field 'returnStaffName'. The field
     * 'returnStaffName' has the following description: 退单人员姓名
     * 
     * @param returnStaffName the value of field 'returnStaffName'.
     */
    public void setReturnStaffName(final java.lang.String returnStaffName) {
        this.returnStaffName = returnStaffName;
    }

    /**
     * Sets the value of field 'returnStaffPhone'. The field
     * 'returnStaffPhone' has the following description: 退单人员联系号码
     * 
     * @param returnStaffPhone the value of field 'returnStaffPhone'
     */
    public void setReturnStaffPhone(final java.lang.String returnStaffPhone) {
        this.returnStaffPhone = returnStaffPhone;
    }

    /**
     * Sets the value of field 'returnType'. The field 'returnType'
     * has the following description: 退单原因类型
     * 
     * @param returnType the value of field 'returnType'.
     */
    public void setReturnType(final java.lang.String returnType) {
        this.returnType = returnType;
    }

    /**
     * Sets the value of field 'statusCd'. The field 'statusCd' has
     * the following description: P单当前状态编码
     * 
     * @param statusCd the value of field 'statusCd'.
     */
    public void setStatusCd(final java.lang.String statusCd) {
        this.statusCd = statusCd;
    }

    /**
     * Sets the value of field 'statusCdName'. The field
     * 'statusCdName' has the following description: P单当前状态名称
     * 
     * @param statusCdName the value of field 'statusCdName'.
     */
    public void setStatusCdName(final java.lang.String statusCdName) {
        this.statusCdName = statusCdName;
    }

    /**
     * Sets the value of field 'statusReasonCd'. The field
     * 'statusReasonCd' has the following description:
     * 状态原因编码，比如退单原因归类编码，便于统计数量
     * 
     * @param statusReasonCd the value of field 'statusReasonCd'.
     */
    public void setStatusReasonCd(final java.lang.String statusReasonCd) {
        this.statusReasonCd = statusReasonCd;
    }

    /**
     * Sets the value of field 'statusReasonDesc'. The field
     * 'statusReasonDesc' has the following description:
     * 状态原因描述，比如退单原因描述
     * 
     * @param statusReasonDesc the value of field 'statusReasonDesc'
     */
    public void setStatusReasonDesc(final java.lang.String statusReasonDesc) {
        this.statusReasonDesc = statusReasonDesc;
    }

}
