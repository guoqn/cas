/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.hbbean.preannouncecharge;

/**
 * 请求信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class InParam implements java.io.Serializable {

    /**
     * 帐务处理请求类型:
     * 0、收费
     * 3：补收款
     * 字段长度： 1
     */
    private long reqType;

    /**
     * Keeps track of whether primitive field reqType has been set
     * already.
     */
    private boolean hasreqType;

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
     * 预受理单号
     */
    private java.lang.String preCustSoNum;

    /**
     * 业务号码 
     */
    private java.lang.String accNbr;

    /**
     * 客户名称
     */
    private java.lang.String custName;

    private java.util.Vector<com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.FeeItem> feeItemList;

    public InParam() {
        super();
        this.feeItemList = new java.util.Vector<com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.FeeItem>();
    }

    /**
     * 
     * 
     * @param vFeeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFeeItem(final com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.FeeItem vFeeItem) throws java.lang.IndexOutOfBoundsException {
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
    public void addFeeItem(final int index,final com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.FeeItem vFeeItem) throws java.lang.IndexOutOfBoundsException {
        this.feeItemList.add(index, vFeeItem);
    }

    /**
     */
    public void deleteReqType() {
        this.hasreqType= false;
    }

    /**
     */
    public void deleteStaffPositionId() {
        this.hasstaffPositionId= false;
    }

    /**
     * Method enumerateFeeItem.
     * 
     * @return an Enumeration over all
     * com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.FeeItem
     * elements
     */
    public java.util.Enumeration<? extends com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.FeeItem> enumerateFeeItem() {
        return this.feeItemList.elements();
    }

    /**
     * Returns the value of field 'accNbr'. The field 'accNbr' has
     * the following description: 业务号码 
     * 
     * @return the value of field 'AccNbr'.
     */
    public java.lang.String getAccNbr() {
        return this.accNbr;
    }

    /**
     * Returns the value of field 'custName'. The field 'custName'
     * has the following description: 客户名称
     * 
     * @return the value of field 'CustName'.
     */
    public java.lang.String getCustName() {
        return this.custName;
    }

    /**
     * Method getFeeItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.FeeItem at
     * the given index
     */
    public com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.FeeItem getFeeItem(final int index) throws java.lang.IndexOutOfBoundsException {
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
    public com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.FeeItem[] getFeeItem() {
        com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.FeeItem[] array = new com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.FeeItem[0];
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
     * Returns the value of field 'latnId'. The field 'latnId' has
     * the following description: 受理团队区域（如591）
     * 
     * @return the value of field 'LatnId'.
     */
    public java.lang.String getLatnId() {
        return this.latnId;
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
     * Returns the value of field 'reqType'. The field 'reqType'
     * has the following description: 帐务处理请求类型:
     * 0、收费
     * 3：补收款
     * 字段长度： 1
     * 
     * @return the value of field 'ReqType'.
     */
    public long getReqType() {
        return this.reqType;
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
     * Method hasReqType.
     * 
     * @return true if at least one ReqType has been added
     */
    public boolean hasReqType() {
        return this.hasreqType;
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
    public boolean removeFeeItem(final com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.FeeItem vFeeItem) {
        boolean removed = feeItemList.remove(vFeeItem);
        return removed;
    }

    /**
     * Method removeFeeItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.FeeItem removeFeeItemAt(final int index) {
        java.lang.Object obj = this.feeItemList.remove(index);
        return (com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.FeeItem) obj;
    }

    /**
     * Sets the value of field 'accNbr'. The field 'accNbr' has the
     * following description: 业务号码 
     * 
     * @param accNbr the value of field 'accNbr'.
     */
    public void setAccNbr(final java.lang.String accNbr) {
        this.accNbr = accNbr;
    }

    /**
     * Sets the value of field 'custName'. The field 'custName' has
     * the following description: 客户名称
     * 
     * @param custName the value of field 'custName'.
     */
    public void setCustName(final java.lang.String custName) {
        this.custName = custName;
    }

    /**
     * 
     * 
     * @param index
     * @param vFeeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setFeeItem(final int index,final com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.FeeItem vFeeItem) throws java.lang.IndexOutOfBoundsException {
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
    public void setFeeItem(final com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.FeeItem[] vFeeItemArray) {
        //-- copy array
        feeItemList.clear();

        for (int i = 0; i < vFeeItemArray.length; i++) {
                this.feeItemList.add(vFeeItemArray[i]);
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
     * Sets the value of field 'preCustSoNum'. The field
     * 'preCustSoNum' has the following description: 预受理单号
     * 
     * @param preCustSoNum the value of field 'preCustSoNum'.
     */
    public void setPreCustSoNum(final java.lang.String preCustSoNum) {
        this.preCustSoNum = preCustSoNum;
    }

    /**
     * Sets the value of field 'reqType'. The field 'reqType' has
     * the following description: 帐务处理请求类型:
     * 0、收费
     * 3：补收款
     * 字段长度： 1
     * 
     * @param reqType the value of field 'reqType'.
     */
    public void setReqType(final long reqType) {
        this.reqType = reqType;
        this.hasreqType = true;
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

}
