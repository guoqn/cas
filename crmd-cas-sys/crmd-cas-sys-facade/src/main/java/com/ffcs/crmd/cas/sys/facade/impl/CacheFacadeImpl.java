package com.ffcs.crmd.cas.sys.facade.impl;

import com.alibaba.fastjson.JSON;
import com.ctg.itrdc.platform.common.utils.type.CollectionUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.base.cache.LocalCache;
import com.ffcs.crmd.cas.core.ddd.facade.impl.CrmdBaseFacade;
import com.ffcs.crmd.cas.sys.api.dto.LocalCacheDTO;
import com.ffcs.crmd.cas.sys.api.facade.ICacheFacade;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YULIYAO on 2016/5/5.
 */
@Service("cacheFacade")
public class CacheFacadeImpl  extends CrmdBaseFacade implements ICacheFacade {

    private LocalCache localCache = LocalCache.getInstance();

    @Override
    public List<LocalCacheDTO> qryCache(String key) {
        List<LocalCacheDTO> localCacheDTOs = new ArrayList<>();
        List keys = localCache.getAllKey();
        if (CollectionUtils.isNotEmpty(keys)) {
            for (int i = 0; i < keys.size(); i++) {
                String eachKey = (String) keys.get(i);
                if (StringUtils.isNullOrEmpty(key) || eachKey.contains(key)) {
                    LocalCacheDTO localCacheDTO = new LocalCacheDTO();
                    localCacheDTO.setKey(eachKey);
                    localCacheDTO.setValue(JSON.toJSON(localCache.get(eachKey)));
                    localCacheDTOs.add(localCacheDTO);
                }
            }
        }
        return localCacheDTOs;
    }

    @Override
    public void cleanup() {
        localCache.clean();
    }

    @Override
    public void put(String key, Object value) {
        localCache.put(key,value);
    }

    @Override
    public Object remove(String key) {
        return localCache.remove(key);
    }

}
