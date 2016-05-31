angular.module('nsPopoverExample', [ 'nsPopover', "sampleMainServiceApp","bsTable" ])

.controller('MainCtrl', function($scope) {
    $scope.items = [ {
	name : "Action"
    }, {
	name : "Another action"
    }, {
	name : "Something else here"
    } ];

    $scope.shouldDisplayPopover = function() {
	return $scope.displayPopover;
    }
    $scope.test = function() {
	alert(13);
    }
}).controller('tableCtrl', function($scope, $http) {
    $scope.workspaces = [];
    $scope.workspaces.push({
	name : 'Workspace 1'
    });
    $scope.workspaces.push({
	name : 'Workspace 2'
    });
    $scope.workspaces.push({
	name : 'Workspace 3'
    });

    function makeRandomRows(colData) {
	var rows = [];
	for (var i = 0; i < 500; i++) {
	    rows.push($.extend({
		index : i,
		id : 'row ' + i,
		name : 'GOOG' + i,
		flagImage : Math.random() < 0.4 ? '../img/blueFlag16.png' : Math.random() < 0.75 ? '../img/yellowFlag16.png' : '../img/greenFlag16.png'
	    }, colData));
	}
	return rows;
    }
    $scope.workspaces.forEach(function(wk, index) {
	var colData = {
	    workspace : wk.name
	};
	wk.rows = makeRandomRows(colData);

	wk.bsTableControl = {
	    options : {
		data : wk.rows,
		rowStyle : function(row, index) {
		    return {
			classes : 'none'
		    };
		},
		cache : false,
		height : 400,
		striped : true,
		pagination : true,
		pageSize : 10,
		pageList : [ 5, 10, 25, 50, 100, 200 ],
		search : true,
		showColumns : true,
		showRefresh : false,
		minimumCountColumns : 2,
		clickToSelect : false,
		showToggle : true,
		maintainSelected : true,
		columns : [ {
		    field : 'state',
		    checkbox : true
		}, {
		    field : 'index',
		    title : '#',
		    align : 'right',
		    valign : 'bottom',
		    sortable : true
		}, {
		    field : 'id',
		    title : 'Item ID',
		    align : 'center',
		    valign : 'bottom',
		    sortable : true
		}, {
		    field : 'name',
		    title : 'Item Name',
		    align : 'center',
		    valign : 'middle',
		    sortable : true
		}, {
		    field : 'workspace',
		    title : 'Workspace',
		    align : 'left',
		    valign : 'top',
		    sortable : true
		}, {
		    field : 'flag',
		    title : 'Flag',
		    align : 'center',
		    valign : 'middle',
		    clickToSelect : false,
		    formatter : flagFormatter,
		// events: flagEvents
		} ]
	    }
	};
	function flagFormatter(value, row, index) {
	    return '<img src="' + row.flagImage + '"/>'
	}

    });

    $scope.changeCurrentWorkspace = function(wk) {
	$scope.currentWorkspace = wk;
    };

    // Select the workspace in document ready event
    $(document).ready(function() {
	$scope.changeCurrentWorkspace($scope.workspaces[0]);
	$scope.$apply();
    });

}).controller('testCtrl', function($scope, sampleMainService) {
    $scope.test = "ffff";
    $(function() {
	var dd = $('#sampleTable');
	var ddd = $('#sampleTableaa');
	// 表格初始化
	$('#sampleTable').bootstrapTable({
	    // 条件
	    queryParams : function(params) {
		// 查询条件
		var selfParams = {
		    name : $scope.name
		}
		return $.extend({}, params, selfParams);
	    },
	    // 服务请求
	    ajax : function(render) {
		// 服务请求
		sampleMainService.querySampleTableData(render.data, function(result) {
		    ffc.util.loadTableData(render, result);
		});
	    }
	});
	// 查询按钮事件
	$scope.querySample = function() {
	    // 方法调用
	    $('#sampleTable').bootstrapTable("selectPage", 1);
	};

    })
}).directive('viewportWidth', function() {
    return {
	link : function(scope, elm, attrs) {
	    function getViewport() {
		var e = window, a = 'inner';
		if (!('innerWidth' in window)) {
		    a = 'client';
		    e = document.documentElement || document.body;
		}
		return {
		    width : e[a + 'Width'],
		    height : e[a + 'Height']
		};
	    }

	    elm.css('maxWidth', getViewport().width + 'px');
	}
    };
});