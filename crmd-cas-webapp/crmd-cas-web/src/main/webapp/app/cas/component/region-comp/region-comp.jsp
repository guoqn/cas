<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="com.ffcs.crmd.cas.base.utils.JspUtil" %>
<link rel="stylesheet"
      href="<%=JspUtil.path(request)%>/app/cas/component/css/comp_css.css?<%=JspUtil.version()%>">

<div id="region-query" ng-controller="regionCompCtrl"
     class="modal fade" tabindex="-1" role="dialog" data-backdrop="true"
     aria-hidden="true" style="display: none;">
    <div class="modal-dialog" style="width: 60%;height: 50%;">
        <div class="modal-content">
            <div class="modal-header">
                <i class="mark"></i>
                <span class="modal-title">区域选择</span>
                <a type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</a>
            </div>
            <div class="modal-body">
                <form class="form-inline bg-lighter-blue bg-padding">
                    <div class="form-group">
                        <label class="control-label">区域名称:</label> <input
                            class="form-control" type="text" placeholder="请输入..."
                            ng-model="qryRegionName">
                    </div>
                    <button type="button" class="btn btn-blue"
                            ng-click="queryRegion()">查询
                    </button>
                    <button type="button" class="btn btn-blue"
                            ng-click="resetRegion()">清空
                    </button>
                </form>
                <div style="width: 100%;height:400px;">
                    <table id="regionTable" data-toggle="table"
                           data-click-to-select="true" data-query-params-type=""
                           data-side-pagination="server"
                           data-row-style="rowStyle" data-page-size="10"
                           data-page-list="[5, 10, 20]" data-pagination="true"
                           class="table table-hover fjNet-table">
                        <thead>
                        <tr>
                            <th data-field="regionCode" data-align="center">区域编码</th>
                            <th data-field="regionName" data-align="center">区域名称</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
            <div class="modal-footer bg-gray">
                <div class="text-center">
                    <button class="btn btn-blue" style="width: 15%"
                            ng-click="confirmRegion()">确定
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
