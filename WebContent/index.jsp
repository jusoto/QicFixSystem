<%-- 
    Document   : index
    Created on : Feb 4, 2016, 11:25:52 PM
    Author     : Juan
--%>

<%@page import="client.model.Service"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //Authenticator authenticator = Authenticator.getInstance();
    Integer userTypeId;
    userTypeId = 0;
    if (session.getAttribute("email") == null) {
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", "login.jsp");
    } else {
        if (session.getAttribute("userTypeId") != null) {
            userTypeId = (Integer) session.getAttribute("userTypeId");
        }
%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="WEB-INF/head/head.jsp" />
        <style>
            table, th, td {
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <jsp:include page="WEB-INF/menu/menu.jsp" />
        <div><%=session.getAttribute("indexMessage") != null ? session.getAttribute("indexMessage") : ""%></div>
        <%if (userTypeId == 1) {%>
        <h4>Ask for service</h4>
        <div>
            <form action="requestService.jsp" method="POST">
                <input type="submit" id="btnTowService" value="Request New Tow Service" />
            </form>
        </div>
        <div>
            <h4>Active Services</h4>
            <div>

                <%if (session.getAttribute("activeServicesClient") != null) {
                        try {
                            List<Service> list = (List<Service>) session.getAttribute("activeServicesClient");
                            if (list != null) {
                %>
                <table>
                    <tr><td>ID</td><td>Pickup Address</td><td>Destination Address</td></tr>
                    <%
                        for (int i = 0; i < list.size(); i++) {
                            Service service = list.get(i);
                            Integer id = service.getId();
                            String pickupAddress = service.getStreetAddressPickup() + ", " + service.getCityPickup() + ", " + service.getStatePickup() + " " + service.getZipcodePickup();
                            String destinationAddress = service.getStreetAddressDestination() + ", " + service.getCityDestination() + ", " + service.getStateDestination() + " " + service.getZipcodeDestination();
                    %>
                    <tr>
                        <td><div>Service ID: <%=id%></div></td><td><div>Pickup: <%=pickupAddress%></div></td><td><div>Destination: <%=destinationAddress%></div></td>
                    </tr>
                    <%
                        }%>
                </table>
                <%}
                        } catch (Exception e) {
                            e.printStackTrace();
                                        }
                                    }%>
            </div>
        </div>
        <%}
            if (userTypeId == 2) {%>
        <h4>Search for a New Service</h4>
        <div>
            <form action="listAvailableService.jsp" method="POST">
                <input type="submit" id="btnTowService" value="Display Available Services" />
            </form>
        </div>
        <div>
            <h4>Active Services</h4>
            <div><%=session.getAttribute("activeServicesTower") != null ? session.getAttribute("activeServicesTower") : ""%></div>
        </div>
        <%}%>
        <jsp:include page="WEB-INF/footer/footer.jsp" />
    </body>
</html>
<%
        session.setAttribute("indexMessage", "");
    }
%>
