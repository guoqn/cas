package com.ffcs.crmd.cas.order.api.facade;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.api.facade.ICrmdBaseFacade;
import com.ffcs.crmd.cas.order.api.dto.InteractionAssignOrgDTO;
import com.ffcs.crmd.cas.order.api.vo.InteractionAssignOrgVo;

import java.util.List;

public interface IInteractionAssignOrgFacade extends ICrmdBaseFacade {

    /**
     * 保存
     * @author YULIYAO 2016/1/5
     * return
     */
    public int save(InteractionAssignOrgDTO interactionAssignOrgDTO);

    /**
     * 修改
     * @author YULIYAO 2016/1/5
     * return
     */
    public int update(InteractionAssignOrgDTO interactionAssignOrgDTO);

    /**
     * 删除
     * @author YULIYAO 2016/1/5
     * return
     */
    public int remove(InteractionAssignOrgDTO interactionAssignOrgDTO);

    /**
     * 根据流程名称查询工单池流程
     * @author YULIYAO 2016/1/5
     * return
     */
    public PageInfo queryAssignOrg(InteractionAssignOrgVo interactionAssignOrgVo);

    /**
     * 转派团队配置信息获取。
     * @param interactionAssignOrgDTO
     * @return
     */
    List<InteractionAssignOrgDTO> queryAllAssignOrgs(InteractionAssignOrgDTO interactionAssignOrgDTO);

    /**
     * 接口查询团队配置
     * @author YULIYAO 2016/4/29
     * return 
     */
    List<InteractionAssignOrgDTO> queryAssignOrgIntf(Long execusteOrgId, List<String> regionCds);
}
