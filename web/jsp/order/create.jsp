<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="customer" scope="request" type="com.mariya.entity.Customer"/>
<jsp:useBean id="employers" scope="request" type="java.util.Collection"/>
<jsp:useBean id="product" scope="request" type="com.mariya.entity.Product"/>

<c:url value="/order.do" var="saveOrderUrl">
    <c:param name="action" value="save"/>
</c:url>

<html>
<head>
    <title>Оформлення замовлення</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/yui/fonts/fonts-min.css"/>
    <link rel="stylesheet" type="text/css"
          href="<%=request.getContextPath()%>/yui/calendar/assets/skins/sam/calendar.css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/yui/yahoo-dom-event/yahoo-dom-event.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/yui/calendar/calendar-min.js"></script>

    <style type="text/css">
        #examplecontainer {
            height: 100px;
            position: relative
        }

        #cal2Container {
            display: none;
            position: absolute;
            left: 250px;
            top: 80px;
            z-index: 1
        }
    </style>

</head>
<body class="yui-skin-sam">
<script type="text/javascript">
    YAHOO.namespace("example.calendar");

    YAHOO.example.calendar.init = function() {

        YAHOO.example.calendar.cal2 = new YAHOO.widget.Calendar("cal2", "cal2Container", { title:"Choose a date:", close:true, draggable:true });
        YAHOO.example.calendar.cal2.render();

        YAHOO.util.Event.addListener("date", "click", YAHOO.example.calendar.cal2.show, YAHOO.example.calendar.cal2, true);

        YAHOO.example.calendar.cal2.selectEvent.subscribe(mySelectHandler, YAHOO.example.calendar.cal2, true);

        function mySelectHandler(type, args, obj) {
            var selected = args[0];
            var selDate = this.toDate(selected[0]);
            YAHOO.example.calendar.cal2.hide();
            document.forms['orderForm'].elements['date'].value = dateToLocaleString(selDate, this);
        }


        function dateToLocaleString(dt, cal) {
            var wStr = cal.cfg.getProperty("WEEKDAYS_LONG")[dt.getDay()];
            var dStr = dt.getDate();
            var mStr = cal.cfg.getProperty("MONTHS_LONG")[dt.getMonth()];
            var dMonth = dt.getMonth(); 
            var yStr = dt.getFullYear();
            return (yStr + "/" + dMonth + "/" + dStr);
        }

    }

    YAHOO.util.Event.onDOMReady(YAHOO.example.calendar.init);
</script>

<div id="examplecontainer">
    <div class="body">
        <h1>Оформлення замовлення</h1>

        <form name="orderForm" action="<c:out value="${saveOrderUrl}"/>" method="POST">
            <input type="hidden" name="id" value="<c:out value="${null}"/>"/>
            <table>
                <tr class="prop">
                    <td valign="top" class="name">Дата Замовлення</td>
                    <td valign="top" class="value">
                        <input type="text" id="date" name="date" value=""/>
                        
                        <div id="cal2Container"></div>
                    </td>


                </tr>
                <tr class="prop">
                    <td valign="top" class="name">Менежер</td>
                    <td valign="top" class="value">
                        <select id="employee" name="employee" onChange="this.options[this.selectedIndex].value">
                            <option value="null">Виберiть Менеджера</option>
                            <c:forEach var="viewBeanl" items="${employers}">
                                <option value="<c:out value="${viewBeanl.id}"/>"><c:out value="${viewBeanl.firstName}"/>&nbsp;<c:out value="${viewBeanl.lastName}"/></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td valign="top" class="name">Продукт</td>
                    <td valign="top" class="value">
                        <input type="hidden" name="product" value="<c:out value="${product.id}"/>"/>
                        <c:out value="${product.name}"/>
                    </td>
                </tr>
                <tr>
                    <td valign="top" class="name">Ціна Продукту</td>
                    <td valign="top" class="value">
                        <input type="hidden" name="price" value="<c:out value="${product.price}"/>"/>
                        <c:out value="${product.price}"/>&nbsp;грн
                    </td>
                </tr>
                <tr>
                    <td valign="top" class="name">Замовник</td>
                    <td valign="top" class="value">
                        <input type="hidden" name="customer" value="<c:out value="${customer.id}"/>"/>
                        <c:out value="${customer.firstName}"/>&nbsp;<c:out value="${customer.lastName}"/>
                    </td>
                </tr>
                <tr class="prop">
                    <td valign="top" class="name">Сума</td>
                    <td valign="top" class="value"><input type="text" id="amount" name="amount"/></td>

                </tr>
                <tr class="prop">
                    <td valign="top" class="name">Кількість</td>
                    <td valign="top" class="value"><input type="text" id="productCount" name="productCount"/></td>

                </tr>
            </table>
            <div class="buttons">
                <span class="button"><input class="save" type="submit" value="Оформити"/></span>
            </div>
        </form>
    </div>
</div>
</body>
</html>