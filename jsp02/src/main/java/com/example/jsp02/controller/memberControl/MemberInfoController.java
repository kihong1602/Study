package com.example.jsp02.controller.memberControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.dao.UserDAO;
import com.example.jsp02.dto.UserDTO;
import com.example.jsp02.entity.User;
import java.io.IOException;
import java.util.Map;

public class MemberInfoController implements Controller {
	
	UserDAO userDAO;
	
	public MemberInfoController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "info";
		
		String id = (String) paramMap.get("id");
		UserDTO userDTO = userDAO.getUserInfo(new User.Builder().id(id).build());
		
		ModelView modelView = new ModelView(viewName);
		
		if (userDTO != null) {
			modelView.getModel().put("user", userDTO);
		}
		
		return modelView;
	}
}
