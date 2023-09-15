<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-15
  Time: 오전 11:16
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
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String id = "blanc";
    String pw = "1234";
    try {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection connection = DriverManager.getConnection(url, id, pw);
        out.println("<h2>연결완료</h2>");
    } catch (Exception e) {
        out.println("<h2>연결실패  </h2>");
        e.printStackTrace();
    }
%>
</body>
</html>
