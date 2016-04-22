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
        if (errorCount >= 5) {
            controller.blockAccount(session.getAttribute("errorAccount").toString());
            session.setAttribute("error_message", "Too many login fails.");
            response.setHeader("Location", "error.jsp");
        }
    }

    if ((request.getParameter("user") != null) && (request.getParameter("pass") != null)) {

        String email = request.getParameter("user").toString();
        String pass = request.getParameter("pass").toString();
        String token = null;

        try {
            token = controller.login(email, pass);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        if (token != null) {
            User user = controller.selectUserByEmail(token, email);
            session.setAttribute("email", email);
            session.setAttribute("name", user.getFname() + " " + user.getLname());
            if (user != null && user.getUserTypeId() == 1) {
                Client client = controller.selectClientByEmail(token, email);
                //TODO Load Menu for Application List
                session.setAttribute("client_id", client.getId());
            }
            if (user != null && user.getUserTypeId() == 2) {
                Tower tower = controller.selectTowerByEmail(token, email);
                //TODO Load Menu for Application List
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
        <jsp:include page="WEB-INF/head/head.jsp" />
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