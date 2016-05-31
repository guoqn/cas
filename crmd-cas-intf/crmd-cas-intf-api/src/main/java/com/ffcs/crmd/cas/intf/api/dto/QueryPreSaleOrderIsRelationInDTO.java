/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.intf.api.dto;

/**
 * 请求信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class QueryPreSaleOrderIsRelationInDTO implements java.io.Serializable {

    /**
     * 预受理单号
     */
    private String preOrderNumber;

    public QueryPreSaleOrderIsRelationInDTO() {
        super();
    }

    /**
     * Returns the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: 预受理单号
     *
     * @return the value of field 'PreOrderNumber'.
     */
    public String getPreOrderNumber() {
        return this.preOrderNumber;
    }

    /**
     * Sets the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: 预受理单号
     *
     * @param preOrderNumber the value of field 'preOrderNumber'.
     */
    public void setPreOrderNumber(final String preOrderNumber) {
        this.preOrderNumber = preOrderNumber;
    }

}
