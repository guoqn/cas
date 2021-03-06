<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<table id="preSaleOrderRecProcTable" class="table table-bordered table-hover fjNet-table"
       data-toggle="table" data-page-list="[5, 10, 20]"
       data-side-pagination="server" data-click-to-select="true"
       data-row-style="rowStyle" data-pagination="true" data-height="350"
       data-page-size="10" data-query-params-type="">
    <thead>
    <tr>
        <!--预受理工单池接收处理过程-->
        <th data-field="createDate" data-formatter="ffc.util.tableDateFormatter" data-align="center">处理时间</th>
        <th data-field="handlePeopleName" data-align="center">处理人员</th>
        <th data-field="customerInteractionEventName" data-align="center">动作</th>
        <th data-field="remark" data-align="center">描述</th>
    </tr>
    </thead>
</table>

