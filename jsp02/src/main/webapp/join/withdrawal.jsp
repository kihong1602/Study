<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-19
  Time: 오후 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../layout/header.jsp" %>
<div class="form-signin w-100 m-auto">
    <form action="user/user-remove" method="post">
        <h1 class="h3 mb-3 fw-normal">회원 탈퇴</h1>
        <div class="form-floating">
            <input type="hidden" name="filePath" value="${sessionScope.filePath}">
            <input type="text" name="userID" class="form-control" id="userID"
                   placeholder="ID">
            <label for="userID">userID</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="userPW" name="userPW"
                   placeholder="Password">
            <label for="userPW">Password</label>
        </div>
        <button class="btn btn-primary w-100 py-2" type="submit">Sign in</button>
        <p class="mt-5 mb-3 text-body-secondary">© 2017–2023</p>
    </form>
</div>

<%@include file="../layout/footer.jsp" %>
