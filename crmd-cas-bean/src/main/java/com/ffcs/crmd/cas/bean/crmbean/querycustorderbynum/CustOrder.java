/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.crmbean.querycustorderbynum;

/**
 * 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CustOrder implements java.io.Serializable {

    /**
     * 客户ID
     */
    private long custId;

    /**
     * Keeps track of whether primitive field custId has been set
     * already.
     */
    private boolean hascustId;

    /**
     * 订单类型
     */
    private java.lang.String orderType;

    /**
     * 渠道ID
     */
    private long channelId;

    /**
     * Keeps track of whether primitive field channelId has been
     * set already.
     */
    private boolean haschannelId;

    /**
     * 组织ID
     */
    private long orgId;

    /**
     * Keeps track of whether primitive field orgId has been set
     * already.
     */
    private boolean hasorgId;

    /**
     * C3区域
     */
    private long areaId;

    /**
     * Keeps track of whether primitive field areaId has been set
     * already.
     */
    private boolean hasareaId;

    /**
     * 区域id
     */
    private long regionCd;

    /**
     * Keeps track of whether primitive field regionCd has been set
     * already.
     */
    private boolean hasregionCd;

    /**
     * 订单ID
     */
    private long custOrderId;

    /**
     * Keeps track of whether primitive field custOrderId has been
     * set already.
     */
    private boolean hascustOrderId;

    /**
     * 是否历史表
     */
    private java.lang.String isHis;

    /**
     * 订单流水号
     */
    private java.lang.String custSoNumber;

    public CustOrder() {
        super();
    }

    /**
     */
    public void deleteAreaId() {
        this.hasareaId= false;
    }

    /**
     */
    public void deleteChannelId() {
        this.haschannelId= false;
    }

    /**
     */
    public void deleteCustId() {
        this.hascustId= false;
    }

    /**
     */
    public void deleteCustOrderId() {
        this.hascustOrderId= false;
    }

    /**
     */
    public void deleteOrgId() {
        this.hasorgId= false;
    }

    /**
     */
    public void deleteRegionCd() {
        this.hasregionCd= false;
    }

    /**
     * Returns the value of field 'areaId'. The field 'areaId' has
     * the following description: C3区域
     * 
     * @return the value of field 'AreaId'.
     */
    public long getAreaId() {
        return this.areaId;
    }

    /**
     * Returns the value of field 'channelId'. The field
     * 'channelId' has the following description: 渠道ID
     * 
     * @return the value of field 'ChannelId'.
     */
    public long getChannelId() {
        return this.channelId;
    }

    /**
     * Returns the value of field 'custId'. The field 'custId' has
     * the following description: 客户ID
     * 
     * @return the value of field 'CustId'.
     */
    public long getCustId() {
        return this.custId;
    }

    /**
     * Returns the value of field 'custOrderId'. The field
     * 'custOrderId' has the following description: 订单ID
     * 
     * @return the value of field 'CustOrderId'.
     */
    public long getCustOrderId() {
        return this.custOrderId;
    }

    /**
     * Returns the value of field 'custSoNumber'. The field
     * 'custSoNumber' has the following description: 订单流水号
     * 
     * @return the value of field 'CustSoNumber'.
     */
    public java.lang.String getCustSoNumber() {
        return this.custSoNumber;
    }

    /**
     * Returns the value of field 'isHis'. The field 'isHis' has
     * the following description: 是否历史表
     * 
     * @return the value of field 'IsHis'.
     */
    public java.lang.String getIsHis() {
        return this.isHis;
    }

    /**
     * Returns the value of field 'orderType'. The field
     * 'orderType' has the following description: 订单类型
     * 
     * @return the value of field 'OrderType'.
     */
    public java.lang.String getOrderType() {
        return this.orderType;
    }

    /**
     * Returns the value of field 'orgId'. The field 'orgId' has
     * the following description: 组织ID
     * 
     * @return the value of field 'OrgId'.
     */
    public long getOrgId() {
        return this.orgId;
    }

    /**
     * Returns the value of field 'regionCd'. The field 'regionCd'
     * has the following description: 区域id
     * 
     * @return the value of field 'RegionCd'.
     */
    public long getRegionCd() {
        return this.regionCd;
    }

    /**
     * Method hasAreaId.
     * 
     * @return true if at least one AreaId has been added
     */
    public boolean hasAreaId() {
        return this.hasareaId;
    }

    /**
     * Method hasChannelId.
     * 
     * @return true if at least one ChannelId has been added
     */
    public boolean hasChannelId() {
        return this.haschannelId;
    }

    /**
     * Method hasCustId.
     * 
     * @return true if at least one CustId has been added
     */
    public boolean hasCustId() {
        return this.hascustId;
    }

    /**
     * Method hasCustOrderId.
     * 
     * @return true if at least one CustOrderId has been added
     */
    public boolean hasCustOrderId() {
        return this.hascustOrderId;
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
     * Method hasRegionCd.
     * 
     * @return true if at least one RegionCd has been added
     */
    public boolean hasRegionCd() {
        return this.hasregionCd;
    }

    /**
     * Sets the value of field 'areaId'. The field 'areaId' has the
     * following description: C3区域
     * 
     * @param areaId the value of field 'areaId'.
     */
    public void setAreaId(final long areaId) {
        this.areaId = areaId;
        this.hasareaId = true;
    }

    /**
     * Sets the value of field 'channelId'. The field 'channelId'
     * has the following description: 渠道ID
     * 
     * @param channelId the value of field 'channelId'.
     */
    public void setChannelId(final long channelId) {
        this.channelId = channelId;
        this.haschannelId = true;
    }

    /**
     * Sets the value of field 'custId'. The field 'custId' has the
     * following description: 客户ID
     * 
     * @param custId the value of field 'custId'.
     */
    public void setCustId(final long custId) {
        this.custId = custId;
        this.hascustId = true;
    }

    /**
     * Sets the value of field 'custOrderId'. The field
     * 'custOrderId' has the following description: 订单ID
     * 
     * @param custOrderId the value of field 'custOrderId'.
     */
    public void setCustOrderId(final long custOrderId) {
        this.custOrderId = custOrderId;
        this.hascustOrderId = true;
    }

    /**
     * Sets the value of field 'custSoNumber'. The field
     * 'custSoNumber' has the following description: 订单流水号
     * 
     * @param custSoNumber the value of field 'custSoNumber'.
     */
    public void setCustSoNumber(final java.lang.String custSoNumber) {
        this.custSoNumber = custSoNumber;
    }

    /**
     * Sets the value of field 'isHis'. The field 'isHis' has the
     * following description: 是否历史表
     * 
     * @param isHis the value of field 'isHis'.
     */
    public void setIsHis(final java.lang.String isHis) {
        this.isHis = isHis;
    }

    /**
     * Sets the value of field 'orderType'. The field 'orderType'
     * has the following description: 订单类型
     * 
     * @param orderType the value of field 'orderType'.
     */
    public void setOrderType(final java.lang.String orderType) {
        this.orderType = orderType;
    }

    /**
     * Sets the value of field 'orgId'. The field 'orgId' has the
     * following description: 组织ID
     * 
     * @param orgId the value of field 'orgId'.
     */
    public void setOrgId(final long orgId) {
        this.orgId = orgId;
        this.hasorgId = true;
    }

    /**
     * Sets the value of field 'regionCd'. The field 'regionCd' has
     * the following description: 区域id
     * 
     * @param regionCd the value of field 'regionCd'.
     */
    public void setRegionCd(final long regionCd) {
        this.regionCd = regionCd;
        this.hasregionCd = true;
    }

}
