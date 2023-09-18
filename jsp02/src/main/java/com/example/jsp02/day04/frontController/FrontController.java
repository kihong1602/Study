package com.example.jsp02.day04.frontController;

import com.example.jsp02.day04.View.ModelView;
import com.example.jsp02.day04.View.MyView;
import com.example.jsp02.day04.controller.Controller;
import com.example.jsp02.day04.controller.UserListController;
import com.example.jsp02.day04.controller.UserRemoveController;
import com.example.jsp02.day04.controller.UserSaveController;
import com.example.jsp02.day04.controller.UserSelectController;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrontController extends HttpServlet {
	
	private Map<String, Controller> controllerMap;
	
	public FrontController() {
		controllerMap.put("/front-controller/user/user-save", new UserSaveController());
		controllerMap.put("/front-controller/user/user-select", new UserSelectController());
		controllerMap.put("/front-controller/user/user-list", new UserListController());
		controllerMap.put("/front-controller/user/user-remove", new UserRemoveController());
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
		HashMap<String, String> paramMap = createParamMap(request);
		ModelView modelView = controller.process(paramMap);
		String viewName = modelView.getViewName();
		
		MyView myView = viewResolver(viewName);
		myView.render(modelView.getModel(), request, response);
		
	}
	
	private MyView viewResolver(String viewName) {
		return new MyView("/day04/"+viewName+".jsp");
	}
	
	private HashMap<String, String> createParamMap(HttpServletRequest request) {
		HashMap<String, String> paramMap = new HashMap<>();
		request.getParameterNames().asIterator()
				.forEachRemaining(
						paramName -> paramMap.put(paramName, request.getParameter(paramName)));
		return paramMap;
	}
}
