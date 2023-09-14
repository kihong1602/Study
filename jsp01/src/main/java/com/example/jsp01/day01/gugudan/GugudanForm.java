package com.example.jsp01.day01.gugudan;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "gugudanForm", value = "/gugudanform")
public class GugudanForm extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("""
				<form action= "gugudan-result" method="get">
					<!--<input type="text" name ="dan">-->
					<label><input type="radio" name = "dan" value = "2"><span>2</span></label>
					<label><input type="radio" name = "dan" value = "3"><span>3</span></label>
					<label><input type="radio" name = "dan" value = "4"><span>4</span></label>
					<button>구구단 출력</button>
				</form>
				""");
		
		
	}
	
	
}
