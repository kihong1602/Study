<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %><%--
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
    response.setContentType("text/html;charset:UTF-8");
    List<String[]> userSave = new ArrayList<>();
    Map<String, List<String[]>> userList = new HashMap<>();
    String userId = request.getParameter("userId");
    String userPw = request.getParameter("userPw");
    String userName = request.getParameter("userName");
    String userAdd = request.getParameter("userAddress");
    String userZip = request.getParameter("userZipcode");
    String userEmail = request.getParameter("userEmail");
    String userTel = request.getParameter("userTel");
    String userBirth = request.getParameter("userBirth");
    userSave.add(new String[]{userId, userPw, userName, userAdd, userZip, userEmail, userTel,
            userBirth});
    userList.put(userId, userSave);
    session.setAttribute("userId", userId);
    session.setAttribute("userPw", userPw);
    session.setAttribute("userName", userName);
    response.sendRedirect("join-success.jsp");
%>
</body>
</html>
