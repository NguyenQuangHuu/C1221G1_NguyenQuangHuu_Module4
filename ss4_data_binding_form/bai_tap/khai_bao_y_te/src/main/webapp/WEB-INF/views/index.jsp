<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 05-05-2022
  Time: 03:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form:form modelAttribute="information" method="post" action="/result">
    <div>
      <p>Họ tên (ghi chữ IN HOA)</p>
      <form:input path="name"/>
    </div>
    <div style="display: flex;justify-content: space-evenly">
      <div style="width: 100%">
        <p>Năm sinh</p>
        <form:select path="dayOfBirth">
          <form:option value="1974">Trước 1975</form:option>
          <form:option value="1976">Sau 1975</form:option>
          <form:option value="2000">Gen Z 2k</form:option>
        </form:select>
      </div>
      <div style="width: 100%">
        <p>Giới tính</p>
        <form:select path="gender">
          <form:option value="Nam">Nam</form:option>
          <form:option value="Nữ">Nữ</form:option>
          <form:option value="Khác">Khác</form:option>
        </form:select>
      </div>
      <div style="width: 100%">
        <p>Quốc tịch</p>
        <form:select path="country">
          <form:option value="Việt Nam">Việt Nam</form:option>
          <form:option value="Nước ngoài">Nước ngoài</form:option>
          <form:option value="Ba que">Ba que</form:option>
        </form:select>
      </div>
    </div>
    <div style="width: 100%">
      <p>Số chứng minh nhân dân, số hộ chiếu hoặc giấy tờ thông hành khác </p>
      <form:input path="passportId"/>
    </div>
    <div style="width: 100%">
      <p>Thông tin đi lại</p>
      <form:radiobutton path="vehicles" value="Tàu bay"/>Tàu bay
      <form:radiobutton path="vehicles" value="Tàu thuyền"/>Tàu thuyền
      <form:radiobutton path="vehicles" value="Ô tô"/>Ô tô
      <form:radiobutton path="vehicles" value="Khác"/>Khác
    </div>
    <div style="display: flex;justify-content: space-evenly">
      <div style="width: 100%">
        <p>Số hiệu phương tiện</p>
        <form:input path="vehiclesPlate"/>
      </div>
      <div style="width: 100%">
        <p>Số ghế</p>
        <form:input path="seatNumber"/>
      </div>
    </div>
    <div style="display: flex;justify-content: space-evenly">
      <div style="width: 100%">
        <p>Ngày khởi hành</p>
        <input type="date" name="startDate">
      </div>
      <div style="width: 100%">
        <p>Ngày kết thúc</p>
        <input type="date" name="endDate">
      </div>
    </div>
    <div style="width: 100%">
      <p>Trong vòng 14 ngày qua, Anh/ chị có đi đến tỉnh thành phố nào không</p>
      <form:input path="description"/>
    </div>
  </form:form>
  </body>
</html>
