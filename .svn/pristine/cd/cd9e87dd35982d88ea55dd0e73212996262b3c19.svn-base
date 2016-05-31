package com.ffcs.crmd.cas.order.repository;


import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.repository.ICrmdBaseRepository;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderPool;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderPoolHis;
import com.ffcs.crmd.cas.order.vo.PreSaleOrderOverTimeListVo;

import java.util.List;
import java.util.Map;

public interface IPreSaleOrderPoolRepository extends ICrmdBaseRepository<PreSaleOrderPool,Long>  {

    /**
     * 查询预受理工单池
     * @author YULIYAO 2016/1/20
     * return 
     */
    List<PreSaleOrderPool> queryPreSaleOrderPool(Map param);

    /**
     *
     * @param param
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo queryPreSaleOrderPool(Map param, int pageNum, int pageSize);

    /**
     * 查询预受理工单池数量
     * @param param
     * @return
     */
    int queryPreSaleOrderPoolAmount(Map param);
    /**
     * 查询预受理工单池
     * return
     */
    List<PreSaleOrderPoolHis> queryPreSaleOrderPoolHis(Map param);
    /**
     * 超时预警清单
     * @param map
     * @return
     */
    List<PreSaleOrderOverTimeListVo> qryPreSaleOrderOverTimeList(Map map);
    /**
     * 超时预警清单(二表)
     * @param map
     * @return
     */
    List<PreSaleOrderOverTimeListVo> qryPreSaleOrderOverTimeListHis(Map map);
}
