package com.ffcs.crmd.cas.sys.api.dto;

import com.ffcs.crmd.cas.core.ddd.api.dto.impl.CrmdBaseDTO;

/**
 * .
 *
 * @author Luxb
 * @version Revision 1.0.0
 * @版权：福富软件 版权所有 (c) 2011
 * @see:
 * @创建日期：2016/1/9
 * @功能说明：
 */
public class SceneTypeDTO  extends CrmdBaseDTO {
    private static final long serialVersionUID = 1598179584838497003L;
    /**
     * 业务类型。
     */
    private String sceneType;
    /**
     * 业务类型名称。
     */
    private String sceneTypeName;

    public String getSceneType() {
        return sceneType;
    }

    public void setSceneType(String sceneType) {
        this.sceneType = sceneType;
    }

    public String getSceneTypeName() {
        return sceneTypeName;
    }

    public void setSceneTypeName(String sceneTypeName) {
        this.sceneTypeName = sceneTypeName;
    }
}
