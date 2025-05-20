<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="<%=request.getContextPath()%>/views/home.jsp">Hello Servlet</a>

<a href="<%=request.getContextPath()%>/customer?action=GETALL">Danh sách khách hàng</a>
</body>
</html>