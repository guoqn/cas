package com.ffcs.crmd.cas.base.utils;

import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

import java.io.Reader;

/**
 * .
 *
 * @author Luxb
 * @version Revision 1.0.0
 * @版权：福富软件 版权所有 (c) 2011
 * @see:
 * @创建日期：2016/4/19
 * @功能说明：
 */
public class BeanUtil {
    public static Object unmarshal(String outXml, final Class clazz) {
        Object obj = null;
        outXml = outXml.replaceAll("[\\x00-\\x08,\\x0b-\\x0c,\\x0e-\\x1f]", "");
        final Reader r = new java.io.StringReader(outXml);
        try {
            obj = org.exolab.castor.xml.Unmarshaller.unmarshal(clazz, r);
        } catch (MarshalException e) {
            ExceptionUtils.throwEx("SYS10006");
        } catch (ValidationException e) {
            ExceptionUtils.throwEx("SYS10007");
        }
        return obj;
    }
}
