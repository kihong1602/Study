package com.example.jsp02.controller;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.entity.User;
import com.example.jsp02.service.UserService;
import java.util.Map;

public class UserRemoveController implements Controller {
	
	UserService userService;
	
	public UserRemoveController(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public ModelView process(Map<String, String> paramMap) {
		String viewName = "user-delete";
		
		String id = paramMap.get("userID");
		String password = paramMap.get("userPW");
		
		User user = new User.UserBuilder(id).password(password).build();
		User removeUser = userService.removeUser(user);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("removeUser", removeUser);
		
		return modelView;
	}
}
