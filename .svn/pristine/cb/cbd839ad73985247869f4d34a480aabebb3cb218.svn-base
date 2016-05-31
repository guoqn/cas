package com.ffcs.crmd.cas.order.entity;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.cas.order.repository.IOrgSceneTypeRelRepository;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;


@Table(name = "ORG_SCENE_TYPE_REL")
public class OrgSceneTypeRel extends AbsCrmdBaseEntity<Long> {

	private static final long serialVersionUID = -2811347047325737314L;


	/**
	 * 记录销售品订单项标识
	 */
	@Id
	@Column(name = "ORG_SCENE_TYPE_REL_ID")
	private Long orgSceneTypeRelId;

	/**
	 * 县局标识
	 */
	@Column(name = "REGION_CD")
	private Long regionCd;

	/**
	 * 分片键
	 */
	@Column(name = "SHARDING_ID")
	private Long shardingId;

	/**
	 * 创建员工
	 */
	@Column(name = "CREATE_STAFF")
	private Long createStaff;

	/**
	 * 修改日期
	 */
	@Column(name = "UPDATE_DATE")
	private Timestamp updateDate;

	/**
	 * 订单项类型分为：01=客户订单项、02=账户订单项、03=销售品订单项、04=产品订单项
	 */
	@Column(name = "SCENE_TYPE_NAME")
	private String sceneTypeName;

	/**
	 * 本地网标识
	 */
	@Column(name = "AREA_ID")
	private Long areaId;

	/**
	 * 记录状态时间
	 */
	@Column(name = "STATUS_DATE")
	private Timestamp statusDate;

	/**
	 * 记录销售品订单项标识
	 */
	@Column(name = "ORG_ID")
	private Long orgId;

	/**
	 * 
	 */
	@Column(name = "DTIMESTAMP")
	private Long dtimestamp;

	/**
	 * 
	 */
	@Column(name = "DVERSION")
	private Long dversion;

	/**
	 * 修改员工
	 */
	@Column(name = "UPDATE_STAFF")
	private Long updateStaff;

	/**
	 * 记录客户订单标识
	 */
	@Column(name = "SCENE_TYPE")
	private String sceneType;

	/**
	 * 记录状态
	 */
	@Column(name = "STATUS_CD")
	private String statusCd;

	/**
	 * 记录创建时间。
	 */
	@Column(name = "CREATE_DATE")
	private Timestamp createDate;


	public void setOrgSceneTypeRelId(Long orgSceneTypeRelId){
		this.orgSceneTypeRelId = orgSceneTypeRelId;
	}

	public Long getOrgSceneTypeRelId(){
		return this.orgSceneTypeRelId;
	}

	public void setRegionCd(Long regionCd){
		this.regionCd = regionCd;
	}

	public Long getRegionCd(){
		return this.regionCd;
	}

	public void setShardingId(Long shardingId){
		this.shardingId = shardingId;
	}

	public Long getShardingId(){
		return this.shardingId;
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

	public void setSceneTypeName(String sceneTypeName){
		this.sceneTypeName = sceneTypeName;
	}

	public String getSceneTypeName(){
		return this.sceneTypeName;
	}

	public void setAreaId(Long areaId){
		this.areaId = areaId;
	}

	public Long getAreaId(){
		return this.areaId;
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

	public void setDtimestamp(Long dtimestamp){
		this.dtimestamp = dtimestamp;
	}

	public Long getDtimestamp(){
		return this.dtimestamp;
	}

	public void setDversion(Long dversion){
		this.dversion = dversion;
	}

	public Long getDversion(){
		return this.dversion;
	}

	public void setUpdateStaff(Long updateStaff){
		this.updateStaff = updateStaff;
	}

	public Long getUpdateStaff(){
		return this.updateStaff;
	}

	public void setSceneType(String sceneType){
		this.sceneType = sceneType;
	}

	public String getSceneType(){
		return this.sceneType;
	}

	public void setStatusCd(String statusCd){
		this.statusCd = statusCd;
	}

	public String getStatusCd(){
		return this.statusCd;
	}

	public void setCreateDate(Timestamp createDate){
		this.createDate = createDate;
	}

	public Timestamp getCreateDate(){
		return this.createDate;
	}


	public Long getId() {
		return orgSceneTypeRelId;
	}

	public void setId(Long id) {
		this.orgSceneTypeRelId = id;
	}
	
	public OrgSceneTypeRel() {
		super();
    }

    public OrgSceneTypeRel(boolean genId) {
        if (genId) {
			setId(genEnttId());
		}
    }

	public static IOrgSceneTypeRelRepository repository() {
		return (IOrgSceneTypeRelRepository) RepositoryRegister.getInstance()
				.getRepository(OrgSceneTypeRel.class);
	}
	
}
