<%-- 
    Document   : listAccount
    Created on : Mar 13, 2022, 10:51:22 PM
    Author     : Dinh Nam
--%>

<%@page import="model.Account"%>
<%@page import="java.util.List"%>
<%@page import="model.AccountDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    AccountDAO u = new AccountDAO();
    List<Account> lst = u.getAccountList();
%>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Account</title>
        <link rel="stylesheet" href="css/styleTable.css" type="text/css" />
    </head>
    <body>
        <h2> List of accounts </h2> 
        <p style="margin-top: 50px;"><button onclick='window.location.href="insertAccount.jsp"'>Insert a new account</button>
            
        <table style="width: 100%;">
            <tr>
                <th> Account ID </th>
                <th> Username </th>
                <th> Password </th>
                <th> Role </th>
                <th> Customer ID </th>
                <th> Delete </th>
                <th> Update </th>
            </tr>
            <% for (Account x : lst) {%>
            <tr>
                <td><%= x.getAccID() %></td>
                <td><%= x.getUsername()%></td>
                <td><%= x.getPassword()%></td>
                <td><%= x.getRole() %></td>
                <td><%= x.getCusID() %></td>
               <td> <a href="accountController?action=delete&accID=<%= x.getAccID() %>"> Delete  </td>  
               <td> <a href="updateAccount.jsp?accID=<%= x.getAccID() %>"> Update  </td>  
            </tr>
            <%}%>
        </table>
            
    </body>
</html>
