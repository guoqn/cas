package com.ffcs.crmd.cas.core.ddd.filter;

import java.util.Map;
import java.util.Map.Entry;

import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.base.context.CasSessionContext;
import com.ffcs.crmd.platform.pub.proxy.callfilter.serverimpl.AbstractServerCallFilter;
import org.springframework.stereotype.Component;

@Component("defaultServerCallFilter")
public class DefaultServerCallFilter extends AbstractServerCallFilter {

	@Override
	public Map<String, String> getAppPropsMap() {
		return null;
	}

	@Override
	public void putAppPropsMap(Map<String, String> props) {
        for (Entry<String, String> entry : props.entrySet()) {
            if (StringUtils.equals(entry.getKey(), CasSessionContext.ORG_NAME)) {
            	CasSessionContext.getContext().setOrgName(props.get(CasSessionContext.ORG_NAME));
            } else if (StringUtils.equals(entry.getKey(), CasSessionContext.STAFF_POSITION_ID)) {
            	CasSessionContext.getContext().setStaffPositionId(NumberUtils.toLong(props.get(CasSessionContext.STAFF_POSITION_ID)));
            } else if (StringUtils.equals(entry.getKey(), CasSessionContext.REGION_NAME)) {
            	CasSessionContext.getContext().setOrgName(props.get(CasSessionContext.REGION_NAME));
            } else if (StringUtils.equals(entry.getKey(), CasSessionContext.CHANNEL_CODE)) {
            	CasSessionContext.getContext().setChannelCode(props.get(CasSessionContext.CHANNEL_CODE));
            } else if (StringUtils.equals(entry.getKey(), CasSessionContext.AREA_ID)) {
				CasSessionContext.getContext().setOrgName(props.get(CasSessionContext.AREA_ID));
			} else if (StringUtils.equals(entry.getKey(), CasSessionContext.STAFF_NAME)) {
				CasSessionContext.getContext().setChannelCode(props.get(CasSessionContext.STAFF_NAME));
			}
            //平台默认参数
            else if (StringUtils.equals(entry.getKey(), "staffId")) {
            	CasSessionContext.getContext().setStaffId(NumberUtils.toLong(props.get("staffId")));
            } else if (StringUtils.equals(entry.getKey(), "orgId")) {
            	CasSessionContext.getContext().setOrgId(NumberUtils.toLong(props.get("orgId")));
            } else if (StringUtils.equals(entry.getKey(), "regionId")) {
            	CasSessionContext.getContext()
                    .setRegionId(NumberUtils.toLong(props.get("regionId")));
            }
        }
	}

}
