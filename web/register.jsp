<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>

    <link rel="stylesheet" href="css/styleLogin.css">
</head>

<body>
    <div id="login-box">
        <div class="left">
            <form action="logController?action=register" method="POST">

                <h1>Register</h1>

                <input id="name" type="text" name="cusName" placeholder="FULL NAME" required="" />
                <input id="phone" type="text" name="cusPhone" placeholder="PHONE" required="" />
                <input id="address" type="text" name="cusAddress" placeholder="ADDRESS" required="" />
                <input id="user" type="text" name="username" placeholder="USERNAME" required="" />
                <input id="password1" type="password" name="password" placeholder="PASSWORD" id="password1" required="" />
                <input id="password2" type="password" name="Confirm password" placeholder="CONFIRM PASSWORD" id="password2" required="" />
                <input type="submit" class="register" value="REGISTER">
            </form>

            <script type="text/javascript">
                window.onload = function() {
                    document.getElementById("password1").onchange = validatePassword;
                    document.getElementById("password2").onchange = validatePassword;
                }

                function validatePassword() {
                    var pass2 = document.getElementById("password2").value;
                    var pass1 = document.getElementById("password1").value;
                    if (pass1 != pass2)
                        document.getElementById("password2").setCustomValidity("Passwords Don't Match");
                    else
                        document.getElementById("password2").setCustomValidity('');
                    //empty string means no validation error
                }
            </script>
        </div>
        <div class="right">
            <span class="loginwith">Sign in<br />options</span>

            <a href="homeController"><button class="social-signin facebook">Home</button></a>
            <a href="login.jsp"><button class="social-signin twitter">Log in as customer</button></a>
            <a href="login.jsp"><button class="social-signin google">Login as administrator</button></a>
        </div>
        <div class="or">OR</div>
    </div>
</body>

</html>