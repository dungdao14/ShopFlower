<%-- 
    Document   : updateBill
    Created on : Mar 14, 2022, 1:56:43 AM
    Author     : Dinh Nam
--%>

<%@page import="model.Bill"%>
<%@page import="model.CustomerDAO"%>
<%@page import="model.BillDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/styleForm.css" type="text/css" />
    </head>
    <body>
        <%!
            BillDAO u;
            Bill x;
            String sOrderID;
            int xOrderID;
        %>
        <%
            u = new BillDAO();
            sOrderID = request.getParameter("orderID");
            if (sOrderID == null || sOrderID.trim().equals("")) {
                response.sendRedirect("adminView.jsp");
                return;
            }
            xOrderID = Integer.parseInt(sOrderID);
            x = u.getBill(xOrderID);
            if (x == null) {
                response.sendRedirect("adminView.jsp");
                return;
            }

        %>    
        <h3>Update a bill</h3>
        <form action="billController?action=update" method="POST"> 
            <p>Order ID: <input type="text" name="orderID" value="<%= x.getOrderID()%>" readonly="true"/> 
            <p>Date Create: <input type="Date" name="dateCreate" value="<%= x.getDateCreate()%>" readonly="true"/> 
            <p>Customer name: <input type="text" value="<%= x.getCusName()%>" name="cusName"/>
            <p>Phone number: <input type="text" value="<%= x.getCusPhone()%>" name="cusPhone"/>
            <p>Address: <input type="text" name="cusAddress" value="<%=x.getCusAddress()%>"/>
            <p>Total: <input type="text" name="total" value="<%= x.getTotal()%>" readonly="true"/>
            <p>Customer ID: <input type="text" name="cusID" value="<%= x.getCusID()%>" readonly="true"/>
            <p>Voucher: <input type="text" name="vouID" value="<%= x.getVouID() %>"/>
            <p> <input type="submit" value="Update"/>
        </form>
        <button onclick='window.location.href = "adminView.jsp"'>Cancel</button>
    </body>
</html>
