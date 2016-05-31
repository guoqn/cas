/**
 *
 */
var statusCompCtrlApp = angular.module("statusCompCtrlApp", ["commonApp", "compServiceApp"]);

statusCompCtrlApp.controller('statusCompCtrl', [
    '$scope',
    'commonService',
    'compService',
    '$compile',
    function ($scope, commonService, compService, $compile) {
        $scope.dataList = [];
        $scope.selectedRow = "";
        // 初始化表格
        $("#statusTable").bootstrapTable(
            {
                // 加载成功后重新编译，试点formatter后的dom元素支持angularjs
                onResetView: function () {
                    $compile($('#statusTable'))($scope);
                },
                onLoadError: function () {
                },
                onClickRow: function (row, $element) {
                    $scope.selectedRow = row;
                },
                // 条件
                queryParams: function (params) {
                    // 查询条件
                    var selfParams = {
                        classCode: 'PreSaleOrder'
                    }
                    return $.extend({}, params, selfParams);
                },
                ajax: function (render) {
                    if (render.data) {
                        compService.qryStatus(render.data,
                            function (result) {
                                if (undefined != result.dataList) {
                                    $scope.dataList = result.dataList;
                                }
                                $('#statusTable').bootstrapTable("hideLoading");
                                $('#statusTable').bootstrapTable('load', result.dataList);
                            }, function () {
                            });
                    }
                }
            });
        //清空状态
        $scope.resetStatus = function () {
            $scope.$parent.statusList = null;
            $scope.$parent.statusData = "";
            $('#status-query').modal('hide');
        }
        // 确认
        $scope.confirmStatus = function () {
            var allSelectTeam = $('#statusTable').bootstrapTable(
                'getAllSelections');
            var dataList = [];// 返回的数据
            if (allSelectTeam == undefined || allSelectTeam.length == 0) {
                if ($scope.selectedRow == '') {
                    MESSAGE_DIALOG.warning("请选择一个订单状态！");
                    return false;
                }
                allSelectTeam[0] = $scope.selectedRow;
            }
            for (var i = 0; i < allSelectTeam.length; i++) {
                var statusList = {};
                statusList['status'] = allSelectTeam[i].attrValue;
                statusList['statusName'] = allSelectTeam[i].attrValueName;
                dataList.push(statusList);
            }
            $scope.$parent.statusList = dataList;
            var statusData = "";
            //具体取值
            $.each(dataList, function (i, n) {
                statusData += n.status + ",";
            });
            //针对前端穿的参数尽量用 字符串的形式  add by guoqn
            $scope.$parent.statusData = statusData;
            $('#status-query').modal('hide');
        };

    }]);