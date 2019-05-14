<%--
  Created by IntelliJ IDEA.
  User: otimoshe
  Date: 13.05.2019
  Time: 19:44
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
    <title>Pick a seat</title>
</head>
<body>

<form:form action="/buyTicket/confirmation"  modelAttribute="ticketForm" method="post" >

    <p>Pick a passenger</p>
    <spring:bind path="passengerId">
        <select name = "passengerId" path="passengerId">
            <c:forEach items="${passengerList}" var="passenger">
                <option value="${passenger.id}">${passenger.name} ${passenger.lastName}</option>
            </c:forEach>
        </select>
    </spring:bind>
    <p><input type="submit" value="Submit" /> </p>
    <sec:csrfInput/>
</form:form>

</body>
</html>