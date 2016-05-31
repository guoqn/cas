/**
 * sample service app
 */

// module
var sampleMainServiceApp = angular.module("sampleMainServiceApp", [ "commonApp" ]);
// service
sampleMainServiceApp.service("sampleMainService", [ "commonService", function(commonService) {
	// sample service
	this.querySampleTableData = function(params, sback, eback) {
		commonService.call("app/sample/data/sample-data.json", params, sback, eback);
	}
	//sample sub service
	this.querySampleSubData = function(params, sback, eback) {
		commonService.call("app/sample/data/sub-data.json", params, sback, eback);
	}
} ]);
