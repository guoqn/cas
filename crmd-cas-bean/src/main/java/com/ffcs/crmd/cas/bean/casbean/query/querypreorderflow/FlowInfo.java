/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.query.querypreorderflow;

/**
 * 状态信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class FlowInfo implements java.io.Serializable {

    /**
     * 处理人员
     */
    private java.lang.String staffName;

    /**
     * 时间
     */
    private java.lang.String operateDate;

    /**
     * 动作
     */
    private java.lang.String actionName;

    /**
     * 描述
     */
    private java.lang.String desc;

    public FlowInfo() {
        super();
    }

    /**
     * Returns the value of field 'actionName'. The field
     * 'actionName' has the following description: 动作
     * 
     * @return the value of field 'ActionName'.
     */
    public java.lang.String getActionName() {
        return this.actionName;
    }

    /**
     * Returns the value of field 'desc'. The field 'desc' has the
     * following description: 描述
     * 
     * @return the value of field 'Desc'.
     */
    public java.lang.String getDesc() {
        return this.desc;
    }

    /**
     * Returns the value of field 'operateDate'. The field
     * 'operateDate' has the following description: 时间
     * 
     * @return the value of field 'OperateDate'.
     */
    public java.lang.String getOperateDate() {
        return this.operateDate;
    }

    /**
     * Returns the value of field 'staffName'. The field
     * 'staffName' has the following description: 处理人员
     * 
     * @return the value of field 'StaffName'.
     */
    public java.lang.String getStaffName() {
        return this.staffName;
    }

    /**
     * Sets the value of field 'actionName'. The field 'actionName'
     * has the following description: 动作
     * 
     * @param actionName the value of field 'actionName'.
     */
    public void setActionName(final java.lang.String actionName) {
        this.actionName = actionName;
    }

    /**
     * Sets the value of field 'desc'. The field 'desc' has the
     * following description: 描述
     * 
     * @param desc the value of field 'desc'.
     */
    public void setDesc(final java.lang.String desc) {
        this.desc = desc;
    }

    /**
     * Sets the value of field 'operateDate'. The field
     * 'operateDate' has the following description: 时间
     * 
     * @param operateDate the value of field 'operateDate'.
     */
    public void setOperateDate(final java.lang.String operateDate) {
        this.operateDate = operateDate;
    }

    /**
     * Sets the value of field 'staffName'. The field 'staffName'
     * has the following description: 处理人员
     * 
     * @param staffName the value of field 'staffName'.
     */
    public void setStaffName(final java.lang.String staffName) {
        this.staffName = staffName;
    }

}
