package com.example.jsp02.controller.boardControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.entity.Board;
import com.example.jsp02.service.BoardService;
import java.util.Map;

public class BoardModifiedController implements Controller {
	
	BoardService boardService;
	
	
	public BoardModifiedController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) {
		String viewName = "process/modify-process";
		
		int no = Integer.parseInt(String.valueOf(paramMap.get("no")));
		String name = (String) paramMap.get("name");
		String title = (String) paramMap.get("title");
		String content = (String) paramMap.get("content");
		String password = (String) paramMap.get("password");
		
		Board board = new Board.Builder(password).no(no).name(name).title(title).content(content)
				.build();
		
		int result = boardService.modifiedContent(board);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("result", result);
		
		return modelView;
	}
}
