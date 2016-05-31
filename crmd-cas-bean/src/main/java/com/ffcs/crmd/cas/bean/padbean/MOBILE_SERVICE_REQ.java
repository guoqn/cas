/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.padbean;

/**
 * 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class MOBILE_SERVICE_REQ implements java.io.Serializable {

    /**
     * 请求类型
     */
    private com.ffcs.crmd.cas.bean.padbean.QRY_TYPE QRY_TYPE;

    private com.ffcs.crmd.cas.bean.padbean.QRY_BODY QRY_BODY;

    public MOBILE_SERVICE_REQ() {
        super();
    }

    /**
     * Returns the value of field 'QRY_BODY'.
     * 
     * @return the value of field 'QRY_BODY'.
     */
    public com.ffcs.crmd.cas.bean.padbean.QRY_BODY getQRY_BODY() {
        return this.QRY_BODY;
    }

    /**
     * Returns the value of field 'QRY_TYPE'. The field 'QRY_TYPE'
     * has the following description: 请求类型
     * 
     * @return the value of field 'QRY_TYPE'.
     */
    public com.ffcs.crmd.cas.bean.padbean.QRY_TYPE getQRY_TYPE() {
        return this.QRY_TYPE;
    }

    /**
     * Sets the value of field 'QRY_BODY'.
     * 
     * @param QRY_BODY the value of field 'QRY_BODY'.
     */
    public void setQRY_BODY(final com.ffcs.crmd.cas.bean.padbean.QRY_BODY QRY_BODY) {
        this.QRY_BODY = QRY_BODY;
    }

    /**
     * Sets the value of field 'QRY_TYPE'. The field 'QRY_TYPE' has
     * the following description: 请求类型
     * 
     * @param QRY_TYPE the value of field 'QRY_TYPE'.
     */
    public void setQRY_TYPE(final com.ffcs.crmd.cas.bean.padbean.QRY_TYPE QRY_TYPE) {
        this.QRY_TYPE = QRY_TYPE;
    }

}
