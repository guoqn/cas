package com.ffcs.crmd.cas.base;

import net.sourceforge.pinyin4j.PinyinHelper;

public class PinyinAPI {

    /**
    * 提取汉字的首字母(大写)
    * 
    * @param str
    * @return
    */
    public static String getPinYinHeadChar(String str) {
        if (isNull(str) || str.length() < 1) {
            return "";
        }
        String convert = "";
            char word = str.charAt(0);
            // 提取汉字的首字母
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            }
            else {
                convert += word;
            }

        convert = string2AllTrim(convert);
        return convert.toUpperCase();
    }

    /*
    * 判断字符串是否为空
    */

    public static boolean isNull(Object strData) {
        if (strData == null || String.valueOf(strData).trim().equals("")) {
            return true;
        }
        return false;
    }

    /**
    * 去掉字符串包含的所有空格
    * 
    * @param value
    * @return
    */
    public static String string2AllTrim(String value) {
        if (isNull(value)) {
            return "";
        }
        return value.trim().replace(" ", "");
    }

    public static void main(String[] args) {
        String ss = PinyinAPI.getPinYinHeadChar("行动");
        String ss1 = PinyinAPI.getPinYinHeadChar("1");
        System.out.print(ss);//ZG
        System.out.print(ss1);//ZG
    }
}