<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ffcs.crmd.cas.base.utils.JspUtil"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/app/public/include/header-inc.jsp"></jsp:include>
<title>sample 查询</title>
</head>
<body>
	<div class="panel-body">
		<form class="navbar-form navbar-left" role="search"
			ng-app="sampleMainApp" ng-controller="sampleMainCtrl">
			<div class="form-group">
				<input type="text" class="form-control" ng-model="name"
					placeholder="Search">
			</div>
			<button type="button" ng-click="querySample()"
				class="btn btn-default">查询</button>
		</form>
		<table id="sampleTable" data-toggle="table"
			data-side-pagination="server" data-click-to-select="true"
			data-row-style="rowStyle" data-pagination="true" data-height="350"
			data-page-size="10" data-query-params-type=""
			data-page-list="[5, 10, 20]">
			<thead>
				<tr>
					<th data-field="state" data-checkbox="true"></th>
					<th data-field="id" data-align="center">ID</th>
					<th data-field="name" data-align="center" data-sortable="true">受邀人名称</th>
					<th data-field="phone" data-align="center">受邀人手机</th>
					<th data-field="update_date" data-align="center">邀请时间</th>
					<th data-field="status" data-align="center">邀请状态</th>
					<th data-field="action" data-width="200"
						data-formatter="sample.operateFormatter">操作</th>
				</tr>
			</thead>
		</table>
	</div>
	<jsp:include page="/app/public/include/footer-inc.jsp"></jsp:include>
	<script type="text/javascript"
		src="./sample-main-service.js?<%=JspUtil.version()%>"></script>
	<script type="text/javascript"
		src="./sample-main-controller.js?<%=JspUtil.version()%>"></script>
</body>
</html>