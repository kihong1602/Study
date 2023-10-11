package com.example.jsp02.controller.newBoardControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.dao.NewBoardDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class NewBoardAllRemoveController implements Controller {
	
	NewBoardDAO newBoardDAO;
	
	public NewBoardAllRemoveController(NewBoardDAO newBoardDAO) {
		this.newBoardDAO = newBoardDAO;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "go-to-board";
		ArrayList<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(25);
		list.add(28);
		int result = newBoardDAO.deleteAllBoard(list);
		if (result > list.size()) {
			System.out.println("삭제완료");
		} else {
			System.out.println("삭제실패");
		}
		ModelView modelView = new ModelView(viewName);
		
		return modelView;
	}
}
