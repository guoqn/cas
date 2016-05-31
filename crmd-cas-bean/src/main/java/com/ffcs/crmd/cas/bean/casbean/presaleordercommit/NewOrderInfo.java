/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.presaleordercommit;

/**
 * 订单确认信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class NewOrderInfo implements java.io.Serializable {

    /**
     * 关联的P订单号
     */
    private java.lang.String preOrderNumber;

    /**
     * 场景标识
     * normal：正常订单确认
     * cancel：订单撤销确认
     * 默认是normal
     */
    private java.lang.String actionCd;

    /**
     * 是否需要付费
     * 0--不需要
     * 1--需要
     */
    private java.lang.String isNeedPay;

    /**
     * 关联新的正式订单信息
     */
    private com.ffcs.crmd.cas.bean.casbean.presaleordercommit.CustOrderInfo custOrderInfo;

    /**
     * 是否有最后一张单标识
     */
    private java.lang.String ifEnd;

    /**
     * P单的目标状态
     */
    private java.lang.String preOrderStatus;

    /**
     * 处理员工
     */
    private java.lang.String handleStaffId;

    /**
     * 处理团队
     */
    private java.lang.String handleOrgId;

    public NewOrderInfo() {
        super();
    }

    /**
     * Returns the value of field 'actionCd'. The field 'actionCd'
     * has the following description: 场景标识
     * normal：正常订单确认
     * cancel：订单撤销确认
     * 默认是normal
     * 
     * @return the value of field 'ActionCd'.
     */
    public java.lang.String getActionCd() {
        return this.actionCd;
    }

    /**
     * Returns the value of field 'custOrderInfo'. The field
     * 'custOrderInfo' has the following description: 关联新的正式订单信息
     * 
     * @return the value of field 'CustOrderInfo'.
     */
    public com.ffcs.crmd.cas.bean.casbean.presaleordercommit.CustOrderInfo getCustOrderInfo() {
        return this.custOrderInfo;
    }

    /**
     * Returns the value of field 'handleOrgId'. The field
     * 'handleOrgId' has the following description: 处理团队
     * 
     * @return the value of field 'HandleOrgId'.
     */
    public java.lang.String getHandleOrgId() {
        return this.handleOrgId;
    }

    /**
     * Returns the value of field 'handleStaffId'. The field
     * 'handleStaffId' has the following description: 处理员工
     * 
     * @return the value of field 'HandleStaffId'.
     */
    public java.lang.String getHandleStaffId() {
        return this.handleStaffId;
    }

    /**
     * Returns the value of field 'ifEnd'. The field 'ifEnd' has
     * the following description: 是否有最后一张单标识
     * 
     * @return the value of field 'IfEnd'.
     */
    public java.lang.String getIfEnd() {
        return this.ifEnd;
    }

    /**
     * Returns the value of field 'isNeedPay'. The field
     * 'isNeedPay' has the following description: 是否需要付费
     * 0--不需要
     * 1--需要
     * 
     * @return the value of field 'IsNeedPay'.
     */
    public java.lang.String getIsNeedPay() {
        return this.isNeedPay;
    }

    /**
     * Returns the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: 关联的P订单号
     * 
     * @return the value of field 'PreOrderNumber'.
     */
    public java.lang.String getPreOrderNumber() {
        return this.preOrderNumber;
    }

    /**
     * Returns the value of field 'preOrderStatus'. The field
     * 'preOrderStatus' has the following description: P单的目标状态
     * 
     * @return the value of field 'PreOrderStatus'.
     */
    public java.lang.String getPreOrderStatus() {
        return this.preOrderStatus;
    }

    /**
     * Sets the value of field 'actionCd'. The field 'actionCd' has
     * the following description: 场景标识
     * normal：正常订单确认
     * cancel：订单撤销确认
     * 默认是normal
     * 
     * @param actionCd the value of field 'actionCd'.
     */
    public void setActionCd(final java.lang.String actionCd) {
        this.actionCd = actionCd;
    }

    /**
     * Sets the value of field 'custOrderInfo'. The field
     * 'custOrderInfo' has the following description: 关联新的正式订单信息
     * 
     * @param custOrderInfo the value of field 'custOrderInfo'.
     */
    public void setCustOrderInfo(final com.ffcs.crmd.cas.bean.casbean.presaleordercommit.CustOrderInfo custOrderInfo) {
        this.custOrderInfo = custOrderInfo;
    }

    /**
     * Sets the value of field 'handleOrgId'. The field
     * 'handleOrgId' has the following description: 处理团队
     * 
     * @param handleOrgId the value of field 'handleOrgId'.
     */
    public void setHandleOrgId(final java.lang.String handleOrgId) {
        this.handleOrgId = handleOrgId;
    }

    /**
     * Sets the value of field 'handleStaffId'. The field
     * 'handleStaffId' has the following description: 处理员工
     * 
     * @param handleStaffId the value of field 'handleStaffId'.
     */
    public void setHandleStaffId(final java.lang.String handleStaffId) {
        this.handleStaffId = handleStaffId;
    }

    /**
     * Sets the value of field 'ifEnd'. The field 'ifEnd' has the
     * following description: 是否有最后一张单标识
     * 
     * @param ifEnd the value of field 'ifEnd'.
     */
    public void setIfEnd(final java.lang.String ifEnd) {
        this.ifEnd = ifEnd;
    }

    /**
     * Sets the value of field 'isNeedPay'. The field 'isNeedPay'
     * has the following description: 是否需要付费
     * 0--不需要
     * 1--需要
     * 
     * @param isNeedPay the value of field 'isNeedPay'.
     */
    public void setIsNeedPay(final java.lang.String isNeedPay) {
        this.isNeedPay = isNeedPay;
    }

    /**
     * Sets the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: 关联的P订单号
     * 
     * @param preOrderNumber the value of field 'preOrderNumber'.
     */
    public void setPreOrderNumber(final java.lang.String preOrderNumber) {
        this.preOrderNumber = preOrderNumber;
    }

    /**
     * Sets the value of field 'preOrderStatus'. The field
     * 'preOrderStatus' has the following description: P单的目标状态
     * 
     * @param preOrderStatus the value of field 'preOrderStatus'.
     */
    public void setPreOrderStatus(final java.lang.String preOrderStatus) {
        this.preOrderStatus = preOrderStatus;
    }

}
