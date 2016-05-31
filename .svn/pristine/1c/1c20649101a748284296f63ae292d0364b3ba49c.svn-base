<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="com.ffcs.crmd.cas.base.utils.JspUtil" %>
<link rel="stylesheet"
      href="<%=JspUtil.path(request)%>/app/cas/component/css/comp_css.css?<%=JspUtil.version()%>">
<div id="status-query" ng-controller="statusCompCtrl"
     class="modal fade" tabindex="-1" role="dialog" data-backdrop="true"
     aria-hidden="true" style="display: none;">
    <div class="modal-dialog" style="width: 60%;">
        <div class="modal-content">
            <div class="modal-header">
                <i class="mark"></i>
                <span class="modal-title">订单状态选择</span>
                <a type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</a>
            </div>
            <div class="modal-body">
                <div style="width: 100%;height:400px;overflow-y: auto;">
                	<div style="height:98%">
	                    <table id="statusTable" data-toggle="table"
	                           data-click-to-select="true"
	                           data-row-style="rowStyle"
	                           class="table table-hover table-responsive fjNet-table">
	                        <thead>
	                        <tr>
	                            <th data-field="check" data-checkbox="true"></th>
	                            <th data-field="attrValueName" data-align="center">订单状态</th>
	                        </tr>
	                        </thead>
	                    </table>
                    </div>
                </div>
            </div>
            <div class="modal-footer bg-gray">
                <div class="text-center">
                    <button class="btn btn-blue" style="width: 15%"
                            ng-click="confirmStatus()">确定
                    </button>
                    <button class="btn btn-blue" style="width: 15%"
                            ng-click="resetStatus()">清空
                    </button>

                </div>
            </div>
        </div>
    </div>
</div>
