
var mainIndexApp = angular.module("mainIndexApp", ["mainServiceApp"]);
mainIndexApp.controller("mainIndexAppCtrl" ,
		function($scope,mainService) {
			// 页面菜单初始化
			 mainService.qryMenuData(
					 {},function(result){
						 $scope.privileges = result.dataList;
					 },function(errResult){
					 }
			 );
			 
			// 页面菜单初始化-获取全部菜单
			 mainService.qryAllMenuData(
					 {},function(result){
						 $scope.allPrivileges = result.dataList;
					 },function(errResult){
					 }
			 );
			 
			 
			 $scope.showQuery = false;
			 $scope.queryBlur = function() {
				 if($("#menuName").val().length <= 0){
					 $scope.showQuery = false;
				 }
			 };
			 
			 $scope.queryFocus = function() {
				 if($("#menuName").val().length > 0){
					 $scope.showQuery = true;
				 }else{
					 $scope.showQuery = false;
				 }
				 
			 };
		}
);