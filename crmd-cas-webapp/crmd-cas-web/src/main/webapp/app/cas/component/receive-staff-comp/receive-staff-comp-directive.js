/**
 * add by luxb
 */
var receiveStaffCompApp = angular.module("receiveStaffCompApp", ["receiveStaffCompCtrlApp"]);

// 将模板放到缓存中
receiveStaffCompApp.run(function ($templateCache) {
    $templateCache.put("receiveStaffComp.html",
        '<div>'
        + '<div data-toggle="popover" data-placement="bottom" data-content="该组件不可用！">'
        + '<input id = "receiveStaffInput"' +
        ' ng-click="showReceiveStaff()" class="form-control btn-default2 comp-btn" ng-model="receiveStaffName" />'
        + '</div>' + '</div>')
});

receiveStaffCompApp.directive("receiveStaffComp", function () {
    return {
        scope: {
            receiveStaffName: '=', // 用于界面输入框的展示
            receiveStaffList: '=receiveStaffDataBind' // 员工数据
        },
        restrict: "AE",
        templateUrl: "receiveStaffComp.html",
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
                var table = $('#receiveStaffTable');
                if (table != undefined) {
                    $('#receiveStaffTable').bootstrapTable('hideColumn', 'check');
                }
            }


            //弹出员工选择界面
            scope.showReceiveStaff = function () {
                $('#receive-staff-query').modal();
            };

            // 监听选择班组的变化,并将值赋给scope.mktStaffName，展示在界面上
            scope.$watch("receiveStaffList", function (newValue, oldValue) {
                var temp = "";
                if (newValue != undefined) {
                    for (var i = 0; i < newValue.length; i++) {
                        if (i == newValue.length - 1) {
                            temp = temp + newValue[i].staffName;
                        } else {
                            temp = temp + newValue[i].staffName + ",";
                        }
                    }
                }
                scope.receiveStaffName = temp;
            });

            $('#receiveStaffTable tbody').delegate('tr', 'click', function () {
                $(this).addClass("tr-onClick").siblings("tr").removeClass("tr-onClick");
            });
        },
        controller: "receiveStaffCompCtrl"
    }
});