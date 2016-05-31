package com.ffcs.crmd.cas.dat.api.facade;

import java.util.List;

import com.ffcs.crmd.cas.order.api.dto.PreSaleOrderProcDTO;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderProc;

public interface IPreSaleOrderProcDatFacade {
	 /**
     * 查询预受理单处理过程
     * @author linguangaho 2016/4/20
     * return 
     */
    public List<PreSaleOrderProcDTO> queryPreSaleOrderProc(PreSaleOrderProc proc);
}
