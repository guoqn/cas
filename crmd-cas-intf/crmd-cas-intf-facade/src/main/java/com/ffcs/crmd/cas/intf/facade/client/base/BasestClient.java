package com.ffcs.crmd.cas.intf.facade.client.base;

import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.base.utils.CrmClassUtils;
import com.ffcs.crmd.cas.constants.IntfConstant;
import com.ffcs.crmd.cas.intf.entity.CasIntfLogInfo;
import com.ffcs.crmd.cas.intf.entity.CasIntfLogRec;
import com.ffcs.crmd.cas.intf.service.ICasIntfLogRecService;
import com.ffcs.crmd.cas.intf.util.WsUtil;
import com.ffcs.crmd.cas.intf.util.XmlUtil;
import com.ffcs.crmd.platform.meta.entity.AttrSpec;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.annotation.Resource;
import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.sql.Timestamp;

public abstract class BasestClient {
	final static int CALL_TYPE_STRING           = 1;
	final static int CALL_TYPE_OBJECT           = 2;
	final static int CALL_TYPE_5OBJECT          = 5;
	final static int CALL_TYPE_STRING_ArgName   = 6;//操作的参数名为可修改
	final static int CALL_TYPE_STRING_nameSpaceAndArgName   = 7;//操作的名空间和参数名为可修改
	final static int CALL_TYPE_STRING_nameSpaceAndArgName4Ppm   = 8;//操作的名空间和参数名为可修改
	final static int CALL_TYPE_5OBJECT_OBJ      = 9; //返回OBJECT 对象
	final static int CALL_TYPE_STRING_CHANNEL_VIEW      = 10; //针对宁夏渠道视图做特殊处理  crm00056125 LiuWenYi 20140629
	final static int CALL_TYPE_HTTP_POST        = 11;
	final static int CALL_TYPE_STRING_nameSpaceAndArgName4O2O	= 12;
	final static int CALL_TYPE_HTTP_POST_BY_FULL_URL        = 13;
	final static int CALL_TYPE_WEB_SERVICE        = 14;

	/**
	 * 操作的参数名.
	 */
	String argName = "arg0";
	/**
	 * 命名空间。
	 */
	String nameSpace = "";
	@Resource
	ICasIntfLogRecService casIntfLogRecService;

	public abstract String getInXml(Object... params);

