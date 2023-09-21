package com.example.jsp02.controller;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.entity.Board;
import com.example.jsp02.service.BoardService;
import java.util.Map;

public class BoardModifiedController implements Controller {
	
	BoardService boardService;
	
	
	public BoardModifiedController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public ModelView process(Map<String, String> paramMap) {
		String viewName = "process/modify-process";
		
		int no = Integer.parseInt(paramMap.get("no"));
		String name = paramMap.get("name");
		String title = paramMap.get("title");
		String content = paramMap.get("content");
		String password = paramMap.get("password");
		
		Board board = new Board.Builder(password).no(no).name(name).title(title).content(content)
				.build();
		
		int result = boardService.modifiedContent(board);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("result", result);
		
		return modelView;
	}
}
