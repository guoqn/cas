/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.crmbean.autorelcustorder;

/**
 * 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class IsSaleAcctItem implements java.io.Serializable {

    private java.lang.String saleSerial;

    private java.lang.String extAcctItemId;

    private java.lang.String realAmount;

    public IsSaleAcctItem() {
        super();
    }

    /**
     * Returns the value of field 'extAcctItemId'.
     * 
     * @return the value of field 'ExtAcctItemId'.
     */
    public java.lang.String getExtAcctItemId() {
        return this.extAcctItemId;
    }

    /**
     * Returns the value of field 'realAmount'.
     * 
     * @return the value of field 'RealAmount'.
     */
    public java.lang.String getRealAmount() {
        return this.realAmount;
    }

    /**
     * Returns the value of field 'saleSerial'.
     * 
     * @return the value of field 'SaleSerial'.
     */
    public java.lang.String getSaleSerial() {
        return this.saleSerial;
    }

    /**
     * Sets the value of field 'extAcctItemId'.
     * 
     * @param extAcctItemId the value of field 'extAcctItemId'.
     */
    public void setExtAcctItemId(final java.lang.String extAcctItemId) {
        this.extAcctItemId = extAcctItemId;
    }

    /**
     * Sets the value of field 'realAmount'.
     * 
     * @param realAmount the value of field 'realAmount'.
     */
    public void setRealAmount(final java.lang.String realAmount) {
        this.realAmount = realAmount;
    }

    /**
     * Sets the value of field 'saleSerial'.
     * 
     * @param saleSerial the value of field 'saleSerial'.
     */
    public void setSaleSerial(final java.lang.String saleSerial) {
        this.saleSerial = saleSerial;
    }

}
