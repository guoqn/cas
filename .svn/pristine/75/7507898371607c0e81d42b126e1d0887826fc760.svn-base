/**
 * 
 */
var testCtrlApp = angular.module("testCtrlApp", [ "commonApp", "testServiceApp" ]);

testCtrlApp.controller('testCtrl', [
		'$scope',
		'commonService',
		'testService',
		'$compile',
		function($scope, commonService, testService, $compile) {
			// 调用服务查询可用仓库
			$scope.showResource = function() {
				testService.showResource({},
						function(result) {
							$scope.resTxt=result.object;
						});
			};
			
			$scope.startTest = function() {
				testService.startTest({},
						function(result) {
							$scope.testResultTxt=result.object;
						});
			};
		} ]);