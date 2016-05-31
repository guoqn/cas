/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.hbbean.prefeecancel;

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
     * 预受理退款费用
     */
    private com.ffcs.crmd.cas.bean.hbbean.prefeecancel.PreFee preFee;

    /**
     * 转正订单退款费用
     */
    private java.util.Vector<com.ffcs.crmd.cas.bean.hbbean.prefeecancel.OrderFee> orderFeeList;

    public InParam() {
        super();
        this.orderFeeList = new java.util.Vector<com.ffcs.crmd.cas.bean.hbbean.prefeecancel.OrderFee>();
    }

    /**
     * 
     * 
     * @param vOrderFee
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addOrderFee(final com.ffcs.crmd.cas.bean.hbbean.prefeecancel.OrderFee vOrderFee) throws java.lang.IndexOutOfBoundsException {
        this.orderFeeList.addElement(vOrderFee);
    }

    /**
     * 
     * 
     * @param index
     * @param vOrderFee
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addOrderFee(final int index,final com.ffcs.crmd.cas.bean.hbbean.prefeecancel.OrderFee vOrderFee) throws java.lang.IndexOutOfBoundsException {
        this.orderFeeList.add(index, vOrderFee);
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
     * Method enumerateOrderFee.
     * 
     * @return an Enumeration over all
     * com.ffcs.crmd.cas.bean.hbbean.prefeecancel.OrderFee elements
     */
    public java.util.Enumeration<? extends com.ffcs.crmd.cas.bean.hbbean.prefeecancel.OrderFee> enumerateOrderFee() {
        return this.orderFeeList.elements();
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
     * Method getOrderFee.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.ffcs.crmd.cas.bean.hbbean.prefeecancel.OrderFee at the
     * given index
     */
    public com.ffcs.crmd.cas.bean.hbbean.prefeecancel.OrderFee getOrderFee(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.orderFeeList.size()) {
            throw new IndexOutOfBoundsException("getOrderFee: Index value '" + index + "' not in range [0.." + (this.orderFeeList.size() - 1) + "]");
        }

        return orderFeeList.get(index);
    }

    /**
     * Method getOrderFee.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.ffcs.crmd.cas.bean.hbbean.prefeecancel.OrderFee[] getOrderFee() {
        com.ffcs.crmd.cas.bean.hbbean.prefeecancel.OrderFee[] array = new com.ffcs.crmd.cas.bean.hbbean.prefeecancel.OrderFee[0];
        return this.orderFeeList.toArray(array);
    }

    /**
     * Method getOrderFeeCount.
     * 
     * @return the size of this collection
     */
    public int getOrderFeeCount() {
        return this.orderFeeList.size();
    }

    /**
     * Returns the value of field 'preFee'. The field 'preFee' has
     * the following description: 预受理退款费用
     * 
     * @return the value of field 'PreFee'.
     */
    public com.ffcs.crmd.cas.bean.hbbean.prefeecancel.PreFee getPreFee() {
        return this.preFee;
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
    public void removeAllOrderFee() {
        this.orderFeeList.clear();
    }

    /**
     * Method removeOrderFee.
     * 
     * @param vOrderFee
     * @return true if the object was removed from the collection.
     */
    public boolean removeOrderFee(final com.ffcs.crmd.cas.bean.hbbean.prefeecancel.OrderFee vOrderFee) {
        boolean removed = orderFeeList.remove(vOrderFee);
        return removed;
    }

    /**
     * Method removeOrderFeeAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.ffcs.crmd.cas.bean.hbbean.prefeecancel.OrderFee removeOrderFeeAt(final int index) {
        java.lang.Object obj = this.orderFeeList.remove(index);
        return (com.ffcs.crmd.cas.bean.hbbean.prefeecancel.OrderFee) obj;
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
     * 
     * 
     * @param index
     * @param vOrderFee
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setOrderFee(final int index,final com.ffcs.crmd.cas.bean.hbbean.prefeecancel.OrderFee vOrderFee) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.orderFeeList.size()) {
            throw new IndexOutOfBoundsException("setOrderFee: Index value '" + index + "' not in range [0.." + (this.orderFeeList.size() - 1) + "]");
        }

        this.orderFeeList.set(index, vOrderFee);
    }

    /**
     * 
     * 
     * @param vOrderFeeArray
     */
    public void setOrderFee(final com.ffcs.crmd.cas.bean.hbbean.prefeecancel.OrderFee[] vOrderFeeArray) {
        //-- copy array
        orderFeeList.clear();

        for (int i = 0; i < vOrderFeeArray.length; i++) {
                this.orderFeeList.add(vOrderFeeArray[i]);
        }
    }

    /**
     * Sets the value of field 'preFee'. The field 'preFee' has the
     * following description: 预受理退款费用
     * 
     * @param preFee the value of field 'preFee'.
     */
    public void setPreFee(final com.ffcs.crmd.cas.bean.hbbean.prefeecancel.PreFee preFee) {
        this.preFee = preFee;
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
