package com.example.jsp02.controller.boardControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.entity.Board;
import com.example.jsp02.service.BoardService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class BoardListController implements Controller {
	
	BoardService boardService;
	
	public BoardListController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "board";
		
		int currentPage = (paramMap.get("page") != null) ? Integer.parseInt(
				String.valueOf(paramMap.get("page"))) : 1;
		int recodesPerPage = 10;
		int offset = (currentPage - 1) * recodesPerPage;
		System.out.println("currentPage : " + currentPage);
		System.out.println("offset : " + offset);
		int total = boardService.boardCount();
		int pagination = (int) Math.ceil((double) total / recodesPerPage);
		System.out.println("total : " + total);
		System.out.println("pagination: " + pagination);
		ArrayList<Board> boardList = boardService.paginationContent(offset, recodesPerPage);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("currentPage", currentPage);
		modelView.getModel().put("pagination", pagination);
		modelView.getModel().put("boardList", boardList);
		
		return modelView;
	}
}
