package com.ffcs.crmd.cas.order.service;

import com.ffcs.crmd.cas.core.ddd.service.ICrmdGenericService;
import com.ffcs.crmd.cas.order.api.vo.OrgSceneTypeRelVo;
import com.ffcs.crmd.cas.order.entity.OrgSceneTypeRel;

import java.util.List;

public interface IOrgSceneTypeRelService extends ICrmdGenericService<OrgSceneTypeRel, Long> {

    /**
     * 查询团队关联业务类型
     * @author YULIYAO 2016/1/11
     * return
     */
    public List<OrgSceneTypeRel> queryOrgSceneTypeRel(OrgSceneTypeRelVo orgSceneTypeRelVo);
}
