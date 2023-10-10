<%@ page import="com.example.jsp02.alert.ScriptWriter" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-10-10
  Time: 오전 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int result = (int) request.getAttribute("result");
    if (result > 0) {
        ScriptWriter.alertAndNext(response, "삭제완료", "/reply/board");
    } else {
        ScriptWriter.alertAndBack(response, "삭제실패");
    }
%>
