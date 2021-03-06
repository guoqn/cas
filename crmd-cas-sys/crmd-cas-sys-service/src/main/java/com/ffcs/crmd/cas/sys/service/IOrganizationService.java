package com.ffcs.crmd.cas.sys.service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.service.ICrmdGenericService;
import com.ffcs.crmd.cas.sys.entity.Organization;

import java.util.List;
import java.util.Map;

public interface IOrganizationService extends ICrmdGenericService<Organization, Long> {

	/**
	 * 团队信息获取.
	 * @param params
	 * @param page
	 * @param pageSize
	 * @return
	 * @author Luxb
	 * 2016年1月4日 Luxb
	 */
	PageInfo<Organization> qryOrg(Map<String, Object> params, int page, int pageSize);

	List<Organization> qryOrgList(Map<String, Object> params);

	/**
	 * 獲取團隊樹數據.
	 * @param orgId
	 * @return
	 * @author Luxb
	 * 2016年1月7日 Luxb
	 */
	List<Organization> qryOrgTree(Long orgId);

	/**
	 * 根据员工获取关联的团队信息
	 * @param staffId
	 * @return
     */
	List<Organization> qryPreOrderDisList(Long staffId);

	/**
	 * 查询团队信息
	 * @author YULIYAO 2016/4/29
	 * return 
	 */
	List<Organization> queryOrganization(Map param);
	/**
	 * 工单池预受理团队.
	 * 
	 * @param params
	 * @param page
	 * @param pageSize
	 * @return
	 */
	PageInfo qryOrganizaztionPageInfoByIdsAndParams(Map<String, Object> params, int page, int pageSize);
}
