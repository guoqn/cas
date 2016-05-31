/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.intf.api.dto;

/**
 * 响应信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class QueryPreSaleOrderIsRelationOutDTO implements java.io.Serializable {



    /**
     * 处理结果
     * 0：成功
     * 1：失败
     */
    private java.lang.String result;

    /**
     * 错误信息
     */
    private com.ffcs.crmd.cas.bean.casbean.comm.Error error;

    /**
     * 状态信息
     */
    private com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleOrder preSaleOrder;

    /**
     * 待收费的预收费用
     */
    private long preFee;

    /**
     * Keeps track of whether primitive field preFee has been set
     * already.
     */
    private boolean haspreFee;

    public QueryPreSaleOrderIsRelationOutDTO() {
        super();
    }

    /**
     */
    public void deletePreFee() {
        this.haspreFee= false;
    }

    /**
     * Returns the value of field 'error'. The field 'error' has
     * the following description: 错误信息
     *
     * @return the value of field 'Error'.
     */
    public com.ffcs.crmd.cas.bean.casbean.comm.Error getError() {
        return this.error;
    }

    /**
     * Returns the value of field 'preFee'. The field 'preFee' has
     * the following description: 待收费的预收费用
     *
     * @return the value of field 'PreFee'.
     */
    public long getPreFee() {
        return this.preFee;
    }

    /**
     * Returns the value of field 'preSaleOrder'. The field
     * 'preSaleOrder' has the following description: 状态信息
     *
     * @return the value of field 'PreSaleOrder'.
     */
    public com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleOrder getPreSaleOrder() {
        return this.preSaleOrder;
    }

    /**
     * Returns the value of field 'result'. The field 'result' has
     * the following description: 处理结果
     * 0：成功
     * 1：失败
     *
     * @return the value of field 'Result'.
     */
    public java.lang.String getResult() {
        return this.result;
    }

    /**
     * Method hasPreFee.
     *
     * @return true if at least one PreFee has been added
     */
    public boolean hasPreFee() {
        return this.haspreFee;
    }

    /**
     * Sets the value of field 'error'. The field 'error' has the
     * following description: 错误信息
     *
     * @param error the value of field 'error'.
     */
    public void setError(final com.ffcs.crmd.cas.bean.casbean.comm.Error error) {
        this.error = error;
    }

    /**
     * Sets the value of field 'preFee'. The field 'preFee' has the
     * following description: 待收费的预收费用
     *
     * @param preFee the value of field 'preFee'.
     */
    public void setPreFee(final long preFee) {
        this.preFee = preFee;
        this.haspreFee = true;
    }

    /**
     * Sets the value of field 'preSaleOrder'. The field
     * 'preSaleOrder' has the following description: 状态信息
     *
     * @param preSaleOrder the value of field 'preSaleOrder'.
     */
    public void setPreSaleOrder(final com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleOrder preSaleOrder) {
        this.preSaleOrder = preSaleOrder;
    }

    /**
     * Sets the value of field 'result'. The field 'result' has the
     * following description: 处理结果
     * 0：成功
     * 1：失败
     *
     * @param result the value of field 'result'.
     */
    public void setResult(final java.lang.String result) {
        this.result = result;
    }

}
