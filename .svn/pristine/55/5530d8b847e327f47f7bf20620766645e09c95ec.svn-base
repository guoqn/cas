package com.ffcs.crmd.cas.sys.api.facade;

import com.ffcs.crmd.cas.core.ddd.api.facade.ICrmdBaseFacade;
import com.ffcs.crmd.cas.sys.api.dto.LocalCacheDTO;

import java.util.List;

/**
 * Created by YULIYAO on 2016/5/5.
 */
public interface ICacheFacade extends ICrmdBaseFacade {

    List<LocalCacheDTO> qryCache(String key);

    void cleanup();

    void put(String key, Object value);

    Object remove(String key);
}
