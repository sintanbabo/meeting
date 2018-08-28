<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Metting List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
 
<body>
    <div class="generic-container">
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">List of Metting </span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Metting Room Name</th>
                        <th>Start</th>
                        <th>End</th>
                        <th>User</th>
                        <th>Cycle Count</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${mettingList}" var="mettingList">
                    <tr>
                        <td>${mettingList.mettingRoomName}</td>
                        <td>${mettingList.start}</td>
                        <td>${mettingList.end}</td>
                        <td>${mettingList.user}</td>
                        <td>${mettingList.cycleCount}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>