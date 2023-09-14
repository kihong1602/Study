package com.example.jsp01.day01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "hi", value = "/hi")
public class Hi extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public Hi() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		PrintWriter out = response.getWriter();
		if (age < 18) {
			out.println("당신의 이름은 " + name + "입니다. 미성년자시네요");
		} else {
			out.println("당신의 이름은" + name + "입니다. 성인인증되었습니다.");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
