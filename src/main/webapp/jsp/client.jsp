
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>client</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <c:set var="app" value="${pageContext.request.contextPath}"/>
</head>
<body>
<form action="${app}/client" method="post">

    <input type="hidden" name="action" value="goToClientTwo">
    first name:
    <input type="text" name="firstName"/>
    last name:
    <input type="text" name="lastName"/>

    <input type="submit" value="ok"/>
</form>
</body>
</html>
