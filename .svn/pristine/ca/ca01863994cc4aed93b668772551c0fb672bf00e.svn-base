package com.ffcs.crmd.cas.intf.facade.impl;

import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ffcs.crmd.cas.base.utils.TransUtil;
import com.ffcs.crmd.cas.bean.smsbean.comm.MsgHead;
import com.ffcs.crmd.cas.constants.IntfConstant;
import com.ffcs.crmd.cas.intf.api.dto.SendMessageInDTO;
import com.ffcs.crmd.cas.intf.api.dto.SendMessageOutDTO;
import com.ffcs.crmd.cas.intf.api.facade.ICasToSmsFacade;
import com.ffcs.crmd.cas.intf.facade.client.SmsClient;
import com.ffcs.crmd.cas.intf.util.WsUtil;
import com.ffcs.crmd.cas.intf.util.crm.ToGb2312;
import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.exolab.castor.xml.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;

import java.io.ByteArrayInputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Date;

/**
 * .
 *
 * @author Luxb
 * @version Revision 1.0.0
 * @版权：福富软件 版权所有 (c) 2011
 * @see:
 * @创建日期：2016/1/19
 * @功能说明：
 */
@Service("casToSmsFacade")
public class CasToSmsFacadeImpl implements ICasToSmsFacade {
    @Autowired
    private SmsClient client;
    @Override
    public RetVo sendMessage(SendMessageInDTO inParamDto){
        try {

            String msgType = IntfConstant.MSG_TYPE_SM_POST.getValue();
            com.ffcs.crmd.cas.bean.smsbean.smpost.Root reqRoot = new com.ffcs.crmd.cas.bean.smsbean.smpost.Root();
            com.ffcs.crmd.cas.bean.smsbean.smpost.MsgBody body = new com.ffcs.crmd.cas.bean.smsbean.smpost.MsgBody();
            reqRoot.setMsgBody(body);
            reqRoot.setMsgHead(getReqMsgHead(msgType));
            com.ffcs.crmd.cas.bean.smsbean.smpost.InParam inParam = new com.ffcs.crmd.cas.bean.smsbean.smpost.InParam();
            CrmBeanUtils.applyIf(inParam, inParamDto);
            body.setInParam(inParam);
            final Writer w = new java.io.StringWriter();
            org.exolab.castor.xml.Marshaller.marshal(reqRoot, w);
            final String inXml = ToGb2312.delNameSpace(w.toString());
            final String outXml = this.client.call(msgType, inXml);
            final RetVo retVo = new RetVo();
            if (outXml == null) {
                retVo.setResult(false);
                retVo.setRetCode(IntfConstant.INTF_WS_CLOSED.getValue());
                retVo.setMsgTitle("短信发送接口关闭");
                return retVo;
            }
            final Reader r = new java.io.StringReader(outXml);

            final com.ffcs.crmd.cas.bean.smsbean.smpost.Root respRoot = (com.ffcs.crmd.cas.bean.smsbean.smpost.Root) Unmarshaller.
                unmarshal(com.ffcs.crmd.cas.bean.smsbean.smpost.Root.class,
                    new InputSource(new ByteArrayInputStream(outXml.getBytes("utf-8"))));
            retVo.setResult(true);
            com.ffcs.crmd.cas.bean.smsbean.smpost.OutParam outParam = respRoot.getMsgBody().getOutParam();
            if (IntfConstant.RESULT_FALSE.getValue().equals(outParam.getResult())) {
                retVo.setResult(false);
                retVo.setRetCode(outParam.getError().getId());
                retVo.setMsgTitle(outParam.getError().getMessage());
            } else {
                SendMessageOutDTO outDTO = new SendMessageOutDTO();
                CrmBeanUtils.applyIf(outDTO, respRoot.getMsgBody().getOutParam());
                retVo.setObject(outDTO);
            }
            return retVo;
        } catch (final Exception e) {
            return WsUtil.getErrorMsg(e);
        }
    }

    /**
     * 报文头部拼装。
     * @param msgType
     * @return
     */
    private MsgHead getReqMsgHead(String msgType) {
        final MsgHead head = new MsgHead();
        head.setFrom("CRM");
        head.setTo("SMS");
        head.setSysSign("SMS_CRM");
        final String transid = TransUtil.getTransId();
        head.setSerial(transid);
        head.setMsgType(msgType);
        final String time = DateUtils.date2Str(new Date(), "yyyyMMddHHmmss");
        head.setTime(time);
        return head;
    }
}
