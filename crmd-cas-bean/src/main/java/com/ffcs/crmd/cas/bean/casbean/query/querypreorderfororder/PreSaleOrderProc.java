/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.query.querypreorderfororder;

/**
 * 协销人信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PreSaleOrderProc implements java.io.Serializable {

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    private long staffId;

    /**
     * Keeps track of whether primitive field staffId has been set
     * already.
     */
    private boolean hasstaffId;

    private java.lang.String createDate;

    private java.lang.String customerInteractionEventIdName;

    private java.lang.String attrDesc;

    public PreSaleOrderProc() {
        super();
    }

    /**
     */
    public void deleteStaffId() {
        this.hasstaffId= false;
    }

    /**
     * Returns the value of field 'attrDesc'.
     * 
     * @return the value of field 'AttrDesc'.
     */
    public java.lang.String getAttrDesc() {
        return this.attrDesc;
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
     * Returns the value of field 'createDate'.
     * 
     * @return the value of field 'CreateDate'.
     */
    public java.lang.String getCreateDate() {
        return this.createDate;
    }

    /**
     * Returns the value of field 'customerInteractionEventIdName'.
     * 
     * @return the value of field 'CustomerInteractionEventIdName'.
     */
    public java.lang.String getCustomerInteractionEventIdName() {
        return this.customerInteractionEventIdName;
    }

    /**
     * Returns the value of field 'staffId'.
     * 
     * @return the value of field 'StaffId'.
     */
    public long getStaffId() {
        return this.staffId;
    }

    /**
     * Method hasStaffId.
     * 
     * @return true if at least one StaffId has been added
     */
    public boolean hasStaffId() {
        return this.hasstaffId;
    }

    /**
     * Sets the value of field 'attrDesc'.
     * 
     * @param attrDesc the value of field 'attrDesc'.
     */
    public void setAttrDesc(final java.lang.String attrDesc) {
        this.attrDesc = attrDesc;
        this._choiceValue = attrDesc;
    }

    /**
     * Sets the value of field 'createDate'.
     * 
     * @param createDate the value of field 'createDate'.
     */
    public void setCreateDate(final java.lang.String createDate) {
        this.createDate = createDate;
        this._choiceValue = createDate;
    }

    /**
     * Sets the value of field 'customerInteractionEventIdName'.
     * 
     * @param customerInteractionEventIdName the value of field
     * 'customerInteractionEventIdName'.
     */
    public void setCustomerInteractionEventIdName(final java.lang.String customerInteractionEventIdName) {
        this.customerInteractionEventIdName = customerInteractionEventIdName;
        this._choiceValue = customerInteractionEventIdName;
    }

    /**
     * Sets the value of field 'staffId'.
     * 
     * @param staffId the value of field 'staffId'.
     */
    public void setStaffId(final long staffId) {
        this.staffId = staffId;
        this._choiceValue = new java.lang.Long(staffId);
        this.hasstaffId = true;
    }

}
