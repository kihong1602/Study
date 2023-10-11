package com.example.jsp02.controller.newBoardControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.dao.NewBoardDAO;
import com.example.jsp02.dto.NewBoardDTO;
import java.io.IOException;
import java.util.Map;

public class NewBoardReplyWriteController implements Controller {
	
	NewBoardDAO newBoardDAO;
	
	public NewBoardReplyWriteController(NewBoardDAO newBoardDAO) {
		this.newBoardDAO = newBoardDAO;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "go-to-board";
		
		String id = (String) paramMap.get("id");
		String name = (String) paramMap.get("name");
		String title = (String) paramMap.get("title");
		String content = (String) paramMap.get("content");
		int reGroup = Integer.parseInt(String.valueOf(paramMap.get("reGroup")));
		int reLevel = Integer.parseInt(String.valueOf(paramMap.get("reLevel")));
		int reStep = Integer.parseInt(String.valueOf(paramMap.get("reStep")));
		
		NewBoardDTO newBoardDTO = new NewBoardDTO();
		newBoardDTO.setId(id);
		newBoardDTO.setName(name);
		newBoardDTO.setTitle(title);
		newBoardDTO.setContent(content);
		newBoardDTO.setReGroup(reGroup);
		newBoardDTO.setReLevel(reLevel);
		newBoardDTO.setReStep(reStep);
		
		newBoardDAO.updateReLevel(newBoardDTO);
		newBoardDTO.setReLevel(reLevel + 1);
		newBoardDTO.setReStep(reStep + 1);
		
		int result = newBoardDAO.writeReply(newBoardDTO);
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("result", result);
		
		return modelView;
	}
}
