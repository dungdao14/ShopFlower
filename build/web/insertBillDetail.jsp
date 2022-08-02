<%-- 
    Document   : insertBillDetail
    Created on : Mar 14, 2022, 2:23:50 AM
    Author     : Dinh Nam
--%>

<%@page import="model.BillDetailDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    BillDetailDAO u = new BillDetailDAO();
%>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert a new bill detail</title>
        <link rel="stylesheet" href="css/styleForm.css" type="text/css" />
    </head>
    <body>
        <h3>Insert a new bill detail</h3>
        <form action="billDetailController?action=insert" method="POST">
            <p>Product ID: <input type="text" name="proID" value=""/>
            <p>Order ID: <input type="text" name="orderID" value=""/>
            <p>Quantity: <input type="text" name="quantity" value=""/>
            <p><input type="submit" value="Insert"> 
        </form>  
    </body>
</html>