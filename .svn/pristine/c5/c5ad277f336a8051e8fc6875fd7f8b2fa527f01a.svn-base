package com.ffcs.crmd.cas.order.repository.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.order.entity.AutoGenOrder;
import com.ffcs.crmd.cas.order.repository.IAutoGenOrderRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("autoGenOrderRepository")
public class AutoGenOrderRepositoryImpl extends AbsCrmdBaseRepositoryImpl<AutoGenOrder, Long>
    implements IAutoGenOrderRepository {


    public AutoGenOrderRepositoryImpl() {
        super(AutoGenOrder.class);
    }

    @Override
    public List<AutoGenOrder> queryAutoGenOrder(Map param) {
        return this
            .queryListByName("preSaleOrderRepository.queryAutoGenOrder", AutoGenOrder.class, param);
    }

    @Override
    public PageInfo queryAutoGenOrder(Map param,int pageNumber,int pageSize) {
        return this
            .queryPageInfoByName("preSaleOrderRepository.queryAutoGenOrder", AutoGenOrder.class, param,pageNumber,pageSize);
    }
}
