/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.autogenorder;

/**
 * 证件信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Cust implements java.io.Serializable {

    /**
     * 证件类型：1
     */
    private java.lang.String certType;

    /**
     * 证件名称：身份证
     */
    private java.lang.String certTypeName;

    /**
     * 证件号码：身份证号码
     */
    private java.lang.String certNumber;

    public Cust() {
        super();
    }

    /**
     * Returns the value of field 'certNumber'. The field
     * 'certNumber' has the following description: 证件号码：身份证号码
     * 
     * @return the value of field 'CertNumber'.
     */
    public java.lang.String getCertNumber() {
        return this.certNumber;
    }

    /**
     * Returns the value of field 'certType'. The field 'certType'
     * has the following description: 证件类型：1
     * 
     * @return the value of field 'CertType'.
     */
    public java.lang.String getCertType() {
        return this.certType;
    }

    /**
     * Returns the value of field 'certTypeName'. The field
     * 'certTypeName' has the following description: 证件名称：身份证
     * 
     * @return the value of field 'CertTypeName'.
     */
    public java.lang.String getCertTypeName() {
        return this.certTypeName;
    }

    /**
     * Sets the value of field 'certNumber'. The field 'certNumber'
     * has the following description: 证件号码：身份证号码
     * 
     * @param certNumber the value of field 'certNumber'.
     */
    public void setCertNumber(final java.lang.String certNumber) {
        this.certNumber = certNumber;
    }

    /**
     * Sets the value of field 'certType'. The field 'certType' has
     * the following description: 证件类型：1
     * 
     * @param certType the value of field 'certType'.
     */
    public void setCertType(final java.lang.String certType) {
        this.certType = certType;
    }

    /**
     * Sets the value of field 'certTypeName'. The field
     * 'certTypeName' has the following description: 证件名称：身份证
     * 
     * @param certTypeName the value of field 'certTypeName'.
     */
    public void setCertTypeName(final java.lang.String certTypeName) {
        this.certTypeName = certTypeName;
    }

}
