package com.ffcs.crmd.cas.order.service.impl;

import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.order.api.vo.OrgSceneTypeRelVo;
import com.ffcs.crmd.cas.order.entity.OrgSceneTypeRel;
import com.ffcs.crmd.cas.order.repository.IOrgSceneTypeRelRepository;
import com.ffcs.crmd.cas.order.service.IOrgSceneTypeRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orgSceneTypeRelService")
public class OrgSceneTypeRelServiceImpl extends AbsCrmdGenericServiceImpl<OrgSceneTypeRel, Long>
    implements IOrgSceneTypeRelService {

   	@Autowired
	IOrgSceneTypeRelRepository orgSceneTypeRelRepository;

	@Override
	public List<OrgSceneTypeRel> queryOrgSceneTypeRel(OrgSceneTypeRelVo orgSceneTypeRelVo) {
		return orgSceneTypeRelRepository.queryOrgSceneTypeRel(orgSceneTypeRelVo);
	}

}
