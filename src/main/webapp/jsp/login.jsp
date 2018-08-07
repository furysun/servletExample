
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <c:set var="app" value="${pageContext.request.contextPath}"/>

    <title>login</title>
</head>
<form action="${app}/controller" method="post">
    <input type="hidden" name="action" value="LOGIN">

    login:
    <input type="text" name="login"/>
    password:
    <input type="password" name="password"/>


<c:if test="${error}">
    Invalid login or password.
</c:if>

    <input type="submit" value="ok"/>

    <input type="button" value="back"/>
</form>
</body>
</html>
