<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<jsp:useBean id="employers" scope="session" type="java.util.Collection"/>

<html:html>
    <head>
        <title>Редагування працівника</title>
    </head>
    <body>
    <div class="body">
        <h1>Інформація по працівнику</h1>

        <div class="errors">
            <html:errors/>
        </div>
        <html:form action="/customer/employee/save">
            <html:hidden property="id"/>
            <html:hidden property="office"/>
            <table>
                <tr class="prop">
                    <td valign="top" class="name">Імя:</td>
                    <td valign="top" class="value"><html:text property="firstName"/></td>
                </tr>
                <tr class="prop">
                    <td valign="top" class="name">Прізвище:</td>
                    <td valign="top" class="value"><html:text property="lastName"/></td>
                </tr>
                <tr class="prop">
                    <td valign="top" class="name">Електронна пошта:</td>
                    <td valign="top" class="value"><html:text property="mail"/></td>
                </tr>
                <tr class="prop">
                    <td valign="top" class="name">Телефон:</td>
                    <td valign="top" class="value"><html:text property="phone"/></td>
                </tr>
                <tr class="prop">
                    <td valign="top" class="name">Вік:</td>
                    <td valign="top" class="value"><html:text property="age"/></td>
                </tr>
                <tr class="prop">
                    <td valign="top" class="name">Логін:</td>
                    <td valign="top" class="value"><html:text property="username"/></td>
                </tr>
                <tr class="prop">
                    <td valign="top" class="name">Пароль:</td>
                    <td valign="top" class="value"><html:text property="password"/></td>
                </tr>
                <tr class="prop">
                    <td valign="top" class="name">Менежер:</td>
                    <td valign="top" class="value">
                        <html:select property="manager">
                        <html:option value="null">Виберiть Менеджера</html:option>
                            <html:options collection="employers" property="id" labelProperty="fullName"/>
                        </html:select>
                </tr>
                <tr class="prop">
                    <td valign="top" class="name">Квота:</td>
                    <td valign="top" class="value"><html:text property="quota"/></td>
                </tr>
                <tr class="prop">
                    <td valign="top" class="name">Салес:</td>
                    <td valign="top" class="value"><html:text property="sales"/></td>
                </tr>
                <tr class="prop">
                    <td valign="top" class="name">Активний</td>
                    <td valign="top" class="value">
                        <html:radio property="active" value="true"/> Так <br/>
                        <html:radio property="active" value="false"/> Ні
                    </td>
                </tr>
            </table>
            <div class="buttons">
                <span class="button">
                        <html:submit styleClass="save" value="Зберегти"/>
            </div>
        </html:form>
    </div>
    </body>
</html:html>