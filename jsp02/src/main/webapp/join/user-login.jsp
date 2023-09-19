<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.jsp02.alert.ScriptWriter" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-19
  Time: 오전 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="layout/header.jsp" %>
<%
    ArrayList<Object> list = (ArrayList<Object>) request.getAttribute("loginCheck");
    boolean check = (boolean) list.get(0);
    String id = (String) list.get(1);
    String name = (String) list.get(2);

    if (check) {
        ScriptWriter.alertAndNext(response, "로그인성공!", "/join/info.jsp");
    } else {
        ScriptWriter.alertAndBack(response, "로그인 실패..");
    }
%>
<%@include file="layout/footer.jsp" %>
