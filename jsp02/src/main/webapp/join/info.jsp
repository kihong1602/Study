<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-19
  Time: 오전 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../layout/header.jsp" %>
<div class="form-signin w-100 m-auto">
    <form action="user/user-select" method="post">
        <div class="form-floating">
            <input type="text" name="userID" class="form-control" id="userID"
                   placeholder="ID">
            <label for="userID">userID</label>
        </div>
        <button class="btn btn-primary w-100 py-2" type="submit">Sign in</button>
    </form>
</div>
<<%@include file="../layout/footer.jsp" %>
