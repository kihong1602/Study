package com.example.jsp01.day03.controller;

import com.example.jsp01.day03.member.MemberService;
import com.example.jsp01.day03.view.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "FrontController", urlPatterns = "/day03/front-controller/*")
public class FrontController extends HttpServlet {
	
	private final Map<String, Controller> controllerMap = new HashMap<>();
	
	public FrontController() {
		controllerMap.put("/day03/front-controller/join-save", new MemberInsertController(new MemberService()));
		controllerMap.put("/day03/front-controller/join-select", new MemberSelectController(new MemberService()));
		controllerMap.put("/day03/front-controller/join-delete", new MemberDeleteController(new MemberService()));
		controllerMap.put("/day03/front-controller/member-list", new MemberListController(new MemberService()));
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		Controller controller = controllerMap.get(requestURI);
		
		if (controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		MyView myView = controller.process(request, response);
		
		myView.render(request, response);
	}
}
