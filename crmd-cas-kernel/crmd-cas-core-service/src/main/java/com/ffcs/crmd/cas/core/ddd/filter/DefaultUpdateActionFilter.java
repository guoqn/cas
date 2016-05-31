package com.ffcs.crmd.cas.core.ddd.filter;

import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ffcs.crmd.cas.base.context.CasSessionContext;
import com.ffcs.crmd.cas.core.ddd.entity.ICasBaseEntity;
import com.ffcs.crmd.platform.meta.daaction.DaActionContext;
import com.ffcs.crmd.platform.meta.daaction.impl.ActionType;
import com.ffcs.crmd.platform.pub.vo.RetVo;

import org.springframework.stereotype.Component;

/**
 * .
 *
 * @author Luxb
 * @version Revision 1.0.0
 * @版权：福富软件 版权所有 (c) 2011
 * @see:
 * @创建日期：2016/2/17
 * @功能说明：
 */
@Component("defaultUpdateActionFilter")
public class DefaultUpdateActionFilter extends DefaultActionFilter {

    @Override
	public void beforeAction(DaActionContext context, Object entity,
			ActionType actionType) {
		super.beforeAction(context, entity, actionType);
	}

	@Override
	public void afterAction(DaActionContext context, Object entity,
			ActionType actionType) {
		super.afterAction(context, entity, actionType);
	}

	@Override
	public RetVo doBeforeAction(DaActionContext context, Object entity,
			ActionType actionType) {
		ICasBaseEntity baseEntity = (ICasBaseEntity) entity;
    	//修改员工
    	Long staffId = CasSessionContext.getContext().getStaffId();
    	if (staffId != null) {
        	baseEntity.setUpdateStaff(staffId);
    	}
    	
    	//修改时间
    	baseEntity.setUpdateDate(DateUtils.dateToTimestamp(DateUtils.getNowDate()));

        //状态时间
        baseEntity.setStatusDate(DateUtils.dateToTimestamp(DateUtils.getNowDate()));
		return super.doBeforeAction(context, entity, actionType);
	}

	@Override
	public RetVo doAfterAction(DaActionContext context, Object entity,
			ActionType actionType) {
		return super.doAfterAction(context, entity, actionType);
	}

	public DefaultUpdateActionFilter() {
        super();
    }
}
