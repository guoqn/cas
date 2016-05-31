package com.ffcs.crmd.cas.sys.facade.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.base.cache.LocalCache;
import com.ffcs.crmd.cas.constants.PubConstant;
import com.ffcs.crmd.cas.core.ddd.api.dto.TreeNodeDTO;
import com.ffcs.crmd.cas.core.ddd.api.dto.TreeNodeStateDTO;
import com.ffcs.crmd.cas.core.ddd.facade.impl.CrmdBaseFacade;
import com.ffcs.crmd.cas.sys.api.dto.CommonRegionDTO;
import com.ffcs.crmd.cas.sys.api.facade.ICommonRegionFacade;
import com.ffcs.crmd.cas.sys.entity.CommonRegion;
import com.ffcs.crmd.cas.sys.service.ICommonRegionService;
import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 区域Facade类.
 *
 * @author huangchuanmao 2015-11-04
 */
@Service("commonRegionFacade")
public class CommonRegionFacadeImpl extends CrmdBaseFacade implements
        ICommonRegionFacade {
    /**
     * 本地缓存.
     */
    private LocalCache localCache = LocalCache.getInstance();

    /**
     * 区域Service类.
     */
    @Resource
    private ICommonRegionService commonRegionService;

    /**
     * 根据区域标识获取区域.
     *
     * @author huangchuanmao 2015-11-04
     */
    @Override
    public CommonRegionDTO getCommonRegionByCommonRegionId(Long commonRegionId) {
        // 先取本地缓存
        StringBuffer key = new StringBuffer();
        key.append(this.hashCode()).append("|")
                .append("getCommonRegionByCommonRegionId").append("|")
                .append(commonRegionId);
        if (this.localCache.contains(key.toString())) {
            return (CommonRegionDTO) this.localCache.get(key.toString());
        }
        CommonRegionDTO commonRegionDTO = null;

        CommonRegion commonRegion = this.commonRegionService
                .getCommonRegionByCommonRegionId(commonRegionId);
        if (commonRegion != null) {
            commonRegionDTO = new CommonRegionDTO();
            CrmBeanUtils.applyIf(commonRegionDTO, commonRegion);
        }
        this.localCache.put(key.toString(), commonRegionDTO);

        return commonRegionDTO;
    }

    /**
     * 根据区域标识获取父子两级区域.
     *
     * @author huangchuanmao 2015-11-04
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<TreeNodeDTO> queryTreeNodeByCommonRegionId(Long commonRegionId) {
        // 先取本地缓存
        StringBuffer key = new StringBuffer();
        /*key.append(this.hashCode()).append("|")
                .append("queryTreeNodeByCommonRegionId").append("|")
                .append(commonRegionId);
        if (this.localCache.containsKey(key.toString())) {
            return (List<TreeNodeDTO>) this.localCache.get(key.toString());
        }*/
        List<TreeNodeDTO> listTreeNodeDTO = new ArrayList<TreeNodeDTO>();

        if (commonRegionId == null) {
            // 空值则默认福建省
            commonRegionId = NumberUtils
                    .nullToLongZero(PubConstant.COMMON_REGION_ID_FJ.getValue());
        }
        CommonRegion commonRegion1 = this.commonRegionService
                .getCommonRegionByCommonRegionId(commonRegionId);
        if (commonRegion1 != null) {
            listTreeNodeDTO.add(this
                    .convertCommonRegionToTreeNode(commonRegion1));
            List<Long> listUpRegionId2 = new ArrayList<Long>();
            listUpRegionId2.add(commonRegion1.getCommonRegionId());
            List<CommonRegion> listCommonRegion2 = this.commonRegionService
                    .queryCommonRegionByListUpRegionId(listUpRegionId2);
            if (listCommonRegion2 != null && listCommonRegion2.size() > 0) {
                for (CommonRegion commonRegion2 : listCommonRegion2) {
                    listTreeNodeDTO.add(this
                            .convertCommonRegionToTreeNode(commonRegion2));
                }
                List<Long> listUpRegionId3 = this
                        .convertListCommonRegionId(listCommonRegion2);
                List<CommonRegion> listCommonRegion3 = this.commonRegionService
                        .queryCommonRegionByListUpRegionId(listUpRegionId3);
                if (listCommonRegion3 != null && listCommonRegion3.size() > 0) {
                    for (CommonRegion commonRegion3 : listCommonRegion3) {
                        listTreeNodeDTO.add(this
                                .convertCommonRegionToTreeNode(commonRegion3));
                    }
                }
            }
        }
        /*this.localCache.put(key.toString(), listTreeNodeDTO, "CommonRegion");*/

        return listTreeNodeDTO;
    }

    /**
     * 根据父级区域标识获取子级区域.
     *
     * @author huangchuanmao 2015-11-04
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<TreeNodeDTO> queryTreeNodeByUpRegionId(Long upRegionId) {
        // 先取本地缓存
        String key = LocalCache.genKey("queryTreeNodeByUpRegionId", upRegionId + "");
        if (this.localCache.contains(key.toString())) {
            return (List<TreeNodeDTO>) this.localCache.get(key.toString());
        }
        List<TreeNodeDTO> listTreeNodeDTO = new ArrayList<TreeNodeDTO>();

        List<CommonRegion> listCommonRegion = this.commonRegionService
                .queryCommonRegionByUpRegionId(upRegionId);
        if (listCommonRegion != null && listCommonRegion.size() > 0) {
            for (CommonRegion commonRegion : listCommonRegion) {
                listTreeNodeDTO.add(this
                        .convertCommonRegionToTreeNode(commonRegion));
            }
        }
        this.localCache.put(key.toString(), listTreeNodeDTO);

        return listTreeNodeDTO;
    }

    /**
     * 区域转换成列表.
     *
     * @author huangchuanmao 2015-11-04
     */
    private List<Long> convertListCommonRegionId(
            List<CommonRegion> listCommonRegion) {
        List<Long> listCommonRegionId = null;
        //
        if (listCommonRegion == null || listCommonRegion.size() <= 0) {
            return listCommonRegionId;
        }

        listCommonRegionId = new ArrayList<Long>();
        for (CommonRegion commonRegion : listCommonRegion) {
            listCommonRegionId.add(commonRegion.getCommonRegionId());
        }

        return listCommonRegionId;
    }

    /**
     * 区域转换层树节点.
     *
     * @author huangchuanmao 2015-11-04
     */
    private TreeNodeDTO convertCommonRegionToTreeNode(CommonRegion commonRegion) {
        TreeNodeDTO treeNodeDTO = new TreeNodeDTO();

        treeNodeDTO
                .setId(StringUtils.strnull(commonRegion.getCommonRegionId()));
        String str = StringUtils.strnull(commonRegion.getUpRegionId());
        // 父节点为#
        treeNodeDTO.setParent(StringUtils.isNullOrEmpty(str) ? "#" : str);
        treeNodeDTO.setText(commonRegion.getRegionName());
        TreeNodeStateDTO treeNodeStateDTO = new TreeNodeStateDTO();
        treeNodeStateDTO.setOpened(false);
        treeNodeStateDTO.setSelected(false);
        treeNodeStateDTO.setLoaded(true);
        treeNodeDTO.setState(treeNodeStateDTO);
        return treeNodeDTO;
    }

    @Override
    public String getRegionName(Long commonRegionId) {
        CommonRegion commonRegion = commonRegionService.get(commonRegionId);
        return commonRegion == null ? "" : commonRegion.getRegionName();
    }

    @Override
    public PageInfo qryCommonRegionByName(CommonRegionDTO dto) {
        CommonRegion commonRegion = new CommonRegion();
        try {
            BeanUtils.applyIf(commonRegion,dto,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageInfo<CommonRegion> pageInfo = commonRegionService.qryCommonRegionByName(commonRegion ,dto.getPageNumber(),dto.getPageSize());
        if (pageInfo != null && pageInfo.getList() != null
                && pageInfo.getList().size() > 0) {
            List commonRegionDTOs = CrmBeanUtils.copyList(
                    pageInfo.getList(), CommonRegionDTO.class);
            pageInfo.setList(commonRegionDTOs);
        }
        return pageInfo == null ? new PageInfo<>() : pageInfo;
    }
}
