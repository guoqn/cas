/**
 * Created by qn_guo on 2016/2/18.
 */
var preSaleOrderRecApp = angular.module("preSaleOrderRecApp");
preSaleOrderRecApp.controller("preSalerOrderRecProcCtrl", ["$scope", "casOrderService", "commonService", "$compile",
    function ($scope, casOrderService, commonService, $compile) {
        $scope.triggerPreSaleOrderRecProc = function (preOrderId, preOrderNbr) {
            if (undefined == preOrderId || "" == preOrderId) return;
            $('#preSaleOrderRecProcTable').bootstrapTable('showLoading');
            casOrderService.qryPreSaleOrderProc({
                preOrderId: preOrderId,
                preSaleOrderNum: preOrderNbr
            }, function (result) {
                $('#preSaleOrderRecProcTable').bootstrapTable('hideLoading');
                if (!result.result || undefined == result.pageInfo || undefined == result.pageInfo.list) {
                    //MESSAGE_DIALOG.warning("" + result.msgTitle);
                    return false;
                }
                $("#preSaleOrderRecProcTable").bootstrapTable("load", {
                    rows: result.pageInfo.list,
                    total: result.pageInfo.total
                });
            }, function () {

            });
        }

    }]);