/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit;

/**
 * 请求信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class InParam implements java.io.Serializable {

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
     * 受理团队区域（如591）
     */
    private java.lang.String latnId;

    /**
     * 当前员工任职关系标识
     * 字段长度： 12
     */
    private long staffPositionId;

    /**
     * Keeps track of whether primitive field staffPositionId has
     * been set already.
     */
    private boolean hasstaffPositionId;

    /**
     * 预受理单信息
     */
    private com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.PreOrder preOrder;

    /**
     * 客户订单信息
     */
    private java.util.Vector<com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.CustomerOrder> customerOrderList;

    public InParam() {
        super();
        this.customerOrderList = new java.util.Vector<com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.CustomerOrder>();
    }

    /**
     * 
     * 
     * @param vCustomerOrder
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCustomerOrder(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.CustomerOrder vCustomerOrder) throws java.lang.IndexOutOfBoundsException {
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
    public void addCustomerOrder(final int index,final com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.CustomerOrder vCustomerOrder) throws java.lang.IndexOutOfBoundsException {
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
     * com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.CustomerOrder
     * elements
     */
    public java.util.Enumeration<? extends com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.CustomerOrder> enumerateCustomerOrder() {
        return this.customerOrderList.elements();
    }

    /**
     * Method getCustomerOrder.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.CustomerOrder
     * at the given index
     */
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.CustomerOrder getCustomerOrder(final int index) throws java.lang.IndexOutOfBoundsException {
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
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.CustomerOrder[] getCustomerOrder() {
        com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.CustomerOrder[] array = new com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.CustomerOrder[0];
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
     * Returns the value of field 'latnId'. The field 'latnId' has
     * the following description: 受理团队区域（如591）
     * 
     * @return the value of field 'LatnId'.
     */
    public java.lang.String getLatnId() {
        return this.latnId;
    }

    /**
     * Returns the value of field 'preOrder'. The field 'preOrder'
     * has the following description: 预受理单信息
     * 
     * @return the value of field 'PreOrder'.
     */
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.PreOrder getPreOrder() {
        return this.preOrder;
    }

    /**
     * Returns the value of field 'staffPositionId'. The field
     * 'staffPositionId' has the following description: 当前员工任职关系标识
     * 字段长度： 12
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
    public boolean removeCustomerOrder(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.CustomerOrder vCustomerOrder) {
        boolean removed = customerOrderList.remove(vCustomerOrder);
        return removed;
    }

    /**
     * Method removeCustomerOrderAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.CustomerOrder removeCustomerOrderAt(final int index) {
        java.lang.Object obj = this.customerOrderList.remove(index);
        return (com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.CustomerOrder) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vCustomerOrder
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCustomerOrder(final int index,final com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.CustomerOrder vCustomerOrder) throws java.lang.IndexOutOfBoundsException {
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
    public void setCustomerOrder(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.CustomerOrder[] vCustomerOrderArray) {
        //-- copy array
        customerOrderList.clear();

        for (int i = 0; i < vCustomerOrderArray.length; i++) {
                this.customerOrderList.add(vCustomerOrderArray[i]);
        }
    }

    /**
     * Sets the value of field 'latnId'. The field 'latnId' has the
     * following description: 受理团队区域（如591）
     * 
     * @param latnId the value of field 'latnId'.
     */
    public void setLatnId(final java.lang.String latnId) {
        this.latnId = latnId;
    }

    /**
     * Sets the value of field 'preOrder'. The field 'preOrder' has
     * the following description: 预受理单信息
     * 
     * @param preOrder the value of field 'preOrder'.
     */
    public void setPreOrder(final com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.PreOrder preOrder) {
        this.preOrder = preOrder;
    }

    /**
     * Sets the value of field 'staffPositionId'. The field
     * 'staffPositionId' has the following description: 当前员工任职关系标识
     * 字段长度： 12
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
