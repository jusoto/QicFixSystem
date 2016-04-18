<%-- 
    Document   : login
    Created on : Feb 5, 2016, 12:13:35 AM
    Author     : Juan
--%>

<%@page import="client.model.Client"%>
<%@page import="client.model.User"%>
<%@page import="client.model.Tower"%>
<%@page import="client.controller.ControllerFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ControllerFacade controller = new ControllerFacade();
    Integer errorCount = 0;
    
    if (session.getAttribute("errorCount") != null) {
        errorCount = Integer.parseInt(session.getAttribute("errorCount").toString());
        if(errorCount>=5){
            controller.blockAccount(session.getAttribute("errorAccount").toString());
            session.setAttribute("error_message", "Too many login fails.");
            response.setHeader("Location", "error.jsp");
        }
    }
    
    if ((request.getParameter("user") != null) && (request.getParameter("pass") != null)) {

        
        String email = request.getParameter("user").toString();
        String pass = request.getParameter("pass").toString();

        String token = controller.login(email, pass);

        if (token != null) {
            User user = new User();
            user.setEmail(email);
            user.selectByEmail(token, email);
            session.setAttribute("email", email);
            session.setAttribute("name", user.getFname() + " " + user.getLname());
            if(user.getUserTypeId()==1){
                Client client = new Client();
                client.setEmail(email);
                client = client.selectByEmailClient(token);
                session.setAttribute("client_id", client.getId());
            }
            if(user.getUserTypeId()==2){
                Tower tower = new Tower();
                tower.setEmail(email);
                tower = tower.selectByEmailTower(token);
                session.setAttribute("tower_id", tower.getId());
            }
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "index.jsp");
        } else {
            errorCount++;
            session.setAttribute("errorCount", errorCount);
            session.setAttribute("errorAccount", email);
        }
    }

%>


<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    <link rel="stylesheet" href="assets/css/Google-Style-Login.css">
</head>

<body>
    <div class="login-card"><img src="assets/img/avatar_2x.png" class="profile-img-card">
        <p class="profile-name-card"> </p>
        <form class="form-signin" name="login_form" action="login.jsp" method="POST"><span class="reauth-email"> </span>
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
        <div>Login tries count: <%=errorCount%></div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>

<!--
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login Form</h1>
        <form name="login_form" action="login.jsp" method="POST">
            <table>
                <tr><td><span>Email:</span></td><td><span><input name="user" type="text" alt="email address" /></span></td></tr>
                <tr><td><span>Password:</span></td><td><span><input name="pass" type="password" alt="password" /></span></td></tr>
                <tr><td colspan="2" style="text-align: center"><input type="submit" name="btnLogin" value="Login" /></td></tr>
                <tr><td>Login tries count: <%=errorCount%></td></tr>
            </table>
        </form>
    </body>
</html>
-->
