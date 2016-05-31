<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="com.ffcs.crmd.cas.base.utils.JspUtil" %>
<link rel="stylesheet"
      href="<%=JspUtil.path(request)%>/app/cas/component/css/comp_css.css?<%=JspUtil.version()%>">
<div id="scene-type-query" ng-controller="sceneTypeCompCtrl"
     class="modal fade" tabindex="-1" role="dialog" data-backdrop="true"
     aria-hidden="true" style="display: none;">
    <div class="modal-dialog" style="width: 60%;">
        <div class="modal-content">
            <div class="modal-header">
                <i class="mark"></i>
                <span class="modal-title">业务类型选择</span>
                <a type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</a>
            </div>
            <div class="modal-body">
                <form class="form-inline bg-lighter-blue bg-padding">
                    <div class="form-group">
                        <label class="control-label">业务类型名称:</label>
                        <input class="form-control" type="text" placeholder="请输入..."
                               ng-model="sceneTypeName"/>
                    </div>
                    <button type="button" class="btn btn-blue"
                            ng-click="querySceneType()">查询
                    </button>
                    <button type="button" class="btn btn-blue"
                            ng-click="resetSceneType()">清空
                    </button>
                </form>
                <div style="width: 100%;height:400px;overflow-y: auto;">
                	<div style="height:98%">
	                    <table id="sceneTypeTable" data-toggle="table"
	                           data-click-to-select="true"
	                           data-row-style="rowStyle"
	                           class="table table-hover table-responsive fjNet-table">
	                        <thead>
	                        <tr>
	                            <th data-field="check" data-checkbox="true"></th>
	                            <th data-field="sceneTypeName" data-align="center">受理类型</th>
	                        </tr>
	                        </thead>
	                    </table>
                    </div>
                </div>
            </div>
            <div class="modal-footer bg-gray">
                <div class="text-center">
                    <button class="btn btn-blue" style="width: 15%"
                            ng-click="confirmSceneType()">确定
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
