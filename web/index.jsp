<%-- 
    Document   : index
    Created on : Feb 4, 2016, 11:25:52 PM
    Author     : Juan
--%>
<%@page import="util.Utility"%>
<%@page import="entity.User"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="WEB-INF/head/head.jsp" />
    </head>
    <body>
        <jsp:include page="WEB-INF/menu/menu.jsp" />
<%
    if(session.getAttribute("email")!=null){
        if(Utility.checkSession(session.getAttribute("email").toString())){
%>
<div>
    <span>
        Logged as <%=session.getAttribute("name")%>
    </span>
    <span>
        <form name="logout" action="logout.jsp" method="POST">
            <input type="submit" name="btnLogout" value="Logout"/>
        </form>
    </span>
</div>
        <h1>Ask for service</h1>
        <div>
            <form action="requestService.jsp" method="POST">
                <input type="submit" id="btnTowService" value="Request New Tow Service" >Tow service</button>
            </form>
        </div>

<%
        }
    }else{
       response.setStatus(response.SC_MOVED_TEMPORARILY);
       response.setHeader("Location", "login.jsp"); 
    }
%>
<jsp:include page="WEB-INF/footer/footer.jsp" />
    </body>
</html>