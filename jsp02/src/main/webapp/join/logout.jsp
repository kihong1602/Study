<%@ page import="com.example.jsp02.cookie.CookieManager" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-19
  Time: 오전 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/layout/header.jsp" %>
<%
    session.removeAttribute("loggedID");
    session.removeAttribute("loggedName");
    CookieManager.removeCookie("saveID", response);
    CookieManager.removeCookie("checkBox", response);
%>
<h2>로그아웃 완료</h2>
<%@include file="/WEB-INF/layout/footer.jsp" %>