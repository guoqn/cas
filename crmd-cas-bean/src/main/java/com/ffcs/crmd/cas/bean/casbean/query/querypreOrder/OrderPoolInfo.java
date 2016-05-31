/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.query.querypreOrder;

/**
 * 工单池信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class OrderPoolInfo implements java.io.Serializable {

    /**
     * 工单池状态
     */
    private java.lang.String statusCd;

    /**
     * 工单池记录的备注
     */
    private java.lang.String orderPoolRemark;

    public OrderPoolInfo() {
        super();
    }

    /**
     * Returns the value of field 'orderPoolRemark'. The field
     * 'orderPoolRemark' has the following description: 工单池记录的备注
     * 
     * @return the value of field 'OrderPoolRemark'.
     */
    public java.lang.String getOrderPoolRemark() {
        return this.orderPoolRemark;
    }

    /**
     * Returns the value of field 'statusCd'. The field 'statusCd'
     * has the following description: 工单池状态
     * 
     * @return the value of field 'StatusCd'.
     */
    public java.lang.String getStatusCd() {
        return this.statusCd;
    }

    /**
     * Sets the value of field 'orderPoolRemark'. The field
     * 'orderPoolRemark' has the following description: 工单池记录的备注
     * 
     * @param orderPoolRemark the value of field 'orderPoolRemark'.
     */
    public void setOrderPoolRemark(final java.lang.String orderPoolRemark) {
        this.orderPoolRemark = orderPoolRemark;
    }

    /**
     * Sets the value of field 'statusCd'. The field 'statusCd' has
     * the following description: 工单池状态
     * 
     * @param statusCd the value of field 'statusCd'.
     */
    public void setStatusCd(final java.lang.String statusCd) {
        this.statusCd = statusCd;
    }

}
