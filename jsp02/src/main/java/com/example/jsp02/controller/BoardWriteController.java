package com.example.jsp02.controller;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.entity.Board;
import com.example.jsp02.service.BoardService;
import java.util.Map;

public class BoardWriteController implements Controller {
	
	BoardService boardService;
	
	public BoardWriteController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public ModelView process(Map<String, String> paramMap) {
		String viewName = "board";
		
		String id = paramMap.get("id");
		String name = paramMap.get("name");
		String title = paramMap.get("title");
		String content = paramMap.get("content");
		String password = paramMap.get("password");
		
		Board board = new Board.Builder(password).id(id).name(name).title(title).content(content)
				.build();
		boardService.insertContent(board);
		
		ModelView modelView = new ModelView(viewName);
		
		return modelView;
	}
}
