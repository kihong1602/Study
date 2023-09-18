package com.example.jsp02.day04.controller;

import com.example.jsp02.day04.entity.User;
import com.example.jsp02.day04.service.UserService;
import com.example.jsp02.day04.view.ModelView;
import java.util.List;
import java.util.Map;

public class UserListController implements Controller {
	
	UserService userService;
	
	public UserListController(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public ModelView process(Map<String, String> paramMap) {
		String viewName = "user-list";
		
		List<User> userList = userService.userList();
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("userList", userList);
		
		return modelView;
	}
}
