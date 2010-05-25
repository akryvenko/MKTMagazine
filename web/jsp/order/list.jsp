<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="orders" scope="request" type="java.util.Collection"/>
<jsp:useBean id="customer" scope="request" type="com.mariya.entity.Customer"/>

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
                <th>Замовник</th>
                <th>Менеджер</th>
                <th>Продукт</th>
                <th>Цiна</th>
                <th>Замовлена Кількість</th>
                <th>Сума</th>
                <th>Дія</th>
            </tr>
	    </thead>
      <c:forEach var="order" items="${orders}" varStatus="i" >
        <tr>
            <td>
                <fmt:formatDate value="${order.date}" pattern="yyyy/MM/dd"/>
            </td>
            <td>
                 <c:out value="${customer.firstName}"/>&nbsp;<c:out value="${customer.lastName}"/>
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
                <a class="actionEdit" href="<c:url value="/order.do"><c:param name="orderId" value="${order.id}"/><c:param name="action" value="edit"/></c:url>">Редагувати</a>
                <a class="actionCancel" href="<c:url value="/order.do"><c:param name="orderId" value="${order.id}"/><c:param name="action" value="delete"/></c:url>">Скасувати</a>
            </td>
        </tr>
      </c:forEach>
      </table>
      </div>
   </div>
  </body>
</html></html>