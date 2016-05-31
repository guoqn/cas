/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.intf.api.dto;

/**
 * 预受理订单项
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PreSaleOrderItemInDTO implements java.io.Serializable {

    /**
     * 预受理订单项Id
     */
    private long preOrderItemId;

    /**
     * 预受理订单Id
     */
    private long preOrderId;


    /**
     * 属性ID
     */
    private long attrId;

    /**
     * javaCode
     */
    private String javaCode;

    /**
     * 父类订单项ID
     */
    private long superItemId;

    /**
     * 参数2
     */
    private String attrParam2;

    public PreSaleOrderItemInDTO() {
        super();
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
    public String getAttrParam2() {
        return this.attrParam2;
    }

    /**
     * Returns the value of field 'javaCode'. The field 'javaCode'
     * has the following description: javaCode
     *
     * @return the value of field 'JavaCode'.
     */
    public String getJavaCode() {
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
     * Sets the value of field 'attrId'. The field 'attrId' has the
     * following description: 属性ID
     *
     * @param attrId the value of field 'attrId'.
     */
    public void setAttrId(final long attrId) {
        this.attrId = attrId;
    }

    /**
     * Sets the value of field 'attrParam2'. The field 'attrParam2'
     * has the following description: 参数2
     *
     * @param attrParam2 the value of field 'attrParam2'.
     */
    public void setAttrParam2(final String attrParam2) {
        this.attrParam2 = attrParam2;
    }

    /**
     * Sets the value of field 'javaCode'. The field 'javaCode' has
     * the following description: javaCode
     *
     * @param javaCode the value of field 'javaCode'.
     */
    public void setJavaCode(final String javaCode) {
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
    }

    /**
     * Sets the value of field 'preOrderItemId'. The field
     * 'preOrderItemId' has the following description: 预受理订单项Id
     *
     * @param preOrderItemId the value of field 'preOrderItemId'.
     */
    public void setPreOrderItemId(final long preOrderItemId) {
        this.preOrderItemId = preOrderItemId;
    }

    /**
     * Sets the value of field 'superItemId'. The field
     * 'superItemId' has the following description: 父类订单项ID
     *
     * @param superItemId the value of field 'superItemId'.
     */
    public void setSuperItemId(final long superItemId) {
        this.superItemId = superItemId;
    }

}
