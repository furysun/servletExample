<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="app" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/styleCss.css">
    <style>
    </style>
    <title>Title</title>
</head>
<body>
cats

<table>
    <c:forEach items="${cats}" var="cat">
        <tr>
            <td><c:out value="${cat.id}"/></td>
            <td><c:out value="${cat.name}"/></td>
            <td><c:out value="${cat.age}"/></td>
            <td>
                <form action="${app}/cats" method="post">
                    <input type="hidden" name="action" value="DELETE_CAT"/>

                    <input type="hidden" name="id" value="${cat.id}"/>
                    <input type="submit" value="delete"/>
                </form>
            </td>
            <td>
                <form action="${app}/cats" method="post">
                    <input type="hidden" name="action" value="SHOW_EDIT_CAT"/>

                    <input type="hidden" name="id" value="${cat.id}"/>
                    <input type="submit" value="edit"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
new cat:
<form action="${app}/cats" method="post">
    <input type="hidden" name="action" value="CREATE_CAT"/>

    <input type="text" name="id"/>
    <input type="text" name="name"/>
    <input type="text" name="age"/>

    <input type="submit" value="ok"/>
</form>

<c:if test="${catToEdit!=null}">
    edit cat:
    <form action="${app}/cats" method="post">
        <input type="hidden" name="action" value="EDIT_CAT"/>

        <input type="hidden" name="id" value="${catToEdit.id}"/>
        <input type="text" name="name" value="${catToEdit.name}"/>
        <input type="text" name="age" value="${catToEdit.age}"/>

        <input type="submit" value="ok"/>
    </form>
</c:if>

</body>
</html>
