<%@ page import="com.example.jsp02.service.UserService" %>
<%@ page import="com.example.jsp02.entity.User" %>
<%@ page import="com.example.jsp02.entity.Board" %>
<%@ page import="com.example.jsp02.service.BoardService" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-21
  Time: 오전 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>
<%
    BoardService boardService = new BoardService();
    int no = Integer.parseInt(request.getParameter("no"));
    boardService.increaseHit(no);
    Board board = boardService.viewContent(no);
%>
<div class="container">
    <div class="row d-flex justify-content-center">
        <div class="col-10">
            <h2>글보기</h2>
            <table class="table">
                <colgroup>
                    <col style="width: 15%">
                    <col style="width: 35%">
                    <col style="width: 15%">
                    <col style="width: 35%">
                </colgroup>
                <tbody>
                <tr>
                    <th>제목</th>
                    <td colspan="3"><%=board.getTitle()%>
                    </td>
                </tr>
                <tr>
                    <th>글쓴이</th>
                    <td colspan="3"><%=board.getName()%>
                    </td>
                </tr>
                <tr>
                    <th>날짜</th>
                    <td><%=board.getRegDate()%>
                    </td>
                    <th>조회수</th>
                    <td><%=board.getHit()%>
                    </td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3" class="content"><%=board.getContent()%>
                    </td>
                </tr>

                </tbody>

            </table>
            <div class="d-flex justify-content-center mt-5">
                <a href="board.jsp" class="btn btn-primary">목록</a>
                <a href="write.jsp" class="btn btn-primary mx-1">글쓰기</a>
                <a href="process/board-remove.jsp?no=<%=board.getNo()%>"
                   class="btn btn-danger mx-1">지우기</a>
            </div>
        </div>
    </div>
</div>
<%@include file="/layout/footer.jsp" %>