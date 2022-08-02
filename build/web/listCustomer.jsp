<%-- 
    Document   : listCustomer
    Created on : Mar 14, 2022, 1:25:32 AM
    Author     : Dinh Nam
--%>

<%@page import="model.Customer"%>
<%@page import="java.util.List"%>
<%@page import="model.CustomerDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    CustomerDAO u = new CustomerDAO();
    List<Customer> lst = u.getCustomerList();
%>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of customers</title>
        <link rel="stylesheet" href="css/styleTable.css" type="text/css" />
    </head>
    <body>
        <h2> List of customers </h2>
        <p><button onclick='window.location.href = "insertCustomer.jsp"'>Insert a new customer</button>
        <table style="width: 100%;">
            <tr>
                <th> Customer ID </th>
                <th> Full name </th>
                <th> Phone number </th>
                <th> Address </th>
                <th> Status </th>
                <th> Delete </th>
                <th> Update </th>
            </tr>
            <% for (Customer x : lst) {%>
            <tr>
                <td><%= x.getCusID()%></td>
                <td><%= x.getCusName()%></td>
                <td> <%= x.getCusPhone()%></td>
                <td><%= x.getCusAddress()%></td>
                <td><%= x.getStatus()%></td>
                <td> <a href="customerController?action=delete&cusID=<%= x.getCusID()%>"> Delete  </td>  
                <td> <a href="updateCustomer.jsp?cusID=<%= x.getCusID()%>"> Update  </td>  
            </tr>
            <%}%>
        </table>

    </body>
</html>
