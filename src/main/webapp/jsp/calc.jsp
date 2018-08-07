<%--
  Created by IntelliJ IDEA.
  User: yana
  Date: 8/7/18
  Time: 7:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <c:set var="app" value="${pageContext.request.contextPath}"/>
    <title>calc</title>
</head>
<body>
<form action="${app}/calc" method="post">
    <input type="text" name="number1"/>
    <select name="operator">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="%">%</option>
    </select>
    <input type="text" name="number2"/>
    <input type="submit" name="result"/>
</form>

<c:out value="${result}"/>

</body>
</html>
