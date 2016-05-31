/*
归属模块：订单
关联CQ单：
脚本用途：集中受理配置地址
提交人:   郭泉宁
提交时间：20160307
发布环境：福建所有环境
注意事项：
*/

--  页面菜单权限 --预受理工单接收
delete from privilege a where a.privilege_code = 'CAS_PRE_ORDER_REC_URL';
insert into privilege (PRIVILEGE_ID, PRIVILEGE_NAME, PRIVILEGE_TYPE, PRIVILEGE_DESC, STATUS_CD, STATUS_DATE, CREATE_DATE, UPDATE_DATE, PARENT_PRIVILEGE_ID, SYS_TYPE, PATH, PRIVILEGE_SUB_TYPE, OPERATE_TYPE, DISP_ORDER, ICON_PATH, PRIVILEGE_CODE)
values (crmv2.seq_privilege_id.nextval, '预受理工单接收-cas', '1000', null, '1000', sysdate, sysdate, sysdate, 120, '100', '/mod_ds/ds_index.zul?page=preOrderRec', '10100', null, null, '/public/images/desktop/default.png', 'CAS_PRE_ORDER_REC_URL');
--  配置角色权限关系 --预受理工单接收
delete from role_auth_rel a where a.privilege_id = (select a.privilege_id from privilege a where a.privilege_code = 'CAS_PRE_ORDER_REC_URL');
insert into role_auth_rel (ROLE_PRIVILEGE_ID, ROLE_ID, PRIVILEGE_ID, EFFECT_DATE, EXPIRE_DATE, STATUS_CD, STATUS_DATE, CREATE_DATE, UPDATE_DATE, PRI_TYPE)
values (crmv2.seq_role_auth_rel_id.nextval, 1, (select a.privilege_id from privilege a where a.privilege_code = 'CAS_PRE_ORDER_REC_URL'), sysdate, sysdate, '1000', sysdate, sysdate, sysdate, '11');


--  页面菜单权限 --预受理工单池
delete from privilege a where a.privilege_code = 'CAS_PRE_ORDER_POOL_URL';
insert into privilege (PRIVILEGE_ID, PRIVILEGE_NAME, PRIVILEGE_TYPE, PRIVILEGE_DESC, STATUS_CD, STATUS_DATE, CREATE_DATE, UPDATE_DATE, PARENT_PRIVILEGE_ID, SYS_TYPE, PATH, PRIVILEGE_SUB_TYPE, OPERATE_TYPE, DISP_ORDER, ICON_PATH, PRIVILEGE_CODE)
values (crmv2.seq_privilege_id.nextval, '预受理工单池-cas', '1000', null, '1000', sysdate, sysdate, sysdate, 120, '100', '/mod_ds/ds_index.zul?page=preOrderPool', '10100', null, null, '/public/images/desktop/default.png', 'CAS_PRE_ORDER_POOL_URL');
--  配置角色权限关系  --预受理工单池
delete from role_auth_rel a where a.privilege_id = (select a.privilege_id from privilege a where a.privilege_code = 'CAS_PRE_ORDER_POOL_URL');
insert into role_auth_rel (ROLE_PRIVILEGE_ID, ROLE_ID, PRIVILEGE_ID, EFFECT_DATE, EXPIRE_DATE, STATUS_CD, STATUS_DATE, CREATE_DATE, UPDATE_DATE, PRI_TYPE)
values (crmv2.seq_role_auth_rel_id.nextval, 1, (select a.privilege_id from privilege a where a.privilege_code = 'CAS_PRE_ORDER_POOL_URL'), sysdate, sysdate, '1000', sysdate, sysdate, sysdate, '11');

--  页面菜单权限 --预受理缴费
delete from privilege a where a.privilege_code = 'CAS_PRE_ORDER_URL';
insert into privilege (PRIVILEGE_ID, PRIVILEGE_NAME, PRIVILEGE_TYPE, PRIVILEGE_DESC, STATUS_CD, STATUS_DATE, CREATE_DATE, UPDATE_DATE, PARENT_PRIVILEGE_ID, SYS_TYPE, PATH, PRIVILEGE_SUB_TYPE, OPERATE_TYPE, DISP_ORDER, ICON_PATH, PRIVILEGE_CODE)
values (crmv2.seq_privilege_id.nextval, '预受理缴费-cas', '1000', null, '1000', sysdate, sysdate, sysdate, 120, '100', '/mod_ds/ds_index.zul?page=preOrder', '10100', null, null, '/public/images/desktop/default.png', 'CAS_PRE_ORDER_URL');
--  配置角色权限关系  --预受理缴费
delete from role_auth_rel a where a.privilege_id = (select a.privilege_id from privilege a where a.privilege_code = 'CAS_PRE_ORDER_URL');
insert into role_auth_rel (ROLE_PRIVILEGE_ID, ROLE_ID, PRIVILEGE_ID, EFFECT_DATE, EXPIRE_DATE, STATUS_CD, STATUS_DATE, CREATE_DATE, UPDATE_DATE, PRI_TYPE)
values (crmv2.seq_role_auth_rel_id.nextval, 1, (select a.privilege_id from privilege a where a.privilege_code = 'CAS_PRE_ORDER_URL'), sysdate, sysdate, '1000', sysdate, sysdate, sysdate, '11');

