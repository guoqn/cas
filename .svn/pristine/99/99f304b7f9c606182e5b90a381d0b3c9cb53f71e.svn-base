package com.ffcs.crmd.cas.order.entity;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.cas.order.repository.IInteractionFlowHisRepository;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;


@Table(name = "INTERACTION_FLOW_HIS")
public class InteractionFlowHis extends AbsCrmdBaseEntity<Long> {

	private static final long serialVersionUID = -2811347047325737314L;


	/**
	 * 
	 */
	@Id
	@Column(name = "HIS_ID")
	private Long hisId;

	/**
	 * 
	 */
	@Column(name = "REGION_CD")
	private Long regionCd;

	/**
	 * 
	 */
	@Column(name = "SHARDING_ID")
	private Long shardingId;

	/**
	 * 
	 */
	@Column(name = "STATE_CD")
	private String stateCd;

	/**
	 * 
	 */
	@Column(name = "CREATE_STAFF")
	private Long createStaff;

	/**
	 * 
	 */
	@Column(name = "EVENT_CD")
	private String eventCd;

	/**
	 * 
	 */
	@Column(name = "UPDATE_DATE")
	private Timestamp updateDate;

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
	@Column(name = "INTERACTION_FLOW_ID")
	private Long interactionFlowId;

	/**
	 * 
	 */
	@Column(name = "STATUS_DATE")
	private Timestamp statusDate;

	/**
	 * complainͶ
	 */
	@Column(name = "CUST_ITEM_TYPE_GROUP")
	private String custItemTypeGroup;

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
	 * 
	 */
	@Column(name = "UPDATE_STAFF")
	private Long updateStaff;

	/**
	 * 
	 */
	@Column(name = "INTERACTION_FLOW_NAME")
	private String interactionFlowName;

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
	 * 001
	 */
	@Column(name = "ASSIGN_MODE")
	private String assignMode;


	public void setHisId(Long hisId){
		this.hisId = hisId;
	}

	public Long getHisId(){
		return this.hisId;
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

	public void setStateCd(String stateCd){
		this.stateCd = stateCd;
	}

	public String getStateCd(){
		return this.stateCd;
	}

	public void setCreateStaff(Long createStaff){
		this.createStaff = createStaff;
	}

	public Long getCreateStaff(){
		return this.createStaff;
	}

	public void setEventCd(String eventCd){
		this.eventCd = eventCd;
	}

	public String getEventCd(){
		return this.eventCd;
	}

	public void setUpdateDate(Timestamp updateDate){
		this.updateDate = updateDate;
	}

	public Timestamp getUpdateDate(){
		return this.updateDate;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getRemark(){
		return this.remark;
	}

	public void setAreaId(Long areaId){
		this.areaId = areaId;
	}

	public Long getAreaId(){
		return this.areaId;
	}

	public void setInteractionFlowId(Long interactionFlowId){
		this.interactionFlowId = interactionFlowId;
	}

	public Long getInteractionFlowId(){
		return this.interactionFlowId;
	}

	public void setStatusDate(Timestamp statusDate){
		this.statusDate = statusDate;
	}

	public Timestamp getStatusDate(){
		return this.statusDate;
	}

	public void setCustItemTypeGroup(String custItemTypeGroup){
		this.custItemTypeGroup = custItemTypeGroup;
	}

	public String getCustItemTypeGroup(){
		return this.custItemTypeGroup;
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

	public void setInteractionFlowName(String interactionFlowName){
		this.interactionFlowName = interactionFlowName;
	}

	public String getInteractionFlowName(){
		return this.interactionFlowName;
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

	public void setAssignMode(String assignMode){
		this.assignMode = assignMode;
	}

	public String getAssignMode(){
		return this.assignMode;
	}


	public Long getId() {
		return hisId;
	}

	public void setId(Long id) {
		this.hisId = id;
	}
	
	public InteractionFlowHis() {
		super();
    }

    public InteractionFlowHis(boolean genId) {
        if (genId) {
			setId(genEnttId());
		}
    }

	public static IInteractionFlowHisRepository repository() {
		return (IInteractionFlowHisRepository) RepositoryRegister.getInstance()
				.getRepository(InteractionFlowHis.class);
	}
	
}
