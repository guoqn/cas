/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.intf.api.dto;

/**
 * 预受理账目项属性
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PreSaleAcctItemAttrInDTO implements java.io.Serializable {

    /**
     * 账目项属性Id
     */
    private long preAcctItemAttrId;


    /**
     * 账目项Id
     */
    private long preAcctItemId;


    /**
     * 属性ID
     */
    private long attrId;



    /**
     * 属性值ID
     */
    private long attrValueId;



    /**
     * 属性值
     */
    private String attrValue;

    public PreSaleAcctItemAttrInDTO() {
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
     * Returns the value of field 'attrValue'. The field
     * 'attrValue' has the following description: 属性值
     *
     * @return the value of field 'AttrValue'.
     */
    public String getAttrValue() {
        return this.attrValue;
    }

    /**
     * Returns the value of field 'attrValueId'. The field
     * 'attrValueId' has the following description: 属性值ID
     *
     * @return the value of field 'AttrValueId'.
     */
    public long getAttrValueId() {
        return this.attrValueId;
    }

    /**
     * Returns the value of field 'preAcctItemAttrId'. The field
     * 'preAcctItemAttrId' has the following description: 账目项属性Id
     *
     * @return the value of field 'PreAcctItemAttrId'.
     */
    public long getPreAcctItemAttrId() {
        return this.preAcctItemAttrId;
    }

    /**
     * Returns the value of field 'preAcctItemId'. The field
     * 'preAcctItemId' has the following description: 账目项Id
     *
     * @return the value of field 'PreAcctItemId'.
     */
    public long getPreAcctItemId() {
        return this.preAcctItemId;
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
     * Sets the value of field 'attrValue'. The field 'attrValue'
     * has the following description: 属性值
     *
     * @param attrValue the value of field 'attrValue'.
     */
    public void setAttrValue(final String attrValue) {
        this.attrValue = attrValue;
    }

    /**
     * Sets the value of field 'attrValueId'. The field
     * 'attrValueId' has the following description: 属性值ID
     * 
     * @param attrValueId the value of field 'attrValueId'.
     */
    public void setAttrValueId(final long attrValueId) {
        this.attrValueId = attrValueId;
    }

    /**
     * Sets the value of field 'preAcctItemAttrId'. The field
     * 'preAcctItemAttrId' has the following description: 账目项属性Id
     * 
     * @param preAcctItemAttrId the value of field
     * 'preAcctItemAttrId'.
     */
    public void setPreAcctItemAttrId(final long preAcctItemAttrId) {
        this.preAcctItemAttrId = preAcctItemAttrId;
    }

    /**
     * Sets the value of field 'preAcctItemId'. The field
     * 'preAcctItemId' has the following description: 账目项Id
     * 
     * @param preAcctItemId the value of field 'preAcctItemId'.
     */
    public void setPreAcctItemId(final long preAcctItemId) {
        this.preAcctItemId = preAcctItemId;
    }

}
