package com.ffcs.crmd.cas.order.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderProcAttrHisRepository;


@ShardingBean
@Table(name = "PRE_SALE_ORDER_PROC_ATTR_HIS")
public class PreSaleOrderProcAttrHis extends AbsCrmdBaseEntity<Long> {

	private static final long serialVersionUID = -2811347047325737314L;


	/**
	 * 
	 */
	@Id
	@Column(name = "HIS_ID")
	private Long hisId;

	/**
	 * ĩ
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
	@Column(name = "ATTR_VALUE_ID")
	private Long attrValueId;

	/**
	 * 
	 */
	@Column(name = "UPDATE_DATE")
	private Timestamp updateDate;

	/**
	 * 
	 */
	@Column(name = "ATTR_DESC")
	private String attrDesc;

	/**
	 * 
	 */
	@Column(name = "AREA_ID")
	private Long areaId;

	/**
	 * 
	 */
	@Column(name = "PRE_ORDER_PROC_ATTR_ID")
	private Long preOrderProcAttrId;

	/**
	 * ״̬ʱ
	 */
	@Column(name = "STATUS_DATE")
	private Timestamp statusDate;

	/**
	 * 
	 */
	@Column(name = "ATTR_VALUE")
	private String attrValue;

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
	 * ״̬
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
	@Column(name = "ATTR_ID")
	private Long attrId;

	/**
	 * 
	 */
	@Column(name = "PRE_SALE_ORDER_PROC_ID")
	private Long preSaleOrderProcId;


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

	public void setCreateStaff(Long createStaff){
		this.createStaff = createStaff;
	}

	public Long getCreateStaff(){
		return this.createStaff;
	}

	public void setAttrValueId(Long attrValueId){
		this.attrValueId = attrValueId;
	}

	public Long getAttrValueId(){
		return this.attrValueId;
	}

	public void setUpdateDate(Timestamp updateDate){
		this.updateDate = updateDate;
	}

	public Timestamp getUpdateDate(){
		return this.updateDate;
	}

	public void setAttrDesc(String attrDesc){
		this.attrDesc = attrDesc;
	}

	public String getAttrDesc(){
		return this.attrDesc;
	}

	public void setAreaId(Long areaId){
		this.areaId = areaId;
	}

	public Long getAreaId(){
		return this.areaId;
	}

	public void setPreOrderProcAttrId(Long preOrderProcAttrId){
		this.preOrderProcAttrId = preOrderProcAttrId;
	}

	public Long getPreOrderProcAttrId(){
		return this.preOrderProcAttrId;
	}

	public void setStatusDate(Timestamp statusDate){
		this.statusDate = statusDate;
	}

	public Timestamp getStatusDate(){
		return this.statusDate;
	}

	public void setAttrValue(String attrValue){
		this.attrValue = attrValue;
	}

	public String getAttrValue(){
		return this.attrValue;
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

	public void setAttrId(Long attrId){
		this.attrId = attrId;
	}

	public Long getAttrId(){
		return this.attrId;
	}

	public void setPreSaleOrderProcId(Long preSaleOrderProcId){
		this.preSaleOrderProcId = preSaleOrderProcId;
	}

	public Long getPreSaleOrderProcId(){
		return this.preSaleOrderProcId;
	}


	public Long getId() {
		return hisId;
	}

	public void setId(Long id) {
		this.hisId = id;
	}
	
	public PreSaleOrderProcAttrHis() {
		super();
    }

    public PreSaleOrderProcAttrHis(boolean genId) {
        if (genId) {
			setId(genEnttId());
		}
    }

	public static IPreSaleOrderProcAttrHisRepository repository() {
		return (IPreSaleOrderProcAttrHisRepository) RepositoryRegister.getInstance()
				.getRepository(PreSaleOrderProcAttrHis.class);
	}
	
}
