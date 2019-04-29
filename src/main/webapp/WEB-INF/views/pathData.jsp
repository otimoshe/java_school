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
    <title>Path Data</title>

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

</head>
<body>
<h1>Path Details</h1>

<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Station</th>
        <th width="120">Next station</th>
        <th width="120">Distance</th>

    </tr>
    <tr>
        <form:form action="/path/${path.id}"  modelAttribute ="path" method="post">
        <td><form:input type ="text" path="id" value = "${station.id}" readonly="true"/></td>
        <td>${path.station.name}</td>
            <td>${path.nextStation.name}</td>
            <td><form:input type ="number" path="distance"   min="0.1" step="0.1" value = "${station.distance}" /></td>
        <p><input type="submit" value="Submit" /> </p>
            <sec:csrfInput/>
        </form:form>
</body>
</tr>
<a href="/admin">Back to admin page</a>


</table>
</body>
</html>