<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-13
  Time: 오후 2:36
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
    String name = "blanc";
    int age = 20;
%>
<h1>hello jsp</h1>
<h2>Name is <%= name%>
</h2>
<h2>Age is <%= age%>
</h2>
<a href="hi.jsp?name=judas&age=27">hi</a>
</body>
</html>
