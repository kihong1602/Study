<%@ page import="com.example.jsp02.service.UserService" %>
<%@ page import="com.example.jsp02.entity.Board" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.jsp02.service.BoardService" %>
<%@ page import="com.example.jsp02.cookie.CookieManager" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-19
  Time: 오전 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>
<div class="container">
    <div class="row d-flex justify-content-center">
        <div class="col-8">
            <h2>글 목록</h2>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">no</th>
                    <th scope="col">Title</th>
                    <th scope="col">Name</th>
                    <th scope="col">Date</th>
                    <th scope="col">Hit</th>
                </tr>
                </thead>
                <%
                    BoardService boardService = new BoardService();
                    ArrayList<Board> boardList = (ArrayList<Board>) boardService.scanAllContent();
                    for (Board board : boardList) {
                %>
                <tbody class="table-group-divider">
                <tr>
                    <th scope="row"><%=board.getNo()%>
                    </th>
                    <td><a href="javascript:listView('<%=board.getNo()%>')"><%=board.getTitle()%>
                    </a>
                    </td>
                    <td><%=board.getName()%>
                    </td>
                    <td><%=board.getRegDate()%>
                    </td>
                    <td><%=board.getHit()%>
                    </td>
                </tr>
                </tbody>
                <%}%>
            </table>
            <form action="/board/progress/search" method="post">
                <select name="search">
                    <option value="all">전체</option>
                    <option value="title">제목</option>
                    <option value="name">글쓴이</option>
                    <option value="content">내용</option>
                </select>
                <input type="text" name="searchWord">
                <button>검색</button>
            </form>
        </div>
    </div>
</div>
<script>
  function getCookie(name) {
    const cookies = document.cookie.split(';');
    for (const cookie of cookies) {
      const trimCookie = cookie.trim();
      //trim 해주지 않으면 cookieName을 조회하지 못함..
      const [cookieName, cookieValue] = trimCookie.split('=');
      if (cookieName === name) {

        return decodeURIComponent(cookieValue);
      }
    }
    return null;
  }

  function listView(boardNo) {
    let form = document.createElement('form');

    const cookieValue = getCookie('visitedCookie');
    console.log(getCookie('visitedCookie'));
    console.log(cookieValue);
    let visited;
    visited = document.createElement('input');
    visited.setAttribute('type', 'hidden');
    visited.setAttribute('name', 'visitedCookie');
    visited.setAttribute('value', cookieValue);

    let obj;
    obj = document.createElement('input');
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('name', 'no');
    obj.setAttribute('value', boardNo);

    form.appendChild(obj);
    form.appendChild(visited);
    form.setAttribute('method', 'post');
    form.setAttribute('action', 'progress/view');
    document.body.appendChild(form);
    form.submit();
  }
</script>
<%@include file="/layout/footer.jsp" %>
