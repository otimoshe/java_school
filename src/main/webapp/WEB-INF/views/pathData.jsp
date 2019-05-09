<%--
  Created by IntelliJ IDEA.
  User: otimoshe
  Date: 10.03.2019
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<jsp:include page="sideBar.jsp"/>
<html>
<head>
    <title>Path Data</title>

</head>
<body>

<div id="content">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span6">
                <div class="widget-box">
                    <table class="table table-bordered data-table">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Station</th>
                            <th>Station</th>
                            <th>Distance</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr class="gradeX">
                            <form:form action="/path/${path.id}" modelAttribute="path" method="post"
                                       class="form-horizontal">
                            <td><form:input type="text" path="id" value="${path.id}" readonly="true"
                                            class="span11"/></td>
                            <td>${path.station.name}</td>
                            <td>${path.nextStation.name}</td>
                            <td><form:input type="number" path="distance" min="0.1" step="0.1" class="span11" required="true"
                                            value="${path.distance}"/></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <button type="submit" class="btn btn-info">Edit</button>
            </div>

            <sec:csrfInput/>
            </form:form>
            <div>
            </div>
        </div>
    </div>
</div>
</body>
</html>