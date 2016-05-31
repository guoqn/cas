package com.ffcs.crmd.cas.intf.util.config;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;


public class PropertiesUtil {
    
    /**
     * 缓存.
     */
    private static HashMap<String, String> cacheMap  = new HashMap<String, String>();
    
    /**
     * 分格符.
     */
    public final static String            CACHE_TAG = "__";
    
    /**
     * 全局版本号
     *  by linwd crm00062921    20-福建CRM2.0  中  需求单  子单 crm00062534 FJCRMV2.0_灰度发布_流量控制 订单
     */
    public static String                  VERSION_NUM = "";
    
    /**
     * 构造函数.
     */
    protected PropertiesUtil() {
        
    }
    
    public static void clearCache() {
        cacheMap.clear();
    }
    
    public static String getConfigValueCache(final String fileName, final String key) {
        String fkey = fileName + CACHE_TAG + key;
        if (PropertiesUtil.cacheMap.containsKey(fkey)) {
            return PropertiesUtil.cacheMap.get(fkey);
        }
        PropertiesUtil.cacheMap.put(fkey, getConfigValue(fileName, key));
        return PropertiesUtil.cacheMap.get(fkey);
    }
    
    public static String getConfigValue(final String fileName, final String key) {
        InputStream dataIn = null;
        try {
            final Properties properties = new Properties();
            dataIn = PropertiesUtil.class.getResourceAsStream("/" + fileName + ".properties");
            if(dataIn!=null){
            	properties.load(dataIn);
            	dataIn.close();            	
            }
            return properties.getProperty(key);
        } catch (final Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (dataIn != null) {
                    dataIn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * 获取泉州优惠协议版本.
     * 
     * @return 优惠协议版本
     * @author: zfz
     * @修改记录： ==============================================================<br>
     *        日期:Jul 21, 2008 zfz 创建方法，并实现其功能
     *        ==============================================================<br>
     */
    public static String getQZYHXYVer() {
        String ver = StringUtils.strnull(PropertiesUtil.getConfigValue("ejb", "QZYHXY_VER"));
        if (ver.equals("")) {
            ver = "1";
        }
        return ver;
    }
    
    /**
     * 获取三明合同版本.
     * 
     * @return String
     * @author: yejb
     * @修改记录： ==============================================================<br>
     *        日期:Nov 11, 2008 yejb 创建方法，并实现其功能
     *        ==============================================================<br>
     */
    public static String getSMHTVer() {
        String ver = StringUtils.strnull(PropertiesUtil.getConfigValue("ejb", "SMHT_VER"));
        if (ver.equals("")) {
            ver = "OLD";
        }
        return ver;
    }
}
