package com.ffcs.crmd.cas.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.order.entity.StateChangeCfg;
import com.ffcs.crmd.cas.order.service.IStateChangeCfgService;
import com.ffcs.crmd.cas.order.repository.IStateChangeCfgRepository;

@Service("stateChangeCfgService")
public class StateChangeCfgServiceImpl extends AbsCrmdGenericServiceImpl<StateChangeCfg, Long>
    implements IStateChangeCfgService {

   	@Autowired
	IStateChangeCfgRepository stateChangeCfgRepository;
}
