package com.example.jsp02.controller;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.entity.User;
import com.example.jsp02.service.UserService;
import java.util.ArrayList;
import java.util.Map;

public class UserListController implements Controller {
	
	UserService userService;
	
	public UserListController(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) {
		String viewName = "user-list";
		
		ArrayList<User> userList = userService.userList();
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("userList", userList);
		
		return modelView;
	}
}
