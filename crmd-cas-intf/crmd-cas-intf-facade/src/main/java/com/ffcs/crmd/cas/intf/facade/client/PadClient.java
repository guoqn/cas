package com.ffcs.crmd.cas.intf.facade.client;

import com.ffcs.crmd.cas.constants.IntfConstant;
import com.ffcs.crmd.cas.intf.facade.client.base.BaseClient;

import org.springframework.stereotype.Service;

/**
 * .
 *
 * @author Luxb
 * @version Revision 1.0.0
 * @版权：福富软件 版权所有 (c) 2011
 * @see:
 * @创建日期：2016/1/21
 * @功能说明：
 */
@Service("padClient")
public class PadClient extends BaseClient {
    /**
     *
     * @param msgType
     * @param inXml
     * @return
     * @throws Exception
     */
    public String call(String msgType, String inXml) throws Exception{
        String outXml = call(IntfConstant.MOBILESALE_WS_URL.getValue(), "exchange", msgType, inXml);
        return outXml;
    }

    @Override
    protected String getServiceName() {
        return "MobileServicSV";
    }
}
