/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.modpreorderbean.notifyPreSaleOrder;

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
     * P单的FJ单号
     */
    private String custSoNumber;

    /**
     * 动作(确认或竣工，CRM对应的值)
     */
    private String action;

    public InParam() {
        super();
    }

    /**
     * Returns the value of field 'action'. The field 'action' has
     * the following description: 动作(确认或竣工，CRM对应的值)
     *
     * @return the value of field 'Action'.
     */
    public String getAction() {
        return this.action;
    }

    /**
     * Returns the value of field 'custSoNumber'. The field
     * 'custSoNumber' has the following description: P单的FJ单号
     *
     * @return the value of field 'CustSoNumber'.
     */
    public String getCustSoNumber() {
        return this.custSoNumber;
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
     * Sets the value of field 'action'. The field 'action' has the
     * following description: 动作(确认或竣工，CRM对应的值)
     *
     * @param action the value of field 'action'.
     */
    public void setAction(final String action) {
        this.action = action;
    }

    /**
     * Sets the value of field 'custSoNumber'. The field
     * 'custSoNumber' has the following description: P单的FJ单号
     *
     * @param custSoNumber the value of field 'custSoNumber'.
     */
    public void setCustSoNumber(final String custSoNumber) {
        this.custSoNumber = custSoNumber;
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
