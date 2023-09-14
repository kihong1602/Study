package com.example.jsp01.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login-form", value = "/login-form")
public class LoginForm extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		
		out.println("""
					<form action="login-process" method = "post">
						<input type ="text" name="userId">
						<input type ="password" name="userPw">
						<button>로그인</button>
					</form>
				""");
	}
}
