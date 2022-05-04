<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 01-05-2022
  Time: 05:11 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>

    <c:if test="${message == null}">
    <ul>
        <c:if test="${condiments != null}">
        List condiments Order:

            <c:forEach items="${condiments}" var="c">
                <li>${c.toString()}</li>
            </c:forEach>



    </ul>

        </c:if>
    </c:if>
    <c:if test="${message!=null}">
        ${message}
    </c:if>

</div>
</body>
</html>
