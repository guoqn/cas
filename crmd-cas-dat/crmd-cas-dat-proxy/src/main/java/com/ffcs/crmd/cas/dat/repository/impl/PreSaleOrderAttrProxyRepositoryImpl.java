package com.ffcs.crmd.cas.dat.repository.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderAttrDTO;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderAttr;
import com.ffcs.crmd.cas.order.repository.impl.PreSaleOrderAttrRepositoryImpl;
import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;
import com.ffcs.crmd.platform.pub.dats.DataServiceUtils;

@Repository("preSaleOrderAttrRepositoryProxy")
public class PreSaleOrderAttrProxyRepositoryImpl extends PreSaleOrderAttrRepositoryImpl {
	public PreSaleOrderAttrProxyRepositoryImpl(){
		super();
	}
	@Override
	public List<PreSaleOrderAttr> queryPreSaleOrderAttr(Map map) {
		//固定方法,调用远程服务.
		List<PreSaleOrderAttrDTO> preSaleOrderAttrDtos = DataServiceUtils.callService("$preSaleOrderAttrDatFacade", "queryPreSaleOrderAttr", map);
		 //将DTO转换为返回
		return CrmBeanUtils.copyList(preSaleOrderAttrDtos, PreSaleOrderAttr.class);
	}
}
