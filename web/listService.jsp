<%-- 
    Document   : listService
    Created on : Feb 8, 2016, 11:49:51 PM
    Author     : Juan
--%>

<%@page import="client.model.Service"%>
<%@page import="java.util.List"%>
<%@page import="client.controller.ControllerFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <table>
            <tr><td>Service ID</td><td>Pickup Address</td><td>Destination Address</td></tr>
            <%
                if (session.getAttribute("email") != null && session.getAttribute("token") != null) {
                    String email = session.getAttribute("email").toString();
                    String token = session.getAttribute("token").toString();
                    ControllerFacade controller = new ControllerFacade();
                    List<Service> list = controller.selectServices(email, token);
                    if (list != null) {
                        for (int i = 0; i < list.size(); i++) {
                            Service service = list.get(i);
                            Integer id = service.getId();
                            String pickupAddress = service.getStreetAddressPickup() + ", " + service.getCityPickup() + ", " + service.getStatePickup() + " " + service.getZipcodePickup();
                            String destinationAddress = service.getStreetAddressDestination() + ", " + service.getCityDestination() + ", " + service.getStateDestination() + " " + service.getZipcodeDestination();
            %>
            <tr>
                <td><div><%=id%></div></td><td><div><%=pickupAddress%></div></td><td><div><%=destinationAddress%></div></td>
            </tr>
            <%
                        }
                    }
                }
            %>
        </table>
        <jsp:include page="WEB-INF/footer/footer.jsp" />
    </body>
</html>
