<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="sitemesh-decorator" prefix="decorator" %>
<%@ taglib uri="sitemesh-page" prefix="page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page import="org.acegisecurity.ui.AbstractProcessingFilter" %>
<%@ page import="org.acegisecurity.ui.webapp.AuthenticationProcessingFilter" %>
<%@ page import="org.acegisecurity.AuthenticationException" %>
<%@ page import="org.acegisecurity.context.SecurityContextHolder" %>
<%@ page import="org.acegisecurity.Authentication" %>
<%@ page import="org.acegisecurity.userdetails.UserDetails" %>

<html>
<head>
    <title><decorator:title default="Mysterious page..."/></title>
    <link href="<%= request.getContextPath() %>/css/main.css" rel="stylesheet" type="text/css">
    <decorator:head/>
    <title>Головна сторiнка</title>
</head>
<body>
<div id="wrapper">
    <div id="container">
        <div id="header">
            <%
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                if (auth.getPrincipal() instanceof String) {
            %>
            <a href="<c:url value='/acegilogin.jsp'/>"/>Авторизуватися</a>
            |
            <a href="<c:url value="/customerSignup.do"/>">Зареєструватися</a>
            <%
            } else {
                String userRole = ((UserDetails) auth.getPrincipal()).getUsername();
            %>
            <%= userRole %>
            |
            <a href="<c:url value="/j_acegi_logout"/>">Вийти</a>
            <% } %>
        </div>
        <div id="navigation">
            <ul class="nav">
                <li><a href="<c:url value="/welcome.do"/>">На головну</a></li>
            <%
                if (!(auth.getPrincipal() instanceof String)) {
                    String userRole = ((UserDetails) auth.getPrincipal()).getAuthorities()[0].getAuthority();
            %>
                <%
                   if (userRole.equalsIgnoreCase("ROLE_ADMIN")) {
                %>
                <li><a href="<c:url value="/customer.do"><c:param name="action" value="list"/></c:url>">Список замовникiв</a></li>
                <% }
                   if (userRole.equalsIgnoreCase("ROLE_ADMIN") || userRole.equalsIgnoreCase("ROLE_CUSTOMER")) {
                %>
                <li><a href="<c:url value="/welcome.do"/>">Список продуктів</a></li>
                <% }
                   if (userRole.equalsIgnoreCase("ROLE_ADMIN") || userRole.equalsIgnoreCase("ROLE_CUSTOMER")) {
                %>
                <li><a href="<c:url value="/customer/employee/list.do"></c:url>">Список працiвникiв</a></li>
                <% }
                   if (userRole.equalsIgnoreCase("ROLE_ADMIN") || userRole.equalsIgnoreCase("ROLE_CUSTOMER")) {
                %>
                <li><a href="<c:url value="/office.do"><c:param name="action" value="list"/></c:url>">Список офiсiв</a></li>
                <% }
                   if (userRole.equalsIgnoreCase("ROLE_ADMIN") || userRole.equalsIgnoreCase("ROLE_CUSTOMER") || userRole.equalsIgnoreCase("ROLE_MANAGER")) {
                %>

                <li><a href="<c:url value="/order.do"><c:param name="action" value="list"/></c:url>">Список замовлень</a></li>
                <%
                    }
                %>

                 <li><a href="<c:url value="/setings.do" />">Налаштування</a></li>


            <%
                }
            %>
            </ul>
        </div>
    </div>
    <div id="content">
        <decorator:body/>
    </div>

    <div style="clear: both"/>
</div>
</div>
<div id="footer">
    Tonya // All rights reserved
</div>
</body>
</html>