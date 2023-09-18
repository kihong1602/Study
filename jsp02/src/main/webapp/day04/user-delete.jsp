<%@ page import="com.example.jsp02.day04.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-18
  Time: 오전 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%
    User user = (User)request.getAttribute("removeUser");
%>
<h2>Delete Complete <%=user.getId()%></h2>
</body>
</html>
