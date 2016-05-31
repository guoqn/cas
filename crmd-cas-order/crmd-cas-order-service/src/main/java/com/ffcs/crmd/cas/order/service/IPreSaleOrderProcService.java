package com.ffcs.crmd.cas.order.service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.service.ICrmdGenericService;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderProcAttr;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderProcHis;
import com.ffcs.crmd.cas.order.vo.PreSaleOrderProcForIntfVo;
import com.ffcs.crmd.cas.order.vo.PreSaleOrderProcVo;
import com.ffcs.crmd.cas.order.entity.PreSaleOrder;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderProc;
import com.ffcs.crmd.cas.sys.api.dto.StaffDTO;

import java.util.List;
import java.util.Map;

public interface IPreSaleOrderProcService extends ICrmdGenericService<PreSaleOrderProc, Long> {

    /**
     * 查询预受理订单处理过程
     * @author YULIYAO 2016/1/12
     * return 
     */
    public List<PreSaleOrderProc> queryPreSaleOrderProc(PreSaleOrderProc proc);

    /**
     * 查询预受理订单处理过程，分页
     * @author YULIYAO 2016/1/13
     * return 
     */
    public PageInfo queryPreSaleOrderProcPage(PreSaleOrderProc proc, int pageNumber, int pageSize);

    PageInfo queryPreSaleOrderProcPageWithAttr(PreSaleOrderProc proc, int pageNumber, int pageSize);

    /**
     * 删除预受理单ID关联的所有处理过程
     * @author YULIYAO 2016/1/20
     * return 
     */
    public int removeByOrderId(Long preOrderId);

    /**
     * 预受理订单过程属性创建。
     * @param preSaleOrder
     * @param eventId
     * @return
     */
    int createPreSaleOrderProc(PreSaleOrder preSaleOrder, Long eventId, List<PreSaleOrderProcVo> vos, StaffDTO staffDTO);

    /**
     * 查询预受理订单处理过程
     * @author YULIYAO 2016/1/12
     * return
     */
    List<PreSaleOrderProcHis> queryPreSaleOrderProcHis(PreSaleOrderProc proc);

    /**
     * 获取最后一条退单属性
     * @author YULIYAO 2016/4/7
     * return
     */
    PreSaleOrderProcAttr getLastBackProcAttr(Long preOrderId);
    /**
     * 工单处理情况清单
     * @param map
     * @return
     * @author linguanghao
     */
    List<PreSaleOrderProcForIntfVo> qryPreSaleOrderProcForIntf(Map map);
}
