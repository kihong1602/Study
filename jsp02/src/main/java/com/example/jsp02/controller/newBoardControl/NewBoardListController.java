package com.example.jsp02.controller.newBoardControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.dao.NewBoardDAO;
import com.example.jsp02.dto.NewBoardDTO;
import com.example.jsp02.dto.PageDTO;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class NewBoardListController implements Controller {
	
	NewBoardDAO newBoardDAO;
	
	public NewBoardListController(NewBoardDAO newBoardDAO) {
		this.newBoardDAO = newBoardDAO;
	}
	
	/*@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "board";
		
		List<NewBoardDTO> boardList = newBoardDAO.getAllPost();
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("boardList", boardList);
		
		return modelView;
	}*/
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "board";
		
		int currentPage = (paramMap.get("page") != null) ? Integer.parseInt(
				String.valueOf(paramMap.get("page"))) : 1;
		int recodesPerPage = 10;
		int offset = (currentPage - 1) * recodesPerPage;
		int total = newBoardDAO.getBoardCount();
		int pagination = (int) Math.ceil((double) total / recodesPerPage);
		
		System.out.println("currentPage : " + currentPage);
		System.out.println("offset : " + offset);
		System.out.println("total : " + total);
		System.out.println("pagination: " + pagination);
		
		PageDTO pageDTO = new PageDTO();
		pageDTO.setStart(offset);
		pageDTO.setEnd(recodesPerPage);
		List<NewBoardDTO> boardList = newBoardDAO.getPagingPost(pageDTO);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("boardList", boardList);
		modelView.getModel().put("currentPage", currentPage);
		modelView.getModel().put("pagination", pagination);
		
		return modelView;
	}
}
