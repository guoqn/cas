/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery;

/**
 * 响应信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class OutParam implements java.io.Serializable {

    /**
     * 处理结果
     * 10：成功，FJ可以全部撤销 11：成功，只有部分FJ能撤销12：只有P单能撤销,FJ都不能撤销
     * 20：失败
     * 
     */
    private java.lang.String result;

    /**
     * 错误信息
     */
    private com.ffcs.crmd.cas.bean.casbean.comm.Error error;

    /**
     * 预受理单信息
     */
    private com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.PreOrder preOrder;

    /**
     * 订单id
     */
    private java.lang.String extCustOrderIds;

    /**
     * 客户订单信息
     */
    private java.util.Vector<com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.CustomerOrder> customerOrderList;

    public OutParam() {
        super();
        this.customerOrderList = new java.util.Vector<com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.CustomerOrder>();
    }

    /**
     * 
     * 
     * @param vCustomerOrder
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCustomerOrder(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.CustomerOrder vCustomerOrder) throws java.lang.IndexOutOfBoundsException {
        this.customerOrderList.addElement(vCustomerOrder);
    }

    /**
     * 
     * 
     * @param index
     * @param vCustomerOrder
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCustomerOrder(final int index,final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.CustomerOrder vCustomerOrder) throws java.lang.IndexOutOfBoundsException {
        this.customerOrderList.add(index, vCustomerOrder);
    }

    /**
     * Method enumerateCustomerOrder.
     * 
     * @return an Enumeration over all
     * com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.CustomerOrder
     * elements
     */
    public java.util.Enumeration<? extends com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.CustomerOrder> enumerateCustomerOrder() {
        return this.customerOrderList.elements();
    }

    /**
     * Method getCustomerOrder.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.CustomerOrder
     * at the given index
     */
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.CustomerOrder getCustomerOrder(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.customerOrderList.size()) {
            throw new IndexOutOfBoundsException("getCustomerOrder: Index value '" + index + "' not in range [0.." + (this.customerOrderList.size() - 1) + "]");
        }

        return customerOrderList.get(index);
    }

    /**
     * Method getCustomerOrder.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.CustomerOrder[] getCustomerOrder() {
        com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.CustomerOrder[] array = new com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.CustomerOrder[0];
        return this.customerOrderList.toArray(array);
    }

    /**
     * Method getCustomerOrderCount.
     * 
     * @return the size of this collection
     */
    public int getCustomerOrderCount() {
        return this.customerOrderList.size();
    }

    /**
     * Returns the value of field 'error'. The field 'error' has
     * the following description: 错误信息
     * 
     * @return the value of field 'Error'.
     */
    public com.ffcs.crmd.cas.bean.casbean.comm.Error getError() {
        return this.error;
    }

    /**
     * Returns the value of field 'extCustOrderIds'. The field
     * 'extCustOrderIds' has the following description: 订单id
     * 
     * @return the value of field 'ExtCustOrderIds'.
     */
    public java.lang.String getExtCustOrderIds() {
        return this.extCustOrderIds;
    }

    /**
     * Returns the value of field 'preOrder'. The field 'preOrder'
     * has the following description: 预受理单信息
     * 
     * @return the value of field 'PreOrder'.
     */
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.PreOrder getPreOrder() {
        return this.preOrder;
    }

    /**
     * Returns the value of field 'result'. The field 'result' has
     * the following description: 处理结果
     * 10：成功，FJ可以全部撤销 11：成功，只有部分FJ能撤销12：只有P单能撤销,FJ都不能撤销
     * 20：失败
     * 
     * 
     * 
     * @return the value of field 'Result'.
     */
    public java.lang.String getResult() {
        return this.result;
    }

    /**
     */
    public void removeAllCustomerOrder() {
        this.customerOrderList.clear();
    }

    /**
     * Method removeCustomerOrder.
     * 
     * @param vCustomerOrder
     * @return true if the object was removed from the collection.
     */
    public boolean removeCustomerOrder(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.CustomerOrder vCustomerOrder) {
        boolean removed = customerOrderList.remove(vCustomerOrder);
        return removed;
    }

    /**
     * Method removeCustomerOrderAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.CustomerOrder removeCustomerOrderAt(final int index) {
        java.lang.Object obj = this.customerOrderList.remove(index);
        return (com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.CustomerOrder) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vCustomerOrder
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCustomerOrder(final int index,final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.CustomerOrder vCustomerOrder) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.customerOrderList.size()) {
            throw new IndexOutOfBoundsException("setCustomerOrder: Index value '" + index + "' not in range [0.." + (this.customerOrderList.size() - 1) + "]");
        }

        this.customerOrderList.set(index, vCustomerOrder);
    }

    /**
     * 
     * 
     * @param vCustomerOrderArray
     */
    public void setCustomerOrder(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.CustomerOrder[] vCustomerOrderArray) {
        //-- copy array
        customerOrderList.clear();

        for (int i = 0; i < vCustomerOrderArray.length; i++) {
                this.customerOrderList.add(vCustomerOrderArray[i]);
        }
    }

    /**
     * Sets the value of field 'error'. The field 'error' has the
     * following description: 错误信息
     * 
     * @param error the value of field 'error'.
     */
    public void setError(final com.ffcs.crmd.cas.bean.casbean.comm.Error error) {
        this.error = error;
    }

    /**
     * Sets the value of field 'extCustOrderIds'. The field
     * 'extCustOrderIds' has the following description: 订单id
     * 
     * @param extCustOrderIds the value of field 'extCustOrderIds'.
     */
    public void setExtCustOrderIds(final java.lang.String extCustOrderIds) {
        this.extCustOrderIds = extCustOrderIds;
    }

    /**
     * Sets the value of field 'preOrder'. The field 'preOrder' has
     * the following description: 预受理单信息
     * 
     * @param preOrder the value of field 'preOrder'.
     */
    public void setPreOrder(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery.PreOrder preOrder) {
        this.preOrder = preOrder;
    }

    /**
     * Sets the value of field 'result'. The field 'result' has the
     * following description: 处理结果
     * 10：成功，FJ可以全部撤销 11：成功，只有部分FJ能撤销12：只有P单能撤销,FJ都不能撤销
     * 20：失败
     * 
     * 
     * 
     * @param result the value of field 'result'.
     */
    public void setResult(final java.lang.String result) {
        this.result = result;
    }

}
