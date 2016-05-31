package com.ffcs.crmd.cas.intf.util.crm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * @版权：福富软件 版权所有 (c) 2007
 * @文件：com.ffcs.crm.common.util.crm.ToGb2312.java
 * @所含类：ToGb2312
 * @author: wuq
 * @version: V1.0
 * @see:
 * @创建日期：2007-9-17
 * @功能说明：
 * @修改记录： =============================================================<br>
 *        日期:2007-9-17 wuq 创建
 *        =============================================================<br>
 */
public class ToGb2312 {
    static Logger logger = Logger.getLogger("ToGb2312");
    
    /**
     * @author: wuq
     * @修改记录： ==============================================================<br>
     *        日期:2007-9-17 wuq 创建方法，并实现其功能
     *        ==============================================================<br>
     */
    protected ToGb2312() {
    }
    
    /**
     * @param s
     *            String
     * @return String
     * @throws Exception
     *             Exception
     * @author: wuq
     * @修改记录： ==============================================================<br>
     *        日期:2007-9-17 wuq 创建方法，并实现其功能
     *        ==============================================================<br>
     */
    public static String convertinto(final String s) throws Exception {
        if (s == null) {
            return null;
        }
        String str;
        byte[] inputBytes = s.getBytes("8859_1");
        str = new String(inputBytes, "GBK");
        if (ToGb2312.logger.isInfoEnabled()) {
            ToGb2312.logger.info(str);
        }
        inputBytes = null;
        return str;
    }
    
    /**
     * @param s
     *            String
     * @return String
     * @author: wuq
     * @修改记录： ==============================================================<br>
     *        日期:2007-9-17 wuq 创建方法，并实现其功能
     *        ==============================================================<br>
     */
    public static String delNameSpace(String s) {
        if (s == null) {
            return null;
        }
        final String regEx = "\\sxmlns(|:ns\\d+)=\"http://[^\"]+\"|ns\\d+:";
        
        final Pattern p = Pattern.compile(regEx);
        final Matcher m = p.matcher(s);
        s = m.replaceAll("");
        s = s.replaceAll("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:", "");
        s = s.replaceAll(" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:", "");
        //删除报文中多余的xsi:type节点  add by wangjianjun 2013-11-30
        s = delXsiType(s);
        return s;
    }
    
    /**
     * 删除命名空间，
     * 如：<ns:sendMessageResponse xmlns:ns="http://ws.apache.org/axis2" xmlns:ax21="http://ws.apache.org/axis2/xsd">
     * 变成：<sendMessageResponse>
     * 
     * .
     * 
     * @param s
     * @return
     * @author chaijinch
     * 2015-2-3 chaijinch
     */
    public static String delNameSpaceAll(String s) {
        if (s == null) {
            return null;
        }
        String reg = "\\s+[a-zA-Z]+:[a-zA-Z]*=\"[^<>]*\"\\s*|\\s+[a-zA-Z]+=\"[^<>]*\"\\s*";
        String reg2 = "<[a-zA-Z]+:";
        String reg3 = "</[a-zA-Z]+:";
        String destr = s.replaceAll(reg, "");
        destr = destr.replaceAll(reg2, "<");
        destr = destr.replaceAll(reg3, "</");
        //删除报文中多余的xsi:type节点  add by wangjianjun 2013-11-30
        destr = delXsiType(destr);
        return destr;
    }
    
    /**
     * 删除XML报文中的xsi:type节点
     * .
     * 
     * @param s
     * @return
     * @author wangjianjun
     * 2013-11-30 wangjianjun
     */
    public static String delXsiType(String s){
        if (s == null) {
            return null;
        }
        final String regEx = "\\sxsi:type\\s*=\\s*\"[^\"]*\"\\s*";
        final Pattern p = Pattern.compile(regEx);
        final Matcher m = p.matcher(s);
        s = m.replaceAll("");
        return s;
    }
    
