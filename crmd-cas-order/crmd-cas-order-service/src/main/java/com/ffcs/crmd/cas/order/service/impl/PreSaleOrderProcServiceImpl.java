package com.ffcs.crmd.cas.order.service.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.CollectionUtils;
import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.cas.base.utils.CrmClassUtils;
import com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderProc.InParam;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.order.entity.PreSaleOrder;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderProc;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderProcAttr;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderProcHis;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderProcRepository;
import com.ffcs.crmd.cas.order.service.IPreSaleOrderProcAttrService;
import com.ffcs.crmd.cas.order.service.IPreSaleOrderProcService;
import com.ffcs.crmd.cas.order.vo.PreSaleOrderProcForIntfVo;
import com.ffcs.crmd.cas.order.vo.PreSaleOrderProcVo;
import com.ffcs.crmd.cas.sys.api.dto.StaffDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("preSaleOrderProcService")
public class PreSaleOrderProcServiceImpl extends AbsCrmdGenericServiceImpl<PreSaleOrderProc, Long>
    implements IPreSaleOrderProcService {

   	@Autowired
	IPreSaleOrderProcRepository preSaleOrderProcRepository;
	@Autowired
	private IPreSaleOrderProcAttrService procAttrService;

	@Override
	public List<PreSaleOrderProc> queryPreSaleOrderProc(PreSaleOrderProc proc) {
		return PreSaleOrderProc.repository().queryPreSaleOrderProc(proc);
	}

	@Override
	public PageInfo queryPreSaleOrderProcPage(PreSaleOrderProc proc, int pageNumber, int pageSize) {
		return preSaleOrderProcRepository.queryPreSaleOrderProcPage(proc, pageNumber, pageSize);
	}

	@Override
	public PageInfo queryPreSaleOrderProcPageWithAttr(PreSaleOrderProc proc, int pageNumber,
			int pageSize) {
		return preSaleOrderProcRepository.queryPreSaleOrderProcWithAttr(proc, pageNumber, pageSize);
	}

	@Override
	public int removeByOrderId(Long preOrderId) {
		int results = 0;
		PreSaleOrderProc proc = new PreSaleOrderProc();
		proc.setPreOrderId(preOrderId);
		List<PreSaleOrderProc> procs = this.queryPreSaleOrderProc(proc);
		if (CollectionUtils.isNotEmpty(procs)) {
			for (PreSaleOrderProc preSaleOrderProc : procs) {
				results += this.remove(preSaleOrderProc);
			}
		}
		return results;
	}

	/**
	 * 删除处理过程，同时删除处理过程属性
	 * @author YULIYAO 2016/1/20
	 * return 
	 */
	@Override
	public int remove(PreSaleOrderProc proc) {
		Map param = new HashMap();
		param.put("preSaleOrderProcId", proc.getPreSaleOrderProcId());
		param.put("shardingId", proc.getShardingId());
		List<PreSaleOrderProcAttr> procAttrs = procAttrService.queryPreSaleOrderProcAttr(param);
		if (CollectionUtils.isNotEmpty(procAttrs)) {
			for (PreSaleOrderProcAttr procAttr : procAttrs) {
				procAttr.remove();
			}
		}
		return super.remove(proc);
	}

	@Override
	public int createPreSaleOrderProc(PreSaleOrder preSaleOrder, Long eventId, List<PreSaleOrderProcVo> vos, StaffDTO staffDTO) {
		int result = 0;
		PreSaleOrderProc proc = new PreSaleOrderProc(true);
		proc.setStatusCd("1000");
		proc.setPreOrderId(preSaleOrder.getPreOrderId());
		proc.setCustomerInteractionEventId(eventId);
		proc.setLanId(preSaleOrder.getAreaId());
		proc.setStaffId(staffDTO != null ? staffDTO.getStaffId() : null);
		proc.setHandlePeopleName(staffDTO != null ? staffDTO.getStaffName() : "");
		proc.setRealCustSoNumber("");
		proc.setAcceptTime(DateUtils.dateToTimestamp(new Date()));
		proc.setShardingId(preSaleOrder.getShardingId());
		String remark = CrmClassUtils.getAttrValueNameByValue(
				"PreSaleOrderProc", "customerInteractionEventId", eventId+"");
		proc.setRemark(remark);
		result += this.save(proc);
		// 创建处理过程属性
		if (vos != null && vos.size() > 0) {
			for (PreSaleOrderProcVo procVo : vos) {
				PreSaleOrderProcAttr procAttr = new PreSaleOrderProcAttr(true);
				procAttr.setPreSaleOrderProcId(proc.getPreSaleOrderProcId());
				procAttr.setShardingId(preSaleOrder.getShardingId());
				procAttr.setAttrId(procVo.getAttrId());
				procAttr.setAttrDesc(procVo.getAttrDesc());
				procAttr.setAttrValueId(procVo.getAttrValueId());
				procAttr.setAttrValue(procVo.getAttrValue());
				result += procAttrService.save(procAttr);
			}
		}
		return result;
	}

	@Override
	public List<PreSaleOrderProcHis> queryPreSaleOrderProcHis(PreSaleOrderProc proc) {
		return preSaleOrderProcRepository.queryPreSaleOrderProcHis(proc);
	}

	/**
	 * 获取最后一条退单属性
	 * @author YULIYAO 2016/4/7
	 * return
	 */
	public PreSaleOrderProcAttr getLastBackProcAttr(Long preOrderId){
		Map map = new HashMap();
		map.put("preOrderId", preOrderId);
		map.put("attrId", NumberUtils.toLong(CasConstant.BACK_REASON_ATTR.getValue()));
		List<Long> eventIds = new ArrayList<>();
		eventIds.add(NumberUtils.toLong(CasConstant.PRE_PROC_EVENT_ID_POOL_RET.getValue()));
		eventIds.add(NumberUtils.toLong(CasConstant.PRE_PROC_EVENT_ID_AUDIT_RET.getValue()));
		map.put("eventIds", eventIds);
		IPreSaleOrderProcAttrService preSaleOrderProcAttrService = ApplicationContextUtil.getBean("preSaleOrderProcAttrService");
		return preSaleOrderProcAttrService.queryLastBackProcAttr(map);
	}

	@Override
	public List<PreSaleOrderProcForIntfVo> qryPreSaleOrderProcForIntf(Map map) {
		List<PreSaleOrderProcForIntfVo> list = preSaleOrderProcRepository.qryPreSaleOrderProcForIntf(map);
		List<PreSaleOrderProcForIntfVo> hisList = preSaleOrderProcRepository.qryPreSaleOrderProcHisForIntf(map);
		List<PreSaleOrderProcForIntfVo> all = new ArrayList<PreSaleOrderProcForIntfVo>();
		if(list !=null && list.size() >0){
			all.addAll(list);
		}
		if(hisList !=null && hisList.size() >0){
			all.addAll(hisList);
		}
		return all;
	}
}
