package com.ffcs.crmd.cas.intf.exception;



/**
 * 组件服务异常.
 * 
 * @版权：福富软件 版权所有 (c) 2011
 * @author renl
 * @version Revision 1.0.0
 * @see: @ProviderException @InvokerException
 * @创建日期：2012-2-24
 * @功能说明：组件服务异常，所有组件服务异常的基类，目前分为提供方异常和调用方异常
 */
public abstract class CompException extends Exception {
    
    /** 序列版本号 */
    private static final long serialVersionUID = 1772964729694064924L;
    
    /** 异常响应代码 */
    private String            code;
    
    /**
     * 组件服务异常构造函数.
     * 
     * @param code
     *            异常响应代码
     * @param message
     *            异常消息
     * @author renl
     *         2012-2-24 renl
     */
    public CompException(String code, String message) {
        super(message);
        this.code = code;
    }
    
    /**
     * 组件服务异常构造函数.
     * 
     * @param code
     *            异常响应代码
     * @param message
     *            异常消息
     * @param cause
     *            异常原因
     * @author renl
     *         2012-2-24 renl
     */
    public CompException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
    
//    private String trackMsg;
//    @Override
//    public String getMessage() {
//        String retMsg = super.getMessage();
//        //调用轨迹跟踪，注入轨迹
//        if(this.trackMsg==null){
//            this.trackMsg = TrackUtil.attachErrTrackId(retMsg);
//        }
//        return trackMsg;
//    }
}
