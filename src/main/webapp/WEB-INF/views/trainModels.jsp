<%--
  Created by IntelliJ IDEA.
  User: otimoshe
  Date: 19.03.2019
  Time: 16:04
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
    <title>Train models page</title>
    <script type="text/javascript">
        function getModelList() {
            var modelList = [], trainModel;
            <c:forEach var="trainModel" items="${listTrainModels}">
            trainModel = "${trainModel.name}";
            modelList.push(trainModel);
            </c:forEach>
            console.log(modelList);
            return modelList;
        }

        function validate_trainModel_form() {
            var validate = true;
            document.getElementById('alert').innerHTML = "";
            var trainModels = getModelList();
            var trainModel = document.getElementById('trainModelName').value;
            for (var i = 0; i < trainModels.length; i++) {
                if (trainModels[i] == trainModel) {
                    document.getElementById('alert').innerHTML = "<p>" + "This plane model already exist" + "</p>";
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
                        <h5>TrainModel list</h5>
                    </div>
                    <c:if test="${!empty listTrainModels}">
                        <table class="table table-bordered data-table">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <c:forEach items="${listTrainModels}" var="model">
                                <tbody>
                                <tr>
                                    <td>${model.id}</td>
                                    <td>${model.name}</td>

                                    <td><a href="<c:url value='/trainModel/${model.id}'/>">Edit</a></td>
                                    <td><a href="<c:url value='/removeModel/${model.id}'/>">Delete</a></td>
                                </tr>
                                </tbody>
                            </c:forEach>
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
                            <h5>Add TrainModel</h5>
                        </div>
                        <div class="widget-content nopadding">
                            <form:form action="/trainModel" modelAttribute="model" method="post"
                                       onsubmit=" return validate_trainModel_form()" class="form-horizontal">
                                <div class="control-group">
                                    <label class="control-label"> Name:</label>
                                    <div class="controls">
                                        <form:input path="name" value="" id="trainModelName" class ="span11"
                                                                      required="true"/>
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
</div>
</body>
</html>
