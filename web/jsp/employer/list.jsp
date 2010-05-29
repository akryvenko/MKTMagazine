
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.mariya.entity.Customer" %>
<%@ page import="com.mariya.entity.Employer" %>
<%@ page import="com.mariya.entity.CustomUser" %>
<%@ page import="org.acegisecurity.context.SecurityContextHolder" %>
<%@ page import="java.util.List" %>

<jsp:useBean id="employers" scope="request" type="java.util.Collection"/>

<html>
  <head><title>Список Працiвникiв</title></head>
  <body>
  <div class="buttonBar">
        <span class="menuButton"><a class="create" href="<c:url value="/employer.do"><c:param name="action" value="create"/></c:url>">Новий працiвник</a></span>
  </div>
  <div class="body">
    <h1>Список Працiвникiв</h1>
      <div class="list">
      <table>
        <thead>
            <tr>
                <th>ПIБ</th>
                <th>Вік</th>
                <th>Офiс</th>
                <th>Заголовок</th>
                <th>Менеджер</th>
                <th>Квота</th>
                <th>Салес</th>
                <th>Дія</th>
            </tr>
	    </thead>
      <c:forEach var="viewBeanl" items="${employers}" varStatus="i" >
        <tr>
            <td>
                 <c:out value="${viewBeanl.firstName}"/>&nbsp;<c:out value="${viewBeanl.lastName}"/>
            </td>
            <td>
                 <c:out value="${viewBeanl.age}"/>
            </td>
            <td>
                 <c:out value="${viewBeanl.office.region}"/>:<c:out value="${viewBeanl.office.city}"/>
            </td>
            <td>
                 <c:out value="${viewBeanl.title}"/>
            </td>
            <td>
                 <c:out value="${viewBeanl.manager.firstName}"/>&nbsp;<c:out value="${viewBeanl.manager.lastName}"/>
            </td>
            <td>
                 <c:out value="${viewBeanl.quota}"/>
            </td>
            <td>
                 <c:out value="${viewBeanl.sales}"/>
            </td>
            <td>

                <a class="actionEdit" href="<c:url value="/employer.do"><c:param name="employerId" value="${viewBeanl.id}"/><c:param name="action" value="edit"/></c:url>">Редагувати</a>


               <a class="actionCancel" href="<c:url value="/employer.do"><c:param name="employerId" value="${viewBeanl.id}"/><c:param name="action" value="delete"/></c:url>">Видалити</a>

            </td>
        </tr>
      </c:forEach>
      </table>
      </div>
   </div>
  </body>
</html>