package com.example.jsp02.frontController;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.View.MyView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.controller.replyBoardControl.ReplyBoardGoToReplController;
import com.example.jsp02.controller.replyBoardControl.ReplyBoardListController;
import com.example.jsp02.controller.replyBoardControl.ReplyBoardReplController;
import com.example.jsp02.controller.replyBoardControl.ReplyBoardViewController;
import com.example.jsp02.controller.replyBoardControl.ReplyBoardWriteController;
import com.example.jsp02.service.ReplyBoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "front-replyBoardController", urlPatterns = "/reply/*")
public class FrontReplyBoardController extends HttpServlet {
	
	private final Map<String, Controller> controllerMap = new HashMap<>();
	
	public FrontReplyBoardController() {
		controllerMap.put("/reply/write", new ReplyBoardWriteController(new ReplyBoardService()));
		controllerMap.put("/reply/board", new ReplyBoardListController(new ReplyBoardService()));
		controllerMap.put("/reply/view", new ReplyBoardViewController(new ReplyBoardService()));
		controllerMap.put("/reply/reply-process", new ReplyBoardGoToReplController());
		controllerMap.put("/reply/reply-write",
				new ReplyBoardReplController(new ReplyBoardService()));
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
		if (viewName.equals("redirect")) {
			return new MyView("/reply/board");
		}
		return new MyView("/reply-board/" + viewName + ".jsp");
	}
	
	private HashMap<String, Object> createParamMap(HttpServletRequest request)
			throws ServletException, IOException {
		HashMap<String, Object> paramMap = new HashMap<>();
		
		request.getParameterNames().asIterator().forEachRemaining(
				paramName -> paramMap.put(paramName, request.getParameter(paramName)));
		System.out.println("request.getContentType : " + request.getContentType());
		if (request.getContentType() != null) {
			if (request.getContentType().startsWith("multipart/")) {
				Part part = request.getPart("upload");
				String realUploadPath = "c:\\upload";
				paramMap.put("uploadPath", realUploadPath);
				paramMap.put("part", part);
				
			}
		}
		return paramMap;
	}
}
