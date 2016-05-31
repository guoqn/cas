/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderOverTimeList;

/**
 * 处理过程信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PreSaleOrderDetail implements java.io.Serializable {

    /**
     * p单号
     */
    private java.lang.String preOrderNumber;

    /**
     * 工单认领人
     */
    private java.lang.String poolStaffId;

    /**
     * 认领人名称
     */
    private java.lang.String poolStaffName;

    /**
     * 工单完成标识:poolStatusCd=12000
     */
    private java.lang.String statusCd;

    /**
     * 工单认领时间
     */
    private java.lang.String poolAcceptDate;

    /**
     * 最后受理时间
     */
    private java.lang.String poolStatusDate;

    private java.lang.String poolCreateDate;

    public PreSaleOrderDetail() {
        super();
    }

    /**
     * Returns the value of field 'poolAcceptDate'. The field
     * 'poolAcceptDate' has the following description: 工单认领时间
     * 
     * @return the value of field 'PoolAcceptDate'.
     */
    public java.lang.String getPoolAcceptDate() {
        return this.poolAcceptDate;
    }

    /**
     * Returns the value of field 'poolCreateDate'.
     * 
     * @return the value of field 'PoolCreateDate'.
     */
    public java.lang.String getPoolCreateDate() {
        return this.poolCreateDate;
    }

    /**
     * Returns the value of field 'poolStaffId'. The field
     * 'poolStaffId' has the following description: 工单认领人
     * 
     * @return the value of field 'PoolStaffId'.
     */
    public java.lang.String getPoolStaffId() {
        return this.poolStaffId;
    }

    /**
     * Returns the value of field 'poolStaffName'. The field
     * 'poolStaffName' has the following description: 认领人名称
     * 
     * @return the value of field 'PoolStaffName'.
     */
    public java.lang.String getPoolStaffName() {
        return this.poolStaffName;
    }

    /**
     * Returns the value of field 'poolStatusDate'. The field
     * 'poolStatusDate' has the following description: 最后受理时间
     * 
     * @return the value of field 'PoolStatusDate'.
     */
    public java.lang.String getPoolStatusDate() {
        return this.poolStatusDate;
    }

    /**
     * Returns the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: p单号
     * 
     * @return the value of field 'PreOrderNumber'.
     */
    public java.lang.String getPreOrderNumber() {
        return this.preOrderNumber;
    }

    /**
     * Returns the value of field 'statusCd'. The field 'statusCd'
     * has the following description: 工单完成标识:poolStatusCd=12000
     * 
     * @return the value of field 'StatusCd'.
     */
    public java.lang.String getStatusCd() {
        return this.statusCd;
    }

    /**
     * Sets the value of field 'poolAcceptDate'. The field
     * 'poolAcceptDate' has the following description: 工单认领时间
     * 
     * @param poolAcceptDate the value of field 'poolAcceptDate'.
     */
    public void setPoolAcceptDate(final java.lang.String poolAcceptDate) {
        this.poolAcceptDate = poolAcceptDate;
    }

    /**
     * Sets the value of field 'poolCreateDate'.
     * 
     * @param poolCreateDate the value of field 'poolCreateDate'.
     */
    public void setPoolCreateDate(final java.lang.String poolCreateDate) {
        this.poolCreateDate = poolCreateDate;
    }

    /**
     * Sets the value of field 'poolStaffId'. The field
     * 'poolStaffId' has the following description: 工单认领人
     * 
     * @param poolStaffId the value of field 'poolStaffId'.
     */
    public void setPoolStaffId(final java.lang.String poolStaffId) {
        this.poolStaffId = poolStaffId;
    }

    /**
     * Sets the value of field 'poolStaffName'. The field
     * 'poolStaffName' has the following description: 认领人名称
     * 
     * @param poolStaffName the value of field 'poolStaffName'.
     */
    public void setPoolStaffName(final java.lang.String poolStaffName) {
        this.poolStaffName = poolStaffName;
    }

    /**
     * Sets the value of field 'poolStatusDate'. The field
     * 'poolStatusDate' has the following description: 最后受理时间
     * 
     * @param poolStatusDate the value of field 'poolStatusDate'.
     */
    public void setPoolStatusDate(final java.lang.String poolStatusDate) {
        this.poolStatusDate = poolStatusDate;
    }

    /**
     * Sets the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: p单号
     * 
     * @param preOrderNumber the value of field 'preOrderNumber'.
     */
    public void setPreOrderNumber(final java.lang.String preOrderNumber) {
        this.preOrderNumber = preOrderNumber;
    }

    /**
     * Sets the value of field 'statusCd'. The field 'statusCd' has
     * the following description: 工单完成标识:poolStatusCd=12000
     * 
     * @param statusCd the value of field 'statusCd'.
     */
    public void setStatusCd(final java.lang.String statusCd) {
        this.statusCd = statusCd;
    }

}
