<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html:html>
    <head>
        <title>Редагування Категорії</title>
    </head>
    <body>
    <div class="body">
        <h1>Редагування Категорії</h1>

        <div class="errors">
            <html:errors/>
        </div>
        <html:form action="/product/category/save">
            <html:hidden property="id"/>
            <table>
                <tr class="prop">
                    <td valign="top" class="name">Назва категорії</td>
                    <td valign="top" class="value"><html:text property="name"/></td>
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
                  <html:submit styleClass="save" value="Зберегти"/></span>
            </div>
        </html:form>
    </div>
    </body>
</html:html>