package com.ffcs.crmd.cas.dat.facade.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.cas.dat.api.facade.IPreSaleOrderPoolDatFacade;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderPoolDTO;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderPool;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderPoolRepository;
import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;

@Service("preSaleOrderPoolDatFacade")
public class PreSaleOrderPoolDatFacadeImpl implements IPreSaleOrderPoolDatFacade {
	@Override
	public List<PreSaleOrderPoolDTO> queryPreSaleOrderPool(Map param) {
		IPreSaleOrderPoolRepository preSaleOrderPoolRepository = ApplicationContextUtil.getBean("preSaleOrderPoolRepository");
		List<PreSaleOrderPool> preSaleOrderPools = preSaleOrderPoolRepository.queryPreSaleOrderPool(param);
		return CrmBeanUtils.copyList(preSaleOrderPools, PreSaleOrderPoolDTO.class);
	}

}
