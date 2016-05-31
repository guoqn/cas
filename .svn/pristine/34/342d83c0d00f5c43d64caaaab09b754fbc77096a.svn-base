/**
 *
 */
var sceneTypeCompCtrlApp = angular.module("sceneTypeCompCtrlApp", ["commonApp", "compServiceApp"]);

sceneTypeCompCtrlApp.controller('sceneTypeCompCtrl', [
    '$scope',
    'commonService',
    'compService',
    '$compile',
    function ($scope, commonService, compService, $compile) {
        $scope.dataList = [];
        $scope.selectedRow = "";
        // 初始化表格
        $("#sceneTypeTable").bootstrapTable(
            {
                // 加载成功后重新编译，试点formatter后的dom元素支持angularjs
                onResetView: function () {
                    $compile($('#sceneTypeTable'))($scope);
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
                        classCode: 'PreSaleOrder',
                        attrSpecCode: 'sceneType',
                        sceneTypeName: $scope.qrySceneTypeName
                    }
                    return $.extend({}, params, selfParams);
                },
                ajax: function (render) {
                    if (render.data) {
                        compService.qrySceneType(render.data,
                            function (result) {
                                if (undefined != result.dataList) {
                                    $scope.dataList = result.dataList;
                                }
                                $('#sceneTypeTable').bootstrapTable("hideLoading");
                                $('#sceneTypeTable').bootstrapTable('load', result.dataList);
                            }, function () {
                            });
                    }
                }
            });

        // 初始化
        commonService.initFrom(ffc.util.getPageMetas($scope), function () {

        });

        // 调用服务查询可用仓库
        $scope.querySceneType = function () {
            var sceneTypeName = $scope.sceneTypeName;
            if (undefined != sceneTypeName && sceneTypeName != '') {
                var list = [];
                $.each($scope.dataList, function (index, value) {
                    if (value.sceneTypeName.indexOf(sceneTypeName) != -1) {
                        list.push(value);
                    }
                });

                $('#sceneTypeTable').bootstrapTable("hideLoading");
                $('#sceneTypeTable').bootstrapTable('load', list);
            } else {
                $('#sceneTypeTable').bootstrapTable("hideLoading");
                $('#sceneTypeTable').bootstrapTable('load', $scope.dataList);
            }
        };
        //清空业务类型
        $scope.resetSceneType = function () {
            $scope.$parent.sceneTypeList = null;
            $scope.$parent.sceneTypeData ="";
            $('#scene-type-query').modal('hide');
        }
        // 确认
        $scope.confirmSceneType = function () {
            var allSelectTeam = $('#sceneTypeTable').bootstrapTable(
                'getAllSelections');
            var dataList = [];// 返回的数据
            if (allSelectTeam == undefined || allSelectTeam.length == 0) {
                if ($scope.selectedRow == '') {
                    MESSAGE_DIALOG.warning("请选择一个业务类型！");
                    return false;
                }
                allSelectTeam[0] = $scope.selectedRow;
            }
            for (var i = 0; i < allSelectTeam.length; i++) {
                var sceneTypeList = {};
                sceneTypeList['sceneType'] = allSelectTeam[i].sceneType;
                sceneTypeList['sceneTypeName'] = allSelectTeam[i].sceneTypeName;
                dataList.push(sceneTypeList);
            }
            $scope.$parent.sceneTypeList = dataList;
            var sceneTypeData = "";
            //具体取值
            $.each(dataList, function (i, n) {
                sceneTypeData += n.sceneType + ",";
            });
            //针对前端穿的参数尽量用 字符串的形式  add by guoqn
            $scope.$parent.sceneTypeData = sceneTypeData;
            $('#scene-type-query').modal('hide');
        };

        // 模态框全部展示之后处理
        $('#scene-type-query').on('shown.bs.modal', function () {

        })

    }]);