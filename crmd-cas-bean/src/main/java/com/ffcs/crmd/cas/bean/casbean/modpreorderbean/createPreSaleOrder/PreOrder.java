/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.modpreorderbean.createPreSaleOrder;

/**
 * P单信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PreOrder implements java.io.Serializable {

    /**
     * P单号
     */
    private String preOrderNumber;

    /**
     * P单受理入口
     */
    private String orderFrom;

    /**
     * 客户名称
     */
    private String custName;

    /**
     * 证件类型
     */
    private String certType;

    /**
     * 证件号码
     */
    private String certNumber;

    /**
     * 产品实例ID，拍照甩单可放空
     */
    private String prodInstId;

    /**
     * 甩单天翼号码
     */
    private String mobileTel;

    /**
     * 甩单固话号码
     */
    private String fixedTel;

    /**
     * P单受理团队
     */
    private String orgId;

    /**
     * P单受理团队名称
     */
    private String orgName;

    /**
     * P单受理人员
     */
    private String staffId;

    /**
     * P单受理人员名称
     */
    private String staffName;

    /**
     * P单受理团队C4区域
     */
    private String commonRegionId;

    /**
     * P单受理团队C4区域描述
     */
    private String regionName;

    /**
     * P单受理备注
     */
    private String remark;

    /**
     * P单状态
     */
    private String statusCd;

    /**
     * P单状态时间
     *  格式：YYYYMMDDHH24MISS
     */
    private String stateDate;

    public PreOrder() {
        super();
    }

    /**
     * Returns the value of field 'certNumber'. The field
     * 'certNumber' has the following description: 证件号码
     *
     * @return the value of field 'CertNumber'.
     */
    public String getCertNumber() {
        return this.certNumber;
    }

    /**
     * Returns the value of field 'certType'. The field 'certType'
     * has the following description: 证件类型
     *
     * @return the value of field 'CertType'.
     */
    public String getCertType() {
        return this.certType;
    }

    /**
     * Returns the value of field 'commonRegionId'. The field
     * 'commonRegionId' has the following description: P单受理团队C4区域
     *
     * @return the value of field 'CommonRegionId'.
     */
    public String getCommonRegionId() {
        return this.commonRegionId;
    }

    /**
     * Returns the value of field 'custName'. The field 'custName'
     * has the following description: 客户名称
     *
     * @return the value of field 'CustName'.
     */
    public String getCustName() {
        return this.custName;
    }

    /**
     * Returns the value of field 'fixedTel'. The field 'fixedTel'
     * has the following description: 甩单固话号码
     *
     * @return the value of field 'FixedTel'.
     */
    public String getFixedTel() {
        return this.fixedTel;
    }

    /**
     * Returns the value of field 'mobileTel'. The field
     * 'mobileTel' has the following description: 甩单天翼号码
     *
     * @return the value of field 'MobileTel'.
     */
    public String getMobileTel() {
        return this.mobileTel;
    }

    /**
     * Returns the value of field 'orderFrom'. The field
     * 'orderFrom' has the following description: P单受理入口
     *
     * @return the value of field 'OrderFrom'.
     */
    public String getOrderFrom() {
        return this.orderFrom;
    }

    /**
     * Returns the value of field 'orgId'. The field 'orgId' has
     * the following description: P单受理团队
     *
     * @return the value of field 'OrgId'.
     */
    public String getOrgId() {
        return this.orgId;
    }

    /**
     * Returns the value of field 'orgName'. The field 'orgName'
     * has the following description: P单受理团队名称
     *
     * @return the value of field 'OrgName'.
     */
    public String getOrgName() {
        return this.orgName;
    }

    /**
     * Returns the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: P单号
     *
     * @return the value of field 'PreOrderNumber'.
     */
    public String getPreOrderNumber() {
        return this.preOrderNumber;
    }

    /**
     * Returns the value of field 'prodInstId'. The field
     * 'prodInstId' has the following description: 产品实例ID，拍照甩单可放空
     *
     * @return the value of field 'ProdInstId'.
     */
    public String getProdInstId() {
        return this.prodInstId;
    }

    /**
     * Returns the value of field 'regionName'. The field
     * 'regionName' has the following description: P单受理团队C4区域描述
     *
     * @return the value of field 'RegionName'.
     */
    public String getRegionName() {
        return this.regionName;
    }

    /**
     * Returns the value of field 'remark'. The field 'remark' has
     * the following description: P单受理备注
     *
     * @return the value of field 'Remark'.
     */
    public String getRemark() {
        return this.remark;
    }

    /**
     * Returns the value of field 'staffId'. The field 'staffId'
     * has the following description: P单受理人员
     *
     * @return the value of field 'StaffId'.
     */
    public String getStaffId() {
        return this.staffId;
    }

    /**
     * Returns the value of field 'staffName'. The field
     * 'staffName' has the following description: P单受理人员名称
     *
     * @return the value of field 'StaffName'.
     */
    public String getStaffName() {
        return this.staffName;
    }

    /**
     * Returns the value of field 'stateDate'. The field
     * 'stateDate' has the following description: P单状态时间
     *  格式：YYYYMMDDHH24MISS
     *
     * @return the value of field 'StateDate'.
     */
    public String getStateDate() {
        return this.stateDate;
    }

    /**
     * Returns the value of field 'statusCd'. The field 'statusCd'
     * has the following description: P单状态
     *
     * @return the value of field 'StatusCd'.
     */
    public String getStatusCd() {
        return this.statusCd;
    }

    /**
     * Sets the value of field 'certNumber'. The field 'certNumber'
     * has the following description: 证件号码
     *
     * @param certNumber the value of field 'certNumber'.
     */
    public void setCertNumber(final String certNumber) {
        this.certNumber = certNumber;
    }

    /**
     * Sets the value of field 'certType'. The field 'certType' has
     * the following description: 证件类型
     *
     * @param certType the value of field 'certType'.
     */
    public void setCertType(final String certType) {
        this.certType = certType;
    }

    /**
     * Sets the value of field 'commonRegionId'. The field
     * 'commonRegionId' has the following description: P单受理团队C4区域
     *
     * @param commonRegionId the value of field 'commonRegionId'.
     */
    public void setCommonRegionId(final String commonRegionId) {
        this.commonRegionId = commonRegionId;
    }

    /**
     * Sets the value of field 'custName'. The field 'custName' has
     * the following description: 客户名称
     *
     * @param custName the value of field 'custName'.
     */
    public void setCustName(final String custName) {
        this.custName = custName;
    }

    /**
     * Sets the value of field 'fixedTel'. The field 'fixedTel' has
     * the following description: 甩单固话号码
     *
     * @param fixedTel the value of field 'fixedTel'.
     */
    public void setFixedTel(final String fixedTel) {
        this.fixedTel = fixedTel;
    }

    /**
     * Sets the value of field 'mobileTel'. The field 'mobileTel'
     * has the following description: 甩单天翼号码
     *
     * @param mobileTel the value of field 'mobileTel'.
     */
    public void setMobileTel(final String mobileTel) {
        this.mobileTel = mobileTel;
    }

    /**
     * Sets the value of field 'orderFrom'. The field 'orderFrom'
     * has the following description: P单受理入口
     *
     * @param orderFrom the value of field 'orderFrom'.
     */
    public void setOrderFrom(final String orderFrom) {
        this.orderFrom = orderFrom;
    }

    /**
     * Sets the value of field 'orgId'. The field 'orgId' has the
     * following description: P单受理团队
     *
     * @param orgId the value of field 'orgId'.
     */
    public void setOrgId(final String orgId) {
        this.orgId = orgId;
    }

    /**
     * Sets the value of field 'orgName'. The field 'orgName' has
     * the following description: P单受理团队名称
     *
     * @param orgName the value of field 'orgName'.
     */
    public void setOrgName(final String orgName) {
        this.orgName = orgName;
    }

    /**
     * Sets the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: P单号
     *
     * @param preOrderNumber the value of field 'preOrderNumber'.
     */
    public void setPreOrderNumber(final String preOrderNumber) {
        this.preOrderNumber = preOrderNumber;
    }

    /**
     * Sets the value of field 'prodInstId'. The field 'prodInstId'
     * has the following description: 产品实例ID，拍照甩单可放空
     *
     * @param prodInstId the value of field 'prodInstId'.
     */
    public void setProdInstId(final String prodInstId) {
        this.prodInstId = prodInstId;
    }

    /**
     * Sets the value of field 'regionName'. The field 'regionName'
     * has the following description: P单受理团队C4区域描述
     *
     * @param regionName the value of field 'regionName'.
     */
    public void setRegionName(final String regionName) {
        this.regionName = regionName;
    }

    /**
     * Sets the value of field 'remark'. The field 'remark' has the
     * following description: P单受理备注
     *
     * @param remark the value of field 'remark'.
     */
    public void setRemark(final String remark) {
        this.remark = remark;
    }

    /**
     * Sets the value of field 'staffId'. The field 'staffId' has
     * the following description: P单受理人员
     *
     * @param staffId the value of field 'staffId'.
     */
    public void setStaffId(final String staffId) {
        this.staffId = staffId;
    }

    /**
     * Sets the value of field 'staffName'. The field 'staffName'
     * has the following description: P单受理人员名称
     *
     * @param staffName the value of field 'staffName'.
     */
    public void setStaffName(final String staffName) {
        this.staffName = staffName;
    }

    /**
     * Sets the value of field 'stateDate'. The field 'stateDate'
     * has the following description: P单状态时间
     *  格式：YYYYMMDDHH24MISS
     *
     * @param stateDate the value of field 'stateDate'.
     */
    public void setStateDate(final String stateDate) {
        this.stateDate = stateDate;
    }

    /**
     * Sets the value of field 'statusCd'. The field 'statusCd' has
     * the following description: P单状态
     *
     * @param statusCd the value of field 'statusCd'.
     */
    public void setStatusCd(final String statusCd) {
        this.statusCd = statusCd;
    }

}
