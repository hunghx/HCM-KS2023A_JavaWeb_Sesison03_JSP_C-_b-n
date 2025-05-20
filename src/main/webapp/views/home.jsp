<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 5/20/2025
  Time: 8:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Declaration --%>
<%!
    // Khai báo biên, phương thức ở cấp độ class
    private int a = 10;
    String username = "Nguyen Van A";
    public String upperCase(String str) {
        return str.toUpperCase();
    }

%>
<%-- Scriptlet --%>
<%
    // logic java
    for (int i = 0; i < 5 ; i++) {
        response.getWriter().println("<div>Vòng lặp thứ "+i+"</div>");
    }
    request.setAttribute("username", username);
%>
<%-- Expression --%>
<%="Bieu thuc  can tinh toan"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="layout/header.jsp">
    <jsp:param name="username" value="<%=username%>"/>
</jsp:include>
<h1>Tên : <%=upperCase(username)%> và Tuổi : <%=a%> </h1>
</body>
</html>
