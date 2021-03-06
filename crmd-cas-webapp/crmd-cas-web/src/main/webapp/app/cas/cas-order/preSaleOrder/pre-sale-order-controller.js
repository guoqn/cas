/**
 * Created by qn_guo on 2016/1/16.
 */
var preSaleOrderApp = angular.module("preSaleOrderApp", ["casOrderServiceApp", 'ui.select', "bsTable", "ngSelect2", "orgCompApp", "staffCompApp", "sceneTypeCompApp", "dropTreeApp"])
preSaleOrderApp.controller("preSaleOrderCtrl", ["$scope", "casOrderService", "commonService", "$compile", "$sce", function ($scope, casOrderService, commonService, $compile, $sce) {

    $scope.qryPreSaleOrderInfo = {};
    $scope.payRemainSaveInfo = {};
    $scope.cancelPreOrderSaveInfo = {};
    $scope.robotInfo = {};
    $scope.loginSession = {};
    $scope.isRobot = false;
    //状态下拉
    $scope.statusConfig = {
        minimumResultsForSearch: -1,
        data: [],
        placeholder: '请选择...'
    };
    //撤销原因
    $scope.backReasonConfig = {
        minimumResultsForSearch: -1,
        data: [],
        placeholder: '请选择...'
    };
    $scope.dropConfig = {
        treeData: [],
        treeConfig: {
            version: 1,
        },
        instance: null,
        infoType: null,
        infoMsg: "",
        treeTypes: {
            'default': {
                icon: "glyphicon glyphicon-flash"
            },
            star: {
                icon: "glyphicon glyphicon-star"
            },
            cloud: {
                icon: "glyphicon glyphicon-cloud"
            }
        },
        dropData: "",
        treeEvents: {}
    };
    // 检测界面是否提供参数，获取crm2登录信息
    var localUrl = window.location.href;
    if (!ffc.util.isEmpty(localUrl)) {
        var params = ffc.util.getHrefParam(localUrl, "?");
        // 自主加载数据
        if ("1" === ffc.util.getHrefValue(params, "auto")) {
            var areas = ffc.util.getHrefValue(params, "keyAreas");
            if (!ffc.util.isEmpty(areas)) {
                var j = 0;
                var area = new Array();
                if (areas.indexOf(",") > 0) {
                    var a = areas.split(",");
                    for (var i = 0; i < a.length; i++) {
                        if (!ffc.util.isEmpty(a[i])) {
                            area[j++] = a[i];
                        }
                    }
                } else {
                    area[0] = areas;
                }
                // 页面树设置
                $scope.dropConfig.selectedData = area;
            }
        }
        // 默认加载
        casOrderService.qryRegionData({}, function (rt) {
            if (rt && rt.result) {
                if (rt.dataList && rt.dataList.length >= 0) {
                    $scope.dropConfig.treeData = rt.dataList;
                } else {
                    $scope.dropConfig.infoType = "warning";
                    $scope.dropConfig.infoMsg = "找不到匹配数据";
                }
            } else {
                $scope.dropConfig.infoType = "danger";
                $scope.dropConfig.infoMsg = "数据有误....";
            }
        }, function (err) {
            $scope.dropConfig.infoType = "danger";
            $scope.dropConfig.infoMsg = "请求失败...";
        });
    }

    //获取session团队信息
    $scope.orgList = [{
        orgName: ffc.util.isEmpty(ffc.context.loginInfo.orgName) ? "请选择..." : ffc.context.loginInfo.orgName,
        orgId: ffc.util.isEmpty(ffc.context.loginInfo.orgId) ? null : ffc.context.loginInfo.orgId
    }];

    //crm00077148 请看单子详细说明
    if("false" == ffc.context.loginInfo.isWholeReginPri){
        $scope.orgList[0].btnDis = true;
    }
    //时间选择器
    $('.form_date').datetimepicker({
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
    // 表格初始化
    $("#preSaleOrderTable").bootstrapTable({
        // 加载成功后重新编译，试点formatter后的dom元素支持angularjs
        onResetView: function () {
            $compile($('#preSaleOrderTable'))($scope);
        },
        // 条件
        queryParams: function (params) {
            //查询条件
            var selfParams = {
                preOrderNumber: $scope.qryPreSaleOrderInfo.preOrderNumber,
                orgId: ffc.util.isEmpty($scope.orgList) ? null : $scope.orgList[0].orgId,
                staffId: ffc.util.isEmpty($scope.staffList) ? null : $scope.staffList[0].staffId,
                commonRegionStr: $scope.dropConfig.dropData,
                beginTime: ffc.util.tableDateFormatter($scope.qryPreSaleOrderInfo.beginTime?$scope.qryPreSaleOrderInfo.beginTime+" 00:00:00":null),
                endTime: ffc.util.tableDateFormatter($scope.qryPreSaleOrderInfo.endTime?$scope.qryPreSaleOrderInfo.endTime+" 23:59:59":null),
                fromQryBtn : $scope.fromQryBtn,
                statusCd: $scope.qryPreSaleOrderInfo.statusCd
            }
            return $.extend({}, params, selfParams);
        },
        // 服务请求
        ajax: function (render) {
            try {
                if (!render.data) {
                    ffc.util.loadTableData(render);
                } else {
                    $scope.robotInfo = {};
                    $scope.isRobot = false;
                    // 服务请求
                    casOrderService.qryPreSaleOrder(render.data, function (result) {
                        if (!result.result) {
                            if (!ffc.util.isEmpty(result.msgTitle)) {
                                MESSAGE_DIALOG.error(result.msgTitle + "");
                            }
                            ffc.util.loadTableData(render);
                            return false;
                        }
                        ffc.util.setPageResult($scope, 'preSaleOrderErrorAlert', render, result);
                    });
                }
            } catch (e) {
                ffc.util.loadTableData(render);
            }

        },
        // 点击行事件
        onClickRow: function (row, $element) {
            // 点击行后
            $scope.preOrderId = !ffc.util.isEmpty(row.preOrderId) ? row.preOrderId : "";
            $scope.preOrderNumber = row.preOrderNumber;
            if ("200098" == row.statusCd || "200099" == row.statusCd) {
                casOrderService.isShowRobotBtn(row, function (result) {
                    if (result.result) {
                        $scope.robotInfo = row;
                        $scope.isRobot = true;
                    } else {
                        $scope.robotInfo = {};
                        $scope.isRobot = false;
                    }
                }, function (msg) {

                });
            }

            // 点击行后 触发当前tab
            ffc.util.tabsActiveTriggerNg(["#b1_c1"]);
        }
    });

    //查询
    $scope.qryPreSaleOrders = function () {
        $scope.fromQryBtn = "1";
        $('#preSaleOrderProcTable').bootstrapTable('removeAll');
        if (ffc.util.isEmpty($scope.orgList)
            && ffc.util.isEmpty($scope.qryPreSaleOrderInfo.preOrderNumber)) {
            MESSAGE_DIALOG.warning("预受理团队和订单编号至少有个不能为空!");
            return false;
        }
        $("#preSaleOrderTable").bootstrapTable("selectPage", 1);
    }
    //重置
    $scope.resetQryInfo = function () {
        $scope.qryPreSaleOrderInfo = {}
        //获取session团队信息
        $scope.orgList = [{
            orgName: ffc.util.isEmpty(ffc.context.loginInfo.orgName) ? "请选择..." : ffc.context.loginInfo.orgName,
            orgId: ffc.util.isEmpty(ffc.context.loginInfo.orgId) ? null : ffc.context.loginInfo.orgId,
            btnDis: "false" == ffc.context.loginInfo.isWholeReginPri ? true : false
        }];
        $scope.staffList = [{
            staffName: "请选择..",
            staffId: null
        }];
        //区域重置
        $scope.dropConfig.instance.jstree(true).deselect_all()
    }
    //导出数据
    $scope.exportExcelData = function () {
        var data = $("#preSaleOrderTable").bootstrapTable("getData");
        if (undefined == data || data.length == 0) {
            MESSAGE_DIALOG.warning("需要导出的数据为空!");
            return false;
        }
        $scope.qryPreSaleOrderInfo.isExport = "1";
        MESSAGE_DIALOG.loading();
        $scope.qryPreSaleOrderInfo.orgId = ffc.util.isEmpty($scope.orgList) ? null : $scope.orgList[0].orgId;
        $scope.qryPreSaleOrderInfo.staffId = ffc.util.isEmpty($scope.staffList) ? null : $scope.staffList[0].staffId;
        $scope.qryPreSaleOrderInfo.commonRegionStr = $scope.dropConfig.dropData;
        var url = ffc.context.contextPath + '/order/preSaleOrder/downloadPOrderList';
        $.fileDownload(url,
            {
                httpMethod: "POST",
                data: {
                    exportData: JSON.stringify($scope.qryPreSaleOrderInfo)
                }
            }).done(function (res) {
            MESSAGE_DIALOG.close();
        }).fail(function (res) {
            MESSAGE_DIALOG.error("导出失败，请核查！" + res);
        });
        //MESSAGE_DIALOG.close();
        $scope.isExport = "0";
    }

    // 页面下拉框数据
    var initAllListBox = function () {
        casOrderService.queryAllBoxListForPreSaleOrder("", function (result) {
            //状态类型
            if (!ffc.util.isEmpty(result)
                && !ffc.util.isEmpty(result.object)) {
                if (0 < result.object.statusCdList.length) {
                    $scope.statusTypes = result.object.statusCdList;
                    $scope.statusConfig.data = $scope.statusTypes;
                    $scope.qryPreSaleOrderInfo.statusCd = "";
                }
                //撤销原因
                if (0 < result.object.backReasonList.length) {
                    $scope.backReasonTypes = result.object.backReasonList;
                    $scope.backReasonConfig.data = $scope.backReasonTypes;
                    $scope.qryPreSaleOrderInfo.backReason = $scope.backReasonTypes[0];
                    $scope.qryPreSaleOrderInfo.backReasonId = "";
                }
            }

        }, function (res) {
            MESSAGE_DIALOG.error(res);
        });
    };
    // 初始化
    commonService.initFrom(ffc.util.getPageMetas($scope), function () {
        if (ffc.util.isEmpty($scope.statusTypes)) {
            initAllListBox();
        }
        $('#preSaleOrderTable tbody').delegate('tr', 'click', function () {
            $(this).addClass("tr-onClick").siblings("tr").removeClass("tr-onClick");
        });
    });

    //撤销
    $scope.cancelPreSaleOrder = function (preOrderId, preOrderNumber, staffName, mobilePhone, event) {
        event.stopPropagation();
        $scope.cancelPreOrderSaveInfo = {}
        $scope.cancelPreOrderSaveInfo.preOrderNumber = preOrderNumber;
        $scope.cancelPreOrderSaveInfo.staffName = staffName;
        $scope.cancelPreOrderSaveInfo.mobilePhone = mobilePhone;
        $scope.cancelPreOrderSaveInfo.preOrderId = preOrderId;
        $("#cancel_pre_order").modal("show");
    }
    //撤销信息采集 确认
    $scope.confirmCancelPreOrder = function () {
        $scope.cancelPreOrderSaveInfo.cancelReason = $scope.qryPreSaleOrderInfo.backReason.attrValueName;
        $scope.cancelPreOrderSaveInfo.cancelReasonId = $scope.qryPreSaleOrderInfo.backReason.attrValueId;
        if (ffc.util.isEmpty($scope.cancelPreOrderSaveInfo.cancelReason)) {
            MESSAGE_DIALOG.warning("原因描述为必填项!!");
            return;
        }
        $scope.cancelPreOrderSaveInfo.cancelReasonValue = $scope.qryPreSaleOrderInfo.backReasonId;
        casOrderService.cancelPreOrderData($scope.cancelPreOrderSaveInfo, function (result) {
            if (undefined != result.result && result.result == true) {
                $('#cancel_pre_order').modal('hide');
                $scope.qryPreSaleOrders();
            } else {
                MESSAGE_DIALOG.warning(result.msgTitle + " 撤销失败！");
                return;
            }
        }, function (msg) {
            MESSAGE_DIALOG.error("撤销失败！" + msg);
            return;
        });
    }
    //关闭撤销页面
    $scope.closeCancelPreOrder = function () {
        $("#cancel_pre_order").modal("hide");
    }

    //补首款弹出
    $scope.payRemainMoney = function (preOrderId, event) {
        event.stopPropagation();
        $scope.payRemainSaveInfo = {}
        $scope.payRemainSaveInfo.preOrderId = preOrderId;
        $("#pay_remain_money").modal("show");
    }
    //补收款采集 确认
    $scope.confirmPayRemain = function () {
        if (ffc.util.isEmpty($scope.payRemainSaveInfo.payResource)
            && ffc.util.isEmpty($scope.payRemainSaveInfo.payStore)
            && ffc.util.isEmpty($scope.payRemainSaveInfo.paySample)) {
            MESSAGE_DIALOG.alert("至少输入一项金额");
            return;
        }
        casOrderService.remainPreSaleAcctItem($scope.payRemainSaveInfo, function (result) {
            if (undefined != result.result && result.result == true) {
                MESSAGE_DIALOG.alert("补收款成功！");
                $('#pay_remain_money').modal('hide');
                $scope.qryPreSaleOrders();
            } else {
                MESSAGE_DIALOG.warning(result.msgTitle + ",补收款失败！");
                return;
            }
        }, function (msg) {
            MESSAGE_DIALOG.error("补收款失败！" + msg);
            return;
        });
    }
    //归档处理
    $scope.archIve = function (rowIndex, event) {
        event.stopPropagation();
        $scope.preSaleOrderInfo = {};
        var allTable = $('#preSaleOrderTable')
            .bootstrapTable("getData");
        var selectRow = allTable[rowIndex];
        $scope.preSaleOrderInfo = selectRow;
        MESSAGE_DIALOG.confirm("确认做归档处理？", function () {
            MESSAGE_DIALOG.loading();
            casOrderService.archIveData($scope.preSaleOrderInfo, function (result) {
                if (undefined != result.result && result.result == true) {
                    MESSAGE_DIALOG.alert("归档成功," + result.msgTitle);
                    window.setTimeout("MESSAGE_DIALOG.close()", 2000);
                    $scope.qryPreSaleOrders();
                } else {
                    MESSAGE_DIALOG.alert(result.msgTitle + ",归档处理失败！");
                    return;
                }
            }, function (msg) {
                MESSAGE_DIALOG.alert("归档处理失败！" + msg);
                return;
            });
        });
    }

    //费用收取
    $scope.payMoney = function (rowIndex, event) {
        event.stopPropagation();
        $scope.preSaleOrderInfo = {};
        var allTable = $('#preSaleOrderTable')
            .bootstrapTable("getData");
        var selectRow = allTable[rowIndex];
        $scope.preSaleOrderInfo = selectRow;
        MESSAGE_DIALOG.loading();
        casOrderService.qryHbPreSaleUrl($scope.preSaleOrderInfo, function (result) {
            if (undefined != result.result && result.result == true) {
                MESSAGE_DIALOG.close();
                //费用收取页面
                var hbUrl = $sce.trustAsResourceUrl(result.object);
                var rValue = onInvoke(hbUrl, "810px", "600px", "1");
                if (undefined != rValue && "0"==rValue) {
                	casOrderService.updatePreSaleOrder($scope.preSaleOrderInfo,function(result) {

                	});
                }
                //console.log(result);
                $scope.qryPreSaleOrders();
            } else {
                MESSAGE_DIALOG.warning("" + result.msgTitle);
                return;
            }
        });
    }
    //机器人受理
    $scope.robotAccept = function () {
        MESSAGE_DIALOG.loading();
        if (undefined == $scope.robotInfo.preOrderId) {
            MESSAGE_DIALOG.alert("您选中的记录的preOrderId标识为空,请核查!");
            return false;
        }
        casOrderService.robotAccept($scope.robotInfo, function (result) {
            if (!result.result) {
                MESSAGE_DIALOG.warning("" + result.msgTitle);
                return false;
            }
            MESSAGE_DIALOG.alert("机器人受理成功!");
        }, function (msg) {
            MESSAGE_DIALOG.error("" + msg);
        });
    }
}]);
//预受理订单操作
var preSaleOrderFormatter = function (value, row, index) {
    var operateFirst;  //按钮一
    var operateSecond; //按钮二
    var operateThird;  //按钮三
    var operateFouth = '<a ng-click="archIve(' + index + ',$event)">归档处理</a>';  //按钮四

    var preOrderNum = ffc.util.isEmpty(row.preOrderNumber) ? "" : row.preOrderNumber;
    var staffName = ffc.util.isEmpty(row.staffName) ? "" : row.staffName;
    var mobilePhone = ffc.util.isEmpty(row.mobilePhone) ? "" : row.mobilePhone;
    //待收费或者退费中
    if ("101200" == row.statusCd || "401297" == row.statusCd) {
        operateFirst = '<a ng-click="payMoney(' + index + ',$event)">费用收取</a>';
    }
    //待受理、部分受理或全部受理（在途）时
    if (("200098" == row.statusCd || "200099" == row.statusCd
        || "200000" == row.statusCd || "201400" == row.statusCd)
        && ffc.util.isEmpty(row.realAcceptHasPayFlag)) {
        operateSecond = '<a ng-click="payRemainMoney(' + row.preOrderId + ',$event)">补收款</a>';
    }
    //待收费、待受理、部分受理、全部受理（在途）或者部分竣工时
    if ("101200" == row.statusCd || "200098" == row.statusCd || "200099" == row.statusCd
        || "200000" == row.statusCd || "201400" == row.statusCd || "301400" == row.statusCd) {
        operateThird = '<a ng-click="cancelPreSaleOrder('
            + row.preOrderId + ',\'' + preOrderNum + '\',\'' + staffName + '\',\'' + mobilePhone + '\',$event)">撤销</a>';
    }
    operateFirst = ffc.util.isEmpty(operateFirst) ? "" : operateFirst + " | ";
    operateSecond = ffc.util.isEmpty(operateSecond) ? "" : operateSecond + " | ";
    operateThird = ffc.util.isEmpty(operateThird) ? "" : operateThird + " | ";
    return operateFirst + operateSecond + operateThird + operateFouth;
    //return '<a ng-click="payRemainMoney(' + row.preOrderId + ')">补收款</a>';
    //return testPay;
}

$(function () {
    //阻止onclickRow
    /*    $(".privateFor").click(function (event) {
     event.stopPropagation();
     event.preventdefault();
     });*/
    $("#payResource").bigGlass(1);
    $("#payStore").bigGlass(1);
    $("#paySample").bigGlass(1);
})