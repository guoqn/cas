package com.ffcs.crmd.cas.intf.exception;

/**
 * 组件服务调用方异常.
 * 
 * @版权：福富软件 版权所有 (c) 2011
 * @author Administrator
 * @version Revision 1.0.0
 * @see:
 * @创建日期：2012-2-24
 * @功能说明：组件服务调用方异常，用于声明组件服务调用方报文中存在的错误
 */
public class InvokerException extends CompException {
    
    /** 序列版本号 */
    private static final long   serialVersionUID   = -3216627448137390396L;
    
    /** 缺省的组件服务调用方错误代码 */
    private static final String DEFAULT_ERROR_CODE = "1990";
    
    /** 缺少的组件服务调用方错误消息 */
    private static final String DEFAULT_ERROR_MSG  = "校验业务体格式错误";
    
    /**
     * 组件服务调用方异常构造函数.
     * 
     * @author renl
     *         2012-2-24 renl
     */
    public InvokerException() {
        super(DEFAULT_ERROR_CODE, DEFAULT_ERROR_MSG);
    }
    
    /**
     * 组件服务调用方异常构造函数.
     * 
     * @param message
     *            异常响应消息
     * @author renl
     *         2012-2-24 renl
     */
    public InvokerException(String message) {
        super(DEFAULT_ERROR_CODE, DEFAULT_ERROR_MSG + "(" + message + ")");
    }
    
    /**
     * 组件服务调用方异常构造函数.
     * 
     * @param code
     *            异常响应代码
     * @param message
     *            异常响应消息
     * @author renl
     *         2012-2-24 renl
     */
    public InvokerException(String code, String message) {
        super(code, message);
    }
    
    /**
     * 组件服务调用方异常构造函数.
     * 
     * @param cause
     *            异常原因
     * @author renl
     *         2012-2-24 renl
     */
    public InvokerException(Throwable cause) {
        super(DEFAULT_ERROR_CODE, DEFAULT_ERROR_MSG, cause);
    }
    
    /**
     * 组件服务调用方异常构造函数.
     * 
     * @param message
     *            异常响应消息
     * @param cause
     *            异常原因
     * @author renl
     *         2012-2-24 renl
     */
    public InvokerException(String message, Throwable cause) {
        super(DEFAULT_ERROR_CODE, DEFAULT_ERROR_MSG + "(" + message + ")", cause);
    }
    
    /**
     * 组件服务调用方异常构造函数.
     * 
     * @param code
     *            异常响应代码
     * @param message
     *            异常响应消息
     * @param cause
     *            异常原因
     * @author renl
     *         2012-2-24 renl
     */
    public InvokerException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
    
}
