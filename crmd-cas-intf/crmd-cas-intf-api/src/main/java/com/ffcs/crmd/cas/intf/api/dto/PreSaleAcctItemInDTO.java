/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.intf.api.dto;

/**
 * 预受理账目项
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PreSaleAcctItemInDTO implements java.io.Serializable {
    /**
     * 账目项Id
     */
    private long preAcctItemId;


    /**
     * 预受理订单ID
     */
    private long preOrderId;

   

    /**
     * 账目项类型
     */
    private String acctItemType;

    /**
     * 账目项流水
     */
    private String acctSoNumber;

    /**
     * 状态
     */
    private String statusCd;

    private java.util.Vector<PreSaleAcctItemAttrInDTO> preSaleAcctItemAttrList;

    public PreSaleAcctItemInDTO() {
        super();
        this.preSaleAcctItemAttrList = new java.util.Vector<PreSaleAcctItemAttrInDTO>();
    }

    /**
     *
     *
     * @param vPreSaleAcctItemAttr
     * @throws IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPreSaleAcctItemAttr(final PreSaleAcctItemAttrInDTO vPreSaleAcctItemAttr) throws IndexOutOfBoundsException {
        this.preSaleAcctItemAttrList.addElement(vPreSaleAcctItemAttr);
    }

    /**
     *
     *
     * @param index
     * @param vPreSaleAcctItemAttr
     * @throws IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPreSaleAcctItemAttr(final int index,final PreSaleAcctItemAttrInDTO vPreSaleAcctItemAttr) throws IndexOutOfBoundsException {
        this.preSaleAcctItemAttrList.add(index, vPreSaleAcctItemAttr);
    }

   

    /**
     * Method enumeratePreSaleAcctItemAttr.
     *
     * @return an Enumeration over all
     * com.ffcs.crmd.cas.bean.casbean.save.presaleorder.PreSaleAcctItemAttr
     * elements
     */
    public java.util.Enumeration<? extends PreSaleAcctItemAttrInDTO> enumeratePreSaleAcctItemAttr() {
        return this.preSaleAcctItemAttrList.elements();
    }

    /**
     * Returns the value of field 'acctItemType'. The field
     * 'acctItemType' has the following description: 账目项类型
     *
     * @return the value of field 'AcctItemType'.
     */
    public String getAcctItemType() {
        return this.acctItemType;
    }

    /**
     * Returns the value of field 'acctSoNumber'. The field
     * 'acctSoNumber' has the following description: 账目项流水
     *
     * @return the value of field 'AcctSoNumber'.
     */
    public String getAcctSoNumber() {
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
     * @throws IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.ffcs.crmd.cas.bean.casbean.save.presaleorder.PreSaleAcctItemAttr
     * at the given index
     */
    public PreSaleAcctItemAttrInDTO getPreSaleAcctItemAttr(final int index) throws IndexOutOfBoundsException {
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
    public PreSaleAcctItemAttrInDTO[] getPreSaleAcctItemAttr() {
        PreSaleAcctItemAttrInDTO[] array = new PreSaleAcctItemAttrInDTO[0];
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
    public String getStatusCd() {
        return this.statusCd;
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
    public boolean removePreSaleAcctItemAttr(final PreSaleAcctItemAttrInDTO vPreSaleAcctItemAttr) {
        boolean removed = preSaleAcctItemAttrList.remove(vPreSaleAcctItemAttr);
        return removed;
    }

    /**
     * Method removePreSaleAcctItemAttrAt.
     *
     * @param index
     * @return the element removed from the collection
     */
    public PreSaleAcctItemAttrInDTO removePreSaleAcctItemAttrAt(final int index) {
        Object obj = this.preSaleAcctItemAttrList.remove(index);
        return (PreSaleAcctItemAttrInDTO) obj;
    }

    /**
     * Sets the value of field 'acctItemType'. The field
     * 'acctItemType' has the following description: 账目项类型
     *
     * @param acctItemType the value of field 'acctItemType'.
     */
    public void setAcctItemType(final String acctItemType) {
        this.acctItemType = acctItemType;
    }

    /**
     * Sets the value of field 'acctSoNumber'. The field
     * 'acctSoNumber' has the following description: 账目项流水
     *
     * @param acctSoNumber the value of field 'acctSoNumber'.
     */
    public void setAcctSoNumber(final String acctSoNumber) {
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
    }

    /**
     * Sets the value of field 'preOrderId'. The field 'preOrderId'
     * has the following description: 预受理订单ID
     *
     * @param preOrderId the value of field 'preOrderId'.
     */
    public void setPreOrderId(final long preOrderId) {
        this.preOrderId = preOrderId;
    }

    /**
     *
     *
     * @param index
     * @param vPreSaleAcctItemAttr
     * @throws IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setPreSaleAcctItemAttr(final int index,final PreSaleAcctItemAttrInDTO vPreSaleAcctItemAttr) throws IndexOutOfBoundsException {
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
    public void setPreSaleAcctItemAttr(final PreSaleAcctItemAttrInDTO[] vPreSaleAcctItemAttrArray) {
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
    public void setStatusCd(final String statusCd) {
        this.statusCd = statusCd;
    }

}
