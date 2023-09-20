<%@ page import="com.example.jsp02.service.UserService" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.google.gson.Gson" %>
<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-20
  Time: 오후 4:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setContentType("application/json; charset=utf-8");
    UserService userService = new UserService();
    int userNo = Integer.parseInt(request.getParameter("userNo"));

    int result = userService.adminDelete(userNo);
    Map<String, String> map = new HashMap<>();
    if (result > 0) {
        map.put("isDelete", "success");
    } else {
        map.put("isDelete", "fail");
    }

    Gson gson = new Gson();
    String json = gson.toJson(map);
    out.println(json);
%>