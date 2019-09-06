<%-- 
    Document   : listTower
    Created on : Apr 18, 2016, 1:58:58 PM
    Author     : Juan
--%>

<%@page import="client.model.Tower"%>
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
        <h1>List Tower</h1>
        <table>
            <tr><td>Tower ID</td><td>Name</td><td>Price $(USD)</td></tr>
            <%
                if (session.getAttribute("email") != null && session.getAttribute("token") != null) {
                    String email = session.getAttribute("email").toString();
                    String token = session.getAttribute("token").toString();
                    ControllerFacade controller = new ControllerFacade();
                    List<Tower> list = controller.selectTower(email, token);
                    if (list != null) {
                        for (int i = 0; i < list.size(); i++) {
                            Tower tower = list.get(i);
                            Integer id = tower.getId();
                            String name = tower.getFname() + " " + tower.getLname();
                            String price = "" + tower.getPriceMile();
            %>
            <tr>
                <td><div><%=id%></div></td><td><div><%=name%></div></td><td><div><%=price%></div></td>
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
