package com.ffcs.crmd.cas.intf.facade.impl;

import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.base.utils.TransUtil;
import com.ffcs.crmd.cas.bean.casbean.cancel.cancelordercommit.CustomerOrder;
import com.ffcs.crmd.cas.constants.IntfConstant;
import com.ffcs.crmd.cas.intf.api.dto.*;
import com.ffcs.crmd.cas.intf.api.facade.ICasToCrmFacade;
import com.ffcs.crmd.cas.intf.facade.client.BigDataClient;
import com.ffcs.crmd.cas.intf.facade.client.CrmClient;
import com.ffcs.crmd.cas.intf.util.WsUtil;
import com.ffcs.crmd.cas.intf.util.crm.ToGb2312;
import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.exolab.castor.xml.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;

import java.io.ByteArrayInputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * .
 *
 * @author Luxb
 * @version Revision 1.0.0
 * @版权：福富软件 版权所有 (c) 2011
 * @see: @创建日期：2016/2/16 @功能说明：
 */
@Service("casToCrmFacade")
public class CasToCrmFacadeImpl implements ICasToCrmFacade {
	@Autowired
	CrmClient crmClient;
	@Autowired
	BigDataClient bigDataClient;

	@Override
	public RetVo checkRelIntfDepOrder(CheckRelIntfDepOrderInDTO inParamDto) {
		try {

			String msgType = "checkRelIntfDepOrder";
			com.ffcs.crmd.cas.bean.crmbean.checkrelintfdeporder.Root reqRoot = new com.ffcs.crmd.cas.bean.crmbean.checkrelintfdeporder.Root();
			com.ffcs.crmd.cas.bean.crmbean.checkrelintfdeporder.MsgBody body = new com.ffcs.crmd.cas.bean.crmbean.checkrelintfdeporder.MsgBody();
			reqRoot.setMsgBody(body);
			reqRoot.setMsgHead(getReqMsgHeadByMsgType(msgType));
			com.ffcs.crmd.cas.bean.crmbean.checkrelintfdeporder.InParam inParam = new com.ffcs.crmd.cas.bean.crmbean.checkrelintfdeporder.InParam();
			CrmBeanUtils.applyIf(inParam, inParamDto);
			body.setInParam(inParam);
			final Writer w = new java.io.StringWriter();
			org.exolab.castor.xml.Marshaller.marshal(reqRoot, w);
			final String inXml = ToGb2312.delNameSpace(w.toString());
			final String outXml = this.crmClient.call(msgType, inXml);
			final RetVo retVo = new RetVo();
			if (outXml == null) {
				retVo.setResult(false);
				retVo.setRetCode(IntfConstant.INTF_WS_CLOSED.getValue());
				retVo.setMsgTitle("CRM服务接口关闭！");
				return retVo;
			}
			final Reader r = new java.io.StringReader(outXml);

			final com.ffcs.crmd.cas.bean.crmbean.checkrelintfdeporder.Root respRoot = (com.ffcs.crmd.cas.bean.crmbean.checkrelintfdeporder.Root) Unmarshaller
					.unmarshal(com.ffcs.crmd.cas.bean.crmbean.checkrelintfdeporder.Root.class,
							new InputSource(new ByteArrayInputStream(outXml.getBytes("utf-8"))));
			retVo.setResult(true);
			com.ffcs.crmd.cas.bean.crmbean.checkrelintfdeporder.OutParam outParam = respRoot.getMsgBody().getOutParam();
			if (IntfConstant.RESULT_FALSE.getValue().equals(outParam.getResult())) {
				retVo.setResult(false);
				retVo.setRetCode(outParam.getError().getId());
				retVo.setMsgTitle(outParam.getError().getMessage());
			} else {
				CheckRelIntfDepOrderOutDTO outDTO = new CheckRelIntfDepOrderOutDTO();
				CrmBeanUtils.applyIf(outDTO, respRoot.getMsgBody().getOutParam());
				retVo.setObject(outDTO);
			}
			return retVo;
		} catch (final Exception e) {
			return WsUtil.getErrorMsg(e);
		}
	}

