<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head><title>Список звітів</title></head>
<body>

<div class="body">
    <h1>Звіти по Працiвникам</h1>
    <div class="buttonBar">
        <span class="menuButton"><a class="report" href="<c:url value="/customer/report.pdf"><c:param name="report" value="employeeList"/></c:url>">Список Працівників</a></span>
    </div>
    <h1>Звіти по Замовленням</h1>
    <div class="buttonBar">
        <span class="menuButton"><a class="report" href="<c:url value="/customer/report.pdf"><c:param name="report" value="orderList"/></c:url>">Список Замовлень</a></span>
    </div>
    <%--<h1>Звіти по Продуктам</h1>--%>
    <%--<div class="buttonBar">--%>
        <%--<span class="menuButton"><a class="report" href="<c:url value="/customer/report.pdf"/>">Список Замовлених Продуктів</a></span>--%>
    <%--</div>--%>
</div>

</body>
</html>