    /**
     * @param s
     *            String
     * @return String
     * @throws Exception
     *             Exception
     * @author: wuq
     * @修改记录： ==============================================================<br>
     *        日期:2007-9-17 wuq 创建方法，并实现其功能
     *        ==============================================================<br>
     */
    public static String convertback(String s) throws Exception {
        if (s == null) {
            return null;
        }
        String str;
        final String regEx = "\\sxmlns(|:ns\\d+)=\"http://[^\"]+\"|ns\\d+:";
        
        final Pattern p = Pattern.compile(regEx);
        final Matcher m = p.matcher(s);
        s = m.replaceAll("");
        
        if (ToGb2312.logger.isInfoEnabled()) {
            ToGb2312.logger.info(s);
        }
        final byte[] inputBytes = s.getBytes("UTF-8");
        str = new String(inputBytes, "8859_1");
        return str;
    }
    
    /**
     * @param s
     *            String
     * @return String
     * @throws Exception
     *             Exception
     * @author: wuq
     * @修改记录： ==============================================================<br>
     *        日期:2007-9-17 wuq 创建方法，并实现其功能
     *        ==============================================================<br>
     */
    public static String convertbackForOss(final String s) throws Exception {
        if (ToGb2312.logger.isInfoEnabled()) {
            ToGb2312.logger.info(s);
        }
        final byte[] inputBytes = s.getBytes("GBK");
        return new String(inputBytes, "ISO8859_1");
    }
    
    /**
     * @param string
     *            String
     * @return String
     * @throws Exception
     *             Exception
     * @author: wuq
     * @修改记录： ==============================================================<br>
     *        日期:2007-9-17 wuq 创建方法，并实现其功能
     *        ==============================================================<br>
     */
    public static String getStr(final String string) throws Exception {
        String s = "";
        if (string != null) {
            s = ToGb2312.convertinto(string);
        }
        return s;
    }
    
    /**
     * @param seed
     *            String
     * @return String
     * @throws Exception
     *             Exception
     * @author: wuq
     * @修改记录： ==============================================================<br>
     *        日期:2007-9-17 wuq 创建方法，并实现其功能
     *        ==============================================================<br>
     */
    public static String convertintoForXml(String seed) throws Exception {
        if (seed == null) {
            return null;
        }
        seed = ToGb2312.convertinto(seed);
        seed = seed.replaceAll("<", "__1");
        seed = seed.replaceAll(">", "__2");
        seed = seed.replaceAll("&", "__3");
        seed = seed.replaceAll("'", "__4");
        seed = seed.replaceAll("\"", "__5");
        seed = seed.replaceAll(" ", "__6");
        seed = seed.replaceAll("\n", "__7");
        seed = seed.replaceAll("\r", "__8");
        seed = seed.replaceAll("\t", "__0");
        return seed;
    }
    
    /**
     * @param seed
     *            String
     * @return String
     * @throws Exception
     *             Exception
     * @author: wuq
     * @修改记录： ==============================================================<br>
     *        日期:2007-9-17 wuq 创建方法，并实现其功能
     *        ==============================================================<br>
     */
    public static String convertForXml(String seed) throws Exception {
        // seed=convertinto(seed);
        seed = seed.replaceAll("__1", "<");
        seed = seed.replaceAll("__2", ">");
        seed = seed.replaceAll("__3", "&");
        seed = seed.replaceAll("__4", "'");
        seed = seed.replaceAll("__5", "\"");
        seed = seed.replaceAll("__6", " ");
        seed = seed.replaceAll("__7", " ");
        seed = seed.replaceAll("__8", " ");
        seed = seed.replaceAll("__0", " ");
        return seed;
    }
    
