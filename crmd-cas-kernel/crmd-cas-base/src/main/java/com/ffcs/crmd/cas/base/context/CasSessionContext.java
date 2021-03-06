package com.ffcs.crmd.cas.base.context;

import org.apache.log4j.Logger;

import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.pub.context.SessionContext;
import com.ffcs.crmd.cas.base.api.LoginDTO;
import com.ffcs.crmd.cas.constants.CasConstant;
import com.ffcs.crmd.platform.pub.facade.CrmSessionContext;

/**
 * 功能说明:Session操作上下文
 *
 * @author Luxb
 * @Date 2016年2月17日 下午2:57:56
 * <p/>
 * <p/>
 * 版本号  |   作者   |  修改时间   |   修改内容
 */
public class CasSessionContext extends CrmSessionContext {
    private static Logger logger = Logger.getLogger(CasSessionContext.class);
    /**
     * 区域ID。
     */
    public static final String       AREA_ID                                  = "areaId";
    
    /**
     * 员工任职关系ID
     */
    public static final String       STAFF_POSITION_ID                       = "staffPositionId";
    
    /**
     * 组织名称
     */
    public static final String       ORG_NAME                                 = "orgName";
    /**
     * 区域名称。
     */
    public static final String      REGION_NAME 							    = "regionName";
    /**
     * 渠道编码。
     */
    public static final String      CHANNEL_CODE								= "channelCode";
    
    /**
     * 登录对象信息
     */
    public static final String       LOGIN_DETAIL                             = "loginDetail";
    /**
     * 员工名称.
     */
    public static final String       STAFF_NAME                               = "staffName";
    
    private static CasSessionContext casSessionContext                        = new CasSessionContext();
    
    public static CasSessionContext getContext() {
        return casSessionContext;
    }
    
    /**
     * .
     */
    public CasSessionContext() {

    }

    /**
     * 获取区域Id.
     * @return
     */
    public Long getAreaId() {
        Object obj = SessionContext.getValue(AREA_ID);
        if (obj != null) {
            return NumberUtils.nullToLongZero(obj);
        }
        return 2L;
    }

    @Override
    public Long getOrgId() {
        Long orgId = super.getOrgId();
        if (orgId == null) {
            orgId = 14388L;
        }
        return orgId;
    }

    @Override
    public Long getStaffId() {
        Long staffId = super.getStaffId();
        if (staffId == null) {
            staffId = 50924L;
        }
        return staffId;
    }

    /**
     * 设置区域ID。
     * @param areaId
     */
    public void setAreaId(Long areaId) {
        SessionContext.setValue(AREA_ID,areaId);
    }

    /**
     * 获取区域Id.
     * @return
     */
    public String getStaffName() {
        return StringUtils.strnull(SessionContext.getValue(STAFF_NAME));
    }

    /**
     * 设置区域ID。
     * @param staffName
     */
    public void setStaffName(String staffName) {
        SessionContext.setValue(STAFF_NAME,staffName);
    }

    /**
     * 获取区域ID。
     * @return
     */
	public Long getRegionCd() {
        Object obj = SessionContext.getValue(REGION_ID);
        if (obj != null) {
            return NumberUtils.nullToLongZero(obj);
        }
        return 11L;
    }

    /**
     * 获取任职资格ID。
     * @return
     */
    public Long getStaffPositionId() {
        Object obj = SessionContext.getValue(STAFF_POSITION_ID);
        if (obj != null) {
            return NumberUtils.nullToLongZero(obj);
        }
        return 0L;
    }

    /**
     * 设置任职资格
     * @param staffPositionId
     */
    public void setStaffPositionId(Long staffPositionId) {
        SessionContext.setValue(STAFF_POSITION_ID,staffPositionId);
    }

    /**
     * 
     * 获取团队名称.
     * 
     * @return
     * @author Luxb
     * 2016年5月17日 Luxb
     */
    public String getOrgName() {
        return StringUtils.strnull(SessionContext.getValue(ORG_NAME));
    }

    /**
     * 设置团队名称.
     * @param orgName
     */
    public void setOrgName(String orgName) {
        SessionContext.setValue(ORG_NAME,orgName);
    }
    /**
     * 
     * 获取区域的名称.
     * 
     * @return
     * @author Luxb
     * 2016年5月17日 Luxb
     */
    public String getRegionName() {
        return StringUtils.strnull(SessionContext.getValue(REGION_NAME));
    }

    /**
     * 设置区域名称.
     * @param regionName
     */
    public void setRegionName(String regionName) {
        SessionContext.setValue(REGION_NAME,regionName);
    }
    /**
     * 渠道编码
     * channelCode
     */
    public String getChannelCode(){
        return StringUtils.strnull(SessionContext.getValue(CHANNEL_CODE));
    }

    /**
     * 设置渠道名称.
     * @param channelCode
     */
    public void setChannelCode(String channelCode) {
        SessionContext.setValue(CHANNEL_CODE,channelCode);
    }
    /**
     * 获取登录对象信息
     * .
     * 
     */
    public Object getLoginDetail() {
        return SessionContext.getValue(LOGIN_DETAIL);
    }
    
    /**
     * 设置登录对象信息
     * .
     */
    public void setLoginDetail(Object loginDetail) {
        SessionContext.setValue(LOGIN_DETAIL, loginDetail);
    }
}