<%--
  Created by IntelliJ IDEA.
  User: otimoshe
  Date: 10.03.2019
  Time: 21:33
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
    <title>Trips Page</title>

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

<a href="/">Back to main menu</a>

<br/>
<br/>

<h1>Trip List</h1>

<c:if test="${!empty listTrips}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="80">Route name</th>
            <th width="80">Departure Date</th>
            <th width="60">Train id</th>
            <th width="60">Schedule</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listTrips}" var="trip">
            <tr>
                <td>${trip.id}</td>
                <td>${trip.route.name}</td>
                <td>${trip.departureDate}</td>
                <td>${trip.train.id}</td>
                <td> <a href="/tripSchedule/${trip.id}" target="_blank"> Schedule</a></td>
                <td><a href="<c:url value='/removeTrip/${trip.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Trip</h1>

<form:form action="/trips"  modelAttribute ="trip" method="post" >

    <p>Route:
        <select name = "routeId"   >
        <c:forEach items="${routeList}" var="route">
        <option value="${route.id}">${route.name}</option>
        </c:forEach>
        </select></p>
    <p>Date
        <spring:bind path="departureDate">
        <form:input type="date"  path="departureDate"/></p>
        </spring:bind>
    <p>Train
        <select name = "trainId"   >
            <c:forEach items="${trainList}" var="train">
                <option value="${train.id}">${train.id}</option>
            </c:forEach>
        </select></p>
    <p><input type="submit" value="Submit" /> </p>
    <sec:csrfInput/>
</form:form>






</body>
</html>
