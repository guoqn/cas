package com.ffcs.crmd.cas.intf.facade.impl;

import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.base.utils.BeanUtil;
import com.ffcs.crmd.cas.base.utils.TransUtil;
import com.ffcs.crmd.cas.bean.hbbean.comm.MsgHead;
import com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.InParam;
import com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.MsgBody;
import com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.Root;
import com.ffcs.crmd.cas.constants.IntfConstant;
import com.ffcs.crmd.cas.constants.OrderConstant;
import com.ffcs.crmd.cas.intf.api.dto.PreAnnounceChargeInDTO;
import com.ffcs.crmd.cas.intf.api.dto.PreAnnounceChargeOutDTO;
import com.ffcs.crmd.cas.intf.api.dto.PreFeeQueryInDTO;
import com.ffcs.crmd.cas.intf.api.facade.ICrmdToHbFacade;
import com.ffcs.crmd.cas.intf.facade.client.HbClient;
import com.ffcs.crmd.cas.intf.util.WsUtil;
import com.ffcs.crmd.cas.intf.util.crm.ToGb2312;
import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.exolab.castor.xml.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;

import java.io.ByteArrayInputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Date;

@Service("crmdToHbFacade")
public class CrmdToHbFacadeImpl implements ICrmdToHbFacade {
	@Autowired
	private HbClient client;
	@Override
	public RetVo preFeeQuery(PreFeeQueryInDTO inParam) {
		try {
			com.ffcs.crmd.cas.bean.hbbean.prefeequery.Root root = new com.ffcs.crmd.cas.bean.hbbean.prefeequery.Root();
			com.ffcs.crmd.cas.bean.hbbean.prefeequery.InParam _inParam = new com.ffcs.crmd.cas.bean.hbbean.prefeequery.InParam();
			if(inParam != null){
			    CrmBeanUtils.applyIf(_inParam, inParam);
			}
			com.ffcs.crmd.cas.bean.hbbean.comm.MsgHead _msgHead = getReqMsgHeadByMsgType("preFeeQuery");
			root.setMsgHead(_msgHead);
			com.ffcs.crmd.cas.bean.hbbean.prefeequery.MsgBody _msgBody = new com.ffcs.crmd.cas.bean.hbbean.prefeequery.MsgBody();
			_msgBody.setInParam(_inParam);
			root.setMsgBody(_msgBody);
			
			final Writer w = new java.io.StringWriter();
			org.exolab.castor.xml.Marshaller.marshal(root, w);
			final String inXml = ToGb2312.delNameSpace(w.toString());
			final String outXml = this.client.call("preFeeQuery", inXml);
			final RetVo retVo = new RetVo(true);
			
            final com.ffcs.crmd.cas.bean.hbbean.prefeequery.Root resRoot = (com.ffcs.crmd.cas.bean.hbbean.prefeequery.Root)BeanUtil.
					unmarshal(outXml,com.ffcs.crmd.cas.bean.hbbean.prefeequery.Root.class);
			com.ffcs.crmd.cas.bean.hbbean.prefeequery.OutParam output = resRoot.getMsgBody().getOutParam();
			retVo.setResult(true);
            if (IntfConstant.RESULT_FALSE.getValue().equals(output.getResult())) {
            	retVo.setResult(false);
            	retVo.setRetCode(output.getError().getId());
            	retVo.setMsgTitle(output.getError().getMessage());
            } else {
            	retVo.setObject(output);
            }
            return retVo;
		} catch (Exception e) {
			return WsUtil.getErrorMsg(e);
		}
	}


