<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.google.gson.Gson" %>
<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-18
  Time: 오후 5:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setContentType("application/json; charset=UTF-8");
    String id = request.getParameter("userID");
    try {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3307/example",
                "blanc", "1234");
        String sql = "select count(*) as count from user where id = ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, id);

        ResultSet resultSet = ps.executeQuery();
        int result = 0;
        if (resultSet.next()) {
            result = resultSet.getInt("count");
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("count", result);
        Gson gson = new Gson();
        String json = gson.toJson(map);
        System.out.println("잘 도달했습니다.");
        System.out.println(json);
        out.println(json);
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
%>
