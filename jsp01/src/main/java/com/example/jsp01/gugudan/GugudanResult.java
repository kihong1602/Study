package com.example.jsp01.gugudan;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "gugudan-result", value = "/gugudan-result")
public class GugudanResult extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		int gugudanNumber = Integer.parseInt(request.getParameter("dan"));
		out.println(gugudanNumber + "단 출력합니다.");
		out.println("<ul>");
		String result = "";
		for (int i = 1; i < 10; i++) {
			out.println("<li>" + gugudanNumber + " x " + i + " = " + (gugudanNumber * i) + "</li>");
		}
		out.println("</ul>");
	}
	
	
}
