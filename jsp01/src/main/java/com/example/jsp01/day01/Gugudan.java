package com.example.jsp01.day01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "gugudan", value = "/gugudan")
//WebServlet 어노테이션 사용 시 Web.xml 에 매핑안해줘도 된다.
public class Gugudan extends HttpServlet {
	
	private String message;
	
	public void init() {
		message = "Hello Gugudan";
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		// Hello
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>" + message + "</h1>");
		out.println("</body></html>");
	}
}
