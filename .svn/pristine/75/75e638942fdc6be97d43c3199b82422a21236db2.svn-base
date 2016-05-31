package com.ffcs.crmd.cas.intf.facade.impl;

import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.cas.constants.IntfConstant;
import com.ffcs.crmd.cas.intf.api.facade.ICasToPreOrderFacade;
import com.ffcs.crmd.cas.intf.facade.client.PreOrderClient;
import com.ffcs.crmd.cas.intf.util.WsUtil;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.apache.log4j.Logger;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;

import java.io.*;

@Service("casToPreOrderFacade")
public class CasToPreOrderFacadeImpl implements ICasToPreOrderFacade {
    private Logger         logger         = Logger.getLogger(CasToPreOrderFacadeImpl.class);
    private PreOrderClient preOrderClient = (PreOrderClient) ApplicationContextUtil.getBean("preOrderClient");
 
    @Override
    public RetVo preSaleOrder(String inXml){
        RetVo retVo = new RetVo();
        try {
            if (logger.isInfoEnabled()) {
                Writer writer = new StringWriter();
                Marshaller.marshal(inXml, writer);
                logger.info(writer.toString());
            }
            String msgType = WsUtil.getXmlContent(inXml, "msgType");
            String outXml = "";
            outXml = this.preOrderClient.call(msgType, inXml);

            if (logger.isInfoEnabled()) {
                logger.info(outXml);
            }
 
            if (outXml == null) {
                retVo.setResult(false);
                retVo.setRetCode(IntfConstant.INTF_WS_CLOSED.getValue());
                retVo.setMsgTitle("PreWorkOrder接口关闭");
                return retVo;
            }
            final Reader r = new StringReader(outXml);
            if ("createPreSaleOrder".equals(msgType)) {
                final com.ffcs.crmd.cas.bean.casbean.modpreorderbean.createPreSaleOrder.Root respRoot = (com.ffcs.crmd.cas.bean.casbean.modpreorderbean.createPreSaleOrder.Root) Unmarshaller
                    .unmarshal(com.ffcs.crmd.cas.bean.casbean.modpreorderbean.createPreSaleOrder.Root.class,
                            new InputSource(new ByteArrayInputStream(outXml.getBytes("utf-8"))));
                if (IntfConstant.RESULT_TRUE.getValue().equals(respRoot.getMsgBody().getOutParam().getResult())) {
                    retVo.setResult(true);
                } else {
                    retVo.setResult(false);
                    if (respRoot.getMsgBody().getOutParam().getError() != null) {
                        retVo.setRetCode(respRoot.getMsgBody().getOutParam().getError().getId());
                        retVo.setMsgTitle(respRoot.getMsgBody().getOutParam().getError().getMessage());
                    }
                }
            } else if ("notifyPreSaleOrder".equals(msgType)) {
                final com.ffcs.crmd.cas.bean.casbean.modpreorderbean.notifyPreSaleOrder.Root respRoot = (com.ffcs.crmd.cas.bean.casbean.modpreorderbean.notifyPreSaleOrder.Root) Unmarshaller
                    .unmarshal(com.ffcs.crmd.cas.bean.casbean.modpreorderbean.notifyPreSaleOrder.Root.class,
                        new InputSource(new ByteArrayInputStream(outXml.getBytes("utf-8"))));
                if ( IntfConstant.RESULT_TRUE.getValue().equals(respRoot.getMsgBody().getOutParam().getResult())) {
                    retVo.setResult(true);
                } else {
                    retVo.setResult(false);
                    if (respRoot.getMsgBody().getOutParam().getError() != null) {
                        retVo.setRetCode(respRoot.getMsgBody().getOutParam().getError().getId());
                        retVo.setMsgTitle(respRoot.getMsgBody().getOutParam().getError().getMessage());
                    }
                }
            } else if ("modPreSaleOrderState".equals(msgType)) {
                final com.ffcs.crmd.cas.bean.casbean.modpreorderbean.modPreSaleOrderState.Root respRoot = (com.ffcs.crmd.cas.bean.casbean.modpreorderbean.modPreSaleOrderState.Root) Unmarshaller
                    .unmarshal(com.ffcs.crmd.cas.bean.casbean.modpreorderbean.modPreSaleOrderState.Root.class,
                        new InputSource(new ByteArrayInputStream(outXml.getBytes("utf-8"))));
                if ( IntfConstant.RESULT_TRUE.getValue().equals(respRoot.getMsgBody().getOutParam().getResult())) {
                    retVo.setResult(true);
                } else {
                    retVo.setResult(false);
                    if (respRoot.getMsgBody().getOutParam().getError() != null) {
                        retVo.setRetCode(respRoot.getMsgBody().getOutParam().getError().getId());
                        retVo.setMsgTitle(respRoot.getMsgBody().getOutParam().getError().getMessage());
                    }
                }
            }
            return retVo;
        } catch (final Exception e) {
            return WsUtil.getErrorMsg(e);
        }
    }
 
}
