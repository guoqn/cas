/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.intf.api.dto;

/**
 * 集团费用项
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ISaleAcctItemInDTO implements java.io.Serializable {

    /**
     * 集团费用项ID
     */
    private long isaleAcctItemId;



    /**
     * P单号
     */
    private String saleSerial;

    /**
     * 账目项类型
     */
    private String extAcctItemCd;

    /**
     * 账目项流水
     */
    private String realAmount;
    
    private Long extAcctItemId;
    
    public ISaleAcctItemInDTO() {
        super();
    }
    public Long getExtAcctItemId() {
    	return this.extAcctItemId;
    }
    public void setExtAcctItemId(Long extAcctItemId) {
    	this.extAcctItemId = extAcctItemId;
    }

    /**
     * Returns the value of field 'extAcctItemCd'. The field
     * 'extAcctItemCd' has the following description: 账目项类型
     *
     * @return the value of field 'ExtAcctItemCd'.
     */
    public String getExtAcctItemCd() {
        return this.extAcctItemCd;
    }

    /**
     * Returns the value of field 'isaleAcctItemId'. The field
     * 'isaleAcctItemId' has the following description: 集团费用项ID
     *
     * @return the value of field 'IsaleAcctItemId'.
     */
    public long getIsaleAcctItemId() {
        return this.isaleAcctItemId;
    }

    /**
     * Returns the value of field 'realAmount'. The field
     * 'realAmount' has the following description: 账目项流水
     *
     * @return the value of field 'RealAmount'.
     */
    public String getRealAmount() {
        return this.realAmount;
    }

    /**
     * Returns the value of field 'saleSerial'. The field
     * 'saleSerial' has the following description: P单号
     *
     * @return the value of field 'SaleSerial'.
     */
    public String getSaleSerial() {
        return this.saleSerial;
    }


    /**
     * Sets the value of field 'extAcctItemCd'. The field
     * 'extAcctItemCd' has the following description: 账目项类型
     *
     * @param extAcctItemCd the value of field 'extAcctItemCd'.
     */
    public void setExtAcctItemCd(final String extAcctItemCd) {
        this.extAcctItemCd = extAcctItemCd;
    }

    /**
     * Sets the value of field 'isaleAcctItemId'. The field
     * 'isaleAcctItemId' has the following description: 集团费用项ID
     *
     * @param isaleAcctItemId the value of field 'isaleAcctItemId'.
     */
    public void setIsaleAcctItemId(final long isaleAcctItemId) {
        this.isaleAcctItemId = isaleAcctItemId;
    }

    /**
     * Sets the value of field 'realAmount'. The field 'realAmount'
     * has the following description: 账目项流水
     *
     * @param realAmount the value of field 'realAmount'.
     */
    public void setRealAmount(final String realAmount) {
        this.realAmount = realAmount;
    }

    /**
     * Sets the value of field 'saleSerial'. The field 'saleSerial'
     * has the following description: P单号
     *
     * @param saleSerial the value of field 'saleSerial'.
     */
    public void setSaleSerial(final String saleSerial) {
        this.saleSerial = saleSerial;
    }

}
