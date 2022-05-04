<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 01-05-2022
  Time: 05:18 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
Calculator
<form action="/index" method="post">
    <div>
        <input type="text" name="leftNumber" placeholder="First Number">
        <input type="text" name="rightNumber" placeholder="Second Number">
    </div>
        <input type="submit" name="operator" value="Addition(+)">
        <input type="submit" name="operator"  value="Subtraction(-)">
        <input type="submit" name="operator"  value="Multiplication(*)">
        <input type="submit" name="operator"  value="Divide(/)">
</form>
<hr>
<c:if test="${message == null}">
    <c:if test="${result != null}">
        Result ${operator} : <h4> ${result} </h4>
    </c:if>
</c:if>
<c:if test="${message != null}">
    ${message}
</c:if>
</body>
</html>
