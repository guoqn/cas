package com.ffcs.crmd.cas.dat.facade.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.cas.dat.api.facade.IIsaleAcctItemDatFacade;
import com.ffcs.crmd.cas.order.api.dto.IsaleAcctItemDTO;
import com.ffcs.crmd.cas.order.entity.IsaleAcctItem;
import com.ffcs.crmd.cas.order.repository.IIsaleAcctItemRepository;
import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;
@Service("isaleAcctItemDatFacade")
public class ISaleAcctItemDatFacadeImpl implements IIsaleAcctItemDatFacade {

	@Override
	public List<IsaleAcctItemDTO> queryISaleAcctItem(Map param) {
		IIsaleAcctItemRepository isaleAcctItemRepository = ApplicationContextUtil.getBean("isaleAcctItemRepository");
		List<IsaleAcctItem> isaleAcctItems = isaleAcctItemRepository.queryISaleAcctItem(param);
		return CrmBeanUtils.copyList(isaleAcctItems, IsaleAcctItemDTO.class);
	}

}
