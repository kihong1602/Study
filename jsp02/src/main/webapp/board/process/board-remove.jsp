<%@ page import="com.example.jsp02.service.BoardService" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-21
  Time: 오후 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>
<form action="/board/progress/remove" method="post">
    <input type="hidden" name="no" value="<%=request.getParameter("no")%>">
    <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" class="form-control" name="password" id="password"
               placeholder="Password">
    </div>
    <div class="d-flex justify-content-center mt-5 mb-5">
        <button class="btn btn-primary">삭제</button>
    </div>
</form>
<%@include file="/layout/footer.jsp" %>
