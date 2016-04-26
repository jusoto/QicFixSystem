<%-- 
    Document   : errorMessage
    Created on : Feb 7, 2016, 2:14:06 AM
    Author     : Juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <jsp:include page="WEB-INF/head/head.jsp" />
    </head>
    <body>
        <%=session.getAttribute("errorMessage")%>
        <jsp:include page="WEB-INF/footer/footer.jsp" />
    </body>
</html>
