<%@ page import="com.example.jsp02.entity.Board" %>
<%@ page import="com.example.jsp02.service.BoardService" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-21
  Time: 오후 3:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>
<%
    int no = Integer.parseInt(request.getParameter("no"));
    BoardService boardService = new BoardService();
    Board board = boardService.viewContent(no);
%>
<div class="container">
    <div class="row d-flex justify-content-center">
        <div class="col-8">
            <h2>게시판</h2>
            <form action="/board/progress/modify" method="post">
                <input type="hidden" name="no" value="<%=no%>">
                <input type="hidden" name="id" value="${sessionScope.loggedID}">
                <div class="mb-3">
                    <label for="title" class="form-label">Title</label>
                    <input type="text" class="form-control" name="title" id="title"
                           value="<%=board.getTitle()%>"
                           placeholder="제목 입력">
                </div>
                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" class="form-control" name="name" id="name" placeholder="이름"
                           value="${sessionScope.loggedName}" readonly>
                </div>
                <div class="mb-3">
                    <label for="text-content" class="form-label">Text Content</label>
                    <textarea class="form-control" name="content" id="text-content"
                              rows="8"><%=board.getContent()%></textarea>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" name="password" id="password"
                           value="<%=board.getPassword()%>"
                           placeholder="Password">
                </div>
                <div class="d-flex justify-content-center mt-5 mb-5">
                    <button class="btn btn-primary">등록</button>
                    <button class="btn btn-primary">취소</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.ckeditor.com/ckeditor5/39.0.2/classic/ckeditor.js"></script>
<script>
  ClassicEditor
  .create(document.querySelector('#text-content'), {
    ckfinder: {
      uploadUrl: '/board/progress/upload'
    }
  })
  .catch(error => {
    console.error(error);
  });
</script>
<%@include file="/layout/footer.jsp" %>
