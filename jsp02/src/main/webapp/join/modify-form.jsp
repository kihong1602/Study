<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-19
  Time: 오후 2:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>

<div class="form-signin w-100 m-auto">
    <form action="user/user-modified" method="post">
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
        <div class="form-floating">
            <input type="text" name="userID" class="form-control" id="userID"
                   placeholder="ID" value="${sessionScope.loggedID}">
            <label for="userID">ID
            </label>
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

<%@include file="/layout/footer.jsp" %>