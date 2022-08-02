<%-- 
    Document   : addToCart
    Created on : Mar 14, 2022, 8:22:18 PM
    Author     : Dinh Nam
--%>

<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cart</title>

        <link href="https://fonts.googleapis.com/css2?family=Cookie&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700;800;900&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>

    <body>

        <jsp:include page="header.jsp"></jsp:include>

            <p></p>
            <div class="shopping-cart">
                <div class="px-4 px-lg-0">

                    <div class="pb-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                                    <!-- Shopping cart table -->
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="p-2 px-3 text-uppercase">Product</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Price</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Quantity</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Delete</div>
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <%
                                                java.util.Enumeration en = session.getAttributeNames();
                                                double total = 0;
                                                while (en.hasMoreElements()) {
                                                    String xProID = en.nextElement().toString();
                                                    if (!xProID.equals("currUser")) {
                                                        Product p = (Product) session.getAttribute(xProID);%>
                                            <tr>
                                                <th scope="row">
                                                    <div class="p-2">
                                                        <img src="<%= p.getImage()%>" alt="" style="width: 70px; height: 90px;; object-fit: cover;" class="img-fluid rounded shadow-sm">
                                                        <div class="ml-3 d-inline-block align-middle">
                                                            <h5 class="mb-0"> <a href="#" class="text-dark d-inline-block"><%= p.getProName()%></a></h5><span class="text-muted font-weight-normal font-italic"></span>
                                                        </div>
                                                    </div>
                                                </th>
                                                <td class="align-middle"><strong><%= p.getPrice()%></strong></td>
                                                <td class="align-middle">
                                                    <a href="checkCart?action=sub&proID=<%= p.getProID()%>"><button class="btnSub" style="border: none; margin-right: 5px;"> - </button></a>
                                                    <strong>  <%= p.getQuantity()%>  </strong>
                                                    <a href="checkCart?action=add&proID=<%= p.getProID()%>"><button class="btnAdd" style="border: none; margin-left: 5px;"> + </button></a>
                                                </td>
                                                <td class="align-middle">
                                                    <a href="checkCart?action=delete&proID=<%= p.getProID()%>" class="text-dark">
                                                        <button type="button" class="btn btn-danger" style="font-weight: bold;">Delete</button>
                                                    </a>
                                                </td>
                                            </tr>
                                            <%
                                                        total += p.getPrice() * p.getQuantity();
                                                    }
                                                }
                                            %>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- End -->
                            </div>
                        </div>

                        <div class="row py-5 p-4 bg-white rounded shadow-sm">
                            <div class="col-lg-6">
                                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Voucher</div>
                                <div class="p-4">
                                    <div class="input-group mb-4 border rounded-pill p-2">
                                        <input type="text" placeholder="Enter Voucher" aria-describedby="button-addon3" class="form-control border-0" name="vouID">
                                        <div class="input-group-append border-0">
                                            <button id="button-addon3" type="button" class="btn px-4 rounded-pill" style="background-color: #ffbfa7; font-weight: bold;"><i class="fa fa-gift mr-2"></i>Use</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%
                                double amount = 0;
                                if (total != 0) {
                                    amount = total * 1.1 + 5;
                                }
                                String sAmount = String.format("%.2f", amount);
                            %>
                            <div class="col-lg-6">
                                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Bill</div>
                                <div class="p-4">
                                    <ul class="list-unstyled mb-4">
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Subtotal</strong><strong>$ <%= total%></strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Shipping</strong><strong>Free</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">VAT (0%)</strong><strong>$ <%= total * 0%></strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Total</strong>
                                            <h5 class="font-weight-bold">$ <%= total%></h5>
                                        </li>
                                    </ul>
                                    <div>
                                        <a href="homeController" class="btn rounded-pill py-2" style="width: 190px; background-color: #ffbfa7; font-weight: bold; float: left;">Continue shopping</a>
                                        <a href="checkout.jsp?total=<%= total%>" class="btn rounded-pill py-2" style="width: 190px; background-color: #ffbfa7; font-weight: bold; float: right;">checkout</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>

</html>