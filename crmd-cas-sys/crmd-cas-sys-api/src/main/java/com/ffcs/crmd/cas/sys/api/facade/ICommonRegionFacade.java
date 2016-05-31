package com.ffcs.crmd.cas.sys.api.facade;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.api.dto.TreeNodeDTO;
import com.ffcs.crmd.cas.core.ddd.api.facade.ICrmdBaseFacade;
import com.ffcs.crmd.cas.sys.api.dto.CommonRegionDTO;

import java.util.List;

/**
 * 区域Facade类.
 *
 * @author liujr 2016-1-09
 */
public interface ICommonRegionFacade extends ICrmdBaseFacade {
    /**
     * 根据区域标识获取区域.
     *
     * @author liujr 2016-1-09
     */
    CommonRegionDTO getCommonRegionByCommonRegionId(Long commonRegionId);

    /**
     * 根据区域标识获取父子两级区域.
     *
     * @author liujr 2016-1-09
     */
    List<TreeNodeDTO> queryTreeNodeByCommonRegionId(Long commonRegionId);

    /**
     * 根据父级区域标识获取子级区域.
     *
     * @author liujr 2016-1-09
     */
    List<TreeNodeDTO> queryTreeNodeByUpRegionId(Long upRegionId);

    /**
     * 查询区域名称
     *
     * @param commonRegionId
     * @return
     */
    String getRegionName(Long commonRegionId);

    /**
     * 根据区域名称查询
     * @param dto
     * @return
     */
    PageInfo qryCommonRegionByName(CommonRegionDTO dto);
}
