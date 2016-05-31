package com.ffcs.crmd.cas.order.api.dto;

import com.ffcs.crmd.cas.core.ddd.api.dto.impl.CrmdBaseDTO;


public class AutoGenOrderAttachHisDTO extends CrmdBaseDTO {
	private static final long serialVersionUID = 1598179584838497003L;


	/**
	 * 历史表主键
	 */
	private Long hisId;

	/**
	 * 末梢县局
	 */
	private Long regionCd;

	/**
	 * 分片键
	 */
	private Long shardingId;

	/**
	 * 报错截图
	 */
	private String pic;

	/**
	 * 送普坤报文
	 */
	private String xmlMsg;

	/**
	 * 本地网标识
	 */
	private Long areaId;

	/**
	 * 
	 */
	private Long dtimestamp;

	/**
	 * 
	 */
	private Long dversion;

	/**
	 * 主键ID
	 */
	private Long autoGenOrderId;


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

	public void setAreaId(Long areaId){
		this.areaId = areaId;
	}

	public Long getAreaId(){
		return this.areaId;
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

	public void setAutoGenOrderId(Long autoGenOrderId){
		this.autoGenOrderId = autoGenOrderId;
	}

	public Long getAutoGenOrderId(){
		return this.autoGenOrderId;
	}


}
