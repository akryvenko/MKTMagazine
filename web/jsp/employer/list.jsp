<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

    <div class="list">
        <table>
            <thead>
            <tr>
                <th>ПIБ</th>
                <th>Вік</th>
                <th>Заголовок</th>
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
                        <c:out value="${viewBeanl.title}"/>
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