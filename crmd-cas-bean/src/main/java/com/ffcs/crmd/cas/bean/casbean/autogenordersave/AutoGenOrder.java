/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.autogenordersave;

/**
 * 自动受理信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class AutoGenOrder implements java.io.Serializable {

    /**
     * 预受理订单号
     */
    private java.lang.String preOrderNumber;

    /**
     * 接收时间
     */
    private java.lang.String sceneType;

    /**
     * 订单类型
     */
    private java.lang.String prodOfferId;

    /**
     * 团队ID
     */
    private java.lang.String custId;

    /**
     * 渠道ID
     */
    private java.lang.String statusCd;

    /**
     * 渠道ID
     */
    private java.lang.String shardingId;

    /**
     * 客户ID
     */
    private java.lang.String sceneFlag;

    /**
     * 预受理标志
     */
    private java.lang.String accNbr;

    /**
     * 订单来源
     */
    private java.lang.String xmlMsg;

    public AutoGenOrder() {
        super();
    }

    /**
     * Returns the value of field 'accNbr'. The field 'accNbr' has
     * the following description: 预受理标志
     * 
     * @return the value of field 'AccNbr'.
     */
    public java.lang.String getAccNbr() {
        return this.accNbr;
    }

    /**
     * Returns the value of field 'custId'. The field 'custId' has
     * the following description: 团队ID
     * 
     * @return the value of field 'CustId'.
     */
    public java.lang.String getCustId() {
        return this.custId;
    }

    /**
     * Returns the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: 预受理订单号
     * 
     * @return the value of field 'PreOrderNumber'.
     */
    public java.lang.String getPreOrderNumber() {
        return this.preOrderNumber;
    }

    /**
     * Returns the value of field 'prodOfferId'. The field
     * 'prodOfferId' has the following description: 订单类型
     * 
     * @return the value of field 'ProdOfferId'.
     */
    public java.lang.String getProdOfferId() {
        return this.prodOfferId;
    }

    /**
     * Returns the value of field 'sceneFlag'. The field
     * 'sceneFlag' has the following description: 客户ID
     * 
     * @return the value of field 'SceneFlag'.
     */
    public java.lang.String getSceneFlag() {
        return this.sceneFlag;
    }

    /**
     * Returns the value of field 'sceneType'. The field
     * 'sceneType' has the following description: 接收时间
     * 
     * @return the value of field 'SceneType'.
     */
    public java.lang.String getSceneType() {
        return this.sceneType;
    }

    /**
     * Returns the value of field 'shardingId'. The field
     * 'shardingId' has the following description: 渠道ID
     * 
     * @return the value of field 'ShardingId'.
     */
    public java.lang.String getShardingId() {
        return this.shardingId;
    }

    /**
     * Returns the value of field 'statusCd'. The field 'statusCd'
     * has the following description: 渠道ID
     * 
     * @return the value of field 'StatusCd'.
     */
    public java.lang.String getStatusCd() {
        return this.statusCd;
    }

    /**
     * Returns the value of field 'xmlMsg'. The field 'xmlMsg' has
     * the following description: 订单来源
     * 
     * @return the value of field 'XmlMsg'.
     */
    public java.lang.String getXmlMsg() {
        return this.xmlMsg;
    }

    /**
     * Sets the value of field 'accNbr'. The field 'accNbr' has the
     * following description: 预受理标志
     * 
     * @param accNbr the value of field 'accNbr'.
     */
    public void setAccNbr(final java.lang.String accNbr) {
        this.accNbr = accNbr;
    }

    /**
     * Sets the value of field 'custId'. The field 'custId' has the
     * following description: 团队ID
     * 
     * @param custId the value of field 'custId'.
     */
    public void setCustId(final java.lang.String custId) {
        this.custId = custId;
    }

    /**
     * Sets the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: 预受理订单号
     * 
     * @param preOrderNumber the value of field 'preOrderNumber'.
     */
    public void setPreOrderNumber(final java.lang.String preOrderNumber) {
        this.preOrderNumber = preOrderNumber;
    }

    /**
     * Sets the value of field 'prodOfferId'. The field
     * 'prodOfferId' has the following description: 订单类型
     * 
     * @param prodOfferId the value of field 'prodOfferId'.
     */
    public void setProdOfferId(final java.lang.String prodOfferId) {
        this.prodOfferId = prodOfferId;
    }

    /**
     * Sets the value of field 'sceneFlag'. The field 'sceneFlag'
     * has the following description: 客户ID
     * 
     * @param sceneFlag the value of field 'sceneFlag'.
     */
    public void setSceneFlag(final java.lang.String sceneFlag) {
        this.sceneFlag = sceneFlag;
    }

    /**
     * Sets the value of field 'sceneType'. The field 'sceneType'
     * has the following description: 接收时间
     * 
     * @param sceneType the value of field 'sceneType'.
     */
    public void setSceneType(final java.lang.String sceneType) {
        this.sceneType = sceneType;
    }

    /**
     * Sets the value of field 'shardingId'. The field 'shardingId'
     * has the following description: 渠道ID
     * 
     * @param shardingId the value of field 'shardingId'.
     */
    public void setShardingId(final java.lang.String shardingId) {
        this.shardingId = shardingId;
    }

    /**
     * Sets the value of field 'statusCd'. The field 'statusCd' has
     * the following description: 渠道ID
     * 
     * @param statusCd the value of field 'statusCd'.
     */
    public void setStatusCd(final java.lang.String statusCd) {
        this.statusCd = statusCd;
    }

    /**
     * Sets the value of field 'xmlMsg'. The field 'xmlMsg' has the
     * following description: 订单来源
     * 
     * @param xmlMsg the value of field 'xmlMsg'.
     */
    public void setXmlMsg(final java.lang.String xmlMsg) {
        this.xmlMsg = xmlMsg;
    }

}
