package com.ffcs.crmd.cas.order.api.dto;

import com.ffcs.crmd.cas.core.ddd.api.dto.impl.CrmdBaseDTO;

import java.util.List;

/**
 * Created by YULIYAO on 2016/3/25.
 */
public class PreSaleOrderMaintanceDTO extends CrmdBaseDTO {
    private static final long serialVersionUID = 1598179584838497003L;
    /**
     * 批量关联列表
     */
    private List<PreSaleOrderMaintanceDetailDTO> preSaleOrderMaintanceDetailDTOList;

    /**
     * 总数
     */
    private int totalCount;

    /**
     * 可关联数
     */
    private int canConnectCount;

    /**
     * 不可关联数
     */
    private int canntConnectCount;
    /**
     * 关联提出人
     */
    private String originator;

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    public List<PreSaleOrderMaintanceDetailDTO> getPreSaleOrderMaintanceDetailDTOList() {
        return preSaleOrderMaintanceDetailDTOList;
    }

    public void setPreSaleOrderMaintanceDetailDTOList(
        List<PreSaleOrderMaintanceDetailDTO> preSaleOrderMaintanceDetailDTOList) {
        this.preSaleOrderMaintanceDetailDTOList = preSaleOrderMaintanceDetailDTOList;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCanConnectCount() {
        return canConnectCount;
    }

    public void setCanConnectCount(int canConnectCount) {
        this.canConnectCount = canConnectCount;
    }

    public int getCanntConnectCount() {
        return canntConnectCount;
    }

    public void setCanntConnectCount(int canntConnectCount) {
        this.canntConnectCount = canntConnectCount;
    }
}
