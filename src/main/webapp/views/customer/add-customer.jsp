<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 5/20/2025
  Time: 9:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm mới khách hàng</h1>
<form action="<%=request.getContextPath()%>/customer" method="post" enctype="multipart/form-data">
    <div>
        <label for="name">Nhập name:</label>
        <input type="text" name="name" id="name">
    </div>
    <div>
        <label for="avatar">Nhập  avatar:</label>
        <input type="file" name="avatar" id="avatar">
    </div>
    <div>
        <label for="phone">Nhập Phone:</label>
        <input type="text" name="phone" id="phone">
    </div>
    <div>
        <label for="email">Nhập Email:</label>
        <input type="text" name="email" id="email">
    </div>
    <div>
        <label for="address">Nhập Address:</label>
        <input type="text" name="address" id="address">
    </div>
    <input type="submit" value="ADD" name="action">
</form>
</body>
</html>
