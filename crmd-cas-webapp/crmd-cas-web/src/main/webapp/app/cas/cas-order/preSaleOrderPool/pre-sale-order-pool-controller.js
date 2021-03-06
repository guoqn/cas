/**
 * Created by qn_guo on 2016/1/26.
 */
var preSaleOrderPoolApp = angular.module("preSaleOrderPoolApp", ["casOrderServiceApp", 'ui.select', "bsTable", "ngSelect2",
    "orgCompApp", "staffCompApp", "sceneTypeCompApp", "regionCompApp", "statusCompApp"
    , "receiveStaffCompApp", "dropTreeApp", "ngJqueryFileUploadApp"])
preSaleOrderPoolApp.controller("preSaleOrderPoolCtrl", ["$scope", "casOrderService",
    "commonService", "$compile", "$sce",
    function ($scope, casOrderService, commonService, $compile, $sce) {
        $scope.qryPreSaleOrderPoolInfo = {};
        $scope.initPreSaleOrderPoolInfo = {};
        $scope.loginSession = {};
        $scope.showOnClickBtn = false;
        var defaultConfig = {};
        //业务类型下拉
        $scope.serviceTypeConfig = {
            minimumResultsForSearch: -1,
            data: [],
            placeholder: '请选择...'
        };
        //工单来源
        $scope.preOrderSrcsConfg = {
            minimumResultsForSearch: -1,
            data: [],
            placeholder: '请选择...'
        }
        //获取session区域信息
        $scope.regionList = [{
            regionName: ffc.util.isEmpty(ffc.context.loginInfo.regionName) ? "请选择..." : ffc.context.loginInfo.regionName,
            regionId: ffc.util.isEmpty(ffc.context.loginInfo.regionCd) ? null : ffc.context.loginInfo.regionCd,
            regionType: ffc.util.isEmpty(ffc.context.loginInfo.regionType) ? null : ffc.context.loginInfo.regionType
        }];
        //获取session团队信息
        $scope.orgList = [{
            orgName: ffc.util.isEmpty(ffc.context.loginInfo.orgName) ? "请选择..." : ffc.context.loginInfo.orgName,
            orgId: ffc.util.isEmpty(ffc.context.loginInfo.orgId) ? null : ffc.context.loginInfo.orgId
        }];
        $scope.staffList = [{
            staffName: "请选择...",
            staffId: null
        }];

        /**
         * 初始化配置信息
         */
        if ("1" == ffc.context.loginInfo.c3c4Assign || "1" == ffc.context.loginInfo.c3c4orgAssign) {
            $scope.regionList = [{
                regionName: "所有",
                regionId: null
            }];
            $scope.orgList = [{
                orgName: "所有",
                orgId: null
            }];
            defaultConfig.regionName ="所有";
            defaultConfig.regionId = null;
            defaultConfig.orgName ="所有";
            defaultConfig.orgId = null;
        } else if ("1" == ffc.context.loginInfo.orgAssign) {
            $scope.regionList = [{
                regionName: "所有",
                regionId: null,
                btnDis: true
            }];
            $scope.orgList = [{
                orgName: "所有",
                orgId: null
            }];
            defaultConfig.regionName ="所有";
            defaultConfig.regionId = null;
            defaultConfig.orgName ="所有";
            defaultConfig.orgId = null;
        } else if ("1" == ffc.context.loginInfo.notC3c4orgAssign) {
            $scope.regionList = [{
                regionName: "所有",
                regionId: null
            }];
            defaultConfig.regionName ="所有";
            defaultConfig.regionId = null;
        } else if ("1" == ffc.context.loginInfo.notConfigured) {  //未配置
            $scope.regionList = [{
                regionName: "未配置",
                regionId: null,
                btnDis: true
            }];
            $scope.orgList = [{
                orgName: "未配置",
                orgId: null,
                btnDis: true
            }];
            $scope.staffList[0].btnDis = true;
            defaultConfig.regionName ="未配置";
            defaultConfig.regionId = null;
            defaultConfig.orgName ="未配置";
            defaultConfig.orgId = null;
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
        ffc.util.tabsShownTriggerNg();
        // 表格初始化
        $("#preSaleOrderPoolTable").bootstrapTable({
            rowAttributes: function (row, index) {
                return {
                    "title": "销售人员联系号码:" + row.mobilePhone
                };
            },
            // 加载成功后重新编译，试点formatter后的dom元素支持angularjs
            onResetView: function () {
                $compile($('#preSaleOrderPoolTable'))($scope);
            },
            // 条件
            queryParams: function (params) {
                //查询条件
                var selfParams = {
                    preOrderNumber: $scope.qryPreSaleOrderPoolInfo.preOrderNumber,
                    orgId: ffc.util.isEmpty($scope.orgList) ? null : $scope.orgList[0].orgId, //预受理团队
                    createStaff: ffc.util.isEmpty($scope.staffList) ? null : $scope.staffList[0].staffId, //预受理员工
                    commonRegionId: ffc.util.isEmpty($scope.regionList) ? null : $scope.regionList[0].regionId, //预受理区域
                    staffId: ffc.util.isEmpty($scope.receiveStaffList) ? null : $scope.receiveStaffList[0].staffId,//接收员工
                    beginTime: ffc.util.tableDateFormatter($scope.qryPreSaleOrderPoolInfo.beginTime?$scope.qryPreSaleOrderPoolInfo.beginTime+" 00:00:00":null),
                    endTime: ffc.util.tableDateFormatter($scope.qryPreSaleOrderPoolInfo.endTime?$scope.qryPreSaleOrderPoolInfo.endTime+" 23:59:59":null),
                    status: $scope.statusData,
                    sceneType: $scope.sceneTypeData,
                    preOrderSrc: $scope.qryPreSaleOrderPoolInfo.preOrderSrc,
                    serviceType: $scope.qryPreSaleOrderPoolInfo.serviceType,
                    regionType: ffc.util.isEmpty($scope.regionList) ? null : $scope.regionList[0].regionType, //区域类型
                    fromQryBtn : $scope.fromQryBtn,
                    acrossOrgDTO : ffc.context.loginInfo.acrossOrgDTO,
                    from: 'pool'

                }
                return $.extend({}, params, selfParams);
            },
            // 服务请求
            ajax: function (render) {
                try {
                    if (!render.data) {
                        ffc.util.loadTableData(render);
                    } else {
                        // 服务请求

                        casOrderService.qryPreSaleOrderPools(render.data, function (result) {
                            $scope.showOnClickBtn = false;
                            if (!result.result){
                                if (!ffc.util.isEmpty(result.msgTitle)) {
                                    MESSAGE_DIALOG.error(result.msgTitle +"");
                                }
                                ffc.util.loadTableData(render);
                                return false;
                            }
                            ffc.util.setPageResult($scope, 'preSaleOrderPoolErrorAlert', render, result);
                        });
                    }
                } catch (e) {
                    ffc.util.loadTableData(render);
                }
            },
            // 点击行事件
            onClickRow: function (row, $element) {
                // 点击行后 更改流程id
                $scope.preOrderId = !ffc.util.isEmpty(row.preOrderId) ? row.preOrderId : "";
                $scope.preOrderNbr = row.preOrderNbr;
                $scope.showOnClickBtn = true;
                // 点击行后 触发当前tab
                ffc.util.tabsActiveTriggerNg(["#b1_c1"]);
            }
        });
        //查询
        $scope.qryPreSaleOrderPools = function () {
            $scope.fromQryBtn = "1";
            $("#preSaleOrderPoolProcTable").bootstrapTable('removeAll');
            $("#preSaleOrderPoolTable").bootstrapTable("selectPage", 1);
            preSaleAccount();
        }
        //重置
        $scope.resetQryInfo = function () {
            $scope.qryPreSaleOrderPoolInfo = {}
            //获取session区域信息
            $scope.regionList = [{
                regionName:ffc.util.isEmpty(defaultConfig.regionName) ? null :defaultConfig.regionName,
                regionId: ffc.util.isEmpty(defaultConfig.regionId) ? null :defaultConfig.regionId,
            }];
            //获取session团队信息
            $scope.orgList = [{
                orgName: ffc.util.isEmpty(defaultConfig.orgName) ? null :defaultConfig.orgName,
                orgId: ffc.util.isEmpty(defaultConfig.orgId) ? null :defaultConfig.orgId
            }];
            $scope.staffList = [{
                staffName: "请选择...",
                staffId: null
            }];
            $scope.receiveStaffList = [{
                staffName: "请选择...",
                staffId: null
            }];
            initAllListBox();
        }
        // 页面订单状态下拉框
        var initAllListBox = function () {
            casOrderService.queryAllBoxListForPreSaleOrderPool("", function (result) {
                //状态类型
                if (!ffc.util.isEmpty(result)
                    && !ffc.util.isEmpty(result.object)) {
                    //状态类型初始化
                    if (0 < result.object.statusCdList.length) {
                        $scope.statusTypes = result.object.statusCdList;
                        var dataList = [];
                        for (var i = 0; i < $scope.statusTypes.length; i++) {
                            var statusList = {};
                            statusList['status'] = $scope.statusTypes[i].attrValue;
                            statusList['statusName'] = $scope.statusTypes[i].attrValueName;
                            dataList.push(statusList);
                        }
                        $scope.statusList = dataList;
                    }
                    //受理类型
                    if (result.object.sceneTypeList.length > 0) {
                        $scope.sceneTypes = result.object.sceneTypeList;
                        var dataList = [];
                        for (var i = 0; i < $scope.sceneTypes.length; i++) {
                            var sceneTypeList = {};
                            sceneTypeList['sceneType'] = $scope.sceneTypes[i].attrValue;
                            sceneTypeList['sceneTypeName'] = $scope.sceneTypes[i].attrValueName;
                            dataList.push(sceneTypeList);
                        }
                        $scope.sceneTypeList = dataList;
                    }
                    //业务类型
                    if (result.object.serviceTypeList.length > 0) {
                        $scope.serviceTypes = result.object.serviceTypeList;
                        $scope.serviceTypeConfig.data = $scope.serviceTypes;
                        $scope.qryPreSaleOrderPoolInfo.serviceType = "";
                    }
                    //工单来源
                    if (result.object.preOrderSrcs.length > 0) {
                        $scope.preOrderSrcs = result.object.preOrderSrcs;
                        $scope.preOrderSrcsConfg.data = $scope.preOrderSrcs;
                        $scope.qryPreSaleOrderPoolInfo.preOrderSrc = "";
                    }
                }
            }, function (msg) {
                MESSAGE_DIALOG.error("后台查询出错!" + msg)
            });
        };
        //查询工单池总数
        var preSaleAccount = function () {
            $scope.preSaleorderCount = {};
            var acrossOrgDTO = ffc.context.loginInfo.acrossOrgDTO;
            casOrderService.qryPreSaleOrderPoolAmount(acrossOrgDTO, function (result) {
                if (!ffc.util.isEmpty(result) && !ffc.util.isEmpty(result.object)) {
                    //工单池总数
                    $scope.preSaleorderCount.countAll =
                        ffc.util.isEmpty(result.object.totalAmount) ? "0" : result.object.totalAmount;
                    //其中未接收
                    $scope.preSaleorderCount.countWJS =
                        ffc.util.isEmpty(result.object.unAcceptAmount) ? "0" : result.object.unAcceptAmount;
                    //可派单
                    $scope.preSaleorderCount.countKPD =
                        ffc.util.isEmpty(result.object.assignableAmount) ? "0" : result.object.assignableAmount;
                }
            }, function (msg) {
                MESSAGE_DIALOG.error("后台查询出错!" + msg);
            });
        }
        // 初始化
        commonService.initFrom(ffc.util.getPageMetas($scope), function () {
            if (ffc.util.isEmpty($scope.statusTypes)) {
                initAllListBox();
                //preSaleAccount();不初始化数量
            }
            $('#preSaleOrderPoolTable tbody').delegate('tr', 'click', function () {
                $(this).addClass("tr-onClick").siblings("tr").removeClass("tr-onClick");
            });
        });
        //批量派单
        $scope.batchAccepts = function () {
            $scope.batchData = "batch";
            $scope.initPreSaleOrderPoolInfo = {};
            var batchSelect = $('#preSaleOrderPoolTable').bootstrapTable('getSelections');
            if (ffc.util.isEmpty(batchSelect) || batchSelect.length == 0) {
                MESSAGE_DIALOG.alert("请选择需要派单的记录。");
                return;
            }
            $('#pre_sale_order_pool_accept').modal('show');
        }

        //批量派单确认
        var confirmBatchAccepts = function () {
            var batchSelect = $('#preSaleOrderPoolTable').bootstrapTable('getSelections');
            $scope.initPreSaleOrderPoolInfo.selectData = batchSelect;
            MESSAGE_DIALOG.loading();
            casOrderService.batchAcceptsData($scope.initPreSaleOrderPoolInfo, function (result) {
                if (result.result) {
                    $('#pre_sale_order_pool_accept').modal('hide');
                    $scope.resetQryInfo();
                    MESSAGE_DIALOG.alert("批量派单成功");
                    $scope.qryPreSaleOrderPools();
                    preSaleAccount();
                } else {
                    MESSAGE_DIALOG.warning("批量派单失败" + result.msgTitle);
                }
            }, function (msg) {
                MESSAGE_DIALOG.error("批量派单异常" + msg);
            });

        }
        /**派单
         * 选择的工单池记录的接收员工（pre_sale_order_pool.staff_id）与选择的员工一致不处
         * @param preSaleOrderPoolId
         */
        $scope.onAccept = function (rowIndex, event) {
            $scope.batchData = "";
            event.stopPropagation();
            var allTable = $('#preSaleOrderPoolTable')
                .bootstrapTable("getData");
            var selectRow = allTable[rowIndex];
            $scope.initPreSaleOrderPoolInfo = selectRow;
            $('#pre_sale_order_pool_accept').modal('show');
        };
        //派单确认
        $scope.confirmAccept = function () {
            var acceptStaffId = ffc.util.isEmpty(
                $scope.receiveStaffList) ? null : $scope.receiveStaffList[0].staffId;
            if (acceptStaffId == null) {
                MESSAGE_DIALOG.warning("请选择员工!");
                return;
            }
            if ($scope.initPreSaleOrderPoolInfo.staffId == acceptStaffId) {
                MESSAGE_DIALOG.error("当前接收工号与派单工号一致！请不要重复派单！!");
                return;
            }
            $scope.initPreSaleOrderPoolInfo.acceptStaffId = acceptStaffId;
            MESSAGE_DIALOG.loading();
            //批量派单
            if (!ffc.util.isEmpty($scope.batchData)) {
                confirmBatchAccepts();
            } else {
                casOrderService.confirmAcceptData($scope.initPreSaleOrderPoolInfo, function (result) {
                    if (result.result) {
                        $('#pre_sale_order_pool_accept').modal('hide');
                        $scope.resetQryInfo();
                        MESSAGE_DIALOG.alert("派单成功!");
                        $scope.qryPreSaleOrderPools();
                        preSaleAccount();
                    } else {
                        MESSAGE_DIALOG.warning("派单失败!" + result.msgTitle);
                    }
                }, function (msg) {
                    MESSAGE_DIALOG.error("派单异常!" + msg);
                });
            }
        }
        //派单取消
        $scope.cancelAccept = function () {
            $('#pre_sale_order_pool_accept').modal('hide');
        }
        //设置为部分受理
        $scope.returnAccept = function (rowIndex, event) {
            event.stopPropagation();
            $scope.initPreSaleOrderPoolInfo = {};
            var allTable = $('#preSaleOrderPoolTable')
                .bootstrapTable("getData");
            var selectRow = allTable[rowIndex];
            $scope.initPreSaleOrderPoolInfo = selectRow;
            MESSAGE_DIALOG.loading();
            casOrderService.returnToAcceptData($scope.initPreSaleOrderPoolInfo, function (result) {
                if (result.result) {
                    MESSAGE_DIALOG.alert("设置为部分受理成功!");
                    $scope.qryPreSaleOrderPools();
                    preSaleAccount();
                } else {
                    MESSAGE_DIALOG.warning("设置为部分受理失败!" + result.msgTitle);
                }
            }, function (msg) {
                MESSAGE_DIALOG.error("设置为部分受理异常!" + msg);
            });
        }
        //发送短信
        $scope.sendMessage = function (rowIndex, event) {
            $scope.sendMessageInfo = {};
            event.stopPropagation();
            var allTable = $('#preSaleOrderPoolTable')
                .bootstrapTable("getData");
            var selectRow = allTable[rowIndex];
            $scope.sendMessageInfo = selectRow;
            $("#send_message_pre_order").modal('show');
        }
        //确认发送短信
        $scope.confirmSendMessage = function () {
            MESSAGE_DIALOG.loading();
            casOrderService.sendMessageData($scope.sendMessageInfo, function (result) {
                if (result.result) {
                    $("#send_message_pre_order").modal('hide');
                    MESSAGE_DIALOG.alert("" + result.msgTitle);
                } else {
                    MESSAGE_DIALOG.warning("发送短信失败." + result.msgTitle)
                }
            }, function (msg) {
                MESSAGE_DIALOG.error("" + msg);
            })
        }
        //工单分布
        $scope.qryPreOrderDistribute = function () {
            $('#pre-order-distribute').modal('show');
            $('#preOrderDistributeTable').bootstrapTable('showLoading');
            casOrderService.qryPreOrderDistributeData("", function (result) {
                $('#preOrderDistributeTable').bootstrapTable('hideLoading');
                if (!result.result || undefined == result.dataList
                    || result.dataList.length == 0) {
                    return false;
                }
                $('#preOrderDistributeTable').bootstrapTable("load", result.dataList);
            }, function (msg) {
                MESSAGE_DIALOG.error("" + msg);
            });
        }
        //关闭工单分布页面
        $scope.closePreOrder = function () {
            $('#pre-order-distribute').modal('hide');
        }

        //P单详情
        $scope.qryPreOrderDetail = function () {
            var getData = $('#preSaleOrderPoolTable').bootstrapTable('getSelections');
            if (getData != undefined && getData.length > 1) {
                MESSAGE_DIALOG.warning("请只选择一条记录!");
                return false;
            }
            if (undefined == getData || getData.length == 0) {
                MESSAGE_DIALOG.alert("请选中一条记录");
                return false;
            }
            if (ffc.util.isEmpty(getData[0].preOrderNbr)){
                MESSAGE_DIALOG.alert("您选中的记录的P单编号为空!.");
                return false;
            }
            var preOrderNbr = getData[0].preOrderNbr;
            // 动态依赖注入
            var injector = angular.injector(["casOrderServiceApp", "ng"]);
            injector.invoke(['casOrderService', function (casOrderService) {
                var param = "pageCls=dtOrder&keyFlag=0&keyType=bycustsonbr&keyValue=" + preOrderNbr + "&auto=1";
                casOrderService.invokeToOrder(param);
            }]);
        }

        /*//附件上传
        $scope.upload = function () {
            var getData = $('#preSaleOrderPoolTable').bootstrapTable('getSelections');
            if (getData != undefined && getData.length > 1) {
                MESSAGE_DIALOG.warning("请只选择一条记录!");
                return false;
            }
            if (undefined == getData || getData.length == 0) {
                MESSAGE_DIALOG.warning("请先选择一条记录!");
                return false;
            }
            if ($scope.uploadFile) {
                $scope.doUpload($scope.uploadFile,getData[0].preOrderId);
            }
        }
        //执行上传
        $scope.doUpload = function (file,preOrderId) {
            MESSAGE_DIALOG.loading();
            Upload.upload(
                {
                    url: ffc.context.contextPath + '/order/preSaleOrderPool/uploadFile',
                    data: {
                        uploadFile: file,
                        preOrderId: preOrderId
                    }
                }).then(
                function (resp) {
                    //console.log(resp);
                    if (undefined != resp.data && false == resp.data.result) {
                        MESSAGE_DIALOG.error("附件: '" + resp.config.data.uploadFile.name
                            + " ',上传失败:\n" + resp.data.msgTitle);
                        return false;
                    }
                    MESSAGE_DIALOG.alert("附件上传成功!");
                    window.setTimeout("MESSAGE_DIALOG.close()", 1000);
                }, function (resp) {
                    if (undefined != resp.data && false == resp.data.result) {
                        MESSAGE_DIALOG.error("附件" + resp.config.data.uploadFile.name
                            + "上传失败:\n" + resp.data.msgTitle);
                    }
                }, function (evt) {
                });
        }*/
        /**
         * 附件上传
         */
        $scope.submit = function (e, data) {
            var getData = $('#preSaleOrderPoolTable').bootstrapTable('getSelections');
            if (getData != undefined && getData.length > 1) {
                MESSAGE_DIALOG.warning("请只选择一条记录!");
                return false;
            }
            if (undefined == getData || getData.length == 0) {
                MESSAGE_DIALOG.warning("请先选择一条记录!");
                return false;
            }
            data.formData =
            {
                preOrderId: $scope.preOrderId
            }
        }

        $scope.uploadFinished = function (e, data) {
            if (!ffc.util.isEmpty(data.result) && !ffc.util.isEmpty(data.result.result)
                && data.result.result == true) {
                MESSAGE_DIALOG.alert("文件：" + data.files[0].name + "，上传成功！");
            } else {
                MESSAGE_DIALOG.error("文件上传失败，请核查！"+data.result.msgTitle);
            }
        }
        $scope.fail = function (e, data) {
            var getData = $('#preSaleOrderPoolTable').bootstrapTable('getSelections');
            if (getData != undefined && getData.length > 1) {
                MESSAGE_DIALOG.warning("请只选择一条记录!");
                return false;
            }
            if (undefined == getData || getData.length == 0) {
                MESSAGE_DIALOG.warning("请先选择一条记录!");
                return false;
            }
            MESSAGE_DIALOG.error("文件上传失败，请核查！"+data.result.msgTitle);
        }
        $scope.progress = function (e, data) {
            var getData = $('#preSaleOrderPoolTable').bootstrapTable('getSelections');
            if (getData != undefined && getData.length > 1) {
                MESSAGE_DIALOG.warning("请只选择一条记录!");
                return false;
            }
            if (undefined == getData || getData.length == 0) {
                MESSAGE_DIALOG.warning("请先选择一条记录!");
                return false;
            }
            MESSAGE_DIALOG.loading();
        }
    }]);

/**
 * 格式化列
 * @param value
 * @param row
 * @param index
 */
var preSaleOrderPoolFormatter = function (value, row, index) {
    var secondBtn = "";  //派单
    var thirdBtn = "";  //设置为部分受理
    var firstBtn = '<a ng-click="sendMessage(' + index + ',$event)">发送短信</a>'; //发送短信
    /**
     当前界面为工单池，并且pre_sale_order表的if_end字段为空，
     并且pre_sale_order_pool记录的状态是“未接收”、“已接收”或者“锁定”这三者之一，
     仅P单维度展示派单
         状态为已处理（pre_sale_order_pool.status_cd = 15000）的记录不处理
     */
    if (ffc.util.isEmpty(row.ifEnd)
        && ('10000' == row.statusCd || '11000' == row.statusCd || '13000' == row.statusCd)) {
        secondBtn = '<a ng-click="onAccept(' + index + ',$event)">派单</a>';
    }
    //有这个标识才展示 设置为部分受理按钮  状态为“已处理”并且是福州地区（此区域做成可配置）才展示
    if (!ffc.util.isEmpty(row.partAcceptFlag)) {
        thirdBtn = '<a ng-click="returnAccept(' + index + ',$event)">设置为部分受理</a>';
    }
    secondBtn = ffc.util.isEmpty(secondBtn) ? "" : secondBtn + " | ";
    thirdBtn = ffc.util.isEmpty(thirdBtn) ? "" : thirdBtn + " | ";
    return thirdBtn + secondBtn + firstBtn;
}