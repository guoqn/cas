package com.ffcs.crmd.cas.intf.facade.client;

import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ffcs.crmd.cas.constants.IntfConstant;
import com.ffcs.crmd.cas.intf.facade.client.base.BaseClient;

import org.springframework.stereotype.Service;

@Service("preOrderClient")
public class PreOrderClient extends BaseClient {
	
    /**
     * 调用服务
     * .
     * 
     * @param msgType String 消息类型
     * @param inXml String 请求报文
     * @return String 响应报文，接口关闭时返回 null
     * @throws Exception
     * @author qiurl
     * 2011-12-1 qiurl
     */
	public String call(String msgType, String inXml) throws Exception {
	    try {
		    String outXml = callByNameSpaceAndArgName(
		    		IntfConstant.PRE_ORDER_WS_URL.getValue(), "exchange", msgType,
		    		"http://server.workorder.qztc.com", "reqXml", inXml);
		    return outXml;
        } catch (Exception e) {
            throw new RtManagerException("泉州工单池系统接口异常！"+e.getMessage());
        }
    }

    @Override
    protected String getServiceName() {
        return "preWorkOrderClient";
    }
	
}

