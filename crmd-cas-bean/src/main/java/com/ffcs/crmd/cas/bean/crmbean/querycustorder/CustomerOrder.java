/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.crmbean.querycustorder;

/**
 * 客户订单信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CustomerOrder implements java.io.Serializable {

    /**
     * 订单id
     */
    private java.lang.String customerOrderId;

    /**
     * 订单流水号
     */
    private java.lang.String custSoNumber;

    /**
     * 状态
     */
    private java.lang.String statusCd;

    /**
     * 状态名称
     */
    private java.lang.String statusCdName;

    /**
     * 订单类型
     */
    private java.lang.String orderType;

    /**
     * 客户名称
     */
    private java.lang.String custName;

    /**
     * 受理时间
     */
    private java.lang.String createDate;

    /**
     * 0--不是
     * 1--是
     */
    private java.lang.String isQuitOrder;

    /**
     * 客户ID
     */
    private java.lang.String custId;

    /**
     * 订单类型
     */
    private java.lang.String custOrderType;

    /**
     * 渠道ID
     */
    private java.lang.String channelId;

    /**
     * 组织ID
     */
    private java.lang.String orgId;

    /**
     * 区域ID
     */
    private java.lang.String areaId;

    /**
     * C4区域
     */
    private java.lang.String regionCd;

    public CustomerOrder() {
        super();
    }

    /**
     * Returns the value of field 'createDate'. The field
     * 'createDate' has the following description: 受理时间
     * 
     * @return the value of field 'CreateDate'.
     */
    public java.lang.String getCreateDate() {
        return this.createDate;
    }

    /**
     * Returns the value of field 'custName'. The field 'custName'
     * has the following description: 客户名称
     * 
     * @return the value of field 'CustName'.
     */
    public java.lang.String getCustName() {
        return this.custName;
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
     * Returns the value of field 'customerOrderId'. The field
     * 'customerOrderId' has the following description: 订单id
     * 
     * @return the value of field 'CustomerOrderId'.
     */
    public java.lang.String getCustomerOrderId() {
        return this.customerOrderId;
    }

    /**
     * Returns the value of field 'isQuitOrder'. The field
     * 'isQuitOrder' has the following description: 0--不是
     * 1--是
     * 
     * @return the value of field 'IsQuitOrder'.
     */
    public java.lang.String getIsQuitOrder() {
        return this.isQuitOrder;
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
     * Returns the value of field 'statusCd'. The field 'statusCd'
     * has the following description: 状态
     * 
     * @return the value of field 'StatusCd'.
     */
    public java.lang.String getStatusCd() {
        return this.statusCd;
    }

    /**
     * Returns the value of field 'statusCdName'. The field
     * 'statusCdName' has the following description: 状态名称
     * 
     * @return the value of field 'StatusCdName'.
     */
    public java.lang.String getStatusCdName() {
        return this.statusCdName;
    }

    /**
     * Sets the value of field 'createDate'. The field 'createDate'
     * has the following description: 受理时间
     * 
     * @param createDate the value of field 'createDate'.
     */
    public void setCreateDate(final java.lang.String createDate) {
        this.createDate = createDate;
    }

    /**
     * Sets the value of field 'custName'. The field 'custName' has
     * the following description: 客户名称
     * 
     * @param custName the value of field 'custName'.
     */
    public void setCustName(final java.lang.String custName) {
        this.custName = custName;
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
     * Sets the value of field 'customerOrderId'. The field
     * 'customerOrderId' has the following description: 订单id
     * 
     * @param customerOrderId the value of field 'customerOrderId'.
     */
    public void setCustomerOrderId(final java.lang.String customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    /**
     * Sets the value of field 'isQuitOrder'. The field
     * 'isQuitOrder' has the following description: 0--不是
     * 1--是
     * 
     * @param isQuitOrder the value of field 'isQuitOrder'.
     */
    public void setIsQuitOrder(final java.lang.String isQuitOrder) {
        this.isQuitOrder = isQuitOrder;
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
     * Sets the value of field 'statusCd'. The field 'statusCd' has
     * the following description: 状态
     * 
     * @param statusCd the value of field 'statusCd'.
     */
    public void setStatusCd(final java.lang.String statusCd) {
        this.statusCd = statusCd;
    }

    /**
     * Sets the value of field 'statusCdName'. The field
     * 'statusCdName' has the following description: 状态名称
     * 
     * @param statusCdName the value of field 'statusCdName'.
     */
    public void setStatusCdName(final java.lang.String statusCdName) {
        this.statusCdName = statusCdName;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustOrderType() {
        return custOrderType;
    }

    public void setCustOrderType(String custOrderType) {
        this.custOrderType = custOrderType;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getRegionCd() {
        return regionCd;
    }

    public void setRegionCd(String regionCd) {
        this.regionCd = regionCd;
    }
}
