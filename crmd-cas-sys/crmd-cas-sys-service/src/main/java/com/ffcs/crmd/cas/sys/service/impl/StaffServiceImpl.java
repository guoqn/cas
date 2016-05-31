package com.ffcs.crmd.cas.sys.service.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.sys.entity.Staff;
import com.ffcs.crmd.cas.sys.repository.IStaffRepository;
import com.ffcs.crmd.cas.sys.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("staffService")
public class StaffServiceImpl extends AbsCrmdGenericServiceImpl<Staff, Long>
    implements IStaffService {

   	@Autowired
	IStaffRepository staffRepository;

	@Override
	public PageInfo<Staff> qryStaff(Map<String, Object> params, int page, int pageSize) {
		return staffRepository.qryStaff(params , page , pageSize);
	}

	@Override
	public List<Staff> qryStaffList(Map map) {
		return staffRepository.qryStaffList(map);
	}
}
