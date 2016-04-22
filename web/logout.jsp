<%-- 
    Document   : logout
    Created on : Feb 6, 2016, 11:14:58 PM
    Author     : Juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.invalidate();
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", "login.jsp");
%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="WEB-INF/head/head.jsp" />
    </head>
    <body>
        <h1>Session Logout</h1>
    </body>
</html>
