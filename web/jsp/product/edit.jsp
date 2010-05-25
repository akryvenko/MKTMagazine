<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="product" scope="request" type="com.mariya.entity.Product"/>

<c:url value="/product.do" var="saveOrderUrl">
     <c:param name="action" value="save"/>
</c:url>

<html>
  <head>
      <title>Редагування продукту</title>
  </head>
  <body>
    <div class="body">
        <h1>Редагування продукту</h1>
        <form name="productForm" action="<c:out value="${saveOrderUrl}"/>" method="POST" >
        <input type="hidden" name="id" value="<c:out value="${product.id}"/>"/>
        <table>
            <tr class="prop">
                <td valign="top" class="name">Назва продукту</td>
                <td valign="top" class="value"><input type="text" name="name" value="<c:out value="${product.name   }"/>"> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Цiна продукту</td>
                <td valign="top" class="value"><input type="text" name="cost" value="<c:out value="${product.price}"/>"> </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Кількість</td>
                <td valign="top" class="value"><input type="text" name="count" value="<c:out value="${product.count}"/>"> </td>
            </tr>
            <tr class="prop">
                <tr class="prop">
                <td valign="top" class="name">Опис продукту</td>
                <td valign="top" class="value"><textarea id="description" name="description" rows="3" cols="10"><c:out value="${product.description}"/></textarea></td>
            </tr>
            </tr>
        </table>
          <div class="buttons">
              <span class="button"><input class="save" type="submit" value="Зберегти" /></span>
		  </div>
        </form>
    </div>
  </body>
</html>