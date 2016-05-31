package com.ffcs.crmd.cas.sys.facade.impl;

import com.ffcs.crmd.cas.core.ddd.facade.impl.CrmdBaseFacade;
import com.ffcs.crmd.cas.sys.api.facade.IAreaCodeFacade;
import com.ffcs.crmd.cas.sys.service.IAreaCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("areaCodeFacade")
public class AreaCodeFacadeImpl extends CrmdBaseFacade implements IAreaCodeFacade {
   	@Autowired
	IAreaCodeService areaCodeService;
}
