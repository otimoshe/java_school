<%--
  Created by IntelliJ IDEA.
  User: otimoshe
  Date: 01.04.2019
  Time: 14:07
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
    <title>Available trips</title>
</head>
<body>

<c:if test="${!empty listTrips}">
    <table class="tg">
        <tr>

            <th width="80">Route name</th>
            <th width="80">Departure Date</th>
            <th width="80">Departure Station</th>
            <th width="80">Arrival Date</th>
            <th width="80">Arrival Station</th>
            <th width="60">Tickets</th>

        </tr>
        <c:forEach items="${listTrips}" var="trip">
            <tr>

                <td>${trip.route.name}</td>
                <td>${trip.departureDate}</td>
                <td>${trip.route.first_station.name}</td>
                <td></td>
                <td>${trip.route.stationList.get(trip.route.stationList.size() - 1).name}</td>
                <td> <a href="/buyTicket/${trip.id}" target="_blank"> <input type="button" value="Buy Ticket"></a></td>

            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
