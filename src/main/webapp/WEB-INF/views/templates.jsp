<%--
  Created by IntelliJ IDEA.
  User: otimoshe
  Date: 27.03.2019
  Time: 12:10
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
    <title>Time Templates page</title>

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

<a href="/admin">Back to admin page</a>

<c:if test="${!empty listTemplates}">
    <table class="tg">
        <tr>
            <th width="80">Template ID</th>
            <th width="80">Template name</th>
            <th width="80">Route name</th>
            <th width="80">Time info</th>
            <th width="80">Delete</th>
        </tr>

        <c:forEach items="${listTemplates}" var="template">
            <tr>
                <td>${template.id}</td>
                <td>${template.name}</td>
                <td>${template.route.name}</td>
                <td><a href="<c:url value='/templateInfo/${template.id}'/>">Info</a></td>
                <td><a href="<c:url value='/removeTemplate/${template.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<spring:url value="/addTemplate"  var="addTemplateUrl"></spring:url>
<form:form action="${addTemplateUrl}" modelAttribute ="template" method="post">
    <p>Add new template </p>
    <spring:bind path="name">
        <p>Name:<form:input type="text" path="name" value = ""/> </p>
    </spring:bind>
    <p>Route:
        <select name = "routeId">
            <option value="" style="display:none;"></option>
            <c:forEach items="${routesList}" var="route">
                <option value="${route.id}">${route.name}</option>
            </c:forEach>
        </select>

    </p>
    <p><input type="submit" value="Submit" /> </p>
    <sec:csrfInput/>
</form:form>
</body>




</html>
