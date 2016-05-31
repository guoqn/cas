/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.crmbean.queryParty;

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
    private com.ffcs.crmd.cas.bean.crmbean.comm.Error error;

    private java.util.Vector<com.ffcs.crmd.cas.bean.crmbean.queryParty.PartyContactInfo> partyContactInfoList;

    public OutParam() {
        super();
        this.partyContactInfoList = new java.util.Vector<com.ffcs.crmd.cas.bean.crmbean.queryParty.PartyContactInfo>();
    }

    /**
     * 
     * 
     * @param vPartyContactInfo
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPartyContactInfo(final com.ffcs.crmd.cas.bean.crmbean.queryParty.PartyContactInfo vPartyContactInfo) throws java.lang.IndexOutOfBoundsException {
        this.partyContactInfoList.addElement(vPartyContactInfo);
    }

    /**
     * 
     * 
     * @param index
     * @param vPartyContactInfo
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPartyContactInfo(final int index,final com.ffcs.crmd.cas.bean.crmbean.queryParty.PartyContactInfo vPartyContactInfo) throws java.lang.IndexOutOfBoundsException {
        this.partyContactInfoList.add(index, vPartyContactInfo);
    }

    /**
     * Method enumeratePartyContactInfo.
     * 
     * @return an Enumeration over all
     * com.ffcs.crmd.cas.bean.crmbean.queryParty.PartyContactInfo
     * elements
     */
    public java.util.Enumeration<? extends com.ffcs.crmd.cas.bean.crmbean.queryParty.PartyContactInfo> enumeratePartyContactInfo() {
        return this.partyContactInfoList.elements();
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
     * Method getPartyContactInfo.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.ffcs.crmd.cas.bean.crmbean.queryParty.PartyContactInfo
     * at the given index
     */
    public com.ffcs.crmd.cas.bean.crmbean.queryParty.PartyContactInfo getPartyContactInfo(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.partyContactInfoList.size()) {
            throw new IndexOutOfBoundsException("getPartyContactInfo: Index value '" + index + "' not in range [0.." + (this.partyContactInfoList.size() - 1) + "]");
        }

        return partyContactInfoList.get(index);
    }

    /**
     * Method getPartyContactInfo.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.ffcs.crmd.cas.bean.crmbean.queryParty.PartyContactInfo[] getPartyContactInfo() {
        com.ffcs.crmd.cas.bean.crmbean.queryParty.PartyContactInfo[] array = new com.ffcs.crmd.cas.bean.crmbean.queryParty.PartyContactInfo[0];
        return this.partyContactInfoList.toArray(array);
    }

    /**
     * Method getPartyContactInfoCount.
     * 
     * @return the size of this collection
     */
    public int getPartyContactInfoCount() {
        return this.partyContactInfoList.size();
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
    public void removeAllPartyContactInfo() {
        this.partyContactInfoList.clear();
    }

    /**
     * Method removePartyContactInfo.
     * 
     * @param vPartyContactInfo
     * @return true if the object was removed from the collection.
     */
    public boolean removePartyContactInfo(final com.ffcs.crmd.cas.bean.crmbean.queryParty.PartyContactInfo vPartyContactInfo) {
        boolean removed = partyContactInfoList.remove(vPartyContactInfo);
        return removed;
    }

    /**
     * Method removePartyContactInfoAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.ffcs.crmd.cas.bean.crmbean.queryParty.PartyContactInfo removePartyContactInfoAt(final int index) {
        java.lang.Object obj = this.partyContactInfoList.remove(index);
        return (com.ffcs.crmd.cas.bean.crmbean.queryParty.PartyContactInfo) obj;
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
     * 
     * 
     * @param index
     * @param vPartyContactInfo
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setPartyContactInfo(final int index,final com.ffcs.crmd.cas.bean.crmbean.queryParty.PartyContactInfo vPartyContactInfo) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.partyContactInfoList.size()) {
            throw new IndexOutOfBoundsException("setPartyContactInfo: Index value '" + index + "' not in range [0.." + (this.partyContactInfoList.size() - 1) + "]");
        }

        this.partyContactInfoList.set(index, vPartyContactInfo);
    }

    /**
     * 
     * 
     * @param vPartyContactInfoArray
     */
    public void setPartyContactInfo(final com.ffcs.crmd.cas.bean.crmbean.queryParty.PartyContactInfo[] vPartyContactInfoArray) {
        //-- copy array
        partyContactInfoList.clear();

        for (int i = 0; i < vPartyContactInfoArray.length; i++) {
                this.partyContactInfoList.add(vPartyContactInfoArray[i]);
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
    }

}
