package com.example.jsp02.frontController;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.View.MyView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.controller.userControl.IdCheckController;
import com.example.jsp02.controller.userControl.UserInfoModifiedController;
import com.example.jsp02.controller.userControl.UserInfoUpdateController;
import com.example.jsp02.controller.userControl.UserListController;
import com.example.jsp02.controller.userControl.UserListSearchController;
import com.example.jsp02.controller.userControl.UserLoginController;
import com.example.jsp02.controller.userControl.UserRemoveController;
import com.example.jsp02.controller.userControl.UserSaveController;
import com.example.jsp02.controller.userControl.UserSelectController;
import com.example.jsp02.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "front-controller", urlPatterns = "/join/user/*")
public class FrontUserController extends HttpServlet {
	
	private final Map<String, Controller> controllerMap = new HashMap<>();
	
	public FrontUserController() {
		controllerMap.put("/join/user/user-save",
				new UserSaveController(new UserService()));
		controllerMap.put("/join/user/user-select",
				new UserSelectController(new UserService()));
		controllerMap.put("/join/user/user-list",
				new UserListController(new UserService()));
		controllerMap.put("/join/user/user-remove",
				new UserRemoveController(new UserService()));
		controllerMap.put("/join/user/id-check",
				new IdCheckController(new UserService()));
		controllerMap.put("/join/user/user-login",
				new UserLoginController(new UserService()));
		controllerMap.put("/join/user/user-modified",
				new UserInfoModifiedController(new UserService()));
		controllerMap.put("/join/user/user-update",
				new UserInfoUpdateController(new UserService()));
		controllerMap.put("/join/user/user-search",
				new UserListSearchController(new UserService()));
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
		HashMap<String, Object> paramMap = createParamMap(request);
		ModelView modelView = controller.process(paramMap);
		String viewName = modelView.getViewName();
		
		MyView myView = viewResolver(viewName);
		myView.render(modelView.getModel(), request, response);
		
	}
	
	private MyView viewResolver(String viewName) {
		return new MyView("/join/process/" + viewName + ".jsp");
	}
	
	private HashMap<String, Object> createParamMap(HttpServletRequest request)
			throws ServletException, IOException {
		HashMap<String, Object> paramMap = new HashMap<>();
		request.getParameterNames().asIterator()
				.forEachRemaining(
						paramName -> paramMap.put(paramName, request.getParameter(paramName)));
		
		if (request.getContentType() != null) {
			if (request.getContentType().startsWith("multipart/")) {
				Part part = request.getPart("profile");
//			String realUploadPath = getServletContext().getRealPath("C:\\upload");
				String realUploadPath = "C:\\upload";
				paramMap.put("uploadPath", realUploadPath);
				paramMap.put("profile", part);
			}
		}
		return paramMap;
	}
}
