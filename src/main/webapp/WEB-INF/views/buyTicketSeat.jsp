<%--
  Created by IntelliJ IDEA.
  User: otimoshe
  Date: 01.04.2019
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false" %>

<link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css"/>
<link rel="stylesheet" href="${contextPath}/resources/css/bootstrap-responsive.min.css"/>
<link rel="stylesheet" href="${contextPath}/resources/css/fullcalendar.css"/>
<link rel="stylesheet" href="${contextPath}/resources/css/matrix-style.css"/>
<link rel="stylesheet" href="${contextPath}/resources/css/matrix-media.css"/>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Buy Ticket</title>
</head>
<body>
<div id="content">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span6">
                <div class="widget-box">
                    <div class="widget-title"><span class="icon"> <i class="icon-align-justify"></i> </span>
                        <h5>Pick a seat </h5>
                    </div>
                    <div class="widget-content nopadding">
                        <form:form action="/buyTicket/seat" modelAttribute="ticketForm" method="post">
                            <spring:bind path="seatId">
                                <select name="seatId" path="seatId">
                                    <c:forEach items="${seatsList}" var="seat">
                                        <option value="${seat.id}">${seat.number}</option>
                                    </c:forEach>
                                </select>
                            </spring:bind>
                            <p><input type="submit" value="Submit" class="btn btn-success"/></p>
                            <sec:csrfInput/>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
