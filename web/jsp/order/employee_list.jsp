<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="orders" scope="request" type="java.util.Collection"/>

<html>
<head><title>Список замовлень</title></head>
<body>
<div class="body">
    <h1>Список замовлень</h1>

    <div class="list">
        <table>
            <thead>
            <tr>
                <th>Дата Замовлення</th>
                <th>Менеджер</th>
                <th>Продукт</th>
                <th>Цiна</th>
                <th>Замовлена Кількість</th>
                <th>Сума</th>
                <th>Дія</th>
            </tr>
            </thead>
            <c:forEach var="order" items="${orders}" varStatus="i">
                <tr>
                    <td>
                        <fmt:formatDate value="${order.date}" pattern="yyyy/MM/dd"/>
                    </td>
                    <td>
                        <c:out value="${order.employee.firstName}"/>&nbsp;<c:out value="${order.employee.lastName}"/>
                    </td>
                    <td>
                        <c:out value="${order.product.name}"/>
                    </td>
                    <td>
                        <c:out value="${order.product.price}"/>
                    </td>
                    <td>
                        <c:out value="${order.productCount}"/>
                    </td>
                    <td>
                        <c:out value="${order.amount}"/>
                    </td>
                    <td>
                        <c:choose >
                         <c:when test="${order.status == 1}">
                        <table>
                            <tr>
                                <td>
                                    <a class="actionEdit"
                                       href="<c:url value="/employee/order/status.do"><c:param name="orderId" value="${order.id}"/><c:param name="status" value="finish"/></c:url>">Закрити</a>
                                </td>
                                <td>
                                    <a class="actionCancel"
                                       href="<c:url value="/employee/order/status.do"><c:param name="orderId" value="${order.id}"/><c:param name="status" value="cancel"/></c:url>">Скасувати</a>
                                </td>
                            </tr>
                        </table>
                        </c:when>
                        <c:otherwise>
                            <c:if test="${order.status == 2}">Відмінений</c:if>
                            <c:if test="${order.status == 3}">Закритий</c:if>
                        </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
</html>