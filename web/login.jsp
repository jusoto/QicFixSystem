<%-- 
    Document   : login
    Created on : Feb 5, 2016, 12:13:35 AM
    Author     : Juan
--%>

<%@page import="entity.Client"%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Integer errorCount = 0;
    if((request.getParameter("user")!=null) && (request.getParameter("pass")!=null)){
        
        User user = new User();
        Client client = new Client();
        String email = request.getParameter("user").toString();
        String pass = request.getParameter("pass").toString();
        Integer idclient = 0;
        
        if (session.getAttribute("errorCount")!=null){
            errorCount = Integer.parseInt(session.getAttribute("errorCount").toString());
        }

        if(user.validateUser(email, pass)){
            client.setEmail(email);
            client.selectIdByEmail();
            session.setAttribute("email", email);
            session.setAttribute("name", user.getName());
            session.setAttribute("idclient", client.getIdclient());
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "index.jsp");
        }else{
            errorCount++;            
            session.setAttribute("errorCount", errorCount);
        }
    }
            
%>


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
        