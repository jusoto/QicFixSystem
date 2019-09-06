<%-- 
    Document   : forgot
    Created on : Apr 20, 2016, 7:10:02 PM
    Author     : Juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="WEB-INF/head/head.jsp" />
    </head>
    <body>
        <jsp:include page="WEB-INF/menu/menu.jsp" />
        <h1>Forgot</h1>
        <form action="index.jsp" method="POST">
        <div>Email: <input type="text" name="email"/></div>
        <input type="submit"/>
        </form>
        <jsp:include page="WEB-INF/footer/footer.jsp" />
    </body>
</html>
