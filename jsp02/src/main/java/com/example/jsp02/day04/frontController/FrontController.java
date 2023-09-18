package com.example.jsp02.day04.frontController;

import com.example.jsp02.day04.View.ModelView;
import com.example.jsp02.day04.View.MyView;
import com.example.jsp02.day04.controller.Controller;
import com.example.jsp02.day04.controller.UserListController;
import com.example.jsp02.day04.controller.UserRemoveController;
import com.example.jsp02.day04.controller.UserSaveController;
import com.example.jsp02.day04.controller.UserSelectController;
import com.example.jsp02.day04.entity.User;
import com.example.jsp02.day04.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "front-controller", urlPatterns = "/day04/front-controller/user/*")
public class FrontController extends HttpServlet {
	
	private final Map<String, Controller> controllerMap = new HashMap<>();
	
	public FrontController() {
		controllerMap.put("/day04/front-controller/user/user-save",
				new UserSaveController(new UserService()));
		controllerMap.put("/day04/front-controller/user/user-select", new UserSelectController(new UserService()));
		controllerMap.put("/day04/front-controller/user/user-list", new UserListController(new UserService()));
		controllerMap.put("/day04/front-controller/user/user-remove", new UserRemoveController(new UserService()));
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
		return new MyView("/day04/" + viewName + ".jsp");
	}
	
	private HashMap<String, String> createParamMap(HttpServletRequest request) {
		HashMap<String, String> paramMap = new HashMap<>();
		request.getParameterNames().asIterator()
				.forEachRemaining(
						paramName -> paramMap.put(paramName, request.getParameter(paramName)));
		return paramMap;
	}
}
