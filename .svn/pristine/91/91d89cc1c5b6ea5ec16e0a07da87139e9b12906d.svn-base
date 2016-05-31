package com.ffcs.crmd.cas.core.filter;

import java.util.HashMap;
import java.util.Map;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.base.context.CasSessionContext;
import com.ffcs.crmd.platform.pub.proxy.callfilter.impl.AbstractProxyCallFilter;
import org.springframework.stereotype.Component;

@Component("defaultProxyCallFilter")
public class DefaultProxyCallFilter extends AbstractProxyCallFilter {

	@Override
	public Map<String, String> getAppPropsMap() {
		Map<String, String> props = new HashMap<>();
		//区域Id
		if (CasSessionContext.getContext().getAreaId() != null) {
			props.put(CasSessionContext.AREA_ID, StringUtils.strnull(CasSessionContext.getContext().getAreaId()));
		}
		//区域名称.
		if (!StringUtils.isNullOrEmpty(CasSessionContext.getContext().getRegionName())) {
			props.put(CasSessionContext.REGION_NAME, StringUtils.strnull(CasSessionContext.getContext().getRegionName()));
		}
		//渠道编码
		if (!StringUtils.isNullOrEmpty(CasSessionContext.getContext().getChannelCode())) {
			props.put(CasSessionContext.CHANNEL_CODE, StringUtils.strnull(CasSessionContext.getContext().getChannelCode()));
		}
		//团队名称
		if (!StringUtils.isNullOrEmpty(CasSessionContext.getContext().getOrgName())) {
			props.put(CasSessionContext.ORG_NAME, StringUtils.strnull(CasSessionContext.getContext().getOrgName()));
		}
		//任职资格ID
		if (CasSessionContext.getContext().getStaffPositionId() != null) {
			props.put(CasSessionContext.STAFF_POSITION_ID, StringUtils.strnull(CasSessionContext.getContext().getStaffPositionId()));
		}
		//员工名称
		if (!StringUtils.isNullOrEmpty(CasSessionContext.getContext().getStaffName())) {
			props.put(CasSessionContext.STAFF_NAME, StringUtils.strnull(CasSessionContext.getContext().getStaffName()));
		}

        return props;
	}

	@Override
	public void putAppPropsMap(Map<String, String> props) {

	}

}
