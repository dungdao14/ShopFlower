<%-- 
    Document   : insertCustomer
    Created on : Mar 14, 2022, 1:36:20 AM
    Author     : Dinh Nam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert a new customer</title>
        <link rel="stylesheet" href="css/styleForm.css" type="text/css" />
    </head>
    <body>
        <h1>Insert a new customer</h1>
        <form action="customerController?action=insert" method="POST">
            <p>Name: <input type="text" name="cusName" value="" />
            <p>Phone number: <input type="text" name="cusPhone" value=""/>
            <p>Address: <input type="text" name="cusAddress" value=""/>
            <p>Status:
                <select name="status">
                    <option>0</option> 
                    <option>1</option> 
                </select>
            <input type="submit" value="Insert"> 
        </form>  
    </body>
</html>
