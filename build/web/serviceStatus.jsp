<%-- 
    Document   : serviceStatus
    Created on : Feb 7, 2016, 1:12:55 AM
    Author     : Juan
--%>

<%@page import="entity.Serviceman"%>
<%@page import="util.Utility"%>
<%@page import="entity.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Service service = new Service();
    Serviceman serviceman = new Serviceman();
    if(request.getParameter("idserviceType")!=null){
        service.setIdserviceType(Integer.parseInt(request.getParameter("idserviceType").toString()));
    }
    if(request.getParameter("idcustomer")!=null){
        service.setIdcustomer(Integer.parseInt(request.getParameter("idcustomer").toString()));
    }
    if(request.getParameter("startDate")!=null){
        service.setStartDate(Utility.StringToDate(request.getParameter("startDate").toString()));
    }
    if(request.getParameter("positionX")!=null){
        service.setPositionX(Double.parseDouble(request.getParameter("positionX").toString()));
    }
    if(request.getParameter("positionY")!=null){
        service.setPositionX(Double.parseDouble(request.getParameter("positionY").toString()));
    }
    if(request.getParameter("address")!=null){
        service.setAddress(request.getParameter("address").toString());
    }
    if(request.getParameter("customerDescription")!=null){
        service.setCustomerDescription(request.getParameter("customerDescription").toString());
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
                    <input type="text" value="<%=service.getIdservice()%>"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Position</label>
                </td>
                <td>
                    <input type="text" value="<%=service.getPositionX()+", "+service.getPositionY()%>"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Address</label>
                </td>
                <td>
                    <input type="text" value="<%=service.getAddress()%>"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Serviceman</label>
                </td>
                <td>
                    <input type="text" value="<%=serviceman.getName()%>"/>
                </td>
            </tr>
        </table>
                <jsp:include page="WEB-INF/footer/footer.jsp" />
    </body>
</html>
<%
    }
%>
