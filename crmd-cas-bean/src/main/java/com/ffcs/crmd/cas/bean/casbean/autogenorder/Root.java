/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.autogenorder;

/**
 * 根节点
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Root implements java.io.Serializable {

    private com.ffcs.crmd.cas.bean.casbean.comm.MsgHead msgHead;

    /**
     * 报文体
     */
    private com.ffcs.crmd.cas.bean.casbean.autogenorder.MsgBody msgBody;

    public Root() {
        super();
    }

    /**
     * Returns the value of field 'msgBody'. The field 'msgBody'
     * has the following description: 报文体
     * 
     * @return the value of field 'MsgBody'.
     */
    public com.ffcs.crmd.cas.bean.casbean.autogenorder.MsgBody getMsgBody() {
        return this.msgBody;
    }

    /**
     * Returns the value of field 'msgHead'.
     * 
     * @return the value of field 'MsgHead'.
     */
    public com.ffcs.crmd.cas.bean.casbean.comm.MsgHead getMsgHead() {
        return this.msgHead;
    }

    /**
     * Sets the value of field 'msgBody'. The field 'msgBody' has
     * the following description: 报文体
     * 
     * @param msgBody the value of field 'msgBody'.
     */
    public void setMsgBody(final com.ffcs.crmd.cas.bean.casbean.autogenorder.MsgBody msgBody) {
        this.msgBody = msgBody;
    }

    /**
     * Sets the value of field 'msgHead'.
     * 
     * @param msgHead the value of field 'msgHead'.
     */
    public void setMsgHead(final com.ffcs.crmd.cas.bean.casbean.comm.MsgHead msgHead) {
        this.msgHead = msgHead;
    }

}
