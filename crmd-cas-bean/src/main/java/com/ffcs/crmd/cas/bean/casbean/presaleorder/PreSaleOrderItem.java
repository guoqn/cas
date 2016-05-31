/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.presaleorder;

/**
 * 预受理订单项
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PreSaleOrderItem implements java.io.Serializable {

    /**
     * 预受理订单项Id
     */
    private long preOrderItemId;

    /**
     * Keeps track of whether primitive field preOrderItemId has
     * been set already.
     */
    private boolean haspreOrderItemId;

    /**
     * 预受理订单Id
     */
    private long preOrderId;

    /**
     * Keeps track of whether primitive field preOrderId has been
     * set already.
     */
    private boolean haspreOrderId;

    /**
     * 属性ID
     */
    private long attrId;

    /**
     * Keeps track of whether primitive field attrId has been set
     * already.
     */
    private boolean hasattrId;

    /**
     * javaCode
     */
    private java.lang.String javaCode;

    /**
     * 父类订单项ID
     */
    private long superItemId;

    /**
     * Keeps track of whether primitive field superItemId has been
     * set already.
     */
    private boolean hassuperItemId;

    /**
     * 参数2
     */
    private java.lang.String attrParam2;

    public PreSaleOrderItem() {
        super();
    }

    /**
     */
    public void deleteAttrId() {
        this.hasattrId= false;
    }

    /**
     */
    public void deletePreOrderId() {
        this.haspreOrderId= false;
    }

    /**
     */
    public void deletePreOrderItemId() {
        this.haspreOrderItemId= false;
    }

    /**
     */
    public void deleteSuperItemId() {
        this.hassuperItemId= false;
    }

    /**
     * Returns the value of field 'attrId'. The field 'attrId' has
     * the following description: 属性ID
     * 
     * @return the value of field 'AttrId'.
     */
    public long getAttrId() {
        return this.attrId;
    }

    /**
     * Returns the value of field 'attrParam2'. The field
     * 'attrParam2' has the following description: 参数2
     * 
     * @return the value of field 'AttrParam2'.
     */
    public java.lang.String getAttrParam2() {
        return this.attrParam2;
    }

    /**
     * Returns the value of field 'javaCode'. The field 'javaCode'
     * has the following description: javaCode
     * 
     * @return the value of field 'JavaCode'.
     */
    public java.lang.String getJavaCode() {
        return this.javaCode;
    }

    /**
     * Returns the value of field 'preOrderId'. The field
     * 'preOrderId' has the following description: 预受理订单Id
     * 
     * @return the value of field 'PreOrderId'.
     */
    public long getPreOrderId() {
        return this.preOrderId;
    }

    /**
     * Returns the value of field 'preOrderItemId'. The field
     * 'preOrderItemId' has the following description: 预受理订单项Id
     * 
     * @return the value of field 'PreOrderItemId'.
     */
    public long getPreOrderItemId() {
        return this.preOrderItemId;
    }

    /**
     * Returns the value of field 'superItemId'. The field
     * 'superItemId' has the following description: 父类订单项ID
     * 
     * @return the value of field 'SuperItemId'.
     */
    public long getSuperItemId() {
        return this.superItemId;
    }

    /**
     * Method hasAttrId.
     * 
     * @return true if at least one AttrId has been added
     */
    public boolean hasAttrId() {
        return this.hasattrId;
    }

    /**
     * Method hasPreOrderId.
     * 
     * @return true if at least one PreOrderId has been added
     */
    public boolean hasPreOrderId() {
        return this.haspreOrderId;
    }

    /**
     * Method hasPreOrderItemId.
     * 
     * @return true if at least one PreOrderItemId has been added
     */
    public boolean hasPreOrderItemId() {
        return this.haspreOrderItemId;
    }

    /**
     * Method hasSuperItemId.
     * 
     * @return true if at least one SuperItemId has been added
     */
    public boolean hasSuperItemId() {
        return this.hassuperItemId;
    }

    /**
     * Sets the value of field 'attrId'. The field 'attrId' has the
     * following description: 属性ID
     * 
     * @param attrId the value of field 'attrId'.
     */
    public void setAttrId(final long attrId) {
        this.attrId = attrId;
        this.hasattrId = true;
    }

    /**
     * Sets the value of field 'attrParam2'. The field 'attrParam2'
     * has the following description: 参数2
     * 
     * @param attrParam2 the value of field 'attrParam2'.
     */
    public void setAttrParam2(final java.lang.String attrParam2) {
        this.attrParam2 = attrParam2;
    }

    /**
     * Sets the value of field 'javaCode'. The field 'javaCode' has
     * the following description: javaCode
     * 
     * @param javaCode the value of field 'javaCode'.
     */
    public void setJavaCode(final java.lang.String javaCode) {
        this.javaCode = javaCode;
    }

    /**
     * Sets the value of field 'preOrderId'. The field 'preOrderId'
     * has the following description: 预受理订单Id
     * 
     * @param preOrderId the value of field 'preOrderId'.
     */
    public void setPreOrderId(final long preOrderId) {
        this.preOrderId = preOrderId;
        this.haspreOrderId = true;
    }

    /**
     * Sets the value of field 'preOrderItemId'. The field
     * 'preOrderItemId' has the following description: 预受理订单项Id
     * 
     * @param preOrderItemId the value of field 'preOrderItemId'.
     */
    public void setPreOrderItemId(final long preOrderItemId) {
        this.preOrderItemId = preOrderItemId;
        this.haspreOrderItemId = true;
    }

    /**
     * Sets the value of field 'superItemId'. The field
     * 'superItemId' has the following description: 父类订单项ID
     * 
     * @param superItemId the value of field 'superItemId'.
     */
    public void setSuperItemId(final long superItemId) {
        this.superItemId = superItemId;
        this.hassuperItemId = true;
    }

}
