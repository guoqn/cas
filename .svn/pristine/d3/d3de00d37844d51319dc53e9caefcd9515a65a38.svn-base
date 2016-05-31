package com.ffcs.crmd.cas.dat.repository.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderPoolDTO;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderPool;
import com.ffcs.crmd.cas.order.repository.impl.PreSaleOrderPoolRepositoryImpl;
import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;
import com.ffcs.crmd.platform.pub.dats.DataServiceUtils;

@Repository("preSaleOrderPoolRepositoryProxy")
public class PreSaleOrderPoolProxyRepositoryImpl extends PreSaleOrderPoolRepositoryImpl {
	public PreSaleOrderPoolProxyRepositoryImpl() {
        super();
    }
	@Override
	public List<PreSaleOrderPool> queryPreSaleOrderPool(Map param) {
		List<PreSaleOrderPoolDTO> preSaleOrderPoolDtos = DataServiceUtils.callService("$preSaleOrderPoolDatFacade",
				"queryPreSaleOrderPool", param);
		return CrmBeanUtils.copyList(preSaleOrderPoolDtos, PreSaleOrderPool.class);
	}
}
