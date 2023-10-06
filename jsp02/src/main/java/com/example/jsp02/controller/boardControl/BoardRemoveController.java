package com.example.jsp02.controller.boardControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.service.BoardService;
import java.util.Map;

public class BoardRemoveController implements Controller {
	
	BoardService boardService;
	
	public BoardRemoveController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) {
		String viewName = "process/remove-process";
		
		int no = Integer.parseInt(String.valueOf(paramMap.get("no")));
		String password = (String) paramMap.get("password");
		
		int result = boardService.removeContent(no, password);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("result", result);
		
		return modelView;
	}
}
