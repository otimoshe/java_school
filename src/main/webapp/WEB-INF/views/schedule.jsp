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
    <title>Schedule page</title>
</head>
<body>
<div id="content">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span6">
                <div class="widget-box">
                    <div class="widget-title"><span class="icon"><i class="icon-th"></i></span>
                        <h5>Schedule list</h5>
                    </div>
                    <c:if test="${!empty scheduleList}">
                        <table class="table table-bordered data-table">
                            <thead>
                            <tr>
                                <th>Station</th>
                                <th>Arrival date</th>
                                <th>Arrival time</th>
                                <th>Departure date</th>
                                <th>Departure time</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${scheduleList}" var="schedule">
                                <tr>
                                    <td>${schedule.station.name}</td>
                                    <td>${schedule.arrivalDate}</td>
                                    <td>${schedule.arrivalTime}</td>
                                    <td>${schedule.departureDate}</td>
                                    <td>${schedule.departureTime}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if></div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
