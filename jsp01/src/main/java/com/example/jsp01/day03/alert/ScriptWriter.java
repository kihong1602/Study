package com.example.jsp01.day03.alert;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ScriptWriter {
	
	public static void alert(HttpServletResponse response, String msg) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert(" + msg + ");");
		out.println("</script>");
	}
	
	public static void alertAndNext(HttpServletResponse response, String msg, String url)
			throws IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert(" + msg + ");");
		out.println("location.href=" + url + ";");
		out.println("</script>");
	}
	
	public static void alertAndBack(HttpServletResponse response, String msg) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert(" + msg + ");");
		out.println("history.back()");
		out.println("</script>");
	}
}
	

