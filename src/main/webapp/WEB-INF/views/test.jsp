<%--
  Created by IntelliJ IDEA.
  User: otimoshe
  Date: 11.03.2019
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html xmlns:th="http://www.thymeleaf.org">
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/one"  modelAttribute ="train" method="post">
    <p>Id: <form:input path="id" /></p>
    <p>NumberOfSeats:<form:input path="numberOfSeats" /></p>
    <p><input type="submit" value="Submit" /> </p>
        <sec:csrfInput/>
</form:form>
</body>
</html>
