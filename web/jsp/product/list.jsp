<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="products" scope="request" type="java.util.Collection"/>

<html>
<head><title>Список продуктiв</title></head>
<body>
<div class="buttonBar">
    <span class="menuButton"><a class="create" href="<c:url value="/product/new.do"/>">Новий продукт</a></span>
</div>
<div class="body">
    <h1>Список продуктів</h1>
    <form action="<c:url value="/product/list.do"/>">
        <select id="activeFilter" name="activeFilter">
            <option value="active">Всі активні</option>
            <option value="unactive">Всі не активні</option>
            <option value="all">Всі продукти</option>

        </select>
        <span class="button">
            <input type="submit" value="Фільтрувати"/>
         </span>
    </form>
    <div class="list">
        <table>
            <thead>
            <tr>
                <th>Назва Продукту</th>
                <th>Ціна Продукту</th>
                <th>Категорія</th>
                <th>На складі</th>
                <th>Дія</th>
            </tr>
            </thead>
            <c:forEach var="product" items="${products}" varStatus="i">
                <tr>
                    <td>
                        <c:out value="${product.name}"/>
                    </td>
                    <td>
                        <c:out value="${product.price}"/>
                    </td>
                    <td>
                        <c:out value="${product.productCategory.name}"/>
                    </td>
                    <td>
                        <c:out value="${product.count}"/>
                    </td>
                    <td>
                        <table>
                            <tr>
                                <td>
                                    <a class="actionEdit"
                                       href="<c:url value="/product/edit.do"><c:param name="productId" value="${product.id}"/></c:url>">Редагувати</a>
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