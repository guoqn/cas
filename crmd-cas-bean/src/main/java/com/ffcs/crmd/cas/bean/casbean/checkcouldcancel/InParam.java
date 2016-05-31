/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.checkcouldcancel;

/**
 * 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class InParam implements java.io.Serializable {

    /**
     * 预受理P订单号
     */
    private java.lang.String preOrderNumber;

    /**
     * 撤销团队
     */
    private java.lang.String orgId;

    public InParam() {
        super();
    }

    /**
     * Returns the value of field 'orgId'. The field 'orgId' has
     * the following description: 撤销团队
     * 
     * @return the value of field 'OrgId'.
     */
    public java.lang.String getOrgId() {
        return this.orgId;
    }

    /**
     * Returns the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: 预受理P订单号
     * 
     * @return the value of field 'PreOrderNumber'.
     */
    public java.lang.String getPreOrderNumber() {
        return this.preOrderNumber;
    }

    /**
     * Sets the value of field 'orgId'. The field 'orgId' has the
     * following description: 撤销团队
     * 
     * @param orgId the value of field 'orgId'.
     */
    public void setOrgId(final java.lang.String orgId) {
        this.orgId = orgId;
    }

    /**
     * Sets the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: 预受理P订单号
     * 
     * @param preOrderNumber the value of field 'preOrderNumber'.
     */
    public void setPreOrderNumber(final java.lang.String preOrderNumber) {
        this.preOrderNumber = preOrderNumber;
    }

}
