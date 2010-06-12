<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<jsp:useBean id="productCategories" scope="session" type="java.util.Collection"/>

<html:html>
  <head>
      <title>Новий продукт</title>
  </head>
  <body>
  <div class="body">
        <h1>Новий продукт</h1>
        <div class="errors">
            <html:errors/>
        </div>
        <html:form action="/product/save" enctype="multipart/form-data" >
        <input type="hidden" name="id" value="<c:out value="${null}"/>"/>    
        <table>
            <tr class="prop">
                <td valign="top" class="name">Назва продукту</td>
                <td valign="top" class="value"><html:text property="name"/> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Цiна продукту</td>
                <td valign="top" class="value"><html:text property="cost"/> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Кількість</td>
                <td valign="top" class="value"><html:text property="count"/> </td>
            </tr>
            <tr class="prop">
                    <td valign="top" class="name">Категорія</td>
                    <td valign="top" class="value">
                        <html:select property="category">
                            <html:option value="">Виберiть Категорію</html:option>
                            <html:options collection="productCategories" property="id" labelProperty="name"/>
                        </html:select>
                    </td>
                </tr>
            <tr class="prop">
                <td valign="top" class="name">Опис продукту</td>
                <td valign="top" class="value"><html:textarea property="description" rows="3" cols="10"/></td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Фото продукту</td>
                <td valign="top" class="value"><html:file  property="productImage"/></td>
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
                  <html:submit styleClass="save" value="Зберегти" /></span>
		  </div>
        </html:form>
    </div>
  </body>
</html:html>