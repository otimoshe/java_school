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

<h1>Train List</h1>

<c:if test="${!empty listTrains}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="80">Seats</th>

            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listTrains}" var="train">
            <tr>
                <td>${train.id}</td>
                <td><a href="/traindata/${train.id}" target="_blank">${train.numberOfSeats}</a></td>

                <td><a href="<c:url value='/edit/${train.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${train.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Train</h1>

<form:form action="/trains"  modelAttribute ="train" method="post">
    <p>NumberOfSeats:<form:input path="numberOfSeats" value = ""/></p>
    <p><input type="submit" value="Submit" /> </p>
    <sec:csrfInput/>
</form:form>






</body>
</html>