<%-- 
    Document   : insertAccount
    Created on : Mar 13, 2022, 11:13:59 PM
    Author     : Dinh Nam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Account</title>
        <link rel="stylesheet" href="css/styleForm.css" type="text/css" />
    </head>
    <body>
        <h1>Insert Account</h1>
        <form action="accountController?action=insert" method="POST">
            <p>Username: <input type="text" name="username" value=""/>
            <p>Password: <input type="text" name="password" value=""/>
            <p>Role: <input type="text" name="role" value=""/>
            <p>Customer ID: <input type="text" name="cusID" value=""/>
            <p><input type="submit" value="Insert"> 
        </form>  
    </body>
</html>