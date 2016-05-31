/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.query.querypreorderfororder;

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
    private long extCustOrderId;

    /**
     * Keeps track of whether primitive field extCustOrderId has
     * been set already.
     */
    private boolean hasextCustOrderId;

    public InParam() {
        super();
    }

    /**
     */
    public void deleteExtCustOrderId() {
        this.hasextCustOrderId= false;
    }

    /**
     * Returns the value of field 'extCustOrderId'. The field
     * 'extCustOrderId' has the following description: 订单id
     * 
     * @return the value of field 'ExtCustOrderId'.
     */
    public long getExtCustOrderId() {
        return this.extCustOrderId;
    }

    /**
     * Method hasExtCustOrderId.
     * 
     * @return true if at least one ExtCustOrderId has been added
     */
    public boolean hasExtCustOrderId() {
        return this.hasextCustOrderId;
    }

    /**
     * Sets the value of field 'extCustOrderId'. The field
     * 'extCustOrderId' has the following description: 订单id
     * 
     * @param extCustOrderId the value of field 'extCustOrderId'.
     */
    public void setExtCustOrderId(final long extCustOrderId) {
        this.extCustOrderId = extCustOrderId;
        this.hasextCustOrderId = true;
    }

}
