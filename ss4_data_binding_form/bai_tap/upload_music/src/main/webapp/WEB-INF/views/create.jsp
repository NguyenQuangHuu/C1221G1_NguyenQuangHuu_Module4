<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 05-05-2022
  Time: 02:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>Tải nhạc</h4>
<form:form modelAttribute="song" action="/create-song" method="post">
    <p><span>Song name</span><form:input path="songName"/></p>

    <p><span>Song author</span> <form:input path="author"/></p>


    <p><span>Kind of Music</span>
        <form:checkbox path="kindOfMusic" value="nhạc kháng chiến"/>nhạc kháng chiến
        <form:checkbox path="kindOfMusic" value="nhạc thiền"/>nhạc thiền
        <form:checkbox path="kindOfMusic" value="nhạc thiếu nhi"/>nhạc thiếu nhi
        <form:checkbox path="kindOfMusic" value="nhạc nhảy nhót"/>nhạc nhảy nhót
    </p>

    <p>
        <span>Song url</span>
        <form:input path="songUrl" />
    </p>

    <input type="submit" value="upload">
</form:form>
</body>
</html>
