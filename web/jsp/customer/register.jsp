<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<%@ page contentType="text/html;charset=WINDOWS-1251" language="java" %>

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
        <form action="/registerCustomer.do" method="POST" >
        <input type="hidden" name="id"/>
        <table>
            <tr class="prop">
                <td valign="top" class="name">Імя:</td>
                <td valign="top" class="value"><input type="text" name="firstName" > </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Фамілія:</td>
                <td valign="top" class="value"><input type="text" name="lastName" > </td>
            </tr>
             <tr class="prop">
                <td valign="top" class="name">Електронна Пошта:</td>
                <td valign="top" class="value"><input type="text" name="customerEmail" > </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Телефон:</td>
                <td valign="top" class="value"><input type="text" name="customerPhone" > </td>
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
        <h1>Організація</h1>
        <table>
            <tr class="prop">
                <td valign="top" class="name">Назва Організації :</td>
                <td valign="top" class="value"><input type="text" name="organizationName" > </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Місто:</td>
                <td valign="top" class="value"><input type="text" name="city" > </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Адреса:</td>
                <td valign="top" class="value"><input type="text" name="address" > </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Телефон:</td>
                <td valign="top" class="value"><input type="text" name="organizationPhone" > </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Електронна Пошта:</td>
                <td valign="top" class="value"><input type="text" name="organizationEmail" > </td>
            </tr>
        </table>
          <div class="buttons">
              <span class="button"><input class="save" type="submit" value="Зареєструвати" /></span>
		  </div>
        </form>
    </div>
  </body>
</html:html>