/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.hbbean.preannouncecharge;

/**
 * 响应信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class OutParam implements java.io.Serializable {

    /**
     * 处理结果
     * 0：成功 
     * 1：失败
     * 
     * 对于快速缴费（打入话费），如果计费返回成功，CRM直接更新下账目的付费方式为打入话费并进行销帐处理。
     */
    private java.lang.String result;

    /**
     * 错误信息
     */
    private com.ffcs.crmd.cas.bean.hbbean.comm.Error error;

    public OutParam() {
        super();
    }

    /**
     * Returns the value of field 'error'. The field 'error' has
     * the following description: 错误信息
     * 
     * @return the value of field 'Error'.
     */
    public com.ffcs.crmd.cas.bean.hbbean.comm.Error getError() {
        return this.error;
    }

    /**
     * Returns the value of field 'result'. The field 'result' has
     * the following description: 处理结果
     * 0：成功 
     * 1：失败
     * 
     * 对于快速缴费（打入话费），如果计费返回成功，CRM直接更新下账目的付费方式为打入话费并进行销帐处理。
     * 
     * @return the value of field 'Result'.
     */
    public java.lang.String getResult() {
        return this.result;
    }

    /**
     * Sets the value of field 'error'. The field 'error' has the
     * following description: 错误信息
     * 
     * @param error the value of field 'error'.
     */
    public void setError(final com.ffcs.crmd.cas.bean.hbbean.comm.Error error) {
        this.error = error;
    }

    /**
     * Sets the value of field 'result'. The field 'result' has the
     * following description: 处理结果
     * 0：成功 
     * 1：失败
     * 
     * 对于快速缴费（打入话费），如果计费返回成功，CRM直接更新下账目的付费方式为打入话费并进行销帐处理。
     * 
     * @param result the value of field 'result'.
     */
    public void setResult(final java.lang.String result) {
        this.result = result;
    }

}
