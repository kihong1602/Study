package com.example.jsp02.controller.newBoardControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.dao.NewBoardDAO;
import com.example.jsp02.dto.NewBoardDTO;
import java.io.IOException;
import java.util.Map;

public class NewBoardViewController implements Controller {
	
	NewBoardDAO newBoardDAO;
	
	public NewBoardViewController(NewBoardDAO newBoardDAO) {
		this.newBoardDAO = newBoardDAO;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "view";
		
		int no = Integer.parseInt(String.valueOf(paramMap.get("no")));
		NewBoardDTO newBoardDTO = newBoardDAO.getPost(no);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("board", newBoardDTO);
		
		return modelView;
	}
}
