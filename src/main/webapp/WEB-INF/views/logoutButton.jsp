<%--
  Created by IntelliJ IDEA.
  User: otimoshe
  Date: 17.05.2019
  Time: 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css"/>
<link rel="stylesheet" href="${contextPath}/resources/css/bootstrap-responsive.min.css"/>
<link rel="stylesheet" href="${contextPath}/resources/css/fullcalendar.css"/>
<link rel="stylesheet" href="${contextPath}/resources/css/matrix-style.css"/>
<link rel="stylesheet" href="${contextPath}/resources/css/matrix-media.css"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="search">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <buttom class="btn btn-success btn-large" onclick="document.forms['logoutForm'].submit()">Logout</buttom>
    </c:if>
</div>
</body>
</html>
