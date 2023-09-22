<%@ page import="com.example.jsp02.service.UserService" %>
<%@ page import="com.example.jsp02.entity.User" %>
<%@ page import="com.example.jsp02.entity.Board" %>
<%@ page import="com.example.jsp02.service.BoardService" %>
<%@ page import="com.example.jsp02.cookie.CookieManager" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-21
  Time: 오전 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>
<%
    Board board = (Board) request.getAttribute("boardContent");
    String boardNo = "(" + board.getNo() + ")";
    String visitedCookieValue = CookieManager.readCookie("visitedCookie", request);
    if (visitedCookieValue.isEmpty()) {
        CookieManager.createCookie("visitedCookie", boardNo, 60 * 60 * 24,
                response);
    } else {
//        System.out.println("조회수 중복증가는 불가능해용");
        if (visitedCookieValue.contains(boardNo)) {
        } else {
            CookieManager.removeCookie("visitedCookie", response);
            CookieManager.createCookie("visitedCookie",
                    visitedCookieValue + "/" + boardNo, 60 * 60 * 24,
                    response);
        }
    }
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
                    <td colspan="3">${requestScope.boardContent.title}
                    </td>
                </tr>
                <tr>
                    <th>글쓴이</th>
                    <td colspan="3">${requestScope.boardContent.name}
                    </td>
                </tr>
                <tr>
                    <th>날짜</th>
                    <td>${requestScope.boardContent.regDate}
                    </td>
                    <th>조회수</th>
                    <td>${requestScope.boardContent.hit}
                    </td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3" class="content">${requestScope.boardContent.content}
                    </td>
                </tr>

                </tbody>

            </table>
            <div class="d-flex justify-content-center mt-5">
                <a href="board.jsp" class="btn btn-primary">목록</a>
                <a href="write.jsp" class="btn btn-primary mx-1">글쓰기</a>
                <%
                    if (loggedID.equals(board.getId())) { %>
                <a href="javascript:modify('${requestScope.boardContent.no}')"
                   class="btn btn-danger mx-1">수정하기</a>
                <a href="javascript:remove('${requestScope.boardContent.no}')"
                   class="btn btn-danger mx-1">지우기</a>
                <%}%>
            </div>
        </div>
    </div>
</div>
<script>
  function modify(userNo) {
    let form = document.createElement('form');

    let obj;
    obj = document.createElement('input');
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('name', 'no');
    obj.setAttribute('value', userNo);

    form.appendChild(obj);
    form.setAttribute('action', '/board/process/board-modify.jsp');
    form.setAttribute('method', 'post');
    document.body.appendChild(form);
    form.submit();
  }

  function remove(userNo) {
    let form = document.createElement('form');

    let obj;
    obj = document.createElement('input');
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('name', 'no');
    obj.setAttribute('value', userNo);

    form.appendChild(obj);
    form.setAttribute('action', '/board/process/board-remove.jsp');
    form.setAttribute('method', 'post');
    document.body.appendChild(form);
    form.submit();
  }
</script>
<%@include file="/layout/footer.jsp" %>