<%@ page import="com.example.jsp02.alert.ScriptWriter" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-10-06
  Time: 오후 12:52
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
    int result = Integer.parseInt(String.valueOf(request.getAttribute("result")));
    if (result > 0) {
        ScriptWriter.alertAndNext(response, "저장성공", "/reply/board");
    } else {
        ScriptWriter.alertAndBack(response, "알수없는 오류");
    }
%>
</body>
</html>
