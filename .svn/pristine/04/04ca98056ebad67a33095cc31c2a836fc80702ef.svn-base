/**
 * sample
 */

// module
var sampleSubApp = angular.module("sampleSubApp", [ "sampleMainServiceApp" ]);

// controller
sampleSubApp.controller("sampleSubCtrl", [ "$scope", "sampleMainService", function($scope, sampleMainService) {
	// bind data
	sampleMainService.querySampleSubData({}, function(data) {
		$scope.vo = data;
	});
} ])
