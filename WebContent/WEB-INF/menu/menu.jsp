<%-- 
    Document   : menu
    Created on : Feb 8, 2016, 1:18:24 AM
    Author     : Juan
--%>

<%@page import="client.controller.ControllerFacade"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="pageheader">
    <div id='cssmenu'>
        <ul>
            <li><a href='index.jsp'>Home</a></li>
            <%=session.getAttribute("menu")!=null?session.getAttribute("menu"):""%>
            <li><a href='about.jsp'>About</a></li>
        </ul>
            <% if (session.getAttribute("name")!=null){%>
        <div style="float:right; margin-right: 50px">
            <span>
                Logged as <%=session.getAttribute("name")%>
            </span>
            <span>
                <form name="logout" action="Logout" method="POST">
                    <input type="submit" name="btnLogout" value="Logout"/>
                </form>
            </span>
        </div>
            <%}%>
    </div>
</div>
