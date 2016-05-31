package com.ffcs.crmd.cas.dat.repository.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderItemDTO;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderItem;
import com.ffcs.crmd.cas.order.repository.impl.PreSaleOrderItemRepositoryImpl;
import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;
import com.ffcs.crmd.platform.pub.dats.DataServiceUtils;
@Repository("preSaleOrderItemRepositoryProxy")
public class PreSaleOrderItemProxyRepositoryImpl extends PreSaleOrderItemRepositoryImpl {
	public PreSaleOrderItemProxyRepositoryImpl(){
		super();
	}
	@Override
	public List<PreSaleOrderItem> queryPreOrderItem(Map param) {
		List<PreSaleOrderItemDTO> preSaleOrderItemDtos = DataServiceUtils.callService("$preSaleOrderItemDatFacade",
				"queryPreOrderItem", param);
		return CrmBeanUtils.copyList(preSaleOrderItemDtos, PreSaleOrderItem.class);
		
	}
}
