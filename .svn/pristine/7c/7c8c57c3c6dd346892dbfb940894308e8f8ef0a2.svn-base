/**
 * add by luxb
 */
var staffCompApp = angular.module("staffCompApp", ["staffCompCtrlApp"]);

// 将模板放到缓存中
staffCompApp.run(function ($templateCache) {
    $templateCache.put("staffComp.html",
        '<div ng-click="showStaff()">'
        + '<div data-toggle="popover" data-placement="bottom" data-content="该组件不可用！">'
        + '<input id = "staffInput" class="form-control btn-default2 comp-btn" ng-model="staffName" />'
        + '</div>' + '</div>');
});

staffCompApp.directive("staffComp", function () {
    return {
        scope: {
            staffName: '=', // 用于界面输入框的展示
            staffList: '=staffDataBind' // 员工数据
        },
        restrict: "AE",
        templateUrl: "staffComp.html",
        replace: true,
        transclude: true,
        link: function (scope, element, attrs) {
            /*if (attrs.staffDataBind == undefined) {
             // 将按钮置灰,展示提示信息
             $('#staffCompId').attr("disabled", "true");
             $("[data-toggle='popover']").bind('mouseover', function() {
             $(this).popover("show");
             $(this).on("mouseleave", function() {
             $(this).popover('hide');
             });
             });
             $("[data-toggle='popover']").bind('mouseleave', function() {
             setTimeout(function() {
             if (!$(".popover:hover").length) {
             $(this).popover("hide")
             }
             }, 50);
             });
             }*/
            //表格是否可以复选
            if (attrs.checkbox != undefined && attrs.checkbox == "false") {
                var table = $('#staffTable');
                if (table != undefined) {
                    $('#staffTable').bootstrapTable('hideColumn', 'check');
                }
            }


            // 根据属性设置输入框的readonly属性
            if (attrs.readonly == "true") {
                $('#staffInput').attr("readonly", "readonly");
            } else {
                $('#staffInput').removeAttr("readonly");
            }

            //弹出员工选择界面
            scope.showStaff = function () {
                $('#staff-query').modal();
            };

            // 监听选择班组的变化,并将值赋给scope.mktStaffName，展示在界面上
            scope.$watch("staffList", function (newValue, oldValue) {
                var temp = "";
                if (newValue != undefined) {
                    for (var i = 0; i < newValue.length; i++) {
                        if (i == newValue.length - 1) {
                            temp = temp + newValue[i].staffName;
                            if (newValue[i].btnDis) {
                                $('#staffInput').attr("disabled",true);
                                $('#staffInput').attr("readonly", "readonly");
                            } else {
                                $('#staffInput').removeAttr("disabled");
                                $('#staffInput').removeAttr("readonly");
                            }
                        } else {
                            temp = temp + newValue[i].staffName + ",";
                        }
                    }
                }
                scope.staffName = temp;
            });

            $('#staffTable tbody').delegate('tr', 'click', function () {
                $(this).addClass("tr-onClick").siblings("tr").removeClass("tr-onClick");
            });
        },
        controller: "staffCompCtrl"
    }

});