package com.ffcs.crmd.cas.order.service.impl;

import com.ctg.itrdc.platform.common.utils.type.CollectionUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.cas.constants.IntfConstant;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.order.entity.PreSaleAcctItem;
import com.ffcs.crmd.cas.order.entity.PreSaleAcctItemAttr;
import com.ffcs.crmd.cas.order.entity.PreSaleOrder;
import com.ffcs.crmd.cas.order.repository.IPreSaleAcctItemRepository;
import com.ffcs.crmd.cas.order.service.IPreSaleAcctItemAttrService;
import com.ffcs.crmd.cas.order.service.IPreSaleAcctItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("preSaleAcctItemService")
public class PreSaleAcctItemServiceImpl extends AbsCrmdGenericServiceImpl<PreSaleAcctItem, Long>
    implements IPreSaleAcctItemService {

   	@Autowired
	IPreSaleAcctItemRepository preSaleAcctItemRepository;

	@Override
	public List<PreSaleAcctItem> queryPreSaleAcctItem(PreSaleAcctItem acctItem) {
		if (acctItem == null) {
			return null;
		}
		Map params = new HashMap();
		//查询参数：预受理单ID
		if (!StringUtils.isNullOrEmpty(acctItem.getPreOrderId())) {
			params.put("preOrderId", acctItem.getPreOrderId());
		}
		//查询参数：分片键
		if (!StringUtils.isNullOrEmpty(acctItem.getShardingId())) {
			params.put("shardingId", acctItem.getShardingId());
		}
		return preSaleAcctItemRepository.queryListByName("preSaleOrderRepository.queryPreSaleAcctItem",PreSaleAcctItem.class,params);
	}

	@Override
	public int removeByOrderId(Long preOrderId) {
		int result = 0;
		PreSaleAcctItem acctItem = new PreSaleAcctItem();
		acctItem.setPreOrderId(preOrderId);
		acctItem.setShardingId(preOrderId);
		List<PreSaleAcctItem> preSaleAcctItems = this.queryPreSaleAcctItem(acctItem);
		if (CollectionUtils.isNotEmpty(preSaleAcctItems)) {
			for (PreSaleAcctItem preSaleAcctItem : preSaleAcctItems) {
				result += this.remove(preSaleAcctItem);
			}
		}
		return result;
	}
	@Override
	public int remove(PreSaleAcctItem acctItem) {
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("preAcctItemId", acctItem.getPreAcctItemId());
        map.put("shardingId", acctItem.getShardingId());
        IPreSaleAcctItemAttrService preSaleAcctItemAttrService = ApplicationContextUtil.getBean("preSaleAcctItemAttrService");
        List<PreSaleAcctItemAttr> acctItemAttrs = preSaleAcctItemAttrService.queryPreSaleAcctItemAttr(map);
        if (acctItemAttrs != null && acctItemAttrs.size() > 0) {
        	for (PreSaleAcctItemAttr acctItemAttr : acctItemAttrs) {
        		acctItemAttr.remove();
        	}
        }
		return super.remove(acctItem);
	}

	@Override
	public void cancelOrderForAcctItem(PreSaleOrder preSaleOrder) {
		PreSaleAcctItem p = new PreSaleAcctItem();
		p.setPreOrderId(preSaleOrder.getPreOrderId());
		p.setShardingId(preSaleOrder.getPreOrderId());
		List<PreSaleAcctItem> list = queryPreSaleAcctItem(p);
		if (list != null && list.size() >0) {
			for (PreSaleAcctItem preSaleAcctItem : list) {
				if (IntfConstant.PRE_SALE_ACCT_ITEM_STATUS_PAY.getValue().equals(preSaleAcctItem.getStatusCd())) {
					preSaleAcctItem.setStatusCd(IntfConstant.PRE_SALE_ACCT_ITEM_STATUS_REPAY.getValue());
				} else if (IntfConstant.PRE_SALE_ACCT_ITEM_STATUS_NO_PAY.getValue().equals(preSaleAcctItem.getStatusCd())) {
					preSaleAcctItem.setStatusCd(IntfConstant.PRE_SALE_ACCT_ITEM_STATUS_CANCEL.getValue());
				}
				preSaleAcctItem.update();
			}
		}

	}

}
