<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:url value="/product.do" var="saveOrderUrl">
     <c:param name="action" value="save"/>
</c:url>

<html>
  <head>
      <title>Новий продукт</title>
  </head>
  <body>
  <div class="body">
        <h1>Новий продукт</h1>
        <form name="productForm" action="<c:out value="${saveOrderUrl}"/>" method="POST" >
        <input type="hidden" name="id" value="<c:out value="${null}"/>"/>
        <table>
            <tr class="prop">
                <td valign="top" class="name">Назва продукту</td>
                <td valign="top" class="value"><input type="text" name="name"> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Цiна продукту</td>
                <td valign="top" class="value"><input type="text" name="cost"> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Кількість</td>
                <td valign="top" class="value"><input type="text" name="count"> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Опис продукту</td>
                <td valign="top" class="value"><textarea id="description" name="description" rows="3" cols="10"></textarea></td>
            </tr>
        </table>
          <div class="buttons">
              <span class="button"><input class="save" type="submit" value="Зберегти" /></span>
		  </div>
        </form>
    </div>
  </body>
</html>