package com.example.jsp01.favorite;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "favorite-form", value = "/favorite-form")
public class Favorite extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("""
				<form action= "favorite-result" method ="get">
				<p>관심항목을 체크해 주세요.</p>
				<label><input type="checkbox" name = "item" value ="정치"><span>정치</span></label>
				<label><input type="checkbox" name = "item" value ="시사"><span>시사</span></label>
				<label><input type="checkbox" name = "item" value ="영화"><span>영화</span></label>
				<label><input type="checkbox" name = "item" value ="스포츠"><span>스포츠</span></label>
				<label><input type="checkbox" name = "item" value ="IT"><span>IT</span></label>
				<button>확인</button>
				</form>
				""");
	}
	
	
}
