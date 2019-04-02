<%--
  Created by IntelliJ IDEA.
  User: otimoshe
  Date: 01.04.2019
  Time: 19:12
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
    <title>Buy Ticket</title>
</head>
<body>

<form:form action="/buyForTrip/${trip.id}"  modelAttribute="ticket" method="post" >
        <p>Pick a seat</p>
        <select name = "seatId" >
            <c:forEach items="${seatsList}" var="seat">
                <option value="${seat.id}">${seat.number}</option>
            </c:forEach>
        </select></p>

    <p><input type="submit" value="Submit" /> </p>
    <sec:csrfInput/>
</form:form>

</body>
</html>
