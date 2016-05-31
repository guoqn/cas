package com.ffcs.crmd.cas.base;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class ChineseUtil {
    /**
     * @Title: getChinese
     * @Description:随机生成指定字数的简体汉字
     * @param len
     * @return String    
     *
     */
    public static String generateChinese(int len) {
        String ret = "";
        for (int i = 0; i < len; i++) {
            String str = null;
            int hightPos, lowPos; // 定义高低位
            Random random = new Random();
            hightPos = (176 + Math.abs(random.nextInt(39))); //获取高位值
            lowPos = (161 + Math.abs(random.nextInt(93))); //获取低位值
            byte[] b = new byte[2];
            b[0] = (new Integer(hightPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try {
                str = new String(b, "GBk"); //转成中文
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            ret += str;
        }
        return ret;
    }
    
    public static void main(String[] args) {
        System.out.println(generateChinese(1));
        System.out.println(generateChinese(2));
        System.out.println(generateChinese(3));
        System.out.println(generateChinese(4));
        System.out.println(generateChinese(4));
        System.out.println(generateChinese(4));
        System.out.println(generateChinese(4));
    }
 
}