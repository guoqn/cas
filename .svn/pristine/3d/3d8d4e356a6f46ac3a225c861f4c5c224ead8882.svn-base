/**
 * Created by qn_guo on 2016/2/18.
 */
var preSaleOrderRecApp = angular.module("preSaleOrderRecApp");
preSaleOrderRecApp.controller("preSaleOrderDetailCtrl", ["$scope", "casOrderService", "commonService", "$compile", "$sce",
    function ($scope, casOrderService, commonService, $compile, $sce) {
        $scope.keepAcceptDiv = false;

        $("#preSaleOrderDetailTable").bootstrapTable({
            // 加载成功后重新编译，试点formatter后的dom元素支持angularjs
            onResetView: function () {
                $compile($('#preSaleOrderDetailTable'))($scope);
            }
        });
        $scope.triggerPreSaleOrderDetail = function (preOrderId, preOrderNbr, preStatusCd) {
            if (undefined == preOrderId || "" == preOrderId) return;
            $('#preSaleOrderDetailTable').bootstrapTable('showLoading');

            casOrderService.qryPreSaleOrderDetail({
                preOrderId: preOrderId,
                preOrderNbr: preOrderNbr,
                statusCd: preStatusCd
            }, function (result) {
                $('#preSaleOrderDetailTable').bootstrapTable('hideLoading');
                if (!result.result || undefined == result.dataList
                    || result.dataList.length == 0) {
                    //MESSAGE_DIALOG.warning("订单信息查询异常:" + result.msgTitle);
                    return false;
                }
                $("#preSaleOrderDetailTable").bootstrapTable("load", result.dataList);
            }, function (msg) {
                MESSAGE_DIALOG.error("" + msg)
            });
        }

        //集中受理页面跳转到CRM2页面
        var casToCrm2 = function (url) {
            var injector = angular.injector(["casOrderServiceApp", "ng"]);
            injector.invoke(['casOrderService', function (casOrderService) {
                var param = "pageCls@keepOrder&keyValue@" + url;
                casOrderService.invokeToOrder(param);
            }]);
        }
        //继续受理
        $scope.keepAccept = function (index, event) {
            $scope.inKeepAccept = {};
            var allTable = $('#preSaleOrderDetailTable')
                .bootstrapTable("getData");
            var selectRow = allTable[index];
            $scope.inKeepAccept = selectRow;
            MESSAGE_DIALOG.loading();
            casOrderService.keepAcceptData($scope.inKeepAccept, function (result) {
                if (result.result) {
                    MESSAGE_DIALOG.close();
                    var url = $sce.trustAsResourceUrl(result.object);
                    casToCrm2(url);
                } else {
                    MESSAGE_DIALOG.warning("获取地址失败" + result.msgTitle);
                }
            }, function (msg) {
                MESSAGE_DIALOG.error("" + msg);
            });
        }
        //详情
        $scope.orderDetail = function (custSoNumber, event) {
            // 动态依赖注入
            var injector = angular.injector(["casOrderServiceApp", "ng"]);
            injector.invoke(['casOrderService', function (casOrderService) {
                var param = "pageCls=dtOrder&keyFlag=0&keyType=bycustsonbr&keyValue=" + custSoNumber;
                casOrderService.invokeToOrder(param);
            }]);
        }
        //转变更单
        $scope.onConvertToModOrder = function (rowIndex, event) {
            $scope.orderInfo = {};
            var allTable = $('#preSaleOrderDetailTable')
                .bootstrapTable("getData");
            var selectRow = allTable[rowIndex];
            $scope.orderInfo = selectRow;
            MESSAGE_DIALOG.confirm("您确定要将此单转成变更单？", function () {
                MESSAGE_DIALOG.loading();
                casOrderService.onConvertToModOrderData($scope.orderInfo,
                    function (result) {
                        if (result.result != undefined
                            && result.result == true) {
                            MESSAGE_DIALOG.close();
                            $scope.triggerPreSaleOrderDetail($scope.preOrderId, $scope.preOrderNbr);
                            MESSAGE_DIALOG.confirm("转变更单成功！点击确定继续受理，点击取消返回", function () {
                                casOrderService.keepAcceptData($scope.orderInfo, function (result) {
                                    if (!result.result) {
                                        MESSAGE_DIALOG.warning("获取地址失败" + result.msgTitle);
                                    }
                                    var url = $sce.trustAsResourceUrl(result.object);
                                    casToCrm2(url);
                                }, function (msg) {
                                    MESSAGE_DIALOG.error("" + msg);
                                });
                            });
                        } else {
                            MESSAGE_DIALOG.alert(result.msgTitle + ".转变更单失败！");
                        }
                    }, function (msg) {
                        MESSAGE_DIALOG.error("受理失败！" + msg);
                    });
            });
        }
    }]);

/**
 * 格式化列
 * @param value
 * @param row
 * @param index
 */
var preOrderDetailForamatter = function (value, row, index) {
    var keepAccept = "";
    var onConvertToModOrderBtn = "";
    var detailOrder = '<a ng-click="orderDetail(\'' + row.custSoNumber + '\',$event)">详情</a>';
    if ("100098" == row.statusCd && "11000" == row.preStatusCd) {
        keepAccept = '<a ng-click="keepAccept(' + index + ',$event)">继续受理</a>'
    }
    if ("100098" == row.statusCd && "1" == row.isQuitOrder) {
        onConvertToModOrderBtn = '<a ng-click="onConvertToModOrder(' + index + ',$event)">转变更单</a>'
    }
    onConvertToModOrderBtn = ffc.util.isEmpty(onConvertToModOrderBtn) ? "" : onConvertToModOrderBtn + " | ";
    keepAccept = ffc.util.isEmpty(keepAccept) ? "" : keepAccept + " | ";
    return keepAccept + onConvertToModOrderBtn + detailOrder;
}