	@Override
	public RetVo removeCustOrderMap(String preOrderNumber) {
		try {
			String msgType = "removeCustOrderMap";
			com.ffcs.crmd.cas.bean.crmbean.removecustordermap.Root reqRoot = new com.ffcs.crmd.cas.bean.crmbean.removecustordermap.Root();
			com.ffcs.crmd.cas.bean.crmbean.removecustordermap.MsgBody body = new com.ffcs.crmd.cas.bean.crmbean.removecustordermap.MsgBody();
			reqRoot.setMsgBody(body);
			reqRoot.setMsgHead(getReqMsgHeadByMsgType(msgType));
			com.ffcs.crmd.cas.bean.crmbean.removecustordermap.InParam inParam = new com.ffcs.crmd.cas.bean.crmbean.removecustordermap.InParam();
			inParam.setPreOrderNumber(preOrderNumber);
			body.setInParam(inParam);
			final Writer w = new java.io.StringWriter();
			org.exolab.castor.xml.Marshaller.marshal(reqRoot, w);
			final String inXml = ToGb2312.delNameSpace(w.toString());
			final String outXml = this.crmClient.call(msgType, inXml);
			final RetVo retVo = new RetVo();
			if (outXml == null) {
				retVo.setResult(false);
				retVo.setRetCode(IntfConstant.INTF_WS_CLOSED.getValue());
				retVo.setMsgTitle("CRM服务接口关闭！");
				return retVo;
			}
			final Reader r = new java.io.StringReader(outXml);

			final com.ffcs.crmd.cas.bean.crmbean.removecustordermap.Root respRoot = (com.ffcs.crmd.cas.bean.crmbean.removecustordermap.Root) Unmarshaller
					.unmarshal(com.ffcs.crmd.cas.bean.crmbean.removecustordermap.Root.class,
							new InputSource(new ByteArrayInputStream(outXml.getBytes("utf-8"))));
			com.ffcs.crmd.cas.bean.crmbean.removecustordermap.OutParam outParam = respRoot.getMsgBody().getOutParam();
			retVo.setResult(true);
			if (IntfConstant.RESULT_FALSE.getValue().equals(outParam.getResult())) {
				retVo.setResult(false);
				retVo.setRetCode(outParam.getError().getId());
				retVo.setMsgTitle(outParam.getError().getMessage());
				;
			}
			return retVo;
		} catch (final Exception e) {
			return WsUtil.getErrorMsg(e);
		}
	}

	@Override
	public RetVo checkPhotoNotReDeal(String custOrderId, String extCustOrderIds) {
		try {
			String msgType = "checkPhotoNotReDeal";
			com.ffcs.crmd.cas.bean.crmbean.checkphotonotredeal.Root reqRoot = new com.ffcs.crmd.cas.bean.crmbean.checkphotonotredeal.Root();
			com.ffcs.crmd.cas.bean.crmbean.checkphotonotredeal.MsgBody body = new com.ffcs.crmd.cas.bean.crmbean.checkphotonotredeal.MsgBody();
			reqRoot.setMsgBody(body);
			reqRoot.setMsgHead(getReqMsgHeadByMsgType(msgType));
			com.ffcs.crmd.cas.bean.crmbean.checkphotonotredeal.InParam inParam = new com.ffcs.crmd.cas.bean.crmbean.checkphotonotredeal.InParam();
			inParam.setCustOrderId(custOrderId);
			inParam.setExtCustOrderIds(extCustOrderIds);
			body.setInParam(inParam);
			final Writer w = new java.io.StringWriter();
			org.exolab.castor.xml.Marshaller.marshal(reqRoot, w);
			final String inXml = ToGb2312.delNameSpace(w.toString());
			final String outXml = this.crmClient.call(msgType, inXml);
			final RetVo retVo = new RetVo();
			if (outXml == null) {
				retVo.setResult(false);
				retVo.setRetCode(IntfConstant.INTF_WS_CLOSED.getValue());
				retVo.setMsgTitle("CRM服务接口关闭！");
				return retVo;
			}
			final Reader r = new java.io.StringReader(outXml);

			final com.ffcs.crmd.cas.bean.crmbean.checkphotonotredeal.Root respRoot = (com.ffcs.crmd.cas.bean.crmbean.checkphotonotredeal.Root) Unmarshaller
					.unmarshal(com.ffcs.crmd.cas.bean.crmbean.checkphotonotredeal.Root.class,
							new InputSource(new ByteArrayInputStream(outXml.getBytes("utf-8"))));
			com.ffcs.crmd.cas.bean.crmbean.checkphotonotredeal.OutParam outParam = respRoot.getMsgBody().getOutParam();
			retVo.setResult(true);
			if (IntfConstant.RESULT_FALSE.getValue().equals(outParam.getResult())) {
				retVo.setResult(false);
				retVo.setRetCode(outParam.getError().getId());
				retVo.setMsgTitle(outParam.getError().getMessage());
			} else {
				CheckPhotoNotReDealOutDTO outDTO = new CheckPhotoNotReDealOutDTO();
				CrmBeanUtils.applyIf(outDTO, respRoot.getMsgBody().getOutParam());
				retVo.setObject(outDTO);
			}
			return retVo;
		} catch (final Exception e) {
			return WsUtil.getErrorMsg(e);
		}
	}

