<%@ page import="com.example.jsp02.alert.ScriptWriter" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-21
  Time: 오후 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    int result = (int) request.getAttribute("result");

    if (result > 0) {
        ScriptWriter.alertAndNext(response, "삭제가 완료되었습니다.", "/board/progress/board");
    } else {
        ScriptWriter.alertAndBack(response, "비밀번호를 확인해주세요");
    }
%>