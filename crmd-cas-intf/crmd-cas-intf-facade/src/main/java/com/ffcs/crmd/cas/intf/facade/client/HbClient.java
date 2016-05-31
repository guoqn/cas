package com.ffcs.crmd.cas.intf.facade.client;

import org.springframework.stereotype.Service;

import com.ffcs.crmd.cas.constants.IntfConstant;
import com.ffcs.crmd.cas.intf.facade.client.base.BaseClient;
import com.ffcs.crmd.cas.intf.util.WsUtil;

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
@Service("hbClient")
public class HbClient extends BaseClient {

    public String call(String msgType, String inXml) throws Exception {
        //20140801 liufzh   crm00056912  CRM调用计费自动算费接口端口改造
        //计费给的方案是将自动算费单独换到7052端口，其他的保留7051，避免7051负担过重。请研发修改
        //add by fangj crm00063258 计费要求3G增量服务地址端口切换至7052，避免7051压力过大
        IntfConstant intfConstant = IntfConstant.getByCode(msgType);
        if (intfConstant == IntfConstant.MSG_TYPE_INCREMENT_UPDATE
            || intfConstant == IntfConstant.MSG_TYPE_BATCH_DATA_UPDATE
            || intfConstant == IntfConstant.MSG_TYPE_BATCH_DATA_UPDATE_4G
            || intfConstant == IntfConstant.MSG_TYPE_AUTO_ONE_PRICE_CALE) {
            String outXml = call(IntfConstant.HB_PL_WS_URL.getValue(),
                IntfConstant.WS_METHOD_NAME.getValue(), msgType, inXml);
            return WsUtil.getFormatOutXml(IntfConstant.HB_PL_WS_URL.getValue(),
                IntfConstant.RESULT_FALSE.getValue(),
                outXml, IntfConstant.XML_NODE_RESULT.getValue(),
                IntfConstant.XML_NODE_MESSAGE.getValue());
        } else {
            String outXml = call(IntfConstant.HB_WS_URL.getValue(),
                IntfConstant.WS_METHOD_NAME.getValue(), msgType, inXml);
            return WsUtil.getFormatOutXml(IntfConstant.HB_WS_URL.getValue(),
                IntfConstant.RESULT_FALSE.getValue(),
                outXml, IntfConstant.XML_NODE_RESULT.getValue(),
                IntfConstant.XML_NODE_MESSAGE.getValue());
        }
    }



    @Override
    protected String getServiceName() {
        return "HbClient";
    }
}
