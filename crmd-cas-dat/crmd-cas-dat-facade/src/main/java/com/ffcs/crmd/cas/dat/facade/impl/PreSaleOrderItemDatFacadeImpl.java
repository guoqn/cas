package com.ffcs.crmd.cas.dat.facade.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.cas.dat.api.facade.IPreSaleOrderItemDatFacade;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderDTO;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderItemDTO;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderItem;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderItemRepository;
import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;
@Service("preSaleOrderItemDatFacade")
public class PreSaleOrderItemDatFacadeImpl implements IPreSaleOrderItemDatFacade {

	@Override
	public List<PreSaleOrderItemDTO> queryPreOrderItem(Map param) {
		IPreSaleOrderItemRepository preSaleOrderItemRepository = ApplicationContextUtil
				.getBean("preSaleOrderItemRepository");
		List<PreSaleOrderItem> preSaleOrderItems = preSaleOrderItemRepository.queryPreOrderItem(param);
		return CrmBeanUtils.copyList(preSaleOrderItems, PreSaleOrderItemDTO.class);
	}

}
