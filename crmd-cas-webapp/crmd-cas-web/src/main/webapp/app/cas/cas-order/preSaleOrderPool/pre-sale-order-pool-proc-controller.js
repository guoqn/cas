/**
 * 工单池处理过程
 * add by guoqn
 */
var preSaleOrderPoolApp = angular.module("preSaleOrderPoolApp");
preSaleOrderPoolApp.controller("preSaleOrderPoolProcCtrl", ["$scope", "casOrderService", "commonService", "$compile",
    function ($scope, casOrderService, commonService, $compile) {
        $scope.triggerPreSaleOrderPoolProc = function (preOrderId, preOrderNumber) {
            if (undefined == preOrderId || "" == preOrderId) return;
            $('#preSaleOrderPoolProcTable').bootstrapTable('showLoading');
            casOrderService.qryPreSaleOrderProc({
                preOrderId: preOrderId,
                preSaleOrderNum: preOrderNumber
            }, function (result) {
                $('#preSaleOrderPoolProcTable').bootstrapTable('hideLoading');
                if (!result.result || undefined == result.pageInfo || undefined == result.pageInfo.list) {
                    return false;
                }
                $("#preSaleOrderPoolProcTable").bootstrapTable("load", {
                    rows: result.pageInfo.list,
                    total: result.pageInfo.total
                });
            }, function () {

            });
        }

    }]);