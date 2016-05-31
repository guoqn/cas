/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.modpreorderbean.createPreSaleOrder;

/**
 * 请求信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class InParam implements java.io.Serializable {

    /**
     * P单信息
     */
    private com.ffcs.crmd.cas.bean.casbean.modpreorderbean.createPreSaleOrder.PreOrder preOrder;

    public InParam() {
        super();
    }

    /**
     * Returns the value of field 'preOrder'. The field 'preOrder'
     * has the following description: P单信息
     * 
     * @return the value of field 'PreOrder'.
     */
    public com.ffcs.crmd.cas.bean.casbean.modpreorderbean.createPreSaleOrder.PreOrder getPreOrder() {
        return this.preOrder;
    }

    /**
     * Sets the value of field 'preOrder'. The field 'preOrder' has
     * the following description: P单信息
     * 
     * @param preOrder the value of field 'preOrder'.
     */
    public void setPreOrder(final com.ffcs.crmd.cas.bean.casbean.modpreorderbean.createPreSaleOrder.PreOrder preOrder) {
        this.preOrder = preOrder;
    }

}
