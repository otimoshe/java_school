<%--
  Created by IntelliJ IDEA.
  User: otimoshe
  Date: 27.03.2019
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false" %>
<jsp:include page="sideBar.jsp"/>
<html>
<head>
    <title>Time Templates page</title>
</head>
<body>
<div id="content">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span6">
                <div class="widget-box">
                    <div class="widget-title"><span class="icon"><i class="icon-th"></i></span>
                        <h5>TimeTemplate list</h5>
                    </div>
                    <c:if test="${!empty listTemplates}">
                        <table class="table table-bordered data-table">
                            <thead>
                            <tr>
                            <th>Template ID</th>
                            <th>Template name</th>
                            <th>Route name</th>
                            <th>Time info</th>
                            <th>Edit</th>
                            <th>Delete</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listTemplates}" var="template">
                                <tr>
                                    <td>${template.id}</td>
                                    <td>${template.name}</td>
                                    <td>${template.route.name}</td>
                                    <td><a href="<c:url value='/template/${template.id}/times'/>">Info</a></td>
                                    <td><a href="<c:url value='/template/${template.id}'/>">Edit</a></td>
                                    <td><a href="<c:url value='/removeTemplate/${template.id}'/>">Delete</a></td>
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
                            <h5>Add TimeTemplate</h5>
                        </div>
                        <div class="widget-content nopadding">
                            <spring:url value="/addTemplate" var="addTemplateUrl"></spring:url>
                            <form:form action="${addTemplateUrl}" modelAttribute="template" method="post"
                                       onsubmit="return validate_template_form()" class="form-horizontal">
                                <spring:bind path="name">
                                    <div class="control-group">
                                        <label class="control-label"> Name:</label>
                                        <div class="controls">
                                            <form:input type="text" path="name" value="" id="templateName"
                                                        required="true" class="span11"/>
                                        </div>
                                    </div>
                                </spring:bind>
                                <div class="control-group">
                                    <label class="control-label"> Route:</label>
                                    <div class="controls">
                                        <select name="routeId" required="true" class="span11">
                                            <option value="" style="display:none;"></option>
                                            <c:forEach items="${routesList}" var="route">
                                                <option value="${route.id}">${route.name}</option>
                                            </c:forEach>
                                        </select>
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
