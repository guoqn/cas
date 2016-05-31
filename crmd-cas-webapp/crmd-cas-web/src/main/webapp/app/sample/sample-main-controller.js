/**
 * sample controller app
 * 
 * @author LAIYONGMIN
 */
registNS("sample");
// module
var sampleMainApp = angular.module("sampleMainApp", [ "sampleMainServiceApp" ]);
// controller
sampleMainApp.controller("sampleMainCtrl", [ "$scope", "sampleMainService", "commonService", function($scope, sampleMainService, commonService) {
	// 表单初始化
	commonService.initFrom(ffc.util.getPageMetas($scope));
	// 表格初始化
	$('#sampleTable').bootstrapTable({
		// 条件
		queryParams : function(params) {
			//查询条件
			var selfParams = {
				name : $scope.name
			}
			return $.extend({}, params, selfParams);
		},
		// 服务请求
		ajax : function(render) {
			// 服务请求
			sampleMainService.querySampleTableData(render.data, function(result) {
				ffc.util.loadTableData(render,result);
			});
		}
	});
	// 查询按钮事件
	$scope.querySample = function() {
		// 方法调用
		$('#sampleTable').bootstrapTable("selectPage", 1);
	};

} ]);

// table按钮格式化
sample.operateFormatter = function(value, row, index) {
	var btn = [ '<button class="btn btn-primary">新增</button>', '<button class="btn btn-info">修改</button>',
			'<button class="btn btn-danger">修改</button>' ].join(' &nbsp;');
	return btn;
}
