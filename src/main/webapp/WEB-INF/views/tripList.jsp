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

<c:if test="${!empty searchResult}">
    <table class="tg">
        <tr>
            <th width="80">Train number</th>
            <th width="80">Route name</th>
            <th width="80">Departure Date</th>
            <th width="80">Departure Time</th>
            <th width="80">Arrival Date</th>
            <th width="80">Arrival Time</th>
            <th width="80">Price</th>

        </tr>
        <c:forEach items="${searchResult}" var="result">
            <form:form method="post" action="buyTicket" modelAttribute="ticketForm">
                <tr>
                    <spring:bind path="trainId">
                        <td>${result.trainId}</td>
                        <form:input path="trainId" type="hidden" value="${result.trainId}"></form:input>
                    </spring:bind>
                    <spring:bind path="routeName">
                        <td>${result.routeName}</td>
                        <form:input path="routeName" type="hidden" value="${result.routeName}"></form:input>
                    </spring:bind>
                    <spring:bind path="departureDate">
                        <td>${result.departureDate}</td>
                        <form:input path="departureDate" type="hidden" value="${result.departureDate}"></form:input>
                    </spring:bind>
                    <spring:bind path="departureTime">
                        <td>${result.departureTime}</td>
                        <form:input path="departureTime" type="hidden" value="${result.departureTime}"></form:input>
                    </spring:bind>
                    <spring:bind path="arriveDate">
                        <td>${result.arriveDate}</td>
                        <form:input path="arriveDate" type="hidden" value="${result.arriveDate}"></form:input>
                    </spring:bind>
                    <spring:bind path="arriveTime">
                        <td>${result.arriveTime}</td>
                        <form:input path="arriveTime" type="hidden" value="${result.arriveTime}"></form:input>
                    </spring:bind>
                    <spring:bind path="price">
                        <td>${result.price}</td>
                        <form:input path="price" type="hidden" value="${result.price}"></form:input>
                    </spring:bind>
                    <spring:bind path="tripId">
                        <form:input path="tripId" type="hidden" value="${result.tripId}"></form:input>
                    </spring:bind>
                    <spring:bind path="departStationId">
                        <form:input path="departStationId" type="hidden" value="${result.departStationId}"></form:input>
                    </spring:bind>
                    <spring:bind path="arriveStationId">
                        <form:input path="arriveStationId" type="hidden" value="${result.arriveStationId}"></form:input>
                    </spring:bind>
                    <td>
                        <button type="submit">Buy Ticket</button>
                    </td>
                </tr>
            </form:form>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
