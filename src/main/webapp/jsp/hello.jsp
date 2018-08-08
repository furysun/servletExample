<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yana
  Date: 8/8/18
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>hello</title>
    <c:set var="app" value="${pageContext.request.contextPath}"/>
</head>
<body>
Hello,
<c:out value="${name}"/>
</body>
</html>
