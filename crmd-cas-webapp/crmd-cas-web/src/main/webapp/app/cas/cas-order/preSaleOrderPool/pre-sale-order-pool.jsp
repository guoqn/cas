<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="com.ffcs.crmd.cas.base.utils.JspUtil" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/app/public/include/header-inc.jsp"></jsp:include>
    <title>预受理工单池</title>
</head>
<body ng-app="preSaleOrderPoolApp" ng-controller="preSaleOrderPoolCtrl">
<div class="container-fluid">
    <div class="well well-default well-padding">
        <form class="form-horizontal bg-lighter-blue bg-padding">
            <div class="form-group">
                <label class="control-label col-sm-1">订单编号</label>
                <div class="col-sm-3 date-time date-time-ie8">
                    <input type="text" class="form-control" placeholder="受理单号、订单编号"
                           ng-model="qryPreSaleOrderPoolInfo.preOrderNumber" style="">
                </div>
                <label class="control-label col-sm-1">预受理区域</label>
                <div class="col-sm-2">
                    <div region-comp region-data-bind="regionList" checkbox="false"></div>
                </div>
                <label class="control-label col-sm-1">预受理团队</label>
                <div class="col-sm-2">
                    <div org-comp org-data-bind="orgList" checkbox="false"></div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-1">受理时间从</label>
                <div class="col-sm-3 date-time date-time-ie8">
                    <div class="form-inline">
                        <div class="input-group date form_date form-date2" data-date=""
                             data-date-format="yyyy/mm/dd">
                            <input ng-model="qryPreSaleOrderPoolInfo.beginTime"
                                   class="form-control input-date2 input-date2-ie8 dateTime-btn"
                                   size="16" type="text" value="" readonly> <span
                                class="input-group-addon comp-btn"><span
                                class="glyphicon glyphicon-calendar"></span></span><span
                                class="input-group-addon comp-btn"><span
                                class="glyphicon glyphicon-remove"><span
                                class="glyphicon fa-times"></span></span></span>
                        </div>
                        <span class="control-label">至</span>
                        <div class="input-group date form_date form-date2" data-date=""
                             data-date-format="yyyy/mm/dd" >
                            <input ng-model="qryPreSaleOrderPoolInfo.endTime"
                                   class="form-control input-date2 input-date2-ie8 dateTime-btn"
                                   size="16" type="text" value="" readonly> <span
                                class="input-group-addon comp-btn"><span
                                class="glyphicon glyphicon-calendar"></span></span><span
                                class="input-group-addon comp-btn"><span
                                class="glyphicon glyphicon-remove"><span
                                class="glyphicon fa-times"></span></span></span>
                        </div>
                    </div>
                </div>
                <label class="control-label col-sm-1">预受理员工</label>
                <div class="col-sm-2">
                    <div staff-comp staff-data-bind="staffList" checkbox="false"></div>
                </div>
                <label class="control-label col-sm-1">接收员工</label>
                <div class="col-sm-2">
                    <div receive-staff-comp receive-staff-data-bind="receiveStaffList"
                         checkbox="false"></div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-1">工单池状态</label>
                <div class="col-sm-3 date-time date-time-ie8">
                    <div status-comp status-data-bind="statusList"
                         checkbox="true"></div>
                </div>
                <label class="control-label col-sm-1">受理类型</label>
                <div class="col-sm-2">
                    <div scene-type-comp scene-type-data-bind="sceneTypeList"
                         checkbox="true"></div>
                </div>
                <label class="control-label col-sm-1">业务类型</label>
                <div class="col-sm-2">
                    <input select2 ng-model="qryPreSaleOrderPoolInfo.serviceType"
                           select2-model="serviceTypes" config="serviceTypeConfig"
                           class="form-control inline" type="text" />
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-1">工单来源</label>
                <div class="col-sm-3 date-time date-time-ie8">
                    <input select2 ng-model="qryPreSaleOrderPoolInfo.preOrderSrc"
                           select2-model="preOrderSrcs" config="preOrderSrcsConfg"
                           class="form-control inline" type="text"/>
                </div>
                <div class="col-sm-6 text-right">
                    <button type="button" class="btn btn-blue"
                            ng-click="qryPreSaleOrderPools()">查询
                    </button>
                    <button type="button" class="btn btn-ui-blue" ng-click="resetQryInfo()">
                        重置
                    </button>
                </div>
            </div>
        </form>

        <div class="bg-default bg-dotted bg-light-orange bg-padding">
            <div class="form-inline inline" style="display: inline">
                <img src="../../../public/img/slices/notice.png "/>
                <label>工单池总数:</label>
                        <span style="color: #e5784b"
                              ng-bind="preSaleorderCount.countAll">0</span>
                <label>其中未接收:</label>
                        <span style="color: #e5784b"
                              ng-bind="preSaleorderCount.countWJS">0</span>
                <label>可派单:</label>
                        <span style="color: #e5784b"
                              ng-bind="preSaleorderCount.countKPD">0</span>
                <button class="btn btn-white-orange btn-xs" type="button"
                        ng-click="batchAccepts()">批量派单
                </button>
                <button class="btn btn-white-orange btn-xs" type="button"
                        ng-click="qryPreOrderDistribute()">工单分布
                </button>
                <button class="btn btn-white-orange btn-xs" type="button"
                        ng-click="qryPreOrderDetail()" ng-show="showOnClickBtn">P单详情
                </button>

                <div class="form-group">
                    <div class="fileinput-button btn-white-orange btn-xs" ng-show="showOnClickBtn">
                        <span>附件上传</span>
                        <input fileupload type="file" name="uploadFile"
                               data-url="<%=JspUtil.path(request)%>/order/preSaleOrderPool/uploadFile"
                               multiple="false" done="uploadFinished(e, data)"
                               submit="submit(e,data)" fail="fail(e,data)" progress="progress(e,data)">
                    </div>
                </div>
            </div>
        </div>
        <table id="preSaleOrderPoolTable" class="table table-hover fjNet-table"
               data-toggle="table" data-side-pagination="server" data-click-to-select="true"
               data-row-style="rowStyle" data-pagination="true"
               data-page-size="5" data-query-params-type="" data-page-list="[5, 10, 20]">
            <thead>
            <tr>
                <th data-field="state" data-checkbox="true"></th>
                <th data-field="preOrderNbr" data-align="center">受理单号</th>
                <th data-field="sceneTypeName" data-align="center">受理类型</th>
                <th data-field="prodType" data-align="center">产品</th>
                <th data-field="actionType" data-align="center">动作</th>
                <th data-field="statusCdName" data-align="center">工单池状态</th>
                <th data-field="orderStatusCdName" data-align="center">订单状态</th>
                <th data-field="batchAmount" data-align="center">数量</th>
                <th data-field="custName" data-align="center">客户名称</th>
                <th data-field="preFee" data-align="center">预收费用</th>
                <th data-field="createStaffName" data-align="center">预受理员工</th>
                <th data-field="orgName" data-align="center">预受理团队</th>
                <th data-field="regionCdName" data-align="center">甩单操作点</th>
                <th data-field="createDate" data-formatter="ffc.util.tableDateFormatter">甩单时间</th>
                <th data-field="staffName" data-align="center">接收员工</th>
                <th data-field="acceptDate" data-formatter="ffc.util.tableDateFormatter">接收时间</th>
                <th data-align="center" data-formatter="preSaleOrderPoolFormatter">操作</th>
            </tr>
            </thead>
        </table>
    </div>
    <div class="well well-default">
        <ul class="nav nav-tab-default">
            <li class="active">
                <a role="tab" data-toggle="tab" href="#b1_c1">处理过程</a></li>
        </ul>
        <div class="tab-content nav-tab-content-default">
            <div class="tab-pane fade in active" id="b1_c1"
                 ng-controller="preSaleOrderPoolProcCtrl">
                <button class="hidden" id="b1_c1_ngtabclick"
                        ng-click="triggerPreSaleOrderPoolProc(preOrderId,preOrderNumber)"></button>
                <jsp:include page="pre-sale-order-pool-proc.jsp"></jsp:include>
            </div>
        </div>
    </div>
