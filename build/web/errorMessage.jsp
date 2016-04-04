<%-- 
    Document   : errorMessage
    Created on : Feb 7, 2016, 2:14:06 AM
    Author     : Juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Error</h1>
        <p>${errorMessage}</p>
    </jsp:body>
</t:template>