	@Override
	public RetVo queryCustomerOrder(QueryCustOrderInDTO inParamDto) {
		try {
			String msgType = "queryCustOrder";
			com.ffcs.crmd.cas.bean.crmbean.querycustorder.Root reqRoot = new com.ffcs.crmd.cas.bean.crmbean.querycustorder.Root();
			com.ffcs.crmd.cas.bean.crmbean.querycustorder.MsgBody body = new com.ffcs.crmd.cas.bean.crmbean.querycustorder.MsgBody();
			reqRoot.setMsgBody(body);
			reqRoot.setMsgHead(getReqMsgHeadByMsgType(msgType));
			com.ffcs.crmd.cas.bean.crmbean.querycustorder.InParam inParam = new com.ffcs.crmd.cas.bean.crmbean.querycustorder.InParam();
			// 信息拷贝
			CrmBeanUtils.applyIf(inParam, inParamDto);

			body.setInParam(inParam);
			final Writer w = new java.io.StringWriter();
			org.exolab.castor.xml.Marshaller.marshal(reqRoot, w);
			final String inXml = ToGb2312.delNameSpace(w.toString());
			final String outXml = this.crmClient.call(msgType, inXml);
			final RetVo retVo = new RetVo();
			if (outXml == null) {
				retVo.setResult(false);
				retVo.setRetCode(IntfConstant.INTF_WS_CLOSED.getValue());
				retVo.setMsgTitle("CRM服务接口关闭！");
				return retVo;
			}
			final Reader r = new java.io.StringReader(outXml);

			final com.ffcs.crmd.cas.bean.crmbean.querycustorder.Root respRoot = (com.ffcs.crmd.cas.bean.crmbean.querycustorder.Root) Unmarshaller
					.unmarshal(com.ffcs.crmd.cas.bean.crmbean.querycustorder.Root.class,
							new InputSource(new ByteArrayInputStream(outXml.getBytes("utf-8"))));

			retVo.setResult(true);
			com.ffcs.crmd.cas.bean.crmbean.querycustorder.OutParam outParam = respRoot.getMsgBody().getOutParam();
			if (IntfConstant.RESULT_FALSE.getValue().equals(outParam.getResult())) {
				retVo.setResult(false);
				retVo.setRetCode(outParam.getError().getId());
				retVo.setMsgTitle(outParam.getError().getMessage());
			} else {
				QueryCustOrderOutDTO outDTO = new QueryCustOrderOutDTO();
				CrmBeanUtils.applyIf(outDTO, respRoot.getMsgBody().getOutParam());
				retVo.setObject(outDTO);
			}
			return retVo;
		} catch (final Exception e) {
			return WsUtil.getErrorMsg(e);
		}
	}

	@Override
	public RetVo autoRelCustOrder(String preOrderNumber, Long extCustOrderId, List<ISaleAcctItemInDTO> dtos) {
		try {
			String msgType = "autoRelCustOrder";
			com.ffcs.crmd.cas.bean.crmbean.autorelcustorder.Root reqRoot = new com.ffcs.crmd.cas.bean.crmbean.autorelcustorder.Root();
			com.ffcs.crmd.cas.bean.crmbean.autorelcustorder.MsgBody body = new com.ffcs.crmd.cas.bean.crmbean.autorelcustorder.MsgBody();
			reqRoot.setMsgBody(body);
			reqRoot.setMsgHead(getReqMsgHeadByMsgType(msgType));
			com.ffcs.crmd.cas.bean.crmbean.autorelcustorder.InParam inParam = new com.ffcs.crmd.cas.bean.crmbean.autorelcustorder.InParam();
			// 信息拷贝
			inParam.setCustOrderId(StringUtils.strnull(extCustOrderId));
			inParam.setPreOrderNumber(preOrderNumber);
			if (dtos != null && dtos.size() > 0) {
				for (ISaleAcctItemInDTO dto : dtos) {
					com.ffcs.crmd.cas.bean.crmbean.autorelcustorder.IsSaleAcctItem item = new com.ffcs.crmd.cas.bean.crmbean.autorelcustorder.IsSaleAcctItem();
					item.setSaleSerial(dto.getSaleSerial());
					item.setExtAcctItemId(dto.getExtAcctItemId() + "");
					item.setRealAmount(dto.getRealAmount());
					inParam.addIsSaleAcctItem(item);
				}
			}

			body.setInParam(inParam);
			final Writer w = new java.io.StringWriter();
			org.exolab.castor.xml.Marshaller.marshal(reqRoot, w);
			final String inXml = ToGb2312.delNameSpace(w.toString());
			final String outXml = this.crmClient.call(msgType, inXml);
			final RetVo retVo = new RetVo();
			if (outXml == null) {
				retVo.setResult(false);
				retVo.setRetCode(IntfConstant.INTF_WS_CLOSED.getValue());
				retVo.setMsgTitle("CRM服务接口关闭！");
				return retVo;
			}
			final Reader r = new java.io.StringReader(outXml);

			final com.ffcs.crmd.cas.bean.crmbean.autorelcustorder.Root respRoot = (com.ffcs.crmd.cas.bean.crmbean.autorelcustorder.Root) Unmarshaller
					.unmarshal(com.ffcs.crmd.cas.bean.crmbean.autorelcustorder.Root.class,
							new InputSource(new ByteArrayInputStream(outXml.getBytes("utf-8"))));

			retVo.setResult(true);
			com.ffcs.crmd.cas.bean.crmbean.autorelcustorder.OutParam outParam = respRoot.getMsgBody().getOutParam();
			if (IntfConstant.RESULT_FALSE.getValue().equals(outParam.getResult())) {
				retVo.setResult(false);
				retVo.setRetCode(outParam.getError().getId());
				retVo.setMsgTitle(outParam.getError().getMessage());
			}
			return retVo;
		} catch (final Exception e) {
			return WsUtil.getErrorMsg(e);
		}
	}

