package com.ffcs.crmd.cas.order.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YULIYAO on 2016/5/7.
 */
public class AcrossOrgVo {

    List<Long>   orgAssignOrg      = new ArrayList<>();
    List<Long>   c4AssignOrg       = new ArrayList<>();
    List<Long>   c3AssignOrg       = new ArrayList<>();
    List<Long>   notInOrgAssignOrg = new ArrayList<>();
    List<Long>   notInC3AssignOrg  = new ArrayList<>();
    List<Long>   notInC4AssignOrg  = new ArrayList<>();
    List<String> sceneTypes        = new ArrayList<>();

    public List<Long> getOrgAssignOrg() {
        return orgAssignOrg;
    }

    public void setOrgAssignOrg(List<Long> orgAssignOrg) {
        this.orgAssignOrg = orgAssignOrg;
    }

    public List<Long> getC4AssignOrg() {
        return c4AssignOrg;
    }

    public void setC4AssignOrg(List<Long> c4AssignOrg) {
        this.c4AssignOrg = c4AssignOrg;
    }

    public List<Long> getC3AssignOrg() {
        return c3AssignOrg;
    }

    public void setC3AssignOrg(List<Long> c3AssignOrg) {
        this.c3AssignOrg = c3AssignOrg;
    }

    public List<Long> getNotInOrgAssignOrg() {
        return notInOrgAssignOrg;
    }

    public void setNotInOrgAssignOrg(List<Long> notInOrgAssignOrg) {
        this.notInOrgAssignOrg = notInOrgAssignOrg;
    }

    public List<Long> getNotInC3AssignOrg() {
        return notInC3AssignOrg;
    }

    public void setNotInC3AssignOrg(List<Long> notInC3AssignOrg) {
        this.notInC3AssignOrg = notInC3AssignOrg;
    }

    public List<Long> getNotInC4AssignOrg() {
        return notInC4AssignOrg;
    }

    public void setNotInC4AssignOrg(List<Long> notInC4AssignOrg) {
        this.notInC4AssignOrg = notInC4AssignOrg;
    }

    public List<String> getSceneTypes() {
        return sceneTypes;
    }

    public void setSceneTypes(List<String> sceneTypes) {
        this.sceneTypes = sceneTypes;
    }
}
