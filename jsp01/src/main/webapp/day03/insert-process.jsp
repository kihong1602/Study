<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-15
  Time: 오후 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    String userID = request.getParameter("userId");
    String userPW = request.getParameter("userPw");
    // db 집어넣기

    String driver = "org.mariadb.jdbc.Driver";
    Class.forName(driver);

    String url = "jdbc:mariadb://localhost:3307/example";
    String id = "blanc";
    String pw = "1234";
    Connection conn = DriverManager.getConnection(url, id, pw);
    PreparedStatement pstmt = null;
    String sql = "insert into test values(?,?)";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, userID);
    pstmt.setString(2, userPW);
    int result = pstmt.executeUpdate();
    if (result > 0) {
        out.println("회원가입이 되었습니다.");
    } else {
        out.println("회원가입이 잘못되었습니다.");
    }
%>