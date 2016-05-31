package com.ffcs.crmd.cas.core.ddd.api.vo;

import com.ffcs.crmd.platform.pub.vo.ConditionVo;

/**
 * 
 * 功能说明:
 *
 * @author Luxb
 * 
 * @Date 2015年12月26日 下午4:44:47
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public class CrmdBaseConditionVo extends ConditionVo {

    // 当前页
    private int pageNumber;
    // 分页大小
    private int pageSize;

    public int getPageNumber() {
        return pageNumber;
    }
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
