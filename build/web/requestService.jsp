<%--
    Document   : service
    Created on : Feb 6, 2016, 12:21:12 AM
    Author     : Juan
--%>

<%@page import="entity.Tower"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Tower> listTower = new Tower().selectAll();
%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="WEB-INF/head/head.jsp" />
    </head>
    <body>
        <jsp:include page="WEB-INF/menu/menu.jsp" />
        <h1>Detail of service</h1>
        <form name="requestServiceForm" action="serviceStatus.jsp" method="POST">
            <table>
                <tr>
                    <td>
                        <label>Id Customer</label>
                    </td>
                    <td>
                        <input type="text" name="idcustomer" value="<%=session.getAttribute("idcustomer")%>"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Start Date</label>
                    </td>
                    <td>
                        <input type="text" name="startDate"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Address</label>
                    </td>
                    <td>
                        <input type="text" name="street_address"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>City</label>
                    </td>
                    <td>
                        <input type="text" name="city"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>State</label>
                    </td>
                    <td>
                        <input type="text" name="state"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Zip code</label>
                    </td>
                    <td>
                        <input type="text" name="zipcode"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Address</label>
                    </td>
                    <td>
                        <input type="text" name="address"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Description</label>
                    </td>
                    <td>
                        <input type="text" name="customerDescription"/>
                    </td>
                </tr>
                <tr>
                    <td>
                <tr>
                    <td>
                        <label>Tower</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table>
                        <%
                            for (int i=0; i<listTower.size(); i++){
                        %>
                        <tr>
                            <td>
                                <input type="checkbox" name="chkTower" value="<%=listTower.get(i).getId()%>"/>
                            </td>
                            <td>
                                <label><%=listTower.get(i).getFname()%></label>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="btnRequestService" value="Request Service"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