	protected abstract String getServiceName();
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
	public Object call(int callType, String path, String code, String methodName, String msgType,
			Object... params) throws Exception {
		String remark = "";
		long result = 0;
		String inParam = null;
		String outParam = "";
		int timeOut = 60000;
		String url = "";
		if (params.length >0) {
			inParam = params[0]+"";
		}
		long beginTime = 0;
		long endTime = 0;
		Timestamp reqTime = new Timestamp(DateUtils.getNowDate().getTime());
		String from = XmlUtil.getXmlContent(inParam, "from");
		String to = XmlUtil.getXmlContent(inParam, "to");
		String serial = XmlUtil.getXmlContent(inParam, "serial");
		String preOrderNumber = XmlUtil.getXmlContent(inParam, "preCustSoNum");
		if (StringUtils.isNullOrEmpty(preOrderNumber)) {
			preOrderNumber = XmlUtil.getXmlContent(inParam, "preOrderNumber");
		}
		if("smPost".equals(msgType)){
			from = "CAS"; //集中受理平台调用短信网关未制授权，特殊处理
		}
		String resultNode = "";
		String resultMessage = "";
		try {
			beginTime = System.nanoTime();
			if (WsUtil.isSimuReturn(code, msgType)) {
				outParam = WsUtil.getDefaultRespMsg(code, msgType);
				// 未配置返回值则抛出异常
				if (StringUtils.isNullOrEmpty(outParam)) {
					remark = "接口地址" + code + "方法" + msgType + "未配置默认返回值！";
					throw new RtManagerException("接口地址" + code + "方法" + msgType + "未配置默认返回值！");
				}
				remark = "模拟返回";
				// 内部问题，不必重调返回结果=2
				result = 2;
				return outParam;
			}

			if (path != null && path.indexOf("://") > 0) {
				url = path;
			}else{
				/**
				 *正常情况下调用外围接口
				 */
				AttrSpec attrSpec = CrmClassUtils.getAttrSpecByCode(IntfConstant.INTF_URL_CLASS.getValue(), code);
				if (attrSpec != null && !StringUtils.isNullOrEmpty(attrSpec.getDefaultValue())) {
					url = attrSpec.getDefaultValue();
				}
			}
			if(StringUtils.isNullOrEmpty(url)){
				remark = "地址未配置";
				result = 2;
				throw new RtManagerException("接口地址" + code + "未配置！");
			}
			if(callType == CALL_TYPE_STRING_nameSpaceAndArgName) {
				//namespace, argName需先设置
				outParam = callServiceByNameSpaceAndArgName(url, methodName, timeOut,
						this.nameSpace, this.argName, params);
			} else if (callType ==  CALL_TYPE_STRING_nameSpaceAndArgName4Ppm){
				outParam = callServiceByNameSpaceAndArgName4Ppm(url, methodName, timeOut,
						this.nameSpace, this.argName, params);
			} else {
				outParam = callService(url, methodName, timeOut, params);
			}
			resultNode = WsUtil.getXmlContent(outParam,"result");
			if("0".equals(resultNode) || "true".endsWith(resultNode)){
				result = 0;
				resultMessage = WsUtil.getXmlContent(outParam,"message");
			}else if("1".equals(resultNode) || "false".equals(resultNode)){
				result = 1;
				resultMessage = WsUtil.getXmlContent(outParam,"message");
			}else{
				result = -1;
				resultMessage = WsUtil.getXmlContent(outParam,"message");
			}
		} catch (RemoteException e) {
			result = 2;
			if (e.getCause() instanceof java.net.SocketTimeoutException) {
				remark = "接口超时";
				throw new Exception("调用接口[" + code + "]超时!!");
			}
			resultMessage = subString(e.getMessage(),0,400);
			if (!StringUtils.isNullOrEmpty(e.getCause())) {
				remark = subString(e.getCause().toString(),0,400);
			}
			throw e;
		}catch (RtManagerException e) {
			result = 2;
			resultMessage = subString(e.getMessage(),0,400);
			throw e;
		} catch (Exception e) {
			result = 2;
			resultMessage = subString(e.getMessage(),0,400);
			remark = subString(e.getCause().toString(),0,400);
			throw e;
		} finally {
			endTime = System.nanoTime();
			CasIntfLogRec intfLogRec = new CasIntfLogRec(true);
			CasIntfLogInfo intfLogInfo = new CasIntfLogInfo(true);
			intfLogInfo.setCasIntfLogRecId(intfLogRec.getCasIntfLogRecId());
			intfLogRec.setMethodName(methodName);
			intfLogRec.setMsgType(msgType);
			intfLogRec.setRequester(from);
			intfLogRec.setReqDate(reqTime);
			intfLogRec.setReqTranId(serial);
			intfLogRec.setConsumeTimestamp(endTime - beginTime);
			intfLogInfo.setReqMessage(StringUtils.strnull(inParam));
			Timestamp rspTime = new Timestamp(DateUtils.getNowDate().getTime());
			intfLogRec.setRspDate(rspTime);
			intfLogRec.setCreateDate(rspTime);
			intfLogInfo.setRspMessage(outParam);
			intfLogRec.setResult(result);
			intfLogRec.setResultMessage(resultMessage);
			intfLogRec.setRemark(remark);
			intfLogRec.setServerMsg(url);
			intfLogRec.setResponser(to);
			intfLogRec.setClientMsg(WsUtil.getHostIp());
			intfLogRec.setRspTranId(preOrderNumber);
			try {
				casIntfLogRecService.indepSaveIntfLog(intfLogRec, intfLogInfo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return outParam;
	}
	/**
	 * 外围系统接口公共调用方法
	 * .
	 *
	 * @param url String 接口URL地址
	 * @param methodName String 接口方法名
	 * @param params Object... 请求参数
	 * @return
	 * @throws RemoteException
	 * @throws MalformedURLException
	 * @throws ServiceException
	 */
	public static String callService(String url, String methodName, Integer timeout,
			Object... params) throws RemoteException, MalformedURLException, ServiceException {
		String outXml = "";
		Service service = new Service();
		Call call = (Call) service.createCall();
		call.setTargetEndpointAddress(new URL(url));
		call.setOperationName(methodName);
		call.setTimeout(timeout);
		outXml = (String) call.invoke(params);
		return outXml;
	}

	/**
	 *
	 * @param url
	 * @param methodName
	 * @param timeout
	 * @param nameSpace
	 * @param argName
	 * @param params
	 * @return
	 * @throws RemoteException
	 * @throws MalformedURLException
	 * @throws ServiceException
	 */
	public static String callServiceByNameSpaceAndArgName4Ppm(String url, String methodName,
			Integer timeout, String nameSpace, String argName, Object... params)
			throws RemoteException, MalformedURLException, ServiceException {
		String outXml = "";
		Service service = new Service();
		Call call = (Call) service.createCall();
		call.setTargetEndpointAddress(new URL(url));

		call.setOperationName(new QName(nameSpace, methodName));
		//操作的参数添加命名空间标识
		call.addParameter(new QName(nameSpace, argName), org.apache.axis.encoding.XMLType.XSD_STRING,
				javax.xml.rpc.ParameterMode.IN);// 操作的参数；
		call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型

		call.setTimeout(timeout);

		outXml = (String) call.invoke(params);
		return outXml;
	}

	public static String callServiceByNameSpaceAndArgName(String url, String methodName,
			Integer timeout, String nameSpace, String argName, Object... params)
			throws RemoteException, MalformedURLException, ServiceException {
		String outXml = "";
		Service service = new Service();
		Call call = (Call) service.createCall();
		call.setTargetEndpointAddress(new URL(url));

		call.setOperationName(new QName(nameSpace, methodName));
		call.addParameter(argName, org.apache.axis.encoding.XMLType.XSD_STRING,
				javax.xml.rpc.ParameterMode.IN);// 操作的参数
		call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型

		call.setTimeout(timeout);

		outXml = (String) call.invoke(params);
		return outXml;
	}

	public String getArgName() {
		return argName;
	}

	public void setArgName(String argName) {
		this.argName = argName;
	}

	public String getNameSpace() {
		return nameSpace;
	}

	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}

	private String subString(String str, int start, int end){
		if(!StringUtils.isNullOrEmpty(str) && str.length() >= end)
			return str.substring(start,  end);
		return str;
	}
}
