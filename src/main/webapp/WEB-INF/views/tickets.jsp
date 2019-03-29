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
    <title>Ticket page</title>

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

<c:if test="${!empty ticketList}">
    <table class="tg">
        <tr>
            <th width="80">Passenger name</th>
            <th width="80">Passenger lastname</th>
            <th width="80">Passenger birthday</th>
            <th width="80">Departure station</th>
            <th width="80">Arrival station</th>
            <th width="80">Seat number</th>
            <th width="80">Price</th>


        </tr>

        <c:forEach items="${ticketList}" var="ticket">
            <tr>
                <td>${ticket.passenger.name}</td>
                <td>${ticket.passenger.lastName}</td>
                <td>${ticket.passenger.birthday}</td>
                <td>${ticket.departureStation.name}</td>
                <td>${ticket.arrivalStation.name}</td>
                <td>${ticket.seat.number}</td>
                <td>${ticket.price}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
