<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=WINDOWS-1251" language="java" %>

<jsp:useBean id="employers" scope="session" type="java.util.Collection"/>

<html:html>
    <head>
        <title>Звіт за період</title>
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

            #cal2ContainerStart {
                display: none;
                position: absolute;
                left: 250px;
                top: 80px;
                z-index: 1
            }

            #cal2ContainerEnd {
                display: none;
                position: absolute;
                left: 250px;
                top: 80px;
                z-index: 1
            }

        </style>

    </head>
    <body>
    <script type="text/javascript">
        YAHOO.namespace("example.calendar");

        YAHOO.example.calendar.init = function() {

            YAHOO.example.calendar.cal2 = new YAHOO.widget.Calendar("cal2", "cal2ContainerStart", { title:"Choose a date:", close:true, draggable:true });
            YAHOO.example.calendar.cal2.render();

            YAHOO.util.Event.addListener("startDate", "click", YAHOO.example.calendar.cal2.show, YAHOO.example.calendar.cal2, true);

            YAHOO.example.calendar.cal2.selectEvent.subscribe(StartSelectHandler, YAHOO.example.calendar.cal2, true);

            function StartSelectHandler(type, args, obj) {
                var selected = args[0];
                var selDate = this.toDate(selected[0]);
                YAHOO.example.calendar.cal2.hide();
                document.forms['periodReportForm'].elements['startDate'].value = dateToLocaleString(selDate, this);
            }

            YAHOO.example.calendar.cal3 = new YAHOO.widget.Calendar("cal3", "cal2ContainerEnd", { title:"Choose a date:", close:true, draggable:true });
            YAHOO.example.calendar.cal3.render();

            YAHOO.util.Event.addListener("endDate", "click", YAHOO.example.calendar.cal3.show, YAHOO.example.calendar.cal3, true);

            YAHOO.example.calendar.cal3.selectEvent.subscribe(EndSelectHandler, YAHOO.example.calendar.cal3, true);

            function EndSelectHandler(type, args, obj) {
                var selected = args[0];
                var selDate = this.toDate(selected[0]);
                YAHOO.example.calendar.cal3.hide();
                document.forms['periodReportForm'].elements['endDate'].value = dateToLocaleString(selDate, this);
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
            <h1>Звіт за період</h1>

            <div class="errors">
                <html:errors/>
            </div>
            <html:form action="/customer/ReportForPeriod">
                <table>
                    <tr class="prop">
                        <td valign="top" class="name">Менежер</td>
                        <td valign="top" class="value">
                            <html:select property="employee">
                                <html:option value="">Виберiть Менеджера</html:option>
                                <html:options collection="employers" property="id" labelProperty="fullName"/>
                            </html:select>
                        </td>
                    </tr>
                    <tr class="prop">
                        <td valign="top" class="name">Початок періоду:</td>
                        <td valign="top" class="value">
                        <span id="startDate">
                            <html:text property="startDate"/>
                         </span>

                            <div class="yui-skin-sam">
                                <div id="cal2ContainerStart"></div>
                            </div>
                        </td>
                    </tr>
                    <tr class="prop">
                        <td valign="top" class="name">Кінець періоду:</td>
                        <td valign="top" class="value">
                        <span id="endDate">
                            <html:text property="endDate"/>
                         </span>
                            <div class="yui-skin-sam">
                                <div id="cal2ContainerEnd"></div>
                            </div>
                        </td>
                    </tr>
                </table>
                <div class="buttons">
                    <span class="button"><input class="save" type="submit" value="Зберегти"/></span>
                </div>
            </html:form>
        </div>
    </div>
    </body>
</html:html>