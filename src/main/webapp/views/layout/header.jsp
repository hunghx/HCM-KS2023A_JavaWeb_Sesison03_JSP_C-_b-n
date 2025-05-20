<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 5/20/2025
  Time: 8:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Đây là Header</h1>
<p>Chào mừng bạn <%=request.getParameter("username")%> quay lại trang web</p>
<p>Chào mừng bạn ${username} quay lại trang web</p>
</body>
</html>
