package com.ffcs.crmd.cas.constants;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;

/**
 *
 */
public enum OrderConstant {
    /**
     * 预受理处理过程交互事件标识 - 普坤自动受理成功.
     */
    PRE_PROC_EVENT_ID_AUTO_GEN_SUC("1013"),
    /**
     * 预受理处理过程交互事件标识 - 普坤自动受理失败.
     */
    PRE_PROC_EVENT_ID_AUTO_GEN_FAIL("1014"),

    /**
     * 自动处理表状态 - 创建.
     */
    AUTO_GEN_ORDER_STATUS_CREATE("1299"),
    /**
     * 自动处理表状态 - 送普坤成功.
     */
    AUTO_GEN_ORDER_STATUS_SEND_PK_SUC("1000"),
    /**
     * 自动处理表状态 - 送普坤失败.
     */
    AUTO_GEN_ORDER_STATUS_SEND_PK_FAIL("1001"),
    /**
     * 自动处理表状态 - 普坤自动受理成功.
     */
    AUTO_GEN_ORDER_STATUS_GEN_SUC("1100"),
    /**
     * 自动处理表状态 - 普坤自动受理失败.
     */
    AUTO_GEN_ORDER_STATUS_GEN_FAIL("1101"),
    /**
     * 自动处理表状态 - 竣工到历史表.
     */
    AUTO_GEN_ORDER_STATUS_COMPLETE("1200"),
    /**
     * 自动处理表状态 - 自动受理成功，预受理订单启动流程失败.
     */
    AUTO_GEN_ORDER_STATUS_ACTIVE_FAIL("1300"),

    /**
     * 预受理订单池状态--待审批.
     */
    PRE_POOL_STATUS_CD_WAIT_FOR_AUDIT("10001"),
    /**
     * 预受理订单池状态--未接收
     */
    PRE_POOL_STATUS_CD_NOT_ACCEPTED("10000"),
    /**
     * 预受理订单池状态--已接收
     */
    PRE_POOL_STATUS_CD_ACCEPTED("11000"),
    /**
     * 预受理订单池状态--已处理
     */
    PRE_POOL_STATUS_CD_DEALED("12000"),
    /**
     * 预受理订单池状态--锁定
     */
    RE_POOL_STATUS_CD_LOCKED("13000"),
    /**
     * 预受理订单池状态--待回退.
     */
    PRE_POOL_STATUS_CD_GOBACKING("14000"),
    /**
     * 预受理订单池状态--已回退.
     */
    PRE_POOL_STATUS_CD_GOBACKED("15000"),
    /**
     * 订单状态--竣工。
     */
    CUSTOMER_ORDER_STATUS_COMPLETE("300000"),
    /**
     * 订单状态--预受理。
     */
    CUSTOMER_ORDER_STATUS_PREACCEPT("100098"),
    /**
     * 预受理账务处理通知标识
     */
    PRE_ANNOUNCE_CHARGE_FLAG("preAnnounceChargeFlag"),
    /**
     * 预受理缴费员工岗位.
     */
    JAVACODE_PRE_SALE_PAY_STAFF_POSITION("preSalePayStaff");
    /**
     * 常量值.
     */
    private String value;

    /**
     * 构造方法.
     */
    private OrderConstant(String value) {
        this.value = value;
    }

    /**
     * 获取常量值.
     */
    public String getValue() {
        return this.value;
    }


    public static OrderConstant getByCode(String code) {
        if (!StringUtils.isNullOrEmpty(code)) {
            OrderConstant[] values = OrderConstant.values();
            for (int i = 0; i < values.length; i++) {
                if (code.equals(values[i].value)) {
                    return values[i];
                }
            }
        }
        return null;
    }
}
