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

    <script type="text/javascript">
        function validate_form(){
            if (parseInt(document.getElementById('numberOfSeats').value) <= 0){
                document.getElementById('alert').innerHTML  = "Number of seats must be greater than 0";
                return false;
            } else {
                console.log("ytyy");
                return true;
            }
        }
    </script>

</head>
<body>

<a href="/admin">Back to admin page</a>

<br/>
<br/>

<h1>Train List</h1>

<c:if test="${!empty listTrains}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="80">Seats</th>
            <th width="80">Model</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listTrains}" var="train">
            <tr>
                <td>${train.id}</td>
                <td>${train.numberOfSeats}</td>
                <td>${train.trainModel.name}</td>
                <td><a href="<c:url value='/train/${train.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${train.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<h1>Add a Train</h1>

<form:form action="/train"  modelAttribute ="train" method="post" onsubmit="return validate_form()">
    <p>NumberOfSeats:<form:input type ="number" path="numberOfSeats" value = "" id="numberOfSeats"/></p>
    <p>Model:
        <form:select path="trainModel.id">
    <c:forEach items="${listTrainModels}" var="model">
        <option value="${model.id}">${model.name}</option>
    </c:forEach>
</form:select>
    <div id="alert"></div>
    <p><input type="submit" value="Submit" /> </p>
    <sec:csrfInput/>
</form:form>
</body>
</html>
