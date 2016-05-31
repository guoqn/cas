package com.ffcs.crmd.cas.core.ddd.entity.impl;

import java.io.Serializable;
import java.sql.Timestamp;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.base.utils.CrmClassUtils;
import com.ffcs.crmd.cas.core.ddd.entity.ICasBaseEntity;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.data.utils.CrmEntityUtils;
import com.ffcs.crmd.platform.meta.entity.SysClass;

/**
 * 
 * 功能说明:
 *
 * @author Luxb
 * 
 * @Date 2015年12月26日 下午4:31:32
 *
 * @param <ID>
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public abstract class AbsCrmdBaseEntity<ID extends Serializable> extends AbstractCrmDomBaseEntityImpl<ID>
		implements ICasBaseEntity<ID> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2413705807346686224L;
	
	@Override
	public void setStatusDate(Timestamp statusDate) {

	}

	@Override
	public Timestamp getStatusDate() {
		return null;
	}

	@Override
	public void setDtimestamp(Long dtimestamp) {
	}

	@Override
	public Long getDtimestamp() {
		return null;
	}

	@Override
	public void setDversion(Long dversion) {
	}

	@Override
	public Long getDversion() {
		return null;
	}

	@Override
	public void setStatusCd(String statusCd) {
	}

	@Override
	public String getStatusCd() {
		return null;
	}

	@Override
	public void setCreateDate(Timestamp createDate) {
	}

	@Override
	public Timestamp getCreateDate() {
		return null;
	}

	@Override
	public String getGlobalSeqName() {
		String entityname = StringUtils.substringAfterLast(this.getClass().getName(), ".");
		SysClass sysClass = CrmClassUtils.getSysClassByClassName(entityname);
		if(sysClass != null) {
			String seqName = sysClass.getSeqName();
			if (!StringUtils.isNullOrEmpty(seqName)) {
				return seqName;
			}
		}
		return super.getGlobalSeqName();
	}
}
