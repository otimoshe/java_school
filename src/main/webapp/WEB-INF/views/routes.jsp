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
    <meta name="_csrf" content="${_csrf.token}"/>
    <sec:csrfMetaTags/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
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
                                       onsubmit="return validate_form()" id="form">
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
                                            <select name="firstStationId" onchange="getPaths()" required="true">
                                                <option value="" style="display:none;" selected></option>
                                                <c:forEach items="${listStations}" var="station">
                                                    <option value="${station.id}">${station.name}</option>
                                                </c:forEach>
                                            </select></div>
                                    </spring:bind>
                                </div>
                                <div class="control-group">
                                    <label class="control-label"> Paths:</label>
                                    <div class="controls">
                                        <select class="path" name="paths" required="true" id ="paths">
                                        </select>
                                        <button id="pathButton" type="button"> Add path</button>
                                    </div>
                                </div>
                                <form:errors path="pathIds" />
                                <div class="form-actions">
                                    <button id="submit"type="submit" class="btn btn-success">Save</button>
                                </div>
                                <sec:csrfInput/>
                            </form:form>
                            <div id="alert">${error}</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    var paths = [];
    var csrfHeader = $("meta[name='_csrf_header']").attr("content");
    var csrfToken = $("meta[name='_csrf']").attr("content");
    var csrfParameter = $("meta[name='_csrf_parameter']").attr("content");

    function getRouteList() {
        var routeList = [];
        <c:forEach var="route" items="${listRoutes}">
        routeList.push("${route.name}");
        </c:forEach>
        return routeList;
    }

    function validate_form() {
        console.log("validate");
        var validate = true;
        document.getElementById('alert').innerHTML = "";
        var routes = getRouteList();
        var routeName = document.getElementById('routeName').value;
        // validate new route name
        for (var i = 0; i < routes.length; i++) {
            if (routeName == routes[i]) {
                document.getElementById('alert').innerHTML += "<p>" + "Route with name " + routeName + " already exist" + "</p>";
                validate = false;
                break;
            }
         // dublicate path check
            console.log("paths = "+ paths);
            console.log("validate path");

            for(var i=1;i<paths.length;i++){
                var path = paths.shift();
                console.log("path = "+path);
                console.log("paths = "+paths);
            if(paths.includes(path)){
                document.getElementById('alert').innerHTML += "<p>" + "In a route, the path can be used once!" + "</p>";
                validate = false;
                break;
            }
         }
        }
        return validate;
    }
    count = 0;
    $("#pathButton").click(function () {

        var selectBoxHtml = ["<select class =\"path\"> "];
        var pathList = [], path;
        <c:forEach var="path" items="${listPaths}">
        path = {};
        path.station = "${path.station.name}";
        path.nextStation = "${path.nextStation.name}";
        path.id =${path.id};
        pathList.push(path);
        </c:forEach>
        for (var i = 0; i < pathList.length; i++) {
            selectBoxHtml.push('<option value="' + pathList[i].id + '">' + pathList[i].station + "  " + pathList[i].nextStation + '</option>');
        }
        $(this).after(selectBoxHtml.join("") + "select>");
    });

    $("#submit").click(function () {
        console.log("submit");
        $('.path').each(function (index) {
            paths.push($(this).val());
        });
        var form= $('#form');
        for(var i = 0;i<paths.length;i++) {
            $("<input />", {
                type: 'hidden',
                id: 'pathIds[' + i + ']',
                name: 'pathIds[' + i + ']',
                value: paths[i]
            }).appendTo(form);
        }
        console.log('success');
    });

    function getPaths() {
        var headers = {};
        headers[csrfHeader] = csrfToken;
        console.log()
        //clear options from previous station
        var sel = $("#paths");
        sel.empty();
        console.log(length);
        for (i = 0; i < length; i++) {
            console.log("trtrtrtr");
            select.options[i] = null;
        }
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/paths",
            headers: headers,
            data: JSON.stringify({"id": $("select[name='firstStationId']").val()}),
            //data:{stationId: $('#station').val(),date: $('#date').val()},
            dataType: 'json',
            success: function (data) {
                console.log(data);
                var html = '';
                var len = data.length;
                if (len > 0) {
                    for (var i = 0; i < len; i++) {
                        html += '<option value=' + data[i].id + '>' + data[i].station.name +'  '+data[i].nextStation.name+ '</option>';
                    }
                    $("select[name='paths']").append(html);
                }
            }
        })
    }
</script>
</html>
