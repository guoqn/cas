/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.casbean.preordercommitcheck;

/**
 * 请求信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class InParam implements java.io.Serializable {

    /**
     * 订单ID
     */
    private long custOrderId;

    /**
     * Keeps track of whether primitive field custOrderId has been
     * set already.
     */
    private boolean hascustOrderId;

    /**
     * 区域id，用于判断区域是否允许2张最后一张单标示
     */
    private long areaId;

    /**
     * Keeps track of whether primitive field areaId has been set
     * already.
     */
    private boolean hasareaId;

    public InParam() {
        super();
    }

    /**
     */
    public void deleteAreaId() {
        this.hasareaId= false;
    }

    /**
     */
    public void deleteCustOrderId() {
        this.hascustOrderId= false;
    }

    /**
     * Returns the value of field 'areaId'. The field 'areaId' has
     * the following description: 区域id，用于判断区域是否允许2张最后一张单标示
     * 
     * @return the value of field 'AreaId'.
     */
    public long getAreaId() {
        return this.areaId;
    }

    /**
     * Returns the value of field 'custOrderId'. The field
     * 'custOrderId' has the following description: 订单ID
     * 
     * @return the value of field 'CustOrderId'.
     */
    public long getCustOrderId() {
        return this.custOrderId;
    }

    /**
     * Method hasAreaId.
     * 
     * @return true if at least one AreaId has been added
     */
    public boolean hasAreaId() {
        return this.hasareaId;
    }

    /**
     * Method hasCustOrderId.
     * 
     * @return true if at least one CustOrderId has been added
     */
    public boolean hasCustOrderId() {
        return this.hascustOrderId;
    }

    /**
     * Sets the value of field 'areaId'. The field 'areaId' has the
     * following description: 区域id，用于判断区域是否允许2张最后一张单标示
     * 
     * @param areaId the value of field 'areaId'.
     */
    public void setAreaId(final long areaId) {
        this.areaId = areaId;
        this.hasareaId = true;
    }

    /**
     * Sets the value of field 'custOrderId'. The field
     * 'custOrderId' has the following description: 订单ID
     * 
     * @param custOrderId the value of field 'custOrderId'.
     */
    public void setCustOrderId(final long custOrderId) {
        this.custOrderId = custOrderId;
        this.hascustOrderId = true;
    }

}
