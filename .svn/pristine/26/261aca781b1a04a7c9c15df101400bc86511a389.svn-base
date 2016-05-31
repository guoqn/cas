package com.ffcs.crmd.cas.core.ddd.filter;

import java.util.ArrayList;
import java.util.List;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.base.context.CasSessionContext;
import com.ffcs.crmd.cas.base.utils.CrmClassUtils;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.cas.core.ddd.entity.ICasBaseEntity;
import com.ffcs.crmd.platform.data.ddl.SeqServiceFactory;
import com.ffcs.crmd.platform.meta.daaction.DaActionContext;
import com.ffcs.crmd.platform.meta.daaction.filter.impl.AbstractDaActionFilter;
import com.ffcs.crmd.platform.meta.daaction.impl.ActionType;
import com.ffcs.crmd.platform.meta.entity.SysClass;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;
import com.ffcs.crmd.platform.meta.util.DaoSupport;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
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
@Component("defaultActionFilter")
public class DefaultActionFilter extends AbstractDaActionFilter {
	
	private ILogger LOG = LoggerFactory.getLogger(this.getClass());
	
    public DefaultActionFilter() {
        super();
    }

	@Override
	public void beforeAction(DaActionContext context, Object entity,
			ActionType actionType) {
	}

	@Override
	public void afterAction(DaActionContext context, Object entity,
			ActionType actionType) {
	}

	@Override
	public RetVo doBeforeAction(DaActionContext context, Object entity,
			ActionType actionType) {
		 
		RetVo vo = new RetVo(true);
		try {
			ICasBaseEntity baseEntity = (ICasBaseEntity) entity;
			// areaId设置
			if (baseEntity.getAreaId() == null) {
				Long areaId = CasSessionContext.getContext().getAreaId();
				baseEntity.setAreaId(areaId);
			}
			// regionCd设置
			if (baseEntity.getRegionCd() == null) {
				Long regionCd = CasSessionContext.getContext().getRegionCd();
				baseEntity.setRegionCd(regionCd);
			}
			// 创建员工
			if (baseEntity.getCreateStaff() == null) {
				Long staffId = CasSessionContext.getContext().getStaffId();
				baseEntity.setCreateStaff(staffId);
			}
			// 创建时间
			if (baseEntity.getCreateDate() == null) {
				try {
					baseEntity.setCreateDate(DateUtils
							.dateToTimestamp(DateUtils.getNowDate()));
				} catch (Exception e) {
					LOG.error("createDate转换失败：" + DateUtils.getNowDate(), e);
					e.printStackTrace();
					ExceptionUtils.throwEx(e);
				}
			}
			// 状态设置
			if (StringUtils.isNullOrEmpty(baseEntity.getStatusCd())) {
				baseEntity.setStatusCd(CasConstant.STATUS_CD_VAILID.getValue());
			}
			// 状态时间
			if (baseEntity.getStatusDate() == null) {
				baseEntity.setStatusDate(DateUtils.dateToTimestamp(DateUtils
						.getNowDate()));
			}

			// 修改员工
			if (baseEntity.getUpdateStaff() == null) {
				Long staffId = CasSessionContext.getContext().getStaffId();
				baseEntity.setUpdateStaff(staffId);
			}
			// 修改时间
			if (baseEntity.getUpdateDate() == null) {
				try {
					baseEntity.setUpdateDate(DateUtils
							.dateToTimestamp(DateUtils.getNowDate()));
				} catch (Exception e) {
					LOG.error("updateDate转换失败：" + DateUtils.getNowDate(), e);
					e.printStackTrace();
					ExceptionUtils.throwEx(e);
				}
			}
			try {
				// 历史表处理
				if (getDefaultLog(context, entity, actionType)) {
					vo = logHistory(context, entity, actionType);
					List<Object> list = new ArrayList<Object>();
					list.add(baseEntity);
					vo.setDataList(list);
				}
			} catch (Exception e) {
				LOG.error("defaultLog处理失败", e);
				e.printStackTrace();

				ExceptionUtils.throwEx(e);
			}
		} catch (Exception e) {
			LOG.error("doBefore处理失败", e);
			e.printStackTrace();

			ExceptionUtils.throwEx(e);
		}
		return vo;
	}

	@Override
	protected String getHisSeqName(DaActionContext context, Object entity,
			Object orignEntity) {
		String entityname = StringUtils.substringAfterLast(entity.getClass().getName(), ".");
		SysClass sysClass = CrmClassUtils.getSysClassByClassName(entityname);
		if(sysClass != null) {
			String seqName = sysClass.getHisSeqName();
			if (!StringUtils.isNullOrEmpty(seqName)) {
				return seqName;
			}
		}
		return super.getHisSeqName(context, entity, orignEntity);
	}

	@Override
	public RetVo doAfterAction(DaActionContext context, Object entity,
			ActionType actionType) {
		return super.doAfterAction(context, entity, actionType);
	}

	@Override
	protected boolean getDefaultLog(DaActionContext context, Object entity,
			ActionType actionType) {
		boolean result = super.getDefaultLog(context, entity, actionType);
		ICasBaseEntity baseEntity = (ICasBaseEntity) entity;
		SysClass sysClass = CrmClassUtils.getSysClassByClassName(baseEntity.getEntityName());
		if (sysClass != null) {
			if (ActionType.UPDATE.equals(actionType)) {
				if (sysClass.getIsChangeLog() != null && sysClass.getIsChangeLog() == 1) {
					result = true;
				}
			} else if (ActionType.DELETE.equals(actionType)) {
				if (sysClass.getIsDeleteLog() != null && sysClass.getIsDeleteLog() == 1) {
					result = true;
				}
			}
		}
		return result;
	}

	@Override
	protected RetVo logHistory(DaActionContext context, Object entity,
			ActionType actionType) {
		if (ActionType.UPDATE.equals(actionType)) {
			return super.logHistory(context, entity, actionType);
		} else {
	        RetVo vo = new RetVo(true);
	        if (entity == null) {
	            logger.warn("orign entity is not exists");
	            vo.setResult(false);
	            return vo;
	        }
	        String sql = getInsertSql(context,entity,entity);
	        List<Object> params = new ArrayList<Object>();
	        List<String> columns = getColumnList(context,entity,entity);
	        List<String> attrCode = getAttrCodeList(context,entity,entity);
	        int i = 0;

	        String seqName = getHisSeqName(context,entity,entity);
	        if (entity instanceof IMetaEntity && ((IMetaEntity) entity).isUseMeta()) {
	            sql.replace(getSeqColumnValue(seqName),"?");
	        }
	        Long hisId = SeqServiceFactory.getSeqService().getSeq(seqName);
	        params.add(hisId);
	        for (String column : columns) {
	            String code = attrCode.get(i);
	            i++;
	            Object object = getValue(context,code,column,entity,entity);
	            params.add(object);
	        }

	        int ret = DaoSupport.excuteUpate(sql,params);
	        vo.setObject(hisId);
	        vo.setRetCode(StringUtils.strnull(ret));
	        return vo;
		}
	}
	
}
