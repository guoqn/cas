<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="com.ffcs.crmd.cas.base.utils.JspUtil" %>
<link rel="stylesheet"
      href="<%=JspUtil.path(request)%>/app/cas/component/css/comp_css.css?<%=JspUtil.version()%>">

<div id="org-query" ng-controller="orgCompCtrl"
     class="modal fade" tabindex="-1" role="dialog" data-backdrop="true"
     aria-hidden="true" style="display: none;">
    <div class="modal-dialog" style="width: 60%;height: 50%;">
        <div class="modal-content">
            <div class="modal-header">
                <i class="mark"></i>
                <span class="modal-title">团队选择</span>
                <a type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</a>
            </div>
            <div class="modal-body">
                <form class="form-inline bg-lighter-blue bg-padding">
                    <div class="form-group">
                        <label for="orgName" class="control-label">团队名称</label> <input
                            class="form-control" type="text" placeholder="请输入..."
                            ng-model="qryOrgName">
                    </div>
                    <button type="button" class="btn btn-blue"
                            ng-click="queryOrg()">查询
                    </button>
                    <button type="button" class="btn btn-blue"
                            ng-click="resetOrg()">清空
                    </button>
                </form>
                <div style="width: 100%;height:400px;">
                    <table id="orgTable" data-toggle="table"
                           data-click-to-select="true" data-query-params-type=""
                           data-side-pagination="server"
                           data-row-style="rowStyle" data-page-size="10"
                           data-page-list="[5, 10, 20]" data-pagination="true"
                           class="table table-hover fjNet-table">
                        <thead>
                        <tr>
                            <th data-field="check" data-checkbox="true"></th>
                            <th data-field="orgName" data-align="center">团队名称</th>
                            <th data-field="areaCode" data-align="center">所属区域</th>
                            <th data-field="createDate" data-align="center"
                                data-formatter="ffc.util.tableDateFormatter">创建时间
                            </th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
            <div class="modal-footer bg-gray">
                <div class="text-center">
                    <button class="btn btn-blue" style="width: 15%"
                            ng-click="confirmOrg()">确定
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
