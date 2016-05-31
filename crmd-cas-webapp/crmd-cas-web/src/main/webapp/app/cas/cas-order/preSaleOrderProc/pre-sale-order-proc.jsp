<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<table id="preSaleOrderProcTable" class="table table-hover fjNet-table"
       data-toggle="table" data-page-list="[5, 10, 20]"
       data-side-pagination="server" data-click-to-select="true"
       data-row-style="rowStyle" data-pagination="true" data-height="350"
       data-page-size="10" data-query-params-type="">
    <thead>
        <tr>
            <th data-field="preSaleOrderNum" data-align="center">受理单号</th>
            <th data-field="handlePeopleName" data-align="center">受理员工</th>
            <th data-field="statusCdName" data-align="center">受理状态</th>
            <th data-field="acceptTime" data-formatter="ffc.util.tableDateFormatter" data-align="center">受理时间</th>
            <th data-field="remark" data-align="center">备注</th>
        </tr>
    </thead>
</table>
