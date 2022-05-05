<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 05-05-2022
  Time: 02:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h4>Music List</h4>
  ${message}
  <h5><a href="/create-song">Add more songs</a></h5>
  <table border="1">
    <thead>
    <tr>
      <th>Song name</th>
      <th>Song authors</th>
      <th>Kind of Music</th>
      <th>Song URL</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${musics}" var="song">
      <tr>
        <td>${song.songName}</td>
        <td>${song.author}</td>
        <td>${song.kindOfMusic}</td>
        <td><a href="${song.songUrl}">link nhạc</a></td>
      </tr>
    </c:forEach>

    </tbody>
  </table>
  </body>
</html>
