<%--
    Document   : service
    Created on : Feb 6, 2016, 12:21:12 AM
    Author     : Juan
--%>

<%@page import="entity.ServiceType"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Serviceman"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<ServiceType> listServiceType = new ServiceType().selectAll();
    List<Serviceman> listServiceman = new Serviceman().selectAllServiceman();
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
                        <label>Service Type</label>
                    </td>
                    <td>
                        <select>
                            <%
                            for (int i=0; i<listServiceType.size(); i++){
                                %>
                                <option value="<%=listServiceType.get(i).getIdserviceType()%>"><%=listServiceType.get(i).getName()%></option>
                                <%
                            }
                            %>
                        </select>
                    </td>
                </tr>
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
                        <label>Position X</label>
                    </td>
                    <td>
                        <input type="text" name="positionX"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Position Y</label>
                    </td>
                    <td>
                        <input type="text" name="positionY"/>
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
                        <label>Serviceman</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table>
                        <%
                            for (int i=0; i<listServiceman.size(); i++){
                        %>
                        <tr>
                            <td>
                                <input type="checkbox" name="chkServiceman" value="<%=listServiceman.get(i).getIdserviceman()%>"/>
                            </td>
                            <td>
                                <label><%=listServiceman.get(i).getName()%></label>
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
