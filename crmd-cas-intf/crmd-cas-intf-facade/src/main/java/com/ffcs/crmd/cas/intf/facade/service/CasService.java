package com.ffcs.crmd.cas.intf.facade.service;

import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.cas.intf.api.facade.ICasFacade;
import com.ffcs.crmd.cas.intf.entity.CasIntfLogInfo;
import com.ffcs.crmd.cas.intf.entity.CasIntfLogRec;
import com.ffcs.crmd.cas.intf.service.ICasIntfLogRecService;
import com.ffcs.crmd.cas.intf.util.WsUtil;
import com.ffcs.crmd.cas.intf.util.XmlUtil;

import java.lang.reflect.Method;
import java.sql.Timestamp;

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
public class CasService {

	private ICasFacade casFacade = ApplicationContextUtil.getBean("casFacade");

	private ICasIntfLogRecService casIntfLogRecService = ApplicationContextUtil.getBean("casIntfLogRecService");
	/**
	 * 调用CAS服务统一入口.
	 * @param inXml
	 * @return
	 * @author
	 *
	 */
	public String exchange(final String inXml) {
		String outXml = "";
		String msgType = WsUtil.getXmlContent(inXml, "msgType");
		long beginTime = 0;
		long endTime = 0;
		long result = 0;
		Timestamp reqTime = new Timestamp(DateUtils.getNowDate().getTime());
		String from = XmlUtil.getXmlContent(inXml, "from");
		String to = XmlUtil.getXmlContent(inXml, "to");
		String serial = XmlUtil.getXmlContent(inXml, "serial");
		String preOrderNumber = XmlUtil.getXmlContent(inXml, "preCustSoNum");
		if (StringUtils.isNullOrEmpty(preOrderNumber)) {
			preOrderNumber = XmlUtil.getXmlContent(inXml, "preOrderNumber");
		}

		String resultNode = "";
		String resultMessage = "";
		try {
			if (StringUtils.isNullOrEmpty(msgType)) {
				throw new RtManagerException("msgType 不能为空!");
			}
			beginTime = System.nanoTime();
			Method m = null;
			try {
				m = casFacade.getClass().getMethod(msgType, String.class);
			} catch (Exception e) {
				result = 2;
				throw new RtManagerException("msgType: " + msgType + " 未约定!");
			}
			outXml = (String) m.invoke(casFacade, inXml);
			resultNode = WsUtil.getXmlContent(outXml,"result");
			if("0".equals(resultNode)){
				result = 0;
				resultMessage = WsUtil.getXmlContent(outXml,"message");
			}else if("1".equals(resultNode)){
				result = 1;
				resultMessage = WsUtil.getXmlContent(outXml,"message");
			}else{
				result = -1;
				resultMessage = WsUtil.getXmlContent(outXml,"message");
			}
		} catch (Exception e) {
			result = 2;
			outXml = WsUtil.getOutXmlByException(inXml, 1, "1", e);
		} finally {
			endTime = System.nanoTime();
			CasIntfLogRec intfLogRec = new CasIntfLogRec(true);
			CasIntfLogInfo intfLogInfo = new CasIntfLogInfo(true);
			intfLogInfo.setCasIntfLogRecId(intfLogRec.getCasIntfLogRecId());
			intfLogRec.setMethodName(msgType);
			intfLogRec.setMsgType(msgType);
			intfLogRec.setRequester(from);
			intfLogRec.setReqDate(reqTime);
			intfLogRec.setReqTranId(serial);
			intfLogRec.setConsumeTimestamp(endTime - beginTime);
			intfLogInfo.setReqMessage(inXml);
			Timestamp rspTime = new Timestamp(DateUtils.getNowDate().getTime());
			intfLogRec.setRspDate(rspTime);
			intfLogRec.setCreateDate(rspTime);
			intfLogInfo.setRspMessage(outXml);
			intfLogRec.setResult(result);
			intfLogRec.setResultMessage(resultMessage);
			intfLogRec.setResponser(to);
			intfLogRec.setClientMsg(WsUtil.getHostIp());
			intfLogRec.setRspTranId(preOrderNumber);
			try {
				casIntfLogRecService.indepSaveIntfLog(intfLogRec, intfLogInfo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return outXml;
	}
}
