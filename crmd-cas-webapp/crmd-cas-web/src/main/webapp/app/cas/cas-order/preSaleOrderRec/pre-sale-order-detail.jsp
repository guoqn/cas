<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<table id="preSaleOrderDetailTable" class="table table-bordered table-hover fjNet-table"
       data-toggle="table">
    <thead>
    <tr>
        <!--预受理工单池接收订单信息-->
        <th data-field="custSoNumber" data-align="center">订单编号</th>
        <th data-field="orderType" data-align="center">订单类型</th>
        <th data-field="custName" data-align="center">客户名称</th>
        <th data-field="statusCdName" data-align="center">订单状态</th>
        <th data-field="createDate"
            data-align="center">受理时间
        </th>
        <th data-formatter="preOrderDetailForamatter" data-align="center">操作</th>
    </tr>
    </thead>
</table>
