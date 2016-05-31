/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.presaleorder;

/**
 * 预受理账目项
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PreSaleAcctItem implements java.io.Serializable {

    /**
     * 账目项Id
     */
    private long preAcctItemId;

    /**
     * Keeps track of whether primitive field preAcctItemId has
     * been set already.
     */
    private boolean haspreAcctItemId;

    /**
     * 预受理订单ID
     */
    private long preOrderId;

    /**
     * Keeps track of whether primitive field preOrderId has been
     * set already.
     */
    private boolean haspreOrderId;

    /**
     * 账目项类型
     */
    private java.lang.String acctItemType;

    /**
     * 账目项流水
     */
    private java.lang.String acctSoNumber;

    /**
     * 状态
     */
    private java.lang.String statusCd;

    private java.util.Vector<com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleAcctItemAttr> preSaleAcctItemAttrList;

    public PreSaleAcctItem() {
        super();
        this.preSaleAcctItemAttrList = new java.util.Vector<com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleAcctItemAttr>();
    }

    /**
     * 
     * 
     * @param vPreSaleAcctItemAttr
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPreSaleAcctItemAttr(final com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleAcctItemAttr vPreSaleAcctItemAttr) throws java.lang.IndexOutOfBoundsException {
        this.preSaleAcctItemAttrList.addElement(vPreSaleAcctItemAttr);
    }

    /**
     * 
     * 
     * @param index
     * @param vPreSaleAcctItemAttr
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPreSaleAcctItemAttr(final int index,final com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleAcctItemAttr vPreSaleAcctItemAttr) throws java.lang.IndexOutOfBoundsException {
        this.preSaleAcctItemAttrList.add(index, vPreSaleAcctItemAttr);
    }

    /**
     */
    public void deletePreAcctItemId() {
        this.haspreAcctItemId= false;
    }

    /**
     */
    public void deletePreOrderId() {
        this.haspreOrderId= false;
    }

    /**
     * Method enumeratePreSaleAcctItemAttr.
     * 
     * @return an Enumeration over all
     * com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleAcctItemAttr
     * elements
     */
    public java.util.Enumeration<? extends com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleAcctItemAttr> enumeratePreSaleAcctItemAttr() {
        return this.preSaleAcctItemAttrList.elements();
    }

    /**
     * Returns the value of field 'acctItemType'. The field
     * 'acctItemType' has the following description: 账目项类型
     * 
     * @return the value of field 'AcctItemType'.
     */
    public java.lang.String getAcctItemType() {
        return this.acctItemType;
    }

    /**
     * Returns the value of field 'acctSoNumber'. The field
     * 'acctSoNumber' has the following description: 账目项流水
     * 
     * @return the value of field 'AcctSoNumber'.
     */
    public java.lang.String getAcctSoNumber() {
        return this.acctSoNumber;
    }

    /**
     * Returns the value of field 'preAcctItemId'. The field
     * 'preAcctItemId' has the following description: 账目项Id
     * 
     * @return the value of field 'PreAcctItemId'.
     */
    public long getPreAcctItemId() {
        return this.preAcctItemId;
    }

    /**
     * Returns the value of field 'preOrderId'. The field
     * 'preOrderId' has the following description: 预受理订单ID
     * 
     * @return the value of field 'PreOrderId'.
     */
    public long getPreOrderId() {
        return this.preOrderId;
    }

    /**
     * Method getPreSaleAcctItemAttr.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleAcctItemAttr
     * at the given index
     */
    public com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleAcctItemAttr getPreSaleAcctItemAttr(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.preSaleAcctItemAttrList.size()) {
            throw new IndexOutOfBoundsException("getPreSaleAcctItemAttr: Index value '" + index + "' not in range [0.." + (this.preSaleAcctItemAttrList.size() - 1) + "]");
        }

        return preSaleAcctItemAttrList.get(index);
    }

    /**
     * Method getPreSaleAcctItemAttr.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleAcctItemAttr[] getPreSaleAcctItemAttr() {
        com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleAcctItemAttr[] array = new com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleAcctItemAttr[0];
        return this.preSaleAcctItemAttrList.toArray(array);
    }

    /**
     * Method getPreSaleAcctItemAttrCount.
     * 
     * @return the size of this collection
     */
    public int getPreSaleAcctItemAttrCount() {
        return this.preSaleAcctItemAttrList.size();
    }

    /**
     * Returns the value of field 'statusCd'. The field 'statusCd'
     * has the following description: 状态
     * 
     * @return the value of field 'StatusCd'.
     */
    public java.lang.String getStatusCd() {
        return this.statusCd;
    }

    /**
     * Method hasPreAcctItemId.
     * 
     * @return true if at least one PreAcctItemId has been added
     */
    public boolean hasPreAcctItemId() {
        return this.haspreAcctItemId;
    }

    /**
     * Method hasPreOrderId.
     * 
     * @return true if at least one PreOrderId has been added
     */
    public boolean hasPreOrderId() {
        return this.haspreOrderId;
    }

    /**
     */
    public void removeAllPreSaleAcctItemAttr() {
        this.preSaleAcctItemAttrList.clear();
    }

    /**
     * Method removePreSaleAcctItemAttr.
     * 
     * @param vPreSaleAcctItemAttr
     * @return true if the object was removed from the collection.
     */
    public boolean removePreSaleAcctItemAttr(final com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleAcctItemAttr vPreSaleAcctItemAttr) {
        boolean removed = preSaleAcctItemAttrList.remove(vPreSaleAcctItemAttr);
        return removed;
    }

    /**
     * Method removePreSaleAcctItemAttrAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleAcctItemAttr removePreSaleAcctItemAttrAt(final int index) {
        java.lang.Object obj = this.preSaleAcctItemAttrList.remove(index);
        return (com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleAcctItemAttr) obj;
    }

    /**
     * Sets the value of field 'acctItemType'. The field
     * 'acctItemType' has the following description: 账目项类型
     * 
     * @param acctItemType the value of field 'acctItemType'.
     */
    public void setAcctItemType(final java.lang.String acctItemType) {
        this.acctItemType = acctItemType;
    }

    /**
     * Sets the value of field 'acctSoNumber'. The field
     * 'acctSoNumber' has the following description: 账目项流水
     * 
     * @param acctSoNumber the value of field 'acctSoNumber'.
     */
    public void setAcctSoNumber(final java.lang.String acctSoNumber) {
        this.acctSoNumber = acctSoNumber;
    }

    /**
     * Sets the value of field 'preAcctItemId'. The field
     * 'preAcctItemId' has the following description: 账目项Id
     * 
     * @param preAcctItemId the value of field 'preAcctItemId'.
     */
    public void setPreAcctItemId(final long preAcctItemId) {
        this.preAcctItemId = preAcctItemId;
        this.haspreAcctItemId = true;
    }

    /**
     * Sets the value of field 'preOrderId'. The field 'preOrderId'
     * has the following description: 预受理订单ID
     * 
     * @param preOrderId the value of field 'preOrderId'.
     */
    public void setPreOrderId(final long preOrderId) {
        this.preOrderId = preOrderId;
        this.haspreOrderId = true;
    }

    /**
     * 
     * 
     * @param index
     * @param vPreSaleAcctItemAttr
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setPreSaleAcctItemAttr(final int index,final com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleAcctItemAttr vPreSaleAcctItemAttr) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.preSaleAcctItemAttrList.size()) {
            throw new IndexOutOfBoundsException("setPreSaleAcctItemAttr: Index value '" + index + "' not in range [0.." + (this.preSaleAcctItemAttrList.size() - 1) + "]");
        }

        this.preSaleAcctItemAttrList.set(index, vPreSaleAcctItemAttr);
    }

    /**
     * 
     * 
     * @param vPreSaleAcctItemAttrArray
     */
    public void setPreSaleAcctItemAttr(final com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleAcctItemAttr[] vPreSaleAcctItemAttrArray) {
        //-- copy array
        preSaleAcctItemAttrList.clear();

        for (int i = 0; i < vPreSaleAcctItemAttrArray.length; i++) {
                this.preSaleAcctItemAttrList.add(vPreSaleAcctItemAttrArray[i]);
        }
    }

    /**
     * Sets the value of field 'statusCd'. The field 'statusCd' has
     * the following description: 状态
     * 
     * @param statusCd the value of field 'statusCd'.
     */
    public void setStatusCd(final java.lang.String statusCd) {
        this.statusCd = statusCd;
    }

}
