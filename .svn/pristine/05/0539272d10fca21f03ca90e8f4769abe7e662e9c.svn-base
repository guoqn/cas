<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="com.ffcs.crmd.cas.base.utils.JspUtil" %>
<!DOCTYPE html>
<html>
<head>
    <!-- 通用资源引入 -->
    <jsp:include page="/app/public/include/header-inc.jsp"></jsp:include>
    <title>控件测试</title>
</head>
<body ng-app="compApp" ng-controller="compCtrl">
<div class="container-fluid">
    <div class="well well-md well-color">
        <div class="form-group">
            <label for="orgId" class="col-sm-5 control-label"
                   style="text-align: center;">团队选择</label>
            <div class="col-sm-6">
                <div org-comp org-data-bind="orgList" checkbox="false" readonly="true"></div>
            </div>
        </div>
        <div class="form-group">
            <label for="staffId" class="col-sm-5 control-label"
                   style="text-align: center;">员工选择</label>
            <div class="col-sm-6">
                <div staff-comp staff-data-bind="staffList" checkbox="false" readonly="true"></div>
            </div>
        </div>
        <div class="form-group">
            <label for="sceneTypeId" class="col-sm-5 control-label"
                   style="text-align: center;">业务类型</label>
            <div class="col-sm-6">
                <div scene-type-comp scene-type-data-bind="sceneTypeList" checkbox="false" readonly="true"></div>
            </div>
        </div>
        <div class="form-group">
            <label for="regionId" class="col-sm-5 control-label"
                   style="text-align: center;">区域选择</label>
            <div class="col-sm-6">
                <div region-comp region-data-bind="regionList" checkbox="false" readonly="true"></div>
            </div>
        </div>
        <div class="form-group">
            <label for="regionId" class="col-sm-5 control-label"
                   style="text-align: center;">二次受理团队</label>
            <div class="col-sm-6">
                <div execute-org-comp  execute-org-data-bind="executeOrgList" checkbox="false" readonly="true"></div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-5 control-label"
                   style="text-align: center;">订单状态</label>
            <div class="col-sm-6">
                <div status-comp status-data-bind="statusList" checkbox="true" readonly="true"></div>
            </div>
        </div>
    </div>
</div>
<!--团队选择二级界面 -->
<jsp:include
        page="/app/cas/component/org-comp/org_comp.jsp"></jsp:include>

<!-- 业务类型二级界面 -->
<jsp:include
        page="/app/cas/component/scenetype-comp/scenetype_comp.jsp"></jsp:include>
<!-- 区域选择二级界面 -->
<jsp:include
        page="/app/cas/component/region-comp/region-comp.jsp"></jsp:include>
<jsp:include
        page="/app/cas/component/status-comp/status_comp.jsp"></jsp:include>
<!-- 通用资源引入 -->
<jsp:include page="/app/public/include/footer-inc.jsp"></jsp:include>

<!-- 班组选择组件 -->
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/org-comp/org-comp-controller.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/org-comp/org-comp-directive.js?<%=JspUtil.version()%>"></script>
<!-- 员工选择二级界面 -->
<jsp:include
        page="/app/cas/component/staff-comp/staff_comp.jsp"></jsp:include>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/staff-comp/staff-comp-controller.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/staff-comp/staff-comp-directive.js?<%=JspUtil.version()%>"></script>
<!-- 业务类型组件 -->
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/scenetype-comp/scenetype-comp-controller.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/scenetype-comp/scenetype-comp-directive.js?<%=JspUtil.version()%>"></script>
<!-- 区域选择组件 -->
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/region-comp/region-comp-controller.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/region-comp/region-comp-directive.js?<%=JspUtil.version()%>"></script>


<!-- 本身组件 -->
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/comp-service.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/comp-controller.js?<%=JspUtil.version()%>"></script>

<jsp:include
        page="/app/cas/component/execute-org-comp/execute-org-comp.jsp"></jsp:include>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/execute-org-comp/execute-org-comp-controller.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/execute-org-comp/execute-org-comp-directive.js?<%=JspUtil.version()%>"></script>

<!-- 状态列表 -->
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/status-comp/status-comp-controller.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/status-comp/status-comp-directive.js?<%=JspUtil.version()%>"></script>


</body>
</html>
