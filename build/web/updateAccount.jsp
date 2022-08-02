<%-- 
    Document   : updateAccount
    Created on : Mar 14, 2022, 1:10:33 AM
    Author     : Dinh Nam
--%>

<%@page import="model.Account"%>
<%@page import="model.AccountDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>Update a account</title>
     <link rel="stylesheet" href="css/styleForm.css" type="text/css" />
  </head>
  <body>
    <%!
      AccountDAO u;
      Account x;
      String xAccID;
      int sAccID;
    %>
    <%
      u = new AccountDAO();
      xAccID = request.getParameter("accID");
      if(xAccID == null || xAccID.trim().equals("")) {
         response.sendRedirect("adminView.jsp");
         return;
      }
      sAccID = Integer.parseInt(xAccID);
      x = u.getAccount(sAccID);
      if(x==null) {
         response.sendRedirect("adminView.jsp");
         return;
      }
     %>    
      <h3>Update a account</h3>
      <form action="accountController?action=update" method="POST"> 
        <p>Account ID: <input type="text" name="accID" value="<%= x.getAccID() %>" readonly="true"/> 
          <p>Username: <input type="text" name="username" value="<%= x.getUsername() %>"/>
          <p>Password: <input type="text" name="password" value="<%= x.getPassword() %>"/>
          <p>Role: <input type="text" name="role" value="<%= x.getRole() %>" readonly="true"/>
          <p>Customer ID: <input type="text" name="cusID" value="<%= x.getCusID() %>" readonly="true"/>
       
          <p> <input type="submit" value="Update"/>
      </form>
      <button onclick='window.location.href="adminView.jsp"'>Cancel</button>
  </body>
</html>