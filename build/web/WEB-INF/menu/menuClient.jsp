<%-- 
    Document   : menu
    Created on : Feb 8, 2016, 1:18:24 AM
    Author     : Juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="pageheader">
    <div id='cssmenu'>
        <ul>
            <li><a href='index.jsp'>Home</a></li>
            <li><a href='profile.jsp'>Profile</a>
            </li>
            <li class='has-sub'><a href='#'>Service</a>
                <ul>
                    <li><a href="requestService.jsp">Create Service</a></li>
                    <li><a href='listTower.jsp'>List Tower</a></li>
                    <li><a href="listService.jsp">List Service</a></li>
                </ul>
            </li>
            <li><a href='about.jsp'>About</a></li>
        </ul>
    </div>
</div>
