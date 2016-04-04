<%-- 
    Document   : register
    Created on : Feb 5, 2016, 12:14:12 AM
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
        <h1>Register Customer</h1>
        <form action="createCustomer" method="POST">
        <table>
            <tr>
                <td>
                    <label for="name">Name</label>
                </td>
                <td>
                    <input type="text" name="name">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="email">Email</label>
                </td>
                <td>
                    <input type="text" name="email"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="password">Password</label>
                </td>
                <td>
                    <input type="text" name="password"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="address">Address</label>
                </td>
                <td>
                    <input type="text" name="address"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="dob">DOB</label>
                </td>
                <td>
                    <input type="text" name="dob"/>
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
