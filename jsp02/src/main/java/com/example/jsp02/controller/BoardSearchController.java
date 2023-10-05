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
	public ModelView process(Map<String, Object> paramMap) {
		String viewName = "process/search-process";
		String category = (String) paramMap.get("search");
		String searchWord = (String) paramMap.get("searchWord");
		int currentPage = (paramMap.get("page") != null) ? Integer.parseInt(
				String.valueOf(paramMap.get("page"))) : 1;
		int recodesPerPage = 10;
		int offset = (currentPage - 1) * recodesPerPage;
		System.out.println("currentPage : " + currentPage);
		System.out.println("offset : " + offset);
		int total = 0;
		ArrayList<Board> resultBoard = null;
		switch (category) {
			case "title":
				resultBoard = boardService.searchToTitle(searchWord, offset, recodesPerPage);
				total = boardService.countSearchToTitle(searchWord);
				break;
			case "name":
				resultBoard = boardService.searchToName(searchWord, offset, recodesPerPage);
				total = boardService.countSearchToName(searchWord);
				break;
			case "content":
				resultBoard = boardService.searchToContent(searchWord, offset, recodesPerPage);
				total = boardService.countSearchToContent(searchWord);
				break;
			case "all":
				resultBoard = boardService.searchAll(searchWord, offset, recodesPerPage);
				total = boardService.countSearchAll(searchWord);
				break;
		}
		
		int pagination = (int) Math.ceil((double) total / recodesPerPage);
		System.out.println("total : " + total);
		System.out.println("pagination: " + pagination);
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("resultBoard", resultBoard);
		modelView.getModel().put("currentPage", currentPage);
		modelView.getModel().put("pagination", pagination);
		modelView.getModel().put("category", category);
		modelView.getModel().put("searchWord", searchWord);
		
		return modelView;
	}
}
