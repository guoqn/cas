package com.ffcs.crmd.cas.sys.control;

import com.ffcs.crmd.cas.sys.api.dto.LocalCacheDTO;
import com.ffcs.crmd.cas.sys.api.facade.ICacheFacade;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by YULIYAO on 2016/5/5.
 */
@Controller
@RequestMapping("/sys/cacheCtrl")
@ResponseBody
public class LocalCacheController {

    @Autowired
    private ICacheFacade cacheFacade;

    @RequestMapping("/qryCache")
    public RetVo qryCache(@RequestParam("name") String name) {
        List<LocalCacheDTO> localCacheDTOs = cacheFacade.qryCache(name);
        RetVo retVo = new RetVo(true);
        retVo.setDataList(localCacheDTOs);
        return retVo;
    }

    @RequestMapping("/cleanup")
    public RetVo cleanup() {
        RetVo retVo = new RetVo(true);
        try {
            cacheFacade.cleanup();
        } catch (Exception e) {
            retVo.setResult(false);
            retVo.setMsgTitle(e.getMessage());
        }
        return retVo;
    }

    @RequestMapping("/put")
    public RetVo put(String key, String value) {
        RetVo retVo = new RetVo(true);
        try {
            cacheFacade.put(key, value);
        } catch (Exception e) {
            retVo.setResult(false);
            retVo.setMsgTitle(e.getMessage());
        }
        return retVo;
    }

    @RequestMapping("/removeCache")
    public RetVo removeCache(@RequestParam("key") String key) {
        RetVo retVo = new RetVo(true);
        try {
            Object object = cacheFacade.remove(key);
            retVo.setObject(object);
        } catch (Exception e) {
            retVo.setResult(false);
            retVo.setMsgTitle(e.getMessage());
        }
        return retVo;
    }
}
