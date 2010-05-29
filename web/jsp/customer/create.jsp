<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=WINDOWS-1251" language="java" %>

<jsp:useBean id="employers" scope="request" type="java.util.Collection"/>

<c:url value="/customer.do" var="saveCustomerUrl">
     <c:param name="action" value="save"/>
</c:url>

<html:html>
  <head>
      <title>��������� ���������</title>
  </head>
  <body>
    <div class="body">
        <h1>���������� �� ���������</h1>
        <html:form action="<c:out value='${saveCustomerUrl}'/>">
        <input type="hidden" name="id"/>
        <table>
            <tr class="prop">
                <td valign="top" class="name">���:</td>
                <td valign="top" class="value"><input type="text" name="fir�tName" > </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">�����:</td>
                <td valign="top" class="value"><input type="text" name="lastName" > </td>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">�������:</td>
                <td valign="top" class="value">
                    <select id="employer" name="employer" onChange="this.options[this.selectedIndex].value">
    					<option value="null">�����i�� ���������</option>
                        <c:forEach var="viewBeanl" items="${employers}">
                            <option value="<c:out value="${viewBeanl.id}"/>"><c:out value="${viewBeanl.name}"/></option>
                        </c:forEach>
				    </select>
            </tr>
            <tr class="prop">
                <td valign="top" class="name">������:</td>
                <td valign="top" class="value"><input type="text" name="credit" > </td>
            </tr>
        </table>
          <div class="buttons">
              <span class="button"><input class="save" type="submit" value="��������" /></span>
		  </div>
        </html:form>
    </div>
  </body>
</html:html>