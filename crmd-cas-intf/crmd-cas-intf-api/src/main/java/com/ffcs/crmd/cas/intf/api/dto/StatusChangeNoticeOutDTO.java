/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.intf.api.dto;

/**
 * 预受理单状态更新输出
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class StatusChangeNoticeOutDTO implements java.io.Serializable {

    /**
     * 错误信息
     */
    private com.ffcs.crmd.cas.bean.padbean.ERROR ERROR;

    /**
     * 处理结果
     */
    private String RESULT;

    public StatusChangeNoticeOutDTO() {
        super();
    }

    /**
     * Returns the value of field 'ERROR'. The field 'ERROR' has
     * the following description: 错误信息
     *
     * @return the value of field 'ERROR'.
     */
    public com.ffcs.crmd.cas.bean.padbean.ERROR getERROR() {
        return this.ERROR;
    }

    /**
     * Returns the value of field 'RESULT'. The field 'RESULT' has
     * the following description: 处理结果
     *
     * @return the value of field 'RESULT'.
     */
    public String getRESULT() {
        return this.RESULT;
    }

    /**
     * Sets the value of field 'ERROR'. The field 'ERROR' has the
     * following description: 错误信息
     *
     * @param ERROR the value of field 'ERROR'.
     */
    public void setERROR(final com.ffcs.crmd.cas.bean.padbean.ERROR ERROR) {
        this.ERROR = ERROR;
    }

    /**
     * Sets the value of field 'RESULT'. The field 'RESULT' has the
     * following description: 处理结果
     *
     * @param RESULT the value of field 'RESULT'.
     */
    public void setRESULT(final String RESULT) {
        this.RESULT = RESULT;
    }

}
