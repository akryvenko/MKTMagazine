<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=WINDOWS-1251" language="java" %>

<jsp:useBean id="employers" scope="request" type="java.util.Collection"/>

<c:url value="/customer.do" var="saveCustomerUrl">
     <c:param name="action" value="save"/>
</c:url>

<html>
  <head>
      <title>��������� ���������</title>
      <link type="text/css" title="compact" href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet" />
  </head>
  <body>
    <%--<div class="buttonBar">--%>
        <%--<span class="menuButton"><a class="list" href="<c:url value="/customer.do"><c:param name="action" value="list"/></c:url>">������ ��������i�</a></span>--%>
    <%--</div>--%>
    <div class="body">
        <h1>���������� �� ���������</h1>
        <form name="customerForm" action="<c:out value="${saveCustomerUrl}"/>" method="POST" >
        <input type="hidden" name="id"/>
        <table>
            <tr class="prop">
                <td valign="top" class="name">ϲ�:</td>
                <td valign="top" class="value"><input type="text" name="name" > </td>
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
        </form>
    </div>
  </body>
</html>