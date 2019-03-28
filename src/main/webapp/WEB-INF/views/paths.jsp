<%--
  Created by IntelliJ IDEA.
  User: otimoshe
  Date: 22.03.2019
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false" %>
<html>
<head>
    <title>Path Page</title>

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

<br/>
<br/>

<h1>Paths List</h1>

<c:if test="${!empty listPaths}">
<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="80">Station </th>
        <th width="80">Station </th>
        <th width="60">Distance</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listPaths}" var="path">
        <tr>
            <td>${path.id}</td>
            <td>${path.station.name}</td>
            <td>${path.nextStation.name}</td>
            <td>${path.distance}</td>
            <td><a href="<c:url value='/paths/remove/${path.id}'/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</c:if>


<h1>Add a Path</h1>

<spring:url value="/paths" var="pathUrl"></spring:url>
<form:form action="${pathUrl}" modelAttribute ="path" method="post">
    <spring:bind path="distance">
    <p>Distance:<form:input type="number" path="distance" value = ""/> </p>
    </spring:bind>
<p>Stations:
    <select name = "stationId"   >
    <c:forEach items="${listStations}" var="station">
    <option value="${station.id}">${station.name}</option>
    </c:forEach>
    </select>
   <select name ="nextStationId">
    <c:forEach items="${listStations}" var="nextStation">
    <option value="${nextStation.id}">${nextStation.name}</option>
    </c:forEach>
    </select>

<p><input type="submit" value="Submit" /> </p>
    <sec:csrfInput/>
</form:form>
