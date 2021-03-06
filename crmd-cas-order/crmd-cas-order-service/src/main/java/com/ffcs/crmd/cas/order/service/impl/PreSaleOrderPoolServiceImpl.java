package com.ffcs.crmd.cas.order.service.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.CollectionUtils;
import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.cas.base.context.CasSessionContext;
import com.ffcs.crmd.cas.base.utils.PageUtil;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.cas.core.ddd.service.impl.AbsCrmdGenericServiceImpl;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderPool;
import com.ffcs.crmd.cas.order.entity.PreSaleOrderPoolHis;
import com.ffcs.crmd.cas.order.repository.IPreSaleOrderPoolRepository;
import com.ffcs.crmd.cas.order.service.IPreSaleOrderPoolService;
import com.ffcs.crmd.cas.order.vo.PreSaleOrderOverTimeListVo;
import com.ffcs.crmd.cas.order.vo.PreSaleOrderPoolVo;
import com.ffcs.crmd.cas.sys.entity.CommonRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service("preSaleOrderPoolService")
public class PreSaleOrderPoolServiceImpl extends AbsCrmdGenericServiceImpl<PreSaleOrderPool, Long>
    implements IPreSaleOrderPoolService {

   	@Autowired
	IPreSaleOrderPoolRepository preSaleOrderPoolRepository;
   	
	@Override
	public PreSaleOrderPool getPreSaleOrderPoolByOrderId(Long preOrderId) {
		Map param = new HashMap<>();
		param.put("preOrderId", preOrderId);
		param.put("shardingId", preOrderId);
		List<PreSaleOrderPool> preSaleOrderPoolList = PreSaleOrderPool.repository().queryPreSaleOrderPool(param);
		if (CollectionUtils.isNotEmpty(preSaleOrderPoolList)) {
			return preSaleOrderPoolList.get(0);
		}
		return null;
	}

	@Override
	public PageInfo queryPreSaleOrderPool(PreSaleOrderPoolVo vo) {
		List<PreSaleOrderPool> preSaleOrderPools = new ArrayList<>();
		int total = 0;
		Map param = buildQueryParam(vo);
		//1.先查询当前团队配置的'团队对团队'配置
		if (vo.getOrgAssignOrg() != null && vo.getOrgAssignOrg().size() > 0) {
			Map param1 = new HashMap();
			param1.putAll(param);
			param1.put("orgAssinOrg", vo.getOrgAssignOrg());
			PageInfo pageInfo1 = preSaleOrderPoolRepository
					.queryPreSaleOrderPool(param1,1,vo.getPageNumber()*vo.getPageSize());
			preSaleOrderPools.addAll(pageInfo1 == null ? null : pageInfo1.getList());
			total += pageInfo1 == null ? 0 : pageInfo1.getTotal();
		}
		//2.如果有配置C3区域，则再查询C3区域下的团队的订单，并过滤掉别的团队配置的C4区域和团队
		if (vo.getC3AssignOrg() != null && vo.getC3AssignOrg().size() > 0) {
			Map param2 = new HashMap();
			param2.putAll(param);
			param2.put("c3AssignOrg", vo.getC3AssignOrg());
			param2.put("notInC4AssignOrg", vo.getNotInC4AssignOrg());
			param2.put("notInOrgAssignOrg", vo.getNotInOrgAssignOrg());
			PageInfo pageInfo2 = preSaleOrderPoolRepository
					.queryPreSaleOrderPool(param2,1,vo.getPageNumber()*vo.getPageSize());
			preSaleOrderPools.addAll(pageInfo2 == null ? null : pageInfo2.getList());
			total += pageInfo2 == null ? 0 : pageInfo2.getTotal();
		}
		//3.如果有配置C4区域，则查询C4区域下的所有团队的订单，并过滤掉别的团队配置的团队
		if (vo.getC4AssignOrg() != null && vo.getC4AssignOrg().size() > 0) {
			Map param3 = new HashMap();
			param3.putAll(param);
			param3.put("c4AssignOrg", vo.getC4AssignOrg());
			param3.put("notInOrgAssignOrg", vo.getNotInOrgAssignOrg());
			PageInfo pageInfo3 = preSaleOrderPoolRepository
					.queryPreSaleOrderPool(param3,1,vo.getPageNumber()*vo.getPageSize());
			preSaleOrderPools.addAll(pageInfo3 == null ? null : pageInfo3.getList());
			total += pageInfo3 == null ? 0 : pageInfo3.getTotal();
		}
		//4.对list进行排序
		Collections.sort(preSaleOrderPools, new PoolComparator());
		return PageUtil.list2PageInfo(preSaleOrderPools, total, vo.getPageNumber(), vo.getPageSize());
	}

	/**
	 * 预受理工单池查询构建参数
	 * @author YULIYAO 2016/4/20
	 * return 
	 */
	private Map buildQueryParam(PreSaleOrderPoolVo vo) {
		Map param = new HashMap();
		//参数：工单池状态-list
		if (CollectionUtils.isNotEmpty(vo.getStatusCdList())) {
			param.put("statusCdList", vo.getStatusCdList());
		}
		//参数：接收员工
		if (!StringUtils.isNullOrEmpty(vo.getStaffId())) {
			param.put("staffId", vo.getStaffId());
		}
		//参数：预受理区域C3
		if (!StringUtils.isNullOrEmpty(vo.getAreaId())) {
			param.put("areaId", vo.getAreaId());
		}
		//参数：预受理区域C4
		if (!StringUtils.isNullOrEmpty(vo.getRegionCd())) {
			param.put("regionCd", vo.getRegionCd());
		}
		//参数：预受理团队
		if (!StringUtils.isNullOrEmpty(vo.getOrgId())) {
			param.put("orgId", vo.getOrgId());
		}
		//参数：预受理员工
		if (!StringUtils.isNullOrEmpty(vo.getCreateStaff())) {
			param.put("createStaff", vo.getCreateStaff());
		}
		//参数：开始时间
		if (!StringUtils.isNullOrEmpty(vo.getBeginTime())) {
			param.put("beginTime", DateUtils.date2Str(vo.getBeginTime()));
		}
		//参数：结束时间
		if (!StringUtils.isNullOrEmpty(vo.getEndTime())) {
			param.put("endTime", DateUtils.date2Str(vo.getEndTime()));
		}
		//参数：预受理单ID
		if (!StringUtils.isNullOrEmpty(vo.getPreSaleOrderIds())) {
			param.put("preSaleOrderIds", vo.getPreSaleOrderIds());
		}
		//参数：工单池流向配置的业务类型
		if (vo.getSceneTypes() != null && vo.getSceneTypes().size() > 0) {
			param.put("sceneTypes", vo.getSceneTypes());
		}
		//参数：界面传来的业务类型
		if (vo.getSceneTypeList() != null && vo.getSceneTypeList().size() > 0) {
			param.put("sceneTypeList", vo.getSceneTypeList());
		}
		//参数：不查询的状态
		if (!StringUtils.isNullOrEmpty(vo.getNotStatusCd())) {
			param.put("notStatusCd", vo.getNotStatusCd());
		}
		//参数：状态
		if (!StringUtils.isNullOrEmpty(vo.getStatusCd())) {
			param.put("statusCd", vo.getStatusCd());
		}
		//参数：业务类型
		if (!StringUtils.isNullOrEmpty(vo.getServiceType())) {
			param.put("serviceType", vo.getServiceType());
		}
		//参数：订单来源
		if (!StringUtils.isNullOrEmpty(vo.getPreOrderSrc())) {
			param.put("preOrderSrc", vo.getPreOrderSrc());
		}
		//接收团队
		if (!StringUtils.isNullOrEmpty(vo.getAcceptOrgId())) {
			param.put("acceptOrgId", vo.getAcceptOrgId());
		}
		return param;
	}

	@Override
	public List<PreSaleOrderPool> queryPreSaleOrderPoolList(PreSaleOrderPoolVo vo) {
		List<PreSaleOrderPool> preSaleOrderPools = new ArrayList<>();
		Map param = buildQueryParam(vo);
		//1.先查询当前团队配置的'团队对团队'配置
		if (vo.getOrgAssignOrg() != null && vo.getOrgAssignOrg().size() > 0) {
			Map param1 = new HashMap();
			param1.putAll(param);
			param1.put("orgAssinOrg", vo.getOrgAssignOrg());
			List<PreSaleOrderPool> preSaleOrderPools1 = PreSaleOrderPool.repository()
					.queryPreSaleOrderPool(param1);
			preSaleOrderPools.addAll(preSaleOrderPools1);
		}
		//2.如果有配置C3区域，则再查询C3区域下的团队的订单，并过滤掉别的团队配置的C4区域和团队
		if (vo.getC3AssignOrg() != null && vo.getC3AssignOrg().size() > 0) {
			Map param2 = new HashMap();
			param2.putAll(param);
			param2.put("c3AssignOrg", vo.getC3AssignOrg());
			param2.put("notInC4AssignOrg", vo.getNotInC4AssignOrg());
			param2.put("notInOrgAssignOrg", vo.getNotInOrgAssignOrg());
			List<PreSaleOrderPool> preSaleOrderPools2 = preSaleOrderPoolRepository
					.queryPreSaleOrderPool(param2);
			preSaleOrderPools.addAll(preSaleOrderPools2);
		}
		//3.如果有配置C4区域，则查询C4区域下的所有团队的订单，并过滤掉别的团队配置的团队
		if (vo.getC4AssignOrg() != null && vo.getC4AssignOrg().size() > 0) {
			Map param3 = new HashMap();
			param3.putAll(param);
			param3.put("c4AssignOrg", vo.getC4AssignOrg());
			param3.put("notInOrgAssignOrg", vo.getNotInOrgAssignOrg());
			List<PreSaleOrderPool> preSaleOrderPools3 = preSaleOrderPoolRepository
					.queryPreSaleOrderPool(param3);
			preSaleOrderPools.addAll(preSaleOrderPools3);
		}
		//4.对list进行排序
		Collections.sort(preSaleOrderPools, new PoolComparator());
		return preSaleOrderPools;
	}

	@Override
	public int queryPreSaleOrderPoolAmount(PreSaleOrderPoolVo vo) {
		int amount = 0;
		Map param = buildQueryParam(vo);
		//参数：设置本地网和过滤状态
		param.put("areaId", CasSessionContext.getContext().getAreaId());
		param.put("notStatusCd", CasConstant.PRE_POOL_STATUS_CD_WAIT_FOR_AUDIT.getValue());
		//1.先查询当前团队配置的'团队对团队'配置
		if (vo.getOrgAssignOrg() != null && vo.getOrgAssignOrg().size() > 0) {
			Map param1 = new HashMap();
			param1.putAll(param);
			param1.put("orgAssinOrg", vo.getOrgAssignOrg());
			int amount1 = preSaleOrderPoolRepository
					.queryPreSaleOrderPoolAmount(param1);
			amount += amount1;
		}
		//2.如果有配置C3区域，则再查询C3区域下的团队的订单，并过滤掉别的团队配置的C4区域和团队
		if (vo.getC3AssignOrg() != null && vo.getC3AssignOrg().size() > 0) {
			Map param2 = new HashMap();
			param2.putAll(param);
			param2.put("c3AssignOrg", vo.getC3AssignOrg());
			param2.put("notInC4AssignOrg", vo.getNotInC4AssignOrg());
			param2.put("notInOrgAssignOrg", vo.getNotInOrgAssignOrg());
			int amount2 = preSaleOrderPoolRepository
					.queryPreSaleOrderPoolAmount(param2);
			amount += amount2;
		}
		//3.如果有配置C4区域，则查询C4区域下的所有团队的订单，并过滤掉别的团队配置的团队
		if (vo.getC4AssignOrg() != null && vo.getC4AssignOrg().size() > 0) {
			Map param3 = new HashMap();
			param3.putAll(param);
			param3.put("c4AssignOrg", vo.getC4AssignOrg());
			param3.put("notInOrgAssignOrg", vo.getNotInOrgAssignOrg());
			int amount3 = preSaleOrderPoolRepository
					.queryPreSaleOrderPoolAmount(param3);
			amount += amount3;
		}
		return amount;
	}

	/**
	 * 工单池查询比较器
	 * 1、priority升序（空最后）
	 * 2、is_leader_assign倒序
	 * 3、create_date升序
	 * @author YULIYAO 2016/3/2
	 * return
	 */
	class PoolComparator implements Comparator {

		@Override
		public int compare(Object o1, Object o2) {
			PreSaleOrderPool preSaleOrderPool1 = (PreSaleOrderPool) o1;
			PreSaleOrderPool preSaleOrderPool2 = (PreSaleOrderPool) o2;
			int result = 0;
			//1、priority升序（空最后）
			Long priority1 =
					preSaleOrderPool1.getPriority() == null ? 99L : preSaleOrderPool1.getPriority();
			Long priority2 =
					preSaleOrderPool2.getPriority() == null ? 99L : preSaleOrderPool2.getPriority();
			result = priority1.compareTo(priority2);
			if (result == 0) {
				//2、is_leader_assign倒序
				result = -StringUtils.strnull(preSaleOrderPool1.getIsLeaderAssign())
						.compareTo(StringUtils.strnull(preSaleOrderPool2.getIsLeaderAssign()));
				if (result == 0) {
					//3、create_date升序
					Timestamp timestamp = new Timestamp(new Date().getTime());
					Timestamp timestamp1 = preSaleOrderPool1.getCreateDate() == null ?
							timestamp :
							preSaleOrderPool1.getCreateDate();
					Timestamp timestamp2 = preSaleOrderPool2.getCreateDate() == null ?
							timestamp :
							preSaleOrderPool2.getCreateDate();
					result = timestamp1.compareTo(timestamp2);
				}
			}
			return result;
		}
	}

	/**
	 * 根据预受理单ID，查询工单池
	 * @author YULIYAO 2016/3/15
	 * return
	 */
	@Override
	public PreSaleOrderPool getByPreOrderId(Long preOrderId) {
		Map param = new HashMap();
		param.put("preOrderId", preOrderId);
		List<PreSaleOrderPool> preSaleOrderPools = PreSaleOrderPool.repository()
				.queryPreSaleOrderPool(param);
		if (CollectionUtils.isNotEmpty(preSaleOrderPools)) {
			return preSaleOrderPools.get(0);
		}
		return null;
	}
	@Override
	public PreSaleOrderPoolHis getPreSaleOrderPoolHisByOrderId(Long preOrderId) {
		Map param = new HashMap<>();
		param.put("preOrderId", preOrderId);
		param.put("shardingId", preOrderId);
		List<PreSaleOrderPoolHis> preSaleOrderPoolList = preSaleOrderPoolRepository
				.queryPreSaleOrderPoolHis(param);
		if (CollectionUtils.isNotEmpty(preSaleOrderPoolList)) {
			return preSaleOrderPoolList.get(0);
		}
		return null;
	}

	/**
	 * 查询工单池初始界面区域控件
	 * @author YULIYAO 2016/5/11
	 * return
	 */
	@Override
	public PageInfo queryInitPoolRegion(Map param, int pageNum, int pageSize) {

		return preSaleOrderPoolRepository
				.queryPageInfoByName("preSaleOrderRepository.queryInitPoolRegion",
						CommonRegion.class, param, pageNum, pageSize);
	}

	@Override
	public List<PreSaleOrderOverTimeListVo> qryPreSaleOrderOverTimeList(Map map) {
		List<PreSaleOrderOverTimeListVo> list = preSaleOrderPoolRepository.qryPreSaleOrderOverTimeList(map);
		List<PreSaleOrderOverTimeListVo> hisList = preSaleOrderPoolRepository.qryPreSaleOrderOverTimeList(map);
		List<PreSaleOrderOverTimeListVo> all = new ArrayList<PreSaleOrderOverTimeListVo>();
		if(list !=null && list.size() >0){
			all.addAll(list);
		}
		if(hisList !=null && hisList.size() >0){
			all.addAll(hisList);
		}
		return all;
	}
}
