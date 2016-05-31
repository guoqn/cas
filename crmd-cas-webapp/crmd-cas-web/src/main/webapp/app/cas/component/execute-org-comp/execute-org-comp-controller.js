/**
 *
 */
var executeOrgCompCtrlApp = angular.module("executeOrgCompCtrlApp", ["commonApp", "compServiceApp","ngJsTree"]);

executeOrgCompCtrlApp.controller('executeOrgCompCtrl', [
    '$scope',
    'commonService',
    'compService',
    '$compile',
    function ($scope, commonService, compService, $compile) {
        $scope.qryOrgName = "";
        $scope.selectedRow = "";// 选中行的数据
        $scope.orgTreeConf = {
            treeData: null,
            treeConfig: {
                version: 1
            },
            instance: null,
            params: function (node) {
                return node;
            },
            service: function (params, sfn, efn) {
                var clickTreeNodeOrgId = params.id;
                var orgId = clickTreeNodeOrgId; //ffc.context.loginInfo.orgId;//后面默认当前登录团队ID
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
            listSelected: []
        };
        // 初始化表格
        $("#executeOrgTable").bootstrapTable({
            // 加载成功后重新编译，试点formatter后的dom元素支持angularjs
            onResetView: function () {
                $compile($('#executeOrgTable'))($scope);
            },
            onLoadError: function () {
            },
            onClickRow: function (row, $element) {
                $scope.selectedRow = row;
            },
            // 条件
            queryParams: function (params) {
                if ($scope.clickTreeNodeOrgId
                    && $scope.clickTreeNodeOrgId != null) {
                    var selfParams = {
                        parentOrgId: $scope.clickTreeNodeOrgId,
                        orgName: $scope.qryOrgName,
                        fromQryBtn :"1"
                    }
                } else {
                    var orgId = ffc.context.loginInfo.orgId;
                    if ($scope.$parent.executeOrgList
                        && $scope.$parent.executeOrgList[0]
                        && $scope.$parent.executeOrgList[0].orgId) {
                        orgId = $scope.$parent.executeOrgList[0].orgId;
                    }
                    // 查询条件
                    var selfParams = {
                        orgName: $scope.qryOrgName,
                        fromQryBtn :$scope.fromQryBtn
                        // pageNumber : 1,
                        // pageSize : 5
                    }
                }
                return $.extend({}, params, selfParams);
            },
            ajax: function (render) {
                if (render.data) {
                    // $('#mktTeamTable').bootstrapTable('removeAll');
                    compService.qryAssignOrg(render.data,
                        function (result) {
                            ffc.util.setPageResult($scope,
                                'orderQueryErrorAlert',
                                render, result);
                        }, function () {
                        });
                }
            }
        });

        // 初始化
        commonService.initFrom(ffc.util.getPageMetas($scope),
            function () {

            });

        // 调用服务查询可用仓库
        $scope.queryExecuteOrg = function () {
            $scope.fromQryBtn ="1";
            $('#executeOrgTable').bootstrapTable("selectPage", 1);
        };
        //清空
        $scope.resetExecuteOrg = function () {
            $scope.$parent.executeOrgList = null;
            $('#execute-org-query').modal('hide');
        }

        // 确认
        $scope.confirmOrg = function () {
            // 收集表格中选中的数据，放到$scope.mktTeamList中
            var allSelectTeam = $('#executeOrgTable').bootstrapTable(
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
                var executeOrgList = {};
                executeOrgList['orgId'] = allSelectTeam[i].orgId;
                executeOrgList['orgName'] = allSelectTeam[i].orgName;
                dataList.push(executeOrgList);
            }
            $scope.$parent.executeOrgList = dataList;
            $('#execute-org-query').modal('hide');
        };
        $scope.clickTreeNodeOrgId = "";//保存点击树的orgId
        // 单击树
        $scope.treeClick = function (event, data) {
            var id = data.node.id;
            $scope.clickTreeNodeOrgId = id;
            $('#executeOrgTable').bootstrapTable("selectPage", 1);
            //$scope.clickTreeNodeOrgId = "";
        };
        // 模态框全部展示之后处理
        $('#execute-org-query').on('shown.bs.modal', function () {

        })

    }]);