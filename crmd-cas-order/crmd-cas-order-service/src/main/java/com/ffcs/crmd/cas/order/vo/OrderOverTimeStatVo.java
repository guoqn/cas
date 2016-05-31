package com.ffcs.crmd.cas.order.vo;

/**
 * Created by YULIYAO on 2016/3/10.
 */
public class OrderOverTimeStatVo {

    /**
     * 员工id
     */
    private Long staffId;

    /**
     * 待处理超时数
     */
    private int waitDealCount;

    /**
     * 部分处理超时数
     */
    private int partDealCount;

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public int getWaitDealCount() {
        return waitDealCount;
    }

    public void setWaitDealCount(int waitDealCount) {
        this.waitDealCount = waitDealCount;
    }

    public int getPartDealCount() {
        return partDealCount;
    }

    public void setPartDealCount(int partDealCount) {
        this.partDealCount = partDealCount;
    }
}
