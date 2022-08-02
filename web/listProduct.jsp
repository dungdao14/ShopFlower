<%-- 
    Document   : listProduct
    Created on : Mar 13, 2022, 9:51:10 PM
    Author     : Dinh Nam
--%>

<%@page import="java.util.List"%>
<%@page import="model.ProductDAO"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ProductDAO u = new ProductDAO();
    List<Product> lst = u.getProductList();
%>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of products</title>
        <link rel="stylesheet" href="css/styleTable.css" type="text/css" />
    </head>
    <body>
        <h2> List of products </h2>
        <p><button onclick='window.location.href = "insertProduct.jsp"'>Insert a new product</button>
        <table style="width: 100%">
            <tr>
                <th> Product ID </th>
                <th> Name </th>
                <th> Quantity </th>
                <th> Price </th>
                <th> Image </th>
                <th> Category ID </th>
                <th> Delete </th>
                <th> Update </th>
            </tr>
            <% for (Product x : lst) {%>
            <tr>
                <td><%= x.getProID()%></td>
                <td> <%= x.getProName()%></td>
                <td><%= x.getQuantity()%></td>
                <td><%= x.getPrice()%></td>
                <!--<td><%= x.getImage()%></td>-->
                <td style="width: 100px;"><img src="<%= x.getImage()%>" style="width: 90px; height: 90px; object-fit: cover; border-radius: 5px;"/></td>
                <td><%= x.getCateID()%></td>
                <td> <a href="productController?action=delete&proID=<%= x.getProID()%>"> Delete  </td>  
                <td> <a href="updateProduct.jsp?proID=<%= x.getProID()%>"> Update  </td>  
            </tr>
            <%}%>
        </table>
    </body>
</html>