package com.ffcs.crmd.cas.order.service;

import java.util.List;

import com.ffcs.crmd.cas.core.ddd.service.ICrmdGenericService;
import com.ffcs.crmd.cas.order.entity.PreSaleOrder;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderProcHis;
import com.ffcs.crmd.cas.order.vo.PreSaleOrderProcVo;
import com.ffcs.crmd.cas.sys.api.dto.StaffDTO;

public interface IPreSaleOrderProcHisService extends ICrmdGenericService<PreSaleOrderProcHis, Long> {
	/**
	 * 创建预受理处理过程历史记录.
	 * 
	 * @param preSaleOrder
	 * @param eventId
	 * @param vos
	 * @param staffDTO
	 * @return
	 */
	int createPreSaleOrderProcHis(PreSaleOrder preSaleOrder, Long eventId, List<PreSaleOrderProcVo> vos, StaffDTO staffDTO);
}
