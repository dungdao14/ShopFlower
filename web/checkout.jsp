<%@page import="model.Customer"%>
<%@page import="model.CustomerDAO"%>
<%@page import="model.Account"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="model.Product"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/styleCheckout.css">
    </head>

    <body>
        <%
            String sTotal = request.getParameter("total").trim();
            double total = Double.parseDouble(sTotal);
            if (total == 0) {
                response.sendRedirect("homeController");
            } else {
        %>
        <div class="container-fluid background">
            <div class="row padding-top-20">
                <div class="checkout-container">
                    <div class="col-12 col-sm-12 col-md-10 col-lg-10 col-xl-8 offset-md-1 offset-lg-1 offset-xl-2 padding-horizontal-40">
                        <div class="row">
                            <div class="col-12 main-wrapper">
                                <div class="row">
                                    <div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
                                        <div id="template" class="row panel-wrapper">
                                            <div class="col-12 panel-header basket-header">
                                                <div class="row">
                                                    <div class="col-6 basket-title">
                                                        <span class="description">review your</span><br><span class="emphasized">Cart Summary</span>
                                                    </div>
                                                    <div class="col-6 order-number align-right">
                                                        <span class="description"></span><br><span class="emphasized"></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-12 panel-body basket-body">
                                                <%
                                                    java.util.Enumeration en = session.getAttributeNames();
                                                    while (en.hasMoreElements()) {
                                                        String xProID = en.nextElement().toString();
                                                        if (!xProID.equals("currUser")) {
                                                            Product p = (Product) session.getAttribute(xProID);%>
                                                <!-- product -->
                                                <div class="row product">
                                                    <div class="col-2 product-image"><img src="<%= p.getImage()%>"></div>
                                                    <div class="col-4"><%= p.getProName()%><br><span class="additional"></span></div>
                                                    <div class="col-2 align-right"><span class="sub">Quantity: </span><%= p.getQuantity()%></div>
                                                    <div class="col-2 align-right"><span class="sub">Price: </span><%= p.getPrice()%></div>
                                                    <div class="col-2 align-right"><span class="sub">$ </span><%= p.getQuantity() * p.getPrice()%></div>
                                                </div>
                                                <!-- product -->
                                                <%
                                                        }
                                                    }
                                                %>
                                                <%
                                                    double amount = total * 1.1 + 5;
                                                    String sAmount = String.format("%.2f", amount);
                                                %>
                                            </div>
                                            <div class="col-12 panel-footer basket-footer">
                                                <hr>
                                                <div class="row">
                                                    <div class="col-8 align-right description">
                                                        <div class="dive">Subtotal</div>
                                                    </div>
                                                    <div class="col-4 align-right"><span class="emphasized">$ <%= total%></span></div>
                                                    <div class="col-8 align-right description">
                                                        <div class="dive">Taxes (0%)</div>
                                                    </div>
                                                    <div class="col-4 align-right"><span class="emphasized">$ <%= total * 0%></span></div>
                                                    <div class="col-8 align-right description">
                                                        <div class="dive">Shipping</div>
                                                    </div>
                                                    <div class="col-4 align-right"><span class="emphasized">Free</span></div>
                                                </div>
                                                <hr>
                                                <div class="row">
                                                    <div class="col-8 align-right description">
                                                        <div class="dive">Total</div>
                                                    </div>
                                                    <div class="col-4 align-right"><span class="very emphasized">$ <%= total%></span></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
                                        <div class="row panel-wrapper">
                                            <div class="col-12 panel-header creditcard-header">
                                                <div class="row">
                                                    <div class="col-12 creditcard-title">
                                                        <span class="description">please check your</span><br><span class="emphasized">Pay Information</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-12 panel-body creditcard-body">
                                                <%
                                                    Date date = new Date();
                                                    DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
                                                    String xDate = dateFormat.format(date);
                                                    Account acc = (Account) session.getAttribute("currUser");
//                                                    Account acc = null;
                                                    String xCusName = "", xCusPhone = "", xCusAddress = "";
                                                    if (acc != null) {
                                                        CustomerDAO u = new CustomerDAO();
                                                        Customer x = u.getCustomer(acc.getCusID());
                                                        xCusName = x.getCusName();
                                                        xCusPhone = x.getCusPhone();
                                                        xCusAddress = x.getCusAddress();
                                                    }
                                                %>
                                                <form action="checkout" method="post">
                                                    <fieldset>
                                                        <label>Full name</label><br>
                                                        <i class="fa fa-user-o" aria-hidden="true"></i><input type='text' name='cusName' value='<%= xCusName%>'>
                                                    </fieldset>
                                                    <fieldset>
                                                        <label>Phone number</label><br>
                                                        <i class="fa fa-credit-card" aria-hidden="true"></i><input type='text' name='cusPhone' value='<%= xCusPhone%>'>
                                                    </fieldset>
                                                    <fieldset>
                                                        <label>Address</label><br>
                                                        <i class="fa fa-credit-card" aria-hidden="true"></i><input type='text' name='cusAddress' value='<%= xCusAddress%>'>
                                                    </fieldset>
                                                    <fieldset>
                                                        <label>Expiration Date</label><br>
                                                        <i class="fa fa-calendar" aria-hidden="true"></i><input type='text' name='dateCreate' value="<%= xDate%>" class="card-expiration">
                                                    </fieldset>
                                            </div>
                                            <div class="col-6 panel-footer creditcard-footer">
                                                <div class="row">
                                                    <div class="col-12 align-right">
                                                        <a href="checkout"><button class="confirm" style="margin-right: 30px; margin-top: -20px; width: 160px;">Confirm & Pay</button></a>
                                                    </div>
                                                </div>
                                            </div>
                                                </form>
                                            <div class="col-6 panel-footer creditcard-footer">
                                                <div class="row">
                                                    <div class="col-12 align-left">
                                                        <a href="homeController"><button class="cancel" style="margin-left: 30px; margin-top: -20px; width: 160px;">Cancel</button></a>&nbsp;
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%}%>
    </body>

</html>