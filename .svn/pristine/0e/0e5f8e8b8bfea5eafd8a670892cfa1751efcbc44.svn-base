package com.ffcs.crmd.cas.sys.service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.service.ICrmdGenericService;
import com.ffcs.crmd.cas.sys.entity.CommonRegion;

import java.util.List;
import java.util.Map;

/**
 * 区域Service类.
 *
 * @author
 */
public interface ICommonRegionService extends
        ICrmdGenericService<CommonRegion, Long> {
    /**
     * 根据区域标识获取区域.
     *
     * @author
     */
    CommonRegion getCommonRegionByCommonRegionId(Long commonRegionId);

    /**
     * 根据父级区域标识获取子级区域.
     *
     * @author
     */
    List<CommonRegion> queryCommonRegionByUpRegionId(Long upRegionId);

    /**
     * 根据父级区域标识获取子级区域.
     *
     * @author
     */
    List<CommonRegion> queryCommonRegionByListUpRegionId(
            List<Long> listUpRegionId);

    /**
     * 根据名称查询
     * @param commonRegion
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<CommonRegion> qryCommonRegionByName(CommonRegion commonRegion, int pageNumber, int pageSize);

    /**
     * 批量查询区域名称
     * @author YULIYAO 2016/5/17
     * return 
     */
    List<CommonRegion> queryCommonRegion(Map param);
}
