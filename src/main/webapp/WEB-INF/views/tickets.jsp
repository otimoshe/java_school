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
<jsp:include page="sideBar.jsp"/>
<html>
<head>
    <title>Ticket page</title>
</head>
<body>
<div id="content">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span6">
                <div class="widget-box">
                    <div class="widget-title"><span class="icon"><i class="icon-th"></i></span>
                        <h5>Tickets list</h5>
                    </div>
                    <c:if test="${!empty ticketList}">
                        <table class="table table-bordered data-table">
                            <thead>
                            <tr>
                                <th>Passenger name</th>
                                <th>Passenger lastname</th>
                                <th>Passenger birthday</th>
                                <th>Departure station</th>
                                <th>Arrival station</th>
                                <th>Seat number</th>
                                <th>Price</th>
                            </tr>
                            </thead>
                            <tbody>
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
                            </tbody>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
