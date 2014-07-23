<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>

<h1>Devices in house</h1>

<table style="border: 1px solid black">
    <c:forEach var="elem" items="${lst}" varStatus="status">
        <tr>
            <td><c:out value="${elem}"/></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
