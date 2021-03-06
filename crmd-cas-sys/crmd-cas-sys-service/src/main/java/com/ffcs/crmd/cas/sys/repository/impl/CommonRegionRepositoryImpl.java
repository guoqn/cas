package com.ffcs.crmd.cas.sys.repository.impl;


import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.sys.entity.CommonRegion;
import com.ffcs.crmd.cas.sys.repository.ICommonRegionRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 区域Repository类.
 *
 * @author
 */
@Repository("commonRegionRepository")
public class CommonRegionRepositoryImpl extends
        AbsCrmdBaseRepositoryImpl<CommonRegion, Long> implements
        ICommonRegionRepository {
    /**
     * 默认构造函数.
     */
    public CommonRegionRepositoryImpl() {
        super(CommonRegion.class);
    }

    /**
     * 根据父级区域标识查询子级区域.
     *
     * @author
     */
    @Override
    public List<CommonRegion> queryCommonRegionByUpRegionId(Long upRegionId) {
        List<CommonRegion> listCommonRegion = null;
        // 空值判断
        if (upRegionId == null) {
            return listCommonRegion;
        }
        List<Object> listParam = new ArrayList<Object>();

        listParam.add(upRegionId);
        listParam.add(CasConstant.STATUS_CD_VAILID.getValue());
        listCommonRegion = this.jdbcFindListByName(
                "commonRegionRepository.queryCommonRegionByUpRegionId",
                CommonRegion.class, listParam);

        return listCommonRegion;
    }

    /**
     * 根据父级区域标识查询子级区域.
     *
     * @author
     */
    @Override
    public List<CommonRegion> queryCommonRegionByListUpRegionId(
            List<Long> listUpRegionId) {
        List<CommonRegion> listCommonRegion = null;
        // 空值判断
        if (listUpRegionId == null || listUpRegionId.size() <= 0) {
            return listCommonRegion;
        }
        Map<String, Object> params = new HashMap<String, Object>();
        List<Long> listParam = new ArrayList<Long>();
        
        StringBuffer stringBuffer = new StringBuffer();
        for (Long upRegionId : listUpRegionId) {
        	listParam.add(upRegionId);
            //stringBuffer.append(upRegionId).append(",");
        }
        if (listParam.size() >0) {
        	params.put("upRegionId", listParam);
        }
        if (!StringUtils.isNullOrEmpty(stringBuffer)) {
            stringBuffer.setLength(stringBuffer.length() - 1);
        }
        
        //listParam.add(stringBuffer.toString());
        //listParam.add(CasConstant.STATUS_CD_VAILID.getValue());
        params.put("statusCd", CasConstant.STATUS_CD_VAILID.getValue());
        listCommonRegion = this.queryListByName(
                "commonRegionRepository.queryCommonRegionByListUpRegionId",
                CommonRegion.class, params);

        return listCommonRegion;
    }

    @Override
    public PageInfo<CommonRegion> qryCommonRegionByName(CommonRegion commonRegion, int pageNumber, int pageSize) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (!StringUtils.isNullOrEmpty(commonRegion.getRegionName())) {
            params.put("regionName", "%" + commonRegion.getRegionName() + "%");
        }
        if (!StringUtils.isNullOrEmpty(commonRegion.getUpRegionId())){
            params.put("upRegionId",commonRegion.getUpRegionId());
        }
        if (!StringUtils.isNullOrEmpty(commonRegion.getCommonRegionId())){
            params.put("commonRegionId",commonRegion.getCommonRegionId());
        }
        return this.queryPageInfoByName("commonRegionRepository.qryByMap", CommonRegion.class, params, pageNumber,
                pageSize);
    }

    @Override
    public List<CommonRegion> qryCommonRegion(Map param) {
        return this.queryListByName("commonRegionRepository.qryByMap", CommonRegion.class, param);
    }
}
