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
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${contextPath}/resources/css/bootstrap-responsive.min.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/css/matrix-login.css"/>
    <link href="${contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>

    <title>Create an account</title>

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body>
<div id="loginbox">
    <form:form method="POST" modelAttribute="userForm" class="form-vertical" id="loginform">
        <div class="control-group normal_text"><h3><img src="${contextPath}/resources/img/logo.png" alt="Logo"/></h3>
        </div>
        <spring:bind path="username">
            <div class="control-group">
                <div class="controls">
                    <div class="main_input_box">
                        <span class="add-on bg_lg"><i class="icon-user"> </i></span>
                        <form:input type="text" path="username" placeholder="Username"
                                    autofocus="true"></form:input>
                        <form:errors path="username"></form:errors>
                        <div class="form-group ${status.error ? 'has-error' : ''}"></div>
                    </div>
                </div>
            </div>
        </spring:bind>
        <div class="control-group">
            <div class="controls">
                <div class="main_input_box">
                    <span class="add-on bg_lg"><i class="icon-lock"> </i></span>
                    <spring:bind path="password">
                        <form:input type="password" path="password"
                                    placeholder="Password"></form:input>
                        <form:errors path="password"></form:errors>
                        <div class="form-group ${status.error ? 'has-error' : ''}"></div>
                    </spring:bind>
                </div>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <div class="main_input_box">
                    <span class="add-on bg_lg"><i class="icon-lock"> </i></span>
                    <spring:bind path="confirmPassword">
                        <form:input type="password" path="confirmPassword"
                                    placeholder="Confirm your password"></form:input>
                        <form:errors path="confirmPassword"></form:errors>
                        <div class="form-group ${status.error ? 'has-error' : ''}"></div>
                    </spring:bind>
                </div>
            </div>
        </div>
        <div class="form-actions">
           <span class = "pull-right"><button class="btn btn-success" type="submit">Submit</button></span>
        </div>
    </form:form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>