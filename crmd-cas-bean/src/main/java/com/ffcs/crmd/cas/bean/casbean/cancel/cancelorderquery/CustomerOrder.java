/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery;

/**
 * 客户订单信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CustomerOrder implements java.io.Serializable {

    /**
     * CRM客户订单流水号
     */
    private java.lang.String custSoNumber;

    /**
     * 客户订单的动作列表，用逗号分隔
     */
    private java.lang.String actionList;

    /**
     * 包含主套餐、可选群组类可选包；不包含单产品可选包、可选产品
     */
    private java.util.Vector<com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdOfferInsts> prodOfferInstsList;

    /**
     * 只包含接入类产品即可
     */
    private java.util.Vector<com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdInsts> prodInstsList;

    /**
     * 撤销信息
     */
    private com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.CancelInfo cancelInfo;

    /**
     * CRM客户订单的一次性费用
     */
    private java.util.Vector<com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.AcctItem> acctItemList;

    public CustomerOrder() {
        super();
        this.prodOfferInstsList = new java.util.Vector<com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdOfferInsts>();
        this.prodInstsList = new java.util.Vector<com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdInsts>();
        this.acctItemList = new java.util.Vector<com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.AcctItem>();
    }

    /**
     * 
     * 
     * @param vAcctItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAcctItem(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.AcctItem vAcctItem) throws java.lang.IndexOutOfBoundsException {
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
    public void addAcctItem(final int index,final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.AcctItem vAcctItem) throws java.lang.IndexOutOfBoundsException {
        this.acctItemList.add(index, vAcctItem);
    }

    /**
     * 
     * 
     * @param vProdInsts
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addProdInsts(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdInsts vProdInsts) throws java.lang.IndexOutOfBoundsException {
        this.prodInstsList.addElement(vProdInsts);
    }

    /**
     * 
     * 
     * @param index
     * @param vProdInsts
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addProdInsts(final int index,final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdInsts vProdInsts) throws java.lang.IndexOutOfBoundsException {
        this.prodInstsList.add(index, vProdInsts);
    }

    /**
     * 
     * 
     * @param vProdOfferInsts
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addProdOfferInsts(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdOfferInsts vProdOfferInsts) throws java.lang.IndexOutOfBoundsException {
        this.prodOfferInstsList.addElement(vProdOfferInsts);
    }

    /**
     * 
     * 
     * @param index
     * @param vProdOfferInsts
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addProdOfferInsts(final int index,final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdOfferInsts vProdOfferInsts) throws java.lang.IndexOutOfBoundsException {
        this.prodOfferInstsList.add(index, vProdOfferInsts);
    }

    /**
     * Method enumerateAcctItem.
     * 
     * @return an Enumeration over all
     * com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.AcctItem
     * elements
     */
    public java.util.Enumeration<? extends com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.AcctItem> enumerateAcctItem() {
        return this.acctItemList.elements();
    }

    /**
     * Method enumerateProdInsts.
     * 
     * @return an Enumeration over all
     * com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdInsts
     * elements
     */
    public java.util.Enumeration<? extends com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdInsts> enumerateProdInsts() {
        return this.prodInstsList.elements();
    }

    /**
     * Method enumerateProdOfferInsts.
     * 
     * @return an Enumeration over all
     * com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdOfferInsts
     * elements
     */
    public java.util.Enumeration<? extends com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdOfferInsts> enumerateProdOfferInsts() {
        return this.prodOfferInstsList.elements();
    }

    /**
     * Method getAcctItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.AcctItem
     * at the given index
     */
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.AcctItem getAcctItem(final int index) throws java.lang.IndexOutOfBoundsException {
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
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.AcctItem[] getAcctItem() {
        com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.AcctItem[] array = new com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.AcctItem[0];
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
     * Returns the value of field 'actionList'. The field
     * 'actionList' has the following description: 客户订单的动作列表，用逗号分隔
     * 
     * @return the value of field 'ActionList'.
     */
    public java.lang.String getActionList() {
        return this.actionList;
    }

    /**
     * Returns the value of field 'cancelInfo'. The field
     * 'cancelInfo' has the following description: 撤销信息
     * 
     * @return the value of field 'CancelInfo'.
     */
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.CancelInfo getCancelInfo() {
        return this.cancelInfo;
    }

    /**
     * Returns the value of field 'custSoNumber'. The field
     * 'custSoNumber' has the following description: CRM客户订单流水号
     * 
     * @return the value of field 'CustSoNumber'.
     */
    public java.lang.String getCustSoNumber() {
        return this.custSoNumber;
    }

    /**
     * Method getProdInsts.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdInsts
     * at the given index
     */
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdInsts getProdInsts(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.prodInstsList.size()) {
            throw new IndexOutOfBoundsException("getProdInsts: Index value '" + index + "' not in range [0.." + (this.prodInstsList.size() - 1) + "]");
        }

        return prodInstsList.get(index);
    }

    /**
     * Method getProdInsts.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdInsts[] getProdInsts() {
        com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdInsts[] array = new com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdInsts[0];
        return this.prodInstsList.toArray(array);
    }

    /**
     * Method getProdInstsCount.
     * 
     * @return the size of this collection
     */
    public int getProdInstsCount() {
        return this.prodInstsList.size();
    }

    /**
     * Method getProdOfferInsts.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdOfferInsts
     * at the given index
     */
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdOfferInsts getProdOfferInsts(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.prodOfferInstsList.size()) {
            throw new IndexOutOfBoundsException("getProdOfferInsts: Index value '" + index + "' not in range [0.." + (this.prodOfferInstsList.size() - 1) + "]");
        }

        return prodOfferInstsList.get(index);
    }

    /**
     * Method getProdOfferInsts.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdOfferInsts[] getProdOfferInsts() {
        com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdOfferInsts[] array = new com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdOfferInsts[0];
        return this.prodOfferInstsList.toArray(array);
    }

    /**
     * Method getProdOfferInstsCount.
     * 
     * @return the size of this collection
     */
    public int getProdOfferInstsCount() {
        return this.prodOfferInstsList.size();
    }

    /**
     * Method removeAcctItem.
     * 
     * @param vAcctItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeAcctItem(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.AcctItem vAcctItem) {
        boolean removed = acctItemList.remove(vAcctItem);
        return removed;
    }

    /**
     * Method removeAcctItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.AcctItem removeAcctItemAt(final int index) {
        java.lang.Object obj = this.acctItemList.remove(index);
        return (com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.AcctItem) obj;
    }

    /**
     */
    public void removeAllAcctItem() {
        this.acctItemList.clear();
    }

    /**
     */
    public void removeAllProdInsts() {
        this.prodInstsList.clear();
    }

    /**
     */
    public void removeAllProdOfferInsts() {
        this.prodOfferInstsList.clear();
    }

    /**
     * Method removeProdInsts.
     * 
     * @param vProdInsts
     * @return true if the object was removed from the collection.
     */
    public boolean removeProdInsts(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdInsts vProdInsts) {
        boolean removed = prodInstsList.remove(vProdInsts);
        return removed;
    }

    /**
     * Method removeProdInstsAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdInsts removeProdInstsAt(final int index) {
        java.lang.Object obj = this.prodInstsList.remove(index);
        return (com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdInsts) obj;
    }

    /**
     * Method removeProdOfferInsts.
     * 
     * @param vProdOfferInsts
     * @return true if the object was removed from the collection.
     */
    public boolean removeProdOfferInsts(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdOfferInsts vProdOfferInsts) {
        boolean removed = prodOfferInstsList.remove(vProdOfferInsts);
        return removed;
    }

    /**
     * Method removeProdOfferInstsAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdOfferInsts removeProdOfferInstsAt(final int index) {
        java.lang.Object obj = this.prodOfferInstsList.remove(index);
        return (com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdOfferInsts) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vAcctItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAcctItem(final int index,final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.AcctItem vAcctItem) throws java.lang.IndexOutOfBoundsException {
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
    public void setAcctItem(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.AcctItem[] vAcctItemArray) {
        //-- copy array
        acctItemList.clear();

        for (int i = 0; i < vAcctItemArray.length; i++) {
                this.acctItemList.add(vAcctItemArray[i]);
        }
    }

    /**
     * Sets the value of field 'actionList'. The field 'actionList'
     * has the following description: 客户订单的动作列表，用逗号分隔
     * 
     * @param actionList the value of field 'actionList'.
     */
    public void setActionList(final java.lang.String actionList) {
        this.actionList = actionList;
    }

    /**
     * Sets the value of field 'cancelInfo'. The field 'cancelInfo'
     * has the following description: 撤销信息
     * 
     * @param cancelInfo the value of field 'cancelInfo'.
     */
    public void setCancelInfo(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.CancelInfo cancelInfo) {
        this.cancelInfo = cancelInfo;
    }

    /**
     * Sets the value of field 'custSoNumber'. The field
     * 'custSoNumber' has the following description: CRM客户订单流水号
     * 
     * @param custSoNumber the value of field 'custSoNumber'.
     */
    public void setCustSoNumber(final java.lang.String custSoNumber) {
        this.custSoNumber = custSoNumber;
    }

    /**
     * 
     * 
     * @param index
     * @param vProdInsts
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setProdInsts(final int index,final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdInsts vProdInsts) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.prodInstsList.size()) {
            throw new IndexOutOfBoundsException("setProdInsts: Index value '" + index + "' not in range [0.." + (this.prodInstsList.size() - 1) + "]");
        }

        this.prodInstsList.set(index, vProdInsts);
    }

    /**
     * 
     * 
     * @param vProdInstsArray
     */
    public void setProdInsts(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdInsts[] vProdInstsArray) {
        //-- copy array
        prodInstsList.clear();

        for (int i = 0; i < vProdInstsArray.length; i++) {
                this.prodInstsList.add(vProdInstsArray[i]);
        }
    }

    /**
     * 
     * 
     * @param index
     * @param vProdOfferInsts
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setProdOfferInsts(final int index,final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdOfferInsts vProdOfferInsts) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.prodOfferInstsList.size()) {
            throw new IndexOutOfBoundsException("setProdOfferInsts: Index value '" + index + "' not in range [0.." + (this.prodOfferInstsList.size() - 1) + "]");
        }

        this.prodOfferInstsList.set(index, vProdOfferInsts);
    }

    /**
     * 
     * 
     * @param vProdOfferInstsArray
     */
    public void setProdOfferInsts(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.ProdOfferInsts[] vProdOfferInstsArray) {
        //-- copy array
        prodOfferInstsList.clear();

        for (int i = 0; i < vProdOfferInstsArray.length; i++) {
                this.prodOfferInstsList.add(vProdOfferInstsArray[i]);
        }
    }

}
