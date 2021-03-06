package com.ffcs.crmd.cas.order.service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.service.ICrmdGenericService;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderPool;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderPoolHis;
import com.ffcs.crmd.cas.order.vo.PreSaleOrderOverTimeListVo;
import com.ffcs.crmd.cas.order.vo.PreSaleOrderPoolVo;

import java.util.List;
import java.util.Map;

public interface IPreSaleOrderPoolService extends ICrmdGenericService<PreSaleOrderPool, Long> {

    /**
     * 根据预受理单ID查询工单池，取第一条
     * @author YULIYAO 2016/1/20
     * return 
     */
    PreSaleOrderPool getPreSaleOrderPoolByOrderId(Long preOrderId);

    PageInfo queryPreSaleOrderPool(PreSaleOrderPoolVo vo);

    List<PreSaleOrderPool> queryPreSaleOrderPoolList(PreSaleOrderPoolVo vo);

    int queryPreSaleOrderPoolAmount(PreSaleOrderPoolVo vo);

    /**
     * 根据预受理单ID，查询工单池
     * @author YULIYAO 2016/3/15
     * return
     */
    PreSaleOrderPool getByPreOrderId(Long preOrderId);
    /**
     * 根据预受理单ID查询工单池历史记录，取第一条
     * return
     */
    PreSaleOrderPoolHis getPreSaleOrderPoolHisByOrderId(Long preOrderId);

    /**
     * 查询工单池初始界面区域控件
     * @author YULIYAO 2016/5/11
     * return
     */
    PageInfo queryInitPoolRegion(Map param, int pageNum, int pageSize);
    /**
     * 超时预警清单
     * @param map
     * @return
     * @author linguanghao
     */
    List<PreSaleOrderOverTimeListVo> qryPreSaleOrderOverTimeList(Map map);
}
