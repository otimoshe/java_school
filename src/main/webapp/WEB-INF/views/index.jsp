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

</head>

<body>
<div id="booking" class="section">
    <div class="section-center">
        <div class="container">
            <div class="row">
                <div class="booking-form">
                    <form action="/findTrips">
                        <div class="form-group">
                            <div class="form-checkbox">
                                <label for="roundtrip">
                                    <input type="radio" id="roundtrip" name="flight-type">
                                    <span></span>Roundtrip
                                </label>
                                <label for="one-way">
                                    <input type="radio" id="one-way" name="flight-type">
                                    <span></span>One way
                                </label>
                                <label for="multi-city">
                                    <input type="checkbox" id="multi-city" name="flight-type">
                                    <span></span>Multi-City
                                </label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <span class="form-label">From</span>
                                    <select name="departStation" class="js-example-basic-single">
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
                                    <select name="arriveStation" class="js-example-basic-single">
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
                            <div class="col-md-3">
                                <div class="form-group">
                                    <span class="form-label">Returning</span>
                                    <input class="form-control" type="date">
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="form-group">
                                    <span class="form-label">Adults (18+)</span>
                                    <select class="form-control">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                    </select>
                                    <span class="select-arrow"></span>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="form-group">
                                    <span class="form-label">Children (0-17)</span>
                                    <select class="form-control">
                                        <option>0</option>
                                        <option>1</option>
                                        <option>2</option>
                                    </select>
                                    <span class="select-arrow"></span>
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
            placeholder: "Select a city or station",
            allowClear: true
        });
    });
</script>
</html>