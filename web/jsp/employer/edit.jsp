<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="employers" scope="request" type="java.util.Collection"/>
<jsp:useBean id="offices" scope="request" type="java.util.Collection"/>
<jsp:useBean id="employer" scope="request" type="com.mariya.entity.Employer"/>

<c:url value="/employer.do" var="saveCustomerUrl">
     <c:param name="action" value="save"/>
</c:url>

<html>
  <head>
      <title>Редагування працівника</title>
  </head>
  <body>
    <div class="body">
        <h1>Інформація по працівнику</h1>
        <form name="officeForm" action="<c:out value="${saveCustomerUrl}"/>" method="POST" >
        <input type="hidden" name="id" value="<c:out value="${employer.id}"/>"/>
        <table>
            <tr class="prop">
                <td valign="top" class="name">Прізвище:</td>
                <td valign="top" class="value"><input type="text" name="lastName" value="<c:out value="${employer.lastName}"/>"> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Імя:</td>
                <td valign="top" class="value"><input type="text" name="firstName" value="<c:out value="${employer.firstName}"/>"> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Електронна пошта:</td>
                <td valign="top" class="value"><input type="text" name="mail" value="<c:out value="${employer.mail}"/>"> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Телефон:</td>
                <td valign="top" class="value"><input type="text" name="phone" value="<c:out value="${employer.phone}"/>"> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Вік:</td>
                <td valign="top" class="value"><input type="text" name="age" value="<c:out value="${employer.age}"/>"> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Логін:</td>
                <td valign="top" class="value"><input type="text" name="username" value="<c:out value="${employer.user.username}"/>"> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Пароль:</td>
                <td valign="top" class="value"><input type="password" name="password" value="<c:out value="${employer.user.password}"/>"> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Офіс:</td>
                <td valign="top" class="value">
      				<select id="office" name="office" onChange="this.options[this.selectedIndex].value">
    					<option value="null">Виберiть офiс</option>
                        <c:forEach var="office" items="${offices}">
                            <c:if test="${employer.office.id == office.id}">
                                <option selected="selected" value="<c:out value="${office.id}"/>"><c:out value="${office.region}"/>:<c:out value="${office.city}"/></option>
                            </c:if>
                            <c:if test="${employer.office.id != office.id}">
                                <option value="<c:out value="${office.id}"/>"><c:out value="${office.region}"/>:<c:out value="${office.city}"/></option>
                            </c:if>
                        </c:forEach>
				    </select>
                </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Заголовок:</td>
                <td valign="top" class="value"><input type="text" name="title" value="<c:out value="${employer.title}"/>" > </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Менежер:</td>
                <td valign="top" class="value">
                    <select id="manager" name="manager"  onChange="this.options[this.selectedIndex].value" >
    					<option value="null">Виберiть Менеджера</option>
                        <c:forEach var="emp" items="${employers}">
                            <c:if test="${emp.id == employer.manager.id}">
                                <option selected="selected" value="<c:out value="${emp.id}"/>"><c:out value="${emp.firstName}"/>&nbsp;<c:out value="${emp.lastName}"/></option>
                            </c:if>
                            <c:if test="${emp.id != employer.manager.id}">
                                <option value="<c:out value="${emp.id}"/>"><c:out value="${emp.firstName}"/>&nbsp;<c:out value="${emp.lastName}"/></option>
                            </c:if>
                        </c:forEach>
				    </select>
                </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Квота:</td>
                <td valign="top" class="value"><input type="text" name="quota" value="<c:out value="${employer.quota}"/>"> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Салес:</td>
                <td valign="top" class="value"><input type="text" name="sales" value="<c:out value="${employer.sales}"/>"> </td>
            </tr>
        </table>
          <div class="buttons">
              <span class="button"><input class="save" type="submit" value="Зберегти" /></span>
		  </div>
        </form>
    </div>
  </body>
</html>