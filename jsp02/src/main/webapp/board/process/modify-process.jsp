<%@ page import="com.example.jsp02.alert.ScriptWriter" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-21
  Time: 오후 3:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>
<%
    int result = (int) request.getAttribute("result");

    if (result > 0) {
        ScriptWriter.alertAndNext(response, "수정완료", "/board/progress/board");
    }
%>

<%@include file="/layout/footer.jsp" %>
