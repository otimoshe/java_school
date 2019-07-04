<%--
  Created by IntelliJ IDEA.
  User: otimoshe
  Date: 16.05.2019
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css"/>
<link rel="stylesheet" href="${contextPath}/resources/css/bootstrap-responsive.min.css"/>
<link rel="stylesheet" href="${contextPath}/resources/css/fullcalendar.css"/>
<link rel="stylesheet" href="${contextPath}/resources/css/matrix-style.css"/>
<link rel="stylesheet" href="${contextPath}/resources/css/matrix-media.css"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>successful </title>
</head>
<body>
<div id="content">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span6">
                <div class="widget-box">
                    <iframe src="https://money.yandex.ru/quickpay/shop-widget?writer=seller&targets=ticket&targets-hint=&default-sum=&button-text=11&payment-type-choice=on&hint=&successURL=&quickpay=shop&account=41001318595008" width="423" height="222" frameborder="0" allowtransparency="true" scrolling="no"></iframe>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
