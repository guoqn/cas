package com.ffcs.crmd.cas.sys.entity;

import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.cas.sys.repository.IAreaCodeRepository;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Timestamp;



@Table(name = "AREA_CODE")
public class AreaCode extends AbsCrmdBaseEntity<Long> {

	private static final long serialVersionUID = -2811347047325737314L;



	/**
	 * 
	 */
	@Id
	@Column(name = "AREA_CODE_ID")
	private Long areaCodeId;

	/**
	 * 
	 */
	@Column(name = "REGION_ID")
	private Long regionId;

	/**
	 * 
	 */
	@Column(name = "REGION_CD")
	private Long regionCd;

	/**
	 * 
	 */
	@Column(name = "UPDATE_STAFF")
	private Long updateStaff;

	/**
	 * 
	 */
	@Column(name = "AREA_NBR")
	private String areaNbr;

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
	@Column(name = "AREA_CODE")
	private String areaCode;

	/**
	 * 
	 */
	@Column(name = "AREA_ID")
	private Long areaId;


	public void setAreaCodeId(Long areaCodeId){
		this.areaCodeId = areaCodeId;
	}

	public Long getAreaCodeId(){
		return this.areaCodeId;
	}

	public void setRegionId(Long regionId){
		this.regionId = regionId;
	}

	public Long getRegionId(){
		return this.regionId;
	}

	public void setRegionCd(Long regionCd){
		this.regionCd = regionCd;
	}

	public Long getRegionCd(){
		return this.regionCd;
	}

	public void setUpdateStaff(Long updateStaff){
		this.updateStaff = updateStaff;
	}

	public Long getUpdateStaff(){
		return this.updateStaff;
	}

	public void setAreaNbr(String areaNbr){
		this.areaNbr = areaNbr;
	}

	public String getAreaNbr(){
		return this.areaNbr;
	}

	public void setCreateStaff(Long createStaff){
		this.createStaff = createStaff;
	}

	public Long getCreateStaff(){
		return this.createStaff;
	}

	public void setUpdateDate(Timestamp updateDate){
		this.updateDate = updateDate;
	}

	public Timestamp getUpdateDate(){
		return this.updateDate;
	}

	public void setAreaCode(String areaCode){
		this.areaCode = areaCode;
	}

	public String getAreaCode(){
		return this.areaCode;
	}

	public void setAreaId(Long areaId){
		this.areaId = areaId;
	}

	public Long getAreaId(){
		return this.areaId;
	}


	public Long getId() {
		return areaCodeId;
	}

	public void setId(Long id) {
		this.areaCodeId = id;
	}
	
	public AreaCode() {
		super();
    }

    public AreaCode(boolean genId) {
        if (genId) {
			setId(genEnttId());
		}
    }

	public static IAreaCodeRepository repository() {
		return (IAreaCodeRepository) RepositoryRegister.getInstance()
				.getRepository(AreaCode.class);
	}
	
}
