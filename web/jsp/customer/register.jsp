<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>

<%@ page contentType="text/html;charset=WINDOWS-1251" language="java" %>

<c:url value="/customer.do" var="saveCustomerUrl">
     <c:param name="action" value="register"/>
</c:url>


<html:html>
  <head>
      <title>Створення Замовника</title>
  </head>
  <body>
    <div class="body">
        <h1>Інформація по замовнику</h1>
        <form name="customerForm" action="<c:out value="${saveCustomerUrl}"/>" method="POST" >
        <input type="hidden" name="id"/>
        <table>
            <tr class="prop">
                <td valign="top" class="name">Імя:</td>
                <td valign="top" class="value"><input type="text" name="firіtName" > </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Фамілія:</td>
                <td valign="top" class="value"><input type="text" name="lastName" > </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Логін:</td>
                <td valign="top" class="value"><input type="text" name="username" > </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Пароль:</td>
                <td valign="top" class="value"><input type="password" name="password" > </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Кредит:</td>
                <td valign="top" class="value"><input type="text" name="credit" > </td>
            </tr>
        </table>
          <div class="buttons">
              <span class="button"><input class="save" type="submit" value="Зареєструвати" /></span>
		  </div>
        </form>
    </div>
  </body>
  <html:form action="/customer">
  <html:submit value = "test"/>
  </html:form>
</html:html>