	@Override
	public RetVo checkCancel(String custOrderId, Long orgId, Long staffPositionId, CustomerOrder[] inDTOList) {
		try {
			String msgType = "checkCancel";
			com.ffcs.crmd.cas.bean.crmbean.checkcancel.Root reqRoot = new com.ffcs.crmd.cas.bean.crmbean.checkcancel.Root();
			com.ffcs.crmd.cas.bean.crmbean.checkcancel.MsgBody body = new com.ffcs.crmd.cas.bean.crmbean.checkcancel.MsgBody();
			reqRoot.setMsgBody(body);
			reqRoot.setMsgHead(getReqMsgHeadByMsgType(msgType));
			com.ffcs.crmd.cas.bean.crmbean.checkcancel.InParam inParam = new com.ffcs.crmd.cas.bean.crmbean.checkcancel.InParam();
			// 信息拷贝
			inParam.setCustOrderId(custOrderId);
			inParam.setStaffPositionId(staffPositionId);
			inParam.setTeamId(orgId);
			if (inDTOList != null && inDTOList.length > 0) {
				for (CustomerOrder dto : inDTOList) {
					com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustomerOrder custOrder = new com.ffcs.crmd.cas.bean.crmbean.checkcancel.CustomerOrder();
					com.ffcs.crmd.cas.bean.crmbean.checkcancel.CancelInfo info = new com.ffcs.crmd.cas.bean.crmbean.checkcancel.CancelInfo();
					// edit by laiyongmin
					CrmBeanUtils.applyIf(info, dto.getCancelInfo());
					CrmBeanUtils.applyIf(custOrder, dto);
					custOrder.setCancelInfo(info);
					inParam.addCustomerOrder(custOrder);
				}
			}

			body.setInParam(inParam);
			final Writer w = new java.io.StringWriter();
			org.exolab.castor.xml.Marshaller.marshal(reqRoot, w);
			final String inXml = ToGb2312.delNameSpace(w.toString());
			final String outXml = this.crmClient.call(msgType, inXml);
			final RetVo retVo = new RetVo();
			if (outXml == null) {
				retVo.setResult(false);
				retVo.setRetCode(IntfConstant.INTF_WS_CLOSED.getValue());
				retVo.setMsgTitle("CRM服务接口关闭！");
				return retVo;
			}
			final Reader r = new java.io.StringReader(outXml);

			final com.ffcs.crmd.cas.bean.crmbean.checkcancel.Root respRoot = (com.ffcs.crmd.cas.bean.crmbean.checkcancel.Root) Unmarshaller
					.unmarshal(com.ffcs.crmd.cas.bean.crmbean.checkcancel.Root.class,
							new InputSource(new ByteArrayInputStream(outXml.getBytes("utf-8"))));

			retVo.setResult(true);
			com.ffcs.crmd.cas.bean.crmbean.checkcancel.OutParam outParam = respRoot.getMsgBody().getOutParam();
			if (IntfConstant.RESULT_FALSE.getValue().equals(outParam.getResult())) {
				retVo.setResult(false);
				retVo.setRetCode(outParam.getError().getId());
				retVo.setMsgTitle(outParam.getError().getMessage());
			} else {
				retVo.setRetCode(outParam.getIsCancel());
				retVo.setObject(outParam);
			}
			return retVo;
		} catch (final Exception e) {
			return WsUtil.getErrorMsg(e);
		}
	}

