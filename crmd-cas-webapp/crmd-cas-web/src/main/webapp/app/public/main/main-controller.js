
var mainIndexApp = angular.module("mainIndexApp", ["mainServiceApp"]);
mainIndexApp.controller("mainIndexAppCtrl" ,
		function($scope,mainService) {
			$scope.code = 0;
			$scope.privileges = [
				{
					privilegeName : "预受理工单池",
					privilegeCode : $scope.code++,
					path : "/app/cas/cas-order/preSaleOrderPool/pre-sale-order-pool.jsp"
				},
				{
					privilegeName : "预受理工单接收",
					privilegeCode : $scope.code++,
					path : "/app/cas/cas-order/preSaleOrderRec/pre-sale-order-rec.jsp"
				},
				{
					privilegeName : "预受理缴费",
					privilegeCode : $scope.code++,
					path : "/app/cas/cas-order/preSaleOrder/pre-sale-order.jsp"
				},
				{
				privilegeName : "工单池流向配置",
				child : [{
					firstLetter : "G",
					child: [{
						privilegeName : "工单池流程",
						privilegeCode : $scope.code++,
						path : "/app/cas/cas-order/interaction/interaction-flow.jsp"}]
				},{
					firstLetter : "T",
					child : [{
						privilegeName : "团队关联受理类型",
						privilegeCode : $scope.code++,
						path : "/app/cas/cas-order/orgSceneTypeRel/org-scene-type-rel.jsp"}]
				}]
				},
				{
					privilegeName : "预受理订单维护",
					child : [{
						firstLetter : "D",
						child: [{
							privilegeName : "单个关联",
							privilegeCode : $scope.code++,
							path : "/app/cas/cas-order/preSaleOrderMainTanance/pre-sale-order-srel.jsp"}]
					},{
						firstLetter : "P",
						child : [{
							privilegeName : "批量关联",
							privilegeCode : $scope.code++,
							path : "/app/cas/cas-order/preSaleOrderMainTanance/pre-sale-order-brel.jsp"}]
					}]
				},
				{
					privilegeName : "控件测试页面",
					privilegeCode : $scope.code++,
					path : "/app/cas/component/comp_test.jsp"
				}];

			$scope.allPrivileges = [];


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