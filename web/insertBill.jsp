<%-- 
    Document   : insertBill
    Created on : Mar 14, 2022, 2:05:31 AM
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
        <title>Insert a new bill</title>
        <link rel="stylesheet" href="css/styleForm.css" type="text/css" />
    </head>
    <body>
        <h3>Insert a new bill</h3>
        <form action="billController?action=insert" method="POST">
            <p>Date create: <input type="Date" name="dateCreate" value=""/>
            <p>Customer name: <input type="text" name="cusName" value="" />
            <p>Phone number: <input type="text" name="cusPhone" value="" />
            <p>Address: <input type="text" name="cusAddress" value=""/>
            <p>Customer ID: <input type="text" name="cusID" value=""/>
            <p>Voucher: <input type="text" name="vouID" value=""/>
            <p><input type="submit" value="Insert"> 
        </form>  
    </body>
</html>