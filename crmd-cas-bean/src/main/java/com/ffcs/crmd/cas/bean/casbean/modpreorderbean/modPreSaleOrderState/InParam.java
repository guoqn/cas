/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.modpreorderbean.modPreSaleOrderState;

/**
 * 请求信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class InParam implements java.io.Serializable {

    /**
     * P单号
     */
    private String preOrderNumber;

    /**
     * P单原状态
     */
    private String oldStatusCd;

    /**
     * P单新状态
     */
    private String newStatusCd;

    public InParam() {
        super();
    }

    /**
     * Returns the value of field 'newStatusCd'. The field
     * 'newStatusCd' has the following description: P单新状态
     *
     * @return the value of field 'NewStatusCd'.
     */
    public String getNewStatusCd() {
        return this.newStatusCd;
    }

    /**
     * Returns the value of field 'oldStatusCd'. The field
     * 'oldStatusCd' has the following description: P单原状态
     *
     * @return the value of field 'OldStatusCd'.
     */
    public String getOldStatusCd() {
        return this.oldStatusCd;
    }

    /**
     * Returns the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: P单号
     *
     * @return the value of field 'PreOrderNumber'.
     */
    public String getPreOrderNumber() {
        return this.preOrderNumber;
    }

    /**
     * Sets the value of field 'newStatusCd'. The field
     * 'newStatusCd' has the following description: P单新状态
     *
     * @param newStatusCd the value of field 'newStatusCd'.
     */
    public void setNewStatusCd(final String newStatusCd) {
        this.newStatusCd = newStatusCd;
    }

    /**
     * Sets the value of field 'oldStatusCd'. The field
     * 'oldStatusCd' has the following description: P单原状态
     *
     * @param oldStatusCd the value of field 'oldStatusCd'.
     */
    public void setOldStatusCd(final String oldStatusCd) {
        this.oldStatusCd = oldStatusCd;
    }

    /**
     * Sets the value of field 'preOrderNumber'. The field
     * 'preOrderNumber' has the following description: P单号
     *
     * @param preOrderNumber the value of field 'preOrderNumber'.
     */
    public void setPreOrderNumber(final String preOrderNumber) {
        this.preOrderNumber = preOrderNumber;
    }

}