	@Override
	public RetVo convertToModOrder(Long extCustOrderId) {
		try {
			String msgType = "convertToModOrder";
			com.ffcs.crmd.cas.bean.crmbean.converttomodorder.Root reqRoot = new com.ffcs.crmd.cas.bean.crmbean.converttomodorder.Root();
			com.ffcs.crmd.cas.bean.crmbean.converttomodorder.MsgBody body = new com.ffcs.crmd.cas.bean.crmbean.converttomodorder.MsgBody();
			reqRoot.setMsgBody(body);
			reqRoot.setMsgHead(getReqMsgHeadByMsgType(msgType));
			com.ffcs.crmd.cas.bean.crmbean.converttomodorder.InParam inParam = new com.ffcs.crmd.cas.bean.crmbean.converttomodorder.InParam();
			// 信息拷贝
			inParam.setCustOrderId(StringUtils.strnull(extCustOrderId));
			body.setInParam(inParam);
			final Writer w = new java.io.StringWriter();
			org.exolab.castor.xml.Marshaller.marshal(reqRoot, w);
			final String inXml = ToGb2312.delNameSpace(w.toString());
			final String outXml = this.crmClient.call(msgType, inXml);
			final RetVo retVo = new RetVo();
			if (outXml == null) {
				retVo.setResult(false);
				retVo.setRetCode(IntfConstant.INTF_WS_CLOSED.getValue());
				retVo.setMsgTitle("CRM服务接口关闭！");
				return retVo;
			}
			final Reader r = new java.io.StringReader(outXml);

			final com.ffcs.crmd.cas.bean.crmbean.converttomodorder.Root respRoot = (com.ffcs.crmd.cas.bean.crmbean.converttomodorder.Root) Unmarshaller
					.unmarshal(com.ffcs.crmd.cas.bean.crmbean.converttomodorder.Root.class,
							new InputSource(new ByteArrayInputStream(outXml.getBytes("utf-8"))));

			retVo.setResult(true);
			com.ffcs.crmd.cas.bean.crmbean.converttomodorder.OutParam outParam = respRoot.getMsgBody().getOutParam();
			if (IntfConstant.RESULT_FALSE.getValue().equals(outParam.getResult())) {
				retVo.setResult(false);
				retVo.setRetCode(outParam.getError().getId());
				retVo.setMsgTitle(outParam.getError().getMessage());
			}
			return retVo;
		} catch (final Exception e) {
			return WsUtil.getErrorMsg(e);
		}
	}

	@Override
	public RetVo continueAcceptConfirm(Long extCustOrderId) {
		try {
			String msgType = "continueAcceptConfirm";
			com.ffcs.crmd.cas.bean.crmbean.continueacceptconfirm.Root reqRoot = new com.ffcs.crmd.cas.bean.crmbean.continueacceptconfirm.Root();
			com.ffcs.crmd.cas.bean.crmbean.continueacceptconfirm.MsgBody body = new com.ffcs.crmd.cas.bean.crmbean.continueacceptconfirm.MsgBody();
			reqRoot.setMsgBody(body);
			reqRoot.setMsgHead(getReqMsgHeadByMsgType(msgType));
			com.ffcs.crmd.cas.bean.crmbean.continueacceptconfirm.InParam inParam = new com.ffcs.crmd.cas.bean.crmbean.continueacceptconfirm.InParam();
			// 信息拷贝
			inParam.setExtCustOrderId(StringUtils.strnull(extCustOrderId));
			body.setInParam(inParam);
			final Writer w = new java.io.StringWriter();
			org.exolab.castor.xml.Marshaller.marshal(reqRoot, w);
			final String inXml = ToGb2312.delNameSpace(w.toString());
			final String outXml = this.crmClient.call(msgType, inXml);
			final RetVo retVo = new RetVo();
			if (outXml == null) {
				retVo.setResult(false);
				retVo.setRetCode(IntfConstant.INTF_WS_CLOSED.getValue());
				retVo.setMsgTitle("CRM服务接口关闭！");
				return retVo;
			}
			final Reader r = new java.io.StringReader(outXml);

			final com.ffcs.crmd.cas.bean.crmbean.continueacceptconfirm.Root respRoot = (com.ffcs.crmd.cas.bean.crmbean.continueacceptconfirm.Root) Unmarshaller
					.unmarshal(com.ffcs.crmd.cas.bean.crmbean.continueacceptconfirm.Root.class,
							new InputSource(new ByteArrayInputStream(outXml.getBytes("utf-8"))));

			retVo.setResult(true);
			com.ffcs.crmd.cas.bean.crmbean.continueacceptconfirm.OutParam outParam = respRoot.getMsgBody()
					.getOutParam();
			if (IntfConstant.RESULT_FALSE.getValue().equals(outParam.getResult())) {
				retVo.setResult(false);
				retVo.setRetCode(outParam.getError().getId());
				retVo.setMsgTitle(outParam.getError().getMessage());
			} else {
				retVo.setObject(outParam.getUrl());
			}
			return retVo;
		} catch (final Exception e) {
			return WsUtil.getErrorMsg(e);
		}
	}

