<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-13
  Time: 오후 4:04
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
    String userId = String.valueOf(session.getAttribute("userId"));
    String userName = String.valueOf(session.getAttribute("userName"));
    String userPw = String.valueOf(session.getAttribute("userPw"));
%>
<h1>회원가입이 완료되었습니다.</h1>
<h2><%=userName%>님, 우리 회원이 되신것을 축하합니다!</h2>
<h3>앞으로 많은 활동 부탁드립니다. <%=userId%>님!</h3>
</body>
</html>
