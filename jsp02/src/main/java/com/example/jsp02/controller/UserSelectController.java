package com.example.jsp02.controller;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.entity.User;
import com.example.jsp02.service.UserService;
import java.util.Map;

public class UserSelectController implements Controller {
	
	UserService userService;
	
	public UserSelectController(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public ModelView process(Map<String, String> paramMap) {
		String viewName = "user-select";
		
		String id = paramMap.get("userID");
		
		User user = new User.UserBuilder(id).build();
		User selectUser = userService.selectUser(user);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("selectUser", selectUser);
		
		return modelView;
	}
}