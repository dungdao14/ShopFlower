<%-- 
    Document   : listBill
    Created on : Mar 14, 2022, 1:43:13 AM
    Author     : Dinh Nam
--%>

<%@page import="model.Bill"%>
<%@page import="java.util.List"%>
<%@page import="model.BillDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    BillDAO u = new BillDAO();
    List<Bill> lst = u.getBillList();
%>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> List of bills </title>
        <link rel="stylesheet" href="css/styleTable.css" type="text/css" />
    </head>
    <body>
        <h2> List of bills </h2>
        <p><button onclick='window.location.href = "insertBill.jsp"'>Insert a new bill</button>
        <table style="width: 100%;">
            <tr>
                <th> Order ID </th>
                <th> Date create </th>
                <th> Customer name </th>
                <th> Phone </th>
                <th> Address </th>
                <th> Total </th>
                <th> Customer ID </th>
                <th> Voucher </th>
                <th> Delete </th>
                <th> Update </th>
            </tr>
            <% for (Bill x : lst) {%>
            <tr>
                <td><%= x.getOrderID()%></td>
                <td><%= x.getDateCreate()%></td>
                <td><%= x.getCusName()%></td>
                <td> <%= x.getCusPhone()%></td>
                <td><%= x.getCusAddress()%></td>
                <td><%= x.getTotal()%></td>
                <td><%= x.getCusID()%></td>
                <td><%= x.getVouID() %></td>
               <td> <a href="billController?action=delete&orderID=<%= x.getOrderID()%>"> Delete  </td>  
                <td> <a href="updateBill.jsp?orderID=<%= x.getOrderID()%>"> Update  </td>  
            </tr>
            <%}%>
        </table>
    </body>
</html>
