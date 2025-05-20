<%@ page import="java.util.List" %>
<%@ page import="ra.jsp.model.Customer" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 5/20/2025
  Time: 9:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách khách hàng</h1>
<a href="<%=request.getContextPath()%>/customer?action=NEW">+ Thêm mới khách hàng</a>
<table border="10" cellpadding="10" cellspacing="10">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Avatar</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th colspan="2">Action</th>
        </tr>
    </thead>
    <tbody>
   <%
       List<Customer> customers = (List<Customer>) request.getAttribute("customers");
    for (Customer cus : customers){
   %>
   <tr>
       <td><%=cus.getId()%></td>
       <td><%=cus.getName()%></td>
       <td><img src="<%=cus.getAvatar()%>" alt="" width="100" height="100" style="object-fit: cover"></td>
       <td><%=cus.getPhone()%></td>
       <td><%=cus.getEmail()%></td>
       <td><%=cus.getAddress()%></td>
       <td><a href="<%=request.getContextPath()%>/customer?action=EDIT&id=<%=cus.getId()%>">Sửa</a></td>
       <td><a onclick="return confirm('Bạn co chắc chắn muốn xóa không ?')" href="<%=request.getContextPath()%>/customer?action=DELETE&id=<%=cus.getId()%>">Xóa</a></td>
   </tr>
   <%
       };
   %>
    </tbody>
</table>
</body>
</html>
