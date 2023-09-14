<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-13
  Time: 오후 3:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="login-process.jsp" method="post">
    <input type="text" name="userId">
    <input type="password" name="userPw">
    <input type="hidden" name="userName" value="김기홍">
    <button>Login</button>
</form>
</body>
</html>
