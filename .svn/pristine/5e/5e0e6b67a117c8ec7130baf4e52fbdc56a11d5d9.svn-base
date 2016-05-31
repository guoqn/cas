/**
 * 
 */
var compApp = angular.module("compApp", [ "commonApp","orgCompApp"
	,"staffCompApp","executeOrgCompApp","regionCompApp","ngJsTree","sceneTypeCompApp","statusCompApp"]);

compApp.controller('compCtrl', [
		'$scope',
		'commonService',
		'compService',
		'$compile',
		function($scope, commonService, compService, $compile) {
			$scope.orgList = [ {
				orgName : "请选择...",
				orgId : 0
			} ];
			$scope.staffList = [ {
				staffName : "请选择...",
				staffId : 0
			} ];
			$scope.sceneTypeList = [ {
				sceneTypeName : "请选择...",
				sceneTypeId : 0
			} ];
			$scope.regionList = [ {
				regionName : "请选择...",
				regionId : 0
			} ];
			//监听团队变化，限制同页面下选择员工的时候，默认查询当前选择团队下的员工
			$scope.$watch("orgList[0].orgId", function(newValue, oldValue) {
				if (newValue != undefined) {
					$scope.orgList[0].orgId = newValue;
				}
			});
			$scope.$watch("regionList[0].regionId", function(newValue, oldValue) {
				if (newValue != undefined) {
					$scope.regionList[0].regionId = newValue;
				}
			});
			$scope.$watch("executeOrgList[0].orgId", function(newValue, oldValue) {
				if (newValue != undefined) {
					$scope.executeOrgList[0].orgId = newValue;
				}
			});
		} ]);