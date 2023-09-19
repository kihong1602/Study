<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.jsp02.alert.ScriptWriter" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-19
  Time: 오전 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>
<%
    HashMap<String, Object> loginMap = (HashMap<String, Object>) request.getAttribute("loginCheck");
    boolean check = (boolean) loginMap.get("check");
    String id = (String) loginMap.get("userID");
    String name = (String) loginMap.get("userName");

    session.setAttribute("loggedID", id);
    session.setAttribute("loggedName", name);

    if (check) {
        ScriptWriter.alertAndNext(response, "로그인성공!", "/join/user/user-select?userID=" + id);
    } else {
        ScriptWriter.alertAndBack(response, "로그인 실패..");
    }
%>
<%@include file="/layout/footer.jsp" %>
