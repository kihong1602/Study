<%@ page import="com.example.jsp01.day03.member.Member" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-15
  Time: 오후 6:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>member-list</h1>
<%
    ArrayList<Member> memberList = (ArrayList<Member>) request.getAttribute("memberList");
    for (Member member : memberList) {
        String id = member.getId();
        String pw = member.getPw();
        String name = member.getName();
        String email = member.getEmail();
        out.println("<h3>");
        out.println(id + " | " + pw + " | " + name + " | " + email);
        out.println("</h3>");
    }
%>
</body>
</html>
