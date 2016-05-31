package com.ffcs.crmd.cas.sys.repository.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.sys.entity.Staff;
import com.ffcs.crmd.cas.sys.repository.IStaffRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("staffRepository")
public class StaffRepositoryImpl extends AbsCrmdBaseRepositoryImpl<Staff, Long>
    implements IStaffRepository {

    public StaffRepositoryImpl() {
        super(Staff.class);
    }

	@Override
	public PageInfo<Staff> qryStaff(Map<String, Object> params, int page, int pageSize) {
		return this.queryPageInfoByName("staffRepository.qryStaff", Staff.class, params, page, pageSize);
	}

	@Override
	public List<Staff> qryStaffList(Map map) {
		return this.queryListByName("staffRepository.qryStaffList", Staff.class, map);
	}
}
