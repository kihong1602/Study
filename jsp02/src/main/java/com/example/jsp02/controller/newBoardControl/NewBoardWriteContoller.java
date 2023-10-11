package com.example.jsp02.controller.newBoardControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.dao.NewBoardDAO;
import com.example.jsp02.dto.NewBoardDTO;
import java.io.IOException;
import java.util.Map;

public class NewBoardWriteContoller implements Controller {
	
	NewBoardDAO newBoardDAO;
	
	public NewBoardWriteContoller(NewBoardDAO newBoardDAO) {
		this.newBoardDAO = newBoardDAO;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "go-to-board";
		
		String id = (String) paramMap.get("id");
		String name = (String) paramMap.get("name");
		String title = (String) paramMap.get("title");
		String content = (String) paramMap.get("content");
		int reGroup = newBoardDAO.getMaxRegroup();
		
		NewBoardDTO newBoardDTO = new NewBoardDTO();
		newBoardDTO.setId(id);
		newBoardDTO.setName(name);
		newBoardDTO.setTitle(title);
		newBoardDTO.setContent(content);
		newBoardDTO.setReGroup(reGroup + 1);
		
		int result = newBoardDAO.writeBoard(newBoardDTO);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("result", result);
		
		return modelView;
	}
}
