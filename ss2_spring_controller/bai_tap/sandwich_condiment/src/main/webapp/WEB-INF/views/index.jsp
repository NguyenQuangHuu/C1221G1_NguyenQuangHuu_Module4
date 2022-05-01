<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 01-05-2022
  Time: 05:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h4>Sandwich Condiments</h4>
  <form action="/info" method="post">
    <input type="checkbox" name="condiments" value="Lettuce">Lettuce
    <input type="checkbox" name="condiments" value="Tomato">Tomato
    <input type="checkbox" name="condiments" value="Mustard">Mustard
    <input type="checkbox" name="condiments" value="Sprouts">Sprouts
    <input type="submit" value="Save">
  </form>
  </body>
</html>
