<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-13
  Time: 오후 3:40
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
    String id = request.getParameter("userId");
    String password = request.getParameter("userPw");
    String userName = request.getParameter("userName");

    if (id.equals("kks4517") && password.equals("1234")) {
        out.println(" < script > alert('로그인성공!'); </script > ");
        response.sendRedirect("login-success.jsp");
        session = request.getSession();
        session.setAttribute("userName", userName);
    } else {
        out.println(" <script> alert('로그인실패..');history.back(); </script> ");
    }
%>
</body>
</html>
