<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="com.util.day02.cookie.CookieManagerV2" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-14
  Time: 오후 2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    /*Cookie[] cookies = request.getCookies();
if (cookies != null) {
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("loginId")) {
            loginId = cookie.getValue();
            ischeck = "checked";
        }
    }
}*/
    String loginId = CookieManagerV2.readCookie("loginId", request);
    if (loginId == null) {
        loginId = "";
    }
    String ischeck = loginId.isEmpty() ? "" : "checked";

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
      body {
        font-family: Arial, sans-serif;
      }

      div {
        max-width: 300px;
        margin: 0 auto;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
        background-color: #f9f9f9;
      }

      h2 {
        text-align: center;
      }

      form {
        text-align: left;
      }

      label {
        display: flex;
        align-items: center; /* 수직 정렬을 수행합니다. */
        margin-bottom: 10px;
      }

      input[type="text"],
      input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 3px;
      }

      input[type="checkbox"] {
        margin-left: 5px;
      }

      button {
        display: block;
        width: 100%;
        padding: 10px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 3px;
        cursor: pointer;
      }

      button:hover {
        background-color: #0056b3;
      }
    </style>
</head>
<body>
<div>
    <h2>Login</h2>
    <form action="login-process.jsp" method="post">
        <div>
            <label><span>ID</span><input type="text" name="userId" value="<%=loginId%>"></label>
        </div>
        <div>
            <label><input type="checkbox" <%=ischeck%> name="saveId" value="yes"> 아이디 저장</label>
        </div>
        <div>
            <label><span>PW</span><input type="password" name="userPw"></label>
        </div>
        <button>로그인</button>
    </form>
</div>
</body>
</html>


