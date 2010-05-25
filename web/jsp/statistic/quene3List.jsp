<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="viewBeans" scope="request" type="java.util.Collection"/>

<html>
  <head><title>Список Працiвникiв</title></head>
  <link type="text/css" title="compact" href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet" />
  <body>
  <div class="nav">
		<span class="menuButton"><a class="home" href="<%=request.getContextPath()%>">На головну</a></span>
  </div>
  <div class="body">
    <h1>Список офiсiв</h1>
      <div class="list">
      <table>
        <thead>
            <tr>
                <th>Oфiс</th>
                <th>Мiнiмальне значення</th>
                <th>Максимальне значення</th>
            </tr>
	    </thead>
      <c:forEach var="viewBeanl" items="${viewBeans}" varStatus="i" >
        <tr>
            <td>
                 <c:out value="${viewBeanl.name}"/>
            </td>
            <td>
                 <c:out value="${viewBeanl.value}"/>
            </td>
            <td>
                 <c:out value="${viewBeanl.value2}"/>
            </td>
        </tr>
      </c:forEach>
      </table>
      </div>
   </div>
  </body>
</html>