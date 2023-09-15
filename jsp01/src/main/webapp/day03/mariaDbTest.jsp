<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-15
  Time: 오전 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>MariaDB 연결테스트</h1>
<%
    String url = "jdbc:mariadb://localhost:3307/example";
    String id = "blanc";
    String pw = "1234";

    try {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, id, pw);
    } catch (Exception e) {
        out.println("연결오류입니다." + e.getMessage());
        e.printStackTrace();
    }
%>
</body>
</html>
