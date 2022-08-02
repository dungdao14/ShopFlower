<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Account"%>
<!DOCTYPE html>
<html lang="en">
    <%
        Account acc = (Account) request.getSession().getAttribute("currUser");
    %>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>

        <link rel="stylesheet" href="css/styleIndex.css">
    </head>

    <body>
        <header class="header">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xl-4 col-lg-3">
                        <div class="header__logo">
                            <a href="homeController"><img class="imglogo" src="img/logo-2.png" alt=""></a>
                        </div>
                    </div>
                    <div class="col-xl-5 col-lg-6">
                        <nav class="header__menu" style="padding-left: 20%">
                            <ul>
                                <li class=""><a href="homeController">Home</a></li>
                                <li><a href="homeController?action=listAll">Products</a></li>
                                <li><a href="#">Categories</a>
                                    <ul class="dropdown">
                                        <li><a href="homeController?action=listCate&cateID=WD">Wedding</a></li>
                                        <li><a href="homeController?action=listCate&cateID=CO">Congratulations</a></li>
                                        <li><a href="homeController?action=listCate&cateID=DE">Decoration</a></li>
                                        <li><a href="homeController?action=listCate&cateID=RO">Romance</a></li>
                                        <li><a href="homeController?action=listCate&cateID=AN">Anniversary</a></li>
                                    </ul>
                                </li>
                                <li><a href="#">Pages</a>
                                    <ul class="dropdown">
                                        <li><a href="showCart.jsp">Shop Cart</a></li>
                                        <li><a href="checkout.jsp">Checkout</a></li>
                                    </ul>
                                </li>
                                <c:if test="${sessionScope.currUser.role == 1}">
                                <li><a href="adminView.jsp">Admin Manager</a></li>
                                </c:if>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-lg-3">
                        <div class="header__right">
                            <% if (acc == null) { %>
                            <div class="header__right__auth">
                                <a href="login.jsp">Login</a>
                                <a href="register.jsp">Register</a>
                            </div>
                            <%} else {%>
                            <div class="header__right__auth">
                                <a><%= acc.getUsername()%></a>
                                <a href="logController?action=logout">Logout</a>
                            </div>
                            <%}%>
                            <ul class="header__right__widget">
                                <li><span class="icon_search search-switch"></span></li>
                                <li><a href="showCart.jsp"><span class="icon_bag_alt"></span>
                                    </a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="canvas__open">
                    <i class="fa fa-bars"></i>
                </div>
            </div>
        </header>
    </body>

</html>