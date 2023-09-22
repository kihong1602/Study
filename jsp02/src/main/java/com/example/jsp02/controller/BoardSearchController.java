package com.example.jsp02.controller;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.entity.Board;
import com.example.jsp02.service.BoardService;
import java.util.ArrayList;
import java.util.Map;

public class BoardSearchController implements Controller {
	
	BoardService boardService;
	
	public BoardSearchController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public ModelView process(Map<String, String> paramMap) {
		String viewName = "process/search-process";
		String category = paramMap.get("search");
		String searchWord = paramMap.get("searchWord");
		ArrayList<Board> resultBoard = null;
		if (category.equals("title")) {
			resultBoard = boardService.searchToTitle(searchWord);
		} else if (category.equals("name")) {
			resultBoard = boardService.searchToName(searchWord);
		} else if (category.equals("content")) {
			resultBoard = boardService.searchToContent(searchWord);
		} else if (category.equals("all")) {
			resultBoard = boardService.searchAll(searchWord);
		}
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("resultBoard", resultBoard);
		
		return modelView;
	}
}
