/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.query.querypreorderstatus;

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
     */
    private java.lang.String result;

    /**
     * 错误信息
     */
    private com.ffcs.crmd.cas.bean.casbean.query.querypreorderstatus.Error error;

    /**
     * 状态信息
     */
    private com.ffcs.crmd.cas.bean.casbean.query.querypreorderstatus.StatusInfo statusInfo;

    public OutParam() {
        super();
    }

    /**
     * Returns the value of field 'error'. The field 'error' has
     * the following description: 错误信息
     * 
     * @return the value of field 'Error'.
     */
    public com.ffcs.crmd.cas.bean.casbean.query.querypreorderstatus.Error getError() {
        return this.error;
    }

    /**
     * Returns the value of field 'result'. The field 'result' has
     * the following description: 处理结果
     * 0：成功
     * 1：失败
     * 
     * @return the value of field 'Result'.
     */
    public java.lang.String getResult() {
        return this.result;
    }

    /**
     * Returns the value of field 'statusInfo'. The field
     * 'statusInfo' has the following description: 状态信息
     * 
     * @return the value of field 'StatusInfo'.
     */
    public com.ffcs.crmd.cas.bean.casbean.query.querypreorderstatus.StatusInfo getStatusInfo() {
        return this.statusInfo;
    }

    /**
     * Sets the value of field 'error'. The field 'error' has the
     * following description: 错误信息
     * 
     * @param error the value of field 'error'.
     */
    public void setError(final com.ffcs.crmd.cas.bean.casbean.query.querypreorderstatus.Error error) {
        this.error = error;
    }

    /**
     * Sets the value of field 'result'. The field 'result' has the
     * following description: 处理结果
     * 0：成功
     * 1：失败
     * 
     * @param result the value of field 'result'.
     */
    public void setResult(final java.lang.String result) {
        this.result = result;
    }

    /**
     * Sets the value of field 'statusInfo'. The field 'statusInfo'
     * has the following description: 状态信息
     * 
     * @param statusInfo the value of field 'statusInfo'.
     */
    public void setStatusInfo(final com.ffcs.crmd.cas.bean.casbean.query.querypreorderstatus.StatusInfo statusInfo) {
        this.statusInfo = statusInfo;
    }

}
