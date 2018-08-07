<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:set var="app" value="${pageContext.request.contextPath}"/>
</head>
<body>
<form method="get" action="${app}/controller">
    <input type="hidden" name="action" value="GO_TO_LOGIN">
    <input type="submit" value="login"/>
</form>

<form method="get" action="${app}/controller">
    <input type="hidden" name="action" value="GO_TO_REGISTRATION">
    <input type="submit" value="Sing up"/>
</form>

</body>
</html>