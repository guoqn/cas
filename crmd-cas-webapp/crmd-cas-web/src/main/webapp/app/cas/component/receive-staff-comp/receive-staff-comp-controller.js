/**
 *
 */
var receiveStaffCompCtrlApp = angular.module("receiveStaffCompCtrlApp", ["commonApp", "compServiceApp"]);

receiveStaffCompCtrlApp.controller('receiveStaffCompCtrl',
    ['$scope',
        'commonService',
        'compService',
        '$compile',
        function ($scope, commonService, compService, $compile) {
            $scope.selectedRow = "";//选中行的数据
            // 团队树设置
            /*$scope.orgTreeConf = {
             treeData: null,
             treeConfig: {
             version: 1,
             },
             instance: null,
             params: function (node) {
             return node;
             },
             service: function (params, sfn, efn) {
             var clickTreeNodeOrgId = params.id;
             var orgId = clickTreeNodeOrgId;//后面默认当前登录团队ID
             if ($scope.$parent.receiveStaffList
             && $scope.$parent.receiveStaffList[0]
             && $scope.$parent.receiveStaffList[0].orgId) {
             orgId = $scope.$parent.receiveStaffList[0].orgId;
             }
             compService.qryOrgTree(
             {id: orgId},
             function (result) {
             if (!ffc.util.isEmpty(result)
             && !ffc.util.isEmpty(result.dataList)) {
             sfn(result.dataList);
             }
             },
             function (err) {
             });
             },
             status: '',
             listSelected: [],
             };*/

            // 初始化表格
            $("#receiveStaffTable").bootstrapTable({
                // 加载成功后重新编译，试点formatter后的dom元素支持angularjs
                onResetView: function () {
                    $compile($('#receiveStaffTable'))($scope);
                },
                onLoadError: function () {
                },
                onClickRow: function (row, $element) {
                    $scope.selectedRow = row;
                },
                // 条件
                queryParams: function (params) {
                    // 查询条件
                    if ($scope.clickTreeNodeOrgId
                        && $scope.clickTreeNodeOrgId != null) {
                        var selfParams = {
                            //orgId: $scope.clickTreeNodeOrgId,
                            staffName: $scope.qryStaffName,
                            staffCode: $scope.qryStaffCode
                        }
                    } else {
                        /*                        var orgId = 0;//后面默认当前登录团队ID
                         if ($scope.$parent.receiveStaffList
                         && $scope.$parent.receiveStaffList[0]
                         && $scope.$parent.receiveStaffList[0].orgId) {
                         orgId = $scope.$parent.receiveStaffList[0].orgId;
                         }*/
                        var selfParams = {
                            staffName: $scope.qryStaffName,
                            //orgId: orgId,
                            fromQryBtn :$scope.fromQryBtn,
                            staffCode: $scope.qryStaffCode
                        }
                    }
                    return $.extend({}, params, selfParams);
                },
                ajax: function (render) {
                    try {
                        if (!render.data) {
                            ffc.util.loadTableData(render);
                        } else {
                            compService.qryReceiveStaffInfo(
                                render.data,
                                function (result) {
                                    if (!result.result) {
                                        if (!ffc.util.isEmpty(result.msgTitle)) {
                                            MESSAGE_DIALOG.warning(result.msgTitle + "");
                                        }
                                        ffc.util.loadTableData(render);
                                        return false;
                                    }
                                    ffc.util.setPageResult($scope, 'receiveStaffQueryErrorAlert', render, result);
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
            commonService.initFrom(ffc.util
                .getPageMetas($scope), function () {

            });

            // 查询
            $scope.queryReceiveStaff = function () {
                $scope.fromQryBtn = "1";
                $('#receiveStaffTable').bootstrapTable("selectPage", 1);
            };
            //清空
            $scope.resetReceiveStaff = function () {
                $scope.$parent.receiveStaffList = null;
                $('#receive-staff-query').modal('hide');
            }
            // 确认
            $scope.confirmReceiveStaff = function () {
                var allSelectStaff = $('#receiveStaffTable')
                    .bootstrapTable('getAllSelections');
                var dataList = [];//返回的数据
                if (allSelectStaff == undefined
                    || allSelectStaff.length == 0) {
                    if ($scope.selectedRow == '') {
                        MESSAGE_DIALOG.warning("请选择一个员工！");
                        return false;
                    }
                    allSelectStaff[0] = $scope.selectedRow;
                }
                for (var i = 0; i < allSelectStaff.length; i++) {
                    var receiveStaffList = {};
                    receiveStaffList['staffId'] = allSelectStaff[i].staffId;
                    receiveStaffList['staffCode'] = allSelectStaff[i].staffCode;
                    receiveStaffList['staffName'] = allSelectStaff[i].staffName;
                    dataList.push(receiveStaffList);
                }
                $scope.$parent.receiveStaffList = dataList;
                $('#receive-staff-query').modal('hide');
            };

            // 模态框全部展示之后处理
            $('#receive-staff-query').on('shown.bs.modal',
                function () {
                });

            $scope.clickTreeNodeOrgId = "";//保存点击树的orgId
            // 单击树
            $scope.treeClick = function (event, data) {
                var id = data.node.id;
                $scope.clickTreeNodeOrgId = id;
                $('#receiveStaffTable').bootstrapTable("selectPage", 1);
                //$scope.clickTreeNodeOrgId = "";
            };
            //监听团队变化
            $scope.$watch("receiveStaffList[0].staffId", function (newValue, oldValue) {
                /*                if (newValue != undefined) {
                 $scope.orgTreeConf.status = "reload";
                 }*/
            });
        }]);