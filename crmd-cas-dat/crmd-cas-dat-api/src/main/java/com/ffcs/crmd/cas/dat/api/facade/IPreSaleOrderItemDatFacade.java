package com.ffcs.crmd.cas.dat.api.facade;

import java.util.List;
import java.util.Map;

import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderItemDTO;

public interface IPreSaleOrderItemDatFacade {
	/**
     * 查询预受理订单项
     * @author linguanghao 2016/4/20
     * return 
     */
    public List<PreSaleOrderItemDTO> queryPreOrderItem(Map param);
}
