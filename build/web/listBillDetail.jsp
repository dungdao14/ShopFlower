<%-- 
    Document   : listBillDetail
    Created on : Mar 14, 2022, 2:21:47 AM
    Author     : Dinh Nam
--%>

<%@page import="model.BillDetailDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.BillDetail"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    BillDetailDAO u = new BillDetailDAO();
    List<BillDetail> lst = u.getBillDetailList();
%>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of bill details</title>
        <link rel="stylesheet" href="css/styleTable.css" type="text/css" />
    </head>
    <body>
        <h2> List of bill details </h2>
        <a href="insertBillDetail.jsp"><button>Insert a new bill detail</button></a>
        <p></p>
        <table style="width: 100%;">
            <tr>
                <th> Product ID </th>
                <th> Order ID </th>
                <th> Quantity </th>
                <th> Price </th>
                <th> Amount </th>
                <th> Delete </th>
                <th> Update </th>
            </tr>
            <% for (BillDetail x : lst) {%>
            <tr>
                <td><%= x.getProID()%></td>
                <td><%= x.getOrderID()%></td>
                <td> <%= x.getQuantity()%></td>
                <td><%= x.getPrice()%></td>
                <td><%= x.getAmount() %></td>
                <td> <a href="billDetailController?action=delete&proID=<%= x.getProID()%>&orderID=<%= x.getOrderID() %>"> Delete  </td>  
                <td> <a href="updateBillDetail.jsp?proID=<%= x.getProID()%>&orderID=<%= x.getOrderID() %>"> Update  </td>  
            </tr>
            <%}%>
        </table>
    </body>
</html>