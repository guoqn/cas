/**
 *
 */
var regionCompCtrlApp = angular.module("regionCompCtrlApp", ["commonApp", "compServiceApp"]);

regionCompCtrlApp.controller('regionCompCtrl', [
    '$scope',
    'commonService',
    'compService',
    '$compile',
    function ($scope, commonService, compService, $compile) {
        $scope.qryRegionName = "";
        $scope.selectedRow = "";// 选中行的数据
        // 初始化表格
        $("#regionTable").bootstrapTable({
            // 加载成功后重新编译，试点formatter后的dom元素支持angularjs
            onResetView: function () {
                $compile($('#regionTable'))($scope);
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
                    regionName: $scope.qryRegionName,
                    acrossOrgDTO: ffc.context.loginInfo.acrossOrgDTO,
                    fromQryBtn : $scope.fromQryBtn
                // pageNumber : 1,
                    // pageSize : 5
                }
                return $.extend({}, params, selfParams);
            },
            ajax: function (render) {
                try {
                    if (!render.data) {
                        ffc.util.loadTableData(render);
                    } else {
                        compService.qryCommonRegionByName(
                            render.data,
                            function (result) {
                                if (!result.result) {
                                    if (!ffc.util.isEmpty(result.msgTitle)) {
                                        MESSAGE_DIALOG.warning(result.msgTitle + "");
                                    }
                                    ffc.util.loadTableData(render);
                                    return false;
                                }
                                ffc.util.setPageResult($scope, 'regionQueryErrorAlert', render, result);
                            }, function (msg) {
                                MESSAGE_DIALOG.error("查询异常" + msg);
                            });
                    }
                } catch (e) {
                    ffc.util.loadTableData(render);
                }
            }
        });

        // 初始化
        commonService.initFrom(ffc.util.getPageMetas($scope),
            function () {

            });

        // 调用服务查询可用仓库
        $scope.queryRegion = function () {
            $scope.fromQryBtn = "1";
            $('#regionTable').bootstrapTable("selectPage", 1);
        };
        //清空区域
        $scope.resetRegion = function () {
            $scope.$parent.regionList = null;
            $('#region-query').modal('hide');
        }
        // 确认
        $scope.confirmRegion = function () {
            // 收集表格中选中的数据，放到$scope.mktTeamList中
            var allSelectTeam = $('#regionTable').bootstrapTable(
                'getAllSelections');
            var dataList = [];// 返回的数据
            if (allSelectTeam == undefined || allSelectTeam.length == 0) {
                if ($scope.selectedRow == '') {
                    MESSAGE_DIALOG.warning("请选择一个团队！");
                    return false;
                }
                allSelectTeam[0] = $scope.selectedRow;
            }
            for (var i = 0; i < allSelectTeam.length; i++) {
                var regionList = {};
                regionList['regionId'] = allSelectTeam[i].commonRegionId;
                regionList['regionName'] = allSelectTeam[i].regionName;
                regionList['regionType'] = allSelectTeam[i].regionType;
                dataList.push(regionList);
            }
            $scope.$parent.regionList = dataList;
            $('#region-query').modal('hide');
        };

        // 模态框全部展示之后处理
        $('#region-query').on('shown.bs.modal', function () {

        })

    }]);