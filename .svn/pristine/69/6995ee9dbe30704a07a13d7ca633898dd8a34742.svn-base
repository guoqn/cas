package com.ffcs.crmd.cas.sys.repository.impl;

import com.ffcs.crmd.cas.core.ddd.repository.impl.AbsCrmdBaseRepositoryImpl;
import com.ffcs.crmd.cas.sys.entity.StaffPosition;
import com.ffcs.crmd.cas.sys.repository.IStaffPositionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("staffPositionRepository")
public class StaffPositionRepositoryImpl extends AbsCrmdBaseRepositoryImpl<StaffPosition, Long>
    implements IStaffPositionRepository {

    public StaffPositionRepositoryImpl() {
        super(StaffPosition.class);
    }

    @Override
    public List<StaffPosition> queryStaffPosition(Map param) {
        return this
            .queryListByName("staffRepository.queryStaffPosition", StaffPosition.class,
                param);
    }
}
