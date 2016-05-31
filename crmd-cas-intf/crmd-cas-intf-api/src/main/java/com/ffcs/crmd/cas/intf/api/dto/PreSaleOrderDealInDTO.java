/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.intf.api.dto;

/**
 * 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PreSaleOrderDealInDTO implements java.io.Serializable {

    private long preOrderId;

    /**
     * Keeps track of whether primitive field preOrderId has been
     * set already.
     */
    private boolean haspreOrderId;

    private String ifEnd;

    private String isOnWay;

    public PreSaleOrderDealInDTO() {
        super();
    }

    /**
     */
    public void deletePreOrderId() {
        this.haspreOrderId= false;
    }

    /**
     * Returns the value of field 'ifEnd'.
     *
     * @return the value of field 'IfEnd'.
     */
    public String getIfEnd() {
        return this.ifEnd;
    }

    /**
     * Returns the value of field 'isOnWay'.
     *
     * @return the value of field 'IsOnWay'.
     */
    public String getIsOnWay() {
        return this.isOnWay;
    }

    /**
     * Returns the value of field 'preOrderId'.
     *
     * @return the value of field 'PreOrderId'.
     */
    public long getPreOrderId() {
        return this.preOrderId;
    }

    /**
     * Method hasPreOrderId.
     *
     * @return true if at least one PreOrderId has been added
     */
    public boolean hasPreOrderId() {
        return this.haspreOrderId;
    }

    /**
     * Sets the value of field 'ifEnd'.
     *
     * @param ifEnd the value of field 'ifEnd'.
     */
    public void setIfEnd(final String ifEnd) {
        this.ifEnd = ifEnd;
    }

    /**
     * Sets the value of field 'isOnWay'.
     *
     * @param isOnWay the value of field 'isOnWay'.
     */
    public void setIsOnWay(final String isOnWay) {
        this.isOnWay = isOnWay;
    }

    /**
     * Sets the value of field 'preOrderId'.
     * 
     * @param preOrderId the value of field 'preOrderId'.
     */
    public void setPreOrderId(final long preOrderId) {
        this.preOrderId = preOrderId;
        this.haspreOrderId = true;
    }

}
