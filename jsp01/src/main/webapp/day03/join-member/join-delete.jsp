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
<% Member deleteMember = (Member) request.getAttribute("deleteMember");
    String id = deleteMember.getId();
%>
<h1>member-delete</h1>
<hr>
<h2>Delete Complete <%= id%>
</h2>
</body>
</html>
