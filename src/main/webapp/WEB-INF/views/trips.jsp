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
<jsp:include page="sideBar.jsp"/>
<html>
<head>
    <title>Trips Page</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <meta name="_csrf" content="${_csrf.token}"/>
    <sec:csrfMetaTags/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
</head>
<body>
<div id="content">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span6">
                <div class="widget-box">
                    <div class="widget-title"><span class="icon"><i class="icon-th"></i></span>
                        <h5>Trips list</h5>
                    </div>
                    <c:if test="${!empty listTrips}">
                        <table class="table table-bordered data-table">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Route name</th>
                                <th>Departure Date</th>
                                <th>Train id</th>
                                <th>Schedule</th>
                                <th>Tickets</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listTrips}" var="trip">
                                <tr>
                                    <td>${trip.id}</td>
                                    <td>${trip.route.name}</td>
                                    <td>${trip.departureDate}</td>
                                    <td>${trip.train.id}</td>
                                    <td><a href="/trip/schedule/${trip.id}" target="_blank"> Schedule</a></td>

                                    <td><a href="/tripTickets/${trip.id}" target="_blank"> Tickets</a></td>
                                    <td><a href="<c:url value='/removeTrip/${trip.id}'/>">Delete</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <hr>
            <div class="row-fluid">
                <div class="span6">
                    <div class="widget-box">
                        <div class="widget-title"><span class="icon"> <i class="icon-align-justify"></i> </span>
                            <h5>Add Trip</h5>
                        </div>
                        <div class="widget-content nopadding">
                            <form:form action="/trips" modelAttribute="trip" method="post" class="form-horizontal">
                            <div class="control-group">
                                <label class="control-label"> Route:</label>
                                <div class="controls">
                                    <select name="routeId" onchange="doAjax()" class="span11">
                                        <option value="" style="display:none;"></option>
                                        <c:forEach items="${routeList}" var="route">
                                            <option value="${route.id}">${route.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Time template:</label>
                                <div class="controls">
                                    <select name="templateId" class="span11">
                                        <option value="" style="display:none;"></option>
                                    </select>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label"> Date:</label>
                                <div class="controls">
                                    <spring:bind path="departureDate">
                                        <form:input type="date" path="departureDate" class="span11"/>
                                    </spring:bind>
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label">Train:</label>
                                <div class="controls">
                                    <select name="trainId" class="span11">
                                        <c:forEach items="${trainList}" var="train">
                                            <option value="${train.id}">${train.id}</option>
                                        </c:forEach>
                                    </select></div>
                            </div>
                                <div class="form-actions">
                                    <button type="submit" class="btn btn-success">Save</button>
                                </div>
                                <sec:csrfInput/>
                            </form:form>

</body>
</html>


<script type="text/javascript">
    // $('#date').select(testMessage);
    var csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
    var csrfHeader = $("meta[name='_csrf_header']").attr("content");
    var csrfToken = $("meta[name='_csrf']").attr("content");

    function doAjax() {
        console.log($("select[name='routeId']").val());
        var headers = {};
        headers[csrfHeader] = csrfToken;
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/routeId",
            headers: headers,
            data: JSON.stringify({"id": $("select[name='routeId']").val()}),
            //data:{stationId: $('#station').val(),date: $('#date').val()},
            dataType: 'json',
            success: function (data) {
                console.log(data);
                var html = '';
                var len = data.length;
                if (len > 0) {
                    for (var i = 0; i < len; i++) {
                        html += '<option value=' + data[i].id + '>' + data[i].name + '</option>';
                    }
                    $("select[name='templateId']").append(html);
                }
            }
        })
    }
</script>