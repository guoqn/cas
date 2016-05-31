/**
 *
 */
var orgCompCtrlApp = angular.module("orgCompCtrlApp", ["commonApp", "compServiceApp","ngJsTree"]);

orgCompCtrlApp.controller('orgCompCtrl', [
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
        $("#orgTable").bootstrapTable({
            // 加载成功后重新编译，试点formatter后的dom元素支持angularjs
            onResetView: function () {
                $compile($('#orgTable'))($scope);
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
                    if ($scope.$parent.orgList
                        && $scope.$parent.orgList[0]
                        && $scope.$parent.orgList[0].orgId) {
                        orgId = $scope.$parent.orgList[0].orgId;
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
                try {
                    if (!render.data) {
                        ffc.util.loadTableData(render);
                    } else {
                        compService.qryAssignOrg(
                            render.data,
                            function (result) {
                                if (!result.result) {
                                    if (!ffc.util.isEmpty(result.msgTitle)) {
                                        MESSAGE_DIALOG.warning(result.msgTitle + "");
                                    }
                                    ffc.util.loadTableData(render);
                                    return false;
                                }
                                ffc.util.setPageResult($scope, 'orgQueryErrorAlert', render, result);
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
        $scope.queryOrg = function () {
            $scope.fromQryBtn ="1";
            $('#orgTable').bootstrapTable("selectPage", 1);
        };
        //清空
        $scope.resetOrg = function () {
            $scope.$parent.orgList = null;
            $('#org-query').modal('hide');
        }
        // 确认
        $scope.confirmOrg = function () {
            // 收集表格中选中的数据，放到$scope.mktTeamList中
            var allSelectTeam = $('#orgTable').bootstrapTable(
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
                var orgList = {};
                orgList['orgId'] = allSelectTeam[i].orgId;
                orgList['orgName'] = allSelectTeam[i].orgName;
                dataList.push(orgList);
            }
            $scope.$parent.orgList = dataList;
            $('#org-query').modal('hide');
        };
        $scope.clickTreeNodeOrgId = "";//保存点击树的orgId
        // 单击树
        $scope.treeClick = function (event, data) {
            var id = data.node.id;
            $scope.clickTreeNodeOrgId = id;
            $('#orgTable').bootstrapTable("selectPage", 1);
            //$scope.clickTreeNodeOrgId = "";
        };
        // 模态框全部展示之后处理
        $('#org-query').on('shown.bs.modal', function () {

        })

    }]);