	@Override
	public RetVo noticeToDealOrder(Long extCustOrderId, String ifEnd) {
		try {
			String msgType = "noticeToDealOrder";
			com.ffcs.crmd.cas.bean.crmbean.noticetodealorder.Root reqRoot = new com.ffcs.crmd.cas.bean.crmbean.noticetodealorder.Root();
			com.ffcs.crmd.cas.bean.crmbean.noticetodealorder.MsgBody body = new com.ffcs.crmd.cas.bean.crmbean.noticetodealorder.MsgBody();
			reqRoot.setMsgBody(body);
			reqRoot.setMsgHead(getReqMsgHeadByMsgType(msgType));
			com.ffcs.crmd.cas.bean.crmbean.noticetodealorder.InParam inParam = new com.ffcs.crmd.cas.bean.crmbean.noticetodealorder.InParam();
			// 信息拷贝
			inParam.setExtCustOrderId(extCustOrderId);
			if (!StringUtils.isNullOrEmpty(ifEnd)) {
				inParam.setIfEnd(ifEnd);
			}
			body.setInParam(inParam);
			final Writer w = new java.io.StringWriter();
			org.exolab.castor.xml.Marshaller.marshal(reqRoot, w);
			final String inXml = ToGb2312.delNameSpace(w.toString());
			final String outXml = this.crmClient.call(msgType, inXml);
			final RetVo retVo = new RetVo();
			if (outXml == null) {
				retVo.setResult(false);
				retVo.setRetCode(IntfConstant.INTF_WS_CLOSED.getValue());
				retVo.setMsgTitle("CRM服务接口关闭！");
				return retVo;
			}
			final Reader r = new java.io.StringReader(outXml);

			final com.ffcs.crmd.cas.bean.crmbean.noticetodealorder.Root respRoot = (com.ffcs.crmd.cas.bean.crmbean.noticetodealorder.Root) Unmarshaller
					.unmarshal(com.ffcs.crmd.cas.bean.crmbean.noticetodealorder.Root.class,
							new InputSource(new ByteArrayInputStream(outXml.getBytes("utf-8"))));

			retVo.setResult(true);
			com.ffcs.crmd.cas.bean.crmbean.noticetodealorder.OutParam outParam = respRoot.getMsgBody().getOutParam();
			if (IntfConstant.RESULT_FALSE.getValue().equals(outParam.getResult())) {
				retVo.setResult(false);
				retVo.setRetCode(outParam.getError().getId());
				retVo.setMsgTitle(outParam.getError().getMessage());
				retVo.setObject(outParam.getIsAccept());
			} else {
				retVo.setObject(outParam.getIsAccept());
			}
			return retVo;
		} catch (final Exception e) {
			return WsUtil.getErrorMsg(e);
		}
	}

	/**
	 * 报文头部拼装处理。
	 *
	 * @param msgType
	 * @return
	 */
	public com.ffcs.crmd.cas.bean.crmbean.comm.MsgHead getReqMsgHeadByMsgType(String msgType) {
		final com.ffcs.crmd.cas.bean.crmbean.comm.MsgHead head = new com.ffcs.crmd.cas.bean.crmbean.comm.MsgHead();
		head.setFrom("CAS");
		head.setTo("CRM");
		head.setSysSign("");
		head.setSerial(TransUtil.getTransId());
		head.setMsgType(msgType);
		final String time = DateUtils.date2Str(new Date(), "yyyyMMddHHmmss");
		head.setTime(time);
		return head;
	}

	@Override
	public RetVo qryCustInfo(String[] custId, String type) {
		RetVo retVo = new RetVo(true);
		try {
			String msgType = "queryParty";
			com.ffcs.crmd.cas.bean.crmbean.queryParty.Root reqRoot = new com.ffcs.crmd.cas.bean.crmbean.queryParty.Root();
			com.ffcs.crmd.cas.bean.crmbean.queryParty.MsgBody msgBody = new com.ffcs.crmd.cas.bean.crmbean.queryParty.MsgBody();
			reqRoot.setMsgHead(getReqMsgHeadByMsgType(msgType));
			com.ffcs.crmd.cas.bean.crmbean.queryParty.InParam inParam = new com.ffcs.crmd.cas.bean.crmbean.queryParty.InParam();
			if (StringUtils.isNullOrEmpty(custId)) {
				retVo.setResult(false);
				return retVo;
			}
			for (int i = 0; i < custId.length; i++) {
				inParam.addObjId(custId[i]);
				inParam.setType(type);
			}
			msgBody.setInParam(inParam);
			reqRoot.setMsgBody(msgBody);
			final Writer w = new java.io.StringWriter();
			org.exolab.castor.xml.Marshaller.marshal(reqRoot, w);
			final String inXml = ToGb2312.delNameSpace(w.toString());
			final String outXml = this.crmClient.call(msgType, inXml);
			if (StringUtils.isNullOrEmpty(outXml)) {
				retVo.setResult(false);
				retVo.setRetCode(IntfConstant.INTF_WS_CLOSED.getValue());
				retVo.setMsgTitle("CRM服务接口关闭！");
				return retVo;
			}
			final Reader r = new java.io.StringReader(outXml);

			final com.ffcs.crmd.cas.bean.crmbean.queryParty.Root respRoot = (com.ffcs.crmd.cas.bean.crmbean.queryParty.Root) Unmarshaller
					.unmarshal(com.ffcs.crmd.cas.bean.crmbean.queryParty.Root.class,
							new InputSource(new ByteArrayInputStream(outXml.getBytes("utf-8"))));
			com.ffcs.crmd.cas.bean.crmbean.queryParty.OutParam outParam = respRoot.getMsgBody().getOutParam();
			if (IntfConstant.RESULT_FALSE.getValue().equals(outParam.getResult())) {
				retVo.setResult(false);
				retVo.setRetCode(outParam.getError().getId());
				retVo.setMsgTitle(outParam.getError().getMessage());
			} else {
				retVo.setObject(outParam.getPartyContactInfo());
			}
			return retVo;
		} catch (final Exception e) {
			return WsUtil.getErrorMsg(e);
		}
	}

