<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ffcs.crmd.cas.base.utils.JspUtil"%>
<!DOCTYPE html>
<html ng-app="nsPopoverExample">
<head>
<!-- 通用资源引入 -->
<jsp:include page="/app/public/include/header-inc.jsp"></jsp:include>
<link rel="stylesheet"
	href="<%=JspUtil.path(request)%>/resources/lib/angularJS/plugins/nsPopover/nsPopover.css?<%=JspUtil.version()%>">

<style type="text/css">

</style>

<title>nsPopover</title>



<script type="text/ng-template" id="table">
    <div class="triangle"></div>
    <div class="ns-popover-tooltip" ng-controller="tableCtrl">
    <ul class="nav nav-tabs">
        <li role="presentation" ng-repeat="wk in workspaces" ng-class="{active: currentWorkspace==wk}" ng-click="changeCurrentWorkspace(wk)"><a href="#">{{wk.name}}</a></li>
    </ul>

    <!-- Workspaces containers -->
    <div class="workspaceContainer" ng-repeat="wk in workspaces" ng-show="currentWorkspace==wk">
        <table bs-table-control="wk.bsTableControl"></table>
    </div>
	</div>
</script>

</head>
<body ng-controller="MainCtrl">

				<button ns-popover ns-popover-template="table"
				ns-popover-trigger="click" 
				ns-popover-theme="ns-popover-list-theme"
				ns-popover-timeout="1000" ns-popover-hide-on-inside-click="false"
				ns-popover-hide-on-outside-click="true"
				ns-popover-hide-on-button-click="true">Click popover</button>

</body>

<!-- 通用资源引入 -->
<jsp:include page="/app/public/include/footer-inc.jsp"></jsp:include>
<script type="text/javascript"
	src="<%=JspUtil.path(request)%>/resources/lib/angularJS/plugins/nsPopover/nsPopover.js?<%=JspUtil.version()%>"></script>

<script type="text/javascript"
		src="../sample-main-service.js?<%=JspUtil.version()%>"></script>

<script type="text/javascript"
	src="<%=JspUtil.path(request)%>/app/sample/ns-popover/ns-popover-controller.js?<%=JspUtil.version()%>"></script>


</html>