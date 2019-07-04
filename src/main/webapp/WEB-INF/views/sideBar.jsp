<%--
  Created by IntelliJ IDEA.
  User: otimoshe
  Date: 04.05.2019
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${contextPath}/resources/css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="${contextPath}/resources/css/fullcalendar.css" />
    <link rel="stylesheet" href="${contextPath}/resources/css/matrix-style.css" />
    <link rel="stylesheet" href="${contextPath}/resources/css/matrix-media.css" />
    <link href="${contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>


<!--Header-part-->
<div id="header">
    <h1><a >Admin Panel</a></h1>
</div>
<!--close-Header-part-->

<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">

</div>
<div id="search">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <buttom class="btn btn-success btn-large" onclick="document.forms['logoutForm'].submit()">Logout</buttom>
    </c:if>
</div>
<!--sidebar-menu-->
<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> Dashboard2</a>
    <ul>
        <li ><a href="/trains"><i class="icon icon-home"></i> <span>Trains</span></a> </li>
        <li> <a href="/stations"><i class="icon icon-signal"></i> <span>Stations</span></a> </li>
        <li> <a href="/trainModels"><i class="icon icon-inbox"></i> <span>TrainModels</span></a> </li>
        <li><a href="/paths"><i class="icon icon-th"></i> <span>Paths</span></a></li>
        <li><a href="/routes"><i class="icon icon-fullscreen"></i> <span>Routes</span></a></li>
        <li><a href="/templates"><i class="icon icon-tint"></i> <span>Templates</span></a></li>
        <li><a href="/trips"><i class="icon icon-pencil"></i> <span>Trips</span></a></li>
        <li><a href="/userSchedule"><i class="icon icon-pencil"></i> <span>Station schedule</span></a></li>
    </ul>
</div>
</body>
</html>