	@Override
	public RetVo dealConnect(List<Map<String,String>> infos) {
		RetVo retVo = new RetVo(true);
		try {
			String msgType = "dealConnect";
			com.ffcs.crmd.cas.bean.crmbean.createconnect.Root reqRoot = new com.ffcs.crmd.cas.bean.crmbean.createconnect.Root();
			com.ffcs.crmd.cas.bean.crmbean.createconnect.MsgBody msgBody = new com.ffcs.crmd.cas.bean.crmbean.createconnect.MsgBody();
			reqRoot.setMsgHead(getReqMsgHeadByMsgType(msgType));
			com.ffcs.crmd.cas.bean.crmbean.createconnect.InParam inParam = new com.ffcs.crmd.cas.bean.crmbean.createconnect.InParam();
			if (infos != null && infos.size() >0) {
				for (Map<String, String> map : infos) {
					com.ffcs.crmd.cas.bean.crmbean.createconnect.ConnectInfo connectInfo = new com.ffcs.crmd.cas.bean.crmbean.createconnect.ConnectInfo();
					connectInfo.setCustSoNumber(map.get("custSoNumber"));
					connectInfo.setPreOrderNumber(map.get("preOrderNumber"));
					connectInfo.setIsRel(map.get("isRel"));
					inParam.addConnectInfo(connectInfo);
				}
			}

			msgBody.setInParam(inParam);
			reqRoot.setMsgBody(msgBody);
			final Writer w = new java.io.StringWriter();
			org.exolab.castor.xml.Marshaller.marshal(reqRoot, w);
			final String inXml = ToGb2312.delNameSpace(w.toString());
			final String outXml = this.crmClient.call(msgType, inXml);
			if (StringUtils.isNullOrEmpty(outXml)) {
				retVo.setResult(false);
				retVo.setRetCode(IntfConstant.INTF_WS_CLOSED.getValue());
				retVo.setMsgTitle("CRM服务接口关闭！");
				return retVo;
			}
			final Reader r = new java.io.StringReader(outXml);

			final com.ffcs.crmd.cas.bean.crmbean.createconnect.Root respRoot = (com.ffcs.crmd.cas.bean.crmbean.createconnect.Root) Unmarshaller
					.unmarshal(com.ffcs.crmd.cas.bean.crmbean.createconnect.Root.class,
							new InputSource(new ByteArrayInputStream(outXml.getBytes("utf-8"))));
			com.ffcs.crmd.cas.bean.crmbean.createconnect.OutParam outParam = respRoot.getMsgBody().getOutParam();
			if (IntfConstant.RESULT_FALSE.getValue().equals(outParam.getResult())) {
				retVo.setResult(false);
				retVo.setRetCode(outParam.getError().getId());
				retVo.setMsgTitle(outParam.getError().getMessage());
			} else {
				if (outParam.getCustOrderCount() > 0) {
					retVo.setObject(outParam.getCustOrder());
				}
			}
			return retVo;
		} catch (final Exception e) {
			return WsUtil.getErrorMsg(e);
		}
	}

