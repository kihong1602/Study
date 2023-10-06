<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-10-06
  Time: 오전 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>
<div class="container">
    <h2 class="mb-5 mt-5">Write</h2>
    <form action="<c:url value="/reply/reply-write"/>" method="POST">
        <input type="hidden" name="id" value="${sessionScope.loggedID}">
        <input type="hidden" name="name" value="${sessionScope.loggedName}">
        <input type="hidden" name="reGroup" value="${requestScope.regroup}">
        <input type="hidden" name="reLevel" value="${requestScope.relevel}">
        <input type="hidden" name="reStep" value="${requestScope.restep}">
        <%
            String reGroup = (String) request.getAttribute("regroup");
            String reLevel = (String) request.getAttribute("relevel");
            String reStep = (String) request.getAttribute("restep");
            System.out.println(reGroup + " | " + reLevel + " | " + reStep);

        %>
        <div class="form-floating mb-3">
            <input type="text" name="title" class="form-control" id="title" placeholder="title">
            <label for="title">title</label>
        </div>

        <div class="form-floating">
        <textarea name="content" class="form-control" placeholder="Leave a comment here"
                  id="content"
                  style="height: 400px"></textarea>
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
