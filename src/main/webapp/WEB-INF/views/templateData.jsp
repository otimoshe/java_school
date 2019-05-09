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
    <title>Template Data</title>
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
                            <th>Template ID</th>
                            <th>Template name</th>
                            <th>Route name</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <form:form action="/template/${template.id}" modelAttribute="template" method="post"
                                       onsubmit="return validate_template_form()" class="form-horizontal">
                            <td><form:input type="text" path="id" value="${template.id}" readonly="true"
                                            class="span11"/></td>
                            <td><form:input type="text" path="name" required="true" id="templateName" class="span11"
                                            value="${template.name}" /></td>
                            <td><form:input type="text" path="route.name" value="${template.route.name}" class="span11"
                                            readonly="true"/></td>
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
</tr>
<a href="/admin">Back to admin page</a>


</table>
</body>
<script type="text/javascript">
    function getTemplateList() {
        var templateList = [], template;
        <c:forEach var="template" items="${listTemplates}">
        template = "${template.name}";
        templateList.push(template);
        </c:forEach>
        console.log(templateList);
        return templateList;
    }

    function validate_template_form() {
        var validate = true;
        var templates = getTemplateList();
        var template = document.getElementById('templateName').value;
        document.getElementById('alert').innerHTML = "";

        for (var i = 0; i < templates.length; i++) {
            if (templates[i] == template) {
                document.getElementById('alert').innerHTML += "<p>" + "Time template with name " + template + " already exist" + "</p>";
                validate = false;
            }
        }
        return validate;
    }
</script>
</html>