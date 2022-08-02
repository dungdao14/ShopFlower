<%-- 
    Document   : updateCustomer
    Created on : Mar 14, 2022, 1:32:37 AM
    Author     : Dinh Nam
--%>

<%@page import="model.Customer"%>
<%@page import="model.CustomerDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update a customer</title>
        <link rel="stylesheet" href="css/styleForm.css" type="text/css" />
    </head>
    <body>
        <%!
            CustomerDAO u;
            Customer x;
            String xCusID;
            int sCusID;
        %>
        <%
            u = new CustomerDAO();
            xCusID = request.getParameter("cusID");
            if (xCusID == null || xCusID.trim().equals("")) {
                response.sendRedirect("listCustomer.jsp");
                return;
            }
            sCusID = Integer.parseInt(xCusID);
            x = u.getCustomer(sCusID);
            if (x == null) {
                response.sendRedirect("listCustomer.jsp");
                return;
            }
        %>    
        <h3>Update a customer</h3>
        <form action="customerController?action=update" method="POST"> 
            <p>Customer ID: <input type="text" name="cusID" value="<%= x.getCusID()%>" readonly="true"/>
            <p>Name: <input type="text" name="cusName" value="<%= x.getCusName()%>" />
            <p>Phone number: <input type="text" name="cusPhone" value="<%= x.getCusPhone()%>"/>
            <p>Address: <input type="text" name="cusAddress" value="<%=x.getCusAddress()%>"/>
            <p>Status:
                <select name="status">
                    <option>0</option> 
                    <option>1</option> 
                </select>
            <p> <input type="submit" value="Update"/>
        </form>
        <button onclick='window.location.href = "adminView.jsp"'>Cancel</button>
    </body>
</html>
