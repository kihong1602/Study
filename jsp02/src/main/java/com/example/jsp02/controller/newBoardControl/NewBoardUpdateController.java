package com.example.jsp02.controller.newBoardControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.dao.NewBoardDAO;
import com.example.jsp02.dto.NewBoardDTO;
import java.io.IOException;
import java.util.Map;

public class NewBoardUpdateController implements Controller {
	
	NewBoardDAO newBoardDAO;
	
	public NewBoardUpdateController(NewBoardDAO newBoardDAO) {
		this.newBoardDAO = newBoardDAO;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "go-to-board";
		
		int no = Integer.parseInt(String.valueOf(paramMap.get("no")));
		String title = (String) paramMap.get("title");
		String content = (String) paramMap.get("content");
		
		NewBoardDTO newBoardDTO = new NewBoardDTO();
		newBoardDTO.setNo(no);
		newBoardDTO.setTitle(title);
		newBoardDTO.setContent(content);
		int result = newBoardDAO.updateBoard(newBoardDTO);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("result", result);
		
		return modelView;
	}
}
