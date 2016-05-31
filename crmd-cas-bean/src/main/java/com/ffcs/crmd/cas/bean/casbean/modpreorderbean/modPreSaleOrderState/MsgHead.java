/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.modpreorderbean.modPreSaleOrderState;

/**
 * 消息头
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class MsgHead implements java.io.Serializable {

    /**
     * 发送消息包时间
     * YYYYMMDDHH24MISS
     */
    private String time;

    /**
     * 发送系统，标识消息包来源（系统名暂定：CRM）
     */
    private String from;

    /**
     * 接收系统，标识消息包目的系统（系统名暂定：WorkOrderDispatch）
     */
    private String to;

    /**
     * 发起系统签名，如接收系统无校验，默认为123
     */
    private String sysSign;

    /**
     * 消息类型，填接口调用的方法名称:modPreSaleOrderState
     */
    private String msgType;

    /**
     * 流水号，消息包唯一标识，反馈包体中的流水号应该对应于请求包体中的流水号
     */
    private String serial;

    public MsgHead() {
        super();
    }

    /**
     * Returns the value of field 'from'. The field 'from' has the
     * following description: 发送系统，标识消息包来源（系统名暂定：CRM）
     *
     * @return the value of field 'From'.
     */
    public String getFrom() {
        return this.from;
    }

    /**
     * Returns the value of field 'msgType'. The field 'msgType'
     * has the following description:
     * 消息类型，填接口调用的方法名称:modPreSaleOrderState
     *
     * @return the value of field 'MsgType'.
     */
    public String getMsgType() {
        return this.msgType;
    }

    /**
     * Returns the value of field 'serial'. The field 'serial' has
     * the following description:
     * 流水号，消息包唯一标识，反馈包体中的流水号应该对应于请求包体中的流水号
     *
     * @return the value of field 'Serial'.
     */
    public String getSerial() {
        return this.serial;
    }

    /**
     * Returns the value of field 'sysSign'. The field 'sysSign'
     * has the following description: 发起系统签名，如接收系统无校验，默认为123
     *
     * @return the value of field 'SysSign'.
     */
    public String getSysSign() {
        return this.sysSign;
    }

    /**
     * Returns the value of field 'time'. The field 'time' has the
     * following description: 发送消息包时间
     * YYYYMMDDHH24MISS
     *
     *
     * @return the value of field 'Time'.
     */
    public String getTime() {
        return this.time;
    }

    /**
     * Returns the value of field 'to'. The field 'to' has the
     * following description:
     * 接收系统，标识消息包目的系统（系统名暂定：WorkOrderDispatch）
     *
     * @return the value of field 'To'.
     */
    public String getTo() {
        return this.to;
    }

    /**
     * Sets the value of field 'from'. The field 'from' has the
     * following description: 发送系统，标识消息包来源（系统名暂定：CRM）
     *
     * @param from the value of field 'from'.
     */
    public void setFrom(final String from) {
        this.from = from;
    }

    /**
     * Sets the value of field 'msgType'. The field 'msgType' has
     * the following description:
     * 消息类型，填接口调用的方法名称:modPreSaleOrderState
     *
     * @param msgType the value of field 'msgType'.
     */
    public void setMsgType(final String msgType) {
        this.msgType = msgType;
    }

    /**
     * Sets the value of field 'serial'. The field 'serial' has the
     * following description: 流水号，消息包唯一标识，反馈包体中的流水号应该对应于请求包体中的流水号
     *
     * @param serial the value of field 'serial'.
     */
    public void setSerial(final String serial) {
        this.serial = serial;
    }

    /**
     * Sets the value of field 'sysSign'. The field 'sysSign' has
     * the following description: 发起系统签名，如接收系统无校验，默认为123
     *
     * @param sysSign the value of field 'sysSign'.
     */
    public void setSysSign(final String sysSign) {
        this.sysSign = sysSign;
    }

    /**
     * Sets the value of field 'time'. The field 'time' has the
     * following description: 发送消息包时间
     * YYYYMMDDHH24MISS
     *
     *
     * @param time the value of field 'time'.
     */
    public void setTime(final String time) {
        this.time = time;
    }

    /**
     * Sets the value of field 'to'. The field 'to' has the
     * following description:
     * 接收系统，标识消息包目的系统（系统名暂定：WorkOrderDispatch）
     *
     * @param to the value of field 'to'.
     */
    public void setTo(final String to) {
        this.to = to;
    }

}
