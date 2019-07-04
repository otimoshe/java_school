<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false" %>
<jsp:include page="sideBar.jsp"/>
<html>
<head>
    <title>Stations Page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript">
        function getStationNameList() {
            var stationNameList = [], station;
            <c:forEach var="station" items="${listStations}">
            station = "${station.name}";
            stationNameList.push(station);
            </c:forEach>
            return stationNameList;
        }

        function validate_form() {
            var validate = true, stations = getStationNameList();
            console.log(stations)
            if (document.getElementById('stationName').value == "") {
                document.getElementById('alert').innerHTML = "Station name should not be empty!";
                validate = false;
            }
            var stationName = document.getElementById('stationName').value
            if (stations.length !== 0) {
                for (var i = 0; i < stations.length; i++) {
                    if (stationName == stations[i]) {
                        document.getElementById('alert').innerHTML = "This station already exist!";
                        validate = false;
                    }
                }
            }
            return validate;
        }
    </script>
</head>
<body>
<div id="content">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span6">
                <div class="widget-box">
                    <div class="widget-title"><span class="icon"><i class="icon-th"></i></span>
                        <h5>Stations list</h5>
                    </div>
                    <c:if test="${!empty listStations}">
                        <table class="table table-bordered data-table">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listStations}" var="station">
                                <tr>
                                    <td>${station.id}</td>
                                    <td>${station.name}</td>
                                    <td><a href="<c:url value='/station/${station.id}'/>">Edit</a></td>
                                    <td><a href="<c:url value='/removeStation/${station.id}'/>">Delete</a></td>
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
                            <h5>Add a Station</h5>
                        </div>
                        <div class="widget-content nopadding">
                            <form:form action="/station" modelAttribute="station" method="post"
                                       onsubmit=" return validate_form()" class="form-horizontal">
                                <div class="control-group">
                                    <label class="control-label"> Name:</label>
                                    <div class="controls">
                                        <form:input path="name" value="" id="stationName" class="span11"/>
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
</div>
</body>
</html>
