package com.ffcs.crmd.cas.order.repository;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.repository.ICrmdBaseRepository;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderProc;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderProcAttr;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderProcHis;
import com.ffcs.crmd.cas.order.vo.PreSaleOrderProcForIntfVo;

import java.util.List;
import java.util.Map;

public interface IPreSaleOrderProcRepository extends ICrmdBaseRepository<PreSaleOrderProc, Long> {

    /**
     * 查询预受理单处理过程
     * @author YULIYAO 2016/1/12
     * return 
     */
    public List<PreSaleOrderProc> queryPreSaleOrderProc(PreSaleOrderProc proc);

    /**
     * 查询预受理单处理过程,分页
     * @author YULIYAO 2016/1/12
     * return
     */
    public PageInfo queryPreSaleOrderProcPage(PreSaleOrderProc proc, int pageNumber, int pageSize);

    PageInfo queryPreSaleOrderProcWithAttr(PreSaleOrderProc vo, int pageNumber, int pageSize);

    /**
     * 查询预受理单历史处理过程
     * @param proc
     * @return
     */
    List<PreSaleOrderProcHis> queryPreSaleOrderProcHis(PreSaleOrderProc proc);

    /**
     * 查询处理过程属性
     * @author YULIYAO 2016/4/7
     * return
     */
    List<PreSaleOrderProcAttr> queryPreSaleOrderProcAttr(Map map);
    /**
     * 工单处理情况清单
     * @param map
     * @return
     * @author linguanghao
     */
    List<PreSaleOrderProcForIntfVo> qryPreSaleOrderProcForIntf(Map map);
    /**
     * 工单处理情况清单(二表)
     * @param map
     * @return
     * @author linguanghao
     */
    List<PreSaleOrderProcForIntfVo> qryPreSaleOrderProcHisForIntf(Map map);
}
