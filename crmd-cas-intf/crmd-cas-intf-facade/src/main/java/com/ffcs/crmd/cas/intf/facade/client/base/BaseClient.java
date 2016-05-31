package com.ffcs.crmd.cas.intf.facade.client.base;

import com.ffcs.crmd.cas.intf.util.WsUtil;

public abstract class BaseClient extends BasestClient{
	@Override
	public String getInXml(Object... params) {
		String inParam = WsUtil.getStringParam(params);
		return inParam;
	}
	/**
	 * 外围系统接口公共调用方法
	 * .
	 * 
	 * @param code String 接口配置常量 如:IntfConstants.PF_WS_URL
	 * @param methodName String 接口对应方法名	 
	 * @param msgType String 接口方法名
	 * @param params Object... 参数列表
	 * @return String 响应报文
	 * @author wangjianjun
	 * 2011-11-30 wangjianjun
	 * @throws Exception 
	 */
	public String call(String code, String methodName, String msgType, Object... params) throws Exception {
	    return (String)call(1, null, code,  methodName,  msgType, params);
	}
	/**
	 * 通过命名空间方式调用外围接口服务。
	 * @param code
	 * @param methodName
	 * @param msgType
	 * @param nameSpace
	 * @param argName
	 * @param params
     * @return
     * @throws Exception
     */
	public String callByNameSpaceAndArgName(String code, String methodName, String msgType,
											String nameSpace, String argName, Object... params) throws Exception {
		this.setNameSpace(nameSpace);
		this.setArgName(argName);
		return (String) call(CALL_TYPE_STRING_nameSpaceAndArgName, null, code, methodName, msgType, params);
	}

	public String callByNameSpaceAndArgName4Ppm(String code, String methodName, String msgType,
												String nameSpace, String argName, Object... params) throws Exception {
		this.setNameSpace(nameSpace);
		this.setArgName(argName);
		return (String) call(CALL_TYPE_STRING_nameSpaceAndArgName4Ppm, null, code, methodName, msgType, params);
	}
}
