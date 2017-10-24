<%--
  Created by IntelliJ IDEA.
  User: rosaliework
  Date: 10/23/17
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="username" value="Create a new user" />
    </jsp:include>
    <title>Title</title>
</head>
<body>
<%@include file="/WEB-INF/partials/navbar.jsp"%>

<div class="container">
    <h1>Register </h1>
    <form action="/register" method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <textarea id="email" name="email" class="form-control" type="text"></textarea>
        </div>
        <div class="form-group">
            <label for="password">password</label>
           <input type="password" id="password" name="password" class="form-control">
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>

</body>
</html>
