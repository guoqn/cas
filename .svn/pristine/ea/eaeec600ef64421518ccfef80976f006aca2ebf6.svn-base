package com.ffcs.crmd.cas.order.api.facade;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.cas.base.api.AcrossOrgDTO;
import com.ffcs.crmd.cas.core.ddd.api.facade.ICrmdBaseFacade;
import com.ffcs.crmd.cas.order.api.dto.*;
import com.ffcs.crmd.cas.sys.api.dto.AttrValueDTO;
import com.ffcs.crmd.cas.sys.api.dto.StaffDTO;
import com.ffcs.crmd.platform.pub.vo.RetVo;

import java.util.List;

public interface IPreSaleOrderPoolFacade extends ICrmdBaseFacade {

    int savePreSaleOrderPoolAccept(PreSaleOrderPoolDTO preSaleOrderPoolDTO, String isLeaderAssign);

    /**
     * 查询预受理单数量统计
     *
     * @param acrossOrgDTO
     * @return
     */
    PreSaleOrderPoolAmountDTO queryPreSaleOrderPoolAmount(AcrossOrgDTO acrossOrgDTO);

    PreSaleOrderPoolAmountDTO queryPreSaleOrderPoolReceiveAmount(AcrossOrgDTO acrossOrgDTO,Long orgId,
        Long staffId);

    /**
     * 根据条件可以预受理工单池数量
     *
     * @author YULIYAO 2016/2/23
     * return
     */
    int getPreSaleOrderPoolAmount(PreSaleOrderPoolDTO preSaleOrderPoolDTO,
        AcrossOrgDTO acrossOrgDTO);

    /**
     * 查询工单池
     *
     * @author YULIYAO 2016/2/3
     * return
     */
    PageInfo queryPreSaleOrderPool(PreSaleOrderPoolDTO preSaleOrderPoolDTO, Long areaId,
        Long orgId, AcrossOrgDTO acrossOrgDTO);

    /**
     * 保存预受理工单池，状态已接收.
     *
     * @param preSaleOrderPoolDTO
     * @return
     */
    int savePreSaleOrderPoolAccept(PreSaleOrderPoolDTO preSaleOrderPoolDTO);

    AcrossOrgDTO getAcrossOrgInit(Long areaId, Long orgId);

    /**
     * 预受理工单批量转单。
     *
     * @param dtos
     * @return
     */
    int savePreSaleOrderPoolAcceptBatch(List<PreSaleOrderPoolDTO> dtos, String staffId);

    /**
     * 设置为部分受理。
     *
     * @param preSaleOrderPoolDTO
     * @return
     */
    int returnToAccept(PreSaleOrderPoolDTO preSaleOrderPoolDTO);

    /**
     * 获取员工列表。
     *
     * @param orgId
     * @return
     */
    List<StaffDTO> queryStaffList(Long orgId);

    /**
     * 判断是否是拍照甩单，并且没有关联别的订单或者订单项.
     *
     * @param preSaleOrderDTO
     * @return
     */
    boolean checkPhotoNotReDeal(PreSaleOrderDTO preSaleOrderDTO);

    /**
     * 设置为全部受理.
     *
     * @author YULIYAO 2016/2/24
     * return
     */
    boolean completePool(PreSaleOrderPoolDTO preSaleOrderPoolDTO);

    /**
     * 继续受理
     *
     * @author YULIYAO 2016/2/25
     * return
     */
    String continueAccept(Long extCustOrderId);

    /**
     * 根据预受理编号查询正式单，含一表和二表
     *
     * @author YULIYAO 2016/2/27
     * return
     */
    List<CustomerOrderDTO> queryCustomerOrder(String preOrderNumber);

    /**
     * 退单
     *
     * @author YULIYAO 2016/2/29
     * return
     */
    String goBack(PreSaleOrderPoolDTO preSaleOrderPoolDTO, AttrValueDTO attrValueDTO,
                  String staffName,
                  String staffPhone, String backReason);

    int update(PreSaleOrderPoolDTO preSaleOrderPoolDTO);

    /**
     * 接收工单
     * 接收三张工单池中“未接收”状态的订单，设置工单池记录的接收员工为当前登陆员工，设置接收团队为当前登陆团队，更新接收时间，设置“是否班长派单”标识为0，表示不是班长派单，状态设置为已接收
     *
     * @author YULIYAO 2016/3/2
     * return
     */
    boolean acceptOrder(Long staffId, Long orgId, Long areaId, AcrossOrgDTO acrossOrgDTO);

    /**
     * 工单分布
     *
     * @param staffId
     * @return
     */
    List<AutoAssignDTO> qryPreOrderDistribute(Long staffId);

    /**
     * 根据预受理单ID，查询工单池
     *
     * @author YULIYAO 2016/3/15
     * return
     */
    PreSaleOrderPoolDTO getByPreOrderId(Long preOrderId);

    /**
     * 保存
     *
     * @author YULIYAO 2016/3/15
     * return
     */
    int save(PreSaleOrderPoolDTO orderPoolDTO);

    /**
     * 根据受理单ID，查询历史工单池
     *
     * @param preOrderId
     * @return
     */
    PreSaleOrderPoolHisDTO getHisPoolByPreSaleId(Long preOrderId);

    /**
     * 上传附件
     *
     * @author laiyongmin
     */
    public void uploadFiles(Long preOrderId, String fileName, byte[] bytes);

    /**
     * 查询工单池初始界面区域控件
     * @author YULIYAO 2016/5/11
     * return 
     */
    PageInfo queryInitPoolRegion(AcrossOrgDTO acrossOrgDTO, String regionName, int pageNum, int pageSize);
    /**
     * 超时预警清单
     * @param inParam
     * @return
     * @author linguanghao
     */
    RetVo qryPreSaleOrderOverTimeList(com.ffcs.crmd.cas.bean.devops.qryPreSaleOrderOverTimeList.InParam inParam);
}
