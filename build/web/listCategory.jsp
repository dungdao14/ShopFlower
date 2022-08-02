<%-- 
    Document   : listCategory
    Created on : Mar 14, 2022, 2:44:33 AM
    Author     : Dinh Nam
--%>

<%@page import="model.Category"%>
<%@page import="java.util.List"%>
<%@page import="model.CategoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    CategoryDAO u = new CategoryDAO();
    List<Category> lst = u.getCategoryList();
%>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of categories</title>
        <link rel="stylesheet" href="css/styleTable.css" type="text/css" />
    </head>
    <body>
        <h2> List of categories </h2>
        <table style="width: 100%;">
            <tr>
                <th> Category ID </th>
                <th> Name </th>
            </tr>
            <% for (Category x : lst) {%>
            <tr>
                <td><%= x.getCateID()%></td>
                <td><%= x.getCateName()%></td>
               <!--<td> <a href="delete?id=<%= x.getCateID()%>"> Delete  </td>-->  
               <!--<td> <a href="updateCar.jsp?id=<%= x.getCateID()%>"> Update  </td>-->  
            </tr>
            <%}%>
        </table>
    </body>
</html>
