<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-15
  Time: 오후 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    //1. driver찾기...
    String driver = "org.mariadb.jdbc.Driver";
    Class.forName(driver);
    
    String url = "jdbc:mariadb://localhost:3307/example";
    String id = "blanc";
    String pw = "1234";

    Connection conn = DriverManager.getConnection(url, id, pw);
    System.out.println("db연결 성공");
    // 쿼리쓰고 결과값 받아오기....
    // 1. 쿼리문 처리 메서드
    // 2. 결과값 받아오기  select 를 제외하고 나머지는 정수
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "select * from test";
    pstmt = conn.prepareStatement(sql);
    rs = pstmt.executeQuery();
	/*
	if(rs.next()) {
		System.out.println(rs.getString("id"));
		System.out.println(rs.getString("password"));
	}
	if(rs.next()) {
		System.out.println(rs.getString("id"));
		System.out.println(rs.getString("password"));
	}
	if(rs.next()) {
		System.out.println(rs.getString("id"));
		System.out.println(rs.getString("password"));
	}
	*/


%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>id</th>
        <th>password</th>

    </tr>
    </thead>
    <tbody>
    <%
        while (rs.next()) {
            out.println("<tr>");
            out.println("<td>" + rs.getString("id") + "</td>");
            out.println("<td>" + rs.getString("password") + "</td>");
            out.println("</tr>");
        }
    %>
    </tbody>
</table>
</body>
</html>