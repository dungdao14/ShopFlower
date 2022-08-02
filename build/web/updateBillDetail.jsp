<%-- 
    Document   : updateBillDetail
    Created on : Mar 14, 2022, 2:25:24 AM
    Author     : Dinh Nam
--%>

<%@page import="model.BillDetail"%>
<%@page import="model.BillDetailDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update a bill</title>
        <link rel="stylesheet" href="css/styleForm.css" type="text/css" />
    </head>
    <body>
        <%!
            BillDetailDAO u;
            BillDetail x;
        %>
        <%
            u = new BillDetailDAO();
            String xProID = request.getParameter("proID");
            if (xProID == null || xProID.trim().equals("")) {
                response.sendRedirect("adminView.jsp");
                return;
            }
            String sOrderID = request.getParameter("orderID");
            if (sOrderID == null || sOrderID.trim().equals("")) {
                response.sendRedirect("adminView.jsp");
                return;
            }
            int xOrderID = Integer.parseInt(sOrderID);
            x = u.getBillDetail(xProID, xOrderID);
            if (x == null) {
                response.sendRedirect("adminView.jsp");
                return;
            }

        %>    
        <h3>Update a bill detail</h3>
        <form action="billDetailController?action=update" method="POST"> 
            <p>Product ID: <input type="text" name="proID" value="<%= x.getProID()%>" readonly="true"/>
            <p>Order ID: <input type="text" name="orderID" value="<%= x.getOrderID()%>" readonly="true"/> 
            <p>Quantity: <input type="text" name="quantity" value="<%= x.getQuantity()%>"/>
            <p>Price: <input type="text" name="price" value="<%= x.getPrice()%>" readonly="true"/>
            <p>Amount: <input type="text" name="amount" value="<%= x.getAmount() %>"/>

            <p> <input type="submit" value="Update"/>
        </form>
        <button onclick='window.location.href = "adminView.jsp"'>Cancel</button>
    </body>
</html>