/**
 * 自定义iframe
 * @auther caiwl
 * @version 1.0
 */
(function (angular) {
    'use strict'

    var app = angular.module('saas.iframe', [])
        .config(function ($sceDelegateProvider) {
            //console.log(whiteUrls)
            //配置白名单
            $sceDelegateProvider.resourceUrlWhitelist([
                // Allow same origin resource loads.
                'self',
                // Allow loading from our assets domain.  Notice the difference between * and **.
                /*'http://www.baidu.com/!**',
                 'http://www.codeceo.com/!**',
                 'http://134.132.66.207:8097/!**'
                 */
            ])
        })
        .constant('defaultConfig', {
            //align: ''
            src: '',
            frameborder: 0,
            height: 'auto',
            width: '100%',
            //longdesc: ''
            marginheight: 0,
            marginwidth: 0,
            name: '',
            scrolling: 'auto' //yes, no
        })
        .filter('trustResourceUrlFilter', function ($sce) {
            return function (url) {
                return $sce.trustAsResourceUrl(url)
            }
        })
        .directive('saasIframe', function (defaultConfig) {
            return {
                restrict: 'A',
                scope: {
                    options: '=saasIframe'
                },
                link: function (scope, elm, attrs) {
                    scope.options = angular.extend({}, defaultConfig, scope.options)

                    if (scope.options.name === '')
                        elm.removeAttr('name')

                    //填充elm属性,options额外属性添加到iframe中去
                    angular.forEach(scope.options, function (value, key) {
                        if (!defaultConfig.hasOwnProperty(key)) {
                            elm.attr(key, value)
                        }
                    })

                    //监听
                    /*scope.$watch('options', function(newv, oldv){

                    })*/
                },
                template: function (elm, attrs) {
                    return '<iframe name="{{options.name}}" ' +
                        'ng-src="{{options.src | trustResourceUrlFilter}}" ' +
                        'height="{{options.height}}" ' +
                        'width="{{options.width}}" ' +
                        'scrolling="{{options.scrolling}}" ' +
                        'marginheight="{{options.marginheight}}" ' +
                        'marginwidth="{{options.marginwidth}}" ></iframe>'
                },
                //transclude: false,
                replace: true
            }
        })
})(angular)