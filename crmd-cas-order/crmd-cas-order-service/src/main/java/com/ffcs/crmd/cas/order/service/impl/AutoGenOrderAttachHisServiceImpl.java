package com.ffcs.crmd.cas.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.order.entity.AutoGenOrderAttachHis;
import com.ffcs.crmd.cas.order.repository.IAutoGenOrderAttachHisRepository;
import com.ffcs.crmd.cas.order.service.IAutoGenOrderAttachHisService;

@Service("autoGenOrderAttachHisService")
public class AutoGenOrderAttachHisServiceImpl extends AbsCrmdGenericServiceImpl<AutoGenOrderAttachHis, Long>
    implements IAutoGenOrderAttachHisService {

   	@Autowired
	IAutoGenOrderAttachHisRepository autoGenOrderAttachHisRepository;
}
