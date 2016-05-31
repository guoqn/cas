/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.crmbean.queryParty;

/**
 * 请求信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class InParam implements java.io.Serializable {

    private java.util.Vector<java.lang.String> objIdList;

    /**
     * 0:custId 1:staffId
     */
    private java.lang.String type;

    public InParam() {
        super();
        this.objIdList = new java.util.Vector<java.lang.String>();
    }

    /**
     * 
     * 
     * @param vObjId
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addObjId(final java.lang.String vObjId) throws java.lang.IndexOutOfBoundsException {
        this.objIdList.addElement(vObjId);
    }

    /**
     * 
     * 
     * @param index
     * @param vObjId
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addObjId(final int index,final java.lang.String vObjId) throws java.lang.IndexOutOfBoundsException {
        this.objIdList.add(index, vObjId);
    }

    /**
     * Method enumerateObjId.
     * 
     * @return an Enumeration over all java.lang.String elements
     */
    public java.util.Enumeration<? extends java.lang.String> enumerateObjId() {
        return this.objIdList.elements();
    }

    /**
     * Method getObjId.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getObjId(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.objIdList.size()) {
            throw new IndexOutOfBoundsException("getObjId: Index value '" + index + "' not in range [0.." + (this.objIdList.size() - 1) + "]");
        }

        return (java.lang.String) objIdList.get(index);
    }

    /**
     * Method getObjId.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getObjId() {
        java.lang.String[] array = new java.lang.String[0];
        return this.objIdList.toArray(array);
    }

    /**
     * Method getObjIdCount.
     * 
     * @return the size of this collection
     */
    public int getObjIdCount() {
        return this.objIdList.size();
    }

    /**
     * Returns the value of field 'type'. The field 'type' has the
     * following description: 0:custId 1:staffId
     * 
     * @return the value of field 'Type'.
     */
    public java.lang.String getType() {
        return this.type;
    }

    /**
     */
    public void removeAllObjId() {
        this.objIdList.clear();
    }

    /**
     * Method removeObjId.
     * 
     * @param vObjId
     * @return true if the object was removed from the collection.
     */
    public boolean removeObjId(final java.lang.String vObjId) {
        boolean removed = objIdList.remove(vObjId);
        return removed;
    }

    /**
     * Method removeObjIdAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeObjIdAt(final int index) {
        java.lang.Object obj = this.objIdList.remove(index);
        return (java.lang.String) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vObjId
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setObjId(final int index,final java.lang.String vObjId) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.objIdList.size()) {
            throw new IndexOutOfBoundsException("setObjId: Index value '" + index + "' not in range [0.." + (this.objIdList.size() - 1) + "]");
        }

        this.objIdList.set(index, vObjId);
    }

    /**
     * 
     * 
     * @param vObjIdArray
     */
    public void setObjId(final java.lang.String[] vObjIdArray) {
        //-- copy array
        objIdList.clear();

        for (int i = 0; i < vObjIdArray.length; i++) {
                this.objIdList.add(vObjIdArray[i]);
        }
    }

    /**
     * Sets the value of field 'type'. The field 'type' has the
     * following description: 0:custId 1:staffId
     * 
     * @param type the value of field 'type'.
     */
    public void setType(final java.lang.String type) {
        this.type = type;
    }

}
