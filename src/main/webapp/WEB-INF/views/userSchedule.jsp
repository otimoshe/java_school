<%--
  Created by IntelliJ IDEA.
  User: otimoshe
  Date: 02.04.2019
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false" %>
<html>
<head>
    <title>Schedule</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <meta name="_csrf" content="${_csrf.token}"/>
    <sec:csrfMetaTags />
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
</head>
<p>
<p>Pick the station and date</p>
<select id ="station" name = "stationId"  onchange="doAjax()">
   <!-- <option value="" style="display:none;"></option> -->
    <c:forEach items="${stationList}" var="station">
        <option value="${station.id}">${station.name}</option>
    </c:forEach>
</select>
<input id="date" name="date" type="date" onchange="doAjax()"/>
</p>
<input type="hidden"
       name="${_csrf.parameterName}"
       value="${_csrf.token}"/>


<div id = "table"></div>



<script type="text/javascript">
    function test(){
        console.log($('#date').val());
    }
</script>

<script type="text/javascript">
   // $('#date').select(testMessage);
   var csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
   var csrfHeader = $("meta[name='_csrf_header']").attr("content");
   var csrfToken = $("meta[name='_csrf']").attr("content");

    function doAjax(){
        console.log("ttttttttt");
        $('#table').empty();
        if($('#date').val() !=''){
            var headers = {};
            headers[csrfHeader] = csrfToken;
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/userSchedule",
                headers: headers,
                data:  JSON.stringify({"stationId": $('#station').val(), "date": $('#date').val()} ),  //",${_csrf.parameterName}" : "${_csrf.token}"}),
                //data:{stationId: $('#station').val(),date: $('#date').val()},
                dataType: 'json',
                success: function(data){
                    console.log(data);
                    console.log(data.length);
                    var html = '';
                    var len = data.length;
                    if(len > 0){
                        html+=' <table id = "scheduleTable"  class="tg">'
                            +'<tr>'
                            +'<th width="80">Route</th>'
                            +'<th width="80">Train ID</th>'
                            +'<th width="80">Arrival Time</th>'
                            +'<th width="80">Departure Time</th>'
                            +'</tr>';
                        for (var i = 0; i < len; i++) {
                             html+='<tr>'
                             html+='<td>'+ data[i].trip.route.name+'</td>';
                             html+='<td>'+ data[i].trip.train.id+'</td>';
                             html+='<td>'+ data[i].arrivalTime+'</td>';
                             html+='<td>'+ data[i].departureTime+'</td>';
                             html+='</tr>';
                }


                $('#table').append(html);
                  }
                 }

        });
    }
    }
</script>
</body>
</html>

