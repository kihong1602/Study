package com.example.jsp02.controller;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.entity.User;
import com.example.jsp02.service.UserService;
import java.util.Map;

public class UserInfoModifiedController implements Controller {
	
	UserService userService;
	
	public UserInfoModifiedController(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) {
		String viewName = "user-modified";
		String id = (String) paramMap.get("userID");
		String pw = (String) paramMap.get("userPW");
		
		User user = new User.UserBuilder(id).password(pw).build();
		User userCheck = userService.checkUser(user);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("userCheck", userCheck);
		
		return modelView;
	}
}
