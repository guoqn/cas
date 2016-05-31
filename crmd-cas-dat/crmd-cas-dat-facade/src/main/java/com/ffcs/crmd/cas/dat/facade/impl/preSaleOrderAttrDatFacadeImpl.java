package com.ffcs.crmd.cas.dat.facade.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.cas.dat.api.facade.IPreSaleOrderAttrDatFacade;
import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderAttrDTO;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderAttr;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderAttrRepository;
import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;

@Service("preSaleOrderAttrDatFacade")
public class preSaleOrderAttrDatFacadeImpl implements IPreSaleOrderAttrDatFacade{
	@Override
	public List<PreSaleOrderAttrDTO> queryPreSaleOrderAttr(Map map) {
		IPreSaleOrderAttrRepository preSaleOrderAttrRepository = ApplicationContextUtil.getBean("preSaleOrderAttrRepository");
		//调用实际的后端逻辑,获取entity
		List<PreSaleOrderAttr> preSaleOrderAttrs = preSaleOrderAttrRepository.queryPreSaleOrderAttr(map);
		//转换成DTO返回
		return CrmBeanUtils.copyList(preSaleOrderAttrs, PreSaleOrderAttrDTO.class);
	}

}
