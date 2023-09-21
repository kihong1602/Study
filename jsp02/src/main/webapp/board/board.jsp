<%@ page import="com.example.jsp02.service.UserService" %>
<%@ page import="com.example.jsp02.entity.Board" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.jsp02.service.BoardService" %><%--
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
        </div>
    </div>
</div>
<script>
  function listView(boardNo) {
    let form = document.createElement('form');

    let obj;
    obj = document.createElement('input');
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('name', 'no');
    obj.setAttribute('value', boardNo);

    form.appendChild(obj);
    form.setAttribute('method', 'post');
    form.setAttribute('action', 'progress/view');
    document.body.appendChild(form);
    form.submit();
  }
</script>
<%@include file="/layout/footer.jsp" %>
