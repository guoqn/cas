package com.ffcs.crmd.cas.core.ddd.entity;

import com.ffcs.crmd.platform.core.ddd.entity.ICrmDomBaseEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * 功能说明:
 *
 * @author Luxb
 * 
 * @Date 2015年12月26日 下午4:31:48
 *
 * @param <ID>
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public interface ICasBaseEntity<ID extends Serializable> extends ICrmDomBaseEntity<ID> {
	/**
	 * areaId获取.
	 * @return
	 * @author Luxb
	 * 2016年2月17日 Luxb
	 */
	public Long getAreaId();
	/**
	 * areaId设置.
	 * @param areaId
	 * @author Luxb
	 * 2016年2月17日 Luxb
	 */
	public void setAreaId(Long areaId);
	
	public void setStatusDate(Timestamp statusDate);

	public void setRegionCd(Long regionCd);

	public Long getRegionCd();

	public void setCreateStaff(Long createStaff);

	public Long getCreateStaff();

	public void setUpdateDate(Timestamp updateDate);
	
	public Timestamp getUpdateDate();

	public Timestamp getStatusDate();

	public void setDtimestamp(Long dtimestamp);

	public Long getDtimestamp();

	public void setDversion(Long dversion);

	public Long getDversion();

	public void setUpdateStaff(Long updateStaff);

	public Long getUpdateStaff();

	public void setStatusCd(String statusCd);

	public String getStatusCd();

	public void setCreateDate(Timestamp createDate);

	public Timestamp getCreateDate();
}
