package com.ffcs.crmd.cas.order.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderProcRepository;
import com.ffcs.crmd.cas.order.service.IPreSaleOrderProcAttrService;


@ShardingBean
@Table(name = "PRE_SALE_ORDER_PROC")
public class PreSaleOrderProc extends AbsCrmdBaseEntity<Long> {

	private static final long serialVersionUID = -2811347047325737314L;


	/**
	 * Ԥ
	 */
	@Id
	@Column(name = "PRE_SALE_ORDER_PROC_ID")
	private Long preSaleOrderProcId;

	/**
	 * 
	 */
	@Column(name = "REAL_CUST_SO_NUMBER")
	private String realCustSoNumber;

	/**
	 * 
	 */
	@Column(name = "REGION_CD")
	private Long regionCd;

	/**
	 * 
	 */
	@ShardingId
	@Column(name = "SHARDING_ID")
	private Long shardingId;

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
	@Column(name = "STATUS_DATE")
	private Timestamp statusDate;

	/**
	 * 
	 */
	@Column(name = "PRE_ORDER_ID")
	private Long preOrderId;

	/**
	 * 
	 */
	@Column(name = "ACCEPT_TIME")
	private Timestamp acceptTime;

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
	 * Ա
	 */
	@Column(name = "STAFF_ID")
	private Long staffId;

	/**
	 * 
	 */
	@Column(name = "HANDLE_PEOPLE_NAME")
	private String handlePeopleName;

	/**
	 * 
	 */
	@Column(name = "CUSTOMER_INTERACTION_EVENT_ID")
	private Long customerInteractionEventId;

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
	@Column(name = "LAN_ID")
	private Long lanId;

	public void setPreSaleOrderProcId(Long preSaleOrderProcId){
		this.preSaleOrderProcId = preSaleOrderProcId;
	}

	public Long getPreSaleOrderProcId(){
		return this.preSaleOrderProcId;
	}

	public void setRealCustSoNumber(String realCustSoNumber){
		this.realCustSoNumber = realCustSoNumber;
	}

	public String getRealCustSoNumber(){
		return this.realCustSoNumber;
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

	public void setStatusDate(Timestamp statusDate){
		this.statusDate = statusDate;
	}

	public Timestamp getStatusDate(){
		return this.statusDate;
	}

	public void setPreOrderId(Long preOrderId){
		this.preOrderId = preOrderId;
	}

	public Long getPreOrderId(){
		return this.preOrderId;
	}

	public void setAcceptTime(Timestamp acceptTime){
		this.acceptTime = acceptTime;
	}

	public Timestamp getAcceptTime(){
		return this.acceptTime;
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

	public void setStaffId(Long staffId){
		this.staffId = staffId;
	}

	public Long getStaffId(){
		return this.staffId;
	}

	public void setHandlePeopleName(String handlePeopleName){
		this.handlePeopleName = handlePeopleName;
	}

	public String getHandlePeopleName(){
		return this.handlePeopleName;
	}

	public void setCustomerInteractionEventId(Long customerInteractionEventId){
		this.customerInteractionEventId = customerInteractionEventId;
	}

	public Long getCustomerInteractionEventId(){
		return this.customerInteractionEventId;
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

	public void setLanId(Long lanId){
		this.lanId = lanId;
	}

	public Long getLanId(){
		return this.lanId;
	}


	public Long getId() {
		return preSaleOrderProcId;
	}

	public void setId(Long id) {
		this.preSaleOrderProcId = id;
	}
	
	public PreSaleOrderProc() {
		super();
    }

    public PreSaleOrderProc(boolean genId) {
        if (genId) {
			setId(genEnttId());
		}
    }

	public static IPreSaleOrderProcRepository repository() { 
		return (IPreSaleOrderProcRepository) RepositoryRegister.getInstance()
				.getRepository(PreSaleOrderProc.class);
	}
}
