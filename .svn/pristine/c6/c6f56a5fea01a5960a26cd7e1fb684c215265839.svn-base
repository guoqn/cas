package com.ffcs.crmd.cas.intf.util.crm;

/**
 * @版权：福富软件 版权所有 (c) 2007
 * @文件：com.ffcs.crm.common.util.crm.EjbException.java
 * @所含类：EjbException
 * @author: wuq
 * @version: V1.0
 * @see:
 * @创建日期：2007-9-14
 * @功能说明：
 * @修改记录： =============================================================<br>
 *        日期:2007-9-14 wuq 创建
 *        =============================================================<br>
 */
public class EjbException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID      = 8914985650772023512L;
    
    String                    cfgEjbMsg;
    
    /**
     * CORBA_ERROR_MSG String.
     */
    public static String      CORBA_ERROR_MSG       = "调用corba服务发生未知错误，请联系后台组解决！";
    
    /**
     * CORBA_INITERROR_MSG String.
     */
    public static String      CORBA_INITERROR_MSG   = "初始化corba连接失败，请联系管理员解决！";
    
    /**
     * CASTOR_XML_ERROR_MSG String.
     */
    public static String      CASTOR_XML_ERROR_MSG  = "xml不符合对应的schema格式！";
    
    /**
     * CASTOR_BEAN_ERROR_MSG String.
     */
    public static String      CASTOR_BEAN_ERROR_MSG = "传输的java bean无法转换成xml，schema可能已经被改动，java bean：";
    
    /**
     * @author: wuq
     * @修改记录： ==============================================================<br>
     *        日期:2007-9-17 wuq 创建方法，并实现其功能
     *        ==============================================================<br>
     */
    public EjbException() {
        super();
    }
    
    /**
     * @param msg
     *            String
     * @author: wuq
     * @修改记录： ==============================================================<br>
     *        日期:2007-9-17 wuq 创建方法，并实现其功能
     *        ==============================================================<br>
     */
    public EjbException(final String msg) {
        super(msg);
        this.cfgEjbMsg = msg;
    }
    
    /**
     * @param msg
     *            String
     * @param e
     *            Throwable
     * @author: wuq
     * @修改记录： ==============================================================<br>
     *        日期:2007-9-17 wuq 创建方法，并实现其功能
     *        ==============================================================<br>
     */
    public EjbException(final String msg, final Throwable e) {
        super(msg, e);
        if (e instanceof EjbException) {
            this.cfgEjbMsg = ((EjbException) e).getCfgEjbMsg();
        } else {
            this.cfgEjbMsg = msg
                + "<font color=\"#06C\">\n<br><div name=\"trace\"><pre>trace:\n"
                + this.getTraces(e, null) + "</pre></div></font>";
        }
    }
    
    /**
     * @param e
     *            Throwable
     * @param str
     *            String
     * @return String
     * @author: wuq
     * @修改记录： ==============================================================<br>
     *        日期:2007-9-17 wuq 创建方法，并实现其功能
     *        ==============================================================<br>
     */
    private String getTraces(final Throwable e, String str) {
        if (str == null) {
            str = "";
        }
        final StackTraceElement[] traces = e.getStackTrace();
        for (final StackTraceElement element : traces) {
            str += "\n      " + element.toString();
        }
        if (e.getCause() != null) {
            this.getTraces(e.getCause(), "\n  caused by:" + str);
        }
        return str;
    }
    
    /**
     * @return String
     * @author: wuq
     * @修改记录： ==============================================================<br>
     *        日期:2007-9-17 wuq 创建方法，并实现其功能
     *        ==============================================================<br>
     */
    public String getCfgEjbMsg() {
        return this.cfgEjbMsg;
    }
}
