package com.ffcs.crmd.cas.order.vo;

import com.ctg.itrdc.platform.common.utils.type.DateUtils;

public class PreSaleOrderOverTimeListVo {
	/**
     * p单号
     */
    private String preOrderNumber;

    /**
     * 工单认领人
     */
    private String poolStaffId;
    private String poolStaffName;

    /**
     * 工单完成标识:poolStatusCd=12000
     */
    private String statusCd;

    /**
     * 工单认领时间
     */
    private String poolAcceptDate;

    /**
     * 最后受理时间
     */
    private String poolStatusDate;

    private String poolCreateDate;

	public String getPreOrderNumber() {
		return preOrderNumber;
	}

	public void setPreOrderNumber(String preOrderNumber) {
		this.preOrderNumber = preOrderNumber;
	}

	public String getPoolStaffId() {
		return poolStaffId;
	}

	public void setPoolStaffId(String poolStaffId) {
		this.poolStaffId = poolStaffId;
	}

	public String getStatusCd() {
		return statusCd;
	}

	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}

	public String getPoolAcceptDate() {
		return poolAcceptDate;
	}

	public void setPoolAcceptDate(String poolAcceptDate) {
		this.poolAcceptDate = DateUtils.dateToString(DateUtils.formatDate(poolAcceptDate, "yyyy-MM-dd HH:mm:ss"),
				"yyyy-MM-dd HH:mm:ss");;
	}

	public String getPoolStatusDate() {
		return poolStatusDate;
	}

	public void setPoolStatusDate(String poolStatusDate) {
		this.poolStatusDate = DateUtils.dateToString(DateUtils.formatDate(poolStatusDate, "yyyy-MM-dd HH:mm:ss"),
				"yyyy-MM-dd HH:mm:ss");;
	}

	public String getPoolCreateDate() {
		return poolCreateDate;
	}

	public void setPoolCreateDate(String poolCreateDate) {
		this.poolCreateDate = DateUtils.dateToString(DateUtils.formatDate(poolCreateDate, "yyyy-MM-dd HH:mm:ss"),
				"yyyy-MM-dd HH:mm:ss");;
	}

	public String getPoolStaffName() {
		return poolStaffName;
	}

	public void setPoolStaffName(String poolStaffName) {
		this.poolStaffName = poolStaffName;
	}
    
}