--  页面菜单权限 --工单池流程
delete from privilege a where a.privilege_code = 'CAS_INTERACTION_FLOW_URL';
insert into privilege (PRIVILEGE_ID, PRIVILEGE_NAME, PRIVILEGE_TYPE, PRIVILEGE_DESC, STATUS_CD, STATUS_DATE, CREATE_DATE, UPDATE_DATE, PARENT_PRIVILEGE_ID, SYS_TYPE, PATH, PRIVILEGE_SUB_TYPE, OPERATE_TYPE, DISP_ORDER, ICON_PATH, PRIVILEGE_CODE)
values (crmv2.seq_privilege_id.nextval, '工单池流程-cas', '1000', null, '1000', sysdate, sysdate, sysdate, 120, '100', '/mod_ds/ds_index.zul?page=interactionFlow', '10100', null, null, '/public/images/desktop/default.png', 'CAS_INTERACTION_FLOW_URL');
--  配置角色权限关系  --工单池流程
delete from role_auth_rel a where a.privilege_id = (select a.privilege_id from privilege a where a.privilege_code = 'CAS_INTERACTION_FLOW_URL');
insert into role_auth_rel (ROLE_PRIVILEGE_ID, ROLE_ID, PRIVILEGE_ID, EFFECT_DATE, EXPIRE_DATE, STATUS_CD, STATUS_DATE, CREATE_DATE, UPDATE_DATE, PRI_TYPE)
values (crmv2.seq_role_auth_rel_id.nextval, 1, (select a.privilege_id from privilege a where a.privilege_code = 'CAS_INTERACTION_FLOW_URL'), sysdate, sysdate, '1000', sysdate, sysdate, sysdate, '11');

--  页面菜单权限 --团队关联受理类型
delete from privilege a where a.privilege_code = 'CAS_ORG_SCENE_TYPE_REL';
insert into privilege (PRIVILEGE_ID, PRIVILEGE_NAME, PRIVILEGE_TYPE, PRIVILEGE_DESC, STATUS_CD, STATUS_DATE, CREATE_DATE, UPDATE_DATE, PARENT_PRIVILEGE_ID, SYS_TYPE, PATH, PRIVILEGE_SUB_TYPE, OPERATE_TYPE, DISP_ORDER, ICON_PATH, PRIVILEGE_CODE)
values (crmv2.seq_privilege_id.nextval, '团队关联受理类型-cas', '1000', null, '1000', sysdate, sysdate, sysdate, 120, '100', '/mod_ds/ds_index.zul?page=orgSceneTypeRel', '10100', null, null, '/public/images/desktop/default.png', 'CAS_ORG_SCENE_TYPE_REL');
--  配置角色权限关系  --团队关联受理类型
delete from role_auth_rel a where a.privilege_id = (select a.privilege_id from privilege a where a.privilege_code = 'CAS_ORG_SCENE_TYPE_REL');
insert into role_auth_rel (ROLE_PRIVILEGE_ID, ROLE_ID, PRIVILEGE_ID, EFFECT_DATE, EXPIRE_DATE, STATUS_CD, STATUS_DATE, CREATE_DATE, UPDATE_DATE, PRI_TYPE)
values (crmv2.seq_role_auth_rel_id.nextval, 1, (select a.privilege_id from privilege a where a.privilege_code = 'CAS_ORG_SCENE_TYPE_REL'), sysdate, sysdate, '1000', sysdate, sysdate, sysdate, '11');

--  页面菜单权限 --预受理订单维护--单个关联
delete from privilege a where a.privilege_code = 'CAS_PRE_ORDER_SREL';
insert into privilege (PRIVILEGE_ID, PRIVILEGE_NAME, PRIVILEGE_TYPE, PRIVILEGE_DESC, STATUS_CD, STATUS_DATE, CREATE_DATE, UPDATE_DATE, PARENT_PRIVILEGE_ID, SYS_TYPE, PATH, PRIVILEGE_SUB_TYPE, OPERATE_TYPE, DISP_ORDER, ICON_PATH, PRIVILEGE_CODE)
values (crmv2.seq_privilege_id.nextval, '预受理订单维护-单个关联-cas', '1000', null, '1000', sysdate, sysdate, sysdate, 120, '100', '/mod_ds/ds_index.zul?page=preOrderSrel', '10100', null, null, '/public/images/desktop/default.png', 'CAS_PRE_ORDER_SREL');
--  配置角色权限关系  --预受理订单维护--单个关联
delete from role_auth_rel a where a.privilege_id = (select a.privilege_id from privilege a where a.privilege_code = 'CAS_PRE_ORDER_SREL');
insert into role_auth_rel (ROLE_PRIVILEGE_ID, ROLE_ID, PRIVILEGE_ID, EFFECT_DATE, EXPIRE_DATE, STATUS_CD, STATUS_DATE, CREATE_DATE, UPDATE_DATE, PRI_TYPE)
values (crmv2.seq_role_auth_rel_id.nextval, 1, (select a.privilege_id from privilege a where a.privilege_code = 'CAS_PRE_ORDER_SREL'), sysdate, sysdate, '1000', sysdate, sysdate, sysdate, '11');

