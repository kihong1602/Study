package com.example.jsp01.day01.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login-success", value = "/login-success")
public class LoginSuccess extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		String userId = String.valueOf(session.getAttribute("userId"));
		//session에 저장된 "userId"에 대한 값을 getAttribute()를 사용해 불러올 수 있다.
		out.println("""
				<h1> 로그인 성공!</h1>
				""");
		out.println("반갑습니다. " + userId + "님!");
	}
	
	
}
