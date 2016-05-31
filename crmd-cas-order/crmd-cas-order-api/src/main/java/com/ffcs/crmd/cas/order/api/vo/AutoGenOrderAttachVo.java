package com.ffcs.crmd.cas.order.api.vo;

import com.ffcs.crmd.cas.core.ddd.api.vo.CrmdBaseConditionVo;


public class AutoGenOrderAttachVo  extends CrmdBaseConditionVo {
	

	/**
	 * 主键ID
	 */
	private Long autoGenOrderId;

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


	public void setAutoGenOrderId(Long autoGenOrderId){
		this.autoGenOrderId = autoGenOrderId;
	}

	public Long getAutoGenOrderId(){
		return this.autoGenOrderId;
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

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getXmlMsg() {
		return xmlMsg;
	}

	public void setXmlMsg(String xmlMsg) {
		this.xmlMsg = xmlMsg;
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


}
