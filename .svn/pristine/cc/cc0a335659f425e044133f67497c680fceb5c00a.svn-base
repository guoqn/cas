package com.ffcs.crmd.cas.order.api.facade;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.core.ddd.api.facade.ICrmdBaseFacade;
import com.ffcs.crmd.cas.intf.api.dto.AutoGenOrderInDTO;
import com.ffcs.crmd.cas.order.api.dto.AutoGenOrderDTO;
import com.ffcs.crmd.platform.pub.vo.RetVo;

import java.util.List;

public interface IAutoGenOrderFacade extends ICrmdBaseFacade {
    /**
     * 普坤自动信息保存。
     * @param inDTO
     * @return
     */
    int saveAutoGenOrder(AutoGenOrderInDTO inDTO);

    /**
     * 普坤自动化受理结果接收处理.
     * @param preOrderNumber
     * @param autoGenResult
     * @param resultDesc
     * @param pic
     * @param errCode
     * @return
     */
    RetVo autoGenOrderCompleteInner(String preOrderNumber, String autoGenResult, String resultDesc, String pic, String errCode);

    List<AutoGenOrderDTO> queryAutoGenOrder(AutoGenOrderDTO autoGenOrderDTO);

    PageInfo queryAutoGenOrderPage(AutoGenOrderDTO autoGenOrderDTO);

    /**
     * 轮洵查询：创建状态，关联的P单为待受理，关联的工单池接收员工为空或者是接口工号
     * @author YULIYAO 2016/3/15
     * return 
     */
    List<AutoGenOrderDTO> queryAutoGenOrderSentPk(int modelCount,int model,int pageSize);

    /**
     * 查询自动受理单报文
     * @author YULIYAO 2016/3/15
     * return 
     */
    String getXmlMsg(Long autoGenOrderId);

    /**
     * 保存
     * @author YULIYAO 2016/3/15
     * return 
     */
    int save(AutoGenOrderDTO autoGenOrderDTO);

    /**
     * 删除
     * @author YULIYAO 2016/3/16
     * return 
     */
    int remove(AutoGenOrderDTO autoGenOrderDTO);

    /**
     * 送普坤
     * @author YULIYAO 2016/4/19
     * return
     */
    RetVo sendToPk(AutoGenOrderDTO autoGenOrderDTO);
}
