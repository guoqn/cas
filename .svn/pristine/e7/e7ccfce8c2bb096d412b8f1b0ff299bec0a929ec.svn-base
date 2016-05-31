package com.ffcs.crmd.cas.intf.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.cas.intf.repository.ICasIntfLogInfoRepository;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;

@Table(name = "CAS_INTF_LOG_INFO")
public class CasIntfLogInfo extends AbsCrmdBaseEntity<Long> {

	private static final long serialVersionUID = -2811347047325737314L;


	/**
	 * 序列号，主键字段
	 */
	@Id
	@Column(name = "CAS_INTF_LOG_INFO_ID")
	private Long casIntfLogInfoId;

	/**
	 * 
	 */
	@Column(name = "SHARDING_ID")
	private Long shardingId;

	/**
	 * 
	 */
	@Column(name = "UPDATE_STAFF")
	private Long updateStaff;

	/**
	 * 同步外系统编码
	 */
	@Column(name = "REQ_MESSAGE")
	private String reqMessage;

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
	@Column(name = "STATUS_CD")
	private String statusCd;

	/**
	 * P单号
	 */
	@Column(name = "CAS_INTF_LOG_REC_ID")
	private Long casIntfLogRecId;

	/**
	 * 
	 */
	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

	/**
	 * 
	 */
	@Column(name = "STATUS_DATE")
	private Timestamp statusDate;

	/**
	 * 
	 */
	@Column(name = "TENANT_ID")
	private Long tenantId;

	/**
	 * 业务类型
	 */
	@Column(name = "RSP_MESSAGE")
	private String rspMessage;


	public void setCasIntfLogInfoId(Long casIntfLogInfoId){
		this.casIntfLogInfoId = casIntfLogInfoId;
	}

	public Long getCasIntfLogInfoId(){
		return this.casIntfLogInfoId;
	}

	public void setShardingId(Long shardingId){
		this.shardingId = shardingId;
	}

	public Long getShardingId(){
		return this.shardingId;
	}

	public void setUpdateStaff(Long updateStaff){
		this.updateStaff = updateStaff;
	}

	public Long getUpdateStaff(){
		return this.updateStaff;
	}

	public void setReqMessage(String reqMessage){
		this.reqMessage = reqMessage;
	}

	public String getReqMessage(){
		return this.reqMessage;
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

	public void setStatusCd(String statusCd){
		this.statusCd = statusCd;
	}

	public String getStatusCd(){
		return this.statusCd;
	}

	public void setCasIntfLogRecId(Long casIntfLogRecId){
		this.casIntfLogRecId = casIntfLogRecId;
	}

	public Long getCasIntfLogRecId(){
		return this.casIntfLogRecId;
	}

	public void setCreateDate(Timestamp createDate){
		this.createDate = createDate;
	}

	public Timestamp getCreateDate(){
		return this.createDate;
	}

	@Override
	public Long getAreaId() {
		return null;
	}

	@Override
	public void setAreaId(Long areaId) {

	}

	public void setStatusDate(Timestamp statusDate){
		this.statusDate = statusDate;
	}

	@Override
	public void setRegionCd(Long regionCd) {

	}

	@Override
	public Long getRegionCd() {
		return null;
	}

	public Timestamp getStatusDate(){
		return this.statusDate;
	}

	public void setTenantId(Long tenantId){
		this.tenantId = tenantId;
	}

	public Long getTenantId(){
		return this.tenantId;
	}

	public void setRspMessage(String rspMessage){
		this.rspMessage = rspMessage;
	}

	public String getRspMessage(){
		return this.rspMessage;
	}


	public Long getId() {
		return casIntfLogInfoId;
	}

	public void setId(Long id) {
		this.casIntfLogInfoId = id;
	}
	
	public CasIntfLogInfo() {
		super();
    }

    public CasIntfLogInfo(boolean genId) {
        if (genId) {
			setId(genEnttId());
		}
    }

	public static ICasIntfLogInfoRepository repository() {
		return (ICasIntfLogInfoRepository) RepositoryRegister.getInstance()
				.getRepository(CasIntfLogInfo.class);
	}
	
}
