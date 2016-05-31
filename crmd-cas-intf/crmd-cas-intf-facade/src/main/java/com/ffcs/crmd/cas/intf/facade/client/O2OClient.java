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
@Service("o2oClient")
public class O2OClient extends BaseClient{
    public String call(String msgType, String inXml) throws Exception{
        String outXml = callByNameSpaceAndArgName4Ppm(
                IntfConstant.O2O_WS_URL.getValue(), "get", msgType,
                "http://crm.webServices.eecp.ffcs.com", "reqXml", inXml);
        return outXml;
    }
    @Override
    protected String getServiceName() {
        return "receiveCrmNotice";
    }
}
