<%-- 
    Document   : updateProduct
    Created on : Mar 13, 2022, 10:09:14 PM
    Author     : Dinh Nam
--%>

<%@page import="model.Category"%>
<%@page import="java.util.List"%>
<%@page import="model.Product"%>
<%@page import="model.CategoryDAO"%>
<%@page import="model.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update a product</title>
        <link rel="stylesheet" href="css/styleForm.css" type="text/css" />
    </head>
    <body>
        <%!
            ProductDAO u;
            CategoryDAO v;
            Product x;
            String xProID;
            List<Category> proLst;
        %>
        <%
            u = new ProductDAO();
            xProID = request.getParameter("proID");
            if (xProID == null || xProID.trim().equals("")) {
                response.sendRedirect("adminView.jsp");
                return;
            }
            x = u.getProduct(xProID);
            if (x == null) {
                response.sendRedirect("adminView.jsp");
                return;
            }
            v = new CategoryDAO();
            proLst = v.getCategoryList();
        %>    
        <h3>Update a product</h3>
        <form action="productController?action=update" method="POST"> 
            <p>Product ID: <input type="text" name="proID" value="<%= x.getProID()%>" readonly="true"/>
            <p>Name: <input type="text" name="proName" value="<%= x.getProName()%>" /> 
            <p>Quantity: <input type="text" value="<%= x.getQuantity()%>" name="quantity"/>
            <p> Price: <input type="text" name="price" value="<%=x.getPrice()%>"/>
            <p> Image: <input type="text" name="image" value="<%= x.getImage()%>"/>
            <p>Category: 
                <select name="cateID">
                    <% for (Category y : proLst) { %>
                    <option 
                        <% if (y.getCateID().equals(x.getCateID())) { %>
                        selected="selected"
                        <%}%>
                        value="<%= y.getCateID()%>"> <%= y.getCateName()%> </option>
                    <%}%>
                </select>

            <p> <input type="submit" value="Update"/>
        </form>
        <button onclick='window.location.href = "adminView.jsp"'>Cancel</button>
    </body>
</html>
