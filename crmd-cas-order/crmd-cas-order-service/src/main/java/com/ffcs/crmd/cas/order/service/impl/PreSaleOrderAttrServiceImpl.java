package com.ffcs.crmd.cas.order.service.impl;

import com.ctg.itrdc.platform.common.utils.type.CollectionUtils;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderAttr;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderAttrHis;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderAttrRepository;
import com.ffcs.crmd.cas.order.service.IPreSaleOrderAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("preSaleOrderAttrService")
public class PreSaleOrderAttrServiceImpl extends AbsCrmdGenericServiceImpl<PreSaleOrderAttr, Long>
    implements IPreSaleOrderAttrService {

    @Autowired
    IPreSaleOrderAttrRepository preSaleOrderAttrRepository;

    @Override
    public PreSaleOrderAttr getByOrderAndAttrId(Long preOrderId, Long attrId) {
        Map map = new HashMap();
        map.put("preOrderId", preOrderId);
        map.put("shardingId", preOrderId);
        map.put("attrId", attrId);
        List<PreSaleOrderAttr> preSaleOrderAttrs = PreSaleOrderAttr.repository()
            .queryPreSaleOrderAttr(map);
        if (CollectionUtils.isNotEmpty(preSaleOrderAttrs)) {
            return preSaleOrderAttrs.get(0);
        }
        return null;
    }

    @Override
    public PreSaleOrderAttrHis getHisByOrderAndAttrId(Long preOrderId, Long attrId) {
        Map map = new HashMap();
        map.put("preOrderId", preOrderId);
        map.put("shardingId", preOrderId);
        map.put("attrId", attrId);
        List<PreSaleOrderAttrHis> preSaleOrderAttrs = preSaleOrderAttrRepository
                .queryPreSaleOrderAttrHis(map);
        if (CollectionUtils.isNotEmpty(preSaleOrderAttrs)) {
            return preSaleOrderAttrs.get(0);
        }
        return null;
    }
    @Override
    public int removeByOrderId(Long preOrderId) {
    	int result = 0;
    	if (preOrderId != null) {
    		List<PreSaleOrderAttr> attrs = this.getAttrsByOrderId(preOrderId);
    		if (attrs != null && attrs.size() > 0) {
    			for (PreSaleOrderAttr attr : attrs) {
    				result += attr.remove();
    			}
    		}
    	}
    	return result;
    }
    @Override
    public List<PreSaleOrderAttr> getAttrsByOrderId(Long preOrderId) {
    	Map<String, Object> map = new HashMap<String, Object>();
        map.put("preOrderId", preOrderId);
        map.put("shardingId", preOrderId);
        return PreSaleOrderAttr.repository().queryPreSaleOrderAttr(map);
    }
}
