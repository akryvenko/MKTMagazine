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
            <div id="loginform">
                <%
                    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                    if (auth.getPrincipal() instanceof String) {
                %>

                <form id="login_form" name="login_form" action="<c:url value='j_acegi_security_check'/>" method="POST">
                    <table>
                        <tbody>
                        <tr>
                            <td><font style="color:#f0f8ff;">Логін:</font></td>
                            <td>
                                <input type='text' name='j_username'
                                       <c:if test="${not empty param.login_error}">value='<c:out value="${ACEGI_SECURITY_LAST_USERNAME}"/>'
                                </c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td><font style="color:#f0f8ff;">Пароль:</font></td>
                            <td>
                                <input type='password' name='j_password'></td>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <a href="javascript: void(0);" onclick="document.login_form.submit(); return false;">Авторизуватися</a>|<a
                                    href="<c:url value="/customerSignup.do"/>">Зареєструватися</a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </form>


                <%
                } else {
                    String userRole = ((UserDetails) auth.getPrincipal()).getUsername();
                %>
                <font style="color:#f0f8ff;"><%= userRole %>
                    |
                    <a href="<c:url value="/j_acegi_logout"/>">Вийти</a></font>
                <% } %>
            </div>
            <div id="leaderboard">
                <iframe scrolling="no" height="90" frameborder="0" width="728" bordercolor="#000000" vspace="0"
                        hspace="0" marginheight="0" marginwidth="0"
                        src="<c:url value="/html/B3623431.htm"/>">
                </iframe>
            </div>
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
                <li><a href="<c:url value="/customer.do"><c:param name="action" value="list"/></c:url>">Список
                    замовникiв</a></li>
                <% }
                    if (userRole.equalsIgnoreCase("ROLE_ADMIN") || userRole.equalsIgnoreCase("ROLE_CUSTOMER")) {
                %>
                <li><a href="<c:url value="/customer/employee/list.do"></c:url>">Список працiвникiв</a></li>
                <% }
                    if (userRole.equalsIgnoreCase("ROLE_PRODUCT_MANAGER")) {
                %>
                <li><a href="<c:url value="/product/list.do"></c:url>">Список продуктів</a></li>
                <li><a href="<c:url value="/product/category/list.do"></c:url>">Список Категорій</a></li>
                <% }
                    if (userRole.equalsIgnoreCase("ROLE_ADMIN") || userRole.equalsIgnoreCase("ROLE_CUSTOMER")) {
                %>

                <li><a href="<c:url value="/customer/order/list.do"/>">Список замовлень</a></li>
                <%
                    }
                    if (userRole.equalsIgnoreCase("ROLE_CUSTOMER")) {
                %>

                <li><a href="<c:url value="/jsp/customer/report_list.jsp"/>">Звіти</a></li>
                <% } %>
                <%
                    }
                %>
                <li><a href="<c:url value="/jsp/service.jsp"/>">Сервіс</a></li>
                <li><a href="<c:url value="/jsp/contacts.jsp"/>">Контакти</a></li>
            </ul>
        </div>

        <div id="content">
            <decorator:body/>
        </div>
        <div id="messagebar">
            <ul>
                <li>
                    <img src="<c:url value="/images/14127_0.jpg"/>" alt=""><br/>
                    dasjgfdla'fjds
                </li>
                <li><img src="<c:url value="/images/14260_0.jpg"/>" alt=""></li>
                <li><img src="<c:url value="/images/15472_0.jpg"/>" alt=""></li>
                <li><img src="<c:url value="/images/15472_0.jpg"/>" alt=""></li>
                <li><img src="<c:url value="/images/15474_0.jpg"/>" alt=""></li>
            </ul>
        </div>

        <div style="clear: both"/>
    </div>

</div>
</div>
<div id="footer">
    Tonya // All rights reserved
</div>
</body>
</html>