	@Override
	public RetVo announceCharge(PreAnnounceChargeInDTO inDto, Long reqType) {
		try {
			com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.InParam inParam = new com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.InParam();
			CrmBeanUtils.applyIf(inParam,inDto);
			inParam.setReqType(reqType);
			// 费用动作类型，撤销或正常
			final String msgType = IntfConstant.MSG_TYPE_PRE_ANNOUNCE_CHARGE.getValue();
			com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.Root reqRoot = new com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.Root();
			com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.MsgBody body = new com.ffcs.crmd.cas.bean.hbbean.preannouncecharge. MsgBody();
			reqRoot.setMsgBody(body);
			reqRoot.setMsgHead(getReqMsgHeadByMsgType(msgType));
			body.setInParam(inParam);
			final Writer w = new java.io.StringWriter();
			org.exolab.castor.xml.Marshaller.marshal(reqRoot, w);
			final String inXml = ToGb2312.delNameSpace(w.toString());
			final String outXml = this.client.call(msgType, inXml);
			final RetVo retVo = new RetVo();
			if (outXml == null) {
				retVo.setResult(false);
				retVo.setRetCode(IntfConstant.INTF_WS_CLOSED.getValue());
				retVo.setMsgTitle("账务处理通知接口关闭");
				return retVo;
			}
			final Reader r = new java.io.StringReader(outXml);
			final com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.Root respRoot = (com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.Root) BeanUtil.
					unmarshal(outXml,com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.Root.class);
			
			com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.OutParam outParam = respRoot.getMsgBody().getOutParam();
			retVo.setResult(true);
			if (IntfConstant.RESULT_FALSE.getValue().equals(outParam.getResult())) {
				retVo.setResult(false);
            	retVo.setRetCode(outParam.getError().getId());
            	retVo.setMsgTitle(outParam.getError().getMessage());
			} else {
				PreAnnounceChargeOutDTO outDTO = new PreAnnounceChargeOutDTO();
				CrmBeanUtils.applyIf(outDTO,respRoot.getMsgBody().getOutParam());
				retVo.setObject(outDTO);
			}
			return retVo;
		} catch (final Exception e) {
			return WsUtil.getErrorMsg(e);
		}
	}

	@Override
	public RetVo preFeeCancel(com.ffcs.crmd.cas.bean.hbbean.prefeecancel.InParam inParam) {
		try {
			com.ffcs.crmd.cas.bean.hbbean.prefeecancel.Root reqRoot = new com.ffcs.crmd.cas.bean.hbbean.prefeecancel.Root();
			com.ffcs.crmd.cas.bean.hbbean.comm.MsgHead msgHead = getReqMsgHeadByMsgType("preFeeCancel");
			reqRoot.setMsgHead(msgHead);
			com.ffcs.crmd.cas.bean.hbbean.prefeecancel.MsgBody msgBody = new com.ffcs.crmd.cas.bean.hbbean.prefeecancel.MsgBody();
			msgBody.setInParam(inParam);
			reqRoot.setMsgBody(msgBody);

			final Writer w = new java.io.StringWriter();
			org.exolab.castor.xml.Marshaller.marshal(reqRoot, w);
			final String inXml = ToGb2312.delNameSpace(w.toString());
			final String outXml = this.client.call("preFeeCancel", inXml);
			final RetVo retVo = new RetVo();

			if (StringUtils.isNullOrEmpty(outXml)) {
				retVo.setResult(false);
				retVo.setMsgTitle("计费预受理撤销退费接口关闭");
				return retVo;
			}

			final Reader r = new java.io.StringReader(outXml);
			final com.ffcs.crmd.cas.bean.hbbean.prefeecancel.Root respRoot = (com.ffcs.crmd.cas.bean.hbbean.prefeecancel.Root) BeanUtil.
					unmarshal(outXml, com.ffcs.crmd.cas.bean.hbbean.prefeecancel.Root.class);

			com.ffcs.crmd.cas.bean.hbbean.prefeecancel.OutParam output = respRoot.getMsgBody().getOutParam();
			retVo.setObject(output);
			if (IntfConstant.RESULT_TRUE.getValue().equals(output.getResult())) {
				retVo.setResult(true);
			} else {
				retVo.setResult(false);
				if (output.getError() != null) {
					retVo.setMsgTitle(StringUtils.strnull(output.getError().getMessage()));
				}
			}
			return retVo;
		} catch (Exception e) {
			return WsUtil.getErrorMsg(e);
		}
	}

	/**
	 * 报文头部拼装处理。
	 * @param msgType
	 * @return
     */
	public static MsgHead getReqMsgHeadByMsgType(String msgType) {
		final MsgHead head = new MsgHead();
		head.setFrom("CAS");
		head.setTo("HB");
		head.setSysSign("CAS");
		head.setSerial(TransUtil.getTransId());
		head.setMsgType(msgType);
		final String time = DateUtils.date2Str(new Date(), "yyyyMMddHHmmss");
		head.setTime(time);
		return head;
	}
}
