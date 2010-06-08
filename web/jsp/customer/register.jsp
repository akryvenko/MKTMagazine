<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html:html>
  <head>
      <title>Реєстрація</title>
  </head>
  <body>
    <div class="body">
        <div class="errors">
            <html:errors/>
        </div>
        <h1>Інформація по замовнику</h1>
        <html:form action="/registerCustomer">
        <input type="hidden" name="id"/>
        <table>
            <tr class="prop">
                <td valign="top" class="name">Імя:</td>
                <td valign="top" class="value"><html:text property="firstName" /> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Фамілія:</td>
                <td valign="top" class="value"><html:text property="lastName" /> </td>
            </tr>
             <tr class="prop">
                <td valign="top" class="name">Електронна Пошта:</td>
                <td valign="top" class="value"><html:text property="customerEmail" /> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Телефон:</td>
                <td valign="top" class="value"><html:text property="customerPhone" /> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Логін:</td>
                <td valign="top" class="value"><html:text property="username" /> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Пароль:</td>
                <td valign="top" class="value"><html:password property="password" /> </td>
            </tr>
        </table>
        <h1>Організація</h1>
        <table>
            <tr class="prop">
                <td valign="top" class="name">Назва Організації :</td>
                <td valign="top" class="value"><html:text property="organizationName" /> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Місто:</td>
                <td valign="top" class="value"><html:text property="city" /> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Адреса:</td>
                <td valign="top" class="value"><html:text property="address" /> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Телефон:</td>
                <td valign="top" class="value"><html:text property="organizationPhone" /> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Електронна Пошта:</td>
                <td valign="top" class="value"><html:text property="organizationEmail" /> </td>
            </tr>
        </table>
          <div class="buttons">
              <span class="button"><html:submit styleClass="save"value="Зареєструвати"/></span>
		  </div>
        </html:form>
    </div>
  </body>
</html:html>