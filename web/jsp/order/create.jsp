<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="employers" scope="session" type="java.util.Collection"/>

<html:html>
    <head>
        <title>Оформлення замовлення</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/yui/fonts/fonts-min.css"/>
        <link rel="stylesheet" type="text/css"
              href="<%=request.getContextPath()%>/yui/calendar/assets/skins/sam/calendar.css"/>
        <script type="text/javascript"
                src="<%=request.getContextPath()%>/yui/yahoo-dom-event/yahoo-dom-event.js"></script>
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

            <div class="errors">
                <html:errors/>
            </div>
            <html:form action="/customer/order/save">
                <html:hidden property="id"/>
                <table>
                    <tr class="prop">
                        <td valign="top" class="name">Дата Замовлення</td>
                        <td valign="top" class="value">
                        <span id="date">
                            <html:text property="date"/>
                         </span>
                            <div class="yui-skin-sam">
                                <div id="cal2Container"></div>
                            </div>
                        </td>
                    </tr>
                    <tr class="prop">
                        <td valign="top" class="name">Менежер</td>
                        <td valign="top" class="value">
                            <html:select property="employee">
                                <html:option value="">Виберiть Менеджера</html:option>
                                <html:options collection="employers" property="id" labelProperty="fullName"/>
                            </html:select>
                        </td>
                    </tr>
                    <tr>
                        <td valign="top" class="name">Продукт</td>
                        <td valign="top" class="value">
                            <html:hidden property="product"/>
                            <html:text property="productName" readonly="true"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="top" class="name">Ціна Продукту</td>
                        <td valign="top" class="value">
                            <html:text property="productPrice" readonly="true"/>&nbsp;грн
                        </td>
                    </tr>
                    <tr>
                        <td valign="top" class="name">Замовник</td>
                        <td valign="top" class="value">
                            <html:hidden property="customer"/>
                            <html:text property="customerName" readonly="true"/>
                        </td>
                    </tr>
                    <tr class="prop">
                        <td valign="top" class="name">Кількість</td>
                        <td valign="top" class="value"><html:text property="productCount"/></td>

                    </tr>
                </table>
                <div class="buttons">
                    <span class="button"><html:submit styleClass="save" value="Оформити"/></span>
                    <input type="button" class="save" onClick="location.href='<c:url value="/welcome.do"/>'"
                           value='Анулювати замовлення'/>
                </div>
            </html:form>
        </div>
    </div>
    </body>
</html:html>