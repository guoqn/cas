package com.ffcs.crmd.cas.sys.service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.service.ICrmdGenericService;
import com.ffcs.crmd.cas.sys.entity.Staff;

import java.util.List;
import java.util.Map;

public interface IStaffService extends ICrmdGenericService<Staff, Long> {
	/**
	 * 根据条件获取员工信息.
	 * @param params
	 * @param page
	 * @param pageSize
     * @return
	 * @author Luxb
	 * 2016年1月7日 Luxb
     */
	PageInfo<Staff> qryStaff(Map<String, Object> params, int page, int pageSize);

	/**
	 *
	 * @param map
	 * @return
     */
	List<Staff> qryStaffList(Map map);
}
