<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false" %>
<html>
<head>
    <title>Path Page</title>

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
        function getPathList(){
            var pathList = [],path;
            <c:forEach var="path" items="${listPaths}">
            path = {};
            path.station= "${path.station.name}";
            path.nextStation= "${path.nextStation.name}";
            pathList.push(path);
            </c:forEach>
            console.log(pathList);
            return pathList;
        }

        function validate_form(){
            var  validate = true;
            document.getElementById('alert').innerHTML = "";
            if (document.getElementById('station').value == document.getElementById('nextStation').value){
                document.getElementById('alert').innerHTML  += "<p>"+"Stations must not be the same" +"</p>";
                validate = false;
            }
            var paths       = getPathList();
            var station     = document.getElementById('station').options[document.getElementById('station').selectedIndex].text ;
            var nextStation = document.getElementById('nextStation').options[document.getElementById('nextStation').selectedIndex].text;

            // validate new path
            for (var i = 0; i < paths.length; i++){
                if ((paths[i].station == station) && (paths[i].nextStation == nextStation) ||
                    ((paths[i].station == nextStation) && (paths[i].nextStation == station))){
                    document.getElementById('alert').innerHTML  += "<p>"+"This path already exist" +"</p>";
                    validate = false;
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

<h1>Paths List</h1>

<c:if test="${!empty listPaths}">
<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="80">Station </th>
        <th width="80">Station </th>
        <th width="60">Distance</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
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
</table>
</c:if>


<h1>Add a Path</h1>
<spring:url value="/path" var="pathUrl"></spring:url>
<form:form action="${pathUrl}" modelAttribute ="path" method="post" onsubmit="return validate_form() ">
    <spring:bind path="distance">
    <p>Distance:<form:input type="number" path="distance" id ="distance" value = "0.1" min="0.1" step="0.1"/> </p>
    </spring:bind>
<p>Stations:
    <select name = "stationId" id="station">
    <c:forEach items="${listStations}" var="station">
    <option value="${station.id}">${station.name}</option>
    </c:forEach>
    </select>
   <select name ="nextStationId" id ="nextStation">
    <c:forEach items="${listStations}" var="nextStation">
    <option value="${nextStation.id}">${nextStation.name}</option>
    </c:forEach>
    </select>

<p><input type="submit" value="Submit" /> </p>
    <sec:csrfInput/>
</form:form>
<div id ="alert"> </div>
</body>
