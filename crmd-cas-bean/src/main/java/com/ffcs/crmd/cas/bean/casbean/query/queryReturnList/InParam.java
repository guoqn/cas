/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.query.queryReturnList;

/**
 * 请求信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class InParam implements java.io.Serializable {

    private java.lang.String saleStaffId;

    private java.lang.String saleOrgId;

    /**
     * 当前页号
     */
    private int currentPage;

    /**
     * Keeps track of whether primitive field currentPage has been
     * set already.
     */
    private boolean hascurrentPage;

    /**
     * 每页多少条
     */
    private int perPageNum;

    /**
     * Keeps track of whether primitive field perPageNum has been
     * set already.
     */
    private boolean hasperPageNum;

    public InParam() {
        super();
    }

    /**
     */
    public void deleteCurrentPage() {
        this.hascurrentPage= false;
    }

    /**
     */
    public void deletePerPageNum() {
        this.hasperPageNum= false;
    }

    /**
     * Returns the value of field 'currentPage'. The field
     * 'currentPage' has the following description: 当前页号
     * 
     * @return the value of field 'CurrentPage'.
     */
    public int getCurrentPage() {
        return this.currentPage;
    }

    /**
     * Returns the value of field 'perPageNum'. The field
     * 'perPageNum' has the following description: 每页多少条
     * 
     * @return the value of field 'PerPageNum'.
     */
    public int getPerPageNum() {
        return this.perPageNum;
    }

    /**
     * Returns the value of field 'saleOrgId'.
     * 
     * @return the value of field 'SaleOrgId'.
     */
    public java.lang.String getSaleOrgId() {
        return this.saleOrgId;
    }

    /**
     * Returns the value of field 'saleStaffId'.
     * 
     * @return the value of field 'SaleStaffId'.
     */
    public java.lang.String getSaleStaffId() {
        return this.saleStaffId;
    }

    /**
     * Method hasCurrentPage.
     * 
     * @return true if at least one CurrentPage has been added
     */
    public boolean hasCurrentPage() {
        return this.hascurrentPage;
    }

    /**
     * Method hasPerPageNum.
     * 
     * @return true if at least one PerPageNum has been added
     */
    public boolean hasPerPageNum() {
        return this.hasperPageNum;
    }

    /**
     * Sets the value of field 'currentPage'. The field
     * 'currentPage' has the following description: 当前页号
     * 
     * @param currentPage the value of field 'currentPage'.
     */
    public void setCurrentPage(final int currentPage) {
        this.currentPage = currentPage;
        this.hascurrentPage = true;
    }

    /**
     * Sets the value of field 'perPageNum'. The field 'perPageNum'
     * has the following description: 每页多少条
     * 
     * @param perPageNum the value of field 'perPageNum'.
     */
    public void setPerPageNum(final int perPageNum) {
        this.perPageNum = perPageNum;
        this.hasperPageNum = true;
    }

    /**
     * Sets the value of field 'saleOrgId'.
     * 
     * @param saleOrgId the value of field 'saleOrgId'.
     */
    public void setSaleOrgId(final java.lang.String saleOrgId) {
        this.saleOrgId = saleOrgId;
    }

    /**
     * Sets the value of field 'saleStaffId'.
     * 
     * @param saleStaffId the value of field 'saleStaffId'.
     */
    public void setSaleStaffId(final java.lang.String saleStaffId) {
        this.saleStaffId = saleStaffId;
    }

}
