/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.hbbean.prefeequery;

/**
 * 预受理费用信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class FeeItem implements java.io.Serializable {

    /**
     * 费用名称
     * 字段长度： 30
     */
    private java.lang.String feeItemName;

    /**
     * 费用类型分类：
     * 00A－不打印发票和凭单
     * 00B－打印凭单
     * 00C－打印发票
     */
    private java.lang.String feeItemClass;

    /**
     * 预受理账目ID
     */
    private long preFeeId;

    /**
     * Keeps track of whether primitive field preFeeId has been set
     * already.
     */
    private boolean haspreFeeId;

    /**
     * 金额（单位分）
     * 字段长度： 16
     */
    private long amount;

    /**
     * Keeps track of whether primitive field amount has been set
     * already.
     */
    private boolean hasamount;

    /**
     * 状态 
     * 5SA 未销帐，
     * 5SB 已销账 
     */
    private java.lang.String state;

    /**
     * 支付方式 
     * 100000 现金
     * 140004 代办点余额支付
     * 150001 翼支付支付
     */
    private java.lang.String chargeMethod;

    public FeeItem() {
        super();
    }

    /**
     */
    public void deleteAmount() {
        this.hasamount= false;
    }

    /**
     */
    public void deletePreFeeId() {
        this.haspreFeeId= false;
    }

    /**
     * Returns the value of field 'amount'. The field 'amount' has
     * the following description: 金额（单位分）
     * 字段长度： 16
     * 
     * @return the value of field 'Amount'.
     */
    public long getAmount() {
        return this.amount;
    }

    /**
     * Returns the value of field 'chargeMethod'. The field
     * 'chargeMethod' has the following description: 支付方式 
     * 100000 现金
     * 140004 代办点余额支付
     * 150001 翼支付支付
     * 
     * @return the value of field 'ChargeMethod'.
     */
    public java.lang.String getChargeMethod() {
        return this.chargeMethod;
    }

    /**
     * Returns the value of field 'feeItemClass'. The field
     * 'feeItemClass' has the following description: 费用类型分类：
     * 00A－不打印发票和凭单
     * 00B－打印凭单
     * 00C－打印发票
     * 
     * @return the value of field 'FeeItemClass'.
     */
    public java.lang.String getFeeItemClass() {
        return this.feeItemClass;
    }

    /**
     * Returns the value of field 'feeItemName'. The field
     * 'feeItemName' has the following description: 费用名称
     * 字段长度： 30
     * 
     * @return the value of field 'FeeItemName'.
     */
    public java.lang.String getFeeItemName() {
        return this.feeItemName;
    }

    /**
     * Returns the value of field 'preFeeId'. The field 'preFeeId'
     * has the following description: 预受理账目ID
     * 
     * @return the value of field 'PreFeeId'.
     */
    public long getPreFeeId() {
        return this.preFeeId;
    }

    /**
     * Returns the value of field 'state'. The field 'state' has
     * the following description: 状态 
     * 5SA 未销帐，
     * 5SB 已销账 
     * 
     * @return the value of field 'State'.
     */
    public java.lang.String getState() {
        return this.state;
    }

    /**
     * Method hasAmount.
     * 
     * @return true if at least one Amount has been added
     */
    public boolean hasAmount() {
        return this.hasamount;
    }

    /**
     * Method hasPreFeeId.
     * 
     * @return true if at least one PreFeeId has been added
     */
    public boolean hasPreFeeId() {
        return this.haspreFeeId;
    }

    /**
     * Sets the value of field 'amount'. The field 'amount' has the
     * following description: 金额（单位分）
     * 字段长度： 16
     * 
     * @param amount the value of field 'amount'.
     */
    public void setAmount(final long amount) {
        this.amount = amount;
        this.hasamount = true;
    }

    /**
     * Sets the value of field 'chargeMethod'. The field
     * 'chargeMethod' has the following description: 支付方式 
     * 100000 现金
     * 140004 代办点余额支付
     * 150001 翼支付支付
     * 
     * @param chargeMethod the value of field 'chargeMethod'.
     */
    public void setChargeMethod(final java.lang.String chargeMethod) {
        this.chargeMethod = chargeMethod;
    }

    /**
     * Sets the value of field 'feeItemClass'. The field
     * 'feeItemClass' has the following description: 费用类型分类：
     * 00A－不打印发票和凭单
     * 00B－打印凭单
     * 00C－打印发票
     * 
     * @param feeItemClass the value of field 'feeItemClass'.
     */
    public void setFeeItemClass(final java.lang.String feeItemClass) {
        this.feeItemClass = feeItemClass;
    }

    /**
     * Sets the value of field 'feeItemName'. The field
     * 'feeItemName' has the following description: 费用名称
     * 字段长度： 30
     * 
     * @param feeItemName the value of field 'feeItemName'.
     */
    public void setFeeItemName(final java.lang.String feeItemName) {
        this.feeItemName = feeItemName;
    }

    /**
     * Sets the value of field 'preFeeId'. The field 'preFeeId' has
     * the following description: 预受理账目ID
     * 
     * @param preFeeId the value of field 'preFeeId'.
     */
    public void setPreFeeId(final long preFeeId) {
        this.preFeeId = preFeeId;
        this.haspreFeeId = true;
    }

    /**
     * Sets the value of field 'state'. The field 'state' has the
     * following description: 状态 
     * 5SA 未销帐，
     * 5SB 已销账 
     * 
     * @param state the value of field 'state'.
     */
    public void setState(final java.lang.String state) {
        this.state = state;
    }

}
