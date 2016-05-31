<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="com.ffcs.crmd.cas.base.utils.JspUtil" %>
<%@ page import="com.ffcs.crmd.cas.base.context.CasSessionContext" %>
<script type="text/javascript">
    //全局变量
    path = "<%=JspUtil.path(request)%>";//path;
    contextPath = "<%=JspUtil.contextPath(request)%>";//contextPath;
</script>
<!--BASE JS FILES -->
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/jquery/jquery.min-1.11.1.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/bootstrap/js/bootstrap.min-3.2.0.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/angularJS/angular-ie8-1.4.7.min.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/angularJS/angular-sanitize.min.js?<%=JspUtil.version()%>"></script>
<!-- BOOTSTRAP PLUGINS JS FILES -->
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/bootstrap/plugins/buttons/js/buttons.min.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/bootstrap/plugins/bootstrap-table/js/bootstrap-table.min.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/bootstrap/plugins/bootstrap-table/js/bootstrap-table-angular.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/bootstrap/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/bootstrap/plugins/bootstrap-select/js/bootstrap-select.min.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/bootstrap/plugins/bootstrap-dialog/js/bootstrap-dialog.min.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/bootstrap/plugins/bootstrap-treeview/js/bootstrap-treeview.min.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/bootstrap/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/bootstrap/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.zh-CN.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/bootstrap/plugins/bootstrap-validator/js/bootstrap-validator.min.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/angularJS/plugins/ui-select/select.js?<%=JspUtil.version()%>"></script>

<!-- 自定义通用 JS common.js -->
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/public/common/js/common.js?<%=JspUtil.version()%>"></script>

<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/public/common/js/constants.js?<%=JspUtil.version()%>"></script>

<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/app/app-common/js/app-common.js?<%=JspUtil.version()%>"></script>
<!-- 自定义组件 -->
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/public/component/loading-comp/js/loading.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/public/component/message-dialog-comp/js/message-dialog.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/public/component/right-suspension-menu/js/common.js?<%=JspUtil.version()%>"></script>
<!-- ng-select2引入 -->
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/jquery/plugins/select2-3.5.4/js/select2.min.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/angularJS/plugins/ng-select2/ng-select2.js?<%=JspUtil.version()%>"></script>
<!-- treeTable引入 -->
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/jquery/plugins/jquery-treetable/js/jquery.treeTable.min.js?<%=JspUtil.version()%>"></script>
<!-- 下拉菜单组织树封装脚本-start -->
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/jsTree/jstree.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/angular-jstree/ng-jsTree.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/app/app-component/drop-tree-comp/js/drop-tree.js?<%=JspUtil.version()%>"></script>
<!-- 下拉菜单组织树封装脚本-end -->
<!--导出控件-start-->
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/jquery/plugins/file-download/jquery.fileDownload.js?<%=JspUtil.version()%>"></script>
<!--导出控件-end-->

<!--调用外系统js start-->
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/public/out-system/utils.js?<%=JspUtil.version()%>"></script>
<!--调用外系统js end-->
<%--iframe工具 start--%>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/angularJS/plugins/iframe/saas-iframe.js?<%=JspUtil.version()%>"></script>
<%--iframe工具 end--%>