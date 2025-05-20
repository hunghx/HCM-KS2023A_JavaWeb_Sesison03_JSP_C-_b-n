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
<h1>Cập nhật thông tin khách hàng</h1>
<form action="<%=request.getContextPath()%>/customer" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${customer.id}">
    <div>
        <label for="name">Nhập name:</label>
        <input type="text" name="name" id="name" value="${customer.name}" required>
    </div>
    <div>
        <label for="avatar">Nhập  avatar:</label>
        <img src="${customer.avatar}" alt="" width="150" height="150" style="object-fit: cover">
        <input type="file" name="avatar" id="avatar" v>
    </div>
    <div>
        <label for="phone">Nhập Phone:</label>
        <input type="text" name="phone" id="phone" value="${customer.phone}" required>
    </div>
    <div>
        <label for="email">Nhập Email:</label>
        <input type="text" name="email" id="email" value="${customer.email}" required>
    </div>
    <div>
        <label for="address">Nhập Address:</label>
        <input type="text" name="address" id="address" value="${customer.address}" required>
    </div>
    <input type="submit" value="UPDATE" name="action">
</form>
</body>
</html>
