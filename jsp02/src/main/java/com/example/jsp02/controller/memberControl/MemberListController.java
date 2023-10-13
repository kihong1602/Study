package com.example.jsp02.controller.memberControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.dao.UserDAO;
import com.example.jsp02.dto.UserDTO;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MemberListController implements Controller {
	
	UserDAO userDAO;
	
	public MemberListController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "list";
		
		List<UserDTO> userList = userDAO.getUserList();
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("userList", userList);
		
		return modelView;
	}
}
