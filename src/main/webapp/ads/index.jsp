<%--
  Created by IntelliJ IDEA.
  User: rosaliework
  Date: 10/18/17
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../partials/head.jsp"%>
    <title>Title</title>
</head>
<body>
<%@ include file="../partials/navbar.jsp"%>
<ul>
    <c:forEach var="ad" items="${ads}">
        <li>

            Title: ${ad.title},<br>
            Description: ${ad.description}
        </li>

    </c:forEach>
</ul>


</body>
</html>
