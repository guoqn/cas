/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.crmbean.continueacceptconfirm;

/**
 * 错误信息
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Error implements java.io.Serializable {

    private java.lang.String id;

    private java.lang.String message;

    public Error() {
        super();
    }

    /**
     * Returns the value of field 'id'.
     * 
     * @return the value of field 'Id'.
     */
    public java.lang.String getId() {
        return this.id;
    }

    /**
     * Returns the value of field 'message'.
     * 
     * @return the value of field 'Message'.
     */
    public java.lang.String getMessage() {
        return this.message;
    }

    /**
     * Sets the value of field 'id'.
     * 
     * @param id the value of field 'id'.
     */
    public void setId(final java.lang.String id) {
        this.id = id;
    }

    /**
     * Sets the value of field 'message'.
     * 
     * @param message the value of field 'message'.
     */
    public void setMessage(final java.lang.String message) {
        this.message = message;
    }

}
