<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-10-11
  Time: 오전 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>
<div class="container">
    <h2 class="mb-5 mt-5">Write</h2>
    <form action="<c:url value="/new/save"/>" method="POST">
        <input type="hidden" name="id" value="${sessionScope.loggedID}">
        <input type="hidden" name="name" value="${sessionScope.loggedName}">
        <div class="form-floating mb-3">
            <input type="text" name="title" class="form-control" id="title" placeholder="title">
            <label for="title">title</label>
        </div>
        <div class="form-floating">
        <textarea name="content" class="form-control" placeholder="Leave a comment here"
                  id="content" style="height: 400px"></textarea>
            <label for="content">content</label>
        </div>
        <div class="mb-5 mt-5 d-flex justify-content-center">
            <button type="submit" class="btn btn-success">Submit</button>
            <button type="button" class="btn btn-danger mx-2" id="btn-cancel">Danger</button>
        </div>
    </form>
</div>
<script>
  let cancelBtn = document.getElementById('btn-cancel');
  cancelBtn.addEventListener("click", function () {
    history.back();
  })
</script>
<%@include file="/layout/footer.jsp" %>
