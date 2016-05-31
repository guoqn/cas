/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit;

/**
 * 预受理单信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PreOrder implements java.io.Serializable {

    /**
     * 预受理单号
     */
    private java.lang.String preCustSoNum;

    /**
     * 总金额（单位分，退款为负值）
     * 字段长度： 16
     */
    private long amount;

    /**
     * Keeps track of whether primitive field amount has been set
     * already.
     */
    private boolean hasamount;

    /**
     * 预受理单对应的费用信息
     */
    private java.util.Vector<com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.FeeItem> feeItemList;

    public PreOrder() {
        super();
        this.feeItemList = new java.util.Vector<com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.FeeItem>();
    }

    /**
     * 
     * 
     * @param vFeeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFeeItem(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.FeeItem vFeeItem) throws java.lang.IndexOutOfBoundsException {
        this.feeItemList.addElement(vFeeItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vFeeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFeeItem(final int index,final com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.FeeItem vFeeItem) throws java.lang.IndexOutOfBoundsException {
        this.feeItemList.add(index, vFeeItem);
    }

    /**
     */
    public void deleteAmount() {
        this.hasamount= false;
    }

    /**
     * Method enumerateFeeItem.
     * 
     * @return an Enumeration over all
     * com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.FeeItem
     * elements
     */
    public java.util.Enumeration<? extends com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.FeeItem> enumerateFeeItem() {
        return this.feeItemList.elements();
    }

    /**
     * Returns the value of field 'amount'. The field 'amount' has
     * the following description: 总金额（单位分，退款为负值）
     * 字段长度： 16
     * 
     * @return the value of field 'Amount'.
     */
    public long getAmount() {
        return this.amount;
    }

    /**
     * Method getFeeItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.FeeItem
     * at the given index
     */
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.FeeItem getFeeItem(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.feeItemList.size()) {
            throw new IndexOutOfBoundsException("getFeeItem: Index value '" + index + "' not in range [0.." + (this.feeItemList.size() - 1) + "]");
        }

        return feeItemList.get(index);
    }

    /**
     * Method getFeeItem.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.FeeItem[] getFeeItem() {
        com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.FeeItem[] array = new com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.FeeItem[0];
        return this.feeItemList.toArray(array);
    }

    /**
     * Method getFeeItemCount.
     * 
     * @return the size of this collection
     */
    public int getFeeItemCount() {
        return this.feeItemList.size();
    }

    /**
     * Returns the value of field 'preCustSoNum'. The field
     * 'preCustSoNum' has the following description: 预受理单号
     * 
     * @return the value of field 'PreCustSoNum'.
     */
    public java.lang.String getPreCustSoNum() {
        return this.preCustSoNum;
    }

    /**
     * Method hasAmount.
     * 
     * @return true if at least one Amount has been added
     */
    public boolean hasAmount() {
        return this.hasamount;
    }

    /**
     */
    public void removeAllFeeItem() {
        this.feeItemList.clear();
    }

    /**
     * Method removeFeeItem.
     * 
     * @param vFeeItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeFeeItem(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.FeeItem vFeeItem) {
        boolean removed = feeItemList.remove(vFeeItem);
        return removed;
    }

    /**
     * Method removeFeeItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.FeeItem removeFeeItemAt(final int index) {
        java.lang.Object obj = this.feeItemList.remove(index);
        return (com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.FeeItem) obj;
    }

    /**
     * Sets the value of field 'amount'. The field 'amount' has the
     * following description: 总金额（单位分，退款为负值）
     * 字段长度： 16
     * 
     * @param amount the value of field 'amount'.
     */
    public void setAmount(final long amount) {
        this.amount = amount;
        this.hasamount = true;
    }

    /**
     * 
     * 
     * @param index
     * @param vFeeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setFeeItem(final int index,final com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.FeeItem vFeeItem) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.feeItemList.size()) {
            throw new IndexOutOfBoundsException("setFeeItem: Index value '" + index + "' not in range [0.." + (this.feeItemList.size() - 1) + "]");
        }

        this.feeItemList.set(index, vFeeItem);
    }

    /**
     * 
     * 
     * @param vFeeItemArray
     */
    public void setFeeItem(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.FeeItem[] vFeeItemArray) {
        //-- copy array
        feeItemList.clear();

        for (int i = 0; i < vFeeItemArray.length; i++) {
                this.feeItemList.add(vFeeItemArray[i]);
        }
    }

    /**
     * Sets the value of field 'preCustSoNum'. The field
     * 'preCustSoNum' has the following description: 预受理单号
     * 
     * @param preCustSoNum the value of field 'preCustSoNum'.
     */
    public void setPreCustSoNum(final java.lang.String preCustSoNum) {
        this.preCustSoNum = preCustSoNum;
    }

}
