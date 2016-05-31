package com.ffcs.crmd.cas.intf.util;

import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.bind.ValidationException;
import javax.xml.crypto.MarshalException;
import javax.xml.rpc.ServiceException;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.base.utils.CrmClassUtils;
import com.ffcs.crmd.cas.constants.IntfConstant;
import com.ffcs.crmd.cas.intf.constants.CasConstants;
import com.ffcs.crmd.cas.intf.util.crm.EjbException;
import com.ffcs.crmd.cas.intf.util.crm.ToGb2312;
import com.ffcs.crmd.platform.meta.entity.AttrSpec;
import com.ffcs.crmd.platform.meta.entity.AttrValue;
import com.ffcs.crmd.platform.pub.vo.RetVo;


@SuppressWarnings("unchecked")
public final class WsUtil {
    
    /**
     * 电信公用管理区域编码映射 .
     */
    private static Map<Long, Long>                 lanIdMapping;
    
    private static Map<Long, Long>                 commonRegionIdMapping;
    
    
    private static Logger                          logger                   = Logger
                                                                                .getLogger(WsUtil.class);
    private static int count = 0;
    
    
    /**
     * 方法功能:获取xml里面某个字段的取
     * 
     * @param
     * @return
     * @param event
     * @throws .tag
     * @author: Liuzhuangfei
     * @修改记录modify by wangxp
     *             ====================================================
     *             ========== <br>
     *             日期:2011-1-11 Liuzhuangfei 创建方法，并实现其功
     *             ==========================
     *             ==================================== <br>
     */
    public static String getXmlContent(final String inXML, final String tagName) {
        String ret = "";
        try {
            ret = XmlUtil.getXmlContent(inXML, tagName);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
    
    
    /**
     * 获取最上层异常
     * .
     * 
     * @param e
     * @return
     * @author Wangjianjun
     *         2011-12-2 Wangjianjun
     */
    public static Throwable getSupperErrorMsg(final Throwable e) {
        if (e instanceof InvocationTargetException) {
            final InvocationTargetException invoExce = (InvocationTargetException) e;
            if (invoExce.getTargetException() != null) {
                return WsUtil.getSupperErrorMsg(invoExce.getTargetException());
            } else {
                return e;
            }
        } else {
            return e;
        }
    }
    
    /**
     * 根据异常获取返回信息
     * .
     * 
     * @param e
     *            Throwable 异常
     * @param isSimple
     *            boolean 提示类型 ,True 简单提示，false 原版提示
     * @return
     * @author Wangjianjun
     *         2011-12-2 Wangjianjun
     */
    public static RetVo getErrorMsg(Throwable e, final boolean isSimple) {
        e = WsUtil.getSupperErrorMsg(e);
        e.printStackTrace();
        final RetVo retVo = new RetVo(true);
        retVo.setResult(false);
        retVo.setRetCode(CasConstants.ERROR_CODE_XML_VALIDATE);;//默认
        if (e instanceof EjbException) {
            if (isSimple) {
                retVo.setRetCode(CasConstants.ERROR_CODE_XML_VALIDATE);
                retVo.setMsgTitle(e.getMessage());;
            } else {
                retVo.setMsgTitle(e.getMessage());
            }
        } else if (e instanceof MarshalException) {
            if (isSimple) {
                retVo.setRetCode(CasConstants.ERROR_CODE_XML_VALIDATE);
                retVo.setMsgTitle("报文中存在非法字符！");
            } else {
                retVo.setMsgTitle(e.getMessage());
            }
        } else if (e instanceof ValidationException) {
            if (isSimple) {
                retVo.setRetCode(CasConstants.ERROR_CODE_XML_VALIDATE);
                retVo.setMsgTitle("报文不符合Schema定义！");
            } else {
                retVo.setMsgTitle(e.getMessage());
            }
        } else if (e instanceof RtManagerException) {
            retVo.setRetCode(CasConstants.ERROR_CODE_SYSTEM_ERROR);
            retVo.setMsgTitle(e.getMessage());
        } else if (e instanceof RemoteException) {
            if (isSimple) {
                retVo.setRetCode(CasConstants.ERROR_CODE_SYSTEM_ERROR);
                retVo.setMsgTitle("接口接连异常！");
            } else {
                retVo.setMsgTitle(e.getMessage());
            }
        } else if (e instanceof ServiceException) {
            if (isSimple) {
                retVo.setRetCode(CasConstants.ERROR_CODE_SYSTEM_ERROR);
                retVo.setMsgTitle("接口服务部署异常！");
            } else {
                retVo.setMsgTitle(e.getMessage());
            }
        } else {
            if (!StringUtils.isNullOrEmpty(e.getLocalizedMessage())) {
                retVo.setMsgTitle(e.getLocalizedMessage());
            } else if (!StringUtils.isNullOrEmpty(e.getMessage())) {
                retVo.setMsgTitle(e.getMessage());
            } else {
                retVo.setMsgTitle(e + " at " + e.getStackTrace()[0].toString());
            }
        }
        return retVo;
    }
    
    /**
     * 根据异常获取返回信息
     * （原版提示）
     * .
     * 
     * @param e
     * @return RetVO
     * @author Wangjianjun
     *         2011-12-1 Wangjianjun
     */
    public static RetVo getErrorMsg(final Throwable e) {
        return WsUtil.getErrorMsg(e, false);
    }

    /**
     * 生成异常的响应报文
     * .
     * 
     * @param inXml
     *            请求报文
     * @param xsdType
     *            xsd的格式. 目前只有两种格式的xsd, 一种是info, 另一种是inParam|outParam.
     *            xsdType为0时表示是info格式的xsd. 为1时,是inParam|outParam
     * @param falseResultCode
     *            响应报文中的result节点的错误值
     * @param e
     *            异常
     * @return
     * @author: g.caijx
     * @修改记录：
     *        ==============================================================<br>
     *        日期:2011-12-15 g.caijx 创建方法，并实现其功能
     *        ==============================================================<br>
     */
    public static String getOutXmlByException(final String inXml, final int xsdType,
        final String falseResultCode, final Throwable e) {
        RetVo retVo = null;
        try {
            retVo = WsUtil.getErrorMsg(e, true);
        } catch (final Exception e2) {
            retVo = new RetVo(true);
            retVo.setRetCode(CasConstants.ERROR_CODE_SYSTEM_ERROR);
            retVo.setMsgTitle(e2.getMessage());
        }
        
        final StringBuffer sb = new StringBuffer();
        sb.append("<error><id>");
        sb.append(retVo.getRetCode());
        sb.append("</id><message>");
        //crm00057042 FJCRMV2.0_BUG_计费调用服务bankAcctNotify返回报错信息修正_接口 qiurl 20140806
        //sb.append(retVo.getRetMsg());
        String retMsg = retVo.getMsgTitle();
        if(null!=retMsg){
            retMsg= retMsg.length()>1000?retMsg.substring(0, 1000).replace("<", "[").replace(">", "]"):retMsg.replace("<", "[").replace(">", "]");
        }
        sb.append(retMsg);
        //end
        sb.append("</message></error>");
        
        return WsUtil.getOutXml(inXml, xsdType, falseResultCode, sb.toString());
    }
    /**
     * 生成响应报文
     * .
     * 
     * @param inXml
     *            请求报文
     * @param xsdType
     *            xsd的格式. 目前只有两种格式的xsd, 一种是info, 另一种是inParam|outParam.
     *            xsdType为0时表示是info格式的xsd. 为1时,是inParam|outParam
     * @param resultCode
     *            响应报文中的result节点的值
     * @param resultXml
     *            msgBody节点中除了result节点以外的内容
     * @return
     * @author g.caijx
     *         2012-2-4 g.caijx
     */
    public static String getOutXml(final String inXml, final int xsdType, final String resultCode,
        final String resultXml) {
        final String msgType = WsUtil.getXmlContent(inXml, "msgType");
        final String sysSign = WsUtil.getXmlContent(inXml, "sysSign");
        final String serial = WsUtil.getXmlContent(inXml, "serial");
        final String outSystem = WsUtil.getXmlContent(inXml, "from");// 外系统
        
        String msgBodyChildName = null;
        if (0 == xsdType) {
            msgBodyChildName = "info";
        } else if (1 == xsdType) {
            msgBodyChildName = "outParam";
        }
        
        final String time = DateUtils.date2Str(new Date(), "yyyyMMddHHmmss");
        
        final StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sb.append("<root><msgHead><time>");
        sb.append(time);
        sb.append("</time><from>");
        sb.append("CRM");
        sb.append("</from><to>");
        sb.append(outSystem);
        sb.append("</to><sysSign>");
        sb.append(sysSign);
        sb.append("</sysSign><msgType>");
        sb.append(msgType);
        sb.append("</msgType><serial>");
        sb.append(serial);
        sb.append("</serial></msgHead><msgBody><" + msgBodyChildName + "><result>");
        sb.append(resultCode);
        sb.append("</result>");
        sb.append(resultXml);
        sb.append("</" + msgBodyChildName + "></msgBody></root>");
        return sb.toString();
    }
    
    /**
     * 把msgHead和msgBody打包成报文
     * .
     * 
     * @param xsdClass
     *            xsd类, 如 com.ffcs.crm2.intf.hbbean.dispartGroupQuery.Root.class
     * @param msgHead
     *            如果这个参数的类型与xsdClass中的msgHead属性的类型不一致,
     *            则用PropertyUtils.copyProperties(dest, org)方法进行转换.
     * @param msgBodyChild
     *            如 com.ffcs.crm2.intf.srmbean.holdCodeRangesReq.Info类型的对象
     * @return
     * @throws Exception
     * @author: g.caijx
     * @修改记录：
     *        ==============================================================<br>
     *        日期:2011-12-15 g.caijx 创建方法，并实现其功能
     *        ==============================================================<br>
     */
    public static String toXml(final Class<?> xsdClass, Object msgHead, final Object msgBodyChild)
        throws Exception {
        
        // 取msgBodyChild的类名, 如: Info, InParam, OutParam
        String msgBodyChildName = msgBodyChild.getClass().getSimpleName();
        // 首字母改成小写, 如: info, inParam, outParam
        msgBodyChildName = msgBodyChildName.substring(0, 1).toLowerCase()
            + msgBodyChildName.substring(1);
        
        final Object root = xsdClass.newInstance();
        
        // 二手服务调用, msgHead的处理...
        final Class<?> msgHeadClass = PropertyUtils.getPropertyType(root, "msgHead");
        if (msgHead.getClass() != msgHeadClass) {
            final Object dest = msgHeadClass.newInstance();
            PropertyUtils.copyProperties(dest, msgHead);
            msgHead = dest;
        }
        
        PropertyUtils.setSimpleProperty(root, "msgHead", msgHead);
        final Object msgBody = PropertyUtils.getPropertyType(root, "msgBody").newInstance();
        PropertyUtils.setSimpleProperty(msgBody, msgBodyChildName, msgBodyChild);
        PropertyUtils.setSimpleProperty(root, "msgBody", msgBody);
        final Writer w = new java.io.StringWriter();
        org.exolab.castor.xml.Marshaller.marshal(root, w);
        final String inXml = ToGb2312.delNameSpace(w.toString());
        
        return inXml;
    }
    /**
     * 通过接口参数获取参数字符串
     * .
     * 
     * @param params
     *            Object... 接口参数列表
     * @return String 参数字符串
     *         样式：【参数1,参数2,参数3】
     * @author Wangjianjun
     *         2011-12-22 Wangjianjun
     */
    public static String getStringParam(final Object... params) {
        String inParam = "";
        if (params != null && params.length > 0) {
            final StringBuffer sb = new StringBuffer();
            for (final Object obj : params) {
                if (obj != null) {
                    sb.append(obj.toString() + ",");
                }
            }
            inParam = sb.toString();
            if (inParam.lastIndexOf(",") + 1 == inParam.length()) {
                inParam = inParam.substring(0, inParam.lastIndexOf(","));
            }
        }
        return inParam;
    }

    /**
     * 对外系统返回的错误信息进行格式化处理.
     *
     * @param code 系统
     * @param errFlag 错误标识
     * @param outXml 返回包
     * @param resultNode  成功失败节点名称
     * @param messageNode 错误信息节点名称
     * @return
     * @author ouzhf
     *         2012-11-18 ouzhf
     */
    public static String getFormatOutXml(final String code, final String errFlag,
                                         final String outXml, final String resultNode, final String messageNode) {
        String out = outXml;
        try {
            // 错误返回进行处理
            // 当服务返回错误信息的时候，封装下错误信息：某某系统服务有问题，请联系某某系统维护人员，错误信息如下：”返回的错误信息“
            if (errFlag.equals(WsUtil.getXmlContent(out, resultNode))) {
                final AttrSpec attrSpec = CrmClassUtils.getAttrSpecByCode(
                        IntfConstant.INTF_URL_CLASS.getValue(), code);
                if (attrSpec != null && !StringUtils.isNullOrEmpty(attrSpec.getAttrName())) {
                    String message = WsUtil.getXmlContent(out, messageNode);
                    //PRO_201302166879 2013.3.20
                    if (IntfConstant.HB_WS_URL.getValue().equals(code)) {
                        out = out.replace("<" + messageNode + ">" + message + "</" + messageNode
                                + ">", "<" + messageNode + ">" + attrSpec.getAttrName()
                                + "返回异常，具体提示如下：“" + message + "”</" + messageNode + ">");
                    } else {
                        out = out.replace("<" + messageNode + ">" + message + "</" + messageNode
                                + ">", "<" + messageNode + ">" + attrSpec.getAttrName() + "服务有问题，请联系"
                                + attrSpec.getAttrName() + "维护人员，错误信息如下：“" + message + "”</"
                                + messageNode + ">");
                    }
                }
            }
        } catch (RtManagerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }
    
    /**
     * 根据接口配置编码，判断是否需要模拟返回.
     * @param code
     * @param msgType
     * @return
     * @author Luxb
     * 2016年2月25日 Luxb
     */
    public static boolean isSimuReturn(final String code, final String msgType) {
        try {
            AttrSpec attrSpec = CrmClassUtils.getAttrSpecByCode(IntfConstant.INTF_URL_CLASS.getValue(), code);
            if (attrSpec == null) {
                throw new RtManagerException("接口(" + code + ")未配置！");
            }
            if (attrSpec.getIsPost() != null && attrSpec.getIsPost() == 1) {
                return true;
            }
            if(msgType == null){
            	return false;
            }
            
            /*List<AttrValue> values = CrmClassUtils.getAttrValues(IntfConstant.INTF_URL_CLASS.getValue(), attrSpec.getJavaCode());
            if (values != null) {
                for (AttrValue attrValue : values) {
                    if (attrValue == null) {
                        continue;
                    }
                    // 接口方法状态配置为不可用时，接口关闭，未配置时默认为打开
                    if (msgType.equals(attrValue.getAttrValueName())
                        && IntfConstant.INTF_SERVICE_STATUS_SIMU.equals(attrValue.getIsTrans())) {
                        return true;
                    }
                }
            }*/
        } catch (RtManagerException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("isSimuReturn发生异常:" + "code=" + code + ",msgType=" + msgType);
            e.printStackTrace();
            return false;
        }
        return false;
    }
    
    /**
     * 获取接口默认返回值
     * .
     * 
     * @param attrSpec
     * @param method
     * @return
     * @author wangjianjun
     *         2011-11-30 wangjianjun
     */
    public static String getDefaultRespMsg(final String code, final String methodName) {
        AttrSpec attrSpec = CrmClassUtils.getAttrSpecByCode(IntfConstant.INTF_URL_CLASS.getValue(), code);
        if (attrSpec != null) {
            List<AttrValue> values = CrmClassUtils.getAttrValues(IntfConstant.INTF_URL_CLASS.getValue(), attrSpec.getJavaCode());
            if (values != null) {
                for (AttrValue attrValue : values) {
                    if (attrValue == null) {
                        continue;
                    }
                    if (methodName.equals(attrValue.getAttrValueName())) {
                        return attrValue.getAttrValue();
                    }
                }
            }
        }
        return "";
    }
    /**
     * 获取本机IP
     * .
     * 
     * @return
     * @author Wangjianjun
     * 2012-5-21 Wangjianjun
     */
    public static String getHostIp() {
        try {
            final String hostName = InetAddress.getLocalHost().getHostName();
            final InetAddress byName = InetAddress.getByName(hostName);
            return byName.getHostAddress();
        } catch (final UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

}
