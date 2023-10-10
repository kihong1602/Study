package com.example.jsp02.controller.newBoardControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.dao.NewBoardDAO;
import com.example.jsp02.dto.NewBoardDTO;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class NewBoardListController implements Controller {
	
	NewBoardDAO newBoardDAO;
	
	public NewBoardListController(NewBoardDAO newBoardDAO) {
		this.newBoardDAO = newBoardDAO;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "board";
		
		List<NewBoardDTO> boardList = newBoardDAO.getAllPost();
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("boardList", boardList);
		
		return modelView;
	}
}
