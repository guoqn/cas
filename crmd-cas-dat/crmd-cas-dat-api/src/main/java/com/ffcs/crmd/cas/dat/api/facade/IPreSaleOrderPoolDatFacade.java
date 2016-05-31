package com.ffcs.crmd.cas.dat.api.facade;

import java.util.List;
import java.util.Map;

import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderPoolDTO;

public interface IPreSaleOrderPoolDatFacade {
	/**
     * 查询预受理工单池
     * @author linguanghao 2016/4/20
     * return 
     */
    List<PreSaleOrderPoolDTO> queryPreSaleOrderPool(Map param);
}
