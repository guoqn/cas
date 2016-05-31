/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.cancel.cancelorderquery;

/**
 * 撤销信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CancelInfo implements java.io.Serializable {

    /**
     * YES 可以撤销 NO 不能撤销
     */
    private java.lang.String cancelFlag;

    /**
     * 不能撤销的原因
     */
    private java.lang.String reason;

    public CancelInfo() {
        super();
    }

    /**
     * Returns the value of field 'cancelFlag'. The field
     * 'cancelFlag' has the following description: YES 可以撤销 NO 不能撤销
     * 
     * @return the value of field 'CancelFlag'.
     */
    public java.lang.String getCancelFlag() {
        return this.cancelFlag;
    }

    /**
     * Returns the value of field 'reason'. The field 'reason' has
     * the following description: 不能撤销的原因
     * 
     * @return the value of field 'Reason'.
     */
    public java.lang.String getReason() {
        return this.reason;
    }

    /**
     * Sets the value of field 'cancelFlag'. The field 'cancelFlag'
     * has the following description: YES 可以撤销 NO 不能撤销
     * 
     * @param cancelFlag the value of field 'cancelFlag'.
     */
    public void setCancelFlag(final java.lang.String cancelFlag) {
        this.cancelFlag = cancelFlag;
    }

    /**
     * Sets the value of field 'reason'. The field 'reason' has the
     * following description: 不能撤销的原因
     * 
     * @param reason the value of field 'reason'.
     */
    public void setReason(final java.lang.String reason) {
        this.reason = reason;
    }

}
