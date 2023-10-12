<%@ page import="com.example.jsp02.alert.ScriptWriter" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-10-11
  Time: 오전 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>
<%--<%
    int result = (int) request.getAttribute("result");
    if (result > 0) {
        ScriptWriter.alertAndNext(response, "글저장완료", "/new/list");
    } else {
        ScriptWriter.alertAndBack(response, "저장실패");
    }
%>--%>
<%@include file="/layout/footer.jsp" %>