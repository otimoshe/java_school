<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<jsp:include page="sideBar.jsp"/>
<html>
<head>
    <title>Route Data</title>
</head>
<body onload="saveName()">
<div id="content">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span6">
                <div class="widget-box">
                    <table class="table table-bordered data-table">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Stations</th>
                            <th>Price</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <form:form action="/route/${route.id}" modelAttribute="route" method="post"
                                       onsubmit="return check_form()" class="form-horizontal">
                            <td><form:input type="text" path="id" value="${route.id}" readonly="true"
                                            class="span11"/></td>
                            <td><form:input type="text" id="routeName" path="name" value="${route.name}"
                                            required="true" class="span11"/></td>
                            <td>
                                <c:forEach items="${route.stationList}" var="station">
                                    ${station.name}
                                </c:forEach>
                            </td>
                            <td><form:input type="number" path="price" min="0.1" step="0.1"
                                            value="${route.price}" class="span11" required="true"/></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <button type="submit" class="btn btn-info">Edit</button>
            </div>
            <sec:csrfInput/>
            </form:form>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">

    var name = ""

    function saveName() {
        name = document.getElementById('routeName').value;
        console.log("name = " + name);
    }

    function getRouteList() {
        var routeNameList = [];
        console.log("name in f = " + name);
        <c:forEach var="route" items="${listRoutes}">
        if ("${route.name}" != name) {
            routeNameList.push("${route.name}");
        }
        </c:forEach>
        routeNameList
        console.log("routes = " + routeNameList)
        return routeNameList;
    }

    function check_form() {
        var validate = true, routes = getRouteList();
        console.log(document.getElementById('routeName').value)
        if (document.getElementById('routeName').value == "") {
            document.getElementById('alert').innerHTML = "Route name should not be empty!";
            validate = false;
        }
        var routeName = document.getElementById('routeName').value
        if (routes.length !== 0) {
            for (var i = 0; i < routes.length; i++) {
                if (routeName == routes[i]) {
                    document.getElementById('alert').innerHTML = "Route with this name already exist!";
                    validate = false;
                }
            }
        }
        return validate;
    }
</script>
</html>