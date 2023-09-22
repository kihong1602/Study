<%@ page import="com.example.jsp02.entity.Board" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.jsp02.service.BoardService" %>
<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-19
  Time: 오전 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
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

                    int currentPage = (request.getParameter("page") != null) ? Integer.parseInt(
                            request.getParameter("page")) : 1;
                    int recodesPerPage = 10;//한번에 보여질 page의 수
                    int offset = (currentPage - 1) * recodesPerPage;
                    int total = boardService.boardCount();
                    int pagination = (int) Math.ceil(
                            (double) total / recodesPerPage);//pagination 개수
                    ArrayList<Board> boardList = boardService.paginationContent(offset,
                            recodesPerPage);
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
            <nav aria-label="Page navigation">
                <%
                    int currentGroup = (currentPage - 1) / 5;
                    int startPage = currentGroup * 5 + 1;
                    int endPage = Math.min(startPage + 4, pagination);

                %>
                <ul class="pagination">
                    <%if (currentGroup > 0) {%>
                    <li class="page-item"><a class="page-link"
                                             href="?page=<%=startPage-5%>"
                                             aria-label="Previous"> <span
                            aria-hidden="true">&laquo;</span>
                    </a></li>
                    <%
                        }
                        for (int i = startPage; i <= endPage; i++) {
                            if (i == currentPage) { %>
                    <li class="page-item"><a class="page-link active"
                                             href="?page=<%=i%>"><%=i %>
                    </a></li>
                    <%} else { %>
                    <li class="page-item"><a class="page-link"
                                             href="?page=<%=i%>"><%=i %>
                    </a></li>
                    <%
                            }
                        }
                        if (endPage < pagination) {
                    %>
                    <li class="page-item"><a class="page-link"
                                             href="?page=<%=endPage+1%>"
                                             aria-label="Next"> <span
                            aria-hidden="true">&raquo;</span>
                    </a></li>
                    <%}%>
                </ul>
            </nav>
            <form action="<c:url value="/board/progress/search"/>" method="post">
                <label>
                    <select name="search">
                        <option value="all">전체</option>
                        <option value="title">제목</option>
                        <option value="name">글쓴이</option>
                        <option value="content">내용</option>
                    </select>
                </label>
                <label>
                    <input type="text" name="searchWord">
                </label>
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
