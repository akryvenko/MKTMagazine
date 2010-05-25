<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="offices" scope="request" type="java.util.Collection"/>

<html>
  <head><title>Список офісів</title></head>
  <link type="text/css" title="compact" href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet" />
  <body>
  <div class="buttonBar">
        <span class="menuButton"><a class="create" href="<c:url value="/office.do"><c:param name="action" value="create"/></c:url>">Новий офіс</a></span>
  </div>
  <div class="body">
    <h1>Список офісів</h1>
      <div class="list">
      <table>
        <thead>
            <tr>
                <th>Місто</th>
                <th>Регіон</th>
                <th>Власник</th>
                <th>target</th>
                <th>sales</th>
                <th>Дія</th>
            </tr>
	    </thead>
      <c:forEach var="office" items="${offices}" varStatus="i" >
        <tr>
            <td>
                 <c:out value="${office.city}"/>
            </td>
            <td>
                 <c:out value="${office.region}"/>
            </td>
            <td>
                 <c:out value="${office.customer.firstName}"/>&nbsp;<c:out value="${office.customer.lastName}"/>
            </td>
            <td>
                 <c:out value="${office.target}"/>
            </td>
            <td>
                 <c:out value="${office.sales}"/>
            </td>
            <td>
               <a class="actionEdit" href="<c:url value="/office.do"><c:param name="officeId" value="${office.id}"/><c:param name="action" value="edit"/></c:url>">Редагувати</a>
               <a class="actionCancel" href="<c:url value="/office.do"><c:param name="officeId" value="${office.id}"/><c:param name="action" value="delete"/></c:url>">Видалити</a>
            </td>
        </tr>
      </c:forEach>
      </table>
      </div>
   </div>
  </body>
</html>