package com.ffcs.crmd.cas.core.ddd.service;

import java.io.Serializable;

import com.ffcs.crmd.cas.core.ddd.entity.impl.AbsCrmdBaseEntity;
import com.ffcs.crmd.platform.core.ddd.service.ICrmDomGenericService;

/**
 * 
 * 功能说明:
 *
 * @author Luxb
 * 
 * @Date 2015年12月26日 下午4:32:28
 *
 * @param <T>
 * @param <ID>
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public interface ICrmdGenericService<T extends AbsCrmdBaseEntity<ID>, ID extends Serializable>
		extends ICrmDomGenericService<T, ID> {

}
