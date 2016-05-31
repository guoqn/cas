/**
 * add by luxb
 */
(function (angular) {
    var executeOrgCompApp = angular.module("executeOrgCompApp", ["executeOrgCompCtrlApp"]);

// 将模板放到缓存中
    executeOrgCompApp.run(function ($templateCache) {
        $templateCache.put("executeOrgComp.html",
            '<div >'
            + '<div data-toggle="popover" data-placement="bottom" data-content="该组件不可用！">'
            + '<input id="executeOrgInput" ng-click="showExecuteOrg()" class="form-control btn-default2 comp-btn" ng-model="orgName" />'
            + '</div>'
            + '</div>')

    });

    executeOrgCompApp.directive("executeOrgComp", function () {
        return {
            scope: {
                orgName: '=', // 用于界面输入框的展示
                executeOrgList: '=executeOrgDataBind' // 保存团队的数据
            },
            restrict: "AE",
            templateUrl: "executeOrgComp.html",
            replace: true,
            transclude: true,
            link: function (scope, element, attrs) {
                //表格是否可以复选
                if (attrs.checkbox != undefined && attrs.checkbox == "false") {
                    var table = $('#executeOrgTable');
                    if (table != undefined) {
                        $('#executeOrgTable').bootstrapTable('hideColumn', 'check');
                    }
                }

                //弹出团队查询界面
                scope.showExecuteOrg = function () {
                    $('#execute-org-query').modal();
                };
                // 根据属性设置输入框的readonly属性
                if (attrs.readonly == "true") {
                    $('#executeOrgInput').attr("readonly", "readonly");
                } else {
                    $('#executeOrgInput').removeAttr("readonly");
                }
                // 监听选择班组的变化,并将值赋给scope.orgName，展示在界面上
                scope.$watch("executeOrgList", function (newValue, oldValue) {
                    var temp = "";
                    if (newValue != undefined) {
                        for (var i = 0; i < newValue.length; i++) {
                            if (i == newValue.length - 1) {
                                temp = temp + newValue[i].orgName;
                            } else {
                                temp = temp + newValue[i].orgName + ",";
                            }
                        }
                    }
                    scope.orgName = temp;
                });

                $('#executeOrgTable tbody').delegate('tr', 'click', function () {
                    $(this).addClass("tr-onClick").siblings("tr").removeClass("tr-onClick");
                });
            },
            controller: "executeOrgCompCtrl"
        }
    });
})(angular);