package com.ffcs.crmd.cas.order.api.dto;

import com.ffcs.crmd.cas.core.ddd.api.dto.impl.CrmdBaseDTO;


public class InteractionFlowDTO extends CrmdBaseDTO {
	private static final long serialVersionUID = 1598179584838497003L;

	private Long interactionFlowId;

	/**
	 * 
	 */
	private Long regionCd;

	/**
	 * 
	 */
	private Long shardingId;

	/**
	 * 
	 */
	private String stateCd;

	/**
	 * 
	 */
	private String eventCd;

	/**
	 * 
	 */
	private Long areaId;

	/**
	 * complainͶ
	 */
	private String custItemTypeGroup;

	/**
	 * 
	 */
	private Long dtimestamp;

	/**
	 * 
	 */
	private Long dversion;

	/**
	 * 
	 */
	private String interactionFlowName;

	/**
	 * 001
	 */
	private String assignMode;

	/**
	 * 业务大组类名称
	 */
	private String custItemTypeGroupName;

	/**
	 * 状态名称
	 */
	private String statusCdName;


	public void setInteractionFlowId(Long interactionFlowId){
		this.interactionFlowId = interactionFlowId;
	}

	public Long getInteractionFlowId(){
		return this.interactionFlowId;
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

	public void setEventCd(String eventCd){
		this.eventCd = eventCd;
	}

	public String getEventCd(){
		return this.eventCd;
	}

	public void setAreaId(Long areaId){
		this.areaId = areaId;
	}

	public Long getAreaId(){
		return this.areaId;
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

	public void setInteractionFlowName(String interactionFlowName){
		this.interactionFlowName = interactionFlowName;
	}

	public String getInteractionFlowName(){
		return this.interactionFlowName;
	}

	public void setAssignMode(String assignMode){
		this.assignMode = assignMode;
	}

	public String getAssignMode(){
		return this.assignMode;
	}

	public String getCustItemTypeGroupName() {
		return custItemTypeGroupName;
	}

	public void setCustItemTypeGroupName(String custItemTypeGroupName) {
		this.custItemTypeGroupName = custItemTypeGroupName;
	}

	public String getStatusCdName() {
		return statusCdName;
	}

	public void setStatusCdName(String statusCdName) {
		this.statusCdName = statusCdName;
	}
}
