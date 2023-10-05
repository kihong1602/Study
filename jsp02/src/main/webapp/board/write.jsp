<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-21
  Time: 오전 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>
<div class="container">
    <div class="row d-flex justify-content-center">
        <div class="col-8">
            <h2>게시판</h2>
            <form action="progress/write" method="post">
                <input type="hidden" name="id" value="${sessionScope.loggedID}">
                <div class="mb-3">
                    <label for="title" class="form-label">Title</label>
                    <input type="text" class="form-control" name="title" id="title"
                           placeholder="제목 입력">
                </div>
                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" class="form-control" name="name" id="name" placeholder="이름"
                           value="${sessionScope.loggedName}">
                </div>
                <div class="mb-3">
                    <label for="text-content" class="form-label">Text Content</label>
                    <textarea class="form-control" name="content" id="text-content"
                              rows="8"></textarea>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" name="password" id="password"
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
<%--<script src="../js/ckeditor.js"></script>--%>
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