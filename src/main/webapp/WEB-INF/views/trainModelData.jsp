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
                    document.getElementById('alert').innerHTML = "<p>" + "This train model already exist" + "</p>";
                    validate = false;
                }
            }
            console.log(trainModels)
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
                    <table class="table table-bordered data-table">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <form:form action="/trainModel" modelAttribute="model" method="post"
                                       onsubmit=" return validate_trainModel_form()" class="form-horizontal">
                            <td><form:input type="text" path="id" value="${model.id}" readonly="true" class="span11"/></td>
                            <td><form:input type="text" path="name" id="trainModelName" required="true" class="span11"
                                            value="${model.name}"/></td>
                            <div id="alert"></div>
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
</html>