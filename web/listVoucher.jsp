<%-- 
    Document   : listVoucher
    Created on : Mar 14, 2022, 2:46:02 AM
    Author     : Dinh Nam
--%>

<%@page import="model.Voucher"%>
<%@page import="model.VoucherDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    VoucherDAO u = new VoucherDAO();
    List<Voucher> list = u.getVoucherList();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Voucher</title>
        <style type="text/css">
            a {text-decoration:none;} 
        </style>
    </head>
    <body>
        <h1>List Voucher</h1>
        <table border="1">
            <tr>
                <td>Voucher ID:</td>
                <td>Discount</td>
                <td>Total</td>
                <td>Status</td>
            </tr>
            <% for (Voucher x : list) {%>
            <tr>
                <td><%= x.getVouID() %></td>
                <td><%= x.getDiscount() %></td>
                <td><%= x.getTotal() %></td>
                <td><%= x.getStatus() %></td>
            </tr>
            <%}%>
        </table>
        <p><button onclick='window.history.go(-1);'>Back to previous page</button>
        <p><a href="home.html">Back to homepage</a>
    </body>
</html>
