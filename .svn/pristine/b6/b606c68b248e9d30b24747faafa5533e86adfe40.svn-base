<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="com.ffcs.crmd.cas.base.utils.JspUtil" %>
<link rel="stylesheet" href="<%=JspUtil.path(request)%>/app/cas/component/css/comp_css.css?<%=JspUtil.version()%>">
<div id="staff-query" ng-controller="staffCompCtrl"
     class="modal fade" tabindex="-1" role="dialog" data-backdrop="true"
     aria-hidden="true" style="display: none;">
    <div class="modal-dialog" style="width: 60%">
        <div class="modal-content">
            <div class="modal-header">
                <i class="mark"></i>
                <span class="modal-title">员工选择</span>
                <a type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</a>
            </div>
            <div class="modal-body">
                <form class="form-inline bg-lighter-blue bg-padding">
                    <div class="form-group">
                        <label class="control-label">员工名称:</label>
                        <input class="form-control" type="text" placeholder="请输入..."
                               ng-model="qryStaffName"/>
                        <label class="control-label">员工工号:</label>
                        <input class="form-control" type="text" placeholder="请输入..."
                               ng-model="qryStaffCode"/>
                    </div>
                    <button type="button" class="btn btn-blue"
                            ng-click="queryStaff()">查询
                    </button>
                    <button type="button" class="btn btn-blue"
                            ng-click="resetStaff()">清空
                    </button>
                </form>
                <div style="width: 100%;height:400px;overflow-y: auto;">
                    <table id="staffTable" data-toggle="table"
                           data-click-to-select="true" data-query-params-type=""
                           data-side-pagination="server"
                           data-row-style="rowStyle" data-page-size="10"
                           data-page-list="[5, 10, 20]" data-pagination="true"
                           class="table table-hover fjNet-table">
                        <thead>
                        <tr>
                            <th data-field="check" data-checkbox="true"></th>
                            <th data-field="staffCode" data-align="center">员工工号</th>
                            <th data-field="staffName" data-align="center">员工名称</th>
                        </tr>
                        </thead>
                    </table>
                </div>
                <%--<div class="div-content-h" style="height: 400px;border:1px solid #ddd;">
                    <div id="orgTree" class="left" style="width: 30%;padding:0px;margin-left:0px;overflow-y: auto;">
                        <div id="myTabContent" class="tab-content div-toolbar-gray">
                            <label style="font-weight:bold">团队选择</label>
                            <div tree-data="orgTreeConf.treeData"
                                 selected-data="orgTreeConf.selectedData"
                                 js-tree="orgTreeConf.treeConfig"
                                 service="orgTreeConf.service"
                                 tree-events="select_node:treeClick"
                                 status="orgTreeConf.status"
                                 tree-types="treeTypes" data-multiple="false" animation="true"></div>
                        </div>
                    </div>
                    <div class="right" style="width: 69%;float:right;padding:0px;margin:0px;">
                        <div class="div-toolbar" style="height: 40px;margin:0px;background-color:#FFF">
                            <div style="width: 80px;">
                                <label class="control-label">员工信息</label>
                            </div>
                        </div>
                        <div style="padding:5px;height:89%;overflow:auto;">

                        </div>
                    </div>
                </div>--%>
            </div>
            <div class="modal-footer bg-gray">
                <div class="text-center">
                    <button class="btn btn-blue" style="width: 15%" ng-click="confirmStaff()">确定</button>
                </div>
            </div>
        </div>
    </div>
</div>
