<%-- 
    Document   : serviceStatus
    Created on : Feb 7, 2016, 1:12:55 AM
    Author     : Juan
--%>

<%@page import="client.model.Client"%>
<%@page import="client.model.Tower"%>
<%@page import="util.Utility"%>
<%@page import="client.model.Service"%>
<%@page import="client.model.HasTower"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Service service = new Service();
    Tower tower = new Tower();
    HasTower hasTower = new HasTower();
    if(request.getParameter("client_id")!=null){
        service.setClientId(Integer.parseInt(request.getParameter("client_id").toString()));
    }
    if(request.getParameter("startDate")!=null){
        service.setStartDate(Utility.StringToDate(request.getParameter("startDate").toString()));
    }
    if(request.getParameter("street_address_pickup")!=null){
        service.setCityPickup(request.getParameter("street_address_pickup").toString());
    }
    if(request.getParameter("state_pickup")!=null){
        service.setStatePickup(request.getParameter("state_pickup").toString());
    }
    if(request.getParameter("zipcode_pickup")!=null){
        service.setZipcodeDestination(request.getParameter("zipcode_pickup").toString());
    }
    if(request.getParameter("street_address_destination")!=null){
        service.setCityDestination(request.getParameter("street_address_destination").toString());
    }
    if(request.getParameter("state_destination")!=null){
        service.setStateDestination(request.getParameter("state_destination").toString());
    }
    if(request.getParameter("zipcode_destination")!=null){
        service.setZipcodeDestination(request.getParameter("zipcode_destination").toString());
    }
    if(request.getParameter("customerDescription")!=null){
        service.setClientDescription(request.getParameter("customerDescription").toString());
    }
    
   
        //Display Service Status Page
%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="WEB-INF/head/head.jsp" />
    </head>
    <body>
        <jsp:include page="WEB-INF/menu/menu.jsp" />
        
        <h1>Service Status</h1>
        <table>
            <tr>
                <td>
                    <label>Id Service</label>
                </td>
                <td>
                    <input type="text" value="<%=service.getId()%>"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Pickup Address</label>
                </td>
                <td>
                    <input type="text" value="<%=service.getStreetAddressPickup() + " " + service.getCityPickup() + " " + service.getStatePickup() + " " + service.getZipcodePickup()%>"/>
                </td>
            </tr>
            
            <tr>
                <td>
                    <label>Destination Address</label>
                </td>
                <td>
                    <input type="text" value="<%=service.getStreetAddressDestination() + " " + service.getCityDestination() + " " + service.getStateDestination() + " " + service.getZipcodeDestination()%>"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Tower</label>
                </td>
                <td>
                    <input type="text" value="<%=tower.getFname() +" "+ tower.getLname()%>"/>
                </td>
            </tr>
        </table>
                <jsp:include page="WEB-INF/footer/footer.jsp" />
    </body>
</html>

