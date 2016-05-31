/**
 * 创建服务
 */

var mainServiceApp = angular.module("mainServiceApp", [ "commonApp" ]);

// 创建档案服务
mainServiceApp.service("mainService", [ "commonService", function(commonService) {

} ]);