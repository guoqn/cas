/**
 * 创建服务
 */

var casOrderServiceApp = angular.module("casOrderServiceApp", ["commonApp"]);

// 创建档案服务
casOrderServiceApp.service("casOrderService", ["commonService", function (commonService) {
    /*-------------------------------------登陆信息-----------------------------------------*/
    this.login = function (params, sback, eback) {
        commonService.call("sys/loginCtrl/login", params, sback, eback);
    }
    /*------------------------------------流程相关服务--------------------------------------*/
    //获取流程
    this.queryInterActionFlowData = function (params, sback, eback) {
        commonService.call("order/orderQuery/qryInterActionFlowList", params, sback, eback);
    }
    //初始化下拉框
    this.queryAllBoxListForInteractionFlow = function (params, sback, eback) {
        commonService.call("order/orderQuery/queryAllBoxListForInteractionFlow", params, sback, eback);
    }
    //删除流程
    this.delInteractionFlowData = function (params, sback, eback) {
        commonService.call("order/orderQuery/delInteractionFlow", params, sback, eback);
    }
    //保存流程
    this.saveInteractionFlowData = function (params, sback, eback) {
        commonService.call("order/orderQuery/saveInteractionFlow", params, sback, eback);
    }
    //删除流程校验是否存在转派团队
    this.qryAssignOrgCountData = function (params, sback, eback) {
        commonService.call("order/orderQuery/qryAssignOrgCount", params, sback, eback);
    }

    /*------------------------------转派团队相关服务------------------------------------*/
    //获取接触单转派团队
    this.qryInterActionAssignOrgData = function (params, sback, eback) {
        commonService.call("order/orderQuery/qryInterActionAssignOrgs", params, sback, eback);
    }
    //删除团队
    this.delInteractionAssgnOrg = function (params, sback, eback) {
        commonService.call("order/orderQuery/delInteractionAssignOrg", params, sback, eback);
    }
    //保存团队
    this.saveInteractionAssignOrg = function (params, sback, eback) {
        commonService.call("order/orderQuery/saveInteractionAssignOrg", params, sback, eback);
    }

    /*----------------------------------团队关联受理类型-------------------------------------*/
    //查询团队关联受理
    this.qryOrgSceneTypeRel = function (params, sback, eback) {
        commonService.call("order/orgSceneTypeRel/qryOrgSceneTypeRel", params, sback, eback);
    }
    //保存团队关联受理
    this.saveOrgSceneTypeRel = function (params, sback, eback) {
        commonService.call("order/orgSceneTypeRel/saveOrgSceneTypeOrg", params, sback, eback);
    }
    //删除团队关联受理
    this.delOrgSceneTypeRel = function (params, sback, eback) {
        commonService.call("order/orgSceneTypeRel/delOrgSceneTypeRel", params, sback, eback);
    }
    //初始化checkBox
    this.qryCheckBoxForOrgSceneTypeRel = function (params, sback, eback) {
        commonService.call("order/orgSceneTypeRel/qryCheckBoxForOrgSceneTypeRel", params, sback, eback);
    }

    /*------------------------------------预受理缴费--------------------------------------------*/
    //预受理查询
    this.qryPreSaleOrder = function (params, sback, eback) {
        commonService.call("order/preSaleOrder/qryPreSaleOrders", params, sback, eback);
    }
    //初始化下拉框
    this.queryAllBoxListForPreSaleOrder = function (params, sback, eback) {
        commonService.call("order/preSaleOrder/queryAllBoxListForPreSaleOrder", params, sback, eback);
    }
    // 区域
    this.qryRegionData = function (params, sback, eback) {
        commonService.call("sys/regionQuery/qryComRegion", params, sback, eback);
    }
    //处理过程
    this.qryPreSaleOrderProc = function (params, sback, eback) {
        commonService.call("order/preSaleOrder/qryPreSaleOrderProc", params, sback, eback);
    }
    //补收款保存
    this.remainPreSaleAcctItem = function (params, sback, eback) {
        commonService.call("order/preSaleOrder/reFee", params, sback, eback);
    }
    //归档处理
    this.archIveData = function (params, sback, eback) {
        commonService.call("order/preSaleOrder/archIve", params, sback, eback);
    }
    //撤销
    this.cancelPreOrderData = function (params, sback, eback) {
        commonService.call("order/preSaleOrder/cancelPreOrder", params, sback, eback);
    }
    //费用收取
    this.qryHbPreSaleUrl = function (params, sback, eback) {
        commonService.call("order/preSaleOrder/qryHbPreSaleUrl", params, sback, eback);
    }
    //是否展示机器人受理按钮
    this.isShowRobotBtn = function (params, sback, eback) {
        commonService.call("order/preSaleOrder/isShowRobotBtn", params, sback, eback);
    }
    //机器人受理
    this.robotAccept = function (params, sback, eback) {
        commonService.call("order/preSaleOrder/robotAccept", params, sback, eback);
    }
    
  //机器人受理
    this.updatePreSaleOrder = function (params, sback, eback) {
        commonService.call("order/preSaleOrder/updatePreSaleOrder", params, sback, eback);
    }

    /*----------------------------------预受理工单池-----------------------------------------*/
    //查询||接收
    this.qryPreSaleOrderPools = function (params, sback, eback) {
        commonService.call("order/preSaleOrderPool/qryPreSaleOrderPools", params, sback, eback);
    }
    //初始化下拉框
    this.queryAllBoxListForPreSaleOrderPool = function (params, sback, eback) {
        commonService.call("order/preSaleOrderPool/queryAllBoxListForPreSaleOrderPool", params, sback, eback);
    }
    //计算工单池数量
    this.qryPreSaleOrderPoolAmount = function (params, sback, eback) {
        commonService.call("order/preSaleOrderPool/queryPreSaleOrderPoolAmount", params, sback, eback);
    }
    //派单
    this.confirmAcceptData = function (params, sback, eback) {
        commonService.call("order/preSaleOrderPool/accept", params, sback, eback);
    }
    //设置为部分受理
    this.returnToAcceptData = function (params, sback, eback) {
        commonService.call("order/preSaleOrderPool/returnToAccept", params, sback, eback);
    }
    //批量派单
    this.batchAcceptsData = function (params, sback, eback) {
        commonService.call("order/preSaleOrderPool/batchAccepts", params, sback, eback);
    }
    /*-------------------------------------预受理工单池接收-------------------------------------*/
    //工单池接收查询
    this.qryPreSaleOrderRecData = function (params, sback, eback) {
        commonService.call("order/PreSaleOrderRec/qryPreSaleOrderRec", params, sback, eback);
    }
    //接收工单
    this.recPreSaleOrderData = function (params, sback, eback) {
        commonService.call("order/PreSaleOrderRec/recPreSaleOrder", params, sback, eback);
    }
    //工单分布distribute
    this.qryPreOrderDistributeData = function (params, sback, eback) {
        commonService.call("order/PreSaleOrderRec/qryPreOrderDistribute", params, sback, eback);
    }
    //退单
    this.sendBackPreOrder = function (params, sback, eback) {
        commonService.call("order/PreSaleOrderRec/sendBackPreSaleOrder", params, sback, eback);
    }
    //设置为全部受理
    this.returnToAllAcceptData = function (params, sback, eback) {
        commonService.call("order/PreSaleOrderRec/returnToAllAccept", params, sback, eback);
    }
    //接收总数量
    this.qryPreSaleOrderRecAmount = function (params, sback, eback) {
        commonService.call("order/PreSaleOrderRec/qryPreSaleOrderRecAmount", params, sback, eback);
    }
    //订单信息
    this.qryPreSaleOrderDetail = function (params, sback, eback) {
        commonService.call("order/PreSaleOrderRec/qryPreSaleOrderDetail", params, sback, eback);
    }
    //继续受理
    this.keepAcceptData = function (params, sback, eback) {
        commonService.call("order/PreSaleOrderRec/keepAccept", params, sback, eback);
    }
    //跳转CRM界面
    this.invokeToOrder = function (params, sback, eback) {
        commonService.invoke(ffc.context.crm2URL, params);
    }
    //转变更单
    this.onConvertToModOrderData = function (params, sback, eback) {
        commonService.call("order/PreSaleOrderRec/onConvertToModOrder", params, sback, eback);
    }
    //发送消息
    this.sendMessageData = function (params, sback, eback) {
        commonService.call("order/preSaleOrderPool/sendMessage", params, sback, eback);
    }
    //记录受理备注
    this.saveRemark = function (params, sback, eback) {
        commonService.call("order/PreSaleOrderRec/saveRemark", params, sback, eback);
    }
    //展示照片
    this.showPic = function (params, sback, eback) {
        commonService.call("order/PreSaleOrderRec/showPic", params, sback, eback);
    }

    /*-------------------------滚动需求-预受理关联订单-----------------------------------*/
    //单个关联--查询
    this.qryPreSaleOrderSrel = function (params, sback, eback) {
        commonService.call("order/maintanace/qryPreSaleOrderSrel", params, sback, eback);
    }
    //单个关联-关联connectNewPreOrder
    this.connectNewPreOrder = function (params, sback, eback) {
        commonService.call("order/maintanace/connectNewPreOrder", params, sback, eback);
    }
    //批量关联
    this.batchConnectPreOrder = function (params, sback, eback) {
        commonService.call("order/maintanace/batchConnectPreOrders", params, sback, eback);
    }
    //查询缓存
    this.queryCache = function(params,sback,eback) {
        commonService.callByGet("sys/cacheCtrl/qryCache", params, sback, eback);
    };
    //清除缓存
    this.cleanCache = function (params,sback,eback) {
        commonService.call("sys/cacheCtrl/cleanup", params, sback, eback);
    };
    //删除某个缓存
    this.removeCache = function(params,sback,eback) {
        commonService.callByGet("sys/cacheCtrl/removeCache", params, sback, eback);
    };
}]);
