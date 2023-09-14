package com.example.jsp01.day01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "hello", value = "/hello")
public class Hello extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public Hello() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("Hello Servlet");
		out.println("""
				<a href ="hi">hi</a>
				""");
		//"""사용시 JS에서 사용하는 백틱과 같이 코드블록기능함
	}
	//client 서버로 데이터 보내줄 때 <from action ="URI" method ="get or post"
	
}
