package com.ffcs.crmd.cas.sys.service.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.sys.entity.CommonRegion;
import com.ffcs.crmd.cas.sys.repository.ICommonRegionRepository;
import com.ffcs.crmd.cas.sys.service.ICommonRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 区域Service类.
 *
 * @author
 */
@Service("commonRegionService")
public class CommonRegionServiceImpl extends
        AbsCrmdGenericServiceImpl<CommonRegion, Long> implements
        ICommonRegionService {
    @Autowired
    private ICommonRegionRepository commonRegionRepository;
    /**
     * 根据区域标识获取区域.
     *
     * @author
     */
    @Override
    public CommonRegion getCommonRegionByCommonRegionId(Long commonRegionId) {
        return CommonRegion.repository().getById(commonRegionId);
    }

    /**
     * 根据父级区域标识获取子级区域.
     *
     * @author
     */
    @Override
    public List<CommonRegion> queryCommonRegionByUpRegionId(Long upRegionId) {
        return CommonRegion.repository().queryCommonRegionByUpRegionId(
                upRegionId);
    }

    /**
     * 根据父级区域标识获取子级区域.
     *
     * @author
     */
    @Override
    public List<CommonRegion> queryCommonRegionByListUpRegionId(
            List<Long> listUpRegionId) {
        return CommonRegion.repository().queryCommonRegionByListUpRegionId(
                listUpRegionId);
    }

    @Override
    public PageInfo<CommonRegion> qryCommonRegionByName(CommonRegion commonRegion, int pageNumber, int pageSize) {
        return commonRegionRepository.qryCommonRegionByName(commonRegion,pageNumber,pageSize);
    }

    /**
     * 批量查询区域名称
     * @author YULIYAO 2016/5/17
     * return
     */
    @Override
    public List<CommonRegion> queryCommonRegion(Map param) {
        return commonRegionRepository.qryCommonRegion(param);
    }

}
