package com.example.jsp02.controller;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.entity.Board;
import com.example.jsp02.service.BoardService;
import java.util.Map;

public class BoardViewController implements Controller {
	
	BoardService boardService;
	
	public BoardViewController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public ModelView process(Map<String, String> paramMap) {
		String viewName = "view";
		
		int no = Integer.parseInt(paramMap.get("no"));
		String boardNo = "(" + no + ")";
		String visitedCookie = paramMap.get("visitedCookie");
		System.out.println("쿠키값 : " + visitedCookie);
		if (!visitedCookie.contains(boardNo)) {
			boardService.increaseHit(no);
		}
		
		Board board = boardService.viewContent(no);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("boardContent", board);
		
		return modelView;
	}
}
