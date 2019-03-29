<%--
  Created by IntelliJ IDEA.
  User: otimoshe
  Date: 27.03.2019
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false" %>
<html>
<head>
    <title>Schedule page</title>

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

<a href="/admin">Back to admin page</a>

<c:if test="${!empty seatsList}">
    <table class="tg">
        <tr>
            <th width="80">Number</th>
            <th width="80">Available</th>
            <th width="80"></th>

        </tr>
        <c:set var = "available" value = "${true}"/>
        <c:forEach items="${seatsList}" var="seat">
            <tr>
                <td>${seat.number}</td>
                <div style="display: none">  ${available} = ${true} </div>
                <c:forEach items="${seat.statuses}" var="status">
                    <c:set var = "available" value = "${true}"/>
                    <c:if test="${status} == ${false}">
                            ${available} = ${false}
                     </c:if>
                </c:forEach>
                <td>${available}</td>

            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
