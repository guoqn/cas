/**
 * Created by qn_guo on 2016/1/8.
 */
/**
 * 工单池流程
 * add by guoqn
 */
// module
var interactionMainApp = angular.module("interactionFlowApp");
// controller
interactionMainApp.controller("assignOrgMainCtrl", ["$scope", "casOrderService", "commonService", "$compile", function ($scope, casOrderService, commonService, $compile) {
    $scope.interactionAssignOrgInfo = {};

    //团队表格初始化
    $("#intetactionAssignOrgTable").bootstrapTable({
        onResetView: function () {
            $compile($('#intetactionAssignOrgTable'))($scope);
        },
        // 条件
        queryParams: function (params) {
            //查询条件
            var selfParams = {
                orgName: $scope.orgName,
                executeOrgName: $scope.executeOrgName,
                interactionFlowId: $scope.interactionFlowId
            }
            return $.extend({}, params, selfParams);
        },
        // 服务请求
        ajax: function (render) {
            try {
                if (!render.data) {
                    ffc.util.loadTableData(render);
                } else {
                    // 服务请求
                    casOrderService.qryInterActionAssignOrgData(render.data, function (result) {
                        if (!result.result){
                            if (!ffc.util.isEmpty(result.msgTitle)) {
                                MESSAGE_DIALOG.error(result.msgTitle +"");
                            }
                            ffc.util.loadTableData(render);
                            return false;
                        }
                        ffc.util.setPageResult($scope, 'interActionFlowAssignOrgErrorAlert', render, result);
                    });
                }
            } catch (e) {
                ffc.util.loadTableData(render);
            }
        }
    });
    //查询按钮
    $scope.queryAssignOrg = function () {
        $("#intetactionAssignOrgTable").bootstrapTable("selectPage", 1);
    };
    $scope.triggerInterActionAssignOrg = function (interactionFlowId) {
        if (undefined == interactionFlowId) return;
        $('#intetactionAssignOrgTable').bootstrapTable('showLoading');
        casOrderService.qryInterActionAssignOrgData({
            interactionFlowId: $scope.interactionFlowId
        }, function (result) {
            $('#intetactionAssignOrgTable').bootstrapTable('hideLoading');
            if (!result.result || undefined == result.pageInfo || undefined == result.pageInfo.list) {
                return false;
            }
            $("#intetactionAssignOrgTable").bootstrapTable("load", {
                rows: result.pageInfo.list,
                total: result.pageInfo.total
            });
        }, function (msg) {
            MESSAGE_DIALOG.error(msg);
        });
    }
    //新增
    $scope.addInteractionAssignOrg = function () {
        if (undefined == $scope.interactionFlowId) {
            MESSAGE_DIALOG.alert("请选中对应流程再执行团队相关操作");
            return;
        }
        $scope.assignOrgModifyName="新增转派团队页面";
        $scope.interactionAssignOrgInfo = {};
        $("#interaction_assign_org_modify").modal("show");
    }
    //修改
    $scope.modifyInteractionAssignOrg = function (rowIndex, elm) {
        var allTable = $('#intetactionAssignOrgTable')
            .bootstrapTable("getData");
        elm.stopPropagation();
        $scope.assignOrgModifyName="转派团队编辑页面";
        var selectRow = allTable[rowIndex];
        $scope.interactionAssignOrgInfo = selectRow;
        var regionId = null;
        var regionName = "";
        if(!ffc.util.isEmpty(selectRow.cfourRegionId)){
            regionId = selectRow.cfourRegionId;
            regionName = ffc.util.isEmpty(selectRow.cfourRegionName) ? "" : selectRow.cfourRegionName;
        }else if(!ffc.util.isEmpty(selectRow.commonRegionId)){
            regionId = selectRow.commonRegionId;
            regionName = ffc.util.isEmpty(selectRow.commonRegionName) ? "" : selectRow.commonRegionName;
        }
        $scope.$parent.regionList = [{
            regionId: regionId,
            regionName: regionName
        }];
        $scope.$parent.orgList = [{
            orgId: ffc.util.isEmpty(selectRow.orgId) ? null : selectRow.orgId,
            orgName: ffc.util.isEmpty(selectRow.orgName) ? "" : selectRow.orgName
        }];
        $scope.$parent.executeOrgList = [{
            orgId: ffc.util.isEmpty(selectRow.executeOrgId) ? null : selectRow.executeOrgId,
            orgName: ffc.util.isEmpty(selectRow.executeOrgName) ? "" : selectRow.executeOrgName
        }];

        $("#interaction_assign_org_modify").modal("show");
    }
    //删除
    $scope.delInteractionAssignOrg = function (rowIndex, elm) {
        var allTable = $('#intetactionAssignOrgTable')
            .bootstrapTable("getData");
        var selectRow = allTable[rowIndex];
        $scope.interactionAssignOrgInfo = {};
        $scope.interactionAssignOrgInfo = selectRow;
        var deleteInfo = {
            interactionAssignOrgId: selectRow.interactionAssignOrgId
        };
        elm.stopPropagation();
        MESSAGE_DIALOG.confirm("确认删除？", function () {
            casOrderService.delInteractionAssgnOrg($scope.interactionAssignOrgInfo,
                function (result) {
                    if (result.result != undefined
                        && result.result == true) {
                        MESSAGE_DIALOG.alert("删除成功！");
                        $scope.triggerInterActionAssignOrg($scope.interactionFlowId);
                    } else {
                        MESSAGE_DIALOG.alert(result.msgTitle + ".删除失败！");
                    }
                }, function (msg) {
                    MESSAGE_DIALOG.alert("删除失败！" + msg);
                });
        });
    };
    //保存
    $scope.saveInteractionAssignOrg = function () {
        if (undefined == $scope.interactionFlowId) {
            MESSAGE_DIALOG.alert("请选中对应流程再执行相关操作");
            return;
        }
        $scope.interactionAssignOrgInfo.executeOrgId = ffc.util.isEmpty($scope.executeOrgList) ? null : $scope.executeOrgList[0].orgId;
        if (null == $scope.interactionAssignOrgInfo.executeOrgId) {
            MESSAGE_DIALOG.warning("'二次受理团队'是必选的");
            return;
        }
        $scope.interactionAssignOrgInfo.orgId = ffc.util.isEmpty($scope.orgList) ? null : $scope.orgList[0].orgId;
        //判断所选区域是C3还是C4
        if(!ffc.util.isEmpty($scope.regionList)){
            var commonRegion = $scope.regionList[0];
            if(commonRegion.regionType == '1300'){
                $scope.interactionAssignOrgInfo.commonRegionId = ffc.util.isEmpty($scope.regionList) ? null : $scope.regionList[0].regionId;
                $scope.interactionAssignOrgInfo.cfourRegionId = null;
            }else if(commonRegion.regionType == '1499'){
                $scope.interactionAssignOrgInfo.cfourRegionId = ffc.util.isEmpty($scope.regionList) ? null : $scope.regionList[0].regionId;
                $scope.interactionAssignOrgInfo.commonRegionId = null;
            }
        }else {
            $scope.interactionAssignOrgInfo.cfourRegionId = null;
            $scope.interactionAssignOrgInfo.commonRegionId = null;
        }
        if (null == $scope.interactionAssignOrgInfo.orgId  && null == $scope.interactionAssignOrgInfo.commonRegionId && null == $scope.interactionAssignOrgInfo.cfourRegionId) {
            MESSAGE_DIALOG.warning("团队、区域必须选一个.");
            return;
        }
        MESSAGE_DIALOG.loading();
        $scope.interactionAssignOrgInfo.interactionFlowId = $scope.interactionFlowId;
        casOrderService.saveInteractionAssignOrg($scope.interactionAssignOrgInfo, function (result) {
            if (result.result != undefined && result.result == true) {
                MESSAGE_DIALOG.alert("保存成功！");
                $('#interaction_assign_org_modify').modal('hide');
                $scope.triggerInterActionAssignOrg($scope.interactionFlowId);
            } else {
                MESSAGE_DIALOG.alert(result.msgTitle + ",保存失败！");
            }
        }, function (msg) {
            MESSAGE_DIALOG.alert("保存失败！" + msg);
        });
    }

}]);

//格式化列
var operationOrgFormatter = function (value, row, index) {
    var modifyBtn = '<a ng-click="modifyInteractionAssignOrg(' + index + ',$event)">编辑</a>';
    var delBtn = '<a ng-click="delInteractionAssignOrg(' + index + ',$event)">删除</a>';
    return modifyBtn + " | " + delBtn;
}
//选中颜色
$(function () {
    $('#intetactionAssignOrgTable tbody').delegate('tr', 'click', function () {
        $(this).addClass("tr-onClick").siblings("tr").removeClass("tr-onClick");
    });
});
