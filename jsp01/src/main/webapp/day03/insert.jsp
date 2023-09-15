<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-15
  Time: 오후 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="insert-process.jsp" method="post">
    <div>
        <label>
            <span>아이디</span>
            <input type="text" name="userId">
        </label>
    </div>
    <div>
        <label>
            <span>패스워드</span>
            <input type="password" name="userPw">
        </label>
    </div>
    <button>회원가입</button>
</form>
</body>
</html>
