/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.modpresaleorder;

/**
 * 请求信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class InParam implements java.io.Serializable {

    /**
     * 预受理单号
     */
    private java.lang.String preOrderNumber;

    /**
     * 接收员工ID
     */
    private java.lang.String receiveStaffId;

    /**
     * 接收团队ID
     */
    private java.lang.String receiveOrgId;

    /**
     * 操作说明
     */
    private java.lang.String remark;

    public InParam() {
        super();
    }

    /**
     * Returns the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: 预受理单号
     * 
     * @return the value of field 'PreOrderNumber'.
     */
    public java.lang.String getPreOrderNumber() {
        return this.preOrderNumber;
    }

    /**
     * Returns the value of field 'receiveOrgId'. The field
     * 'receiveOrgId' has the following description: 接收团队ID
     * 
     * @return the value of field 'ReceiveOrgId'.
     */
    public java.lang.String getReceiveOrgId() {
        return this.receiveOrgId;
    }

    /**
     * Returns the value of field 'receiveStaffId'. The field
     * 'receiveStaffId' has the following description: 接收员工ID
     * 
     * @return the value of field 'ReceiveStaffId'.
     */
    public java.lang.String getReceiveStaffId() {
        return this.receiveStaffId;
    }

    /**
     * Returns the value of field 'remark'. The field 'remark' has
     * the following description: 操作说明
     * 
     * @return the value of field 'Remark'.
     */
    public java.lang.String getRemark() {
        return this.remark;
    }

    /**
     * Sets the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: 预受理单号
     * 
     * @param preOrderNumber the value of field 'preOrderNumber'.
     */
    public void setPreOrderNumber(final java.lang.String preOrderNumber) {
        this.preOrderNumber = preOrderNumber;
    }

    /**
     * Sets the value of field 'receiveOrgId'. The field
     * 'receiveOrgId' has the following description: 接收团队ID
     * 
     * @param receiveOrgId the value of field 'receiveOrgId'.
     */
    public void setReceiveOrgId(final java.lang.String receiveOrgId) {
        this.receiveOrgId = receiveOrgId;
    }

    /**
     * Sets the value of field 'receiveStaffId'. The field
     * 'receiveStaffId' has the following description: 接收员工ID
     * 
     * @param receiveStaffId the value of field 'receiveStaffId'.
     */
    public void setReceiveStaffId(final java.lang.String receiveStaffId) {
        this.receiveStaffId = receiveStaffId;
    }

    /**
     * Sets the value of field 'remark'. The field 'remark' has the
     * following description: 操作说明
     * 
     * @param remark the value of field 'remark'.
     */
    public void setRemark(final java.lang.String remark) {
        this.remark = remark;
    }

}
