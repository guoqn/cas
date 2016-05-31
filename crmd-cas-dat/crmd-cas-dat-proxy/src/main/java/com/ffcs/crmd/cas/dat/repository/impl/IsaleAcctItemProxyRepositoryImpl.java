package com.ffcs.crmd.cas.dat.repository.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.cas.order.api.dto.IsaleAcctItemDTO;
import com.ffcs.crmd.cas.order.entity.IsaleAcctItem;
import com.ffcs.crmd.cas.order.repository.impl.IsaleAcctItemRepositoryImpl;
import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;
import com.ffcs.crmd.platform.pub.dats.DataServiceUtils;
@Repository("isaleAcctItemRepositoryProxy")
public class IsaleAcctItemProxyRepositoryImpl extends IsaleAcctItemRepositoryImpl {
	public IsaleAcctItemProxyRepositoryImpl(){
		super();
	}
	@Override
	public List<IsaleAcctItem> queryISaleAcctItem(Map param) {
		List<IsaleAcctItemDTO> isaleAcctItemDtos = DataServiceUtils.callService("$isaleAcctItemDatFacade",
				"queryISaleAcctItem", param);
		return CrmBeanUtils.copyList(isaleAcctItemDtos, IsaleAcctItem.class);
		
	}
}
