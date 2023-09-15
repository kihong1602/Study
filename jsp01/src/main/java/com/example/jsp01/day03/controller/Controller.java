package com.example.jsp01.day03.controller;

import com.example.jsp01.day03.view.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller {
	
	MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
