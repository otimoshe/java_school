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

<html>
<head>
    <title>TrainData</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>

</head>
<body>
<h1>Train Details</h1>
<a href="/admin">Back to admin page</a>
<table class="tg">
    <tr>
        <th width="80">Station</th>
        <th width="80">arrival time</th>
        <th width="120">departure time</th>
    </tr>

    <form:form action="/templateInfo/{id}"  modelAttribute="times"  method="post" >
    <c:forEach items="${times.templateStationMap}" var="template">
    <tr>
        <td><input type="text" readonly value="${template.key}" /></td>
        <td><form:input path="templateStationMap['${template.key}'][0]" type="time" value = "${template.value.get(0)}" onchange="doAppend()"/></td>
        <td><form:input path="templateStationMap['${template.key}'][1]" type="time" value = "${template.value.get(1)}" onchange="doAppend()"/></td>
    </tr>
    </c:forEach>
        <input type="hidden" name="templateId" value="${times.templateId}">
        <p><input type="submit" value="Submit" /> </p>
        <sec:csrfInput/>
    </form:form>
</table>
</body>

<script type="text/javascript">
    function doAppend() {
        console.log(this);

        console.log(this.value);
    }
</script>

</html>