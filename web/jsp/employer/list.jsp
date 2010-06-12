<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<jsp:useBean id="employers" scope="request" type="java.util.Collection"/>

<html>
<head><title>Список Працiвникiв</title></head>
<body>
<div class="buttonBar">
    <span class="menuButton"><a class="create" href="<c:url value="/customer/employee/new.do"/>">Новий
        працiвник</a></span>
</div>

<div class="body">
    <h1>Список Працiвникiв</h1>

    <form action="<c:url value="/customer/employee/list.do"/>">
        <select id="active" name="active">
            <option value="active">Всі активні</option>
            <option value="unactive">Всі не активні</option>
            <option value="all">Всі працівники</option>
        </select>
               <span class="button">
                       <input type="submit" value="Фільтрувати"/>
               </span>
    </form>
    <div class="list">
        <table>
            <thead>
            <tr>
                <th>ПIБ</th>
                <th>Вік</th>
                <th>Менеджер</th>
                <th>Квота</th>
                <th>Салес</th>
                <th>Дія</th>
            </tr>
            </thead>
            <c:forEach var="viewBeanl" items="${employers}" varStatus="i">
                <tr>
                    <td>
                        <c:out value="${viewBeanl.firstName}"/>&nbsp;<c:out value="${viewBeanl.lastName}"/>
                    </td>
                    <td>
                        <c:out value="${viewBeanl.age}"/>
                    </td>
                    <td>
                        <c:out value="${viewBeanl.manager.firstName}"/>&nbsp;<c:out
                            value="${viewBeanl.manager.lastName}"/>
                    </td>
                    <td>
                        <c:out value="${viewBeanl.quota}"/>
                    </td>
                    <td>
                        <c:out value="${viewBeanl.sales}"/>
                    </td>
                    <td>
                        <table>
                            <tr>
                                <td>
                                    <a class="actionEdit"
                                       href="<c:url value="/customer/employee/edit.do"><c:param name="employerId" value="${viewBeanl.id}"/></c:url>">Редагувати</a>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>