/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.presaleorderdeal;

/**
 * 请求信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class InParam implements java.io.Serializable {

    /**
     * 是否需要付费
     * 0--不需要
     * 1--需要
     */
    private java.lang.String isNeedPay;

    /**
     * 订单Id
     */
    private long custOrderId;

    /**
     * Keeps track of whether primitive field custOrderId has been
     * set already.
     */
    private boolean hascustOrderId;

    private com.ffcs.crmd.cas.bean.casbean.presaleorderdeal.PreSaleOrder preSaleOrder;

    public InParam() {
        super();
    }

    /**
     */
    public void deleteCustOrderId() {
        this.hascustOrderId= false;
    }

    /**
     * Returns the value of field 'custOrderId'. The field
     * 'custOrderId' has the following description: 订单Id
     * 
     * @return the value of field 'CustOrderId'.
     */
    public long getCustOrderId() {
        return this.custOrderId;
    }

    /**
     * Returns the value of field 'isNeedPay'. The field
     * 'isNeedPay' has the following description: 是否需要付费
     * 0--不需要
     * 1--需要
     * 
     * @return the value of field 'IsNeedPay'.
     */
    public java.lang.String getIsNeedPay() {
        return this.isNeedPay;
    }

    /**
     * Returns the value of field 'preSaleOrder'.
     * 
     * @return the value of field 'PreSaleOrder'.
     */
    public com.ffcs.crmd.cas.bean.casbean.presaleorderdeal.PreSaleOrder getPreSaleOrder() {
        return this.preSaleOrder;
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
     * Sets the value of field 'custOrderId'. The field
     * 'custOrderId' has the following description: 订单Id
     * 
     * @param custOrderId the value of field 'custOrderId'.
     */
    public void setCustOrderId(final long custOrderId) {
        this.custOrderId = custOrderId;
        this.hascustOrderId = true;
    }

    /**
     * Sets the value of field 'isNeedPay'. The field 'isNeedPay'
     * has the following description: 是否需要付费
     * 0--不需要
     * 1--需要
     * 
     * @param isNeedPay the value of field 'isNeedPay'.
     */
    public void setIsNeedPay(final java.lang.String isNeedPay) {
        this.isNeedPay = isNeedPay;
    }

    /**
     * Sets the value of field 'preSaleOrder'.
     * 
     * @param preSaleOrder the value of field 'preSaleOrder'.
     */
    public void setPreSaleOrder(final com.ffcs.crmd.cas.bean.casbean.presaleorderdeal.PreSaleOrder preSaleOrder) {
        this.preSaleOrder = preSaleOrder;
    }

}
