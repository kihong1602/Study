<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="com.util.cookie.CookieManagerV2" %>
<%@ page import="com.util.cookie.CookieManagerV1" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-14
  Time: 오전 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    final int DAY = 60 * 60 * 24;
    String today = request.getParameter("today");
    if (today != null && today.equals("1")) {
        Cookie cookie = CookieManagerV2.createCookie("popupClose", "off", DAY);
        CookieManagerV2.sendCookie(cookie, response);
    }
%>


<%--<%
            String today = request.getParameter("today");
            System.out.println("today=====" + today);

            if (today != null && today.equals("1")) {
        //        Cookie cookie = new Cookie("popupClose", "off");
        //        cookie.setPath(request.getContextPath());
        //        cookie.setMaxAge(60 * 60 * 24);
        //        response.addCookie(cookie);

                Cookie cookie = CookieManagerV2.createCookie("popupClose", "off", 60 * 60 * 24);
                CookieManagerV2.sendCookie(cookie, response);
            }
%>--%>
