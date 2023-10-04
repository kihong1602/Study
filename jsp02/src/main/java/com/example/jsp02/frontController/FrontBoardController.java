package com.example.jsp02.frontController;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.View.MyView;
import com.example.jsp02.controller.BoardModifiedController;
import com.example.jsp02.controller.BoardRemoveController;
import com.example.jsp02.controller.BoardSearchController;
import com.example.jsp02.controller.BoardViewController;
import com.example.jsp02.controller.BoardWriteController;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.service.BoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "front-boardController", urlPatterns = "/board/progress/*")
public class FrontBoardController extends HttpServlet {
	
	private final Map<String, Controller> controllerMap = new HashMap<>();
	
	public FrontBoardController() {
		controllerMap.put("/board/progress/write", new BoardWriteController(new BoardService()));
		controllerMap.put("/board/progress/view", new BoardViewController(new BoardService()));
		controllerMap.put("/board/progress/modify",
				new BoardModifiedController(new BoardService()));
		controllerMap.put("/board/progress/remove", new BoardRemoveController(new BoardService()));
		controllerMap.put("/board/progress/search", new BoardSearchController(new BoardService()));
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
		return new MyView("/board/" + viewName + ".jsp");
	}
	
	private HashMap<String, Object> createParamMap(HttpServletRequest request) {
		HashMap<String, Object> paramMap = new HashMap<>();
		
		request.getParameterNames().asIterator().forEachRemaining(
				paramName -> paramMap.put(paramName, request.getParameter(paramName)));
		
		return paramMap;
	}
}
