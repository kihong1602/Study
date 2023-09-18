<%@ page import="com.example.jsp02.day04.entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-18
  Time: 오전 9:09
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
        List<User> userList = (List<User>) request.getAttribute("userList");
		for(User user : userList){
			out.println(user.toString()+"<br>");

        }
    %>
</body>
</html>
