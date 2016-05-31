/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.intf.api.dto;

/**
 * 响应信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CheckRelIntfDepOrderOutDTO implements java.io.Serializable {

    /**
     * 处理结果
     * 0：成功
     * 1：失败
     */
    private String result;

    /**
     * 0--关联intfDepOrder
     * 1--不关联intfDepOrder
     */
    private String isRel;

    /**
     * 错误信息
     */
    private com.ffcs.crmd.cas.bean.crmbean.comm.Error error;

    public CheckRelIntfDepOrderOutDTO() {
        super();
    }

    /**
     * Returns the value of field 'error'. The field 'error' has
     * the following description: 错误信息
     *
     * @return the value of field 'Error'.
     */
    public com.ffcs.crmd.cas.bean.crmbean.comm.Error getError() {
        return this.error;
    }

    /**
     * Returns the value of field 'isRel'. The field 'isRel' has
     * the following description: 0--关联intfDepOrder
     * 1--不关联intfDepOrder
     *
     * @return the value of field 'IsRel'.
     */
    public String getIsRel() {
        return this.isRel;
    }

    /**
     * Returns the value of field 'result'. The field 'result' has
     * the following description: 处理结果
     * 0：成功
     * 1：失败
     *
     * @return the value of field 'Result'.
     */
    public String getResult() {
        return this.result;
    }

    /**
     * Sets the value of field 'error'. The field 'error' has the
     * following description: 错误信息
     *
     * @param error the value of field 'error'.
     */
    public void setError(final com.ffcs.crmd.cas.bean.crmbean.comm.Error error) {
        this.error = error;
    }

    /**
     * Sets the value of field 'isRel'. The field 'isRel' has the
     * following description: 0--关联intfDepOrder
     * 1--不关联intfDepOrder
     *
     * @param isRel the value of field 'isRel'.
     */
    public void setIsRel(final String isRel) {
        this.isRel = isRel;
    }

    /**
     * Sets the value of field 'result'. The field 'result' has the
     * following description: 处理结果
     * 0：成功
     * 1：失败
     *
     * @param result the value of field 'result'.
     */
    public void setResult(final String result) {
        this.result = result;
    }

}
