<%@ page import="jakarta.servlet.http.Cookie" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-14
  Time: 오전 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>쿠키 설정</h1>
<%
    Cookie cookie = new Cookie("myCookie", "포스틱");
    //Cookie는 Key,Value로 저장된다.
    cookie.setPath(request.getContextPath());
    cookie.setMaxAge(60 * 60);
    //setMaxAge() -> 쿠키 유지시간 (sec)
    response.addCookie(cookie);
    out.println(request.getContextPath());
%>
</body>
</html>
