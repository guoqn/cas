package com.ffcs.crmd.cas.order.service.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.CollectionUtils;
import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.pub.context.SessionContext;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.cas.base.context.CasSessionContext;
import com.ffcs.crmd.cas.base.utils.CodeBuildUtils;
import com.ffcs.crmd.cas.base.utils.CrmClassUtils;
import com.ffcs.crmd.cas.bean.casbean.presaleordercommit.CompleteOrderInfo;
import com.ffcs.crmd.cas.bean.casbean.presaleordercommit.PreSaleOrderInfo;
import com.ffcs.crmd.cas.bean.hbbean.preannouncecharge.FeeItem;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.cas.constants.IntfConstant;
import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.intf.api.dto.PreAnnounceChargeInDTO;
import com.ffcs.crmd.cas.intf.api.dto.PreAnnounceChargeOutDTO;
import com.ffcs.crmd.cas.intf.api.facade.ICrmdToHbFacade;
import com.ffcs.crmd.cas.order.api.dto.IntfPreOrderDTO;
import com.ffcs.crmd.cas.order.api.vo.PreSaleOrderVo;
import com.ffcs.crmd.cas.order.entity.*;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderRepository;
import com.ffcs.crmd.cas.order.service.*;
import com.ffcs.crmd.cas.order.vo.OrderOverTimeStatVo;
import com.ffcs.crmd.cas.order.vo.PreSaleOrderCountVo;
import com.ffcs.crmd.cas.order.vo.PreSaleOrderProcVo;
import com.ffcs.crmd.cas.sys.api.dto.StaffDTO;
import com.ffcs.crmd.cas.sys.api.facade.ICasSysFacade;
import com.ffcs.crmd.cas.sys.entity.Staff;
import com.ffcs.crmd.cas.sys.entity.StaffPosition;
import com.ffcs.crmd.platform.data.utils.CrmEntityUtils;
import com.ffcs.crmd.platform.meta.entity.AttrSpec;
import com.ffcs.crmd.platform.meta.entity.AttrValue;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service("preSaleOrderService")
public class PreSaleOrderServiceImpl extends AbsCrmdGenericServiceImpl<PreSaleOrder, Long>
		implements IPreSaleOrderService {

	@Autowired
	IPreSaleOrderRepository preSaleOrderRepository;
	@Autowired
	private IPreSaleOrderProcService procService;
	@Autowired
	private IPreSaleAcctItemService itemService;
	@Autowired
	private IPreSaleOrderPoolService orderPoolService;
	@Autowired
	private IAutoGenOrderService autoGenOrderService;
	@Autowired
	private IIsaleAcctItemService isaleAcctItemService;
	@Autowired
	private IPreSaleOrderItemService preSaleOrderItemService;
	@Autowired
	private ICrmdToHbFacade crmdToHbFacade;
	@Autowired
	private IPreSaleAcctItemService preSaleAcctItemService;
	@Autowired
	private IPreSaleOrderAttrService preSaleOrderAttrService;
	@Autowired
	private IPreSaleOrderPoolService     preSaleOrderPoolService;
	@Autowired
	private IIntfPreOrderService         intfPreOrderService;
	@Autowired
	private IIntfPreOrderAttachService   intfPreOrderAttachService;
	
	@Override
	public PageInfo queryPreSaleOrder(PreSaleOrderVo preSaleOrderVo) {
		return preSaleOrderRepository.queryPreSaleOrder(preSaleOrderVo);
	}

	@Override
	public List<PreSaleOrder> queryPreSaleOrderList(Map param) {
		return preSaleOrderRepository.queryPreSaleOrderList(param);
	}

	@Override
	public void submitReFee(Long preOrderId, List<AttrValue> attrValues,Long staffId) {
		// 1.生成预销售单账目项
		PreSaleAcctItem preSaleAcctItem = new PreSaleAcctItem(true);
		preSaleAcctItem.setPreOrderId(preOrderId);
		preSaleAcctItem.setShardingId(preOrderId);
		preSaleAcctItem.setStatusCd(CasConstant.PRE_SALE_ACCT_ITEM_STATUS_NO_PAY.getValue()); // 设置状态：未销帐
		preSaleAcctItem.setAcctItemType(CasConstant.PRE_SALE_ACCT_ITEM_TYPE_RE_FEE.getValue()); // 设置类型：补收款
		// 账目项编码
		AttrSpec attrSpec = CrmClassUtils.getAttrSpecByCode(CasConstant.PRE_SALE_ACCT_ITEM.getValue(),
				CasConstant.ACCT_SO_NUMBER.getValue());
		preSaleAcctItem.setAcctSoNumber(CodeBuildUtils.buildPreOrderAcctCode(attrSpec));
		preSaleAcctItem.save();
		// 2.生成预销售单项目项属性
		if (attrValues != null && attrValues.size() > 0) {
			for (AttrValue attrValue : attrValues) {
				PreSaleAcctItemAttr acctItemAttr = new PreSaleAcctItemAttr(true);
				acctItemAttr.setShardingId(preOrderId); // 分片键
				acctItemAttr.setPreAcctItemId(preSaleAcctItem.getPreAcctItemId()); // 账目项ID
				acctItemAttr.setAttrId(attrValue.getAttrId()); // 属性ID
				acctItemAttr.setAttrValue(""+NumberUtils.multiply(NumberUtils.toDouble(attrValue.getAttrValue()),100)); // 属性值
				acctItemAttr.save();
			}
		}
		// 3.新增预销售单处理过程
		PreSaleOrder preSaleOrder = this.getByIdAndShardingId(preOrderId, preOrderId);
		PreSaleOrderProc preSaleOrderProc = new PreSaleOrderProc(true);
		preSaleOrderProc.setPreOrderId(preOrderId);
		preSaleOrderProc.setShardingId(preOrderId);
		preSaleOrderProc.setStatusCd(preSaleOrder.getStatusCd()); // 设置预销售单当前的状态
		preSaleOrderProc.setAcceptTime(new Timestamp(new Date().getTime())); // 受理时间
		preSaleOrderProc.setRemark(CasConstant.REMARK_WAIT_FOR_PAY.getValue()); // 备注：补收款
		// 设置员工
		preSaleOrderProc.setStaffId(staffId);
		// 现网代码：com/ffcs/crm2/order/manager/impl/PreSaleOrderManagerImpl.java:259
		preSaleOrderProc.save();
		// 4.修改预销售单状态
		preSaleOrder.setStatusCd(CasConstant.PRE_SALE_ORDER_STATUS_CD_WAIT_FOR_PAY.getValue()); // 状态：待收费
		preSaleOrder.update();
	}

	/**
	 * 删除预受理单及相关表
	 * 
	 * @author YULIYAO 2016/1/20 return
	 */
	@Override
	public int remove(PreSaleOrder preSaleOrder) {
		// 第一张单处理内容
		if ("1".equals(preSaleOrder.getSeq() + "")) {
			// 移除P订单属性
			preSaleOrderAttrService.removeByOrderId(preSaleOrder.getPreOrderId());
			// 移除预受理处理过程
			procService.removeByOrderId(preSaleOrder.getPreOrderId());
			// 移除费用项
			itemService.removeByOrderId(preSaleOrder.getPreOrderId());
			// 移工单池记录
			this.completeOrderPool(preSaleOrder);
			// 移除P订单号关联的所有P订单记录
			this.removePreSaleOrdersByPreOrderNbr(preSaleOrder);
			// 移除普坤自动受理表
			autoGenOrderService.removeAutoGenOrder(preSaleOrder.getPreOrderNumber());
			// 移除集团销售费用
			isaleAcctItemService.removeBySerail(preSaleOrder.getPreOrderNumber());
		}
		// 移除预受理订单项
		preSaleOrderItemService.removeItemByOrderId(preSaleOrder.getPreOrderId(), preSaleOrder.getShardingId());
		return super.remove(preSaleOrder);
	}

	private int removePreSaleOrdersByPreOrderNbr(PreSaleOrder paramOrder) {
		int results = 0;
		Map param = new HashMap();
		param.put("preOrderNumber", paramOrder.getPreOrderNumber());
		List<PreSaleOrder> preSaleOrders = this.queryPreSaleOrderList(param);
		if (CollectionUtils.isNotEmpty(preSaleOrders)) {
			for (PreSaleOrder preSaleOrder : preSaleOrders) {
				if (!"1".equals(preSaleOrder.getSeq()+"")) { // 移除除了第一张P单之外的P单
					// 状态统一设置为第一张P单的状态
					preSaleOrder.setStatusCd(paramOrder.getStatusCd());
					results += remove(preSaleOrder);
				}
			}
		}
		return results;
	}

	/**
	 * 将工单池移到二表.
	 *
	 * @author chenjw 2014-9-16
	 */
	public void completeOrderPool(PreSaleOrder preSaleOrder) {
		// 竣工或者撤销竣工
		if (IntfConstant.PRE_SALE_ORDER_STATUS_CD_COMPLETE.getValue().equals(preSaleOrder.getStatusCd())
				|| IntfConstant.PRE_SALE_ORDER_STATUS_CD_CANCEL_COMPLETE.getValue()
						.equals(preSaleOrder.getStatusCd())) {
			PreSaleOrderPool orderPool = orderPoolService.getPreSaleOrderPoolByOrderId(preSaleOrder.getPreOrderId());
			if (orderPool != null) {
				orderPool.setStatusCd(IntfConstant.PRE_POOL_STATUS_CD_DEALED.getValue());
				orderPool.setStatusDate(new Timestamp(new Date().getTime()));
				orderPool.remove();
			}
		}
	}

	@Override
	public List<PreSaleOrderHis> queryPreSaleOrderHisList(Map param) {
		return preSaleOrderRepository.queryPreSaleOrderHisList(param);
	}

	@Override
	public List<PreSaleOrderItem> queryPreSaleOrderItems(Long preSaleOrderId) {
		return preSaleOrderItemService.queryPreSaleOrderItems(preSaleOrderId);
	}

	@Override
	public PreSaleOrder queryFirstPreOrderByOrderNumber(String preOrderNumber) {
		PreSaleOrder preSaleOrder = null;
		Map param = new HashMap();
		param.put("preOrderNumber", preOrderNumber);
		param.put("seq", 1L);
		List<PreSaleOrder> preSaleOrders = preSaleOrderRepository.queryPreSaleOrderList(param);
		if (preSaleOrders != null && preSaleOrders.size() > 0) {
			preSaleOrder = preSaleOrders.get(0);
		}
		return preSaleOrder;
	}

	@Override
	public PreSaleOrderHis queryFirstPreSaleOrderHisByOrderNumber(String preOrderNumber) {
		PreSaleOrderHis preSaleOrder = null;
		Map param = new HashMap();
		param.put("preOrderNumber", preOrderNumber);
		param.put("seq", 1L);
		List<PreSaleOrderHis> preSaleOrders = preSaleOrderRepository.queryPreSaleOrderHisList(param);
		if (preSaleOrders != null && preSaleOrders.size() > 0) {
			preSaleOrder = preSaleOrders.get(0);
		}
		return preSaleOrder;
	}

	/**
	 * 查询轮询泉州工单池自动发送
	 * 
	 * @param procCount
	 * @param model
	 * @param perSize
	 * @return
	 */
	@Override
	public List<IntfPreOrder> queryIntfOrderWaitSent(int procCount, int model, int perSize) {
		Map params = new HashMap();
		// 工单池自动发送设值
		if (procCount > 0) {
			params.put("procCount", procCount);
			params.put("model", model);
		}
		// 查询条数
		params.put("perSize", perSize);
		// 状态
		List statusList = new ArrayList();
		statusList.add("70A");
		statusList.add("70E");
		statusList.add("70F");
		params.put("statusCdList", statusList);
		// 下次处理时间 小于
		params.put("nextDealTimeEnd", DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		// 处理数 小于
		params.put("dealNumEnd", 3);

		return preSaleOrderRepository.queryListByName("preSaleOrderRepository.queryIntfOrder", IntfPreOrderDTO.class,
				params);
	}

	/**
	 * 查询同编码比当前对象ID小的数据，返回最小的id
	 * 
	 * @author YULIYAO 2016/3/11 return
	 */
	@Override
	public List<IntfPreOrderDTO> queryIntfPreOrder(Map param) {
		return preSaleOrderRepository.queryListByName("preSaleOrderRepository.queryIntfOrder", IntfPreOrderDTO.class,
				param);
	}

	/**
	 * 查询超时统计
	 * 
	 * @author YULIYAO 2016/3/10 return
	 */
	@Override
	public List<OrderOverTimeStatVo> queryOrderOverTimeStat(int procCount, int model) {
		return preSaleOrderRepository.queryOrderOverTimeStat(procCount, model);
	}

	@Override
	public String getLastCustOrderIdByPreOrderNbr(String preOrderNumber) {
		String result = "";
		Map param = new HashMap();
		param.put("preOrderNumber", preOrderNumber);
		PreSaleOrder preSaleOrder = preSaleOrderRepository.getLastCustOrderIdByPreOrderNbr(param);
		if (preSaleOrder != null) {
			result += StringUtils.strnull(preSaleOrder.getExtCustOrderId());
		}
		return result;
	}

	@Override
	public PreSaleOrder getPreSaleOrderByExtOrderId(Long extCustOrderId) {
		PreSaleOrder preSaleOrder = null;
		Map map = new HashMap();
		map.put("extCustOrderId", extCustOrderId);
		List<PreSaleOrder> lists = this.queryPreSaleOrderList(map);
		if (lists != null && lists.size() > 0) {
			preSaleOrder = lists.get(0);
			if (!"1".equals(StringUtils.strnull(preSaleOrder.getSeq()))) {
				preSaleOrder = this.queryFirstPreOrderByOrderNumber(preSaleOrder.getPreOrderNumber());
			}
		}
		return preSaleOrder;
	}
	@Override
	public PreSaleOrder getSelfPreSaleOrderByExtOrderId(Long extCustOrderId) {
		PreSaleOrder preSaleOrder = null;
		Map map = new HashMap();
		map.put("extCustOrderId", extCustOrderId);
		List<PreSaleOrder> lists = this.queryPreSaleOrderList(map);
		if (lists != null && lists.size() > 0) {
			preSaleOrder = lists.get(0);
		}
		return preSaleOrder;
	}

	@Override
	public AbsCrmdBaseEntity getPreSaleOrderHisByExtOrderId(Long extCustOrderId) {
		AbsCrmdBaseEntity preSaleOrder = null;
		preSaleOrder = getPreSaleOrderByExtOrderId(extCustOrderId);
		if (preSaleOrder == null) {
			Map map = new HashMap();
			map.put("extCustOrderId", extCustOrderId);
			List<PreSaleOrderHis> hisList = this.queryPreSaleOrderHisList(map);
			if (hisList != null && hisList.size() > 0) {
				preSaleOrder = hisList.get(0);
				if (preSaleOrder != null && !"1".equals(((PreSaleOrderHis) preSaleOrder).getSeq()+"")) {
					preSaleOrder = queryFirstPreSaleOrderHisByOrderNumber(
							((PreSaleOrderHis) preSaleOrder).getPreOrderNumber());
				}
			}
		}
		return preSaleOrder;
	}

	@Override
	public RetVo announceCharge(PreSaleOrder preSaleOrder, Long reqType) {
		RetVo retVo = new RetVo();
		if (NumberUtils.toLong(IntfConstant.ANNOUNCE_CHARGE_REQ_TYPE_0.getValue()) != reqType
				&& NumberUtils.toLong(IntfConstant.ANNOUNCE_CHARGE_REQ_TYPE_2.getValue()) != reqType
				&& NumberUtils.toLong(IntfConstant.ANNOUNCE_CHARGE_REQ_TYPE_3.getValue()) != reqType) {
			retVo.setResult(false);
			retVo.setMsgTitle("帐务处理请求类型 不合法");
			return retVo;
		}
		try {
			PreAnnounceChargeInDTO preAnnounceChargeInDTO = getPreAnnounceChargeInPut(preSaleOrder, reqType);
			retVo = crmdToHbFacade.announceCharge(preAnnounceChargeInDTO, reqType);
		} catch (Exception e) {
			retVo.setResult(false);
			retVo.setMsgTitle(e.getMessage());
			return retVo;
		}
		// 处理成功，记录账务处理表示
		if (retVo.getResult() && retVo.getObject() != null
				&& "0".equals(((PreAnnounceChargeOutDTO) retVo.getObject()).getResult())) {
			AttrSpec attrSpec = CrmClassUtils.getAttrSpecByCode(PreSaleOrder.class.getSimpleName(),
					"preAnnounceChargeFlag");
			if (attrSpec != null) {
				PreSaleOrderAttr attr = new PreSaleOrderAttr(true);
				attr.setPreOrderId(preSaleOrder.getPreOrderId());
				attr.setShardingId(preSaleOrder.getPreOrderId());
				attr.setAttrId(attrSpec.getAttrId());
				attr.setAttrValue("1");
				IPreSaleOrderAttrService preSaleOrderAttrService = ApplicationContextUtil
						.getBean("preSaleOrderAttrService");
				preSaleOrderAttrService.save(attr);
			}
		}
		return retVo;
	}

	private PreAnnounceChargeInDTO getPreAnnounceChargeInPut(PreSaleOrder preSaleOrder, Long reqType) throws Exception {
		PreAnnounceChargeInDTO preAnnounceChargeInDTO = new PreAnnounceChargeInDTO();
		preAnnounceChargeInDTO.setReqType(reqType);
		ICasSysFacade casSysFacade = ApplicationContextUtil.getBean("CasSysFacade");
		// 获取C3区域的areaNbr
		preAnnounceChargeInDTO.setLatnId(casSysFacade.getLatnIdByAreaId(preSaleOrder.getAreaId()));
		// 岗位ID，先从session中获取岗位，如果没有则默认岗位
		String staffPositionId = StringUtils.isNullOrEmpty(SessionContext.getValue("staffPosionId"))
				? CasConstant.INTF_STAFF_POSITION_ID.getValue()
				: StringUtils.strnull(SessionContext.getValue("staffPosionId"));
		preAnnounceChargeInDTO.setStaffPositionId(NumberUtils.nullToLongZero(staffPositionId));

		preAnnounceChargeInDTO.setPreCustSoNum(preSaleOrder.getPreOrderNumber());
		// 客户名称获取
		preAnnounceChargeInDTO.setCustName(preSaleOrder.getCustName());

		AttrSpec attrSpec = CrmClassUtils.getAttrSpecByCode("PreAcceptanceContext", "accNbr");

		List<PreSaleOrderItem> items = preSaleOrderItemService.queryPreSaleOrderItems(preSaleOrder.getId());
		PreSaleOrderItem accNbrItem = null;
		for (PreSaleOrderItem item : items) {
			if (attrSpec.getAttrId().equals(item.getAttrId())) {
				accNbrItem = item;
				break;
			}
		}

		// 是否有业务号码或者证件号码
		boolean hasAccNbrOrCertNbr = false;

		if (accNbrItem != null) {
			preAnnounceChargeInDTO.setAccNbr(accNbrItem.getAttrValue());
			hasAccNbrOrCertNbr = true;
		} else {
			// TODO:如果没有采集业务号码，则捞证件号码
			String certNbr = null;// this.getCustCertNbr();
			if (!StringUtils.isNullOrEmpty(certNbr)) {
				preAnnounceChargeInDTO.setAccNbr(certNbr);
				hasAccNbrOrCertNbr = true;
			}
		}
		/*
		 * if (!hasAccNbrOrCertNbr) { throw new Exception("未采集业务号码或者证件号码！"); }
		 */
		PreSaleAcctItem paramItem = new PreSaleAcctItem();
		paramItem.setPreOrderId(preSaleOrder.getPreOrderId());
		paramItem.setShardingId(preSaleOrder.getPreOrderId());
		IPreSaleAcctItemService preSaleAcctItemService = ApplicationContextUtil.getBean("preSaleAcctItemService");
		List<PreSaleAcctItem> acctItems = preSaleAcctItemService.queryPreSaleAcctItem(paramItem);
		// 正常受理、撤销，需要把算费产生的账目信息传给计费
		if (IntfConstant.ANNOUNCE_CHARGE_REQ_TYPE_0.getValue().equals(reqType + "")) {

			for (PreSaleAcctItem acctItem : acctItems) {
				if (IntfConstant.PRE_SALE_ACCT_ITEM_TYPE_NORMAL.getValue().equals(acctItem.getAcctItemType())
						&& IntfConstant.PRE_SALE_ACCT_ITEM_STATUS_NO_PAY.getValue().equals(acctItem.getStatusCd())) {
					for (FeeItem item : convertAcctItemToIntf(acctItem)) {
						preAnnounceChargeInDTO.addFeeItem(item);
					}
				}
			}

		} else if (IntfConstant.ANNOUNCE_CHARGE_REQ_TYPE_3.getValue().equals(reqType + "")) {
			for (PreSaleAcctItem acctItem : acctItems) {
				if (IntfConstant.PRE_SALE_ACCT_ITEM_TYPE_RE_FEE.getValue().equals(acctItem.getAcctItemType())
						&& IntfConstant.PRE_SALE_ACCT_ITEM_STATUS_NO_PAY.getValue().equals(acctItem.getStatusCd())) {
					for (FeeItem item : convertAcctItemToIntf(acctItem)) {
						preAnnounceChargeInDTO.addFeeItem(item);
					}
				}
			}
		} else if (IntfConstant.ANNOUNCE_CHARGE_REQ_TYPE_2.getValue().equals(reqType + "")) {

		}
		return preAnnounceChargeInDTO;
	}

	/**
	 *
	 * @param acctItem
	 * @return
	 */
	List<FeeItem> convertAcctItemToIntf(PreSaleAcctItem acctItem) {
		List<FeeItem> list = new ArrayList<FeeItem>();
		Map param = new HashMap();
		param.put("preAcctItemId", acctItem.getId());
		param.put("shardingId", acctItem.getShardingId());
		IPreSaleAcctItemAttrService attrRepository = ApplicationContextUtil.getBean("preSaleAcctItemAttrService");
		List<PreSaleAcctItemAttr> attrs = attrRepository.queryPreSaleAcctItemAttr(param);
		if (attrs != null && attrs.size() > 0) {
			for (PreSaleAcctItemAttr attr : attrs) {
				FeeItem item = new FeeItem();
				AttrSpec attrSpec = CrmClassUtils.getAttrSpecById(attr.getAttrId());

				item.setFeeItemName(attrSpec.getAttrName());
				item.setAmount(NumberUtils.nullToDoubleZero(attr.getAttrValue()).longValue());
				if (IntfConstant.PRE_ACCT_ATTR_SPEC_ID.getValue().equals(attrSpec.getAttrId()+"")) {
					item.setFeeItemClass(IntfConstant.PRE_SALE_ACCT_ITEM_PRINT_VOUCHER.getValue());
				} else if (IntfConstant.CASH_ACCT_ATTR_SPEC_ID.getValue().equals(attrSpec.getAttrId()+"")) {
					item.setFeeItemClass(IntfConstant.PRE_SALE_ACCT_ITEM_PRINT_INVOICE.getValue());
				} else {
					item.setFeeItemClass(IntfConstant.PRE_SALE_ACCT_ITEM_PRINT_NONE.getValue());
				}
				list.add(item);
			}
		}
		return list;
	}

	@Override
	public void savePreSaleOrderForReSend(PreSaleOrder preSaleOrder, PreSaleOrderPool orderPool,
			List<PreSaleOrderAttr> attrs, List<PreSaleOrderProcVo> vos, StaffDTO staffDTO) {
		if (preSaleOrder != null) {
			IPreSaleOrderProcService preSaleOrderProcService = ApplicationContextUtil
					.getBean("preSaleOrderProcService");
			preSaleOrderProcService.createPreSaleOrderProc(preSaleOrder, 1010L, vos, staffDTO);
		}
		if (orderPool != null) {
			// edit by laiyongmin 2016-03-30 crm00073381 orderPool.save() 改
			// .update();
			orderPool.update();
		}
		if (attrs != null && attrs.size() > 0) {
			for (PreSaleOrderAttr attr : attrs) {
				attr.save();
			}
		}
	}

	public void savePreForCompletePayment(PreSaleOrder preSaleOrder, List<PreSaleAcctItem> items,
			List<PreSaleOrderAttr> attrsForSave, List<PreSaleOrderAttr> attrsForRemove, StaffDTO staffDTO) {
		if (preSaleOrder != null) {
			preSaleOrder.update();
		}
		if (items != null && items.size() > 0) {
			for (PreSaleAcctItem item : items) {
				item.update();
			}
		}
		if (attrsForSave != null && attrsForSave.size() > 0) {
			for (PreSaleOrderAttr attr : attrsForSave) {
				attr.save();
			}
		}
		if (attrsForRemove != null && attrsForRemove.size() > 0) {
			for (PreSaleOrderAttr attr : attrsForRemove) {
				attr.remove();
			}
		}
		// 创建预受理处理过程并保存
		IPreSaleOrderProcService procService = ApplicationContextUtil.getBean("preSaleOrderProcService");
		procService.createPreSaleOrderProc(preSaleOrder,
				NumberUtils.toLong(IntfConstant.PRE_PROC_EVENT_ID_PAYED.getValue()), null, staffDTO);
	}

	@Override
	public void savePreForNormalCommit(PreSaleOrder preSaleOrder, PreSaleOrderPool orderPool,
			PreSaleOrder newPreSaleOrder, StaffDTO staffDTO) {
		if (preSaleOrder != null) {
			preSaleOrder.update();
			// 全部受理保存预受理处理过程
			if (IntfConstant.PRE_SALE_ORDER_STATUS_CD_ON_WAY.getValue().equals(preSaleOrder.getStatusCd())) {
				if (staffDTO != null && staffDTO.getStaffId() != null) {
					IPreSaleOrderProcService preSaleOrderProcService = ApplicationContextUtil
							.getBean("preSaleOrderProcService");
					preSaleOrderProcService.createPreSaleOrderProc(preSaleOrder, 1011L, null, staffDTO);
				}
			}
		}
		if (orderPool != null) {
			orderPool.update();
		}
		if (newPreSaleOrder != null) {
			newPreSaleOrder.save();
		}
	}

	@Override
	public void removePreForCancelComplete(PreSaleOrder preSaleOrder, StaffDTO staffDTO ,List<PreSaleOrderProcVo> preSaleOrderProcVos) {
		if (preSaleOrder != null) {
			this.remove(preSaleOrder);
			if (staffDTO != null && staffDTO.getStaffId() != null) {
				IPreSaleOrderProcHisService preSaleOrderProcHisService = ApplicationContextUtil
						.getBean("preSaleOrderProcHisService");
				preSaleOrderProcHisService.createPreSaleOrderProcHis(preSaleOrder, 1002L, preSaleOrderProcVos, staffDTO);
			}
		}
	}

	@Override
	public void savePreForCancelComplete(PreSaleOrder preSaleOrder, PreSaleOrderPool orderPool, StaffDTO staffDTO, List<PreSaleOrderProcVo> preSaleOrderProcVos) {
		if (preSaleOrder != null) {
			preSaleOrder.update();
			if (staffDTO != null && staffDTO.getStaffId() != null) {
				IPreSaleOrderProcService preSaleOrderProcService = ApplicationContextUtil
						.getBean("preSaleOrderProcService");
				preSaleOrderProcService.createPreSaleOrderProc(preSaleOrder, 1012L, preSaleOrderProcVos, staffDTO);
			}
		}
		if (orderPool != null) {
			orderPool.update();
		}
	}

	/**
	 * 查询已竣工的预受理单，供轮洵调用
	 * 
	 * @author YULIYAO 2016/4/1 return
	 */
	@Override
	public List<PreSaleOrder> queryCompleteOrderAuto(Map map) {
		return preSaleOrderRepository.queryListByName("preSaleOrderRepository.queryCompleteOrderAuto",
				PreSaleOrder.class, map);
	}

	/**
	 * 根据销售员工/销售团队查询回退单列表
	 * 
	 * @author YULIYAO 2016/4/6 return
	 */
	@Override
	public PageInfo queryReturnList(Map param, int currentPage, int perPageNum) {
		return preSaleOrderRepository.queryPageInfoByName("preSaleOrderRepository.queryReturnList", PreSaleOrder.class,
				param, currentPage, perPageNum);
	}

	/**
	 * 集团单省内缴费归档处理
	 * 
	 * @author YULIYAO 2016/4/7 return
	 */
	public PageInfo queryCompleteGroupOrderAuto(int model, int procCount, int perSize) {
		Map map = new HashMap();
		if (procCount > 0) {
			map.put("model", model);
			map.put("procCount", procCount);
		}
		return preSaleOrderRepository.queryPageInfoByName("preSaleOrderRepository.queryCompleteGroupOrderAuto",
				PreSaleOrder.class, map, 1, perSize);
	}

	@Override
	public PageInfo getPreOrderByDevStaffAndDevTeam(String saleStaffId, String saleOrgId, String statusCd,
			String beginDate, String endDate, int currentPage, int perPageNum) {
		return preSaleOrderRepository.getPreOrderByDevStaffAndDevTeam(saleStaffId, saleOrgId, statusCd, beginDate,
				endDate, currentPage, perPageNum);
	}

	@Override
	public PageInfo getHisPreOrderByDevStaffAndDevTeam(String saleStaffId, String saleOrgId, String statusCd,
			String beginDate, String endDate, int currentPage, int perPageNum) {
		return preSaleOrderRepository.getHisPreOrderByDevStaffAndDevTeam(saleStaffId, saleOrgId, statusCd, beginDate,
				endDate, currentPage, perPageNum);
	}

	@Override
	public Map<String, Object> getPreOrderStatusAndStatusNumber(String saleStaffId, String saleOrgId,
			String beginDate, String endDate) {
		// 统计1表
		List<PreSaleOrderCountVo> vos = preSaleOrderRepository.qryPreOrderStatusAndNumGroupByStatus(saleStaffId,
				saleOrgId, beginDate, endDate);
		// 统计2表
		List<PreSaleOrderCountVo> hisVos = preSaleOrderRepository.qryHisPreOrderStatusAndNumGroupByStatus(saleStaffId,
				saleOrgId, beginDate, endDate);
		Map<String, Object> map = new HashMap<String, Object>();
		
		for(PreSaleOrderCountVo vo : vos){
			map.put(vo.getStatusCd(), vo.getPreOrderNum());
		}
		for(PreSaleOrderCountVo hisVo : hisVos){
			if(map.containsKey(hisVo.getStatusCd())){
				Long num = NumberUtils.nullToLongZero(map.get(hisVo.getStatusCd()))+hisVo.getPreOrderNum();
				map.put(hisVo.getStatusCd(), num);
			}else{
				map.put(hisVo.getStatusCd(), hisVo.getPreOrderNum());
			}
		}
		// 返回合并数据
		return map;
	}
	@Override
	public void savePreSaleOrderForReturn(PreSaleOrder preSaleOrder,
			PreSaleOrderPool orderPool, StaffDTO staffDTO,
			List<PreSaleOrderProcVo> procVos, Long eventId) {
		if (orderPool != null) {
			orderPool.update();
		}
		if (preSaleOrder != null) {
			if (staffDTO != null && staffDTO.getStaffId() != null) {
				IPreSaleOrderProcService preSaleOrderProcService = ApplicationContextUtil
						.getBean("preSaleOrderProcService");
				preSaleOrderProcService.createPreSaleOrderProc(preSaleOrder, eventId, procVos, staffDTO);
			}
		}
	}
	@Override
	public void saveCancelPreOrder(PreSaleOrder preSaleOrder,
			String cancelFlag, StaffDTO staffDTO, Long staffPositionId,
			String cancelReason, Long amount) {
		if (preSaleOrder != null) {
			// P订单标识为已结单
			preSaleOrder.setIfEnd("1");
			// 1表示撤销P订单
			if ("1".equals(cancelFlag)) {
				// P订单设置为已撤销
				preSaleOrder.setStatusCd(IntfConstant.PRE_SALE_ORDER_STATUS_CD_CANCEL_COMPLETE.getValue());
				PreSaleAcctItem paramItem = new PreSaleAcctItem();
				paramItem.setPreOrderId(preSaleOrder.getPreOrderId());
				paramItem.setShardingId(preSaleOrder.getPreOrderId());
				IPreSaleAcctItemService preSaleAcctItemService = ApplicationContextUtil.getBean("preSaleAcctItemService");
				List<PreSaleAcctItem> acctItems = preSaleAcctItemService.queryPreSaleAcctItem(paramItem);
				// 预受理费用项标识为已退费
				if (acctItems != null && acctItems.size() > 0) {
					for (PreSaleAcctItem acctItem : acctItems) {
						if (IntfConstant.PRE_SALE_ACCT_ITEM_STATUS_PAY.getValue().equals(acctItem.getStatusCd())) {
							acctItem.setStatusCd(IntfConstant.PRE_SALE_ACCT_ITEM_STATUS_REPAY.getValue());
							acctItem.update();
						}
					}
				}
				this.remove(preSaleOrder);
				// 保存预受理处理过程
				List<PreSaleOrderProcVo> vos = new ArrayList<>();
				PreSaleOrderProcVo vo = new PreSaleOrderProcVo();
				vos.add(vo);
				vo.setAttrId(0L);
				vo.setAttrDesc(cancelReason);
				vo.setAttrValue(cancelReason);
				
				IPreSaleOrderProcHisService preSaleOrderProcHisService = ApplicationContextUtil
						.getBean("preSaleOrderProcHisService");
				preSaleOrderProcHisService.createPreSaleOrderProcHis(preSaleOrder, 1006L, vos, staffDTO);
				
				// 保存退费员工
				savePreSaleOrderAttrHis(preSaleOrder.getId(), "preSalePayStaff", staffPositionId + "");
			} else { // 其他情况不撤销P订单
				preSaleOrder.update();
				// 保存退费员工
				if (amount != null && amount > 0 && staffPositionId != null) {
					savePreSaleOrderAttr(preSaleOrder.getId(), "preSalePayStaff", staffPositionId + "");
				}
			}
		}
	}
	/**
	 * 创建并保存P订单属性.
	 * 
	 * @param javaCode
	 * @param attrValue
	 */
	private void savePreSaleOrderAttr(Long preOrderId, String javaCode, String attrValue) {
		if (preOrderId != null && !StringUtils.isNullOrEmpty(javaCode) && !StringUtils.isNullOrEmpty(attrValue)) {
			PreSaleOrderAttr attr = new PreSaleOrderAttr(true);
			attr.setPreOrderId(preOrderId);
			attr.setShardingId(preOrderId);
			Long attrId = CrmClassUtils.getAttrSpecByCode(PreSaleOrder.class.getSimpleName(), javaCode) != null
							? CrmClassUtils.getAttrSpecByCode(PreSaleOrder.class.getSimpleName(),
									javaCode).getId()
							: 0L;
			attr.setAttrId(attrId);
			attr.setAttrValue(attrValue);
			attr.save();
		}
	}
	/**
	 * 创建并保存P订单历史属性.
	 * 
	 * @param preOrderId
	 * @param javaCode
	 * @param attrValue
	 */
	private void savePreSaleOrderAttrHis(Long preOrderId, String javaCode, String attrValue) {
		if (preOrderId != null && !StringUtils.isNullOrEmpty(javaCode) && !StringUtils.isNullOrEmpty(attrValue)) {
			PreSaleOrderAttrHis attrHis = new PreSaleOrderAttrHis();
			PreSaleOrderAttr attr = new PreSaleOrderAttr(true);
			attrHis.setHisId(CrmEntityUtils.getSeq("SEQ_PRE_SALE_ORDER_ATTR_HIS_ID"));
			attrHis.setPreOrderAttrId(attr.getId());
			attrHis.setPreOrderId(preOrderId);
			attrHis.setShardingId(preOrderId);
			Long attrId = CrmClassUtils.getAttrSpecByCode(PreSaleOrder.class.getSimpleName(), javaCode) != null
							? CrmClassUtils.getAttrSpecByCode(PreSaleOrder.class.getSimpleName(),
									javaCode).getId()
							: 0L;
			attrHis.setAttrId(attrId);
			attrHis.setAttrValue(attrValue);
			attrHis.save();
		}
	}

	@Override
	public void cancelOrderForAcctItem(PreSaleOrder preSaleOrder, String msg) {
		preSaleAcctItemService.cancelOrderForAcctItem(preSaleOrder);
		
		if (!StringUtils.isNullOrEmpty(preSaleOrder.getStatusCd()) && !IntfConstant.PRE_SALE_ORDER_STATUS_CD_CANCEL_COMPLETE.getValue().equals(preSaleOrder.getStatusCd())) {
            PreSaleOrderProc preSaleOrderProc = new PreSaleOrderProc(true);
            preSaleOrderProc.setPreOrderId(preSaleOrder.getPreOrderId());
            preSaleOrderProc.setShardingId(preSaleOrder.getPreOrderId());
            // 如果缴费前有保存缴费员工，则设置 - chenjw 20140606 crm00055635
            Long payStaffId = this.getPreSalePayStaffIdByOrder(preSaleOrder);
            if (payStaffId != null) {
            	preSaleOrderProc.setStaffId(payStaffId);
            } else {
            	preSaleOrderProc.setStaffId(CasSessionContext.getContext().getStaffId());
            }
            preSaleOrderProc.setAcceptTime(new Timestamp(new Date().getTime()));
            preSaleOrderProc.setStatusCd(preSaleOrder.getStatusCd());
            preSaleOrderProc.setRemark(msg);
            preSaleOrderProc.save();
        }
        
		preSaleOrder.setStatusCd(IntfConstant.PRE_SALE_ORDER_STATUS_CD_CANCEL_COMPLETE.getValue());
	}

	/**
	 * 甩单保存预受理单信息
	 * @author YULIYAO 2016/5/19
	 * return
	 */
	@Override
	public void savePreSaleOrder(PreSaleOrderInfo info) {
		RetVo retVo = new RetVo(true);
		// 预受理订单保存
		PreSaleOrder preSaleOrder = new PreSaleOrder(true);
		convertBeanToSaleOrder(info.getPreSaleOrder(), preSaleOrder);
		preSaleOrder.setShardingId(preSaleOrder.getPreOrderId());

		this.save(preSaleOrder);
		// 预受理订单属性保存
		boolean preAnnounceChargFlag = false;
		if (info.getPreSaleOrderAttr() != null && info.getPreSaleOrderAttr().length > 0) {
			AttrSpec attrSpec = CrmClassUtils.getAttrSpecByCode(preSaleOrder.getEntityName(), "preAnnounceChargeFlag");
			for (com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleOrderAttr attrInDto : info.getPreSaleOrderAttr()) {
				PreSaleOrderAttr attr = new PreSaleOrderAttr(true);
				convertBeanToSaleOrderAttr(attrInDto, attr);
				attr.setPreOrderId(preSaleOrder.getId());
				attr.setShardingId(preSaleOrder.getPreOrderId());
				attr.setAreaId(preSaleOrder.getAreaId());
				attr.setRegionCd(preSaleOrder.getRegionCd());
				attr.setCreateStaff(preSaleOrder.getCreateStaff());
				attr.setUpdateStaff(preSaleOrder.getUpdateStaff());
				if (attrSpec != null && attrSpec.getAttrId() == attrInDto.getAttrId()) {
					preAnnounceChargFlag = true;
				}
				preSaleOrderAttrService.save(attr);
			}
		}
		// 预受理订单项保存
		if (info.getPreSaleOrderItem() != null && info.getPreSaleOrderItem().length > 0) {
			for (com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleOrderItem itemDto : info.getPreSaleOrderItem()) {
				PreSaleOrderItem item = new PreSaleOrderItem(true);
				convertBeanToPreSaleOrderItem(itemDto, item);
				item.setPreOrderId(preSaleOrder.getId());
				item.setShardingId(preSaleOrder.getPreOrderId());
				item.setCreateStaff(preSaleOrder.getCreateStaff());
				item.setUpdateStaff(preSaleOrder.getUpdateStaff());
				item.setAreaId(preSaleOrder.getAreaId());
				item.setRegionCd(preSaleOrder.getRegionCd());
				IPreSaleOrderItemService preSaleOrderItemService = ApplicationContextUtil
						.getBean("preSaleOrderItemService");
				preSaleOrderItemService.save(item);
			}
		}

		// 集团费用项保存
		if (info.getISaleAcctItem() != null && info.getISaleAcctItem().length > 0) {
			for (com.ffcs.crmd.cas.bean.casbean.presaleorder.ISaleAcctItem itemDto : info.getISaleAcctItem()) {
				IsaleAcctItem item = new IsaleAcctItem(true);
				convertBeanToISaleAcctItem(itemDto, item);
				item.setShardingId(preSaleOrder.getPreOrderId());
				item.setCreateStaff(preSaleOrder.getCreateStaff());
				item.setUpdateStaff(preSaleOrder.getUpdateStaff());
				item.setAreaId(preSaleOrder.getAreaId());
				item.setRegionCd(preSaleOrder.getRegionCd());
				IIsaleAcctItemService isaleAcctItemService = ApplicationContextUtil
						.getBean("isaleAcctItemService");
				isaleAcctItemService.save(item);
			}
		}

		if (info.getPreSaleAcctItem() != null && info.getPreSaleAcctItem().length > 0) {
			for (com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleAcctItem itemDto : info.getPreSaleAcctItem()) {
				PreSaleAcctItem item = new PreSaleAcctItem(true);
				convertBeanToPreSaleAcctItem(itemDto, item);
				item.setPreOrderId(preSaleOrder.getId());
				item.setShardingId(preSaleOrder.getPreOrderId());
				item.setCreateStaff(preSaleOrder.getCreateStaff());
				item.setUpdateStaff(preSaleOrder.getUpdateStaff());
				item.setAreaId(preSaleOrder.getAreaId());
				item.setRegionCd(preSaleOrder.getRegionCd());
				preSaleAcctItemService.save(item);
				if (itemDto.getPreSaleAcctItemAttr() != null && itemDto.getPreSaleAcctItemAttr().length > 0) {
					for (com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleAcctItemAttr attrDto : itemDto
							.getPreSaleAcctItemAttr()) {
						PreSaleAcctItemAttr attr = new PreSaleAcctItemAttr(true);
						convertBeanToPreSaleAcctItemAttr(attrDto, attr);
						attr.setPreAcctItemId(item.getId());
						attr.setShardingId(preSaleOrder.getPreOrderId());
						attr.setCreateStaff(preSaleOrder.getCreateStaff());
						attr.setUpdateStaff(preSaleOrder.getUpdateStaff());
						attr.setAreaId(preSaleOrder.getAreaId());
						attr.setRegionCd(preSaleOrder.getRegionCd());
						IPreSaleAcctItemAttrService preSaleAcctItemAttrService = ApplicationContextUtil
								.getBean("preSaleAcctItemAttrService");
						preSaleAcctItemAttrService.save(attr);
					}
				}
			}
		}
		// 工单池记录
		if (info.getPreSaleOrderPool() != null) {
			// 保存工单池记录前，先判断数据库中是否已经存在，根据PRE_ORDER_ID判断
			PreSaleOrderPool oldPool = preSaleOrderPoolService
					.getPreSaleOrderPoolByOrderId(preSaleOrder.getPreOrderId());
			if (oldPool != null) {
				ExceptionUtils.throwEx("P单号：" + preSaleOrder.getPreOrderNumber() + "对应的工单池记录已存在，不能再新增");
			}
			com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleOrderPool _preSaleOrderPool = info.getPreSaleOrderPool();
			PreSaleOrderPool preSaleOrderPool = new PreSaleOrderPool(true);
			convertBeanToOrderPool(_preSaleOrderPool, preSaleOrderPool);
			preSaleOrderPool.setPreOrderId(preSaleOrder.getId());
			preSaleOrderPool.setShardingId(preSaleOrder.getId());
			preSaleOrderPool.setCreateStaff(preSaleOrder.getCreateStaff());
			preSaleOrderPool.setUpdateStaff(preSaleOrder.getUpdateStaff());
			preSaleOrderPool.setAreaId(preSaleOrder.getAreaId());
			preSaleOrderPool.setRegionCd(preSaleOrder.getRegionCd());
			preSaleOrderPool.setPreOrderSrc(preSaleOrder.getPreOrderSrc());
			preSaleOrderPool.setRemark("初始化备注");
			preSaleOrderPoolService.save(preSaleOrderPool);

		}
		// intf_pre_order
		if (info.getIntfPreOrder() != null && info.getIntfPreOrder().length > 0) {
			for (com.ffcs.crmd.cas.bean.casbean.presaleordercommit.IntfPreOrder intfPreOrder : info.getIntfPreOrder()) {
				IntfPreOrder order = new IntfPreOrder(true);
				order.setPreOrderNumber(preSaleOrder.getPreOrderNumber());
				order.setShardingId(preSaleOrder.getPreOrderId());
				order.setChannelNbr(intfPreOrder.getChannelNbr());
				order.setTextType(intfPreOrder.getTextType());
				order.setDealNum(0L);
				order.setNextDealTime(DateUtils.dateToTimestamp(new Date()));
				order.setStatusCd("70A");
				order.setCreateDate(DateUtils.dateToTimestamp(new Date()));
				order.setUpdateDate(DateUtils.dateToTimestamp(new Date()));
				order.setCreateStaff(preSaleOrder.getCreateStaff());
				order.setUpdateStaff(preSaleOrder.getUpdateStaff());
				order.setAreaId(preSaleOrder.getAreaId());
				order.setRegionCd(preSaleOrder.getRegionCd());
				intfPreOrderService.save(order);

				if (!StringUtils.isNullOrEmpty(intfPreOrder.getTextContent())) {
					String content = intfPreOrder.getTextContent();
					content = content.replace("&lt;", "<");
					content = content.replace("&gt;", ">");
					// 区域为空时，替换为PRE_SALE_ORDER上面的REGION_CD
					if (content.indexOf("<commonRegionId>null</commonRegionId>") != -1) {
						String regionCdTag = "<commonRegionId>" + preSaleOrder.getRegionCd() + "</commonRegionId>";
						content = content.replace("<commonRegionId>null</commonRegionId>", regionCdTag);
					}
					IntfPreOrderAttach attach = new IntfPreOrderAttach();
					attach.setIntfPreOrderId(order.getIntfPreOrderId());
					attach.setShardingId(preSaleOrder.getPreOrderId());
					attach.setCreateStaff(preSaleOrder.getCreateStaff());
					attach.setUpdateStaff(preSaleOrder.getUpdateStaff());
					attach.setAreaId(preSaleOrder.getAreaId());
					attach.setRegionCd(preSaleOrder.getRegionCd());
					attach.setTextContent(content);
					attach.setStatusCd("70A");
					intfPreOrderAttachService.save(attach);
				}
			}
		}
		// auto_gen_order
		if (info.getAutoGenOrder() != null && !StringUtils.isNullOrEmpty(info.getAutoGenOrder().getXmlMsg())) {
			com.ffcs.crmd.cas.bean.casbean.presaleordercommit.AutoGenOrder _autoGenOrder = info.getAutoGenOrder();
			AutoGenOrder autoGenOrder = new AutoGenOrder(true);
			convertBeanToOrder(_autoGenOrder, autoGenOrder);
			autoGenOrder.setShardingId(preSaleOrder.getPreOrderId());
			autoGenOrder.setCreateStaff(preSaleOrder.getCreateStaff());
			autoGenOrder.setUpdateStaff(preSaleOrder.getUpdateStaff());
			autoGenOrder.setAreaId(preSaleOrder.getAreaId());
			autoGenOrder.setRegionCd(preSaleOrder.getRegionCd());
			IAutoGenOrderService autoGenOrderService = ApplicationContextUtil
					.getBean("autoGenOrderService");
			autoGenOrderService.save(autoGenOrder);

			String xmlMsg = _autoGenOrder.getXmlMsg();
			xmlMsg = xmlMsg.replace("&lt;", "<");
			xmlMsg = xmlMsg.replace("&gt;", ">");
			AutoGenOrderAttach attach = new AutoGenOrderAttach(true);
			attach.setXmlMsg(xmlMsg);
			attach.setStatusCd(IntfConstant.AUTO_GEN_ORDER_STATUS_CREATE.getValue());
			attach.setAutoGenOrderId(autoGenOrder.getId());
			attach.setShardingId(preSaleOrder.getPreOrderId());
			attach.setCreateStaff(preSaleOrder.getCreateStaff());
			attach.setUpdateStaff(preSaleOrder.getUpdateStaff());
			attach.setAreaId(preSaleOrder.getAreaId());
			attach.setRegionCd(preSaleOrder.getRegionCd());
			IAutoGenOrderAttachService autoGenOrderAttachService = ApplicationContextUtil
					.getBean("autoGenOrderAttachService");
			autoGenOrderAttachService.save(attach);
		}
	}

	/**
	 *
	 * @author YULIYAO 2016/5/19
	 * return
	 */
	@Override
	public PreSaleOrder saveCompleteOrderInfo(CompleteOrderInfo orderInfo) {
		PreSaleOrder statusChangeOrder = null;	//记录有状态变更时的P单，返回上层facade通知客户端
		String preOrderNumber = orderInfo.getPreOrderNumber();
		// 根据P订单号判断数据库中是否存在
		PreSaleOrder oldPreSaleOrder = this.queryFirstPreOrderByOrderNumber(preOrderNumber);
		if (oldPreSaleOrder == null) {
			ExceptionUtils.throwEx("订单确认失败，根据P订单号：" + preOrderNumber + "找不到对应的P订单");
		}
		// 工单池记录
		PreSaleOrderPool orderPool = preSaleOrderPoolService
				.getPreSaleOrderPoolByOrderId(oldPreSaleOrder.getPreOrderId());
		// 场景标识
		String actionCd = orderInfo.getActionCd();
		// P订单目标状态
		String preOrderStatus = orderInfo.getPreOrderStatus();
		// 处理员工
		StaffDTO staffDTO = null;
		if (!StringUtils.isNullOrEmpty(orderInfo.getHandleStaffId())) {
			Staff staff = Staff.repository().getById(NumberUtils.nullToLongZero(orderInfo.getHandleStaffId()));
			if (staff != null && staff.getId() != null) {
				staffDTO = new StaffDTO();
				staffDTO.setStaffId(staff.getId());
				staffDTO.setStaffName(staff.getStaffName());
			}
		}
		// 撤销原因
		List<PreSaleOrderProcVo> procVos = new ArrayList<PreSaleOrderProcVo>();
		if (!StringUtils.isNullOrEmpty(orderInfo.getCancelReason())) {
			PreSaleOrderProcVo procVo = new PreSaleOrderProcVo();
			procVos.add(procVo);
			procVo.setAttrDesc(orderInfo.getCancelReason());

			Long attrId = CrmClassUtils.getAttrSpecByCode(PreSaleOrderProc.class.getSimpleName(),
					"backReasonList") != null
					? CrmClassUtils.getAttrSpecByCode(PreSaleOrderProc.class.getSimpleName(), "backReasonList")
					.getId()
					: 0L;
			procVo.setAttrId(attrId);
		}
		// 竣工场景
		if ("complete".equals(actionCd)) {
			// 如果是集团订单竣工，则保存一个预受理订单属性
			if (!StringUtils.isNullOrEmpty(orderInfo.getGroupOrderFlag())) {
				PreSaleOrderAttr attr = new PreSaleOrderAttr(true);
				attr.setPreOrderId(oldPreSaleOrder.getPreOrderId());
				attr.setShardingId(oldPreSaleOrder.getPreOrderId());
				Long attrId = CrmClassUtils.getAttrSpecByCode(PreSaleOrder.class.getSimpleName(),
						"groupOrderCompleteFlag") != null
						? CrmClassUtils.getAttrSpecByCode(PreSaleOrder.class.getSimpleName(),
						"groupOrderCompleteFlag").getId()
						: 0L;
				attr.setAttrId(attrId);
				attr.setAttrValue("1");
				attr.save();
			}
			if (IntfConstant.PRE_SALE_ORDER_STATUS_CD_COMPLETE.getValue().equals(preOrderStatus)) {
				oldPreSaleOrder.setStatusCd(preOrderStatus);
				oldPreSaleOrder.update();
				statusChangeOrder =oldPreSaleOrder;
				this.remove(oldPreSaleOrder);
			} else if (IntfConstant.PRE_SALE_ORDER_STATUS_CD_COMPLETING.getValue().equals(preOrderStatus)) {
				oldPreSaleOrder.setStatusCd(preOrderStatus);
				statusChangeOrder = oldPreSaleOrder;
				oldPreSaleOrder.update();
			}
		} else if ("calloff".equals(actionCd)) { // 取消场景
			if (IntfConstant.PRE_SALE_ORDER_STATUS_CD_CANCEL_COMPLETE.getValue().equals(preOrderStatus)) {
				oldPreSaleOrder.setStatusCd(preOrderStatus);
				statusChangeOrder = oldPreSaleOrder;
				this.removePreForCancelComplete(oldPreSaleOrder, staffDTO, procVos);
			}
		} else if ("cancel".equals(actionCd)) { // 撤销场景
			// 撤销时，如果有关联工单池记录，并且工单池记录状态是已处理，并且存在剩余预收费用（此判断由CRM完成），则P订单状态设置为部分受理
			if (IntfConstant.PRE_SALE_ORDER_STATUS_CD_PART_DEAL.getValue().equals(preOrderStatus)) {
				oldPreSaleOrder.setStatusCd(preOrderStatus);
				oldPreSaleOrder.setIfEnd("");
				if (orderPool != null) {
					if (orderPool.getStaffId() != null) {
						orderPool.setStatusCd(IntfConstant.PRE_POOL_STATUS_CD_ACCEPTED.getValue());
					} else {
						orderPool.setStatusCd(IntfConstant.PRE_POOL_STATUS_CD_NOT_ACCEPTED.getValue());
					}
				}
				this.savePreForCancelComplete(oldPreSaleOrder, orderPool, staffDTO, procVos);
			} else if (IntfConstant.PRE_SALE_ORDER_STATUS_CD_CANCEL_COMPLETE.getValue().equals(preOrderStatus)) {
				// 撤销时，如果没有关联工单池记录，则判断关联的正式订单如果都已进二表（此判断由CRM完成），则将P单移到二表
				oldPreSaleOrder.setStatusCd(preOrderStatus);
				statusChangeOrder = oldPreSaleOrder;
				this.removePreForCancelComplete(oldPreSaleOrder, staffDTO, procVos);
			}
		}
		return statusChangeOrder;
	}

	/**
	 * 接口对象转换成dto。
	 *
	 * @param vPreSaleOrder
	 * @param dto
	 */
	private void convertBeanToSaleOrder(com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleOrder vPreSaleOrder,
			PreSaleOrder dto) {
		// dto.setPreOrderId(vPreSaleOrder.getPreOrderId());
		dto.setShardingId(vPreSaleOrder.getPreOrderId());
		dto.setCustomerInteractionEventId(vPreSaleOrder.getCustomerInteractionEventId());
		dto.setStaffId(vPreSaleOrder.getStaffId());
		dto.setCustId(vPreSaleOrder.getCustId());
		dto.setPreOrderNumber(vPreSaleOrder.getPreOrderNumber());
		dto.setSceneType(vPreSaleOrder.getSceneType());
		dto.setLockedStatus(vPreSaleOrder.getLockedStatus());
		dto.setLockedStaff(vPreSaleOrder.getLockedStaff());
		//针对string 转Timestamp 需要先转date，服务器上会有问题
		if (!StringUtils.isNullOrEmpty(vPreSaleOrder.getLockedTime())) {
			dto.setLockedTime(DateUtils.dateToTimestamp(
					DateUtils.str2Date(vPreSaleOrder.getLockedTime())));
		}
		dto.setOrderFrom(vPreSaleOrder.getOrderFrom());
		dto.setHandlePeopleName(vPreSaleOrder.getHandlePeopleName());
		dto.setPriority(vPreSaleOrder.getPriority());
		//针对string 转Timestamp 需要先转date，否则服务器上会有问题
		if (!StringUtils.isNullOrEmpty(vPreSaleOrder.getAcceptTime())) {
			dto.setAcceptTime(DateUtils.dateToTimestamp(
					DateUtils.str2Date(vPreSaleOrder.getAcceptTime())));
		} else {
			dto.setAcceptTime(DateUtils.dateToTimestamp(new Date()));
		}
		dto.setLanId(vPreSaleOrder.getLanId());
		dto.setRemark(vPreSaleOrder.getRemark());
		dto.setPreHandleFlag(vPreSaleOrder.getPreHandleFlag());
		//针对string 转Timestamp 需要先转date，否则服务器上会有问题
		if (!StringUtils.isNullOrEmpty(vPreSaleOrder.getBookTime())) {
			dto.setBookTime(DateUtils.dateToTimestamp(
					DateUtils.str2Date(vPreSaleOrder.getBookTime())));
		}
		dto.setChannelD(vPreSaleOrder.getChannelId());
		dto.setOrgId(vPreSaleOrder.getOrgId());
		dto.setOrderType(vPreSaleOrder.getOrderType());
		dto.setExtCustOrderId(vPreSaleOrder.getExtCustOrderId());
		dto.setIfEnd(vPreSaleOrder.getIfEnd());
		dto.setSeq(vPreSaleOrder.getSeq());
		dto.setProdType(vPreSaleOrder.getProdType());
		dto.setActionType(vPreSaleOrder.getActionType());
		dto.setServiceType(vPreSaleOrder.getServiceType());
		dto.setStatusCd(vPreSaleOrder.getStatusCd());
		dto.setAreaId(vPreSaleOrder.getAreaId());
		dto.setRegionCd(vPreSaleOrder.getRegionCd());
		dto.setCreateStaff(vPreSaleOrder.getCreateStaff());
		dto.setUpdateStaff(vPreSaleOrder.getUpdateStaff());
		dto.setCustSoNumber(vPreSaleOrder.getCustSoNumber());
		dto.setCustName(vPreSaleOrder.getCustName());
		dto.setMobilePhone(vPreSaleOrder.getMobilePhone());
		dto.setCreateDate(DateUtils.dateToTimestamp(DateUtils.getNowDate()));
		if (!StringUtils.isNullOrEmpty(vPreSaleOrder.getBatchAmount())) {
			dto.setBatchAmount(NumberUtils.nullToLongZero(vPreSaleOrder.getBatchAmount()));
		}
		dto.setPreOrderSrc(vPreSaleOrder.getPreOrderSrc());
	}

	/**
	 * 预受理订单属性转换。
	 *
	 * @param inDTO
	 * @param attr
	 */
	private void convertBeanToSaleOrderAttr(com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleOrderAttr inDTO,
			PreSaleOrderAttr attr) {
		// attr.setPreOrderAttrId(inDTO.getPreOrderAttrId());
		// attr.setPreOrderId(inDTO.getPreOrderId());
		attr.setAttrId(inDTO.getAttrId());
		attr.setAttrValueId(inDTO.getAttrValueId());
		attr.setAttrValue(inDTO.getAttrValue());
		attr.setCreateDate(DateUtils.dateToTimestamp(DateUtils.getNowDate()));
	}

	/**
	 * 订单项转换。
	 *
	 * @param inDTO
	 * @param item
	 */
	private void convertBeanToPreSaleOrderItem(com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleOrderItem inDTO,
			PreSaleOrderItem item) {
		// item.setPreOrderItemId(inDTO.getPreOrderItemId());
		// item.setPreOrderId(inDTO.getPreOrderId());
		item.setAttrId(inDTO.getAttrId());
		item.setJavaCode(inDTO.getJavaCode());
		item.setSuperItemId(inDTO.getSuperItemId());
		item.setAttrParam2(inDTO.getAttrParam2());
		item.setCreateDate(DateUtils.dateToTimestamp(DateUtils.getNowDate()));
	}

	/**
	 * 集团费用项转换。
	 *
	 * @param inDTO
	 * @param item
	 */
	private void convertBeanToISaleAcctItem(com.ffcs.crmd.cas.bean.casbean.presaleorder.ISaleAcctItem inDTO,
			IsaleAcctItem item) {
		// item.setIsaleAcctItemId(inDTO.getIsaleAcctItemId());
		item.setSaleSerial(inDTO.getSaleSerial());
		item.setExtAcctItemId(inDTO.getExtAcctItemCd());
		item.setRealAmount(NumberUtils.nullToDoubleZero(inDTO.getRealAmount()).longValue());
		item.setCreateDate(DateUtils.dateToTimestamp(DateUtils.getNowDate()));
	}

	/**
	 * 账目项转换。
	 *
	 * @param inDTO
	 * @param item
	 */
	private void convertBeanToPreSaleAcctItem(com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleAcctItem inDTO,
			PreSaleAcctItem item) {
		// item.setPreAcctItemId(inDTO.getPreAcctItemId());
		// item.setPreOrderId(inDTO.getPreOrderId());
		item.setAcctItemType(inDTO.getAcctItemType());
		item.setAcctSoNumber(inDTO.getAcctSoNumber());
		item.setStatusCd(inDTO.getStatusCd());
		item.setCreateDate(DateUtils.dateToTimestamp(DateUtils.getNowDate()));
	}

	/**
	 * 账目项属性转换。
	 *
	 * @param inDTO
	 * @param item
	 */
	private void convertBeanToPreSaleAcctItemAttr(com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleAcctItemAttr inDTO,
			PreSaleAcctItemAttr item) {
		// item.setPreAcctItemAttrId(inDTO.getPreAcctItemAttrId());
		// item.setPreAcctItemId(inDTO.getPreAcctItemId());
		item.setAttrId(inDTO.getAttrId());
		item.setAttrValueId(inDTO.getAttrValueId());
		item.setAttrValue(inDTO.getAttrValue());
		item.setCreateDate(DateUtils.dateToTimestamp(DateUtils.getNowDate()));
		item.setUpdateDate(DateUtils.dateToTimestamp(DateUtils.getNowDate()));
	}

	/**
	 * .
	 */
	private void convertBeanToOrderPool(com.ffcs.crmd.cas.bean.casbean.presaleorder.PreSaleOrderPool src,
			PreSaleOrderPool dest) {
		dest.setCustOrderId(src.getCustOrderId());
		dest.setRemark(src.getRemark());
		dest.setVersion(src.getVersion());
		dest.setIsLeaderAssign(src.getIsLeaderAssign());
		dest.setOrgId(src.getOrgId());
		dest.setSceneType(src.getSceneType());
		dest.setServiceType(src.getServiceType());
		if (!StringUtils.isNullOrEmpty(src.getPriority())) {
			dest.setPriority(NumberUtils.toLong(src.getPriority()));
		}
		dest.setStatusCd(src.getStatusCd());
		dest.setCreateDate(DateUtils.dateToTimestamp(DateUtils.getNowDate()));
	}

	private void convertBeanToOrder(
			com.ffcs.crmd.cas.bean.casbean.presaleordercommit.AutoGenOrder _autoGenOrder,
			AutoGenOrder autoGenOrder) {
		autoGenOrder.setPreSaleOrder(_autoGenOrder.getPreOrderNumber());
		autoGenOrder.setSceneType(_autoGenOrder.getSceneType());
		autoGenOrder.setSceneFlag(_autoGenOrder.getSceneFlag());
		if (!StringUtils.isNullOrEmpty(_autoGenOrder.getProdOfferId())) {
			autoGenOrder.setProdOfferId(NumberUtils.nullToLongZero(_autoGenOrder.getProdOfferId()));
		}
		autoGenOrder.setAccNbr(_autoGenOrder.getAccNbr());
		if (!StringUtils.isNullOrEmpty(_autoGenOrder.getCustId())) {
			autoGenOrder.setCustId(NumberUtils.nullToLongZero(_autoGenOrder.getCustId()));
		}
		if (!StringUtils.isNullOrEmpty(_autoGenOrder.getAreaId())) {
			autoGenOrder.setAreaId(NumberUtils.nullToLongZero(_autoGenOrder.getAreaId()));
		}
		if (!StringUtils.isNullOrEmpty(_autoGenOrder.getRegionCd())) {
			autoGenOrder.setRegionCd(NumberUtils.nullToLongZero(_autoGenOrder.getRegionCd()));
		}
		if (!StringUtils.isNullOrEmpty(_autoGenOrder.getCreateStaff())) {
			autoGenOrder.setCreateStaff(NumberUtils.nullToLongZero(_autoGenOrder.getCreateStaff()));
		}
		autoGenOrder.setStatusCd(IntfConstant.AUTO_GEN_ORDER_STATUS_CREATE.getValue());
	}

	/**
	 * .
	 */
	private void convertBeanToOrder(com.ffcs.crmd.cas.bean.casbean.presaleordercommit.CustOrderInfo custOrderInfo,
			PreSaleOrder preSaleOrder) {
		preSaleOrder.setExtCustOrderId(NumberUtils.nullToLongZero(custOrderInfo.getCustOrderId()));
		// 序列统一设置为2
		preSaleOrder.setSeq(2L);
		preSaleOrder.setOrderFrom(custOrderInfo.getOrderFrom());
		preSaleOrder.setChannelD(NumberUtils.nullToLongZero(custOrderInfo.getChannelId()));
		preSaleOrder.setCustId(NumberUtils.nullToLongZero(custOrderInfo.getCustId()));
		preSaleOrder.setStaffId(NumberUtils.nullToLongZero(custOrderInfo.getStaffId()));
		preSaleOrder.setOrgId(NumberUtils.nullToLongZero(custOrderInfo.getOrgId()));
		preSaleOrder.setOrderType(custOrderInfo.getCustOrderType());
		preSaleOrder.setCustSoNumber(custOrderInfo.getCustSoNumber());
		preSaleOrder.setCustName(custOrderInfo.getCustName());
		preSaleOrder.setMobilePhone(custOrderInfo.getMobilePhone());
		preSaleOrder.setCreateStaff(NumberUtils.nullToLongZero(custOrderInfo.getStaffId()));
		preSaleOrder.setUpdateStaff(NumberUtils.nullToLongZero(custOrderInfo.getStaffId()));
		preSaleOrder.setAcceptTime(DateUtils.dateToTimestamp(new Date()));
	}

	/**
     * 通过纵表属性“预受理缴费员工岗位”获取员工ID.
     * 
     * @param preSaleOrder
     * @return
     * @author chenjw
     * 2014-6-6
     */
    public Long getPreSalePayStaffIdByOrder(PreSaleOrder preSaleOrder) {
    	if (preSaleOrder != null) {
    		AttrSpec attrSpec = CrmClassUtils.getAttrSpecByCode(PreSaleOrder.class.getSimpleName(), "preSalePayStaff");
    		if (attrSpec != null) {
    			PreSaleOrderAttr preSaleOrderAttr = preSaleOrderAttrService.getByOrderAndAttrId(preSaleOrder.getPreOrderId(),
    					attrSpec.getAttrId());
    			if (preSaleOrderAttr != null) {
    				StaffPosition sp = StaffPosition.repository().getById(
        					NumberUtils.nullToLongZero(preSaleOrderAttr.getAttrValue()));
    				if (sp != null && sp.getStaffId() != null) {
    					return sp.getStaffId();
        			}
    			}
    		}
    	}
    	return null;
    }
	
}
