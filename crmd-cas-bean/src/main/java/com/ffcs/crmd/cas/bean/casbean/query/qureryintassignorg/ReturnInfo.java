/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.query.qureryintassignorg;

/**
 * 工单池信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ReturnInfo implements java.io.Serializable {

    /**
     * 团队名称
     */
    private java.lang.String orgName;

    /**
     * 团队ID
     */
    private long orgId;

    /**
     * Keeps track of whether primitive field orgId has been set
     * already.
     */
    private boolean hasorgId;

    /**
     * 区域ID
     */
    private long commonReginId;

    /**
     * Keeps track of whether primitive field commonReginId has
     * been set already.
     */
    private boolean hascommonReginId;

    public ReturnInfo() {
        super();
    }

    /**
     */
    public void deleteCommonReginId() {
        this.hascommonReginId= false;
    }

    /**
     */
    public void deleteOrgId() {
        this.hasorgId= false;
    }

    /**
     * Returns the value of field 'commonReginId'. The field
     * 'commonReginId' has the following description: 区域ID
     * 
     * @return the value of field 'CommonReginId'.
     */
    public long getCommonReginId() {
        return this.commonReginId;
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
     * Returns the value of field 'orgName'. The field 'orgName'
     * has the following description: 团队名称
     * 
     * @return the value of field 'OrgName'.
     */
    public java.lang.String getOrgName() {
        return this.orgName;
    }

    /**
     * Method hasCommonReginId.
     * 
     * @return true if at least one CommonReginId has been added
     */
    public boolean hasCommonReginId() {
        return this.hascommonReginId;
    }

    /**
     * Method hasOrgId.
     * 
     * @return true if at least one OrgId has been added
     */
    public boolean hasOrgId() {
        return this.hasorgId;
    }

    /**
     * Sets the value of field 'commonReginId'. The field
     * 'commonReginId' has the following description: 区域ID
     * 
     * @param commonReginId the value of field 'commonReginId'.
     */
    public void setCommonReginId(final long commonReginId) {
        this.commonReginId = commonReginId;
        this.hascommonReginId = true;
    }

    /**
     * Sets the value of field 'orgId'. The field 'orgId' has the
     * following description: 团队ID
     * 
     * @param orgId the value of field 'orgId'.
     */
    public void setOrgId(final long orgId) {
        this.orgId = orgId;
        this.hasorgId = true;
    }

    /**
     * Sets the value of field 'orgName'. The field 'orgName' has
     * the following description: 团队名称
     * 
     * @param orgName the value of field 'orgName'.
     */
    public void setOrgName(final java.lang.String orgName) {
        this.orgName = orgName;
    }

}
