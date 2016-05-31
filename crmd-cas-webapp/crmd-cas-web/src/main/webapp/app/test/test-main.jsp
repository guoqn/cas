<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="com.ffcs.crmd.cas.base.utils.JspUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include page="/app/public/include/header-inc.jsp"></jsp:include>
<script type="text/javascript">
	/* function showResource() {
		var injector = angular.injector([ "commonApp", "ng" ]);
		injector.invoke([ 'commonService', function(commonService) {
			commonService.call("test/showResource", {}, function(result) {
				document.getElementById("resTxt").value = result;
			});
		} ]);
	}

	function startTest() {
		var injector = angular.injector([ "commonApp", "ng" ]);
		injector.invoke([ 'commonService', function(commonService) {
			commonService.call("test/startTest", {}, function(result) {
				document.getElementById("testResultTxt").value = result;
			});
		} ]);
		
	} */
</script>
<title>集成测试管理</title>
</head>
<body ng-app="testCtrlApp" ng-controller="testCtrl">
	<h4>集成测试</h4>
	<div id="resourceDiv">
		<input type="button" value="显示资源加载情况" ng-click="showResource();" /> </br> 
		<input type="input" style="width: 800px; height: 200px;" ng-model="resTxt" />
	</div>
	<div id="testResultDiv">
		<input type="button" value="开始测试" ng-click="startTest();" /> </br> <input
			type="input" style="width: 800px; height: 200px;" ng-model="testResultTxt" />
	</div>
	<!-- 通用资源引入 -->
<jsp:include page="/app/public/include/footer-inc.jsp"></jsp:include>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/test/test-service.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/test/test-controller.js?<%=JspUtil.version()%>"></script>
</body>

</html>