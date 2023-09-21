<%@ page import="com.example.jsp02.service.UserService" %>
<%@ page import="com.example.jsp02.entity.Board" %>
<%@ page import="com.example.jsp02.service.BoardService" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-21
  Time: 오전 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String title = request.getParameter("title");
    String name = request.getParameter("name");
    String content = request.getParameter("content");
    String password = request.getParameter("password");

    BoardService boardService = new BoardService();
    Board createCon = new Board.Builder(password).name(name).
    title(title).content(content).build();

    boardService.insertContent(createCon);

%>
