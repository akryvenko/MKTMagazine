<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core"%>

<%@ page import="org.acegisecurity.context.SecurityContextHolder" %>
<%@ page import="org.acegisecurity.Authentication" %>
<%@ page import="org.acegisecurity.userdetails.UserDetails" %>

<jsp:useBean id="products" scope="request" type="java.util.Collection"/>

<html>
  <head><title>Список продуктів</title></head>
  <body>
<div class="body">
    <c:forEach var="product" items="${products}" varStatus="i" >
        <div class="el_preview">
            <img src="<%= request.getContextPath() %> <c:out value="${product.imagePath}"/> "/>

            <h1 class="el_title">
                <c:out value="${product.name}"/>
            </h1>
            <small>
                Ціна продукту&nbsp;:&nbsp;<c:out value="${product.price}"/>&nbsp;грн.
                &nbsp;-&nbsp;Доступна кількість&nbsp;:&nbsp;<c:out value="${product.count}"/>  
            </small>
            <div class="el_summary">
                <p> 
                    <c:out value="${product.description}"/>
                </p>
            </div>

            <div class="el_actions">
                <a class="actionOrder" href="<c:url value="/customer/order/new.do"><c:param name="productId" value="${product.id}"/></c:url>">Замовити</a>
            </div>

            <div style="clear: both;"></div>
        </div>
    </c:forEach>
   </div>
  </body>
</html>