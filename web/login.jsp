<%-- 
    Document   : login
    Created on : Feb 5, 2016, 12:13:35 AM
    Author     : Juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <jsp:include page="WEB-INF/head/head.jsp" />
    </head>

    <body>
        <div class="login-card"><img src="assets/img/avatar_2x.png" class="profile-img-card">
            <p class="profile-name-card"> </p>
            <form class="form-signin" name="login_form" action="login" method="POST"><span class="reauth-email"> </span>
                <input name="user" class="form-control" type="email" required placeholder="Email address" autofocus id="inputEmail">
                <input name="pass" class="form-control" type="password" required placeholder="Password" id="inputPassword">
                <div class="checkbox">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox">Remember me</label>
                    </div>
                </div>
                <button class="btn btn-primary btn-block btn-lg btn-signin" type="submit">Sign in</button>
            </form><a href="#" class="forgot-password">Forgot your password?</a></div>
            <div class="login-card">
                <div>
                <form class="form-signin" name="register_client_form" action="registerClient.jsp" method="POST">
                    <button class="btn btn-primary btn-block btn-lg btn-signin" type="submit">Register Client</button>
                </form>
                </div>
                <div>
                <form class="form-signin" name="register_tower_form" action="registerTower.jsp" method="POST">
                    <button class="btn btn-primary btn-block btn-lg btn-signin" type="submit">Register Tower</button>
                </form>
                </div>
            </div>
        <div>Login tries count: <%=session.getAttribute("errorCount")%></div>
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    </body>

</html>