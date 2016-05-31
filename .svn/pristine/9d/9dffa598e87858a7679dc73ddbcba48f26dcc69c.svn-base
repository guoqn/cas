package com.ffcs.crmd.cas.sys.repository;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.repository.ICrmdBaseRepository;
import com.ffcs.crmd.cas.sys.entity.CommonRegion;

import java.util.List;
import java.util.Map;

/**
 * 区域Repository类.
 *
 * @author
 */
public interface ICommonRegionRepository extends
        ICrmdBaseRepository<CommonRegion, Long> {
    /**
     * 根据父级区域标识查询子级区域.
     *
     * @author
     */
    List<CommonRegion> queryCommonRegionByUpRegionId(Long upRegionId);

    /**
     * 根据父级区域标识查询子级区域.
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
     *
     * @author YULIYAO 2016/5/17
     * return 
     */
    List<CommonRegion> qryCommonRegion(Map param);
}