	@Override
	public RetVo saveDocInfo(SaveDocInfoInDTO inDto) {
		try {

			String msgType = "saveDocInfo";
			com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.Root reqRoot = new com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.Root();
			com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.MsgBody body = new com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.MsgBody();
			reqRoot.setMsgBody(body);
			reqRoot.setMsgHead(this.getReqMsgHeadByMsgTypeForSaveDoc(msgType));
			com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.InParam inParam = new com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.InParam();
			CrmBeanUtils.applyIf(inParam, inDto);
			body.setInParam(inParam);
			final Writer w = new java.io.StringWriter();
			org.exolab.castor.xml.Marshaller.marshal(reqRoot, w);
			final String inXml = ToGb2312.delNameSpace(w.toString());
			final String outXml = this.bigDataClient.call(msgType, inXml);
			final RetVo retVo = new RetVo();
			if (outXml == null) {
				retVo.setResult(false);
				retVo.setRetCode(IntfConstant.INTF_WS_CLOSED.getValue());
				retVo.setMsgTitle("CRM服务接口关闭！");
				return retVo;
			}
			final Reader r = new java.io.StringReader(outXml);

			final com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.Root respRoot = (com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.Root) Unmarshaller
					.unmarshal(com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.Root.class,
							new InputSource(new ByteArrayInputStream(outXml.getBytes("utf-8"))));
			retVo.setResult(true);
			com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.OutParam outParam = respRoot.getMsgBody().getOutParam();
			if (IntfConstant.RESULT_FALSE.getValue().equals(outParam.getResult())) {
				retVo.setResult(false);
				retVo.setRetCode(outParam.getError().getId());
				retVo.setMsgTitle(outParam.getError().getMessage());
			} else {
				retVo.setObject(outParam);
			}
			return retVo;
		} catch (final Exception e) {
			return WsUtil.getErrorMsg(e);
		}
	}

	@Override
	public RetVo queryCustOrderByNum(List<String> custSoNums) {
		try {

			String msgType = "queryCustOrderByNum";
			com.ffcs.crmd.cas.bean.crmbean.querycustorderbynum.Root reqRoot = new com.ffcs.crmd.cas.bean.crmbean.querycustorderbynum.Root();
			com.ffcs.crmd.cas.bean.crmbean.querycustorderbynum.MsgBody body = new com.ffcs.crmd.cas.bean.crmbean.querycustorderbynum.MsgBody();
			reqRoot.setMsgBody(body);
			reqRoot.setMsgHead(getReqMsgHeadByMsgType(msgType));
			com.ffcs.crmd.cas.bean.crmbean.querycustorderbynum.InParam inParam = new com.ffcs.crmd.cas.bean.crmbean.querycustorderbynum.InParam();
			if (custSoNums != null && custSoNums.size() >0) {
				for (String str : custSoNums) {
					com.ffcs.crmd.cas.bean.crmbean.querycustorderbynum.ConnectInfo connectInfo = new com.ffcs.crmd.cas.bean.crmbean.querycustorderbynum.ConnectInfo();
					connectInfo.setCustSoNumber(str);
					inParam.addConnectInfo(connectInfo);
				}
			}
			body.setInParam(inParam);
			final Writer w = new java.io.StringWriter();
			org.exolab.castor.xml.Marshaller.marshal(reqRoot, w);
			final String inXml = ToGb2312.delNameSpace(w.toString());
			final String outXml = this.crmClient.call(msgType, inXml);
			final RetVo retVo = new RetVo();
			if (outXml == null) {
				retVo.setResult(false);
				retVo.setRetCode(IntfConstant.INTF_WS_CLOSED.getValue());
				retVo.setMsgTitle("CRM服务接口关闭！");
				return retVo;
			}
			final Reader r = new java.io.StringReader(outXml);

			final com.ffcs.crmd.cas.bean.crmbean.querycustorderbynum.Root respRoot = (com.ffcs.crmd.cas.bean.crmbean.querycustorderbynum.Root) Unmarshaller
					.unmarshal(com.ffcs.crmd.cas.bean.crmbean.querycustorderbynum.Root.class,
							new InputSource(new ByteArrayInputStream(outXml.getBytes("utf-8"))));
			retVo.setResult(true);
			com.ffcs.crmd.cas.bean.crmbean.querycustorderbynum.OutParam outParam = respRoot.getMsgBody().getOutParam();
			if (IntfConstant.RESULT_FALSE.getValue().equals(outParam.getResult())) {
				retVo.setResult(false);
				retVo.setRetCode(outParam.getError().getId());
				retVo.setMsgTitle(outParam.getError().getMessage());
			} else {
				retVo.setObject(outParam.getCustOrder());
			}
			return retVo;
		} catch (final Exception e) {
			return WsUtil.getErrorMsg(e);
		}
	}

	/**
	 * 报文头部拼装处理。
	 *
	 * @param msgType
	 * @return
	 */
	public com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.MsgHead getReqMsgHeadByMsgTypeForSaveDoc(String msgType) {
		final com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.MsgHead head = new com.ffcs.crmd.cas.bean.crmbean.saveDocInfo.MsgHead();
		head.setFrom("CAS");
		head.setTo("CRM");
		head.setSysSign("");
		head.setSerial(TransUtil.getTransId());
		head.setMsgType(msgType);
		final String time = DateUtils.date2Str(new Date(), "yyyyMMddHHmmss");
		head.setTime(time);
		return head;
	}
}
