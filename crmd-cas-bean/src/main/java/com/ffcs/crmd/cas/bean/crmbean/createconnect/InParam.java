/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.crmbean.createconnect;

/**
 * 请求信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class InParam implements java.io.Serializable {

    private java.util.Vector<com.ffcs.crmd.cas.bean.crmbean.createconnect.ConnectInfo> connectInfoList;

    public InParam() {
        super();
        this.connectInfoList = new java.util.Vector<com.ffcs.crmd.cas.bean.crmbean.createconnect.ConnectInfo>();
    }

    /**
     * 
     * 
     * @param vConnectInfo
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addConnectInfo(final com.ffcs.crmd.cas.bean.crmbean.createconnect.ConnectInfo vConnectInfo) throws java.lang.IndexOutOfBoundsException {
        this.connectInfoList.addElement(vConnectInfo);
    }

    /**
     * 
     * 
     * @param index
     * @param vConnectInfo
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addConnectInfo(final int index,final com.ffcs.crmd.cas.bean.crmbean.createconnect.ConnectInfo vConnectInfo) throws java.lang.IndexOutOfBoundsException {
        this.connectInfoList.add(index, vConnectInfo);
    }

    /**
     * Method enumerateConnectInfo.
     * 
     * @return an Enumeration over all
     * com.ffcs.crmd.cas.bean.crmbean.createconnect.ConnectInfo
     * elements
     */
    public java.util.Enumeration<? extends com.ffcs.crmd.cas.bean.crmbean.createconnect.ConnectInfo> enumerateConnectInfo() {
        return this.connectInfoList.elements();
    }

    /**
     * Method getConnectInfo.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.ffcs.crmd.cas.bean.crmbean.createconnect.ConnectInfo at
     * the given index
     */
    public com.ffcs.crmd.cas.bean.crmbean.createconnect.ConnectInfo getConnectInfo(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.connectInfoList.size()) {
            throw new IndexOutOfBoundsException("getConnectInfo: Index value '" + index + "' not in range [0.." + (this.connectInfoList.size() - 1) + "]");
        }

        return connectInfoList.get(index);
    }

    /**
     * Method getConnectInfo.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.ffcs.crmd.cas.bean.crmbean.createconnect.ConnectInfo[] getConnectInfo() {
        com.ffcs.crmd.cas.bean.crmbean.createconnect.ConnectInfo[] array = new com.ffcs.crmd.cas.bean.crmbean.createconnect.ConnectInfo[0];
        return this.connectInfoList.toArray(array);
    }

    /**
     * Method getConnectInfoCount.
     * 
     * @return the size of this collection
     */
    public int getConnectInfoCount() {
        return this.connectInfoList.size();
    }

    /**
     */
    public void removeAllConnectInfo() {
        this.connectInfoList.clear();
    }

    /**
     * Method removeConnectInfo.
     * 
     * @param vConnectInfo
     * @return true if the object was removed from the collection.
     */
    public boolean removeConnectInfo(final com.ffcs.crmd.cas.bean.crmbean.createconnect.ConnectInfo vConnectInfo) {
        boolean removed = connectInfoList.remove(vConnectInfo);
        return removed;
    }

    /**
     * Method removeConnectInfoAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.ffcs.crmd.cas.bean.crmbean.createconnect.ConnectInfo removeConnectInfoAt(final int index) {
        java.lang.Object obj = this.connectInfoList.remove(index);
        return (com.ffcs.crmd.cas.bean.crmbean.createconnect.ConnectInfo) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vConnectInfo
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setConnectInfo(final int index,final com.ffcs.crmd.cas.bean.crmbean.createconnect.ConnectInfo vConnectInfo) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.connectInfoList.size()) {
            throw new IndexOutOfBoundsException("setConnectInfo: Index value '" + index + "' not in range [0.." + (this.connectInfoList.size() - 1) + "]");
        }

        this.connectInfoList.set(index, vConnectInfo);
    }

    /**
     * 
     * 
     * @param vConnectInfoArray
     */
    public void setConnectInfo(final com.ffcs.crmd.cas.bean.crmbean.createconnect.ConnectInfo[] vConnectInfoArray) {
        //-- copy array
        connectInfoList.clear();

        for (int i = 0; i < vConnectInfoArray.length; i++) {
                this.connectInfoList.add(vConnectInfoArray[i]);
        }
    }

}
