package com.example.jsp02.frontController;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.View.MyView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.controller.memberControl.GoToLoginController;
import com.example.jsp02.controller.memberControl.GoToSignController;
import com.example.jsp02.controller.memberControl.GotoWithdrawalController;
import com.example.jsp02.controller.memberControl.IdCheckController;
import com.example.jsp02.controller.memberControl.MemberInfoController;
import com.example.jsp02.controller.memberControl.MemberListController;
import com.example.jsp02.controller.memberControl.MemberLoginController;
import com.example.jsp02.controller.memberControl.MemberLogoutController;
import com.example.jsp02.controller.memberControl.MemberSignController;
import com.example.jsp02.controller.memberControl.MemberWithdrawalController;
import com.example.jsp02.dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "FrontMemberController", urlPatterns = "/new-member/*")
public class FrontMemberController extends HttpServlet {
	
	private final Map<String, Controller> controllerMap = new HashMap<>();
	
	public FrontMemberController() {
		controllerMap.put("/new-member/login-process", new GoToLoginController());
		controllerMap.put("/new-member/login", new MemberLoginController(new UserDAO()));
		controllerMap.put("/new-member/sign-process", new GoToSignController());
		controllerMap.put("/new-member/sign", new MemberSignController(new UserDAO()));
		controllerMap.put("/new-member/id-check", new IdCheckController(new UserDAO()));
		controllerMap.put("/new-member/logout", new MemberLogoutController());
		controllerMap.put("/new-member/withdrawal-process", new GotoWithdrawalController());
		controllerMap.put("/new-member/withdrawal", new MemberWithdrawalController(new UserDAO()));
		controllerMap.put("/new-member/list", new MemberListController(new UserDAO()));
		controllerMap.put("/new-member/info", new MemberInfoController(new UserDAO()));
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
		return new MyView("/member/" + viewName + ".jsp");
	}
	
	private HashMap<String, Object> createParamMap(HttpServletRequest request)
			throws ServletException, IOException {
		HashMap<String, Object> paramMap = new HashMap<>();
		request.getParameterNames().asIterator()
				.forEachRemaining(
						paramName -> paramMap.put(paramName, request.getParameter(paramName)));
		paramMap.put("session", request.getSession());
		if (request.getContentType() != null) {
			if (request.getContentType().startsWith("multipart/")) {
				
				Part part = request.getPart("profile");
				String realUploadPath = "C:\\upload";
				
				paramMap.put("uploadPath", realUploadPath);
				paramMap.put("profile", part);
			}
		}
		return paramMap;
	}
}
