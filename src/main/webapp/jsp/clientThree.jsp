<%--
  Created by IntelliJ IDEA.
  User: yana
  Date: 8/8/18
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>clientThree</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
<c:set var="app" value="${pageContext.request.contextPath}"/>
<c:out value="${firstName}"/>
<c:out value="${lastName}"/>
<c:out value="${age}"/>

<form action="${app}/client" method="post">
    <input type="hidden" name="action" value="goToClientBack">
    <input type="submit" value="back">
</form>
</body>
</html>
