<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="customers" scope="request" type="java.util.Collection"/>

<html>
  <head><title>Список Замовникiв</title></head>
  <link type="text/css" title="compact" href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet" />
  <body>
  <div class="buttonBar">
        <span class="menuButton"><a class="create" href="<c:url value="/customer.do"><c:param name="action" value="create"/></c:url>">Новий Замовник</a></span>
  </div>
  <div class="body">
    <h1>Список Замовникiв</h1>
      <div class="list">
      <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Iм'я Замовника</th>
                <th>Менеджер</th>
                <th>Кредит</th>
                <th> Дiя </th>
            </tr>
	    </thead>
      <c:forEach var="customer" items="${customers}" varStatus="i" >
        <tr>
            <td>
                <a href="<c:url value="/customer.do"><c:param name="customerId" value="${customer.id}"/><c:param name="action" value="edit"/></c:url>"><c:out value="${customer.id}"/></a>
            </td>
            <td>
                 <c:out value="${customer.name}"/>
            </td>
            <td>
                 <c:out value="${customer.employer.name}"/>
            </td>
            <td>
                 <c:out value="${customer.credit}"/>
            </td>
            <td>
               <a href="<c:url value="/customer.do"><c:param name="customerId" value="${customer.id}"/><c:param name="action" value="edit"/></c:url>">Редагувати</a>
                <a href="<c:url value="/customer.do"><c:param name="customerId" value="${customer.id}"/><c:param name="action" value="delete"/></c:url>">Видалити</a>
            </td>
        </tr>
      </c:forEach>
      </table>
      </div>
   </div>
  </body>
</html>