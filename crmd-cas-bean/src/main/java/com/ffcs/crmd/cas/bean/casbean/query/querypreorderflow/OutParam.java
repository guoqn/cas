/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.query.querypreorderflow;

/**
 * 响应信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class OutParam implements java.io.Serializable {

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * 处理结果
     * 0：成功
     * 1：失败
     */
    private java.lang.String result;

    private java.util.Vector<com.ffcs.crmd.cas.bean.casbean.query.querypreorderflow.FlowInfo> flowInfoList;

    /**
     * 错误信息
     */
    private com.ffcs.crmd.cas.bean.casbean.comm.Error error;

    public OutParam() {
        super();
        this.flowInfoList = new java.util.Vector<com.ffcs.crmd.cas.bean.casbean.query.querypreorderflow.FlowInfo>();
    }

    /**
     * 
     * 
     * @param vFlowInfo
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFlowInfo(final com.ffcs.crmd.cas.bean.casbean.query.querypreorderflow.FlowInfo vFlowInfo) throws java.lang.IndexOutOfBoundsException {
        this.flowInfoList.addElement(vFlowInfo);
    }

    /**
     * 
     * 
     * @param index
     * @param vFlowInfo
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFlowInfo(final int index,final com.ffcs.crmd.cas.bean.casbean.query.querypreorderflow.FlowInfo vFlowInfo) throws java.lang.IndexOutOfBoundsException {
        this.flowInfoList.add(index, vFlowInfo);
    }

    /**
     * Method enumerateFlowInfo.
     * 
     * @return an Enumeration over all
     * com.ffcs.crmd.cas.bean.casbean.query.querypreorderflow.FlowInfo
     * elements
     */
    public java.util.Enumeration<? extends com.ffcs.crmd.cas.bean.casbean.query.querypreorderflow.FlowInfo> enumerateFlowInfo() {
        return this.flowInfoList.elements();
    }

    /**
     * Returns the value of field 'choiceValue'. The field
     * 'choiceValue' has the following description: Internal choice
     * value storage
     * 
     * @return the value of field 'ChoiceValue'.
     */
    public java.lang.Object getChoiceValue() {
        return this._choiceValue;
    }

    /**
     * Returns the value of field 'error'. The field 'error' has
     * the following description: 错误信息
     * 
     * @return the value of field 'Error'.
     */
    public com.ffcs.crmd.cas.bean.casbean.comm.Error getError() {
        return this.error;
    }

    /**
     * Method getFlowInfo.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.ffcs.crmd.cas.bean.casbean.query.querypreorderflow.FlowInfo
     * at the given index
     */
    public com.ffcs.crmd.cas.bean.casbean.query.querypreorderflow.FlowInfo getFlowInfo(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.flowInfoList.size()) {
            throw new IndexOutOfBoundsException("getFlowInfo: Index value '" + index + "' not in range [0.." + (this.flowInfoList.size() - 1) + "]");
        }

        return flowInfoList.get(index);
    }

    /**
     * Method getFlowInfo.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.ffcs.crmd.cas.bean.casbean.query.querypreorderflow.FlowInfo[] getFlowInfo() {
        com.ffcs.crmd.cas.bean.casbean.query.querypreorderflow.FlowInfo[] array = new com.ffcs.crmd.cas.bean.casbean.query.querypreorderflow.FlowInfo[0];
        return this.flowInfoList.toArray(array);
    }

    /**
     * Method getFlowInfoCount.
     * 
     * @return the size of this collection
     */
    public int getFlowInfoCount() {
        return this.flowInfoList.size();
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
     */
    public void removeAllFlowInfo() {
        this.flowInfoList.clear();
    }

    /**
     * Method removeFlowInfo.
     * 
     * @param vFlowInfo
     * @return true if the object was removed from the collection.
     */
    public boolean removeFlowInfo(final com.ffcs.crmd.cas.bean.casbean.query.querypreorderflow.FlowInfo vFlowInfo) {
        boolean removed = flowInfoList.remove(vFlowInfo);
        return removed;
    }

    /**
     * Method removeFlowInfoAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.ffcs.crmd.cas.bean.casbean.query.querypreorderflow.FlowInfo removeFlowInfoAt(final int index) {
        java.lang.Object obj = this.flowInfoList.remove(index);
        return (com.ffcs.crmd.cas.bean.casbean.query.querypreorderflow.FlowInfo) obj;
    }

    /**
     * Sets the value of field 'error'. The field 'error' has the
     * following description: 错误信息
     * 
     * @param error the value of field 'error'.
     */
    public void setError(final com.ffcs.crmd.cas.bean.casbean.comm.Error error) {
        this.error = error;
        this._choiceValue = error;
    }

    /**
     * 
     * 
     * @param index
     * @param vFlowInfo
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setFlowInfo(final int index,final com.ffcs.crmd.cas.bean.casbean.query.querypreorderflow.FlowInfo vFlowInfo) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.flowInfoList.size()) {
            throw new IndexOutOfBoundsException("setFlowInfo: Index value '" + index + "' not in range [0.." + (this.flowInfoList.size() - 1) + "]");
        }

        this.flowInfoList.set(index, vFlowInfo);
    }

    /**
     * 
     * 
     * @param vFlowInfoArray
     */
    public void setFlowInfo(final com.ffcs.crmd.cas.bean.casbean.query.querypreorderflow.FlowInfo[] vFlowInfoArray) {
        //-- copy array
        flowInfoList.clear();

        for (int i = 0; i < vFlowInfoArray.length; i++) {
                this.flowInfoList.add(vFlowInfoArray[i]);
        }
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
        this._choiceValue = result;
    }

}
