/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.hbbean.prefeecancel;

/**
 * 转正订单退款费用
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class OrderFee implements java.io.Serializable {

    /**
     * 订单号
     */
    private java.lang.String custSoNumber;

    /**
     * 转正订单退款费用
     */
    private java.util.Vector<com.ffcs.crmd.cas.bean.hbbean.prefeecancel.AcctItem> acctItemList;

    public OrderFee() {
        super();
        this.acctItemList = new java.util.Vector<com.ffcs.crmd.cas.bean.hbbean.prefeecancel.AcctItem>();
    }

    /**
     * 
     * 
     * @param vAcctItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAcctItem(final com.ffcs.crmd.cas.bean.hbbean.prefeecancel.AcctItem vAcctItem) throws java.lang.IndexOutOfBoundsException {
        this.acctItemList.addElement(vAcctItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vAcctItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAcctItem(final int index,final com.ffcs.crmd.cas.bean.hbbean.prefeecancel.AcctItem vAcctItem) throws java.lang.IndexOutOfBoundsException {
        this.acctItemList.add(index, vAcctItem);
    }

    /**
     * Method enumerateAcctItem.
     * 
     * @return an Enumeration over all
     * com.ffcs.crmd.cas.bean.hbbean.prefeecancel.AcctItem elements
     */
    public java.util.Enumeration<? extends com.ffcs.crmd.cas.bean.hbbean.prefeecancel.AcctItem> enumerateAcctItem() {
        return this.acctItemList.elements();
    }

    /**
     * Method getAcctItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.ffcs.crmd.cas.bean.hbbean.prefeecancel.AcctItem at the
     * given index
     */
    public com.ffcs.crmd.cas.bean.hbbean.prefeecancel.AcctItem getAcctItem(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.acctItemList.size()) {
            throw new IndexOutOfBoundsException("getAcctItem: Index value '" + index + "' not in range [0.." + (this.acctItemList.size() - 1) + "]");
        }

        return acctItemList.get(index);
    }

    /**
     * Method getAcctItem.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.ffcs.crmd.cas.bean.hbbean.prefeecancel.AcctItem[] getAcctItem() {
        com.ffcs.crmd.cas.bean.hbbean.prefeecancel.AcctItem[] array = new com.ffcs.crmd.cas.bean.hbbean.prefeecancel.AcctItem[0];
        return this.acctItemList.toArray(array);
    }

    /**
     * Method getAcctItemCount.
     * 
     * @return the size of this collection
     */
    public int getAcctItemCount() {
        return this.acctItemList.size();
    }

    /**
     * Returns the value of field 'custSoNumber'. The field
     * 'custSoNumber' has the following description: 订单号
     * 
     * @return the value of field 'CustSoNumber'.
     */
    public java.lang.String getCustSoNumber() {
        return this.custSoNumber;
    }

    /**
     * Method removeAcctItem.
     * 
     * @param vAcctItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeAcctItem(final com.ffcs.crmd.cas.bean.hbbean.prefeecancel.AcctItem vAcctItem) {
        boolean removed = acctItemList.remove(vAcctItem);
        return removed;
    }

    /**
     * Method removeAcctItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.ffcs.crmd.cas.bean.hbbean.prefeecancel.AcctItem removeAcctItemAt(final int index) {
        java.lang.Object obj = this.acctItemList.remove(index);
        return (com.ffcs.crmd.cas.bean.hbbean.prefeecancel.AcctItem) obj;
    }

    /**
     */
    public void removeAllAcctItem() {
        this.acctItemList.clear();
    }

    /**
     * 
     * 
     * @param index
     * @param vAcctItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAcctItem(final int index,final com.ffcs.crmd.cas.bean.hbbean.prefeecancel.AcctItem vAcctItem) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.acctItemList.size()) {
            throw new IndexOutOfBoundsException("setAcctItem: Index value '" + index + "' not in range [0.." + (this.acctItemList.size() - 1) + "]");
        }

        this.acctItemList.set(index, vAcctItem);
    }

    /**
     * 
     * 
     * @param vAcctItemArray
     */
    public void setAcctItem(final com.ffcs.crmd.cas.bean.hbbean.prefeecancel.AcctItem[] vAcctItemArray) {
        //-- copy array
        acctItemList.clear();

        for (int i = 0; i < vAcctItemArray.length; i++) {
                this.acctItemList.add(vAcctItemArray[i]);
        }
    }

    /**
     * Sets the value of field 'custSoNumber'. The field
     * 'custSoNumber' has the following description: 订单号
     * 
     * @param custSoNumber the value of field 'custSoNumber'.
     */
    public void setCustSoNumber(final java.lang.String custSoNumber) {
        this.custSoNumber = custSoNumber;
    }

}
