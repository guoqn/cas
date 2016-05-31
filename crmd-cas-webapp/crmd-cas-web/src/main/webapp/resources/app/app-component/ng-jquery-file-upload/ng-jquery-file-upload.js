angular.module('ngJqueryFileUploadApp', []).directive('fileupload',
function() {
    return {
        restrict: 'A',
        scope: {
            done: '&',
            progress: '&',
            fail : '&',
            submit : '&'
        },
        link: function(scope, element, attrs) {
            var optionsObj = {
                dataType: 'json'
            };
            if (scope.done) {
                optionsObj.done = function(e, data) {
                    scope.$apply(function() {
                        scope.done({
                            e: e,
                            data: data
                        });
                    });
                };
            }
            if (scope.progress) {
                optionsObj.progress = function(e, data) {
                    scope.$apply(function() {
                        scope.progress({
                            e: e,
                            data: data
                        });
                    });
                };
            }
            if(scope.fail){
                optionsObj.fail = function(e, data) {
                    scope.$apply(function() {
                        scope.fail({
                            e: e,
                            data: data
                        });
                    });
                };
            }
            if(scope.submit){
                optionsObj.submit = function(e, data) {
                    scope.$apply(function() {
                        scope.submit({
                            e: e,
                            data: data
                        });
                    });
                };
            }
            element.fileupload(optionsObj);
        }
    };
});