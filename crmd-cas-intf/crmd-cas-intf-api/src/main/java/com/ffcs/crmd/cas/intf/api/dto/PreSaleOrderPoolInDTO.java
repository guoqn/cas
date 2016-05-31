/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.intf.api.dto;

/**
 * 预受理工单池信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PreSaleOrderPoolInDTO implements java.io.Serializable {
    /**
     * 预受理工单池ID
     */
    private long preSaleOrderPoolId;

    /**
     * 预受理订单ID
     */
    private String preOrderNumber;
    /**
     * 客户事件Id
     */
    private long custOrderId;


    /**
     * 员工ID
     */
    private long staffId;


    /**
     * 客户Id
     */
    private String remark;

    /**
     * 预受理订单流水
     */
    private long version;


    /**
     * 是否班长指派
     */
    private String isLeaderAssign;

    /**
     * 团队ID
     */
    private long orgId;


    /**
     * 锁定员工
     */
    private long acceptOrgId;


    /**
     * 受理类型
     */
    private String sceneType;

    /**
     * 业务分类
     */
    private String serviceType;

    /**
     * 优先级
     */
    private long priority;


    /**
     * 状态
     */
    private String statusCd;

    public PreSaleOrderPoolInDTO() {
        super();
    }


    /**
     * Returns the value of field 'acceptOrgId'. The field
     * 'acceptOrgId' has the following description: 锁定员工
     *
     * @return the value of field 'AcceptOrgId'.
     */
    public long getAcceptOrgId() {
        return this.acceptOrgId;
    }

    /**
     * Returns the value of field 'preOrderId'. The field
     * 'preOrderId' has the following description: 预受理订单ID
     *
     * @return the value of field 'PreOrderId'.
     */
    public String getPreOrderNumber() {
        return this.preOrderNumber;
    }
    /**
     * Returns the value of field 'custOrderId'. The field
     * 'custOrderId' has the following description: 客户事件Id
     *
     * @return the value of field 'CustOrderId'.
     */
    public long getCustOrderId() {
        return this.custOrderId;
    }

    /**
     * Returns the value of field 'isLeaderAssign'. The field
     * 'isLeaderAssign' has the following description: 是否班长指派
     *
     * @return the value of field 'IsLeaderAssign'.
     */
    public String getIsLeaderAssign() {
        return this.isLeaderAssign;
    }

    /**
     * Returns the value of field 'orgId'. The field 'orgId' has
     * the following description: 团队ID
     *
     * @return the value of field 'OrgId'.
     */
    public long getOrgId() {
        return this.orgId;
    }

    /**
     * Returns the value of field 'preSaleOrderPoolId'. The field
     * 'preSaleOrderPoolId' has the following description: 预受理工单池ID
     *
     * @return the value of field 'PreSaleOrderPoolId'.
     */
    public long getPreSaleOrderPoolId() {
        return this.preSaleOrderPoolId;
    }

    /**
     * Returns the value of field 'priority'. The field 'priority'
     * has the following description: 优先级
     *
     * @return the value of field 'Priority'.
     */
    public long getPriority() {
        return this.priority;
    }

    /**
     * Returns the value of field 'remark'. The field 'remark' has
     * the following description: 客户Id
     *
     * @return the value of field 'Remark'.
     */
    public String getRemark() {
        return this.remark;
    }

    /**
     * Returns the value of field 'sceneType'. The field
     * 'sceneType' has the following description: 受理类型
     *
     * @return the value of field 'SceneType'.
     */
    public String getSceneType() {
        return this.sceneType;
    }

    /**
     * Returns the value of field 'serviceType'. The field
     * 'serviceType' has the following description: 业务分类
     *
     * @return the value of field 'ServiceType'.
     */
    public String getServiceType() {
        return this.serviceType;
    }

    /**
     * Returns the value of field 'staffId'. The field 'staffId'
     * has the following description: 员工ID
     *
     * @return the value of field 'StaffId'.
     */
    public long getStaffId() {
        return this.staffId;
    }

    /**
     * Returns the value of field 'statusCd'. The field 'statusCd'
     * has the following description: 状态
     *
     * @return the value of field 'StatusCd'.
     */
    public String getStatusCd() {
        return this.statusCd;
    }

    /**
     * Returns the value of field 'version'. The field 'version'
     * has the following description: 预受理订单流水
     *
     * @return the value of field 'Version'.
     */
    public long getVersion() {
        return this.version;
    }

    /**
     * Sets the value of field 'acceptOrgId'. The field
     * 'acceptOrgId' has the following description: 锁定员工
     *
     * @param acceptOrgId the value of field 'acceptOrgId'.
     */
    public void setAcceptOrgId(final long acceptOrgId) {
        this.acceptOrgId = acceptOrgId;
    }

    /**
     * Sets the value of field 'custOrderId'. The field
     * 'custOrderId' has the following description: 客户事件Id
     *
     * @param custOrderId the value of field 'custOrderId'.
     */
    public void setCustOrderId(final long custOrderId) {
        this.custOrderId = custOrderId;
    }

    /**
     * Sets the value of field 'isLeaderAssign'. The field
     * 'isLeaderAssign' has the following description: 是否班长指派
     *
     * @param isLeaderAssign the value of field 'isLeaderAssign'.
     */
    public void setIsLeaderAssign(final String isLeaderAssign) {
        this.isLeaderAssign = isLeaderAssign;
    }

    /**
     * Sets the value of field 'orgId'. The field 'orgId' has the
     * following description: 团队ID
     *
     * @param orgId the value of field 'orgId'.
     */
    public void setOrgId(final long orgId) {
        this.orgId = orgId;
    }

    /**
     * Sets the value of field 'preSaleOrderPoolId'. The field
     * 'preSaleOrderPoolId' has the following description: 预受理工单池ID
     *
     * @param preSaleOrderPoolId the value of field
     * 'preSaleOrderPoolId'.
     */
    public void setPreSaleOrderPoolId(final long preSaleOrderPoolId) {
        this.preSaleOrderPoolId = preSaleOrderPoolId;
    }

    /**
     * Sets the value of field 'priority'. The field 'priority' has
     * the following description: 优先级
     *
     * @param priority the value of field 'priority'.
     */
    public void setPriority(final long priority) {
        this.priority = priority;
    }

    /**
     * Sets the value of field 'remark'. The field 'remark' has the
     * following description: 客户Id
     *
     * @param remark the value of field 'remark'.
     */
    public void setRemark(final String remark) {
        this.remark = remark;
    }

    /**
     * Sets the value of field 'sceneType'. The field 'sceneType'
     * has the following description: 受理类型
     *
     * @param sceneType the value of field 'sceneType'.
     */
    public void setSceneType(final String sceneType) {
        this.sceneType = sceneType;
    }

    /**
     * Sets the value of field 'serviceType'. The field
     * 'serviceType' has the following description: 业务分类
     *
     * @param serviceType the value of field 'serviceType'.
     */
    public void setServiceType(final String serviceType) {
        this.serviceType = serviceType;
    }

    /**
     * Sets the value of field 'staffId'. The field 'staffId' has
     * the following description: 员工ID
     *
     * @param staffId the value of field 'staffId'.
     */
    public void setStaffId(final long staffId) {
        this.staffId = staffId;
    }

    /**
     * Sets the value of field 'statusCd'. The field 'statusCd' has
     * the following description: 状态
     *
     * @param statusCd the value of field 'statusCd'.
     */
    public void setStatusCd(final String statusCd) {
        this.statusCd = statusCd;
    }

    /**
     * Sets the value of field 'version'. The field 'version' has
     * the following description: 预受理订单流水
     *
     * @param version the value of field 'version'.
     */
    public void setVersion(final long version) {
        this.version = version;
    }

    /**
     * Sets the value of field 'preOrderId'. The field 'preOrderId'
     * has the following description: 预受理订单ID
     *
     * @param preOrderId the value of field 'preOrderId'.
     */
    public void setPreOrderNumber(final String preOrderNumber) {
        this.preOrderNumber = preOrderNumber;
    }
}
