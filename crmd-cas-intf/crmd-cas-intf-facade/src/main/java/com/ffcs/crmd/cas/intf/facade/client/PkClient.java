package com.ffcs.crmd.cas.intf.facade.client;

import com.ffcs.crmd.cas.intf.facade.client.base.BaseClient;

import org.springframework.stereotype.Service;

@Service("pkClient")
public class PkClient extends BaseClient {

	@Override
	protected String getServiceName() {
		return "PkService";
	}

	public String call(String msgType, String inXml) throws Exception {
		return callByNameSpaceAndArgName4Ppm("PK_WS_URL", "autoGenOrder", msgType,
			"http://webService.iebus4g.business.itest.pktech.com", "paramJson", inXml);
	}
}
