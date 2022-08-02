<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Admin Manager</title>

    <link href="https://fonts.googleapis.com/css2?family=Cookie&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700;800;900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="css/styleIndex.css" type="text/css" />
    <link rel="stylesheet" href="css/styleIndex2.css" type="text/css" />

</head>

<body>

    <jsp:include page="header.jsp"></jsp:include>

    <section class="product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-4">
                    <div class="section-title">
                        <h4>Manage</h4>
                    </div>
                </div>
                <div class="col-lg-8 col-md-8">
                    <ul class="filter__controls">
                        <li class="active" data-filter="">All</li>
                        <li data-filter=".pro">Product</li>
                        <li data-filter=".cus">Customer</li>
                        <li data-filter=".acc">Account</li>
                        <li data-filter=".bill">Bill</li>
                        <li data-filter=".bd">Bill Detail</li>
                        <li data-filter=".cate">Category</li>
                    </ul>
                </div>
            </div>
            <div class="row property__gallery">
                <div class="col-lg-12 mix pro">
                    <jsp:include page="listProduct.jsp"></jsp:include>
                </div>
                <div class="col-lg-12 mix cus">
                    <jsp:include page="listCustomer.jsp"></jsp:include>
                </div>
                <div class="col-lg-12 mix acc">
                    <jsp:include page="listAccount.jsp"></jsp:include>
                </div>
                <div class="col-lg-12 mix bill">
                    <jsp:include page="listBill.jsp"></jsp:include>
                </div>
                <div class="col-lg-12 mix bd">
                    <jsp:include page="listBillDetail.jsp"></jsp:include>
                </div>
                <div class="col-lg-12 mix cate">
                    <jsp:include page="listCategory.jsp"></jsp:include>
                </div>
            </div>
        </div>
    </section>

    <jsp:include page="footer.jsp"></jsp:include>

    <div class="search-model">
        <div class="h-100 d-flex align-items-center justify-content-center">
            <div class="search-close-switch">+</div>
            <form class="search-model-form">
                <input type="text" id="search-input" placeholder="Search here.....">
            </form>
        </div>
    </div>

    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/main.js"></script>
</body>

</html>