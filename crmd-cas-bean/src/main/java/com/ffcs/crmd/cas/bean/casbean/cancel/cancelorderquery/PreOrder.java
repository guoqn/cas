/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery;

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
     * 预受理单对应的费用信息
     */
    private java.util.Vector<com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.FeeItem> feeItemList;

    public PreOrder() {
        super();
        this.feeItemList = new java.util.Vector<com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.FeeItem>();
    }

    /**
     * 
     * 
     * @param vFeeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFeeItem(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.FeeItem vFeeItem) throws java.lang.IndexOutOfBoundsException {
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
    public void addFeeItem(final int index,final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.FeeItem vFeeItem) throws java.lang.IndexOutOfBoundsException {
        this.feeItemList.add(index, vFeeItem);
    }

    /**
     * Method enumerateFeeItem.
     * 
     * @return an Enumeration over all
     * com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.FeeItem
     * elements
     */
    public java.util.Enumeration<? extends com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.FeeItem> enumerateFeeItem() {
        return this.feeItemList.elements();
    }

    /**
     * Method getFeeItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.FeeItem
     * at the given index
     */
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.FeeItem getFeeItem(final int index) throws java.lang.IndexOutOfBoundsException {
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
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.FeeItem[] getFeeItem() {
        com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.FeeItem[] array = new com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.FeeItem[0];
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
    public boolean removeFeeItem(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.FeeItem vFeeItem) {
        boolean removed = feeItemList.remove(vFeeItem);
        return removed;
    }

    /**
     * Method removeFeeItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.FeeItem removeFeeItemAt(final int index) {
        java.lang.Object obj = this.feeItemList.remove(index);
        return (com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.FeeItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vFeeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setFeeItem(final int index,final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.FeeItem vFeeItem) throws java.lang.IndexOutOfBoundsException {
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
    public void setFeeItem(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.FeeItem[] vFeeItemArray) {
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
