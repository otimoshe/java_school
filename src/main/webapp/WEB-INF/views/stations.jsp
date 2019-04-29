<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false" %>
<html>
<head>
    <title>Staions Page</title>

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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript">
        function getStationNameList(){
            var stationNameList = [],station;
            <c:forEach var="station" items="${listStations}">
            station = "${station.name}";
            stationNameList.push(station);
            </c:forEach>
            return stationNameList;
        }

        function validate_form( ){
            var validate = true, stations = getStationNameList() ;
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

<a href="/admin">Back to admin page</a>

<br/>
<br/>

<h1>Stations List</h1>

<c:if test="${!empty listStations}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="80">Name</th>

            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listStations}" var="station">
            <tr>
                <td>${station.id}</td>
                <td>${station.name}</td>
                <td><a href="<c:url value='/station/${station.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/removeStation/${station.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Station</h1>

<form:form action="/station"  modelAttribute ="station" method="post" onsubmit=" return validate_form()">
    <p>Name:<form:input path="name" value = ""  id="stationName" /></p>
    <div id ="alert"> </div>
    <p><input type="submit" value="Submit" /> </p>
    <sec:csrfInput/>
</form:form>
</body>
</html>
