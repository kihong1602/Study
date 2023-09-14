<%@ page import="jakarta.servlet.http.Cookie" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-14
  Time: 오전 10:30
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
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            out.println(cookie.getName() + " : " + cookie.getValue());
            out.println("<br>");
        }
    } else {
        out.println("<h1>쿠키 없음</h1>");
    }
%>
</body>
</html>
