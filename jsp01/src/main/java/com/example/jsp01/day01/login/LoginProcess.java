package com.example.jsp01.day01.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login-process", value = "/login-process")
public class LoginProcess extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		
		String userId = request.getParameter("userId");
		String userPW = request.getParameter("userPw");
		
		if (userId.equals("kks4517") && userPW.equals("1234")) {
			out.println("""
						<script>
						alert('로그인 성공');
						</script>
					""");
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			//userId에 대한 값을 세션에 저장
			response.sendRedirect("login-success");
		} else {
			out.println("""
					<script>
					alert('로그인 실패');
					history.back();
					</script>
					""");
		}
	}
}
