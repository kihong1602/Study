<%@ page import="java.util.Map" %>
<%@ page import="com.example.jsp02.entity.User" %><%--
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
    <title>user save</title>
</head>
<body>
<%
    User saveUser = (User) request.getAttribute("saveUser");
%>
<h2><%= saveUser.getNo()%>
</h2>
<h2><%= saveUser.getId()%>
</h2>
<h2><%= saveUser.getName()%>
</h2>
</body>
</html>
