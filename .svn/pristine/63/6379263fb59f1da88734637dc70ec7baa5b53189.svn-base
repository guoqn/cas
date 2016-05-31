var preSaleOrderApp = angular.module("preSaleOrderApp");
preSaleOrderApp.controller("preSaleOrderProcCtrl", ["$scope", "casOrderService", "commonService", "$compile",
    function ($scope, casOrderService, commonService, $compile) {
        $scope.triggerPreSaleOrderProc = function (preOrderId, preOrderNumber) {
            if (undefined == preOrderId || "" == preOrderId) return;
            $('#preSaleOrderProcTable').bootstrapTable('showLoading');
            casOrderService.qryPreSaleOrderProc({
                preOrderId: preOrderId,
                preSaleOrderNum: preOrderNumber
            }, function (result) {
                $('#preSaleOrderProcTable').bootstrapTable('hideLoading');
                if (!result.result || undefined == result.pageInfo || undefined == result.pageInfo.list) {
                    return false;
                }
                $("#preSaleOrderProcTable").bootstrapTable("load", {
                    rows: result.pageInfo.list,
                    total: result.pageInfo.total
                });
            }, function (msg) {
                MESSAGE_DIALOG.error(msg);
            });
        }

    }]);