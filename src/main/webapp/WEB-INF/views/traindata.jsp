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
    <title>TrainData</title>
    <script type="text/javascript">
        function validate_form() {
            if (parseInt(document.getElementById('numberOfSeats').value) <= 0) {
                document.getElementById('alert').innerHTML = "Number of seats must be greater than 0";
                return false;
            } else {
                return true;
            }
        }
    </script>
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
                            <th>Seats</th>
                            <th>Model</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr class="gradeX">
                            <form:form action="/train" modelAttribute="train" method="post"
                                       onsubmit="return validate_form()" class="form-horizontal">
                            <td><form:input type="text" path="id" value="${train.id}" readonly="true" class="span11"/></td>
                            <td><form:input type="number" path="numberOfSeats" class="span11" min="1" step ="1" required = "true"
                                                          value="${train.numberOfSeats}"/></td>
                            <td><form:select path="trainModel.id" selected="${train.trainModel.id}" class="span11">${train.trainModel.name}
                                    <c:forEach items="${listTrainModels}" var="model">
                                        <option value="${model.id}">${model.name}</option>
                                    </c:forEach>
                                </form:select></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <button type="submit" class="btn btn-info">Edit</button>
            </div>
            <sec:csrfInput/>
            </form:form></div>
    </div>
</div>
</body>

</html>