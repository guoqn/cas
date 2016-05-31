package com.ffcs.crmd.cas.intf.facade.client;

import com.ffcs.crmd.cas.constants.IntfConstant;
import com.ffcs.crmd.cas.intf.facade.client.base.BaseClient;
import com.ffcs.crmd.cas.intf.util.WsUtil;

import org.springframework.stereotype.Service;

/**
 * .
 *
 * @author Luxb
 * @version Revision 1.0.0
 * @版权：福富软件 版权所有 (c) 2011
 * @see:
 * @创建日期：2016/1/16
 * @功能说明：
 */
@Service("smsClient")
public class SmsClient extends BaseClient {
    @Override
    protected String getServiceName() {
        return "smsClient";
    }

    public String call(String msgType, String inXml) throws Exception {
        String outXml = callByNameSpaceAndArgName(IntfConstant.SMS_WS_URL.getValue(),
                IntfConstant.NOR_WS_METHOD_NAME.getValue(), msgType,
                "http://smsService.services.ptn.com", "xml", inXml);
        return WsUtil.getFormatOutXml(IntfConstant.SMS_WS_URL.getValue(), IntfConstant.RESULT_FALSE.getValue(),
                outXml, IntfConstant.XML_NODE_RESULT.getValue(), IntfConstant.XML_NODE_MESSAGE.getValue());
    }
}
