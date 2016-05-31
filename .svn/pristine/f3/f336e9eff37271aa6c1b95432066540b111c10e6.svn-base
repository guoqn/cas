package com.ffcs.crmd.cas.order.service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.service.ICrmdGenericService;
import com.ffcs.crmd.cas.order.entity.AutoGenOrder;

import java.util.List;
import java.util.Map;

public interface IAutoGenOrderService extends ICrmdGenericService<AutoGenOrder, Long> {

    /**
     * 根据预受理单编号删除自动受理
     * @author YULIYAO 2016/1/20
     * return
     */
    public int removeAutoGenOrder(String preOrderNumber);

    AutoGenOrder getOrderByPreOrderNumber(String preOrderNumber);

    /**
     * 查询自动受理信息
     * @author YULIYAO 2016/3/15
     * return 
     */
    List<AutoGenOrder> queryAutoGenOrder(Map param);

    PageInfo queryAutoGenOrder(Map param, int pageNumber, int pageSize);

    /**
     * 轮洵查询：创建状态，关联的P单为待受理，关联的工单池接收员工为空或者是接口工号
     * @author YULIYAO 2016/3/15
     * return
     */
    PageInfo queryAutoGenOrderSentPk(int modelCount, int model, int pageSize);
}
