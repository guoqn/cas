package com.ffcs.crmd.cas.base.encrypt;

import org.apache.log4j.Logger;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


public class Cryto {
    static Logger         logger           = Logger.getLogger(Cryto.class);
    private static String algorithm_DESede = "DESede";
    
    private static String default_charset  = "UTF-8";
    
    public static String generateKey() {
        byte abyte0[] = generateKeyByteArr();
        return byteArrayToHexString(abyte0).toUpperCase();
    }
    
    public static String byteArrayToHexString(byte buf[]) {
        try {
            int iLen = buf.length;
            StringBuffer sb = new StringBuffer(iLen * 2);
            for (int i = 0; i < iLen; i++) {
                int intTmp;
                for (intTmp = buf[i]; intTmp < 0; intTmp += 256)
                    ;
                if (intTmp < 16)
                    sb.append("0");
                sb.append(Integer.toString(intTmp, 16));
            }
            
            return sb.toString().toUpperCase();
        } catch (Exception e) {
            logger.info("将byte数组转换为表示16进制值的字符串时出错!@" + e.getMessage());
        }
        return null;
    }
    
    private static byte[] generateKeyByteArr() {
        SecretKey secretkey;
        SecureRandom securerandom = new SecureRandom();
        KeyGenerator keygenerator;
        try {
            keygenerator = KeyGenerator.getInstance(algorithm_DESede);
            keygenerator.init(securerandom);
            secretkey = keygenerator.generateKey();
            return secretkey.getEncoded();
        } catch (NoSuchAlgorithmException e) {
            logger.info("生成密钥KEY异常:" + e.getMessage());
            return null;
        }
        
    }
    
    public static byte[] SHA1(String source, String charset) {
        try {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
            messagedigest.update(source.getBytes(charset));
            byte abyte0[] = messagedigest.digest();
            return abyte0;
        } catch (Exception exception) {
            logger.info("SHA-1出错!@" + exception.getMessage());
            return null;
        }
    }
    
    public static byte[] base64Decode(String str) {
        try {
            byte a[] = (new BASE64Decoder()).decodeBuffer(str);
            
            return a;
        } catch (Exception e) {
            logger.info("使用增强型BASE64编码格式对字符串进行解码时出错!@" + e.getMessage());
        }
        return null;
    }
    
    public static String base64Encode(byte b[]) {
        try {
            return (new BASE64Encoder()).encode(b);
        } catch (Exception e) {
            System.out.println("使用增强型BASE64编码格式对字节数组进行编码时出错!@" + e.getMessage());
        }
        return null;
    }
    
    /**
     * 采用MD5对字符进行加密后返回(HEX格式)
     *
     * @param str
     *            源字符串
     * @return String 返回加密后的字符串
     *
     *
     */
    public static String cryptMD5ToHEX(String str) {
        return cryptMD5ToHEX(str, default_charset);
    }

    /**
     * 采用MD5对字符进行加密后返回(HEX格式)
     *
     * @param str
     *            源字符串
     * @return String 返回加密后的字符串
     *
     *
     */
    public static String cryptMD5ToHEX(String str, String charset) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return byteArrayToHexString(md.digest(str.getBytes(charset)));
        } catch (NoSuchAlgorithmException e) {
            logger.info("" + e.getMessage());
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
