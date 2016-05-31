/**
 * Created by qn_guo on 2016/3/21.
 */
var preSaleOrderSRelApp = angular.module("preSaleOrderSRelApp", ["casOrderServiceApp", "bsTable"]);
preSaleOrderSRelApp.controller("preSaleOrderSRelCtrl", ["$scope", "casOrderService", "commonService", "$compile",
    function ($scope, casOrderService, commonService, $compile) {

        $scope.qrySrelInfo = {}
        $scope.todos = [
            {
                id: 1,
                custOrderNum: $scope.custOrderNum,
                preOrderNumber: $scope.preOrderNumber,
                newPreSaleOrderNum: $scope.newPreSaleOrderNum
            }
        ];

        preSaleOrderSRelApp.directive('ngBlur', function () {
            return function (scope, elem, attrs) {
                elem.bind('blur', function () {
                    scope.$apply(attrs.ngBlur);
                });
            };
        });

        preSaleOrderSRelApp.directive('ngFocus', function ($timeout) {
            return function (scope, elem, attrs) {
                scope.$watch(attrs.ngFocus, function (newval) {
                    if (newval) {
                        $timeout(function () {
                            elem[0].focus();
                        }, 0, false);
                    }
                });
            };
        });
        //新增行
        $scope.onAddNewRow = function () {
            $scope.todos.push({
                id: $scope.todos.length + 1,
                custOrderNum: $scope.custOrderNum,
                preOrderNumber: $scope.preOrderNumber,
                newPreOrderNumber: $scope.newPreOrderNumber
            });
        }
        //关联
        $scope.connectNewPreOrderForRow = function (todo) {
            if (ffc.util.isEmpty(todo.newPreOrderNumber)) {
                MESSAGE_DIALOG.warning("P单号为空!")
                return false;
            }
            if (ffc.util.isEmpty(todo.custOrderNum)) {
                MESSAGE_DIALOG.warning("FJ单号为空!")
                return false;
            }

            if ("1" == $scope.qrySrelInfo.seq) {
                MESSAGE_DIALOG.warning("FJ单是第一张单不能关联其他P单!")
                return false;
            }
            if (todo.newPreOrderNumber == $scope.qrySrelInfo.preOrderNumber) {
                MESSAGE_DIALOG.warning("P单已关联!")
                return false;
            }
            $scope.qrySrelInfo.newPreOrderNumber = todo.newPreOrderNumber;
            if ("无"== todo.preOrderNumber){
                todo.preOrderNumber = null;
            }
            $scope.qrySrelInfo.preOrderNumber = todo.preOrderNumber;
            $scope.qrySrelInfo.custOrderNum = todo.custOrderNum;
            todo = $scope.qrySrelInfo;
            MESSAGE_DIALOG.loading();
            casOrderService.connectNewPreOrder(todo, function (result) {
                if (result.result) {
                    todo.preOrderNumber = todo.newPreOrderNumber
                    MESSAGE_DIALOG.alert("关联成功");
                } else {
                    MESSAGE_DIALOG.warning("" + result.msgTitle)
                }
            }, function (msg) {
                MESSAGE_DIALOG.error("" + msg)
            })
        }
        //删除行
        $scope.delRow = function (todo) {
            $scope.todos.splice($scope.todos.indexOf(todo), 1);
        }
        //监听光标移出触发查询
        $scope.qryPreSaleOrderRel = function (todo) {
            $scope.qrySrelInfo = {}
            if (ffc.util.isEmpty(todo.custOrderNum)) {
                return false;
            }
            casOrderService.qryPreSaleOrderSrel(todo, function (result) {
                if (result.result) {
                    $scope.qrySrelInfo = result.object;
                    todo.preOrderNumber
                        = ffc.util.isEmpty(result.object.preOrderNumber) ?
                        "无" : result.object.preOrderNumber;
                } else {
                    todo.preOrderNumber = "无";
                    MESSAGE_DIALOG.warning("" + result.msgTitle);
                }
            }, function (msg) {
                MESSAGE_DIALOG.error("" + msg);
            });
        }
    }]);


/*            var newRow = '<tr id="option' + rowCount + '">' +
 '<td><input type="text" class="form-control" onchange="qryPreSaleOrderRel(this.value,rowCount)"></td>' +
 '<td><input type="text" ng-model="" class="form-control" disabled></td>' +
 '<td><input type="text" class="form-control"></td>' +
 '<td><button type="button" class="btn btn-default" ' +
 'onclick="connectNewPreOrderForRow()">关联</button>' +
 ' | <button href="#" class="btn btn-default" onclick=delRow(' + rowCount + ')>删除</button></td>' +
 '</tr>';
 $('#pre_sale_order_rel_table tbody').append(newRow);*/
/*
 //监听输入框编号，查找关联的P订单
 var qryPreSaleOrderRel = function (value, rowCount) {
 $.ajax({
 url: ffc.context.contextPath + "/order/maintanace/qryPreSaleOrderSrel",
 async: false,
 data: {
 oldPreOrderNum: value
 },
 success: function (data) {
 retVo = data;
 //MESSAGE_DIALOG.alert("" + retVo.result);
 $('#option' + rowCount).val("无");
 }
 });
 }*/
