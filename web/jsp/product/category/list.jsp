<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="productCategories" scope="request" type="java.util.Collection"/>

<html>
<head><title>Список Продукт Категорій</title></head>
<body>
<div class="buttonBar">
    <span class="menuButton"><a class="create" href="<c:url value="/product/category/new.do"/>">Нова Категорія</a></span>
</div>
<div class="body">
    <h1>Список Продукт Категорій</h1>
    <div class="list">
        <table>
            <thead>
            <tr>
                <th>Назва Категорії</th>
                <th>Активна</th>
                <th>Дія</th>
            </tr>
            </thead>
            <c:forEach var="category" items="${productCategories}" varStatus="i">
                <tr>
                    <td>
                        <c:out value="${category.name}"/>
                    </td>
                    <td>
                        <c:out value="${category.active}"/>
                    </td>
                    <td>
                        <table>
                            <tr>
                                <td>
                                    <a class="actionEdit"
                                       href="<c:url value="/product/category/edit.do"><c:param name="id" value="${category.id}"/></c:url>">Редагувати</a>
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