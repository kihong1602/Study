package com.util.day02.cookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieManagerV2 {
	
	public static Cookie createCookie(String cookieName, String cookieValue, int aliveTime) {
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setPath("/");
		cookie.setMaxAge(aliveTime);
		return cookie;
	}
	
	public static void removeCookie(Cookie cookie) {
		cookie.setMaxAge(0);
	}
	
	public static void sendCookie(Cookie cookie, HttpServletResponse response) {
		response.addCookie(cookie);
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
