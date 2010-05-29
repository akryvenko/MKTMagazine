
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="products" scope="request" type="java.util.Collection"/>

<html>
  <head><title>Список продуктiв</title></head>
  <body>
  <div class="buttonBar">
        <span class="menuButton"><a class="create" href="<c:url value="/product.do"><c:param name="action" value="create"/></c:url>">Новий продукт</a></span>
  </div>
  <div class="body">
    <h1>Список продуктів</h1>
      <div class="list">
      <table>
        <thead>
            <tr>
                <th>Назва Продукту</th>
                <th>Ціна Продукту</th>
                <th>На складі</th>
                <th>Дія</th>
            </tr>
	    </thead>
      <c:forEach var="product" items="${products}" varStatus="i" >
        <tr>
            <td>
                 <c:out value="${product.name}"/>
            </td>
            <td>
                 <c:out value="${product.price}"/>
            </td>
            <td>
                 <c:out value="${product.count}"/>
            </td>
            <td>
               <a class="actionEdit" href="<c:url value="/product.do"><c:param name="productId" value="${product.id}"/><c:param name="action" value="edit"/></c:url>">Редагувати</a>
                <a class="actionCancel" href="<c:url value="/product.do"><c:param name="productId" value="${product.id}"/><c:param name="action" value="delete"/></c:url>">Видалити</a>
            </td>
        </tr>
      </c:forEach>
      </table>
      </div>
   </div>
  </body>
</html>