    /**
     * @param args
     *            String
     * @author: wuq
     * @修改记录： ==============================================================<br>
     *        日期:2007-9-17 wuq 创建方法，并实现其功能
     *        ==============================================================<br>
     */
    public static void main(final String[] args) {
        String s = "<Condition xmlns=\"http://www.crm.com/queryCustomerCondition\" " 
            + "version=\"1.4\"><customerId>0</customerId><loadMode>2</loadMode><staff>0</staff></Condition>";
        
        final String regEx = "\\sxmlns(|:ns\\d+)=\"http://[^\"]+\"|ns\\d+:"; // 表示一个或多个a
        final String regEx2 = "";
        if (ToGb2312.logger.isDebugEnabled()) {
            ToGb2312.logger.debug(s);
        }
        final Pattern p = Pattern.compile(regEx);
        final Matcher m = p.matcher(s);
        s = m.replaceAll("");
        if (ToGb2312.logger.isDebugEnabled()) {
            ToGb2312.logger.debug(s);
        }
        final Pattern p2 = Pattern.compile(regEx2);
        final Matcher m2 = p2.matcher(s);
        s = m2.replaceAll("");
        if (ToGb2312.logger.isDebugEnabled()) {
            ToGb2312.logger.debug(s);
        }
        /*
         * String regEx="^:"; Pattern p=Pattern.compile(regEx); Matcher
         * m=p.matcher(s); s=m.replaceAll(""); // s=s.replaceAll("/:$/",""); //
         * s=s.replaceAll("/^xmlns=\"http:/", ""); if (logger.isDebugEnabled())
         * logger.debug(s) ;
         */
        if (ToGb2312.logger.isDebugEnabled()) {
            ToGb2312.logger.debug(s.replaceAll("_", "__"));
        }
        try {
            final int[] x = new int[12];
            for (int i = 0; i < 10000; i++) {
                x[(int) Math.ceil(Math.random() * 5)]++;
            }
            for (final int element : x) {
            }
            final String sss = "__1?xml__6version=__51.0__5__6encoding=__5GBK__5?__2__1info__2__1" 
                + "eaInfo__6name=__5空白属性__5__6xAddr=__51__5__6yAddr=__51__5__6displayMode=__515__5__6" 
                + "isNull=__50__5__6displayPlace=__50__5__2__1feaInfo__6name=__5基本信息__5__6xAddr=__52__5__6" 
                + "yAddr=__51__5__6displayMode=__50__5__6isNull=__50__5__6displayPlace=__50__5__2__1feaInfo__6" 
                + "feaSpecId=__567604__5__6name=__5基本信息__5__6xAddr=__51__5__6yAddr=__51__5__6displayMode=__50__5__6" 
                + "isNull=__50__5__6displayPlace=__50__5__6feaAttr=__5PROD__5__2__1feaInfo__6feaSpecId=__567603__5__6" 
                + "name=__5地区编码__5__6xAddr=__51__5__6yAddr=__51__5__6displayMode=__55__5__6isNull=__50__5__6" 
                + "displayPlace=__50__5__6feaAttr=__5PROD__5__2__1feaInfo__6feaSpecId=__56685__5__6name=__5德化__5__6" 
                + "feaAttr=__5PROD__5/__2__1feaInfo__6feaSpecId=__511445__5__6name=__5闽清__5__6feaAttr=__5" 
                + "PROD__5/__2__1feaInfo__6feaSpecId=__56704__5__6name=__5罗源__5__6feaAttr=__5PROD__5/__2__1" 
                + "feaInfo__6feaSpecId=__56706__5__6name=__5福州__5__6feaAttr=__5PROD__5/__2__1feaInfo__6" 
                + "feaSpecId=__511433__5__6name=__5武平__5__6feaAttr=__5PROD__5/__2__1feaInfo__6feaSpecId=__511446__5__6" 
                + "name=__5长乐__5__6feaAttr=__5PROD__5/__2__1feaInfo__6feaSpecId=__511444__5__6name=__5永泰__5__6" 
                + "feaAttr=__5PROD__5/__2__1feaInfo__6feaSpecId=__56701__5__6name=__5平潭__5__6feaAttr=__5PROD__5/__2__1" 
                + "feaInfo__6feaSpecId=__56702__5__6name=__5福清__5__6feaAttr=__5PROD__5/__2__1feaInfo__6" 
                + "feaSpecId=__56703__5__6name=__5连江__5__6feaAttr=__5PROD__5/__2__1feaInfo__6feaSpecId=__56705__5__6" 
                + "name=__5闽侯__5__6feaAttr=__5PROD__5/__2__1feaInfo__6feaSpecId=__56667__5__6name=__5建宁__5__6" 
                + "feaAttr=__5PROD__5/__2__1/feaInfo__2__1feaInfo__6feaSpecId=__57013__5__6name=__5服务期限__5__6" 
                + "xAddr=__52__5__6yAddr=__51__5__6displayMode=__56__5__6isNull=__50__5__6displayPlace=__50__5__6" 
                + "feaAttr=__5PROD__5/__2__1feaInfo__6feaSpecId=__5224__5__6name=__5停机日期__5__6xAddr=__53__5__6" 
                + "yAddr=__51__5__6displayMode=__56__5__6isNull=__50__5__6displayPlace=__50__5__6feaAttr=__5" 
                + "PROD__5/__2__1feaInfo__6feaSpecId=__5223__5__6name=__5复机日期__5__6xAddr=__54__5__6" 
                + "yAddr=__51__5__6displayMode=__56__5__6isNull=__50__5__6displayPlace=__50__5__6feaAttr=__5" 
                + "PROD__5/__2__1feaInfo__6feaSpecId=__567783__5__6name=__5服务保密级别__5__6xAddr=__55__5__6" 
                + "yAddr=__51__5__6displayMode=__55__5__6isNull=__50__5__6displayPlace=__50__5__6feaAttr=__5" 
                + "PROD__5__2__1feaInfo__6feaSpecId=__511224__5__6name=__5二级保密__5__6feaAttr=__5PROD__5/__2__1" 
                + "feaInfo__6feaSpecId=__56389__5__6name=__5三级保密__5__6feaAttr=__5PROD__5/__2__1feaInfo__6" 
                + "feaSpecId=__56387__5__6name=__5不保密__5__6feaAttr=__5PROD__5/__2__1feaInfo__6feaSpecId=__56388__5__6" 
                + "name=__5一级保密__5__6feaAttr=__5PROD__5/__2__1/feaInfo__2__1feaInfo__6feaSpecId=__567664__5__6" 
                + "name=__5服务保障级别__5__6xAddr=__51__5__6yAddr=__52__5__6displayMode=__55__5__6isNull=__50__5__6" 
                + "displayPlace=__50__5__6feaAttr=__5PROD__5__2__1feaInfo__6feaSpecId=__56515__5__6name=__5C级__5__6" 
                + "feaAttr=__5PROD__5/__2__1feaInfo__6feaSpecId=__56516__5__6name=__5B级__5__6feaAttr=__5PROD__5/__2__1"
                + "feaInfo__6feaSpecId=__57169__5__6name=__5A级__5__6feaAttr=__5PROD__5/__2__1/feaInfo__2__1feaInfo__6" 
                + "feaSpecId=__59555__5__6name=__5保障级别附加信息__5__6xAddr=__52__5__6yAddr=__52__5__6" 
                + "displayMode=__512__5__6isNull=__50__5__6displayPlace=__50__5__6feaAttr=__5PROD__5__2__1" 
                + "feaInfo__6feaSpecId=__575355__5__6name=__5申请客户群__5__6feaAttr=__5PROD__5__2__1feaInfo__6" 
                + "feaSpecId=__510050__5__6name=__5商业客户部__5__6feaAttr=__5PROD__5/__2__1feaInfo__6" 
                + "feaSpecId=__510029__5__6name=__5大客户部__5__6feaAttr=__5PROD__5/__2__1feaInfo__6" 
                + "feaSpecId=__510046__5__6name=__5其他__5__6feaAttr=__5PROD__5/__2__1/feaInfo__2__1" 
                + "feaInfo__6feaSpecId=__510174__5__6name=__5客户代表__5__6feaAttr=__5PROD__5/__2__1/" 
                + "feaInfo__2__1feaInfo__6feaSpecId=__567787__5__6name=__5帐务级别__5__6xAddr=__53__5__6" 
                + "yAddr=__52__5__6displayMode=__55__5__6isNull=__50__5__6displayPlace=__50__5__6feaAttr=__5" 
                + "PROD__5__2__1feaInfo__6feaSpecId=__512210__5__6name=__5金牌服务__5__6feaAttr=__5PROD__5/__2__1" 
                + "feaInfo__6feaSpecId=__512211__5__6name=__5普通服务__5__6feaAttr=__5PROD__5/__2__1feaInfo__6" 
                + "feaSpecId=__512209__5__6name=__5银牌服务__5__6feaAttr=__5PROD__5/__2__1feaInfo__6" 
                + "feaSpecId=__512207__5__6name=__5公免保障__5__6feaAttr=__5PROD__5/__2__1feaInfo__6" 
                + "feaSpecId=__512208__5__6name=__5铜牌服务__5__6feaAttr=__5PROD__5/__2__1/feaInfo__2__1" 
                + "feaInfo__6feaSpecId=__511068__5__6name=__5帐务级别附加信息__5__6xAddr=__54__5__6yAddr=__52__5__6" 
                + "displayMode=__512__5__6isNull=__50__5__6displayPlace=__50__5__6feaAttr=__5PROD__5__2__1" 
                + "feaInfo__6feaSpecId=__575452__5__6name=__5申请客户群__5__6feaAttr=__5PROD__5__2__1feaInfo__6" 
                + "feaSpecId=__510045__5__6name=__5公众客户部__5__6feaAttr=__5PROD__5/__2__1feaInfo__6" 
                + "feaSpecId=__5119__5__6name=__5流动客户部__5__6feaAttr=__5PROD__5/__2__1feaInfo__6" 
                + "feaSpecId=__510051__5__6name=__5商业客户部__5__6feaAttr=__5PROD__5/__2__1feaInfo__6" 
                + "feaSpecId=__510033__5__6name=__5大客户部__5__6feaAttr=__5PROD__5/__2__1feaInfo__6" 
                + "feaSpecId=__510047__5__6name=__5其他__5__6feaAttr=__5PROD__5/__2__1/feaInfo__2__1" 
                + "feaInfo__6feaSpecId=__510186__5__6name=__5客户代表__5__6feaAttr=__5PROD__5/__2__1/" 
                + "feaInfo__2__1feaInfo__6feaSpecId=__5225__5__6name=__5备注__5__6xAddr=__51__5__6" 
                + "yAddr=__53__5__6displayMode=__59__5__6isNull=__50__5__6displayPlace=__50__5__6" 
                + "feaAttr=__5PROD__5/__2__1/feaInfo__2__1/feaInfo__2__1feaInfo__6name=__5空白属性__5__6" 
                + "xAddr=__53__5__6yAddr=__51__5__6displayMode=__50__5__6isNull=__50__5__6" 
                + "displayPlace=__50__5__2__1feaInfo__6feaSpecId=__568022__5__6name=__5服务号码__5__6" 
                + "xAddr=__51__5__6yAddr=__51__5__6feaAttr=__5PROD__5__2__1feaInfo__6feaSpecId=__52900__5__6" 
                + "name=__5服务短号__5__6feaAttr=__5PROD__5/__2__1feaInfo__6feaSpecId=__52899__5__6name=__5" 
                + "IMSI号__5__6feaAttr=__5PROD__5/__2__1feaInfo__6feaSpecId=__568093__5__6name=__5是否用户选号__5__6" 
                + "feaAttr=__5PROD__5__2__1feaInfo__6feaSpecId=__56874__5__6name=__5前台选号__5__6feaAttr=__5" 
                + "PROD__5/__2__1feaInfo__6feaSpecId=__55062__5__6name=__5资源选号__5__6feaAttr=__5PROD__5/__2__1" 
                + "feaInfo__6feaSpecId=__55063__5__6name=__5前台配号__5__6feaAttr=__5PROD__5/__2__1/feaInfo__2__1" 
                + "feaInfo__6feaSpecId=__568151__5__6name=__5114是否保密__5__6feaAttr=__5PROD__5__2__1feaInfo__6" 
                + "feaSpecId=__55159__5__6name=__5保密__5__6feaAttr=__5PROD__5/__2__1feaInfo__6feaSpecId=__55194__5__6" 
                + "name=__5不保密__5__6feaAttr=__5PROD__5/__2__1/feaInfo__2__1feaInfo__6feaSpecId=__59001__5__6" 
                + "name=__5移动卡号__5__6feaAttr=__5PROD__5/__2__1feaInfo__6feaSpecId=__52901__5__6name=__5引示号__5__6" 
                + "feaAttr=__5PROD__5/__2__1/feaInfo__2__1/feaInfo__2__1/feaInfo__2__1/info__2__8__7";
            if (ToGb2312.logger.isDebugEnabled()) {
                ToGb2312.logger.debug(ToGb2312.convertForXml(sss));
            }
            
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
