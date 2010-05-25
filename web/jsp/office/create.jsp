<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="employers" scope="request" type="java.util.Collection"/>

<c:url value="/office.do" var="saveOfficeUrl">
     <c:param name="action" value="save"/>
</c:url>

<html>
  <head>
      <title>Редагування офісу</title>
  </head>
  <body>
    <div class="body">
        <h1>Редагування офісу</h1>
        <form name="officeForm" action="<c:out value="${saveOfficeUrl}"/>" method="POST" >
        <input type="hidden" name="id"/>
        <table>
            <tr class="prop">
                <td valign="top" class="name">Місто</td>
                <td valign="top" class="value"><input type="text" name="city" > </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">Регіон</td>
                <td valign="top" class="value"><input type="text" name="region" > </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">target</td>
                <td valign="top" class="value"><input type="text" name="target" > </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">sales</td>
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