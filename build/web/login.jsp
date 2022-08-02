<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>

    <link rel="stylesheet" href="css/styleLogin.css">
</head>

<body>
        <div id="login-box">
            <div class="left">
                <form action="logController?action=login" method="POST">

                    <h1 class="h1-login">Login</h1>
                    <p class="text-danger">${mess}</p>
                    <input type="text" name="username" placeholder="USERNAME" required="" />
                    <input type="password" name="password" placeholder="PASSWORD" required="" />
                    <p class="checkbox"><input type="checkbox" name="remMe" value="remember" checked="checked" /> Remember me </p>
                    <input type="submit" class="register" value="Login">
                </form>
            </div>
            <div class="right">
                <span class="loginwith">Sign in<br />options</span>

                <a href="homeController"><button class="social-signin facebook">Home</button></a>
                <a href="login.jsp"><button class="social-signin twitter">Log in as administrator</button></a>
                <a href="register.jsp"><button class="social-signin google">Register</button></a>
            </div>
            <div class="or">OR</div>
        </div>
</body>

</html>