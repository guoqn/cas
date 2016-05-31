package com.ffcs.crmd.cas.intf.exception;

/**
 * 组件服务提供方异常.
 * 
 * @版权：福富软件 版权所有 (c) 2011
 * @author renl
 * @version Revision 1.0.0
 * @see:
 * @创建日期：2012-2-24
 * @功能说明：组件服务提供方异常，用于声明组件服务提供方系统内部出现的错误
 */
public class ProviderException extends CompException {
    
    /** 序列版本号 */
    private static final long   serialVersionUID   = 3593062826769669526L;
    
    /** 缺省的组件服务提供方错误代码 */
    private static final String DEFAULT_ERROR_CODE = "1999";
    
    /** 缺省的组件服务提供方错误消息 */
    private static final String DEFAULT_ERROR_MSG  = "系统平台内部错误";
    
    /**
     * 组件服务提供方异常构造函数.
     * 
     * @author renl
     *         2012-2-24 renl
     */
    public ProviderException() {
        super(DEFAULT_ERROR_CODE, DEFAULT_ERROR_MSG);
    }
    
    /**
     * 组件服务提供方异常构造函数.
     * 
     * @param message
     *            异常响应消息
     * @author renl
     *         2012-2-24 renl
     */
    public ProviderException(String message) {
        super(DEFAULT_ERROR_CODE, DEFAULT_ERROR_MSG + "(" + message + ")");
    }
    
    /**
     * 组件服务提供方异常构造函数.
     * 
     * @param code
     *            异常响应代码
     * @param message
     *            异常响应消息
     * @author renl
     *         2012-2-24 renl
     */
    public ProviderException(String code, String message) {
        super(code, message);
    }
    
    /**
     * 组件服务提供方异常构造函数.
     * 
     * @param cause
     *            异常原因
     * @author renl
     *         2012-2-24 renl
     */
    public ProviderException(Throwable cause) {
        super(DEFAULT_ERROR_CODE, DEFAULT_ERROR_MSG, cause);
    }
    
    /**
     * 组件服务提供方异常构造函数.
     * 
     * @param message
     *            异常响应消息
     * @param cause
     *            异常原因
     * @author renl
     *         2012-2-24 renl
     */
    public ProviderException(String message, Throwable cause) {
        super(DEFAULT_ERROR_CODE, DEFAULT_ERROR_MSG + "(" + message + ")", cause);
    }
    
    /**
     * 组件服务提供方异常构造函数.
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
    public ProviderException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
    
}
