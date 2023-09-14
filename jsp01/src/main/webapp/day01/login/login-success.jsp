<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-13
  Time: 오후 3:46
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
    session = request.getSession();
    String userName = String.valueOf(session.getAttribute("userName"));
%>
<h1>안녕하세요. <%= userName%> 님!</h1>
</body>
</html>
