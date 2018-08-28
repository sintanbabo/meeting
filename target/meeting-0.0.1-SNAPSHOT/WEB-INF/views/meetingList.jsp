<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Meeting List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
 
<body>
	<div class="panel-heading"><span class="lead">List of Meeting </span></div>
	<table class="table table-hover">
	    <thead>
	        <tr>
	            <th>Meeting Room Name</th>
	            <th>Start</th>
	            <th>End</th>
	            <th>User</th>
	            <th>Cycle Count</th>
	        </tr>
	    </thead>
	    <tbody>
	    <c:forEach items="${meetingList}" var="meetingList">
	        <tr>
	            <td>${meetingList.meetingRoomName}</td>
	            <td>${meetingList.start}</td>
	            <td>${meetingList.end}</td>
	            <td>${meetingList.user}</td>
	            <td>${meetingList.cycleCount}</td>
	        </tr>
	    </c:forEach>
	    </tbody>
	</table>
</body>
</html>