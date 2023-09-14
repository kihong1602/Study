package com.example.jsp01.day01.favorite;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "favorite-result", value = "/favorite-result")
public class FavoriteResult extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String[] favorites = request.getParameterValues("item");
		if (favorites == null) {
			out.println("관심항목을 선택하지 않았습니다.");
		} else {
			for (String result : favorites) {
				out.println("당신의 관심항목은 " + result + " 입니다.<br>");
			}
		}
		
	}
	
	
}
