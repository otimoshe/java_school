<%--
  Created by IntelliJ IDEA.
  User: otimoshe
  Date: 05.04.2019
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false" %>
<jsp:include page="sideBar.jsp"/>
<html>
<head>
    <title>TemplateTimeData</title>
</head>
<body>
<div id="content">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span6">
                <div class="widget-box">
                    <table class="table table-bordered data-table">
                        <thead>
                        <tr>
                            <th>Station</th>
                            <th>arrival time</th>
                            <th>departure time</th>
                        </tr>
                        </thead>
                        <tbody>
                        <form:form action="/template/{id}/times" modelAttribute="times" method="post"
                                   class="form-horizontal">
                        <c:forEach items="${times.templateStationMap}" var="template">
                            <tr>
                                <td><input type="text" readonly value="${template.key}" class="span11"/></td>
                                <td><form:input path="templateStationMap['${template.key}'][0]" type="text"
                                                class="timepicker span11"
                                                value="${template.value.get(0)}"/></td>
                                <td><form:input path="templateStationMap['${template.key}'][1]" type="text"
                                                class="timepicker span11"
                                                value="${template.value.get(1)}"/></td>
                            </tr>
                        </c:forEach>
                        <tr><form:input path="templateId" value="${times.templateId}" type="hidden"/></tr>
                        <div id="alert"></div>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <button type="submit" class="btn btn-info">Edit</button>
            </div>
            <sec:csrfInput/>
            </form:form>
        </div>
    </div>
</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>

<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">

<script type="text/javascript">
    $(document).ready(function() {
        $('.timepicker').timepicker({
            timeFormat: 'HH:mm:ss',
            interval: 60
        });
    });
</script>

</html>