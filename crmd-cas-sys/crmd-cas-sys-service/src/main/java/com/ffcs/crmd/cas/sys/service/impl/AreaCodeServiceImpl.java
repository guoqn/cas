package com.ffcs.crmd.cas.sys.service.impl;

import com.ctg.itrdc.platform.common.utils.type.CollectionUtils;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.sys.entity.AreaCode;
import com.ffcs.crmd.cas.sys.repository.IAreaCodeRepository;
import com.ffcs.crmd.cas.sys.service.IAreaCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("areaCodeService")
public class AreaCodeServiceImpl extends AbsCrmdGenericServiceImpl<AreaCode, Long>
    implements IAreaCodeService {

   	@Autowired
	IAreaCodeRepository areaCodeRepository;

	@Override
	public AreaCode getAreaCodeByRegionId(Long regionId) {
		Map params = new HashMap<>();
		params.put("regionId", regionId);
		List<AreaCode> areaCodeList = areaCodeRepository.queryAreaCode(params);
		if (CollectionUtils.isNotEmpty(areaCodeList)) {
			return areaCodeList.get(0);
		}
		return null;
	}
}
