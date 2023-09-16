<%@ page import="com.example.jsp01.day03.member.Member" %>

<%--
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
<h1>join-membership!</h1>
<%
    Member member = (Member) request.getAttribute("saveMember");
    String id = member.getId();
    String name = member.getName();
    String email = member.getEmail();
%>
<hr>
<h2>Save Complete</h2>
<h3>ID || NAME || EMAIL</h3>
<h3>-------------------</h3>
<h3><%= id%> || <%= name%> || <%= email%>
</h3>
</body>
</html>
