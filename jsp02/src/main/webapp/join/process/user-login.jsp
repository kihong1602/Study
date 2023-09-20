<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.jsp02.alert.ScriptWriter" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.jsp02.cookie.CookieManager" %><%--
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
    String saveID = (String) loginMap.get("saveID");

    session.setAttribute("loggedID", id);
    session.setAttribute("loggedName", name);

    if (check) {
        ScriptWriter.alertAndNext(response, "로그인성공!", "/join/user/user-select?userID=" + id);
        Cookie connectID = CookieManager.createCookie("saveID", id, 60 * 60 * 24 * 365);
        Cookie checkBox = CookieManager.createCookie("checkBox", saveID, 60 * 60 * 24 * 365);
        if (saveID != null) {
            if (saveID.equals("rememberMe")) {
                System.out.println("쿠키보내용");
                CookieManager.sendCookie(connectID, response);
                CookieManager.sendCookie(checkBox, response);
            }
        } else {
            System.out.println("쿠키지워용");
            CookieManager.removeCookie(connectID);
            CookieManager.removeCookie(checkBox);
			//쿠키 지울시 ,sendCookie로 쿠키전송을 따로 구현했으므로
            // removeCookie로 setMaxAge를 0으로 만들어준 후 sendCookie를 해줘야한다.
            CookieManager.sendCookie(connectID, response);
            CookieManager.sendCookie(checkBox, response);
        }
    } else {
        ScriptWriter.alertAndBack(response, "로그인 실패..");
    }
%>
<%@include file="/layout/footer.jsp" %>
