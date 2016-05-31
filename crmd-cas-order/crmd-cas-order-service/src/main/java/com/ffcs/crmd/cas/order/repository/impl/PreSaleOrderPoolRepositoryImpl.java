package com.ffcs.crmd.cas.order.repository.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.pub.sqlext.SqlRegister;
import com.ctg.itrdc.platform.pub.sqlext.SqlRegisterFactory;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderPoolHis;
import com.ffcs.crmd.platform.data.sqlext.impl.CrmSqlRegister;
import org.springframework.stereotype.Repository;

import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderPool;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderPoolRepository;
import com.ffcs.crmd.cas.order.vo.PreSaleOrderOverTimeListVo;

import java.util.List;
import java.util.Map;

@Repository("preSaleOrderPoolRepository")
public class PreSaleOrderPoolRepositoryImpl extends AbsCrmdBaseRepositoryImpl<PreSaleOrderPool, Long>
    implements IPreSaleOrderPoolRepository {

    public PreSaleOrderPoolRepositoryImpl() {
        super(PreSaleOrderPool.class);
    }

    protected SqlRegister sqlRegister = SqlRegisterFactory.getSqlRegister();

    @Override
    public List<PreSaleOrderPool> queryPreSaleOrderPool(Map param) {
        return this
            .queryListByName("preSaleOrderRepository.queryPreSaleOrderPool", PreSaleOrderPool.class,
                param);
    }

    @Override
    public PageInfo queryPreSaleOrderPool(Map param,int pageNum,int pageSize) {
        return this
            .queryPageInfoByName("preSaleOrderRepository.queryPreSaleOrderPool",
                PreSaleOrderPool.class,
                param, pageNum, pageSize);
    }

    @Override
    public int queryPreSaleOrderPoolAmount(Map param) {
        if(this.sqlRegister instanceof CrmSqlRegister) {
            Object[] obj = ((CrmSqlRegister)this.sqlRegister).getSql("preSaleOrderRepository.queryPreSaleOrderPool", param);
            if(obj != null && obj.length == 2) {
                return this.jdbcGetSize(obj[0].toString(), (List) obj[1]);
            }
        }
        return 0;
    }

    @Override
    public List<PreSaleOrderPoolHis> queryPreSaleOrderPoolHis(Map param) {
        return this
                .queryListByName("preSaleOrderRepository.queryPreSaleOrderPoolHis", PreSaleOrderPoolHis.class,
                        param);
    }

	@Override
	public List<PreSaleOrderOverTimeListVo> qryPreSaleOrderOverTimeList(Map map) {
		return this
                .queryListByName("preSaleOrderRepository.qryPreSaleOrderOverTimeList", PreSaleOrderOverTimeListVo.class,
                		map);
	}

	@Override
	public List<PreSaleOrderOverTimeListVo> qryPreSaleOrderOverTimeListHis(Map map) {
		return this
                .queryListByName("preSaleOrderRepository.qryPreSaleOrderOverTimeListHis", PreSaleOrderOverTimeListVo.class,
                		map);
	}
}
