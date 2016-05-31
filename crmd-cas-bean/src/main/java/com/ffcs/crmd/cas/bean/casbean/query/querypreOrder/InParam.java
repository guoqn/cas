/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.query.querypreOrder;

/**
 * 请求信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class InParam implements java.io.Serializable {

    /**
     * 订单id
     */
    private java.lang.String extCustOrderId;

    /**
     * P订单号
     */
    private java.lang.String preOrderNumber;

    /**
     * 0--正常查询
     * 1--返回seq=1的p单
     */
    private java.lang.String qryType;

    /**
     * 是否查询二表
     * 1表示仅查一表
     * 其他值表示如果一表查询没有结果，则再查询二表
     */
    private java.lang.String qryHis;

    public InParam() {
        super();
    }

    /**
     * Returns the value of field 'extCustOrderId'. The field
     * 'extCustOrderId' has the following description: 订单id
     * 
     * @return the value of field 'ExtCustOrderId'.
     */
    public java.lang.String getExtCustOrderId() {
        return this.extCustOrderId;
    }

    /**
     * Returns the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: P订单号
     * 
     * @return the value of field 'PreOrderNumber'.
     */
    public java.lang.String getPreOrderNumber() {
        return this.preOrderNumber;
    }

    /**
     * Returns the value of field 'qryHis'. The field 'qryHis' has
     * the following description: 是否查询二表
     * 1表示仅查一表
     * 其他值表示如果一表查询没有结果，则再查询二表
     * 
     * @return the value of field 'QryHis'.
     */
    public java.lang.String getQryHis() {
        return this.qryHis;
    }

    /**
     * Returns the value of field 'qryType'. The field 'qryType'
     * has the following description: 0--正常查询
     * 1--返回seq=1的p单
     * 
     * @return the value of field 'QryType'.
     */
    public java.lang.String getQryType() {
        return this.qryType;
    }

    /**
     * Sets the value of field 'extCustOrderId'. The field
     * 'extCustOrderId' has the following description: 订单id
     * 
     * @param extCustOrderId the value of field 'extCustOrderId'.
     */
    public void setExtCustOrderId(final java.lang.String extCustOrderId) {
        this.extCustOrderId = extCustOrderId;
    }

    /**
     * Sets the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: P订单号
     * 
     * @param preOrderNumber the value of field 'preOrderNumber'.
     */
    public void setPreOrderNumber(final java.lang.String preOrderNumber) {
        this.preOrderNumber = preOrderNumber;
    }

    /**
     * Sets the value of field 'qryHis'. The field 'qryHis' has the
     * following description: 是否查询二表
     * 1表示仅查一表
     * 其他值表示如果一表查询没有结果，则再查询二表
     * 
     * @param qryHis the value of field 'qryHis'.
     */
    public void setQryHis(final java.lang.String qryHis) {
        this.qryHis = qryHis;
    }

    /**
     * Sets the value of field 'qryType'. The field 'qryType' has
     * the following description: 0--正常查询
     * 1--返回seq=1的p单
     * 
     * @param qryType the value of field 'qryType'.
     */
    public void setQryType(final java.lang.String qryType) {
        this.qryType = qryType;
    }

}
