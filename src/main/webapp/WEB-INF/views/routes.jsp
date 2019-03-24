<%--
  Created by IntelliJ IDEA.
  User: otimoshe
  Date: 23.03.2019
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false" %>
<html>
<head>
    <title>Train Page</title>

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

<a href="/">Back to main menu</a>

<br/>
<br/>

<h1>Route List</h1>

<c:if test="${!empty listRoutes}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="80">Name</th>

            <th >Stations</th>
      <%--      <c:forEach items="${listRoutes.route.stationList}" var="station">
                <th width="80">Station</th>
            </c:forEach>  --%>
        </tr>
        <c:forEach items="${listRoutes}" var="route">
            <tr>
                <td>${route.id}</td>
                <td>${route.name}</td>
                <c:forEach items="${route.stationList}" var="station">
                <td>${station.name}</td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Route</h1>






</body>
</html>