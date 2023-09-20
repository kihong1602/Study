<%@ page import="com.example.jsp02.service.UserService" %>
<%@ page import="com.example.jsp02.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-20
  Time: 오전 11:35
  To change this template use File | Settings | File Templates.
--%>
<%
    UserService userService = new UserService();
    List<User> userList = new ArrayList<>();
    
    String[] paramArr = request.getParameterValues("check");
    for (String strNum : paramArr) {
        int no = Integer.parseInt(strNum);
        User user = userService.adminRemove(no);
        userList.add(user);
    }
    request.setAttribute("userList", userList);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/join/user/user-list");
    requestDispatcher.forward(request, response);
%>
