<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="com.util.cookie.CookieManagerV1" %>
<%@ page import="com.util.cookie.CookieManagerV2" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-14
  Time: 오후 2:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    final int YEAR = 60 * 60 * 24 * 365;
    String userId = request.getParameter("userId");
    String userPw = request.getParameter("userPw");
    String saveId = request.getParameter("saveId");

    if (userId.equals("kks4517") && userPw.equals("1234")) {
        Cookie cookie = CookieManagerV2.createCookie("loginId", userId, YEAR);

        if (saveId != null && saveId.equals("yes")) {
            CookieManagerV2.sendCookie(cookie, response);
        } else {
            CookieManagerV2.removeCookie(cookie);
            CookieManagerV2.sendCookie(cookie, response);
        }

        out.println("<script> alert('로그인성공'); location.href = 'login-main.jsp'; </script>");
    } else {
        out.println("<script> alert('로그인실패'); history.back();</script>");
    }
%>


<%--<%
        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");
        String saveId = request.getParameter("saveId");

        final int YEAR = 60 * 60 * 24 * 365;
        if (userId.equals("kks4517") && userPw.equals("1234")) {

            Cookie cookie = CookieManagerV2.createCookie("loginId", userId, YEAR);

            if (saveId != null && saveId.equals("yes")) {
    //            Cookie saveIdCookie = new Cookie("loginId", userId);
    //            saveIdCookie.setPath("/");// "/"로 setPath 설정시 root에 쿠키를 저장한다.
    //            saveIdCookie.setMaxAge(60 * 60 * 24 * 365);
    //            response.addCookie(saveIdCookie);
    //            CookieManager.createCookie("loginId", userId, 60 * 60 * 24 * 365, response);

                CookieManagerV2.sendCookie(cookie, response);

            } else {
    //            Cookie saveIdCookie = new Cookie("loginId", userId);
    //            saveIdCookie.setPath("/");
    //            saveIdCookie.setMaxAge(0);
    //            response.addCookie(saveIdCookie);
    //            CookieManager.removeCookie("loginId", response);

                CookieManagerV2.deleteCookie(cookie);

            }
            out.println("<script> alert('로그인성공'); location.href = 'login-main.jsp'; </script>");
        } else {
            out.println("<script> alert('로그인실패'); history.back();</script>");
        }
%>--%>
