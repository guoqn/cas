package com.ffcs.crmd.cas.order.service.impl;

import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ffcs.crmd.cas.base.utils.CrmClassUtils;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.order.entity.*;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderProcHisRepository;
import com.ffcs.crmd.cas.order.service.IPreSaleOrderProcAttrHisService;
import com.ffcs.crmd.cas.order.service.IPreSaleOrderProcHisService;
import com.ffcs.crmd.cas.order.vo.PreSaleOrderProcVo;
import com.ffcs.crmd.cas.sys.api.dto.StaffDTO;
import com.ffcs.crmd.platform.data.utils.CrmEntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("preSaleOrderProcHisService")
public class PreSaleOrderProcHisServiceImpl extends AbsCrmdGenericServiceImpl<PreSaleOrderProcHis, Long>
    implements IPreSaleOrderProcHisService {

   	@Autowired
	IPreSaleOrderProcHisRepository preSaleOrderProcHisRepository;
   	@Autowired
   	IPreSaleOrderProcAttrHisService procAttrHisService;
   	@Override
	public int createPreSaleOrderProcHis(PreSaleOrder preSaleOrder,
			Long eventId, List<PreSaleOrderProcVo> vos, StaffDTO staffDTO) {
   		int result = 0;
   		if (preSaleOrder != null) {
   			PreSaleOrderProcHis procHis = new PreSaleOrderProcHis();
   			Long hisId = CrmEntityUtils.getSeq("SEQ_PRE_SALE_ORDER_PROC_HIS_ID");
   			procHis.setHisId(hisId);
			PreSaleOrderProc preSaleOrderProc = new PreSaleOrderProc(true);
			procHis.setPreSaleOrderProcId(preSaleOrderProc.getId());
   			procHis.setStatusCd("1000");
   			procHis.setPreOrderId(preSaleOrder.getId());
   			procHis.setCustomerInteractionEventId(eventId);
   			procHis.setStaffId(staffDTO != null ? staffDTO.getStaffId() : null);
   			procHis.setHandlePeopleName(staffDTO != null ? staffDTO.getStaffName() : "");
   			procHis.setRealCustSoNumber("");
   			procHis.setAcceptTime(DateUtils.dateToTimestamp(new Date()));
   			procHis.setShardingId(preSaleOrder.getShardingId());
   			String remark = CrmClassUtils.getAttrValueNameByValue(
   					"PreSaleOrderProc", "customerInteractionEventId", eventId+"");
   			procHis.setRemark(remark);
   			result += this.save(procHis);
   			// 创建处理过程属性
   			if (vos != null && vos.size() > 0) {
   				for (PreSaleOrderProcVo procVo : vos) {
   					PreSaleOrderProcAttrHis attrHis = new PreSaleOrderProcAttrHis();
					attrHis.setHisId(CrmEntityUtils.getSeq("SEQ_PRE_ORDER_PROC_ATTR_HIS_ID"));
					attrHis.setPreOrderProcAttrId(CrmEntityUtils.getSeq("SEQ_PRE_ORDER_PROC_ATTR_ID"));
   					attrHis.setPreSaleOrderProcId(procHis.getPreSaleOrderProcId());
   					attrHis.setShardingId(preSaleOrder.getShardingId());
   					attrHis.setAttrId(procVo.getAttrId());
   					attrHis.setAttrDesc(procVo.getAttrDesc());
   					attrHis.setAttrValueId(procVo.getAttrValueId());
   					attrHis.setAttrValue(procVo.getAttrValue());
   					procAttrHisService.save(attrHis);
   				}
   			}
   		}
   		return result;
   	}
}
