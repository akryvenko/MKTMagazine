<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Редагування офісу</title>
</head>
<body>
<div class="body">
    <h1>Редагування офісу</h1>

    <div class="errors">
        <html:errors/>
    </div>
    <html:form action="/customer/office/save">
        <html:hidden property="id"/>
        <table>
            <tr class="prop">
                <td valign="top" class="name">Назва організації</td>
                <td valign="top" class="value"><html:text property="name"/></td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Місто</td>
                <td valign="top" class="value"><html:text property="city"/></td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Регіон</td>
                <td valign="top" class="value"><html:text property="region"/></td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Адреса</td>
                <td valign="top" class="value"><html:text property="address"/></td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Телефон</td>
                <td valign="top" class="value"><html:text property="phone"/></td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Електронна Пошта</td>
                <td valign="top" class="value"><html:text property="mail"/></td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Таржет</td>
                <td valign="top" class="value"><html:text property="target"/></td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Салес</td>
                <td valign="top" class="value"><html:text property="sales"/></td>
            </tr>
        </table>
        <div class="buttons">
            <span class="button"><input class="save" type="submit" value="Зберегти"/></span>
        </div>
    </html:form>
</div>
</body>
</html>