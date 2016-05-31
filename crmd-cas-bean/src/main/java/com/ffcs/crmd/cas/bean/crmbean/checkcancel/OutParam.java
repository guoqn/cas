/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.crmbean.checkcancel;

/**
 * 响应信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class OutParam implements java.io.Serializable {

    /**
     * 处理结果
     *  0：成功
     *  1：失败
     */
    private java.lang.String result;

    /**
     * 0--自动
     *  1--非自动
     */
    private java.lang.String isCancel;

    private java.util.Vector<com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustSoNumbers> custSoNumbersList;

    /**
     * 错误信息
     */
    private com.ffcs.crmd.cas.bean.crmbean.comm.Error error;

    public OutParam() {
        super();
        this.custSoNumbersList = new java.util.Vector<com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustSoNumbers>();
    }

    /**
     * 
     * 
     * @param vCustSoNumbers
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCustSoNumbers(final com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustSoNumbers vCustSoNumbers) throws java.lang.IndexOutOfBoundsException {
        this.custSoNumbersList.addElement(vCustSoNumbers);
    }

    /**
     * 
     * 
     * @param index
     * @param vCustSoNumbers
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCustSoNumbers(final int index,final com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustSoNumbers vCustSoNumbers) throws java.lang.IndexOutOfBoundsException {
        this.custSoNumbersList.add(index, vCustSoNumbers);
    }

    /**
     * Method enumerateCustSoNumbers.
     * 
     * @return an Enumeration over all
     * com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustSoNumbers
     * elements
     */
    public java.util.Enumeration<? extends com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustSoNumbers> enumerateCustSoNumbers() {
        return this.custSoNumbersList.elements();
    }

    /**
     * Method getCustSoNumbers.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustSoNumbers at
     * the given index
     */
    public com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustSoNumbers getCustSoNumbers(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.custSoNumbersList.size()) {
            throw new IndexOutOfBoundsException("getCustSoNumbers: Index value '" + index + "' not in range [0.." + (this.custSoNumbersList.size() - 1) + "]");
        }

        return custSoNumbersList.get(index);
    }

    /**
     * Method getCustSoNumbers.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustSoNumbers[] getCustSoNumbers() {
        com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustSoNumbers[] array = new com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustSoNumbers[0];
        return this.custSoNumbersList.toArray(array);
    }

    /**
     * Method getCustSoNumbersCount.
     * 
     * @return the size of this collection
     */
    public int getCustSoNumbersCount() {
        return this.custSoNumbersList.size();
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
     * Returns the value of field 'isCancel'. The field 'isCancel'
     * has the following description: 0--自动
     *  1--非自动
     * 
     * @return the value of field 'IsCancel'.
     */
    public java.lang.String getIsCancel() {
        return this.isCancel;
    }

    /**
     * Returns the value of field 'result'. The field 'result' has
     * the following description: 处理结果
     *  0：成功
     *  1：失败
     * 
     * @return the value of field 'Result'.
     */
    public java.lang.String getResult() {
        return this.result;
    }

    /**
     */
    public void removeAllCustSoNumbers() {
        this.custSoNumbersList.clear();
    }

    /**
     * Method removeCustSoNumbers.
     * 
     * @param vCustSoNumbers
     * @return true if the object was removed from the collection.
     */
    public boolean removeCustSoNumbers(final com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustSoNumbers vCustSoNumbers) {
        boolean removed = custSoNumbersList.remove(vCustSoNumbers);
        return removed;
    }

    /**
     * Method removeCustSoNumbersAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustSoNumbers removeCustSoNumbersAt(final int index) {
        java.lang.Object obj = this.custSoNumbersList.remove(index);
        return (com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustSoNumbers) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vCustSoNumbers
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCustSoNumbers(final int index,final com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustSoNumbers vCustSoNumbers) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this.custSoNumbersList.size()) {
            throw new IndexOutOfBoundsException("setCustSoNumbers: Index value '" + index + "' not in range [0.." + (this.custSoNumbersList.size() - 1) + "]");
        }

        this.custSoNumbersList.set(index, vCustSoNumbers);
    }

    /**
     * 
     * 
     * @param vCustSoNumbersArray
     */
    public void setCustSoNumbers(final com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustSoNumbers[] vCustSoNumbersArray) {
        //-- copy array
        custSoNumbersList.clear();

        for (int i = 0; i < vCustSoNumbersArray.length; i++) {
                this.custSoNumbersList.add(vCustSoNumbersArray[i]);
        }
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
     * Sets the value of field 'isCancel'. The field 'isCancel' has
     * the following description: 0--自动
     *  1--非自动
     * 
     * @param isCancel the value of field 'isCancel'.
     */
    public void setIsCancel(final java.lang.String isCancel) {
        this.isCancel = isCancel;
    }

    /**
     * Sets the value of field 'result'. The field 'result' has the
     * following description: 处理结果
     *  0：成功
     *  1：失败
     * 
     * @param result the value of field 'result'.
     */
    public void setResult(final java.lang.String result) {
        this.result = result;
    }

}
