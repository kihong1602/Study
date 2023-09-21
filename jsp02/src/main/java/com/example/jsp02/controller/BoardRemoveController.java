package com.example.jsp02.controller;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.service.BoardService;
import java.util.Map;

public class BoardRemoveController implements Controller {
	
	BoardService boardService;
	
	public BoardRemoveController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public ModelView process(Map<String, String> paramMap) {
		String viewName = "process/remove-process";
		
		int no = Integer.parseInt(paramMap.get("no"));
		String password = paramMap.get("password");
		
		int result = boardService.removeContent(no, password);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("result", result);
		
		return modelView;
	}
}
