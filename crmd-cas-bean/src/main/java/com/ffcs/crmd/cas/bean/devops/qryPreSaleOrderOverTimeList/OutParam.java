/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderOverTimeList;

/**
 * 响应信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class OutParam implements java.io.Serializable {

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * 处理结果
     * 0：成功
     * 1：失败
     */
    private java.lang.String result;

    /**
     * 错误信息
     */
    private com.ffcs.crmd.cas.bean.devops.comm.Error error;

    private java.util.Vector<com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderOverTimeList.PreSaleOrderDetail> preSaleOrderDetailList;

    public OutParam() {
        super();
        this.preSaleOrderDetailList = new java.util.Vector<com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderOverTimeList.PreSaleOrderDetail>();
    }

    /**
     * 
     * 
     * @param vPreSaleOrderDetail
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPreSaleOrderDetail(final com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderOverTimeList.PreSaleOrderDetail vPreSaleOrderDetail) throws java.lang.IndexOutOfBoundsException {
        this.preSaleOrderDetailList.addElement(vPreSaleOrderDetail);
    }

    /**
     * 
     * 
     * @param index
     * @param vPreSaleOrderDetail
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPreSaleOrderDetail(final int index,final com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderOverTimeList.PreSaleOrderDetail vPreSaleOrderDetail) throws java.lang.IndexOutOfBoundsException {
        this.preSaleOrderDetailList.add(index, vPreSaleOrderDetail);
    }

    /**
     * Method enumeratePreSaleOrderDetail.
     * 
     * @return an Enumeration over all
     * com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderOverTimeList.PreSaleOrderDetail
     * elements
     */
    public java.util.Enumeration<? extends com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderOverTimeList.PreSaleOrderDetail> enumeratePreSaleOrderDetail() {
        return this.preSaleOrderDetailList.elements();
    }

    /**
     * Returns the value of field 'choiceValue'. The field
     * 'choiceValue' has the following description: Internal choice
     * value storage
     * 
     * @return the value of field 'ChoiceValue'.
     */
    public java.lang.Object getChoiceValue() {
        return this._choiceValue;
    }

    /**
     * Returns the value of field 'error'. The field 'error' has
     * the following description: 错误信息
     * 
     * @return the value of field 'Error'.
     */
    public com.ffcs.crmd.cas.bean.devops.comm.Error getError() {
        return this.error;
    }

    /**
     * Method getPreSaleOrderDetail.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderOverTimeList.PreSaleOrderDetail
     * at the given index
     */
    public com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderOverTimeList.PreSaleOrderDetail getPreSaleOrderDetail(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.preSaleOrderDetailList.size()) {
            throw new IndexOutOfBoundsException("getPreSaleOrderDetail: Index value '" + index + "' not in range [0.." + (this.preSaleOrderDetailList.size() - 1) + "]");
        }

        return preSaleOrderDetailList.get(index);
    }

    /**
     * Method getPreSaleOrderDetail.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderOverTimeList.PreSaleOrderDetail[] getPreSaleOrderDetail() {
        com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderOverTimeList.PreSaleOrderDetail[] array = new com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderOverTimeList.PreSaleOrderDetail[0];
        return this.preSaleOrderDetailList.toArray(array);
    }

    /**
     * Method getPreSaleOrderDetailCount.
     * 
     * @return the size of this collection
     */
    public int getPreSaleOrderDetailCount() {
        return this.preSaleOrderDetailList.size();
    }

    /**
     * Returns the value of field 'result'. The field 'result' has
     * the following description: 处理结果
     * 0：成功
     * 1：失败
     * 
     * @return the value of field 'Result'.
     */
    public java.lang.String getResult() {
        return this.result;
    }

    /**
     */
    public void removeAllPreSaleOrderDetail() {
        this.preSaleOrderDetailList.clear();
    }

    /**
     * Method removePreSaleOrderDetail.
     * 
     * @param vPreSaleOrderDetail
     * @return true if the object was removed from the collection.
     */
    public boolean removePreSaleOrderDetail(final com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderOverTimeList.PreSaleOrderDetail vPreSaleOrderDetail) {
        boolean removed = preSaleOrderDetailList.remove(vPreSaleOrderDetail);
        return removed;
    }

    /**
     * Method removePreSaleOrderDetailAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderOverTimeList.PreSaleOrderDetail removePreSaleOrderDetailAt(final int index) {
        java.lang.Object obj = this.preSaleOrderDetailList.remove(index);
        return (com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderOverTimeList.PreSaleOrderDetail) obj;
    }

    /**
     * Sets the value of field 'error'. The field 'error' has the
     * following description: 错误信息
     * 
     * @param error the value of field 'error'.
     */
    public void setError(final com.ffcs.crmd.cas.bean.devops.comm.Error error) {
        this.error = error;
        this._choiceValue = error;
    }

    /**
     * 
     * 
     * @param index
     * @param vPreSaleOrderDetail
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setPreSaleOrderDetail(final int index,final com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderOverTimeList.PreSaleOrderDetail vPreSaleOrderDetail) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.preSaleOrderDetailList.size()) {
            throw new IndexOutOfBoundsException("setPreSaleOrderDetail: Index value '" + index + "' not in range [0.." + (this.preSaleOrderDetailList.size() - 1) + "]");
        }

        this.preSaleOrderDetailList.set(index, vPreSaleOrderDetail);
    }

    /**
     * 
     * 
     * @param vPreSaleOrderDetailArray
     */
    public void setPreSaleOrderDetail(final com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderOverTimeList.PreSaleOrderDetail[] vPreSaleOrderDetailArray) {
        //-- copy array
        preSaleOrderDetailList.clear();

        for (int i = 0; i < vPreSaleOrderDetailArray.length; i++) {
                this.preSaleOrderDetailList.add(vPreSaleOrderDetailArray[i]);
        }
    }

    /**
     * Sets the value of field 'result'. The field 'result' has the
     * following description: 处理结果
     * 0：成功
     * 1：失败
     * 
     * @param result the value of field 'result'.
     */
    public void setResult(final java.lang.String result) {
        this.result = result;
        this._choiceValue = result;
    }

}
