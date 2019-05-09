<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${contextPath}/resources/css/bootstrap-responsive.min.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/css/matrix-login.css"/>
    <link href="${contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body>
<div id="loginbox">
    <form method="POST" action="${contextPath}/login" class="form-vertical" id="loginform">
        <div class="control-group normal_text"><h3><img src="${contextPath}/resources/img/logo.png" alt="Logo"/></h3>
        </div>
        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span><h4>${message}</h4></span>
            <div class="control-group">
                <div class="controls">
                    <div class="main_input_box">
                        <span class="add-on bg_lg"><i class="icon-user"> </i></span>
                        <input name="username" type="text" placeholder="Username"
                               autofocus="true"/>
                    </div>
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <div class="main_input_box">
                        <span class="add-on bg_ly"><i class="icon-lock"></i></span>
                        <input name="password" type="password" class="form-control" placeholder="Password"/>
                    </div>
                    <span class="pull-left"><font size ="4" color="red">${error}</font></span>
                </div>
            </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="form-actions">
                    <span class="pull-right"> <button class="btn btn-success" type="submit">Log In</button></span>
                    <span class="pull-left"><a class="flip-link btn btn-info" href="${contextPath}/registration">Create an account</a></span>
                </div>
            </div>

    </form>
</div>

<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>