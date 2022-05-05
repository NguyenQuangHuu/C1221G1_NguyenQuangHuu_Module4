<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 05-05-2022
  Time: 10:12 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form:form  action="/result" method="post" modelAttribute="mailSetting" acceptCharset="UTF-8">
    <div>
      <span>Language:</span>
      <form:select path="language">
        <form:option  value="English"/>English
        <form:option  value="Vietnamese"/>Vietnamese
        <form:option  value="Japanese"/>Japanese
        <form:option  value="Chinese"/>Chinese
      </form:select>
    </div>
    <div>
      <span>Page Size:</span>
      Show
      <form:select path="pageSize">
        <form:option  value="25"/>25
        <form:option  value="50"/>50
        <form:option  value="75"/>75
        <form:option  value="100"/>100
      </form:select>
      emails per page
    </div>
    <div><span>Spam filter</span>
      <form:checkbox path="filter"/> Enable spams filter
    </div>
    <div><div>
      <span>Signature:</span></div>
      <form:textarea path="signature"/>
    </div>
    <div><input type="submit" value="submit"></div>
  </form:form>
  </body>
</html>
