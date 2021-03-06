/**
 * Created by qn_guo on 2016/1/13.
 */

var orgSceneTypeRelApp = angular.module("orgSceneTypeRelApp", ["sceneTypeCompApp", "casOrderServiceApp", "orgCompApp", "bsTable"]);
orgSceneTypeRelApp.controller("orgSceneTypeRelCtrl", ["$scope", "casOrderService", "commonService", "$compile", function ($scope, casOrderService, commonService, $compile) {
    $scope.orgSceneTypeRelTableSaveInfo = {}
    $scope.sceneTypeList = [{
        sceneTypeName: "请选择..."
    }];
    $scope.orgList = [{
        orgName: "请选择..."
    }];
    $scope.isShow = true;
    var sceneType_four = [];  //4G业务
    var sceneType_school = [];  //校园业务
    var sceneType_band = [];  //宽带业务
    var sceneType_other = [];  //其他
    //监听团队变化
    $scope.$watch("orgList[0].orgId", function (newValue, oldValue) {
        if (newValue != undefined) {
            $scope.orgList[0].orgId = newValue;
        }
    });
    //业务类型
    $scope.$watch("sceneTypeList[0].sceneType", function (newValue, oldValue) {
        if (newValue != undefined) {
            $scope.sceneTypeList[0].sceneType = newValue;
        }
    });
    // 团队关联类型初始化
    $('#orgSceneTypeRelTable').bootstrapTable({
        // 加载成功后重新编译，试点formatter后的dom元素支持angularjs
        onResetView: function () {
            $compile($('#orgSceneTypeRelTable'))($scope);
        },
        // 条件
        queryParams: function (params) {
            //查询条件
            var selfParams = {
                orgName: $scope.orgName,
                sceneType: ffc.util.isEmpty($scope.sceneTypeList) ? null : $scope.sceneTypeList[0].sceneType
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
                    casOrderService.qryOrgSceneTypeRel(render.data, function (result) {
                        if (!result.result) {
                            if (!ffc.util.isEmpty(result.msgTitle)) {
                                MESSAGE_DIALOG.error(result.msgTitle + "");
                            }
                            ffc.util.loadTableData(render);
                            return false;
                        }
                        ffc.util.setPageResult($scope, 'orgSceneTypeRelTableErrorAlert', render, result);
                    });
                }
            } catch (e) {
                ffc.util.loadTableData(render);
            }
        }
    });

    //查询
    $scope.qryOrgSceneTypeRel = function () {
        $('#orgSceneTypeRelTable').bootstrapTable("selectPage", 1);
    }
    //清空
    $scope.reset = function () {
        $scope.orgName = "";
        $scope.sceneTypeList = [{
            sceneTypeName: "请选择...",
            sceneType: ""
        }];
    }
    //新增
    $scope.addOrgSceneTypeRel = function () {
        $scope.orgSceneTypeRelTableSaveInfo = {}
        $scope.OrgSceneTypeName = "新增团队关联受理类型";
        $scope.isShow = true;
        $("#checkList input[type='checkbox']:checked").click();
        $('#org_scene_type_rel_modify').modal('show');
    }
    //修改
    $scope.modifyOrgSceneTypeRel = function (rowIndex) {
        $scope.OrgSceneTypeName = "编辑团队关联受理类型";
        $scope.orgSceneTypeRelTableSaveInfo = {};
        $("#checkList input[type='checkbox']:checked").click();
        var allTable = $('#orgSceneTypeRelTable')
            .bootstrapTable("getData");
        var selectRow = allTable[rowIndex];
        $scope.orgSceneTypeRelTableSaveInfo = selectRow;
        $scope.isShow = false;   //修改不做团队的变更
        $scope.modifyName = selectRow.orgName;
        intersection(selectRow.orgSceneTypeRelDtos);
        $('#org_scene_type_rel_modify').modal('show');
    }


    //删除
    $scope.delOrgSceneTypeRel = function (rowIndex) {
        var allTable = $('#orgSceneTypeRelTable')
            .bootstrapTable("getData");
        var deleteInfo = allTable[rowIndex];
        MESSAGE_DIALOG.confirm("确认删除？", function () {
            casOrderService.delOrgSceneTypeRel(deleteInfo,
                function (result) {
                    if (result.result != undefined
                        && result.result == true) {
                        MESSAGE_DIALOG.alert("删除成功！");
                        $scope.qryOrgSceneTypeRel();
                    } else {
                        MESSAGE_DIALOG.alert(result.msgTitle + ".删除失败！");
                    }
                }, function (msg) {
                    MESSAGE_DIALOG.alert("删除失败！" + msg);
                });
        });
    }
    //保存
    $scope.saveOrgSceneTypeRel = function () {

        if (undefined == $scope.orgSceneTypeRelTableSaveInfo.oldOrgId) {
            $scope.orgSceneTypeRelTableSaveInfo.orgId =
                ffc.util.isEmpty($scope.orgList) ? null : $scope.orgList[0].orgId;
        }
        if (null == $scope.orgSceneTypeRelTableSaveInfo.orgId) {
            MESSAGE_DIALOG.warning("受理团队不能为空!");
            return;
        }

        $scope.orgSceneTypeRelTableSaveInfo.sceneTypes = getSceneTypes();
        if (undefined == $scope.orgSceneTypeRelTableSaveInfo.sceneTypes ||
            $scope.orgSceneTypeRelTableSaveInfo.sceneTypes.length == 0) {
            MESSAGE_DIALOG.warning("受理类型不能为空!");
            return false;
        }
        MESSAGE_DIALOG.loading();
        casOrderService.saveOrgSceneTypeRel($scope.orgSceneTypeRelTableSaveInfo, function (result) {
            if (result.result != undefined && result.result == true) {
                MESSAGE_DIALOG.alert("保存成功！");
                $('#org_scene_type_rel_modify').modal('hide');
                $scope.qryOrgSceneTypeRel();
            } else {
                MESSAGE_DIALOG.alert("保存失败!" + result.msgTitle);
                return false;
            }
        }, function (msg) {
            MESSAGE_DIALOG.error("保存失败！" + msg);
        });
    }

    //传递给后端sceneTypes 用逗号隔开
    var getSceneTypes = function () {
        var strSceneTypes = "";
        //4G业务
        $.each($scope.sceneType_fours, function (index, item) {
            if (item.checked) strSceneTypes += item.attrValue + ",";
        });
        //校园营销
        $.each($scope.sceneType_schools, function (index, item) {
            if (item.checked)  strSceneTypes += item.attrValue + ",";
        });
        //宽带业务
        $.each($scope.sceneType_bands, function (index, item) {
            if (item.checked)  strSceneTypes += item.attrValue + ",";
        });
        //其他
        $.each($scope.sceneType_others, function (index, item) {
            if (item.checked)  strSceneTypes += item.attrValue + ",";
        });
        return strSceneTypes;
    }
    //比较两个数组是否选中
    var intersection = function (selectArray) {
        for (var i in selectArray) {
            for (var j in $scope.sceneType_fours) {  //4G业务
                if (selectArray[i].sceneType == $scope.sceneType_fours[j].attrValue) {
                    $scope.sceneType_fours[j].checked = true;
                    continue;
                }
            }
            for (var j in $scope.sceneType_schools) {  //校园营销
                if (selectArray[i].sceneType == $scope.sceneType_schools[j].attrValue) {
                    $scope.sceneType_schools[j].checked = true;
                    continue;
                }
            }
            for (var j in $scope.sceneType_bands) {  //宽带业务
                if (selectArray[i].sceneType == $scope.sceneType_bands[j].attrValue) {
                    $scope.sceneType_bands[j].checked = true;
                    continue;
                }
            }
            for (var j in $scope.sceneType_others) {  //其他
                if (selectArray[i].sceneType == $scope.sceneType_others[j].attrValue) {
                    $scope.sceneType_others[j].checked = true;
                    continue;
                }
            }
        }
    }
    //加载checkList
    $scope.formatterCheckList = function (type, list) {
        if (!ffc.util.isEmpty(list)) {
            $.each(list, function (index, item) {
                if ("" != item.attrValueName && undefined != item.attrValueName) {
                    if (item.attrValueName.indexOf("4G业务") != -1) {
                        sceneType_four.push(item);
                    } else if (item.attrValueName.indexOf("校园营销") != -1) {
                        sceneType_school.push(item);
                    } else if (item.attrValueName.indexOf("宽带业务") != -1) {
                        sceneType_band.push(item);
                    } else {
                        sceneType_other.push(item);
                    }
                }
            });
        }
        $scope.sceneType_fours = sceneType_four;
        $scope.sceneType_schools = sceneType_school;
        $scope.sceneType_bands = sceneType_band;
        $scope.sceneType_others = sceneType_other;
    }

    // 页面下拉框数据
    $scope.initAllListBox = function () {
        casOrderService.qryCheckBoxForOrgSceneTypeRel("", function (result) {
            //业务类型 checkBox
            if (!ffc.util.isEmpty(result)
                && !ffc.util.isEmpty(result.object)
                && !ffc.util.isEmpty(result.object.sceneTypeCheckList)) {
                $scope.scenTypeChecks = result.object.sceneTypeCheckList;
                $scope.formatterCheckList("add", result.object.sceneTypeCheckList);
            }
        }, function (msg) {
            MESSAGE_DIALOG.error(msg);
        });
    };
// 初始化
    commonService.initFrom(ffc.util.getPageMetas($scope), function () {
        if (ffc.util.isEmpty($scope.scenTypeChecks)) {
            $scope.initAllListBox();
        }
    });
}]);

//格式化列
var operationOrgFormatter = function (value, row, index) {
    var modifyBtn = '<a ng-click="modifyOrgSceneTypeRel(' + index + ')">编辑</a>';
    var delBtn = '<a ng-click="delOrgSceneTypeRel(' + index + ')">删除</a>';
    return modifyBtn + " | " + delBtn;
}

//选中颜色
$(function () {
    //全选
    $('#selectAll').click(function () {
        if ($(this).prop('checked')) {
            $("#checkList input[type='checkbox']:checked").click();
            $("#checkList input[type='checkbox']").click();
        } else {
            $("#checkList input[type='checkbox']:checked").click();
        }
    });
    $('#orgSceneTypeRelTable tbody').delegate('tr', 'click', function () {
        $(this).addClass("tr-onClick").siblings("tr").removeClass("tr-onClick");
    });
});