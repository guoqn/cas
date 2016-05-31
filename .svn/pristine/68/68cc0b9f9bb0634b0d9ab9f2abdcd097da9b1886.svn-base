package com.ffcs.crmd.cas.sys.entity;


import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.cas.sys.repository.IStaffPositionRepository;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;



@Table(name = "STAFF_POSITION")
public class StaffPosition extends AbsCrmdBaseEntity<Long> {

	private static final long serialVersionUID = -2811347047325737314L;


	/**
	 * 
	 */
	@Id
	@Column(name = "STAFF_POSITION_ID")
	private Long staffPositionId;

	/**
	 * 
	 */
	@Column(name = "EXPIRE_DATE")
	private Timestamp expireDate;

	/**
	 * 
	 */
	@Column(name = "REGION_CD")
	private Long regionCd;

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
	@Column(name = "EFFECT_DATE")
	private Timestamp effectDate;

	/**
	 * 
	 */
	@Column(name = "AREA_ID")
	private Long areaId;

	/**
	 * 
	 */
	@Column(name = "ORG_REL_CD")
	private String orgRelCd;

	/**
	 * 
	 */
	@Column(name = "STATUS_DATE")
	private Timestamp statusDate;

	/**
	 * 
	 */
	@Column(name = "ORG_ID")
	private Long orgId;

	/**
	 * 
	 */
	@Column(name = "PRI_TYPE")
	private String priType;

	/**
	 * 
	 */
	@Column(name = "UPDATE_STAFF")
	private Long updateStaff;

	/**
	 * 
	 */
	@Column(name = "STAFF_ID")
	private Long staffId;

	/**
	 * 
	 */
	@Column(name = "STATUS_CD")
	private String statusCd;

	/**
	 * crm1.0ԭtf.tfid
	 */
	@Column(name = "OLD_POSITION_ID")
	private Long oldPositionId;

	/**
	 * 
	 */
	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

	/**
	 * 
	 */
	@Column(name = "POSITION_ID")
	private Long positionId;


	public void setStaffPositionId(Long staffPositionId){
		this.staffPositionId = staffPositionId;
	}

	public Long getStaffPositionId(){
		return this.staffPositionId;
	}

	public void setExpireDate(Timestamp expireDate){
		this.expireDate = expireDate;
	}

	public Timestamp getExpireDate(){
		return this.expireDate;
	}

	public void setRegionCd(Long regionCd){
		this.regionCd = regionCd;
	}

	public Long getRegionCd(){
		return this.regionCd;
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

	public void setEffectDate(Timestamp effectDate){
		this.effectDate = effectDate;
	}

	public Timestamp getEffectDate(){
		return this.effectDate;
	}

	public void setAreaId(Long areaId){
		this.areaId = areaId;
	}

	public Long getAreaId(){
		return this.areaId;
	}

	public void setOrgRelCd(String orgRelCd){
		this.orgRelCd = orgRelCd;
	}

	public String getOrgRelCd(){
		return this.orgRelCd;
	}

	public void setStatusDate(Timestamp statusDate){
		this.statusDate = statusDate;
	}

	public Timestamp getStatusDate(){
		return this.statusDate;
	}

	public void setOrgId(Long orgId){
		this.orgId = orgId;
	}

	public Long getOrgId(){
		return this.orgId;
	}

	public void setPriType(String priType){
		this.priType = priType;
	}

	public String getPriType(){
		return this.priType;
	}

	public void setUpdateStaff(Long updateStaff){
		this.updateStaff = updateStaff;
	}

	public Long getUpdateStaff(){
		return this.updateStaff;
	}

	public void setStaffId(Long staffId){
		this.staffId = staffId;
	}

	public Long getStaffId(){
		return this.staffId;
	}

	public void setStatusCd(String statusCd){
		this.statusCd = statusCd;
	}

	public String getStatusCd(){
		return this.statusCd;
	}

	public void setOldPositionId(Long oldPositionId){
		this.oldPositionId = oldPositionId;
	}

	public Long getOldPositionId(){
		return this.oldPositionId;
	}

	public void setCreateDate(Timestamp createDate){
		this.createDate = createDate;
	}

	public Timestamp getCreateDate(){
		return this.createDate;
	}

	public void setPositionId(Long positionId){
		this.positionId = positionId;
	}

	public Long getPositionId(){
		return this.positionId;
	}


	public Long getId() {
		return staffPositionId;
	}

	public void setId(Long id) {
		this.staffPositionId = id;
	}
	
	public StaffPosition() {
		super();
    }

    public StaffPosition(boolean genId) {
        if (genId) {
			setId(genEnttId());
		}
    }

	public static IStaffPositionRepository repository() {
		return (IStaffPositionRepository) RepositoryRegister.getInstance()
				.getRepository(StaffPosition.class);
	}
	
}
