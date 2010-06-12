<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="orders" scope="request" type="java.util.Collection"/>
<jsp:useBean id="employers" scope="request" type="java.util.Collection"/>
<jsp:useBean id="products" scope="request" type="java.util.Collection"/>

<html>
<head><title>Список замовлень</title></head>
<body>
<div class="body">
    <h1>Список замовлень</h1>

    <form action="<c:url value="/customer/order/list.do"/>">
        <select id="statusFilter" name="statusFilter">
            <option value="active">Всі активні</option>
            <option value="all">Всі замовлення</option>
            <option value="closed">Всі закриті</option>
            <option value="canceled">Всі скасовані</option>
        </select>
        <select id="managerFilter" name="managerFilter">
            <option value="">Всі працівники</option>
            <c:forEach var="employee" items="${employers}" varStatus="i">
                <option value="<c:out value="${employee.id}"/>"><c:out value="${employee.fullName}"/></option>
            </c:forEach>
        </select>
        <select id="productFilter" name="productFilter">
            <option value="">Всі продукти</option>
            <c:forEach var="product" items="${products}" varStatus="i">
                <option value="<c:out value="${product.id}"/>"><c:out value="${product.name}"/></option>
            </c:forEach>
        </select>
               <span class="button">
                       <input type="submit" value="Фільтрувати"/>
               </span>
    </form>
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
                <th>Статус</th>
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
                        <c:if test="${order.status == 1}">В&nbsp;просесі</c:if>
                        <c:if test="${order.status == 2}">Відмінений</c:if>
                        <c:if test="${order.status == 3}">Закритий</c:if>
                    </td>
                    <td>
                        <table>
                            <tr>
                                <td>
                                    <a class="actionEdit"
                                       href="<c:url value="/customer/order/edit.do"><c:param name="orderId" value="${order.id}"/></c:url>">Редагувати</a>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
</html>