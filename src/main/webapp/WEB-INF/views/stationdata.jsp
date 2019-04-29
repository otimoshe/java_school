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

<html>
<head>
    <title>StationData</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
    <script type="text/javascript">
        function getStationNameList(){
            var stationNameList = [],station;
            <c:forEach var="station" items="${listStations}">
            station = "${station.name}";
            stationNameList.push(station);
            </c:forEach>
            return stationNameList;
        }

        function check_form( ){
            var validate = true, stations = getStationNameList();
            if (document.getElementById('stationName').value == ""){
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
<h1>Station Details</h1>
<a href="/admin">Back to admin page</a>
<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Name</th>

    </tr>
    <tr>
        <form:form action="/station"  modelAttribute ="station" method="post" onsubmit="return check_form()">
            <td><form:input type ="text" path="id" value = "${station.id}" readonly="true"/></td>
             <td><form:input type ="text" id = "stationName" path="name" value = "${station.name}  "/></td>
            <div id ="alert"></div>
            <p><input type="submit" value="Submit" /> </p>
            <sec:csrfInput/>
        </form:form>
</body>
</tr>
<a href="/admin">Back to admin page</a>


</table>
</body>
</html>