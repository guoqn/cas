/**
 * 公共组件查询
 */

// 创建公共组件模块
var testServiceApp = angular.module("testServiceApp", [ "commonApp" ]);

// 创建公共组件服务
testServiceApp.service("testService", [ "commonService", function(commonService) {
	//。
	this.showResource = function(params, sback, eback) {
		commonService.call("test/showResource", params, sback, eback);
	}
	//团队树查询。
	this.startTest = function(params, sback, eback) {
		commonService.call("test/startTest", params, sback, eback);
	}
} ]);