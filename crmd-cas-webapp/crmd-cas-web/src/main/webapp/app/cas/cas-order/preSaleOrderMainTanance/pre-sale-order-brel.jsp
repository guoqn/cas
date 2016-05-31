<%--
  Created by IntelliJ IDEA.
  User: qn_guo
  Date: 2016/3/21
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="com.ffcs.crmd.cas.base.utils.JspUtil" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/app/public/include/header-inc.jsp"></jsp:include>
    <title>批量关联</title>
</head>
<body ng-app="preSaleOrderBRelApp" ng-controller="preSaleOrderBRelCtrl">
<div class="container-fluid">
    <div class="well well-default well-padding">
        <form class="form-horizontal bg-lighter-blue bg-padding">
            <div class="form-group">
                <label class="control-label col-sm-1">关联提出人</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" placeholder="请输入关联提出人..."
                           ng-model="mainTananceInfo.originator">
                </div>
                <div class="col-sm-4">
                    <button class="btn btn-blue" ngf-select ng-model="uploadFile"
                         name="uploadFile" ng-change="upload()">数据导入</button>
                    <button type="button" class="btn btn-blue" ng-click="resetBtn()">清空所有</button>
                    <button class="btn btn-blue" ng-click="downTemplate()">模板下载</button>
                </div>
                <label class="control-label">
                    数据模板共两列，第一列为要关联的FJ单号，第二列为要关联的P单号
                </label>
            </div>
        </form>
        <table id="pre_sale_order_brel_table" class="table table-hover fjNet-table"
               data-toggle="table" data-height="400">
            <thead>
            <tr>
                <th data-align="center" data-field="custSoNumber">正式订单号</th>
                <th data-align="center" data-field="oldPreOrderNumber">原关联P单号</th>
                <th data-align="center" data-field="targetPreOrderNumber">要关联P单号</th>
                <th data-align="center" data-formatter="isCanRelate">是否可以关联</th>
                <th data-align="center" data-field="canntRelReason">不能关联的原因</th>
                <th data-align="center" data-field="statusCdName">状态</th>
            </tr>
            </thead>
        </table>
        <form class="form-horizontal bg-lighter-blue bg-padding">
            <div class="form-group">
                <label class="control-label col-sm-1">总数:</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" ng-model="qryBrelInfo.totalCount" disabled>
                </div>
                <label class="control-label col-sm-1">可关联数:</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" ng-model="qryBrelInfo.canConnectCount" disabled>
                </div>
                <label class="control-label col-sm-1">不可关联数:</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" ng-model="qryBrelInfo.canntConnectCount" disabled>
                </div>
                <div class="col-sm-1">
                    <button type="button" class="btn btn-blue" id="buttonUpload" ng-click="uploadSubmit()" >确认关联</button>
                </div>
            </div>
        </form>
    </div>
</div>

<jsp:include page="/app/public/include/footer-inc.jsp"></jsp:include>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/cas-order/cas-order-service.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/cas-order/preSaleOrderMainTanance/pre-sale-order-brel-controller.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/angularJS/plugins/fileUpload/ng-file-upload.min.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/angularJS/plugins/fileUpload/ng-file-upload-shim.min.js?<%=JspUtil.version()%>"></script>

</body>
</html>
