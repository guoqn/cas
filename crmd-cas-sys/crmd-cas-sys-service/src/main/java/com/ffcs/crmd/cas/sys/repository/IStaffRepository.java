package com.ffcs.crmd.cas.sys.repository;


import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.repository.ICrmdBaseRepository;
import com.ffcs.crmd.cas.sys.entity.Staff;

import java.util.List;
import java.util.Map;

public interface IStaffRepository extends ICrmdBaseRepository<Staff,Long>  {
	/**
	 * 根據條件查詢員工信息.
	 * @param params
	 * @param page
	 * @param pageSize
     * @return
	 * @author Luxb
	 * 2016年1月7日 Luxb
     */
	PageInfo<Staff> qryStaff(Map<String, Object> params, int page, int pageSize);

	/**
	 * 根据OrgId查询员工列表。
	 * @param map
	 * @return
     */
	List<Staff> qryStaffList(Map map);
}
