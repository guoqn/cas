<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="com.ffcs.crmd.cas.base.utils.JspUtil" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/app/public/include/header-inc.jsp"></jsp:include>
    <title>工单池流程</title>
</head>
<body ng-app="interactionFlowApp" ng-controller="interactionFlowCtrl">
<div class="container-fluid">
    <div class="well well-default well-padding">
        <form class="form-inline bg-lighter-blue bg-padding">
            <div class="form-group">
                <label for="searchFlowName">流程名称:</label>
                <input id="searchFlowName" type="text" class="form-control"
                       ng-model="interactionFlowName" placeholder="请输入流程名称">
            </div>
            <button type="button" ng-click="queryFlowList()" class="btn btn-blue">
                查询
            </button>
        </form>
        <div class="text-right bg-default">
            <button type="button" ng-click="addInteractionFlow()"
                    class="btn btn-white-orange btn-xs">
                新增工单池流程
            </button>
        </div>
        <table id="interactionFlowTable" class="table table-hover fjNet-table"
               data-toggle="table"
               data-side-pagination="server" data-click-to-select="true"
               data-row-style="rowStyle" data-pagination="true" data-height="350"
               data-page-size="10" data-query-params-type=""
               data-page-list="[5, 10, 20]">
            <thead>
            <tr>
                <th data-field="interactionFlowName" data-align="center">流程名称</th>
                <th data-field="custItemTypeGroupName" data-align="center">业务大类组</th>
                <th data-field="statusCdName" data-align="center">状态</th>
                <th data-field="statusDate" data-formatter="ffc.util.tableDateFormatter"
                    data-align="center">状态时间
                </th>
                <th data-field="remark" data-align="center">备注</th>
                <th data-align="center" data-formatter="operationFormatter">
                    操作
                </th>
            </tr>
            </thead>
        </table>
    </div>
    <div class="well well-default">
        <ul class="nav nav-tab-default">
            <li class="active">
                <a role="tab" data-toggle="tab" href="#b1_c1">工单池转派团队列表</a></li>
        </ul>
        <div class="nav-tab-content-default">
            <div class="tab-pane fade in active" id="b1_c1"
                 ng-controller="assignOrgMainCtrl">
                <button class="hidden" id="b1_c1_ngtabclick"
                        ng-click="triggerInterActionAssignOrg(interactionFlowId)"></button>
                <jsp:include page="../assignOrg/assign-org.jsp"></jsp:include>
            </div>
        </div>
    </div>
    <!--工单池流程编辑页面-->
    <div id="interaction_flow_modify" class="modal fade" tabindex="-1"
         role="dialog" data-backdrop="true" aria-hidden="true">
        <div class="modal-dialog" style="width: 600px;  ">
            <div class="modal-content">
                <div class="modal-header">
                    <i class="mark"></i>
                    <span class="modal-title">{{interactionModifyFlowName}}</span>
                    <a type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</a>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group" style="margin-bottom: 2px;">
                            <label for="interactionFlowName" class="col-sm-4 control-label"
                                   style="text-align: right;">流程名称:</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="interactionFlowName"
                                       placeholder="请输入..."
                                       ng-model="interactionFlowSaveInfo.interactionFlowName"/>
                            </div>
                        </div>
                        <div class="form-group" style="margin-bottom: 2px;">
                            <label class="col-sm-4 control-label"
                                   style="text-align: right;">业务大类组:</label>
                            <div class="col-sm-6">
                                <input select2
                                       ng-model="interactionFlowSaveInfo.custItemTypeGroup"
                                       select2-model="typeGroups" config="typeGroupConfig"
                                       class="form-control" type="text" disabled/>
                            </div>
                        </div>
                        <div class="form-group" style="margin-bottom: 2px;">
                            <label for="statusCd" class="col-sm-4 control-label"
                                   style="text-align: right;">状态:</label>
                            <div class="col-sm-6">
                                <input select2 ng-model="statusCdType" id="statusCd"
                                       select2-model="statusTypes" config="statusConfig"
                                       class="form-control" type="text"/>
                            </div>
                        </div>
                        <div class="form-group" style="margin-bottom: 2px;">
                            <label for="remark" class="col-sm-4 control-label"
                                   style="text-align: right;">备注</label>
                            <div class="col-sm-6">
                                    <textarea class="form-control" id="remark"
                                              style="height: 200px;"
                                              ng-model="interactionFlowSaveInfo.remark">
                                    </textarea>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer bg-gray">
                    <div class="text-center">
                        <button class="btn btn-blue"
                                ng-click="saveInteractionFlow()">保存
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/app/public/include/footer-inc.jsp"></jsp:include>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/cas-order/cas-order-service.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/cas-order/interaction/interaction-flow-controller.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/cas-order/assignOrg/assign-org-controller.js?<%=JspUtil.version()%>"></script>
<!--团队-->
<jsp:include
        page="/app/cas/component/assign-org-comp/assign_org_comp.jsp"></jsp:include>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/assign-org-comp/assign-org-comp-controller.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/assign-org-comp/assign-org-comp-directive.js?<%=JspUtil.version()%>"></script>
<!--区域-->
<jsp:include
        page="/app/cas/component/assign-region-comp/assign-region-comp.jsp"></jsp:include>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/assign-region-comp/assign-region-comp-controller.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/assign-region-comp/assign-region-comp-directive.js?<%=JspUtil.version()%>"></script>
<!--二次受理团队-->
<jsp:include
        page="/app/cas/component/execute-org-comp/execute-org-comp.jsp"></jsp:include>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/execute-org-comp/execute-org-comp-controller.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/execute-org-comp/execute-org-comp-directive.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/comp-service.js?<%=JspUtil.version()%>"></script>

</body>
</html>
