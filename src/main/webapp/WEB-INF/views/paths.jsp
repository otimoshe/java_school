<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false" %>
<jsp:include page="sideBar.jsp"/>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Path Page</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <link rel="stylesheet" href="${contextPath}/resources/css/uniform.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/css/select2.css"/>

    <script type="text/javascript">
        function getPathList() {
            var pathList = [], path;
            <c:forEach var="path" items="${listPaths}">
            path = {};
            path.station = "${path.station.name}";
            path.nextStation = "${path.nextStation.name}";
            pathList.push(path);
            </c:forEach>
            console.log(pathList);
            return pathList;
        }

        function validate_form() {
            var validate = true;
            document.getElementById('alert').innerHTML = "";
            if (document.getElementById('station').value == document.getElementById('nextStation').value) {
                document.getElementById('alert').innerHTML += "<p>" + "Airpots must not be the same" + "</p>";
                validate = false;
            }
            var paths = getPathList();
            var station = document.getElementById('station').options[document.getElementById('station').selectedIndex].text;
            var nextStation = document.getElementById('nextStation').options[document.getElementById('nextStation').selectedIndex].text;

            // validate new path
            for (var i = 0; i < paths.length; i++) {
                if ((paths[i].station == station) && (paths[i].nextStation == nextStation) ||
                    ((paths[i].station == nextStation) && (paths[i].nextStation == station))) {
                    document.getElementById('alert').innerHTML += "<p>" + "This path already exist" + "</p>";
                    validate = false;
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
                        <h5>Paths list</h5>
                    </div>
                    <c:if test="${!empty listPaths}">

                        <table class="table table-bordered data-table">
                            <thead>
                            <tr>
                                <th >ID</th>
                                <th >Airport</th>
                                <th >Airport</th>
                                <th >Distance</th>
                                <th >Edit</th>
                                <th >Delete</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr class="gradeX">
                                <c:forEach items="${listPaths}" var="path">
                            <tr>
                                <td>${path.id}</td>
                                <td>${path.station.name}</td>
                                <td>${path.nextStation.name}</td>
                                <td>${path.distance}</td>
                                <td><a href="<c:url value='/path/${path.id}'/>">Edit</a></td>
                                <td><a href="<c:url value='/path/remove/${path.id}'/>">Delete</a></td>
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
                            <h5>Add Path</h5>
                        </div>
                        <div class="widget-content nopadding">
                            <spring:url value="/path" var="pathUrl"></spring:url>
                            <form:form action="${pathUrl}" modelAttribute="path" method="post" onsubmit="return validate_form()"
                                       class="form-horizontal">
                                <spring:bind path="distance">
                                    <div class="control-group">
                                        <label class="control-label"> Distance:</label>
                                        <div class="controls">
                                            <form:input type="number" path="distance" id="distance" value="0.1"
                                                        min="0.1" step="0.1" class="span11" required="true" />
                                        </div>
                                    </div>
                                </spring:bind>
                                <div class="control-group">
                                    <label class="control-label">Airports:</label>
                                    <div class="controls">
                                        <select name="stationId" id="station">
                                            <c:forEach items="${listStations}" var="station">
                                                <option value="${station.id}">${station.name}</option>
                                            </c:forEach>
                                        </select>
                                        <select name="nextStationId" id="nextStation">
                                            <c:forEach items="${listStations}" var="nextStation">
                                                <option value="${nextStation.id}">${nextStation.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-actions">
                                    <button type="submit" class="btn btn-success">Save</button>
                                </div>
                                <sec:csrfInput/>
                            </form:form>
                            <div id="alert"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
