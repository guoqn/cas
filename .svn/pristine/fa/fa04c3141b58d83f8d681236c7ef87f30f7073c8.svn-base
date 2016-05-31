package com.ffcs.crmd.cas.intf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.intf.entity.CasIntfLogInfo;
import com.ffcs.crmd.cas.intf.entity.CasIntfLogRec;
import com.ffcs.crmd.cas.intf.repository.ICasIntfLogInfoRepository;
import com.ffcs.crmd.cas.intf.repository.ICasIntfLogRecRepository;
import com.ffcs.crmd.cas.intf.service.ICasIntfLogRecService;

@Service("casIntfLogRecService")
public class CasIntfLogRecServiceImpl extends AbsCrmdGenericServiceImpl<CasIntfLogRec, Long>
    implements ICasIntfLogRecService {

   	@Autowired
	ICasIntfLogRecRepository casIntfLogRecRepository;
   	
   	@Autowired
	ICasIntfLogInfoRepository casIntfLogInfoRepository;

	@Override
	public boolean indepSaveIntfLog(CasIntfLogRec intfLogRec,CasIntfLogInfo intfLogInfo) {
		if(intfLogRec != null){
			try {
				casIntfLogRecRepository.insert(intfLogRec);
				casIntfLogInfoRepository.insert(intfLogInfo);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
}
