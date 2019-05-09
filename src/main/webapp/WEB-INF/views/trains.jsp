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
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false" %>
<jsp:include page="sideBar.jsp"/>
<html>
<head>
    <title>Train Page</title>
</head>
<body>
<div id="content">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span6">
                <div class="widget-box">
                    <div class="widget-title"><span class="icon"><i class="icon-th"></i></span>
                        <h5>Trains list</h5>
                    </div>
                    <c:if test="${!empty listTrains}">
                        <table class="table table-bordered data-table">
                            <thead>
                            <tr>
                                <th width="80">ID</th>
                                <th width="80">Seats</th>
                                <th width="80">Model</th>
                                <th width="60">Edit</th>
                                <th width="60">Delete</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listTrains}" var="train">
                                <tr class="gradeX">
                                    <td>${train.id}</td>
                                    <td>${train.numberOfSeats}</td>
                                    <td>${train.trainModel.name}</td>
                                    <td><a href="<c:url value='/train/${train.id}'/>">Edit</a></td>
                                    <td><a href="<c:url value='/remove/${train.id}'/>">Delete</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>
    </div>

    <div class="container-fluid">
        <hr>
        <div class="row-fluid">
            <div class="span6">
                <div class="widget-box">
                    <div class="widget-title"><span class="icon"> <i class="icon-align-justify"></i> </span>
                        <h5>Add Train</h5>
                    </div>
                    <div class="widget-content nopadding">
                        <form:form action="/train" modelAttribute="train" method="post"
                                    class="form-horizontal">
                            <div class="control-group">
                                <label class="control-label"> NumberOfSeats:</label>
                                <div class="controls">
                                    <form:input type="number" path="numberOfSeats" value="" min="1" required = "true"
                                                class="span11" />
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label"> Model:</label>
                                <div class="controls">
                                    <form:select path="trainModel.id" class="span11" required="true">
                                        <c:forEach items="${listTrainModels}" var="model">
                                            <option value="${model.id}">${model.name}</option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>
                            <div id="alert"></div>
                            <div class="form-actions">
                                <button type="submit" class="btn btn-success">Save</button>
                            </div>
                            <sec:csrfInput/>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>
