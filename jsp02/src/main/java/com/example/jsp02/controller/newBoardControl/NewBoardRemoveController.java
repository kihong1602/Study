package com.example.jsp02.controller.newBoardControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.dao.NewBoardDAO;
import java.io.IOException;
import java.util.Map;

public class NewBoardRemoveController implements Controller {
	
	NewBoardDAO newBoardDAO;
	
	public NewBoardRemoveController(NewBoardDAO newBoardDAO) {
		this.newBoardDAO = newBoardDAO;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "go-to-board";
		int no = Integer.parseInt(String.valueOf(paramMap.get("no")));
		
		int result = newBoardDAO.deleteBoard(no);
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("result", result);
		if (result > 0) {
			modelView.getModel().put("state", "show");
			modelView.getModel().put("topMsg","삭제 결과");
			modelView.getModel().put("bodyMsg","삭제가 완료되었어요!");
		}
		
		return modelView;
	}
}
