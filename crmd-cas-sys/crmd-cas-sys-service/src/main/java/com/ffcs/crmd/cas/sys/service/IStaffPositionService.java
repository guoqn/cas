package com.ffcs.crmd.cas.sys.service;

import com.ffcs.crmd.cas.core.ddd.service.ICrmdGenericService;
import com.ffcs.crmd.cas.sys.entity.StaffPosition;

import java.util.List;
import java.util.Map;

public interface IStaffPositionService extends ICrmdGenericService<StaffPosition, Long> {

    /**
     * 查询员工岗位
     * @param param
     * @return
     */
    List<StaffPosition> queryStaffPosition(Map param);
}
