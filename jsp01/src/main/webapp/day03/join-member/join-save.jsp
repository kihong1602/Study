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
<h3>id : <%= id%>
</h3>
<h3>name : <%= name%>
</h3>
<h3>email : <%= email%>
</h3>
</body>
</html>