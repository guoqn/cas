package com.ffcs.crmd.cas.order.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.cas.order.repository.IIntfPreOrderAttachRepository;


@ShardingBean
@Table(name = "INTF_PRE_ORDER_ATTACH")
public class IntfPreOrderAttach extends AbsCrmdBaseEntity<Long> {

	private static final long serialVersionUID = -2811347047325737314L;


	/**
	 * 序列号，主键字段
	 */
	@Id
	@Column(name = "INTF_PRE_ORDER_ID")
	private Long intfPreOrderId;

	/**
	 * 县局标识
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
	 * 同步报文
	 */
	@Column(name = "TEXT_CONTENT")
	private String textContent;

	/**
	 * 记录状态CD。
	 */
	@Column(name = "STATUS_CD")
	private String statusCd;

	/**
	 * 本地网标识
	 */
	@Column(name = "AREA_ID")
	private Long areaId;

	/**
	 * 记录创建时间。
	 */
	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

	/**
	 * 记录状态时间。
	 */
	@Column(name = "STATUS_DATE")
	private Timestamp statusDate;


	public void setIntfPreOrderId(Long intfPreOrderId){
		this.intfPreOrderId = intfPreOrderId;
	}

	public Long getIntfPreOrderId(){
		return this.intfPreOrderId;
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

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	public void setStatusCd(String statusCd){
		this.statusCd = statusCd;
	}

	public String getStatusCd(){
		return this.statusCd;
	}

	public void setAreaId(Long areaId){
		this.areaId = areaId;
	}

	public Long getAreaId(){
		return this.areaId;
	}

	public void setCreateDate(Timestamp createDate){
		this.createDate = createDate;
	}

	public Timestamp getCreateDate(){
		return this.createDate;
	}

	public void setStatusDate(Timestamp statusDate){
		this.statusDate = statusDate;
	}

	public Timestamp getStatusDate(){
		return this.statusDate;
	}


	public Long getId() {
		return intfPreOrderId;
	}

	public void setId(Long id) {
		this.intfPreOrderId = id;
	}
	
	public IntfPreOrderAttach() {
		super();
    }

    public IntfPreOrderAttach(boolean genId) {
        if (genId) {
			setId(genEnttId());
		}
    }

	public static IIntfPreOrderAttachRepository repository() {
		return (IIntfPreOrderAttachRepository) RepositoryRegister.getInstance()
				.getRepository(IntfPreOrderAttach.class);
	}
	
}
