<%@ page import="com.example.jsp02.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-18
  Time: 오전 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/layout/header.jsp" %>
<%
    User user = (User) request.getAttribute("removeUser");
%>
<hr>
<h2>Delete Complete <%=user.getId()%>
</h2>
<hr>
<%@include file="/layout/footer.jsp" %>
