package com.ffcs.crmd.cas.sys.repository;

import com.ffcs.crmd.cas.core.ddd.repository.ICrmdBaseRepository;
import com.ffcs.crmd.cas.sys.entity.StaffPosition;

import java.util.List;
import java.util.Map;

public interface IStaffPositionRepository extends ICrmdBaseRepository<StaffPosition,Long> {

    /**
     * 查询员工岗位
     * @author YULIYAO 2016/3/4
     * return 
     */
    List<StaffPosition> queryStaffPosition(Map param);
}
