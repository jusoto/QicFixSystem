<%-- 
    Document   : registerServiceman
    Created on : Feb 7, 2016, 1:17:16 AM
    Author     : Juan
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="WEB-INF/head/head.jsp" />
    </head>
    <body>
        <jsp:include page="WEB-INF/menu/menu.jsp" />
        <h1>Register Serviceman</h1>
        <form action="createServiceman" method="POST">
        <table>
            <tr>
                <td>
                    <label for="name">Name</label>
                </td>
                <td>
                    <intput type="text" name="name"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="email">Email</label>
                </td>
                <td>
                    <intput type="text" name="email"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="password">Password</label>
                </td>
                <td>
                    <intput type="text" name="password"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="address">Address</label>
                </td>
                <td>
                    <intput type="text" name="address"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="dob">DOB</label>
                </td>
                <td>
                    <intput type="text" name="dob"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <span><input type="submit" value="Create Customer"/></span>
                    <span><input type="button" value="Cancel"/></span>
                </td>
            </tr>
        </table>
        </form>
        <jsp:include page="WEB-INF/footer/footer.jsp" />
    </body>
</html>
