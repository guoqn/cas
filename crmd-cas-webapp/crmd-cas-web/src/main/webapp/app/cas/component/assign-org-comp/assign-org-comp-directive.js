/**
 * add by luxb
 */
var orgCompApp = angular.module("orgCompApp", ["orgCompCtrlApp"]);

// 将模板放到缓存中
orgCompApp.run(function ($templateCache) {
    $templateCache.put("orgComp.html",
        '<div>'
        + '<div data-toggle="popover" data-placement="bottom" data-content="该组件不可用！">'
        + '<input id = "orgInput" ng-click="showOrg()" class="form-control btn-default2 comp-btn" ng-model="orgName" />'
        + '</div>' + '</div>')

});

orgCompApp.directive("orgComp", function () {
    return {
        scope: {
            orgName: '=', // 用于界面输入框的展示
            orgList: '=orgDataBind' // 保存团队的数据
        },
        restrict: "AE",
        templateUrl: "orgComp.html",
        replace: true,
        transclude: true,
        link: function (scope, element, attrs) {
            /*if (attrs.orgDataBind == undefined) {
             // 将按钮置灰,展示提示信息
             //$('#orgCompId').attr("disabled", "true");
             //提示信息展现
             $("[data-toggle='popover']").bind('mouseover', function () {
             $(this).popover("show");
             $(this).on("mouseleave", function () {
             $(this).popover('hide');
             });
             });
             $("[data-toggle='popover']").bind('mouseleave', function () {
             setTimeout(function () {
             if (!$(".popover:hover").length) {
             $(this).popover("hide")
             }
             }, 50);
             });
             }*/
            //表格是否可以复选
            if (attrs.checkbox != undefined && attrs.checkbox == "false") {
                var table = $('#orgTable');
                if (table != undefined) {
                    $('#orgTable').bootstrapTable('hideColumn', 'check');
                }
            }

            //弹出团队查询界面
            scope.showOrg = function () {
                $('#org-query').modal();
            };
            // 根据属性设置输入框的readonly属性
            if (attrs.readonly == "true") {
                $('#orgInput').attr("readonly", "readonly");
            } else {
                $('#orgInput').removeAttr("readonly");
            }
            // 监听选择班组的变化,并将值赋给scope.orgName，展示在界面上
            scope.$watch("orgList", function (newValue, oldValue) {
                var temp = "";
                if (newValue != undefined) {
                    for (var i = 0; i < newValue.length; i++) {
                        if (i == newValue.length - 1) {
                            temp = temp + newValue[i].orgName;
                            if (newValue[i].btnDis) {
                                $('#orgInput').attr("disabled",true);
                                $('#orgInput').attr("readonly", "readonly");
                            } else {
                                $('#orgInput').removeAttr("disabled");
                                $('#orgInput').removeAttr("readonly");
                            }
                        } else {
                            temp = temp + newValue[i].orgName + ",";
                        }
                    }
                }
                scope.orgName = temp;
            });

            $('#orgTable tbody').delegate('tr', 'click', function () {
                $(this).addClass("tr-onClick").siblings("tr").removeClass("tr-onClick");
            });
        },
        controller: "orgCompCtrl"
    }
});