</div>
<!--发送短信采集页面start-->
<div id="send_message_pre_order" class="modal fade" tabindex="-1"
     role="dialog" data-backdrop="true" aria-hidden="true">
    <div class="modal-dialog" style="width: 70%;height: 40%;">
        <div class="modal-content">
            <div class="modal-header">
                <div>
                    <i class="mark"></i><span class="title">发送短信</span> <a
                        type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">&times;</a>
                </div>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">受理单号: </label>
                        <div class="col-sm-10">
                            <input class="form-control"
                                   ng-model="sendMessageInfo.preOrderNbr" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">销售人员: </label>
                        <div class="col-sm-10">
                            <input class="form-control"
                                   ng-model="sendMessageInfo.createStaffName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">联系电话: </label>
                        <div class="col-sm-10">
                            <input class="form-control"
                                   ng-model="sendMessageInfo.mobilePhone">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">短信内容: </label>
                        <div class="col-sm-10">
                                <textarea class="form-control"
                                          ng-model="sendMessageInfo.messageValue">
                                </textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer bg-gray">
                <div class="text-center">
                    <button class="btn btn-blue"
                            ng-click="confirmSendMessage()">确认发送
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<!--发送短信采集页面end-->
<!--派单界面start-->
<div id="pre_sale_order_pool_accept" class="modal fade" tabindex="-1"
     role="dialog" data-backdrop="true" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <i class="mark"></i>
                <span class="modal-title">派单页面</span>
                <a type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</a>
            </div>
            <div class="modal-body">
                <form class="form-inline bg-padding">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-8">
                        <div class="form-group" style="padding-bottom: 78px;">
                            <label class="col-sm-4 control-label">请选择员工:</label>
                            <div class="col-sm-6">
                                <div receive-staff-comp receive-staff-data-bind="receiveStaffList"
                                     checkbox="false"
                                     readonly="true"
                                     class="div-inline"></div>
                            </div>
                        </div>
                    </div>
                </form>
                <div class="col-sm-2"></div>
            </div>
            <div class="modal-footer bg-gray">
                <div class="text-center">
                    <button class="btn btn-blue"
                            ng-click="confirmAccept()">确定
                    </button>
                    <button class="btn btn-blue"
                            ng-click="cancelAccept()">取消
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<!--派单界面end-->
<%--工单分布 start--%>
<div id="pre-order-distribute"
     class="modal fade" tabindex="-1" role="dialog" data-backdrop="true"
     aria-hidden="true" style="display: none;">
    <div class="modal-dialog" style="width: 60%;height: 50%;">
        <div class="modal-content">
            <div class="modal-header">
                <i class="mark"></i>
                <span class="modal-title">工单分布</span>
                <a type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</a>
            </div>
            <div class="modal-body">
                <div style="width: 100%;height:400px;">
                    <table id="preOrderDistributeTable"
                           class="table table-hover fjNet-table" data-toggle="table">
                        <thead>
                        <tr>
                            <th data-field="orgName" data-align="center">关联销售点</th>
                            <th data-field="unAcceptOrderAmount" data-align="center">未接收工单量</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
            <div class="modal-footer bg-gray">
                <div class="text-center">
                    <button class="btn btn-blue"
                            ng-click="closePreOrder()">关闭
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<%--工单分布 end--%>

