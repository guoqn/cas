/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderProc;

/**
 * 请求信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class InParam implements java.io.Serializable {

    /**
     * 团队
     */
    private java.lang.String orgId;

    /**
     * 本地网
     */
    private java.lang.String areaId;

    /**
     * 员工
     */
    private java.lang.String staffId;

    /**
     * 开始时间
     */
    private java.lang.String beginTime;

    /**
     * 结束时间
     */
    private java.lang.String endTime;

    public InParam() {
        super();
    }

    /**
     * Returns the value of field 'areaId'. The field 'areaId' has
     * the following description: 本地网
     * 
     * @return the value of field 'AreaId'.
     */
    public java.lang.String getAreaId() {
        return this.areaId;
    }

    /**
     * Returns the value of field 'beginTime'. The field
     * 'beginTime' has the following description: 开始时间
     * 
     * @return the value of field 'BeginTime'.
     */
    public java.lang.String getBeginTime() {
        return this.beginTime;
    }

    /**
     * Returns the value of field 'endTime'. The field 'endTime'
     * has the following description: 结束时间
     * 
     * @return the value of field 'EndTime'.
     */
    public java.lang.String getEndTime() {
        return this.endTime;
    }

    /**
     * Returns the value of field 'orgId'. The field 'orgId' has
     * the following description: 团队
     * 
     * @return the value of field 'OrgId'.
     */
    public java.lang.String getOrgId() {
        return this.orgId;
    }

    /**
     * Returns the value of field 'staffId'. The field 'staffId'
     * has the following description: 员工
     * 
     * @return the value of field 'StaffId'.
     */
    public java.lang.String getStaffId() {
        return this.staffId;
    }

    /**
     * Sets the value of field 'areaId'. The field 'areaId' has the
     * following description: 本地网
     * 
     * @param areaId the value of field 'areaId'.
     */
    public void setAreaId(final java.lang.String areaId) {
        this.areaId = areaId;
    }

    /**
     * Sets the value of field 'beginTime'. The field 'beginTime'
     * has the following description: 开始时间
     * 
     * @param beginTime the value of field 'beginTime'.
     */
    public void setBeginTime(final java.lang.String beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * Sets the value of field 'endTime'. The field 'endTime' has
     * the following description: 结束时间
     * 
     * @param endTime the value of field 'endTime'.
     */
    public void setEndTime(final java.lang.String endTime) {
        this.endTime = endTime;
    }

    /**
     * Sets the value of field 'orgId'. The field 'orgId' has the
     * following description: 团队
     * 
     * @param orgId the value of field 'orgId'.
     */
    public void setOrgId(final java.lang.String orgId) {
        this.orgId = orgId;
    }

    /**
     * Sets the value of field 'staffId'. The field 'staffId' has
     * the following description: 员工
     * 
     * @param staffId the value of field 'staffId'.
     */
    public void setStaffId(final java.lang.String staffId) {
        this.staffId = staffId;
    }

}
