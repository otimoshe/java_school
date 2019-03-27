<%--
  Created by IntelliJ IDEA.
  User: otimoshe
  Date: 27.03.2019
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schedule page</title>
</head>
<body>

<c:if test="${!empty scheduleList}">
    <table class="tg">
        <tr>
            <th width="80">Station</th>
            <th width="80">Arrival time</th>
            <th width="80">Departure time</th>

        </tr>
        <c:forEach items="${scheduleList}" var="schedule">
            <tr>
                <td>${schedule.station.name}</td>
                <td>${schedule.station.arrivalDate}</td>
                <td>${schedule.station.departureDate}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
