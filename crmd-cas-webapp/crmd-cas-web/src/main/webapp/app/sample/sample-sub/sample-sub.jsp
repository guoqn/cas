<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ffcs.crmd.cas.base.utils.JspUtil"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/app/public/include/header-inc.jsp"></jsp:include>
<title>sample sub</title>
</head>
<body>

	<div ng-app="sampleSubApp" ng-controller="sampleSubCtrl">
		Id:<input type="text" ng-model="vo.id"> 名称:<input type="text"
			ng-model="vo.name">
	</div>

	<jsp:include page="/app/public/include/footer-inc.jsp"></jsp:include>
	<script type="text/javascript"
		src="../sample-main-service.js?<%=JspUtil.version()%>"></script>
	<script type="text/javascript"
		src="./sample-sub-controller.js?<%=JspUtil.version()%>"></script>
</body>
</html>