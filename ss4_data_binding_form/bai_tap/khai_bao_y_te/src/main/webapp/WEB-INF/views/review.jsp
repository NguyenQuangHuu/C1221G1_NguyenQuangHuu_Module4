<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 06-05-2022
  Time: 08:24 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>Thông tin đã được khai báo</h4>
<form:form modelAttribute="information2" action="/edit" method="post">
    <form:hidden path="name"/>
    <form:hidden path="passportId"/>
    <form:hidden path="description"/>
    <form:hidden path="endDate"/>
    <form:hidden path="startDate"/>
    <form:hidden path="endDate"/>
    <form:hidden path="gender"/>
    <form:hidden path="dayOfBirth"/>
    <form:hidden path="country"/>
    <form:hidden path="seatNumber"/>
    <form:hidden path="vehiclesPlate"/>
    <form:hidden path="vehicles"/>
<div>
    <p>Họ tên</p>
    ${information2.name}
</div>
<div style="display: flex;justify-content: space-evenly">
    <div style="width: 100%">
        <p>Năm sinh</p>
        ${information2.dayOfBirth}
    </div>
    <div style="width: 100%">
        <p>Giới tính</p>
        ${information2.gender}
    </div>
    <div style="width: 100%">
        <p>Quốc tịch</p>
        ${information2.country}
    </div>
</div>
<div style="width: 100%">
    <p>Số chứng minh nhân dân, số hộ chiếu hoặc giấy tờ thông hành khác </p>
    ${information2.passportId}
</div>
<div style="width: 100%">
    <p>Thông tin đi lại</p>
    ${information2.vehicles}
</div>
<div style="display: flex;justify-content: space-evenly">
    <div style="width: 100%">
        <p>Số hiệu phương tiện</p>
        ${information2.vehiclesPlate}
    </div>
    <div style="width: 100%">
        <p>Số ghế</p>
        ${information2.seatNumber}
    </div>
</div>
<div style="display: flex;justify-content: space-evenly">
    <div style="width: 100%">
        <p>Ngày khởi hành</p>
        ${information2.startDate}
    </div>
    <div style="width: 100%">
        <p>Ngày kết thúc</p>
        ${information2.endDate}
    </div>
</div>
<div style="width: 100%">
    <p>Trong vòng 14 ngày qua, Anh/ chị có đi đến tỉnh thành phố nào không</p>
    ${information2.description}
</div>
<div>
    <input type="submit" value="chỉnh sửa">
</div>
</form:form>
</body>
</html>
