/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.intfpreordercommit;

/**
 * 请求信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class InParam implements java.io.Serializable {

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * intfPreOrder
     */
    private java.util.Vector<com.ffcs.crmd.cas.bean.casbean.intfpreordercommit.IntfPreOrder> intfPreOrderList;

    public InParam() {
        super();
        this.intfPreOrderList = new java.util.Vector<com.ffcs.crmd.cas.bean.casbean.intfpreordercommit.IntfPreOrder>();
    }

    /**
     * 
     * 
     * @param vIntfPreOrder
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addIntfPreOrder(final com.ffcs.crmd.cas.bean.casbean.intfpreordercommit.IntfPreOrder vIntfPreOrder) throws java.lang.IndexOutOfBoundsException {
        this.intfPreOrderList.addElement(vIntfPreOrder);
    }

    /**
     * 
     * 
     * @param index
     * @param vIntfPreOrder
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addIntfPreOrder(final int index,final com.ffcs.crmd.cas.bean.casbean.intfpreordercommit.IntfPreOrder vIntfPreOrder) throws java.lang.IndexOutOfBoundsException {
        this.intfPreOrderList.add(index, vIntfPreOrder);
    }

    /**
     * Method enumerateIntfPreOrder.
     * 
     * @return an Enumeration over all
     * com.ffcs.crmd.cas.bean.casbean.intfpreordercommit.IntfPreOrder
     * elements
     */
    public java.util.Enumeration<? extends com.ffcs.crmd.cas.bean.casbean.intfpreordercommit.IntfPreOrder> enumerateIntfPreOrder() {
        return this.intfPreOrderList.elements();
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
     * Method getIntfPreOrder.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.ffcs.crmd.cas.bean.casbean.intfpreordercommit.IntfPreOrder
     * at the given index
     */
    public com.ffcs.crmd.cas.bean.casbean.intfpreordercommit.IntfPreOrder getIntfPreOrder(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.intfPreOrderList.size()) {
            throw new IndexOutOfBoundsException("getIntfPreOrder: Index value '" + index + "' not in range [0.." + (this.intfPreOrderList.size() - 1) + "]");
        }

        return intfPreOrderList.get(index);
    }

    /**
     * Method getIntfPreOrder.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.ffcs.crmd.cas.bean.casbean.intfpreordercommit.IntfPreOrder[] getIntfPreOrder() {
        com.ffcs.crmd.cas.bean.casbean.intfpreordercommit.IntfPreOrder[] array = new com.ffcs.crmd.cas.bean.casbean.intfpreordercommit.IntfPreOrder[0];
        return this.intfPreOrderList.toArray(array);
    }

    /**
     * Method getIntfPreOrderCount.
     * 
     * @return the size of this collection
     */
    public int getIntfPreOrderCount() {
        return this.intfPreOrderList.size();
    }

    /**
     */
    public void removeAllIntfPreOrder() {
        this.intfPreOrderList.clear();
    }

    /**
     * Method removeIntfPreOrder.
     * 
     * @param vIntfPreOrder
     * @return true if the object was removed from the collection.
     */
    public boolean removeIntfPreOrder(final com.ffcs.crmd.cas.bean.casbean.intfpreordercommit.IntfPreOrder vIntfPreOrder) {
        boolean removed = intfPreOrderList.remove(vIntfPreOrder);
        return removed;
    }

    /**
     * Method removeIntfPreOrderAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.ffcs.crmd.cas.bean.casbean.intfpreordercommit.IntfPreOrder removeIntfPreOrderAt(final int index) {
        java.lang.Object obj = this.intfPreOrderList.remove(index);
        return (com.ffcs.crmd.cas.bean.casbean.intfpreordercommit.IntfPreOrder) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vIntfPreOrder
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setIntfPreOrder(final int index,final com.ffcs.crmd.cas.bean.casbean.intfpreordercommit.IntfPreOrder vIntfPreOrder) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.intfPreOrderList.size()) {
            throw new IndexOutOfBoundsException("setIntfPreOrder: Index value '" + index + "' not in range [0.." + (this.intfPreOrderList.size() - 1) + "]");
        }

        this.intfPreOrderList.set(index, vIntfPreOrder);
    }

    /**
     * 
     * 
     * @param vIntfPreOrderArray
     */
    public void setIntfPreOrder(final com.ffcs.crmd.cas.bean.casbean.intfpreordercommit.IntfPreOrder[] vIntfPreOrderArray) {
        //-- copy array
        intfPreOrderList.clear();

        for (int i = 0; i < vIntfPreOrderArray.length; i++) {
                this.intfPreOrderList.add(vIntfPreOrderArray[i]);
        }
    }

}
