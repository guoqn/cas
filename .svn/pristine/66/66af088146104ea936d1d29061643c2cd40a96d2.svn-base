package com.ffcs.crmd.cas.order.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;

public class PreSaleOrderProcForIntfVo {
	/**
     * p单号
     */
    private String preOrderNumber;

    /**
     * 处理时间
     */
    private String createDate;

    /**
     * 处理人员
     */
    private String handlePeopleName;

    private String remark;

	public String getPreOrderNumber() {
		return preOrderNumber;
	}

	public void setPreOrderNumber(String preOrderNumber) {
		this.preOrderNumber = preOrderNumber;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = DateUtils.dateToString(DateUtils.formatDate(createDate, "yyyy-MM-dd HH:mm:ss"),
				"yyyy-MM-dd HH:mm:ss");
	}

	public String getHandlePeopleName() {
		return handlePeopleName;
	}

	public void setHandlePeopleName(String handlePeopleName) {
		this.handlePeopleName = handlePeopleName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
}
