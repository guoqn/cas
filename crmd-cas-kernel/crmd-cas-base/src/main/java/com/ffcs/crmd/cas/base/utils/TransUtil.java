package com.ffcs.crmd.cas.base.utils;

import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @version 创建时间：2015年12月5日 下午2:30:06
 *          类说明
 */
public class TransUtil {
    /**
     * 获取报文中serial值
     *
     * @return
     * @author LINGUANGHAO 2015年12月5日
     */
    public static String getTransId() {
        String transId = DateUtils.getCurDate("yyyyMMddHHmmssSSS");
        return transId;
    }

    /**
     * 获取唯一标识
     *
     * @param flag
     * @return
     * @author LINGUANGHAO 2015年12月14日
     */
    public static String getTransId(String flag) {
        String transId = DateUtils.getCurDate("yyyyMMddHHmmssSSS");
        return flag + transId;
    }

    /**
     * 针对前端字符串 用“,”拆分 组装成数组
     * @param data
     * @author GUOQN 2016-2-2
     * @return
     */
    public static List<Long> getListbyStr(String data) {
        String sceneTypeStr = data
                .substring(0, data.length() - 1);
        String[] strData = {};
        strData = sceneTypeStr.split(",");
        List<Long> longList = new ArrayList<>();
        for (int i = 0; i < strData.length; i++) {
            longList.add(NumberUtils.toLong(strData[i]));
        }
        return longList;
    }
    /**
     * 针对前端字符串 用“,”拆分 组装成数组
     * @param data
     * @author GUOQN 2016-2-19
     * @return
     */
    public static List<String> getStrListbyStr(String data){
        String sceneTypeStr = data
                .substring(0, data.length() - 1);
        String[] strData = {};
        strData = sceneTypeStr.split(",");
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < strData.length; i++) {
            strList.add(strData[i]);
        }
        return strList;
    }
}
