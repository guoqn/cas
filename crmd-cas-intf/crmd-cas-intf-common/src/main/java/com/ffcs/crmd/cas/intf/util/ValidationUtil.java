package com.ffcs.crmd.cas.intf.util;
import org.apache.commons.lang3.StringUtils;

import com.ffcs.crmd.cas.intf.exception.InvokerException;
import com.ffcs.crmd.cas.intf.exception.ProviderException;


public class ValidationUtil {
    
    public static void isNotBlank(String string, String message, Object... args)
        throws InvokerException {
        isTrue(StringUtils.isNotBlank(string), message, args);
    }
    
    public static void isNotNull(Object object, String message, Object... args)
        throws InvokerException {
        isTrue(object != null, message, args);
    }
    
    public static void isNumeric(String string, String message, Object... args)
        throws InvokerException {
        isTrue(StringUtils.isNumeric(string), message, args);
    }
    
    public static void hasLength(String string, int length, String message, Object... args)
        throws InvokerException {
        isTrue(string != null && string.length() == length, message, args);
    }
    
    public static void isTrue(boolean bool, String message, Object... args) throws InvokerException {
        if (!bool) {
            throw new InvokerException("");//////////
        }
    }
    
    public static void _isNotBlank(String string, String message, Object... args)
        throws ProviderException {
        _isTrue(StringUtils.isNotBlank(string), message, args);
    }
    
    public static void _isNotNull(Object object, String message, Object... args)
        throws ProviderException {
        _isTrue(object != null, message, args);
    }
    
    public static void _isTrue(boolean bool, String message, Object... args)
        throws ProviderException {
        if (!bool) {
            throw new ProviderException("");/////////////////////
        }
    }
}
