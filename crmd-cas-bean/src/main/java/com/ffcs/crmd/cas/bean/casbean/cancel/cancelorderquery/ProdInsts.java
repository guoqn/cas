/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery;

/**
 * 只包含接入类产品即可
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ProdInsts implements java.io.Serializable {

    /**
     * 业务号码
     */
    private java.lang.String accNbr;

    private long productId;

    /**
     * Keeps track of whether primitive field productId has been
     * set already.
     */
    private boolean hasproductId;

    private java.lang.String productName;

    public ProdInsts() {
        super();
    }

    /**
     */
    public void deleteProductId() {
        this.hasproductId= false;
    }

    /**
     * Returns the value of field 'accNbr'. The field 'accNbr' has
     * the following description: 业务号码
     * 
     * @return the value of field 'AccNbr'.
     */
    public java.lang.String getAccNbr() {
        return this.accNbr;
    }

    /**
     * Returns the value of field 'productId'.
     * 
     * @return the value of field 'ProductId'.
     */
    public long getProductId() {
        return this.productId;
    }

    /**
     * Returns the value of field 'productName'.
     * 
     * @return the value of field 'ProductName'.
     */
    public java.lang.String getProductName() {
        return this.productName;
    }

    /**
     * Method hasProductId.
     * 
     * @return true if at least one ProductId has been added
     */
    public boolean hasProductId() {
        return this.hasproductId;
    }

    /**
     * Sets the value of field 'accNbr'. The field 'accNbr' has the
     * following description: 业务号码
     * 
     * @param accNbr the value of field 'accNbr'.
     */
    public void setAccNbr(final java.lang.String accNbr) {
        this.accNbr = accNbr;
    }

    /**
     * Sets the value of field 'productId'.
     * 
     * @param productId the value of field 'productId'.
     */
    public void setProductId(final long productId) {
        this.productId = productId;
        this.hasproductId = true;
    }

    /**
     * Sets the value of field 'productName'.
     * 
     * @param productName the value of field 'productName'.
     */
    public void setProductName(final java.lang.String productName) {
        this.productName = productName;
    }

}
