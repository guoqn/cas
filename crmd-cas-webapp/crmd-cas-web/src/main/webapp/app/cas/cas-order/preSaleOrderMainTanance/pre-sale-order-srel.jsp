<%--
  Created by IntelliJ IDEA.
  User: qn_guo
  Date: 2016/3/21
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="com.ffcs.crmd.cas.base.utils.JspUtil" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/app/public/include/header-inc.jsp"></jsp:include>
    <title>单个关联</title>
</head>
<body ng-app="preSaleOrderSRelApp" ng-controller="preSaleOrderSRelCtrl">
<div class="container-fluid">
    <div class="well well-default well-padding">
        <form class="form-horizontal bg-lighter-blue bg-padding">
            <div class="form-group">
                <label class="control-label col-sm-1">关联提出人</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" placeholder="请输入关联提出人..."
                           ng-model="qrySrelInfo.originator">
                </div>
                <div class="col-sm-2">
                    <button type="button" class="btn btn-blue" ng-click="onAddNewRow()">新增行</button>
                </div>
            </div>
        </form>
        <table id="pre_sale_order_rel_table" class="table table-hover fjNet-table"
               data-toggle="table" style="width: 70%">
            <thead>
            <tr>
                <th data-width="21%">正式订单号</th>
                <th data-width="22%">原关联P单号</th>
                <th data-width="22%">要关联P单号</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody hidden></tbody>
        </table>
        <div ng-repeat="todo in todos">
            <form class="form-inline">
                <div class="form-group">
                    <input type="text" class="form-control"
                           ng-blur="qryPreSaleOrderRel(todo)" ng-model="todo.custOrderNum"/>
                    <input type="text" class="form-control" ng-model="todo.preOrderNumber" disabled/>
                    <input type="text" class="form-control" ng-model="todo.newPreOrderNumber"/>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-default" ng-click="connectNewPreOrderForRow(todo)">关联</button>
                    <%--<span> | </span>
                    <button type="button" class="btn btn-default" ng-click=delRow(todo)>删除</button>--%>
                </div>
            </form>
        </div>


    </div>
</div>
<jsp:include page="/app/public/include/footer-inc.jsp"></jsp:include>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/cas-order/cas-order-service.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/cas-order/preSaleOrderMainTanance/pre-sale-order-srel-controller.js?<%=JspUtil.version()%>"></script>

</body>
</html>
