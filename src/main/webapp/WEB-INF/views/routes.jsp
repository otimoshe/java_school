<%--
  Created by IntelliJ IDEA.
  User: otimoshe
  Date: 23.03.2019
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false" %>
<jsp:include page="sideBar.jsp"/>
<html>
<head>
    <title>Route Page</title>
    <script type="text/javascript">
        function getRouteList() {
            var routeList = [];
            <c:forEach var="route" items="${listRoutes}">
            routeList.push("${route.name}");
            </c:forEach>
            return routeList;
        }

        function validate_form() {
            var validate = true;
            document.getElementById('alert').innerHTML = "";
            var routes = getRouteList();
            var routeName = document.getElementById('routeName').value;
            // validate new route name
            for (var i = 0; i < routes.length; i++) {
                if (routeName == routes[i]) {
                    document.getElementById('alert').innerHTML += "<p>" + "Route with name " + routeName + " already exist" + "</p>";
                    validate = false;
                }
            }

            return validate;
        }
    </script>
</head>
<body>
<div id="content">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span6">
                <div class="widget-box">
                    <div class="widget-title"><span class="icon"><i class="icon-th"></i></span>
                        <h5>Routes list</h5>
                    </div>
                    <c:if test="${!empty listRoutes}">
                        <table class="table table-bordered data-table">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Stations</th>
                                <th>Price</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listRoutes}" var="route">
                                <tr>
                                    <td>${route.id}</td>
                                    <td>${route.name}</td>
                                    <td>
                                        <c:forEach items="${route.stationList}" var="station">
                                            ${station.name}
                                        </c:forEach>
                                    </td>
                                    <td>${route.price}</td>
                                    <td><a href="<c:url value='/route/${route.id}'/>">Edit</a></td>
                                    <td><a href="<c:url value='/remove/route/${route.id}'/>">Delete</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <hr>
            <div class="row-fluid">
                <div class="span6">
                    <div class="widget-box">
                        <div class="widget-title"><span class="icon"> <i class="icon-align-justify"></i> </span>
                            <h5>Add Route</h5>
                        </div>
                        <div class="widget-content nopadding">
                            <spring:url value="/route" var="pathUrl"></spring:url>
                            <form:form action="${pathUrl}" modelAttribute="dto" method="post" class="form-horizontal"
                                       onsubmit="return validate_form()">
                                <spring:bind path="name">
                                    <div class="control-group">
                                        <label class="control-label"> Name:</label>
                                        <div class="controls"><form:input type="text" path="name" required="true"
                                                                          id="routeName"
                                                                          class="span11"/>
                                        </div>
                                    </div>
                                </spring:bind>
                                <spring:bind path="price">
                                    <div class="control-group">
                                        <label class="control-label"> Price:</label>
                                        <div class="controls"><form:input type="number" path="price" id="distance"
                                                                          value="0.1" required="true" min="0.1"
                                                                          step="0.1" class="span11"/>
                                        </div>
                                    </div>
                                </spring:bind></p>
                                <div class="control-group">
                                    <label class="control-label"> First station:</label>
                                    <spring:bind path="firstStationId">
                                        <div class="controls">
                                            <select name="firstStationId">
                                                <c:forEach items="${listStations}" var="station">
                                                    <option value="${station.id}">${station.name}</option>
                                                </c:forEach>
                                            </select></div>
                                    </spring:bind>
                                </div>
                                <div id="paths">
                                    <div class="control-group">
                                        <label class="control-label"> Paths:</label>
                                        <div class="controls">
                                            <form:select path="pathIds[0]">
                                                <c:forEach items="${listPaths}" var="aPath">
                                                    <option value="${aPath.id}">${aPath.station.name} ${aPath.nextStation.name}</option>
                                                </c:forEach>
                                            </form:select></div>
                                    </div>
                                </div>

                                <div class="form-actions">
                                    <button type="submit" class="btn btn-success">Save</button>
                                </div>
                                <sec:csrfInput/>
                            </form:form>
                            <div id="alert"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>