-- 页面菜单权限 --预受理订单维护-单个关联
delete from privilege a where a.privilege_code = 'CAS_PRE_ORDER_BREL';
insert into privilege (PRIVILEGE_ID, PRIVILEGE_NAME, PRIVILEGE_TYPE, PRIVILEGE_DESC, STATUS_CD, STATUS_DATE, CREATE_DATE, UPDATE_DATE, PARENT_PRIVILEGE_ID, SYS_TYPE, PATH, PRIVILEGE_SUB_TYPE, OPERATE_TYPE, DISP_ORDER, ICON_PATH, PRIVILEGE_CODE)
values (crmv2.seq_privilege_id.nextval, '预受理订单维护-批量关联-cas', '1000', null, '1000', sysdate, sysdate, sysdate, 120, '100', '/mod_ds/ds_index.zul?page=preOrderBrel', '10100', null, null, '/public/images/desktop/default.png', 'CAS_PRE_ORDER_BREL');
--  配置角色权限关系  --预受理订单维护-单个关联
delete from role_auth_rel a where a.privilege_id = (select a.privilege_id from privilege a where a.privilege_code = 'CAS_PRE_ORDER_BREL');
insert into role_auth_rel (ROLE_PRIVILEGE_ID, ROLE_ID, PRIVILEGE_ID, EFFECT_DATE, EXPIRE_DATE, STATUS_CD, STATUS_DATE, CREATE_DATE, UPDATE_DATE, PRI_TYPE)
values (crmv2.seq_role_auth_rel_id.nextval, 1, (select a.privilege_id from privilege a where a.privilege_code = 'CAS_PRE_ORDER_BREL'), sysdate, sysdate, '1000', sysdate, sysdate, sysdate, '11');

-- 集中受理URL配置
-- http://134.132.66.55:8081/crmd-cas-web
-- http://134.132.66.207:8097/crmd-cas-web
delete from attr_spec where class_id = -100 and java_code = 'casPreOrderUrl';
insert into Attr_Spec (ATTR_ID, ATTR_CD, ATTR_NAME, ATTR_DESC, ATTR_VALUE_TYPE, DEFAULT_VALUE, VALUE_FROM, VALUE_TO, IS_UNIQUE, IS_NULLABLE, STATUS_CD, STATUS_DATE, CREATE_DATE, CLASS_ID, ATTR_TYPE, JAVA_CODE, ATTR_SEQ, CNS_TYPE, REF_CLASS_ID, ATTR_LEVEL, IS_DANY_ATTR, IS_MULTI_VALUE, AREA_ID, REGION_CD, UPDATE_STAFF, CREATE_STAFF, IS_PRINT, ATTR_LENGTH, CODE_BUILDER, CODE_PARAM1, COMPLETE_FLAG, VISIBLE_FLAG, ATTR_FORMAT, EFFECTIVE_TYPE, MOD_EFF_TYPE, DEFAULT_TIME_PERIOD, EXPIRE_TYPE, CNS_TYPE_EXTRA, IS_POST, HB_POST, EXT_ATTR_NBR, IS_TRANS, REMARK, PRINT_EXT, MANAGE_GRADE, COMMON_REGION_ID, OWNER_SYSTEM, ATTR_SPEC_CODE_RULE, ATTR_SPEC_EXT_RULE, SELFMOD_DISVALID, MAINMOD_DISVALID, MAINDEL_DISVALID, MAINEXTSO_DISVALID, SUPEXTSO_DISVALID, EXT_FLAG, GROUP_CD, EXT_RULE_FLAG, EVENT_PROC_TYPE, IS_INSTANTIATION, EXT_ATTR_CD)
values (950025917, 'CAS_PRE_ORDER_URL', '集中受理URL', '集中受理URL', 'C', 'http://134.132.66.207:8097/crmd-cas-web', '', '', '', '', '1000', sysdate, sysdate, -100, 'T1', 'casPreOrderUrl', null, '', null, '', 1, 0, 1, 1, 49822, null, '', null, '', '', '', '', '', '', '', null, '', '', null, '', '590023807', '', '', '', '', null, '', '', '', 0, 0, 0, '', '', '', '', '', '', '', '');
