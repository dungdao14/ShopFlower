<%-- 
    Document   : addToCart
    Created on : Mar 14, 2022, 9:55:16 PM
    Author     : Dinh Nam
--%>

<%@page import="model.Product"%>
<%@page import="model.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <body>
        <%
            String xProID = request.getParameter("proID");
            Object value = session.getAttribute(xProID);
            ProductDAO u = new ProductDAO();
            Product x = u.getProduct(xProID);
            Product p = (Product) session.getAttribute(xProID);
            if (value == null) {
                p = new Product(x.getProID(), x.getProName(), 1, x.getPrice(), x.getImage(), x.getCateID());
                session.setAttribute(xProID, p);
            } else {
                p.setQuantity(p.getQuantity() + 1);
                session.setAttribute(xProID, p);
            }
            response.sendRedirect("showCart.jsp");
        %>
    </body>
</html>
