<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=WINDOWS-1251" language="java" %>

<jsp:useBean id="employers" scope="request" type="java.util.Collection"/>
<jsp:useBean id="customer" scope="request" type="com.mariya.entity.Customer"/>

<c:url value="/customer.do" var="saveCustomerUrl">
     <c:param name="action" value="save"/>
</c:url>

<html>
  <head>
      <title>Редагування працівника</title>
      <link type="text/css" title="compact" href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet" />
  </head>
  <body>
    <%--<div class="buttonBar">--%>
        <%--<span class="menuButton"><a class="list" href="<c:url value="/customer.do"><c:param name="action" value="list"/></c:url>">Список Замовників</a></span>--%>
    <%--</div>--%>
    <div class="body">
        <h1>Інформація по працівнику</h1>
        <form name="officeForm" action="<c:out value="${saveCustomerUrl}"/>" method="POST" >
        <input type="hidden" name="id" value="<c:out value="${customer.id}"/>"/>
        <table>
            <tr class="prop">
                <td valign="top" class="name">ПІП:</td>
                <td valign="top" class="value"><input type="text" name="name" value="<c:out value="${customer.name}"/>"> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Менежер:</td>
                <td valign="top" class="value">
                    <select id="employer" name="employer"  onChange="this.options[this.selectedIndex].value" >
    					<option value="null">Виберiть Менеджера</option>
                        <c:forEach var="viewBeanl" items="${employers}">
                            <c:if test="${viewBeanl.id == customer.employer.id}">
                                <option selected="selected" value="<c:out value="${viewBeanl.id}"/>"><c:out value="${viewBeanl.name}"/></option>
                            </c:if>
                            <c:if test="${viewBeanl.id != customer.employer.id}">
                                <option value="<c:out value="${viewBeanl.id}"/>"><c:out value="${viewBeanl.name}"/></option>
                            </c:if>
                        </c:forEach>
				    </select>
                </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Кредит:</td>
                <td valign="top" class="value"><input type="text" name="credit" value="<c:out value="${customer.credit}"/>"> </td>
            </tr>
        </table>
          <div class="buttons">
              <span class="button"><input class="save" type="submit" value="Зберегти" /></span>
		  </div>
        </form>
    </div>
  </body>
</html>