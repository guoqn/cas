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
public class SaveDocInfoInDTO implements java.io.Serializable {

    /**
     * 文档列表
     */
    private java.util.Vector<com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.DocList> docListList;

    public SaveDocInfoInDTO() {
        super();
        this.docListList = new java.util.Vector<com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.DocList>();
    }

    /**
     * 
     * 
     * @param vDocList
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDocList(final com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.DocList vDocList) throws java.lang.IndexOutOfBoundsException {
        this.docListList.addElement(vDocList);
    }

    /**
     * 
     * 
     * @param index
     * @param vDocList
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDocList(final int index,final com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.DocList vDocList) throws java.lang.IndexOutOfBoundsException {
        this.docListList.add(index, vDocList);
    }

    /**
     * Method enumerateDocList.
     * 
     * @return an Enumeration over all
     * com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.DocList elements
     */
    public java.util.Enumeration<? extends com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.DocList> enumerateDocList() {
        return this.docListList.elements();
    }

    /**
     * Method getDocList.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.DocList at the
     * given index
     */
    public com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.DocList getDocList(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.docListList.size()) {
            throw new IndexOutOfBoundsException("getDocList: Index value '" + index + "' not in range [0.." + (this.docListList.size() - 1) + "]");
        }

        return docListList.get(index);
    }

    /**
     * Method getDocList.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.DocList[] getDocList() {
        com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.DocList[] array = new com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.DocList[0];
        return this.docListList.toArray(array);
    }

    /**
     * Method getDocListCount.
     * 
     * @return the size of this collection
     */
    public int getDocListCount() {
        return this.docListList.size();
    }

    /**
     */
    public void removeAllDocList() {
        this.docListList.clear();
    }

    /**
     * Method removeDocList.
     * 
     * @param vDocList
     * @return true if the object was removed from the collection.
     */
    public boolean removeDocList(final com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.DocList vDocList) {
        boolean removed = docListList.remove(vDocList);
        return removed;
    }

    /**
     * Method removeDocListAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.DocList removeDocListAt(final int index) {
        java.lang.Object obj = this.docListList.remove(index);
        return (com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.DocList) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vDocList
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setDocList(final int index,final com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.DocList vDocList) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.docListList.size()) {
            throw new IndexOutOfBoundsException("setDocList: Index value '" + index + "' not in range [0.." + (this.docListList.size() - 1) + "]");
        }

        this.docListList.set(index, vDocList);
    }

    /**
     * 
     * 
     * @param vDocListArray
     */
    public void setDocList(final com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.DocList[] vDocListArray) {
        //-- copy array
        docListList.clear();

        for (int i = 0; i < vDocListArray.length; i++) {
                this.docListList.add(vDocListArray[i]);
        }
    }

}
