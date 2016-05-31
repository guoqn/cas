package com.ffcs.crmd.cas.sys.service.impl;

import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.sys.entity.StaffPosition;
import com.ffcs.crmd.cas.sys.repository.IStaffPositionRepository;
import com.ffcs.crmd.cas.sys.service.IStaffPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("staffPositionService")
public class StaffPositionServiceImpl extends AbsCrmdGenericServiceImpl<StaffPosition, Long>
    implements IStaffPositionService {

   	@Autowired
	IStaffPositionRepository staffPositionRepository;

	@Override
	public List<StaffPosition> queryStaffPosition(Map param) {

		return staffPositionRepository.queryStaffPosition(param);
	}
}
