<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="com.ffcs.crmd.cas.base.utils.JspUtil" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/app/public/include/header-inc.jsp"></jsp:include>
    <title>本地缓存管理</title>
</head>
<body ng-app="localCacheApp" ng-controller="localCacheAppCtrl">
<div class="container-fluid">
    <div class="row-fluid">
        <div class="col-md-3" >
            <form class="form-inline">
                <div class="form-group">
                    <input type="text" ng-model="searchKey" class="form-control" placeholder="缓存key名称" />
                    <button type="submit" class="btn btn-blue" ng-click="queryCache()">查询</button>
                    <button type="submit" class="btn btn-primary" ng-click="cleanup()">清除全部</button>
                </div>
            </form>
            <table id="cacheTable" class="table  table-hover fjNet-table"  data-toggle="table"
                   data-side-pagination="server" data-click-to-select="true">
                <thead>
                <tr>
                    <th data-field="key" data-align="center">key名称</th>
                    <th data-align="center" data-formatter="operationFormatter">操作</th>
                </tr>
                </thead>
            </table>
        </div>
        <div class="col-md-9">
            <label>缓存值：</label>
            <div class="form-group">
                <textarea rows="7" cols="150" ng-model="cacheValue"></textarea>
            </div>
        </div>
    </div>


</div>

<!-- 通用资源引入 -->
<jsp:include page="/app/public/include/footer-inc.jsp"></jsp:include>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/cas-order/cas-order-service.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/cas-sys/local-cache/local-cache-controller.js?<%=JspUtil.version()%>"></script>
</body>
</html>
