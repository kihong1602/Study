<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-14
  Time: 오전 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Third Page</h1>

<%
    out.println(request.getAttribute("name"));
    out.println("<br>");
    out.println(session.getAttribute("name"));
    out.println("<br>");
    out.println(application.getAttribute("name"));
%>
</body>
</html>
