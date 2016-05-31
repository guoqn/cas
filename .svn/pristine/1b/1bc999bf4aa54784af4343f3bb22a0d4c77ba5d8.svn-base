/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.crmbean.createconnect;

/**
 * 响应信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class OutParam implements java.io.Serializable {

    /**
     * 处理结果
     * 0：成功 
     * 1：失败
     */
    private java.lang.String result;

    /**
     * 错误信息
     */
    private com.ffcs.crmd.cas.bean.crmbean.comm.Error error;

    private java.util.Vector<com.ffcs.crmd.cas.bean.crmbean.createconnect.CustOrder> custOrderList;

    public OutParam() {
        super();
        this.custOrderList = new java.util.Vector<com.ffcs.crmd.cas.bean.crmbean.createconnect.CustOrder>();
    }

    /**
     * 
     * 
     * @param vCustOrder
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCustOrder(final com.ffcs.crmd.cas.bean.crmbean.createconnect.CustOrder vCustOrder) throws java.lang.IndexOutOfBoundsException {
        this.custOrderList.addElement(vCustOrder);
    }

    /**
     * 
     * 
     * @param index
     * @param vCustOrder
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCustOrder(final int index,final com.ffcs.crmd.cas.bean.crmbean.createconnect.CustOrder vCustOrder) throws java.lang.IndexOutOfBoundsException {
        this.custOrderList.add(index, vCustOrder);
    }

    /**
     * Method enumerateCustOrder.
     * 
     * @return an Enumeration over all
     * com.ffcs.crmd.cas.bean.crmbean.createconnect.CustOrder
     * elements
     */
    public java.util.Enumeration<? extends com.ffcs.crmd.cas.bean.crmbean.createconnect.CustOrder> enumerateCustOrder() {
        return this.custOrderList.elements();
    }

    /**
     * Method getCustOrder.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.ffcs.crmd.cas.bean.crmbean.createconnect.CustOrder at
     * the given index
     */
    public com.ffcs.crmd.cas.bean.crmbean.createconnect.CustOrder getCustOrder(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.custOrderList.size()) {
            throw new IndexOutOfBoundsException("getCustOrder: Index value '" + index + "' not in range [0.." + (this.custOrderList.size() - 1) + "]");
        }

        return custOrderList.get(index);
    }

    /**
     * Method getCustOrder.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.ffcs.crmd.cas.bean.crmbean.createconnect.CustOrder[] getCustOrder() {
        com.ffcs.crmd.cas.bean.crmbean.createconnect.CustOrder[] array = new com.ffcs.crmd.cas.bean.crmbean.createconnect.CustOrder[0];
        return this.custOrderList.toArray(array);
    }

    /**
     * Method getCustOrderCount.
     * 
     * @return the size of this collection
     */
    public int getCustOrderCount() {
        return this.custOrderList.size();
    }

    /**
     * Returns the value of field 'error'. The field 'error' has
     * the following description: 错误信息
     * 
     * @return the value of field 'Error'.
     */
    public com.ffcs.crmd.cas.bean.crmbean.comm.Error getError() {
        return this.error;
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
    public void removeAllCustOrder() {
        this.custOrderList.clear();
    }

    /**
     * Method removeCustOrder.
     * 
     * @param vCustOrder
     * @return true if the object was removed from the collection.
     */
    public boolean removeCustOrder(final com.ffcs.crmd.cas.bean.crmbean.createconnect.CustOrder vCustOrder) {
        boolean removed = custOrderList.remove(vCustOrder);
        return removed;
    }

    /**
     * Method removeCustOrderAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.ffcs.crmd.cas.bean.crmbean.createconnect.CustOrder removeCustOrderAt(final int index) {
        java.lang.Object obj = this.custOrderList.remove(index);
        return (com.ffcs.crmd.cas.bean.crmbean.createconnect.CustOrder) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vCustOrder
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCustOrder(final int index,final com.ffcs.crmd.cas.bean.crmbean.createconnect.CustOrder vCustOrder) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.custOrderList.size()) {
            throw new IndexOutOfBoundsException("setCustOrder: Index value '" + index + "' not in range [0.." + (this.custOrderList.size() - 1) + "]");
        }

        this.custOrderList.set(index, vCustOrder);
    }

    /**
     * 
     * 
     * @param vCustOrderArray
     */
    public void setCustOrder(final com.ffcs.crmd.cas.bean.crmbean.createconnect.CustOrder[] vCustOrderArray) {
        //-- copy array
        custOrderList.clear();

        for (int i = 0; i < vCustOrderArray.length; i++) {
                this.custOrderList.add(vCustOrderArray[i]);
        }
    }

    /**
     * Sets the value of field 'error'. The field 'error' has the
     * following description: 错误信息
     * 
     * @param error the value of field 'error'.
     */
    public void setError(final com.ffcs.crmd.cas.bean.crmbean.comm.Error error) {
        this.error = error;
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
    }

}
