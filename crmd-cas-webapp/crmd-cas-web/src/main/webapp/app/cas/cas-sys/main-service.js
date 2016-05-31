/**
 * 创建服务
 */

var mainServiceApp = angular.module("mainServiceApp", [ "commonApp" ]);

// 创建档案服务
mainServiceApp.service("mainService", [ "commonService", function(commonService) {
    // 档案查询服务
    this.qryMenuData = function(params, sback, eback) {
    	commonService.call("mkt/sys/mktPrivilegeQuery/qryMenu", params, sback, eback);
    }
    // 获取前部菜单
    this.qryAllMenuData = function(params, sback, eback) {
    	commonService.call("mkt/sys/mktPrivilegeQuery/qryAllMenu", params, sback, eback);
    }
} ]);

//var mainServiceApp = angular.module("mainServiceApp",[]);
//
//// 创建档案服务
//mainServiceApp.service("mainService",[function() {
//    // 档案查询服务
//    this.qryMenuData = function(params, sback, eback) {
//    	alert(231312);
//    	return "测试完成";
//    };
//
//}]);