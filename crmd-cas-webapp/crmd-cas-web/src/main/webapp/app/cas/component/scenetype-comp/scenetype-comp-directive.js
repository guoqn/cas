/**
 * add by luxb
 */
var sceneTypeCompApp = angular.module("sceneTypeCompApp", ["sceneTypeCompCtrlApp" ]);

// 将模板放到缓存中
sceneTypeCompApp.run(function($templateCache) {
			$templateCache.put("sceneTypeComp.html",
				'<div >'
				+ '<div data-toggle="popover" data-placement="bottom" data-content="该组件不可用！">'
				+ '<input id = "sceneTypeInput" ng-click="showSceneType()"  class="form-control btn-default2 comp-btn" ng-model="sceneTypeName" />'
				+ '</div>'
				+ '</div>')

		});

sceneTypeCompApp.directive("sceneTypeComp", function() {
	return {
		scope : {
			sceneTypeName : '=', // 用于界面输入框的展示
			sceneTypeList : '=sceneTypeDataBind' // 保存业务类型数据
		},
		restrict : "AE",
		templateUrl : "sceneTypeComp.html",
		replace : true,
		transclude : true,
		link : function(scope, element, attrs) {
			if (attrs.sceneTypeDataBind == undefined) {
				// 将按钮置灰,展示提示信息
				//$('#sceneTypeCompId').attr("disabled", "true");
				//提示信息展现
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
			}


			/*$('#sceneTypeCompId').on("click", function() {
				$('#scene-type-query').modal();
			});*/
			//弹出业务类型查询界面
			scope.showSceneType = function () {
				$('#scene-type-query').modal();
			};

			//表格是否可以复选
			if (attrs.checkbox != undefined && attrs.checkbox == "false") {
				var table = $('#sceneTypeTable');
				if(table!=undefined){
					$('#sceneTypeTable').bootstrapTable('hideColumn', 'check');
				}
			}


			// 根据属性设置输入框的readonly属性
			if (attrs.readonly == "true") {
				$('#sceneTypeInput').attr("readonly", "readonly");
			} else {
				$('#sceneTypeInput').removeAttr("readonly");
			}
			// 监听选择班组的变化,并将值赋给scope.orgName，展示在界面上
			scope.$watch("sceneTypeList", function(newValue, oldValue) {
				var temp = "";
				if (newValue != undefined) {
					for (var i = 0; i < newValue.length; i++) {
						if (i == newValue.length - 1) {
							temp = temp + newValue[i].sceneTypeName;
						} else {
							temp = temp + newValue[i].sceneTypeName + ",";
						}
					}
				}
				scope.sceneTypeName = temp;
			});



			$('#sceneTypeTable tbody').delegate('tr', 'click', function () {
		        $(this).addClass("tr-onClick").siblings("tr").removeClass("tr-onClick");
		    });
		},
		controller : "sceneTypeCompCtrl"
	}
});