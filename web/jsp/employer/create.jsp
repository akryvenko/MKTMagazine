<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="employers" scope="request" type="java.util.Collection"/>
<jsp:useBean id="offices" scope="request" type="java.util.Collection"/>

<c:url value="/employer.do" var="saveCustomerUrl">
     <c:param name="action" value="save"/>
</c:url>

<html>
  <head>
      <title>Створення працівника</title>
  </head>
  <body>
    <div class="body">
        <h1>Інформація по поацівнику</h1>
        <form name="officeForm" action="<c:out value="${saveCustomerUrl}"/>" method="POST" >
        <input type="hidden" name="id"/>
        <table>
            <tr class="prop">
                <td valign="top" class="name">Прізвище:</td>
                <td valign="top" class="value"><input type="text" name="lastName" > </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Імя:</td>
                <td valign="top" class="value"><input type="text" name="firstName" > </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Електронна пошта:</td>
                <td valign="top" class="value"><input type="text" name="mail" > </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Телефон:</td>
                <td valign="top" class="value"><input type="text" name="phone" > </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Вік:</td>
                <td valign="top" class="value"><input type="text" name="age" > </td>
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
                <td valign="top" class="name">Офіс:</td>
                <td valign="top" class="value">
      				<select id="office" name="office" onChange="this.options[this.selectedIndex].value">
    					<option value="null">Виберiть офiс</option>
                        <c:forEach var="office" items="${offices}">
                            <option value="<c:out value="${office.id}"/>"><c:out value="${office.region}"/>:<c:out value="${office.city}"/></option>
                        </c:forEach>
				    </select>
                </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Заголовок:</td>
                <td valign="top" class="value"><input type="text" name="title" > </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Менежер:</td>
                <td valign="top" class="value">
                    <select id="manager" name="manager" onChange="this.options[this.selectedIndex].value">
    					<option value="null">Виберiть Менеджера</option>
                        <c:forEach var="viewBeanl" items="${employers}">
                            <option value="<c:out value="${viewBeanl.id}"/>"><c:out value="${viewBeanl.firstName}"/>&nbsp;<c:out value="${viewBeanl.lastName}"/></option>
                        </c:forEach>
				    </select>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Квота:</td>
                <td valign="top" class="value"><input type="text" name="quota" > </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Салес:</td>
                <td valign="top" class="value"><input type="text" name="sales" > </td>
            </tr>
        </table>
          <div class="buttons">
              <span class="button"><input class="save" type="submit" value="Зберегти" /></span>
		  </div>
        </form>
    </div>
  </body>
</html>