<jsp:include page="/app/public/include/footer-inc.jsp"></jsp:include>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/cas-order/cas-order-service.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/cas-order/preSaleOrderPool/pre-sale-order-pool-controller.js?<%=JspUtil.version()%>"></script>
<!--团队-->
<jsp:include
        page="/app/cas/component/org-comp/org_comp.jsp"></jsp:include>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/org-comp/org-comp-controller.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/org-comp/org-comp-directive.js?<%=JspUtil.version()%>"></script>
<!--业务类型-->
<jsp:include
        page="/app/cas/component/scenetype-comp/scenetype_comp.jsp"></jsp:include>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/scenetype-comp/scenetype-comp-controller.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/scenetype-comp/scenetype-comp-directive.js?<%=JspUtil.version()%>"></script>
<!-- 员工选择 -->
<jsp:include
        page="/app/cas/component/staff-comp/staff_comp.jsp"></jsp:include>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/staff-comp/staff-comp-controller.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/staff-comp/staff-comp-directive.js?<%=JspUtil.version()%>"></script>
<!-- 区域选择二级界面 -->
<jsp:include
        page="/app/cas/component/region-comp/region-comp.jsp"></jsp:include>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/region-comp/region-comp-controller.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/region-comp/region-comp-directive.js?<%=JspUtil.version()%>"></script>
<!--接收员工-->
<jsp:include
        page="/app/cas/component/receive-staff-comp/receive-staff_comp.jsp"></jsp:include>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/receive-staff-comp/receive-staff-comp-controller.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/receive-staff-comp/receive-staff-comp-directive.js?<%=JspUtil.version()%>"></script>
<!--订单状态-->
<jsp:include
        page="/app/cas/component/status-comp/status_comp.jsp"></jsp:include>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/status-comp/status-comp-controller.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/status-comp/status-comp-directive.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/component/comp-service.js?<%=JspUtil.version()%>"></script>

<!--处理过程-->
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/app/cas/cas-order/preSaleOrderPool/pre-sale-order-pool-proc-controller.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/jquery/plugins/file-upload/jquery.ui.widget.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/jquery/plugins/file-upload/jquery.iframe-transport.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/lib/jquery/plugins/file-upload/jquery.fileupload.js?<%=JspUtil.version()%>"></script>
<script type="text/javascript"
        src="<%=JspUtil.path(request)%>/resources/app/app-component/ng-jquery-file-upload/ng-jquery-file-upload.js?<%=JspUtil.version()%>"></script>
</body>
</html>
