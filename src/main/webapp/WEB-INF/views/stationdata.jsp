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
<%@ page session="false" %>
<jsp:include page="sideBar.jsp"/>
<html>
<head>
    <title>Station Data</title>
    <script type="text/javascript">
        function getStationNameList() {
            var stationNameList = [], station;
            <c:forEach var="station" items="${listStations}">
            station = "${station.name}";
            stationNameList.push(station);
            </c:forEach>
            return stationNameList;
        }

        function check_form() {
            var validate = true, stations = getStationNameList();
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
                    <table class="table table-bordered data-table">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr class="gradeX">
                            <form:form action="/station" modelAttribute="station" method="post"
                                       onsubmit="return check_form()" class="form-horizontal">
                            <td><form:input type="text" path="id" value="${station.id}" readonly="true" class="span11"/></td>
                            <td><form:input type="text" id="stationName" path="name" value="${station.name}" class="span11"/></td>
                            <div id="alert"></div>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <button type="submit" class="btn btn-info">Edit</button>
            </div>
            <sec:csrfInput/>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>