package com.ffcs.crmd.cas.sys.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.cas.sys.repository.ICommonRegionRepository;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;

@Table(name = "COMMON_REGION")
public class CommonRegion extends AbsCrmdBaseEntity<Long> {

	private static final long serialVersionUID = -2811347047325737314L;

	/**
	 * 
	 */
	@Id
	@Column(name = "COMMON_REGION_ID")
	private Long commonRegionId;

	/**
	 * 
	 */
	@Column(name = "REGION_CD")
	private Long regionCd;

	/**
	 * 
	 */
	@Column(name = "COUNTY_TYPE")
	private String countyType;

	/**
	 * 
	 */
	@Column(name = "CREATE_STAFF")
	private Long createStaff;

	/**
	 * 
	 */
	@Column(name = "UPDATE_DATE")
	private Timestamp updateDate;

	/**
	 * 
	 */
	@Column(name = "REGION_TYPE")
	private String regionType;

	/**
	 * 
	 */
	@Column(name = "REMARK")
	private String remark;

	/**
	 * 
	 */
	@Column(name = "AREA_ID")
	private Long areaId;

	/**
	 * 
	 */
	@Column(name = "REGION_DESC")
	private String regionDesc;

	/**
	 * 
	 */
	@Column(name = "STATUS_DATE")
	private Timestamp statusDate;

	/**
	 * 
	 */
	@Column(name = "REGION_NAME")
	private String regionName;

	/**
	 * 
	 */
	@Column(name = "UPDATE_STAFF")
	private Long updateStaff;

	/**
	 * 
	 */
	@Column(name = "STATUS_CD")
	private String statusCd;

	/**
	 * 
	 */
	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

	/**
	 * 
	 */
	@Column(name = "REGION_CODE")
	private String regionCode;

	/**
	 * 
	 */
	@Column(name = "UP_REGION_ID")
	private Long upRegionId;

	/**
	 * Ĭ
	 */
	@Column(name = "DEFAULT_REGION_ID")
	private Long defaultRegionId;

	public void setCommonRegionId(Long commonRegionId) {
		this.commonRegionId = commonRegionId;
	}

	public Long getCommonRegionId() {
		return this.commonRegionId;
	}

	public void setRegionCd(Long regionCd) {
		this.regionCd = regionCd;
	}

	public Long getRegionCd() {
		return this.regionCd;
	}

	public void setCountyType(String countyType) {
		this.countyType = countyType;
	}

	public String getCountyType() {
		return this.countyType;
	}

	public void setCreateStaff(Long createStaff) {
		this.createStaff = createStaff;
	}

	public Long getCreateStaff() {
		return this.createStaff;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setRegionType(String regionType) {
		this.regionType = regionType;
	}

	public String getRegionType() {
		return this.regionType;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getAreaId() {
		return this.areaId;
	}

	public void setRegionDesc(String regionDesc) {
		this.regionDesc = regionDesc;
	}

	public String getRegionDesc() {
		return this.regionDesc;
	}

	public void setStatusDate(Timestamp statusDate) {
		this.statusDate = statusDate;
	}

	public Timestamp getStatusDate() {
		return this.statusDate;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setUpdateStaff(Long updateStaff) {
		this.updateStaff = updateStaff;
	}

	public Long getUpdateStaff() {
		return this.updateStaff;
	}

	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}

	public String getStatusCd() {
		return this.statusCd;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getRegionCode() {
		return this.regionCode;
	}

	public void setUpRegionId(Long upRegionId) {
		this.upRegionId = upRegionId;
	}

	public Long getUpRegionId() {
		return this.upRegionId;
	}

	public void setDefaultRegionId(Long defaultRegionId) {
		this.defaultRegionId = defaultRegionId;
	}

	public Long getDefaultRegionId() {
		return this.defaultRegionId;
	}

	public Long getId() {
		return commonRegionId;
	}

	public void setId(Long id) {
		this.commonRegionId = id;
	}

	public CommonRegion() {
		super();
	}

	public CommonRegion(boolean genId) {
		if (genId) {
			setId(genEnttId());
		}
	}

	public static ICommonRegionRepository repository() {
		return (ICommonRegionRepository) RepositoryRegister.getInstance()
				.getRepository(CommonRegion.class);
	}

}
