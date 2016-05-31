package com.ffcs.crmd.cas.order.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.cas.order.repository.IAutoGenOrderAttachRepository;


@ShardingBean
@Table(name = "AUTO_GEN_ORDER_ATTACH")
public class AutoGenOrderAttach extends AbsCrmdBaseEntity<Long> {

	private static final long serialVersionUID = -2811347047325737314L;


	/**
	 * 主键ID
	 */
	@Id
	@Column(name = "AUTO_GEN_ORDER_ID")
	private Long autoGenOrderId;

	/**
	 * 末梢县局
	 */
	@Column(name = "REGION_CD")
	private Long regionCd;

	/**
	 * 分片键
	 */
	@ShardingId
	@Column(name = "SHARDING_ID")
	private Long shardingId;

	/**
	 * 报错截图
	 */
	@Column(name = "PIC")
	private String pic;

	/**
	 * 送普坤报文
	 */
	@Column(name = "XML_MSG")
	private String xmlMsg;

	/**
	 * 创建员工
	 */
	@Column(name = "CREATE_STAFF")
	private Long createStaff;

	/**
	 * 最后修改时间
	 */
	@Column(name = "UPDATE_DATE")
	private Timestamp updateDate;

	/**
	 * 本地网标识
	 */
	@Column(name = "AREA_ID")
	private Long areaId;

	/**
	 * 状态时间
	 */
	@Column(name = "STATUS_DATE")
	private Timestamp statusDate;

	/**
	 * 
	 */
	@Column(name = "DTIMESTAMP")
	private Long dtimestamp;

	/**
	 * 修改人
	 */
	@Column(name = "UPDATE_STAFF")
	private Long updateStaff;

	/**
	 * 
	 */
	@Column(name = "DVERSION")
	private Long dversion;

	/**
	 * 状态
	 */
	@Column(name = "STATUS_CD")
	private String statusCd;

	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_DATE")
	private Timestamp createDate;


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

	public void setDtimestamp(Long dtimestamp){
		this.dtimestamp = dtimestamp;
	}

	public Long getDtimestamp(){
		return this.dtimestamp;
	}

	public void setUpdateStaff(Long updateStaff){
		this.updateStaff = updateStaff;
	}

	public Long getUpdateStaff(){
		return this.updateStaff;
	}

	public void setDversion(Long dversion){
		this.dversion = dversion;
	}

	public Long getDversion(){
		return this.dversion;
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
		return autoGenOrderId;
	}

	public void setId(Long id) {
		this.autoGenOrderId = id;
	}
	
	public AutoGenOrderAttach() {
		super();
    }

    public AutoGenOrderAttach(boolean genId) {
        if (genId) {
			setId(genEnttId());
		}
    }

	public static IAutoGenOrderAttachRepository repository() {
		return (IAutoGenOrderAttachRepository) RepositoryRegister.getInstance()
				.getRepository(AutoGenOrderAttach.class);
	}
	
}
