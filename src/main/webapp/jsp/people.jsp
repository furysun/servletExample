<%--
  Created by IntelliJ IDEA.
  User: yana
  Date: 8/8/18
  Time: 6:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="app" value="${pageContext.request.contextPath}"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>people</title>
</head>
<body>

<table>
    <c:forEach items="${people}" var="people">

        <tr>
            <td><c:out value="${people.name}"/></td>
            <td><c:out value="${people.age}"/></td>
           <td> <form action="${app}/people" method="post">
               <input type="hidden" name="action" value="showName">
               <input type="hidden" name="name" value="<c:out value="${people.name}"/>">
                <input type="submit" value="ok">
            </form>
           </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
