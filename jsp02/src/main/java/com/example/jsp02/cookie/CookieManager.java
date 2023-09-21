package com.example.jsp02.cookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieManager {
	
	
	public static void createCookie(String cookieName, String cookieValue, int aliveTime,
			HttpServletResponse response) {
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setPath("/");
		cookie.setMaxAge(aliveTime);
		response.addCookie(cookie);
		
	}
	
	public static void removeCookie(String cookieName, HttpServletResponse response) {
		createCookie(cookieName, "", 0, response);
	}
	
	
	public static String readCookie(String cookieName, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String cookieValue = "";
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(cookieName)) {
					cookieValue = cookie.getValue();
				}
			}
		}
		return cookieValue;
	}
}
