/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.intf.api.dto;

/**
 * 请求信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SendMessageInDTO implements java.io.Serializable {

    /**
     * 接入号码
     */
    private String accNbr;

    /**
     * 区号
     */
    private String areaCode;

    /**
     * 发送内容
     */
    private String msg;

    /**
     * 短信类型
     * 0：实时发送（任意时间调用接口立刻发送到用户终端）
     * 1：非作息时间发送（8:00-12:30
     * 14:50-21:00时间段发送，如果不在该时间段则保存到临时表，直到该时间段到了才发送）
     */
    private long type;

    /**
     * Keeps track of whether primitive field type has been set
     * already.
     */
    private boolean hastype;

    public SendMessageInDTO() {
        super();
    }

    /**
     */
    public void deleteType() {
        this.hastype= false;
    }

    /**
     * Returns the value of field 'accNbr'. The field 'accNbr' has
     * the following description: 接入号码
     *
     * @return the value of field 'AccNbr'.
     */
    public String getAccNbr() {
        return this.accNbr;
    }

    /**
     * Returns the value of field 'areaCode'. The field 'areaCode'
     * has the following description: 区号
     *
     * @return the value of field 'AreaCode'.
     */
    public String getAreaCode() {
        return this.areaCode;
    }

    /**
     * Returns the value of field 'msg'. The field 'msg' has the
     * following description: 发送内容
     *
     * @return the value of field 'Msg'.
     */
    public String getMsg() {
        return this.msg;
    }

    /**
     * Returns the value of field 'type'. The field 'type' has the
     * following description: 短信类型
     * 0：实时发送（任意时间调用接口立刻发送到用户终端）
     * 1：非作息时间发送（8:00-12:30
     * 14:50-21:00时间段发送，如果不在该时间段则保存到临时表，直到该时间段到了才发送）
     *
     * @return the value of field 'Type'.
     */
    public long getType() {
        return this.type;
    }

    /**
     * Method hasType.
     *
     * @return true if at least one Type has been added
     */
    public boolean hasType() {
        return this.hastype;
    }

    /**
     * Sets the value of field 'accNbr'. The field 'accNbr' has the
     * following description: 接入号码
     *
     * @param accNbr the value of field 'accNbr'.
     */
    public void setAccNbr(final String accNbr) {
        this.accNbr = accNbr;
    }

    /**
     * Sets the value of field 'areaCode'. The field 'areaCode' has
     * the following description: 区号
     *
     * @param areaCode the value of field 'areaCode'.
     */
    public void setAreaCode(final String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * Sets the value of field 'msg'. The field 'msg' has the
     * following description: 发送内容
     *
     * @param msg the value of field 'msg'.
     */
    public void setMsg(final String msg) {
        this.msg = msg;
    }

    /**
     * Sets the value of field 'type'. The field 'type' has the
     * following description: 短信类型
     * 0：实时发送（任意时间调用接口立刻发送到用户终端）
     * 1：非作息时间发送（8:00-12:30
     * 14:50-21:00时间段发送，如果不在该时间段则保存到临时表，直到该时间段到了才发送）
     * 
     * @param type the value of field 'type'.
     */
    public void setType(final long type) {
        this.type = type;
        this.hastype = true;
    }

}
