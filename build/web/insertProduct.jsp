<%-- 
    Document   : insertProduct
    Created on : Mar 13, 2022, 10:24:45 PM
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
        <title>Insert a new product</title>
        <link rel="stylesheet" href="css/styleForm.css" type="text/css" />
    </head>
    <body>
        <h3>Insert a new product</h3>
        <form action="productController?action=insert" method="POST">
            <p>Product ID: <input type="text" name="proID" value=""/>

            <p>Name: <input type="text" name="proName" value=""/>

            <p>Quantity: <input type="text" name="quantity" value="" />

            <p>Price: <input type="text" name="price" value=""/>
            <p>Image: <input type="text" name="image" value=""/>
            <p>Category: 
                <select name="cateID">
                    <% for (Category x : lst) {%>
                    <option value="<%= x.getCateID()%>"> <%= x.getCateName()%> </option>
                    <% }%>
                </select>
            <p>
            <p><input type="submit" value="Insert"> 
        </form>  
    </body>
</html>