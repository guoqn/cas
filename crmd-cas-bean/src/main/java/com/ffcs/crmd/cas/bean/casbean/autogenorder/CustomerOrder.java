/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.autogenorder;

/**
 * 发展人信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CustomerOrder implements java.io.Serializable {

    /**
     * 发展人工号
     */
    private java.lang.String devStaffCode;

    /**
     * 组织名称
     */
    private java.lang.String devOrgName;

    /**
     * 订单备注
     */
    private java.lang.String remark;

    /**
     * 预收费用
     * 单位：分
     */
    private java.lang.String preFeeAmount;

    public CustomerOrder() {
        super();
    }

    /**
     * Returns the value of field 'devOrgName'. The field
     * 'devOrgName' has the following description: 组织名称
     * 
     * @return the value of field 'DevOrgName'.
     */
    public java.lang.String getDevOrgName() {
        return this.devOrgName;
    }

    /**
     * Returns the value of field 'devStaffCode'. The field
     * 'devStaffCode' has the following description: 发展人工号
     * 
     * @return the value of field 'DevStaffCode'.
     */
    public java.lang.String getDevStaffCode() {
        return this.devStaffCode;
    }

    /**
     * Returns the value of field 'preFeeAmount'. The field
     * 'preFeeAmount' has the following description: 预收费用
     * 单位：分
     * 
     * @return the value of field 'PreFeeAmount'.
     */
    public java.lang.String getPreFeeAmount() {
        return this.preFeeAmount;
    }

    /**
     * Returns the value of field 'remark'. The field 'remark' has
     * the following description: 订单备注
     * 
     * @return the value of field 'Remark'.
     */
    public java.lang.String getRemark() {
        return this.remark;
    }

    /**
     * Sets the value of field 'devOrgName'. The field 'devOrgName'
     * has the following description: 组织名称
     * 
     * @param devOrgName the value of field 'devOrgName'.
     */
    public void setDevOrgName(final java.lang.String devOrgName) {
        this.devOrgName = devOrgName;
    }

    /**
     * Sets the value of field 'devStaffCode'. The field
     * 'devStaffCode' has the following description: 发展人工号
     * 
     * @param devStaffCode the value of field 'devStaffCode'.
     */
    public void setDevStaffCode(final java.lang.String devStaffCode) {
        this.devStaffCode = devStaffCode;
    }

    /**
     * Sets the value of field 'preFeeAmount'. The field
     * 'preFeeAmount' has the following description: 预收费用
     * 单位：分
     * 
     * @param preFeeAmount the value of field 'preFeeAmount'.
     */
    public void setPreFeeAmount(final java.lang.String preFeeAmount) {
        this.preFeeAmount = preFeeAmount;
    }

    /**
     * Sets the value of field 'remark'. The field 'remark' has the
     * following description: 订单备注
     * 
     * @param remark the value of field 'remark'.
     */
    public void setRemark(final java.lang.String remark) {
        this.remark = remark;
    }

}
