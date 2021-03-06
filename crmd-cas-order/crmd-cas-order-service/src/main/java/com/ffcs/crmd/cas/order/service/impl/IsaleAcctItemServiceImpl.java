package com.ffcs.crmd.cas.order.service.impl;

import com.ctg.itrdc.platform.common.utils.type.CollectionUtils;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.order.entity.IsaleAcctItem;
import com.ffcs.crmd.cas.order.repository.IIsaleAcctItemRepository;
import com.ffcs.crmd.cas.order.service.IIsaleAcctItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("isaleAcctItemService")
public class IsaleAcctItemServiceImpl extends AbsCrmdGenericServiceImpl<IsaleAcctItem, Long>
    implements IIsaleAcctItemService {

   	@Autowired
	IIsaleAcctItemRepository isaleAcctItemRepository;

	@Override
	public int removeBySerail(String saleSerial) {
		int result = 0;
		Map param = new HashMap<>();
		param.put("saleSerial", saleSerial);
		List<IsaleAcctItem> isaleAcctItems = IsaleAcctItem.repository().queryISaleAcctItem(param);
		if (CollectionUtils.isNotEmpty(isaleAcctItems)) {
			for (IsaleAcctItem isaleAcctItem : isaleAcctItems) {
				result += isaleAcctItem.remove();
			}
		}
		return result;
	}
}
