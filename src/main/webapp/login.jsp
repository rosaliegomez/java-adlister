<%@ page import="org.apache.taglibs.standard.tag.rt.core.RedirectTag" %><%--
  Created by IntelliJ IDEA.
  User: rosaliework
  Date: 10/17/17
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%--<%! String userName = "admin"; %>--%>
    <%--<% request.setAttribute("userName", userName); %>--%>
    <%--<%! String password = "password"; %>--%>
    <%--<% request.setAttribute("password", password); %>--%>
    <title>Title</title>
<html>
<head>

    <jsp:include page = "partials/style.jsp">
    <jsp:param name = "title" value = "Please Login"/>
    </jsp:include>
</head>
<body>
<%@ include file="partials/navbar.jsp" %>
<h1>Login</h1>


<form action="login.jsp" method="POST">
    <label for="userName">Name:
    <input id="userName" type="text" name ="userName">
    </label>
    <label for="password">Password:
        <input id="password" type="password" name ="password">
    </label>
    <button type="submit">Submit</button>
</form>
<c:choose>
    <c:when test="${param.userName.equals('Admin')&& param.password.equals('password')}">
        <%
            String redirectURL ="http://localhost:8080/profile.jsp";
            response.sendRedirect(redirectURL);
        %>

    </c:when>
</c:choose>

<%@ include file="partials/scripts.jsp" %>
</body>
</html>
