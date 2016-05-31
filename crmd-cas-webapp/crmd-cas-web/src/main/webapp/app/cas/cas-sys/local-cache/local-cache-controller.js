/**
 * Created by FFCS-YULIYAO on 2016/5/5.
 */
var localCacheApp = angular.module("localCacheApp", ["casOrderServiceApp"]);

localCacheApp.controller("localCacheAppCtrl", ["$scope", "$compile", "casOrderService", '$timeout', function ($scope, $compile, casOrderService, $timeout) {
    $("#cacheTable").bootstrapTable({
        // 加载成功后重新编译，试点formatter后的dom元素支持angularjs
        onResetView: function () {
            $compile($('#cacheTable'))($scope);
        },
        // 服务请求
        ajax: function (render) {
            try {
                if (!render.data) {
                    ffc.util.loadTableData(render);
                } else {
                    // 服务请求
                    casOrderService.queryCache({name:ffc.util.isEmpty($scope.searchKey)==true?"":$scope.searchKey}, function (result) {
                        if (!result.result){
                            if (!ffc.util.isEmpty(result.msgTitle)) {
                                MESSAGE_DIALOG.error(result.msgTitle +"");
                            }
                            ffc.util.loadTableDataList(render);
                            return false;
                        }
                        ffc.util.setListResult($scope, 'cacheErrorAlert', render, result);
                    });
                }
            } catch (e) {
                ffc.util.loadTableData(render);
            }
        },
        // 点击行事件
        onClickRow: function (row, $element) {
            $timeout(function () {
                $scope.cacheValue = angular.toJson(row.value);
            },0)
        }
    });

    $scope.queryCache = function () {
        $("#cacheTable").bootstrapTable('refresh');
    };

    $scope.cleanup = function() {
        casOrderService.cleanCache({},function(result) {
            MESSAGE_DIALOG.alert("清除成功!");
            $scope.queryCache();
        },function(msg) {
            MESSAGE_DIALOG.error(msg);
        })
    };

    //删除
    $scope.remove = function (rowIndex, elm) {
        var allTable = $('#cacheTable')
            .bootstrapTable("getData");
        var selectRow = allTable[rowIndex];
        casOrderService.removeCache({"key": selectRow.key}, function (result) {
            if (result.result != undefined
                && result.result == true) {
                MESSAGE_DIALOG.alert("删除成功！");
                $scope.queryCache();
            } else {
                MESSAGE_DIALOG.warning(result.msgTitle + ".删除失败！");
            }
        });
    }

}]);


//格式化列
var operationFormatter = function (value, row, index) {
    var delBtn = '<a ng-click="remove(' + index + ',$event)">删除</a>';
    return delBtn;
}
