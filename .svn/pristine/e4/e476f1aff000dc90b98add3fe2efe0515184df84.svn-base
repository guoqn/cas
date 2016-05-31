/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.crmbean.checkcancel;

/**
 * 请求信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class InParam implements java.io.Serializable {

    private java.lang.String custOrderId;

    /**
     * 当前员工任职关系标识
     *  字段长度： 12
     */
    private long staffPositionId;

    /**
     * Keeps track of whether primitive field staffPositionId has
     * been set already.
     */
    private boolean hasstaffPositionId;

    /**
     * 受理班组ID 
     */
    private long teamId;

    /**
     * Keeps track of whether primitive field teamId has been set
     * already.
     */
    private boolean hasteamId;

    /**
     * 客户订单信息
     */
    private java.util.Vector<com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustomerOrder> customerOrderList;

    public InParam() {
        super();
        this.customerOrderList = new java.util.Vector<com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustomerOrder>();
    }

    /**
     * 
     * 
     * @param vCustomerOrder
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCustomerOrder(final com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustomerOrder vCustomerOrder) throws java.lang.IndexOutOfBoundsException {
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
    public void addCustomerOrder(final int index,final com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustomerOrder vCustomerOrder) throws java.lang.IndexOutOfBoundsException {
        this.customerOrderList.add(index, vCustomerOrder);
    }

    /**
     */
    public void deleteStaffPositionId() {
        this.hasstaffPositionId= false;
    }

    /**
     */
    public void deleteTeamId() {
        this.hasteamId= false;
    }

    /**
     * Method enumerateCustomerOrder.
     * 
     * @return an Enumeration over all
     * com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustomerOrder
     * elements
     */
    public java.util.Enumeration<? extends com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustomerOrder> enumerateCustomerOrder() {
        return this.customerOrderList.elements();
    }

    /**
     * Returns the value of field 'custOrderId'.
     * 
     * @return the value of field 'CustOrderId'.
     */
    public java.lang.String getCustOrderId() {
        return this.custOrderId;
    }

    /**
     * Method getCustomerOrder.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustomerOrder at
     * the given index
     */
    public com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustomerOrder getCustomerOrder(final int index) throws java.lang.IndexOutOfBoundsException {
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
    public com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustomerOrder[] getCustomerOrder() {
        com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustomerOrder[] array = new com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustomerOrder[0];
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
     * Returns the value of field 'staffPositionId'. The field
     * 'staffPositionId' has the following description: 当前员工任职关系标识
     *  字段长度： 12
     * 
     * @return the value of field 'StaffPositionId'.
     */
    public long getStaffPositionId() {
        return this.staffPositionId;
    }

    /**
     * Returns the value of field 'teamId'. The field 'teamId' has
     * the following description: 受理班组ID 
     * 
     * @return the value of field 'TeamId'.
     */
    public long getTeamId() {
        return this.teamId;
    }

    /**
     * Method hasStaffPositionId.
     * 
     * @return true if at least one StaffPositionId has been added
     */
    public boolean hasStaffPositionId() {
        return this.hasstaffPositionId;
    }

    /**
     * Method hasTeamId.
     * 
     * @return true if at least one TeamId has been added
     */
    public boolean hasTeamId() {
        return this.hasteamId;
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
    public boolean removeCustomerOrder(final com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustomerOrder vCustomerOrder) {
        boolean removed = customerOrderList.remove(vCustomerOrder);
        return removed;
    }

    /**
     * Method removeCustomerOrderAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustomerOrder removeCustomerOrderAt(final int index) {
        java.lang.Object obj = this.customerOrderList.remove(index);
        return (com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustomerOrder) obj;
    }

    /**
     * Sets the value of field 'custOrderId'.
     * 
     * @param custOrderId the value of field 'custOrderId'.
     */
    public void setCustOrderId(final java.lang.String custOrderId) {
        this.custOrderId = custOrderId;
    }

    /**
     * 
     * 
     * @param index
     * @param vCustomerOrder
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCustomerOrder(final int index,final com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustomerOrder vCustomerOrder) throws java.lang.IndexOutOfBoundsException {
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
    public void setCustomerOrder(final com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustomerOrder[] vCustomerOrderArray) {
        //-- copy array
        customerOrderList.clear();

        for (int i = 0; i < vCustomerOrderArray.length; i++) {
                this.customerOrderList.add(vCustomerOrderArray[i]);
        }
    }

    /**
     * Sets the value of field 'staffPositionId'. The field
     * 'staffPositionId' has the following description: 当前员工任职关系标识
     *  字段长度： 12
     * 
     * @param staffPositionId the value of field 'staffPositionId'.
     */
    public void setStaffPositionId(final long staffPositionId) {
        this.staffPositionId = staffPositionId;
        this.hasstaffPositionId = true;
    }

    /**
     * Sets the value of field 'teamId'. The field 'teamId' has the
     * following description: 受理班组ID 
     * 
     * @param teamId the value of field 'teamId'.
     */
    public void setTeamId(final long teamId) {
        this.teamId = teamId;
        this.hasteamId = true;
    }

}
