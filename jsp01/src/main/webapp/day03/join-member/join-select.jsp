<%@ page import="com.example.jsp01.day03.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-15
  Time: 오후 4:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<% Member member = (Member) request.getAttribute("selectMember");
    String id = member.getId();
    String pw = member.getPw();
%>
<h1>Find-Password</h1>
<hr>
<h2>Password Find Complete</h2>
<h3>ID || PASSWORD</h3>
<h3>--------------</h3>
<h3><%= id%> || <%= pw%>
</h3>
</body>
</html>
