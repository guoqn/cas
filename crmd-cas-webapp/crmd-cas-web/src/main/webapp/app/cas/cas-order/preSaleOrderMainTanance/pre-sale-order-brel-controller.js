/**
 * Created by qn_guo on 2016/3/21.
 */
var preSaleOrderBRelApp = angular.module("preSaleOrderBRelApp", ["casOrderServiceApp", "bsTable", "ngFileUpload"]);
preSaleOrderBRelApp.controller("preSaleOrderBRelCtrl", ["$scope", "casOrderService", "commonService", "$compile", "Upload",
    function ($scope, casOrderService, commonService, $compile, Upload) {

        $scope.qryBrelInfo = {}
        $scope.mainTananceInfo = {}
        // 上传文件
        $scope.upload = function () {

            if ($scope.uploadFile) {
                if ($scope.uploadFile.name) { //校验是否是xls/xlsx
                    var filename = $scope.uploadFile.name;
                    var fileext = (/[.]/.exec(filename)) ? /[^.]+$/.exec(filename.toLowerCase()) : '';
                    if (!(fileext == 'xlsx' || fileext == 'xls')) {
                        MESSAGE_DIALOG.alert("文件格式必须是*.xls或*.xlsx");
                        return false;
                    }
                }
                $scope.doUpload($scope.uploadFile);
            }
        }
        // 执行上传
        $scope.doUpload = function (file) {
            MESSAGE_DIALOG.loading();
            Upload.upload(
                {
                    url: ffc.context.contextPath + '/order/maintanace/batchQryPreOrders',
                    data: {
                        uploadFile: file
                    }
                }).then(
                function (resp) {
                    if (!ffc.util.isEmpty(resp) && !ffc.util.isEmpty(resp.data) && resp.data.result
                        && !ffc.util.isEmpty(resp.data.object)
                        && !ffc.util.isEmpty(resp.data.object.preSaleOrderMaintanceDetailDTOList)) {
                        $('#pre_sale_order_brel_table').bootstrapTable('load',
                            resp.data.object.preSaleOrderMaintanceDetailDTOList);
                        $scope.qryBrelInfo.totalCount = resp.data.object.totalCount; //总数
                        $scope.qryBrelInfo.canConnectCount = resp.data.object.canConnectCount; //可关联
                        $scope.qryBrelInfo.canntConnectCount = resp.data.object.canntConnectCount; //不可关联
                        $("#buttonUpload").attr("disabled", false);
                        MESSAGE_DIALOG.close();
                    } else {
                        MESSAGE_DIALOG.warning("批量导入失败!" + resp.data.msgTitle);
                        return false;
                    }
                }, function (resp) {
                    MESSAGE_DIALOG.error("批量导入失败，请核查！");
                }, function (evt) {

                });
        };

        //清空所有
        $scope.resetBtn = function () {
            $('#pre_sale_order_brel_table').bootstrapTable('removeAll');
            $scope.qryBrelInfo = {}
            $("#buttonUpload").attr("disabled", false);
        };
        // 导出模板
        $scope.downTemplate = function () {
            $.fileDownload(ffc.context.contextPath + '/order/maintanace/exportTemplate',
                {
                    httpMethod: "POST",
                }).done(function () {

            }).fail(function (res) {
                MESSAGE_DIALOG.error("导出模板传失败，请核查！");
            });
        };
        //确认关联
        $scope.uploadSubmit = function () {
            MESSAGE_DIALOG.loading();
            if (undefined == $scope.qryBrelInfo.canConnectCount
                || $scope.qryBrelInfo.canConnectCount.length == 0) {
                MESSAGE_DIALOG.alert("可关联数为0");
                return false;
            }
            var data = $('#pre_sale_order_brel_table').bootstrapTable('getData');
            if (ffc.util.isEmpty(data) || data.length == 0) {
                MESSAGE_DIALOG.alert("请导入需要关联的数据.");
                return false;
            }
            $scope.mainTananceInfo.preSaleOrderMaintanceDetailDTOList = data;
            casOrderService.batchConnectPreOrder($scope.mainTananceInfo, function (result) {
                if (result.result) {
                    $('#pre_sale_order_brel_table').bootstrapTable('load', []);
                    $scope.qryBrelInfo = {};
                    MESSAGE_DIALOG.alert("关联成功");
                } else {
                    MESSAGE_DIALOG.warning("关联失败" + result.msgTitle);
                }
            }, function (msg) {
                MESSAGE_DIALOG._error("关联异常" + msg);
            })
        }
    }
]);

//dataformatter是否可以关联
var isCanRelate = function (value, row, index) {
    var result = '<span>否</span>';
    if (true == row.canRelate) {
        result = '<span>是</span>';
    }
    return result;
}