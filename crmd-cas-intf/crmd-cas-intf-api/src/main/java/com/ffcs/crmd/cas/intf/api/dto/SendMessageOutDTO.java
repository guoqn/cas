package com.ffcs.crmd.cas.intf.api.dto;


/**
 * 响应信息
 *
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SendMessageOutDTO implements java.io.Serializable{
    /**
     * 处理结果
     * 0：成功
     * 1：失败
     */
    private String result;

    /**
     * 错误信息
     */
    private com.ffcs.crmd.cas.bean.smsbean.comm.Error error;

    public SendMessageOutDTO() {
        super();
    }

    /**
     * Returns the value of field 'error'. The field 'error' has
     * the following description: 错误信息
     *
     * @return the value of field 'Error'.
     */
    public com.ffcs.crmd.cas.bean.smsbean.comm.Error getError() {
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
    public String getResult() {
        return this.result;
    }

    /**
     * Sets the value of field 'error'. The field 'error' has the
     * following description: 错误信息
     *
     * @param error the value of field 'error'.
     */
    public void setError(final com.ffcs.crmd.cas.bean.smsbean.comm.Error error) {
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
    public void setResult(final String result) {
        this.result = result;
    }
}
