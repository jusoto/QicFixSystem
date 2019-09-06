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
       <li class='active has-sub'><a href='#'>Site Administration</a>
          <ul>
             <li class='has-sub'><a href='#'>Customer</a>
                <ul>
                   <li><a href="registerCustomer.jsp">Register Customer</a></li>
                   <li><a href='#'>Modify Customer</a></li>
                   <li><a href='#'>List Customer</a></li>
                </ul>
             </li>
             <li class='has-sub'><a href='#'>Serviceman</a>
                <ul>
                   <a href="registerServiceman.jsp">Register Serviceman</a>
                   <li><a href='#'>Modify Customer</a></li>
                   <li><a href='#'>List Customer</a></li>
                </ul>
             </li>
             <li class='has-sub'><a href='#'>Service</a>
                <ul>
                   <li><a href="requestService.jsp">Create Service</a></li>
                   <li><a href='#'>Modify Customer</a></li>
                   <li><a href="listService.jsp">List Service</a></li>
                </ul>
             </li>
          </ul>
       </li>
       <li><a href='about.jsp'>About</a></li>
       <li><a href='contact.jsp'>Contact</a></li>
    </ul>
    </div>
</div>
