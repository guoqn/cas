package com.ffcs.crmd.cas.order.api.facade;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.api.facade.ICrmdBaseFacade;
import com.ffcs.crmd.cas.order.api.dto.OrgSceneTypeRelDTO;
import com.ffcs.crmd.cas.order.api.vo.OrgSceneTypeRelVo;

import java.util.List;

public interface IOrgSceneTypeRelFacade extends ICrmdBaseFacade {

    /**
     * 添加
     * @param orgSceneTypeRelDTO
     * @return
     */
    public int save(OrgSceneTypeRelDTO orgSceneTypeRelDTO);

    public int remove(OrgSceneTypeRelDTO orgSceneTypeRelDTO);

    public int update(OrgSceneTypeRelDTO orgSceneTypeRelDTO);

    /**
     * 查询团队受理类型关联,分页
     * @param orgSceneTypeRelVo
     * @return
     */
    public PageInfo queryOrgBySceneType(OrgSceneTypeRelVo orgSceneTypeRelVo);

    /**
     * 查询团队受理类型关联
     * @author YULIYAO 2016/2/16
     * return 
     */
    List<OrgSceneTypeRelDTO> queryOrgSceneTypeRel(OrgSceneTypeRelVo vo);
}
