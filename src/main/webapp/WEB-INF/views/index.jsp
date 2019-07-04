<%--
  Created by IntelliJ IDEA.
  User: otimoshe
  Date: 07.05.2019
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>RailwayApp</title>

    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=PT+Sans:400" rel="stylesheet">

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet" href="${contextPath}/resources/css/mainpage.css"/>

    <!-- Custom stlylesheet -->
    <link type="text/css" rel="stylesheet" href="${contextPath}/resources/css/style.css"/>

    <link href="${contextPath}/resources/css/select2.css" rel="stylesheet"/>
    <script src="${contextPath}/resources/js/jquery-3.3.1.js"></script>
    <script src="${contextPath}/resources/js/select2.min.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/css/bootstrap-responsive.min.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/css/fullcalendar.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/css/matrix-style.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/css/matrix-media.css"/>
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
<div id="booking" class="section">
    <div class="section-center">
        <div class="container">
            <div class="row">
                <div class="booking-form">
                    <form action="/findTrips" onsubmit="return validate_form()">

                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <span class="form-label">From</span>
                                    <select name="departStation" class="js-example-basic-single"  id="departStation">
                                        <c:forEach items="${stations}" var="station">
                                            <option value="${station.name}">${station.name}</option>
                                        </c:forEach>
                                    </select>
                                    <%--   <input class="form-control" type="text" placeholder="City or station"> --%>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <span class="form-label">To</span>
                                    <select name="arriveStation" class="js-example-basic-single"  id="arriveStation">
                                        <c:forEach items="${stations}" var="station">
                                            <option value="${station.name}">${station.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <div class="form-group">
                                    <span class="form-label">Departing</span>
                                    <input class="form-control" type="date" required name="date">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <div class="form-btn">
                                    <button class="submit-btn" type="submit">Show trips</button>
                                </div>
                            </div>
                        </div>
                        <div id="alert"></div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $('.js-example-basic-single').prepend('<option selected></option>').select2({
            placeholder: "Select a city or airport",
            allowClear: true
        });
    });
    
    function validate_form() {
        var validate = true;
        document.getElementById('alert').innerHTML = '';
        console.log(" val = "+ $("#departStation").val());
        if ($("#departStation").val()=="" ){
            document.getElementById('alert').innerHTML += "<p style='color:red'>" + "Field \"FROM\"  should not be empty!!" + "</p>";
            validate = false;
        }
        if ($("#arriveStation").val()=="" ){
            document.getElementById('alert').innerHTML += "<p style='color:red'>" + "Field \"TO\"  should not be empty!!" + "</p>";
            validate = false;
        }
        return validate;
    }
</script>


</html>
