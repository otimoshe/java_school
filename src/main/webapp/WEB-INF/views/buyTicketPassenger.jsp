<%--
  Created by IntelliJ IDEA.
  User: otimoshe
  Date: 13.05.2019
  Time: 19:44
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
    <title>Pick a seat</title>
</head>
<body>
<div id="content">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span6">
                <div class="widget-box">
                    <div class="widget-title"><span class="icon"> <i class="icon-align-justify"></i> </span>
                        <h5>Pick a passenger</h5>
                    </div>
                    <div class="widget-content nopadding">
                        <form:form action="/buyTicket/confirmation" modelAttribute="ticketForm" method="post"
                                   class="form-horizontal">
                            <spring:bind path="passengerId">
                                <select name="passengerId" path="passengerId">
                                    <c:forEach items="${passengerList}" var="passenger">
                                        <option value="${passenger.id}">${passenger.name} ${passenger.lastName}</option>
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

    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span6">
                <div class="widget-box">
                    <div class="widget-title"><span class="icon"> <i class="icon-align-justify"></i> </span>
                        <h5>Add Passenger</h5>
                    </div>
                    <div class="widget-content nopadding">
                        <form:form action="/passenger" modelAttribute="passenger" method="post"
                                   class="form-horizontal">
                            <div class="control-group">
                                <label class="control-label"> Name:</label>
                                <div class="controls">
                                    <form:input type="text" path="name" required="true"
                                                class="span11"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label"> Last name:</label>
                                <div class="controls">
                                    <form:input type="text" path="lastName" required="true"
                                                class="span11"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label"> birthday:</label>
                                <div class="controls">
                                    <form:input type="date" path="birhtDate" required="true"
                                                class="span11"/>
                                </div>
                            </div>
                            <div id="alert"></div>
                            <div class="form-actions">
                                <button type="submit" class="btn btn-success">Save</button>
                            </div>
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